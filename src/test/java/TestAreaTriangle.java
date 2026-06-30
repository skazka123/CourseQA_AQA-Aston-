import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAreaTriangle {

    @Test
    void correctValues() {
        Assert.assertEquals(AreaTriangle.area(3, 4, 5), 6);
        Assert.assertEquals(AreaTriangle.area(6, 8, 10), 24);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Треугольник не существует"
    )
    void incorrectValues() {
        AreaTriangle.area(6, 1, 5);
    }
}
