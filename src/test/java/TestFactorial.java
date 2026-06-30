import org.testng.Assert;
import org.testng.annotations.Test;


public class TestFactorial {
    @Test
    void zero() {
        Assert.assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    void naturalInt() {
        Assert.assertEquals(Factorial.factorial(1), 1);
        Assert.assertEquals(Factorial.factorial(2), 2);
        Assert.assertEquals(Factorial.factorial(10), 3628800);
    }

    @Test (
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Факториал не определён для отрицательных чисел"
    )
    void lessZero() {
        Factorial.factorial(-1);
    }
}
