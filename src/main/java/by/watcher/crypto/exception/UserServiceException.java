package by.watcher.crypto.exception;

public class UserServiceException extends Exception {

    public UserServiceException() {
        super();
    }


    public UserServiceException(String message) {
        super(message);
    }


    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    public UserServiceException(Throwable cause) {
        super(cause);
    }
}
