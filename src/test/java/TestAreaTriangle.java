import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAreaTriangle {

    @Test
    void correctValues() {
        Assertions.assertEquals(AreaTriangle.area(3, 4, 5), 6);
        Assertions.assertEquals(AreaTriangle.area(6, 8, 10), 24);
    }

    @Test
    void incorrectValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {AreaTriangle.area(6, 1, 5);}, "Треугольник не существует");
    }
}
