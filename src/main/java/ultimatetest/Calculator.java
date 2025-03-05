package ultimatetest;

public class Calculator {

    // Method to add two numbers
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method to subtract two numbers
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    // Method to multiply two numbers
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Method to divide two numbers
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
