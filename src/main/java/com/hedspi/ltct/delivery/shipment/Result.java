package com.example.demo.shipment;

public class Result {
    private Integer responseCode;
    private String message;
    private Boolean ok;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getOk() {
        return ok;
    }

    public Result(Integer responseCode, String message, Boolean ok) {
        this.responseCode = responseCode;
        this.message = message;
        this.ok = ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Result() {
    }
    public Result(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "Result{" +
                "responseCode=" + responseCode +
                ", message='" + message + '\'' +
                ", ok=" + ok +
                '}';
    }
}
