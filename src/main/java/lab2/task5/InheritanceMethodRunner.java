package lab2.task5;


public class InheritanceMethodRunner {
    public static void main(String[] args) {
        (new D()).foo();
    }
}

class C {
    public void foo() {
        bar(this);
    }
    public void bar(C c) {
        System.out.println("C");
    }
}

class D extends C {
    public void bar(D d) {
        System.out.println("D");
    }
}