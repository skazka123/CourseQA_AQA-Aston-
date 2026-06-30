public static void main(String[] args) {
    searchFactorial();
    searchAreaTriangle();
    calculator();
    compareNumbers();
}

public static void searchFactorial(){
    try {
        int number = 5;
        System.out.println("Факториал числа " + number + " равен " + Factorial.factorial(number));
    } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
}

public static void searchAreaTriangle(){
    try {
        int a = 6, b = 8, c = 10;
        System.out.println("Площадь треугольника со сторонами " + a + " , " + b + " и " + c + " = " + AreaTriangle.area(a, b, c));
    } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
}

public static void calculator(){
    int a = 6, b = 8;
    System.out.println("Сумма чисел " + a + " и " + b + " = " + CalculateTwoNumbers.sum(a, b));
    System.out.println("Разность чисел " + a + " и " + b + " = " + CalculateTwoNumbers.difference(a, b));
    System.out.println("Произведение чисел " + a + " и " + b + " = " + CalculateTwoNumbers.multiplication(a, b));
    try {
        System.out.println("Деление чисел " + a + " на " + b + " = " + CalculateTwoNumbers.division(a, b));
    } catch (ArithmeticException e) {
        System.out.println("Деление чисел " + a + " на " + b + " невозможно. " + "Ошибка: " + e.getMessage());
    }
}

public static void compareNumbers(){
    int a = 6, b = 7;
    String result = CompareNumbers.compareNumbers(a,b);
    System.out.println("Результат сравнения чисел " + a + " и " + b + " : " + result);
}