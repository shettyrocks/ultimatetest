package ultimatetest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    // Create an instance of the Calculator class
    Calculator calculator = new Calculator();

    // Test for addition
    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8, "Addition result is incorrect");
    }

    // Test for subtraction
    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        Assert.assertEquals(result, 2, "Subtraction result is incorrect");
    }

    // Test for multiplication
    @Test
    public void testMultiply() {
        int result = calculator.multiply(5, 3);
        Assert.assertEquals(result, 15, "Multiplication result is incorrect");
    }

    // Test for division
    @Test
    public void testDivide() {
        int result = calculator.divide(6, 3);
        Assert.assertEquals(result, 2, "Division result is incorrect");
    }

    // Test for division by zero
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0); // This should throw ArithmeticException
    }
}
