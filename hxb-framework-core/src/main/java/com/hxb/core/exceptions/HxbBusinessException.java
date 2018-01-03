package com.hxb.core.exceptions;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class HxbBusinessException extends HxbRuntimeException {

    public static final String DEFAULT_FAULT_CODE = "SYS0001";

    private String errorCode;
    private String message;

    public HxbBusinessException(String message){
        this(DEFAULT_FAULT_CODE, message);
    }

    public HxbBusinessException(String errorCode, String message) {
        this(errorCode, message, new Throwable());
    }

    public HxbBusinessException(String errorCode, String message, String internalMessage) {
        this(errorCode, message, internalMessage, null);
    }

    public HxbBusinessException(String errorCode, String message, Throwable throwable) {
        this(errorCode, message, throwable.getMessage(), throwable);
    }

    public HxbBusinessException(String errorCode, String message, String internalMessage, Throwable throwable) {
        super("[" + errorCode + "] - " + message + internalMessage, throwable);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageWithoutCode(){
        return message;
    }

    @Override
    public String getMessage() {
        return "[" + errorCode + "]" + " - " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
