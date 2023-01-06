package com.hedspi.ltct.delivery.response;

public class GhnResponse {
    private Integer code;
    private String message;
    private GhnResponseData data;

    public GhnResponse() {
    }

    public GhnResponse(Integer code, String message, GhnResponseData data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GhnResponseData getData() {
        return data;
    }

    public void setData(GhnResponseData data) {
        this.data = data;
    }
}
