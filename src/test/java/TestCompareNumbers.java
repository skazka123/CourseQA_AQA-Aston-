import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCompareNumbers {

    @Test
    void firstBigger() {
        Assertions.assertEquals(CompareNumbers.compareNumbers(6, 4), "первое число больше");
        Assertions.assertEquals(CompareNumbers.compareNumbers(0, -2), "первое число больше");
    }

    @Test
    void secondBigger() {
        Assertions.assertEquals(CompareNumbers.compareNumbers(0, 4), "второе число больше");
        Assertions.assertEquals(CompareNumbers.compareNumbers(-10, -2), "второе число больше");
    }

    @Test
    void sameNumbers() {
        Assertions.assertEquals(CompareNumbers.compareNumbers(0, 0), "числа равны");
    }
}
