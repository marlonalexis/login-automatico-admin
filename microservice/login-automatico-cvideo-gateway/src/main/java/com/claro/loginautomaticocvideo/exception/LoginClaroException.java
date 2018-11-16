package com.claro.loginautomaticocvideo.exception;

public class LoginClaroException extends Exception {
    private static final long serialVersionUID = 1L;
    private int errorCode = 99;
    
    public LoginClaroException() {
    }

    public LoginClaroException(String message) {
        super(message);
    }
    
    public LoginClaroException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public LoginClaroException(Throwable throwable) {
        super(throwable);
    }

    public LoginClaroException(String message, Throwable throwable) {
        super(message, throwable);
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
