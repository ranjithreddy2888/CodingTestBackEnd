package com.project.backend.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;
    private String message;
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(String error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
