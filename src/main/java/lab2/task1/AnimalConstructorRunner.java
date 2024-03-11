package lab2.task1;

public class AnimalConstructorRunner {
    public static void main(String[] args) {
        Animal dog = new Dog();
    }
}

class Animal {

    public Animal() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    public Dog() {
        System.out.println("Dog");
    }
}