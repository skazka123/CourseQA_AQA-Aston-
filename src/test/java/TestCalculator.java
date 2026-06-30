import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {
    @Test
    void testSum() {
        Assert.assertEquals(CalculateTwoNumbers.sum(3, 4), 7);
        Assert.assertEquals(CalculateTwoNumbers.sum(-3, 4), 1);
    }

    @Test
    void testDifference() {
        Assert.assertEquals(CalculateTwoNumbers.difference(3, 4), -1);
        Assert.assertEquals(CalculateTwoNumbers.difference(-3, -4), 1);
    }

    @Test
    void testMultiplication() {
        Assert.assertEquals(CalculateTwoNumbers.multiplication(3, 4), 12);
        Assert.assertEquals(CalculateTwoNumbers.multiplication(-3, 4), -12);
    }

    @Test
    void testDivision() {
        Assert.assertEquals(CalculateTwoNumbers.division(3, 4), 0.75);
        Assert.assertEquals(CalculateTwoNumbers.division(-3, 4), -0.75);
    }

    @Test
    void zeroValue() {
        Assert.assertEquals(CalculateTwoNumbers.sum(3, 0), 3);
        Assert.assertEquals(CalculateTwoNumbers.difference(0, 4), -4);
        Assert.assertEquals(CalculateTwoNumbers.multiplication(3, 0), 0);
        Assert.assertEquals(CalculateTwoNumbers.division(0, 4), 0.0);
    }

    @Test(
            expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "Деление на 0 не выполнимо"
    )

    void deleteOnZero(){
        CalculateTwoNumbers.division(6, 0);
    }
}
