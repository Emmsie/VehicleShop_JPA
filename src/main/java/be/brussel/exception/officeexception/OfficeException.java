package be.brussel.exception.officeexception;

public class OfficeException extends Exception{

    public OfficeException() {
    }

    public OfficeException(String message) {
        super(message);
    }

    public OfficeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OfficeException(Throwable cause) {
        super(cause);
    }
}
