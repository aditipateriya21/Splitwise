package dev.Aditi.Splitwise.Exception;

public class UserRegistrationInvalidDetailsException extends RuntimeException{
    public UserRegistrationInvalidDetailsException() {
    }

    public UserRegistrationInvalidDetailsException(String message) {
        super(message);
    }

    public UserRegistrationInvalidDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegistrationInvalidDetailsException(Throwable cause) {
        super(cause);
    }

    public UserRegistrationInvalidDetailsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
