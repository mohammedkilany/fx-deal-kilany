package com.bloomberg.fxdealanalyzer.exception;


public class DealAlreadyProcessedException extends RuntimeException {

    public DealAlreadyProcessedException(String message) {
        super(message);
    }

    public DealAlreadyProcessedException(String message, Throwable cause) {
        super(message, cause);
    }
}
