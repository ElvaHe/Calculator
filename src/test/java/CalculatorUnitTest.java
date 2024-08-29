import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class CalculatorUnitTest {
    private  Calculator calculator;

    @BeforeEach
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        double result = calculator.calculate(Operation.ADD, 2, 3);
        Assertions.assertEquals(5, result, 0);
    }

    @Test
    public void testSubtraction() {
        double result = calculator.calculate(Operation.SUBTRACT, 5, 2);
        Assertions.assertEquals(3, result, 0);
    }

    @Test
    public void testMultiplication() {
        double result = calculator.calculate(Operation.MULTIPLY, 2, 3);
        Assertions.assertEquals(6, result, 0);
    }

    @Test
    public void testDivision() {
        double result = calculator.calculate(Operation.DIVIDE, 6, 2);
        Assertions.assertEquals(3, result, 0);
    }

    @Test
    public void testChainingCalculation() {
        double result = calculator.chainCalculator(calculator.chainCalculator(5, Operation.ADD, 3), Operation.MULTIPLY, 2);
        Assertions.assertEquals(16, result, 0);
    }

    @Test
    public void testExtendOperation() {
        calculator.extendOperation(Operation.valueOf("POWER"), (a, b) -> Math.pow(a, b));
        double result = calculator.calculate(Operation.valueOf("POWER"), 2, 3);
        Assertions.assertEquals(8, result, 0);
    }
    @Test
    public void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 6, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.valueOf("MODULO"), 5, 2);
        });
    }
}
