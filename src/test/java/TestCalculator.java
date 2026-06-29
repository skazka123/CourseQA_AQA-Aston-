import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculator {
    @Test
    void testSum() {
        Assertions.assertEquals(CalculateTwoNumbers.sum(3, 4), 7);
        Assertions.assertEquals(CalculateTwoNumbers.sum(-3, 4), 1);
    }

    @Test
    void testDifference() {
        Assertions.assertEquals(CalculateTwoNumbers.difference(3, 4), -1);
        Assertions.assertEquals(CalculateTwoNumbers.difference(-3, -4), 1);
    }

    @Test
    void testMultiplication() {
        Assertions.assertEquals(CalculateTwoNumbers.multiplication(3, 4), 12);
        Assertions.assertEquals(CalculateTwoNumbers.multiplication(-3, 4), -12);
    }

    @Test
    void testDivision() {
        Assertions.assertEquals(CalculateTwoNumbers.division(3, 4), 0.75);
        Assertions.assertEquals(CalculateTwoNumbers.division(-3, 4), -0.75);
    }

    @Test
    void zeroValue() {
        Assertions.assertEquals(CalculateTwoNumbers.sum(3, 0), 3);
        Assertions.assertEquals(CalculateTwoNumbers.difference(0, 4), -4);
        Assertions.assertEquals(CalculateTwoNumbers.multiplication(3, 0), 0);
        Assertions.assertEquals(CalculateTwoNumbers.division(0, 4), 0.0);
        Assertions.assertThrows(ArithmeticException.class, () -> {CalculateTwoNumbers.division(6, 0);}, "Деление на 0 не выполнимо");
    }
}
