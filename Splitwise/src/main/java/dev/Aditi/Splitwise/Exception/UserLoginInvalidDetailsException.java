package dev.Aditi.Splitwise.Exception;

public class UserLoginInvalidDetailsException extends RuntimeException {
    public UserLoginInvalidDetailsException() {
    }

    public UserLoginInvalidDetailsException(String message) {
        super(message);
    }

    public UserLoginInvalidDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginInvalidDetailsException(Throwable cause) {
        super(cause);
    }

    public UserLoginInvalidDetailsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
