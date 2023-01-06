package com.hedspi.ltct.delivery.response;

import java.time.Instant;

public class OrderStatusResponse {
    private String status;
    private String statusDetail;
    private Instant updateAt;

    public OrderStatusResponse(String status, String statusDetail, Instant updateAt) {
        this.status = status;
        this.statusDetail = statusDetail;
        this.updateAt = updateAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
}
