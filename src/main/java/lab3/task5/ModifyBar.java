package lab3.task5;

public class ModifyBar {
    public static void main(String[] args)
    {
        bar();
    }

    public static void bar() {
        try {
            try {
                throw new ClassCastException();
            } catch (RuntimeException e) {
                System.out.println("Nu afisez fail");
            }
        } catch (RuntimeException e) {
            System.out.println("fail");
        }
    }
}
