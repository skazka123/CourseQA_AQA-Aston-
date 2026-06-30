public class CalculateTwoNumbers {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int difference(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0 не выполнимо");
        }
        return (double) a / b;
    }
}
