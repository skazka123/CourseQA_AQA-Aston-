public static void main(String[] args) {
    task1();
    task2();
}

public static void task1(){
    ArrayList<Student> students = new ArrayList<>();
    Student misha = new Student("Миша", "РИ-196", 1, 5, 5, 4, 3);
    Student sasha = new Student("Саша", "РИ-197", 1, 2, 3, 2, 2);
    Student andrey = new Student("Андрей", "РИ-197", 1, 5, 3, 4, 4);
    Student kolya = new Student("Коля", "РИ-196", 1, 2, 3, 3, 2);
    students.add(misha);
    students.add(sasha);
    students.add(andrey);
    students.add(kolya);

    System.out.println("Все студенты в списках студентов");
    Student.printAllStudents(students);
    System.out.println("*");

    System.out.println("Удаляем студентов с низкой успеваемостью");
    Student.removeStudents(students);
    System.out.println("*");

    System.out.println("Оставшиеся студенты в списках студентов");
    Student.printAllStudents(students);
    System.out.println("*");

    System.out.println("Переводим студентов с хорошей успеваемостью на следующий курс");
    for (Student student : students){
        student.goNextCourse();
    }
    System.out.println("*");

    System.out.println("Выведем список студентов 2 курса");
    Student.printStudents(students, 2);
    System.out.println("*");
}

public static void task2(){
    PhoneBook book = new PhoneBook();

    book.add("Миша", "223");
    book.add("Саша", "224");
    book.add("Саша", "335");

    book.infoAbonent("Саша");
    book.infoAbonent("Миша");
}
