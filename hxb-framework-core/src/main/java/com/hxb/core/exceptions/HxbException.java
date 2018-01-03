package com.hxb.core.exceptions;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class HxbException extends Exception {
    private String errorCode;
    private String message;


    public HxbException(String errorCode, String message) {
        this(errorCode, message, new Throwable());
    }

    public HxbException(String errorCode, String message, String internalMessage) {
        this(errorCode, message, internalMessage, null);
    }

    public HxbException(String errorCode, String message, Throwable throwable) {
        this(errorCode, message, throwable.getMessage(), throwable);
    }

    public HxbException(String errorCode, String message, String internalMessage, Throwable throwable) {
        super("[" + errorCode + "] - [" + message +"]" + internalMessage, throwable);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
