import java.util.*;
import java.util.function.BiFunction;
public class Calculator {
    private final Map<Operation, BiFunction<Double, Double, Double>> operationBiFunctionMap = new HashMap<>();
    public Calculator() {
        operationBiFunctionMap.put(Operation.ADD, (a, b) -> a + b);
        operationBiFunctionMap.put(Operation.SUBTRACT, (a, b) -> a - b);
        operationBiFunctionMap.put(Operation.MULTIPLY, (a, b) -> a * b);
        operationBiFunctionMap.put(Operation.DIVIDE, (a, b) -> {
            if(b == 0) {
                throw new ArithmeticException("Cannot divided by zero.");
            }
            return a / b;
        });
    }
    public Calculator extendOperation(Operation op, BiFunction<Double, Double, Double> function) {
        operationBiFunctionMap.put(op, function);
        return this;
    }
    public double calculate(Operation op, Number num1, Number num2){
        try {
            if (!operationBiFunctionMap.containsKey(op)) {
                throw new IllegalArgumentException("Operation not supported: " + op);
            }
            BiFunction<Double, Double, Double> function = operationBiFunctionMap.get(op);
            return function.apply(num1.doubleValue(), num2.doubleValue());
        } catch (IllegalArgumentException exception) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
    }
    public double chainCalculator(double initialValue, Operation op, Number num) {
        return calculate(op, initialValue, num);
    }
}
