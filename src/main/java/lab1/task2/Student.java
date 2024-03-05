package lab1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private double grade;

    @Override
    public String toString() {
        return "Studentul cu numele " + name +
                ", are nota " + grade ;
    }

}
