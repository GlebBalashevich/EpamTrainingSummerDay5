package by.balashevich.stringapp.exception;

public class ProjectInvalidDataException extends Exception{

    public ProjectInvalidDataException() {
        super();
    }

    public ProjectInvalidDataException(String message) {
        super(message);
    }

    public ProjectInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectInvalidDataException(Throwable cause) {
        super(cause);
    }
}
