package lab3.task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = new HashMap<>(courseInformation);
    }

    @Override
    public Object clone() {
        try {
            Student cloned = (Student) super.clone();

            cloned.courseInformation = new HashMap<>(this.courseInformation);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", courseInformation=" + courseInformation +
                '}';
    }

    public static void main(String[] args) {
        Map<String, Double> courses = new HashMap<>();
        courses.put("History", 9.5);
        courses.put("German", 8.7);
        Student originalStudent = new Student("Maria James", courses);


        Student clonedStudent = (Student) originalStudent.clone();

        clonedStudent.courseInformation.put("Math", 7.8);

        System.out.println("Original student: " + originalStudent);
        System.out.println("Cloned student: " + clonedStudent);
    }
}

