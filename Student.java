import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int number_course;
    private ArrayList<Integer> score;

    public Student(String name, String group, int number_course, int... score){
        this.name = name;
        this.group = group;
        this.number_course = number_course;
        this.score = new ArrayList<Integer>();
        for (int ball : score){
            this.score.add(ball);
        }
    }

    public double averageScore (ArrayList<Integer> score){
        if (score.isEmpty()) return 0.0;
        int sum_score = 0;
        for (Integer ball : score){
            sum_score += ball;
        }
        return (double) Math.round( sum_score /score.size()*100)/100;
    }

    public void info (){
        System.out.println("Студент: " + name + "; группа: " + group + "; курс: " + number_course +
                "; оценки по предметам: " + score + "; средний балл: " + averageScore(score));
    }

    public void goNextCourse(){
        if (averageScore(score)>= 3.0){
            this.number_course++;
        }
    }

    public static void removeStudents(ArrayList<Student> students) {
        // Важно: при удалении во время итерации по списку нужно использовать список-копию,
        // иначе может возникнуть ConcurrentModificationException
        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student : students) {
            if (student.averageScore(student.score) < 3.0) {
                studentsToRemove.add(student);
            }
        }
        students.removeAll(studentsToRemove);
    }


    public static void printStudents(ArrayList<Student> students, int course){
        for (Student student : students){
            if (student.number_course == course){
                student.info();
            }
        }
    }

    public static void printAllStudents(ArrayList<Student> students){
        for (Student student : students){
            student.info();
        }
    }
}
