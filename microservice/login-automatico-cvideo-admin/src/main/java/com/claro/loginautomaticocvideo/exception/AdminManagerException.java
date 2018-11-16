package com.claro.loginautomaticocvideo.exception;

public class AdminManagerException extends Exception {
    private static final long serialVersionUID = 1L;
    private int errorCode = 99;
    
    public AdminManagerException() {
    }

    public AdminManagerException(String message) {
        super(message);
    }
    
    public AdminManagerException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AdminManagerException(Throwable throwable) {
        super(throwable);
    }

    public AdminManagerException(String message, Throwable throwable) {
        super(message, throwable);
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
