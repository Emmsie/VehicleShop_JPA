package be.brussel.exception.officeexception;

public class OfficeInputTooLongException extends OfficeException {
    public OfficeInputTooLongException() {
    }

    public OfficeInputTooLongException(String message) {
        super(String.format("%s is too long!" ,message));
    }

    public OfficeInputTooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public OfficeInputTooLongException(Throwable cause) {
        super(cause);
    }
}
