public class Triangle implements MathFigure{
    int side1;
    int side2;
    int side3;
    String backgroundColor;
    String borderColor;

    public Triangle (int side1, int side2, int side3, String backgroundColor, String borderColor){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double Perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double Area() {
        double half_meter = Perimeter()/2;
        return Math.sqrt(half_meter * (half_meter - side1) * (half_meter - side2) * (half_meter - side3));
    }

    @Override
    public void info() {
        System.out.println("Фигура: треугольник, площадь: " + Area() + ", периметр: " + Perimeter() +
                ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor);
    }
}
