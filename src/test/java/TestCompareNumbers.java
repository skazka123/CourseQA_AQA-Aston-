import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCompareNumbers {

    @Test
    void firstBigger() {
        Assert.assertEquals(CompareNumbers.compareNumbers(6, 4), "первое число больше");
        Assert.assertEquals(CompareNumbers.compareNumbers(0, -2), "первое число больше");
    }

    @Test
    void secondBigger() {
        Assert.assertEquals(CompareNumbers.compareNumbers(0, 4), "второе число больше");
        Assert.assertEquals(CompareNumbers.compareNumbers(-10, -2), "второе число больше");
    }

    @Test
    void sameNumbers() {
        Assert.assertEquals(CompareNumbers.compareNumbers(0, 0), "числа равны");
    }
}
