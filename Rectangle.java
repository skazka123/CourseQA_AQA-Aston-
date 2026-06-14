public class Rectangle implements MathFigure{
    int width;
    int length;
    String backgroundColor;
    String borderColor;

    public Rectangle (int width, int length, String backgroundColor, String borderColor){
        this.width = width;
        this.length = length;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double Perimeter() {
        return (width + length) * 2;
    }

    @Override
    public double Area() {
        return width * length;
    }

    @Override
    public void info() {
        System.out.println("Фигура: прямоугольник, площадь: " + Area() + ", периметр: " + Perimeter() +
                ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor);
    }
}
