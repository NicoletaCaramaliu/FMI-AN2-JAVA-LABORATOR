package lab1.task1;

import lab1.task2.Student;
import lab1.task2.Course;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args) {
        Student[] students = StudentAllocator.createStudents(7);

        System.out.println("Toti studentii:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println();

        Course course = new Course("Informatica", 7.0, students);
        System.out.println("Student ales random: " + course.chooseStudentRandomly().toString());
        System.out.println("Studenti care au promovat:");
        course.showAllPassingStudents();

        System.out.println("Studentul cu indexul 3 a promovat? " + course.isStudentPassing(3));
        System.out.println("Studentul cu indexul 4 a promivat? " + course.isStudentPassing(students[4]));

        DummyCalculator calculator = new DummyCalculator();
        calculator.ruleazaCalculator();


    }
}
