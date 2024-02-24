package ru.demo.somebank.exception;

public class RootBusinessException extends RuntimeException {

    public RootBusinessException() {
        super();
    }

    public RootBusinessException(String message) {
        super(message);
    }

    public RootBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
