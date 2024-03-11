package lab2.task3;

public class ConstructorMethodRunner {
    public static void main(String[] args) {

        foo(new B());
    }

    static void foo(A a) {
        a.add(8);
        a.print();
    }
}

class A {
    protected int number;
    A(int value) {
        add(value);
    }

    public void add(int value) {
        number += value;
    }

    public void print() {
        System.out.println(number);
    }
}

class B extends A {
    B() {
        super(2);
    }

    public void add(int value) {
        number += value * 2;
    }
}
