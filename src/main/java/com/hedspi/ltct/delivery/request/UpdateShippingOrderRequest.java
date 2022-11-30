package com.hedspi.ltct.delivery.request;

public class UpdateShippingOrderRequest {
    private Integer statusCode;
    private String statusDetail;

    public UpdateShippingOrderRequest(Integer statusCode, String statusDetail) {
        this.statusCode = statusCode;
        this.statusDetail = statusDetail;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }
}
