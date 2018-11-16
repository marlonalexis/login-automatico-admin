package com.claro.loginautomaticocvideo.exception;

public class IntegrationException extends Exception {
    private static final long serialVersionUID = 1L;

    public IntegrationException() {
    }

    public IntegrationException(String message) {
        super(message);
    }

    public IntegrationException(Throwable throwable) {
        super(throwable);
    }

    public IntegrationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}