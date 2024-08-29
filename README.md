# Flexible Calculator

This repository contains the implementation of a flexible calculator in Java, adhering to good software engineering practices such as the Open-Closed Principle and IoC compatibility.

## Features

- **Basic Operations**: Supports basic arithmetic operations like addition, subtraction, multiplication, and division.
- **Extensible**: New operations can be added without modifying existing code.
- **Chaining**: Allows chaining of multiple operations in a single calculation.
- **Error Handling**: Handles invalid operations gracefully.
- **IoC Compatibility**: Designed to be easily integrated into an IoC environment.

## How to Run

1. Clone the repository.
2. Compile the Java files using a Java compiler.
3. Run the `CalculatorUnitTest` class to execute the unit tests.

## Assumptions

- It is assumed that the enum `Operation` can be modified to add new operations.
- The calculator operates on `Number` types, with results returned as `double`.

## Design Decisions

- **Open-Closed Principle**: The `Calculator` class is closed for modification but open for extension, allowing new operations to be added without modifying the existing code.
- **IoC Compatibility**: The design allows for external management of dependencies, making it easy to inject new operations or configurations.

## Examples

- Basic Calculation: `calculate(Operation.ADD, 2, 3)` returns `5`.
- Chaining Operations: `chainCalculator(chainCalculator(5, Operation.ADD, 3), Operation.MULTIPLY, 2)` returns `16`.
- Custom Operation: Register and use a custom power operation.

## Testing

Run the `CalculatorUnitTest` class to verify that all features work as expected. The tests cover normal cases, edge cases, and error handling.

