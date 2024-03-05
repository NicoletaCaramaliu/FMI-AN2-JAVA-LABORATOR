package lab1.task2;

import java.util.Random;
public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public Student chooseStudentRandomly()
    {
        Random random = new Random();
        int randomIndex = random.nextInt(students.length);
        return students[randomIndex];
    }

    public Student[] showAllPassingStudents()
    {
        Student[] passingStudents = new Student[students.length];
        int index = 0;
        for (Student student : students)
        {
            if (student.getGrade() >= minimumGrade)
            {
                passingStudents[index] = student;
                index++;
            }
        }

        for (Student student : passingStudents)
        {
            System.out.println(student.toString());
        }

        return passingStudents;

    }

    public boolean isStudentPassing(int studentIndex) {
        if (studentIndex < 0 || studentIndex >= students.length) {
            return false;
        }

        return students[studentIndex].getGrade() >= minimumGrade;
    }

    public boolean isStudentPassing(Student student) {
        for (Student s : students) {
            if (s.equals(student)) {
                return s.getGrade() >= minimumGrade;
            }
        }

        return false;
    }
}
