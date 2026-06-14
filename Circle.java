public class Circle implements MathFigure{
    int radius;
    String backgroundColor;
    String borderColor;

    public Circle (int radius, String backgroundColor, String borderColor){
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double Perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double Area() {
        return Math.PI * radius *radius;
    }

    @Override
    public void info() {
        System.out.println("Фигура: круг, площадь: " + Area() + ", периметр: " + Perimeter() +
                ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor);
    }
}
