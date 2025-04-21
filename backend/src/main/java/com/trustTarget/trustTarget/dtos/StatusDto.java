package com.trustTarget.trustTarget.dtos;

public class StatusDto {
    private Boolean status;
    private String message;
    private String error;

    public StatusDto(boolean status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public StatusDto(boolean status, String message) {
        this(status, message, "");
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
