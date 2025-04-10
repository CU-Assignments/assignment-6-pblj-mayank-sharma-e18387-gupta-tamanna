import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.0),
            new Student("Bob", 65.0),
            new Student("Charlie", 78.5),
            new Student("Diana", 92.0),
            new Student("Ethan", 74.0)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        
        students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> s.marks))
            .map(s -> s.name)
            .forEach(System.out::println);
    }
}
