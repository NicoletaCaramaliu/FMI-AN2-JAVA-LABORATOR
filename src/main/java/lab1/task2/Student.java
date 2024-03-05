package lab1.task2;

public class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name =  name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }



}
