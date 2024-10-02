package pl.pingwit.pingwitdentalmanager.exceptionhandling;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
