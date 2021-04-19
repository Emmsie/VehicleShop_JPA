package be.brussel.exception.officeexception;

public class OfficeInputIsEmptyException extends OfficeException{

    public OfficeInputIsEmptyException() {
    }

    public OfficeInputIsEmptyException(String message) {
        super(String.format("%s is empty!" ,message));
    }

    public OfficeInputIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public OfficeInputIsEmptyException(Throwable cause) {
        super(cause);
    }
}
