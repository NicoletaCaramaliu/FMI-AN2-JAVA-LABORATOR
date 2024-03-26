package lab3.task1;

public class JustMyFirstException extends RuntimeException {
    public JustMyFirstException() {
        super("Oopsie! This is my first exception!");
    }

    public JustMyFirstException(String message) {
        this();
    }
}
