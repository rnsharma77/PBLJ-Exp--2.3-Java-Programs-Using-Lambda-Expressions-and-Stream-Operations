import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int age;
    double marks;

    Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return name + " - Age: " + age + ", Marks: " + marks;
    }
}

public class SimpleStudentStream {
    public static void main(String[] args) {
        // Create list of students
        List<Student> students = Arrays.asList(
            new Student("Ravi", 19, 82.5),
            new Student("Priya", 20, 91.2),
            new Student("Amit", 18, 76.8),
            new Student("Sneha", 21, 88.4),
            new Student("Rahul", 22, 69.3)
        );

        // Filter students who have marks greater than 80
        System.out.println("Students with marks > 80:");
        students.stream()
                .filter(s -> s.marks > 80)
                .forEach(s -> System.out.println(s));

        // Sort students by marks in descending order
        System.out.println("\nStudents sorted by marks (high to low):");
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .forEach(s -> System.out.println(s));
    }
}
