import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFactorial {
    @Test
    void zero() {
        Assertions.assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    void naturalInt() {
        Assertions.assertEquals(Factorial.factorial(1), 1);
        Assertions.assertEquals(Factorial.factorial(2), 2);
        Assertions.assertEquals(Factorial.factorial(10), 3628800);
    }

    @Test
    void lessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {Factorial.factorial(-1);}, "Факториал не определён для отрицательных чисел");
    }
}
