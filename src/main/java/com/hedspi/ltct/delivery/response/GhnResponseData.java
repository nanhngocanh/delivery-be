package com.hedspi.ltct.delivery.response;

public class GhnResponseData {
    private Integer total;
    private Integer service_fee;
    private Integer insurance_fee;
    private Integer pick_station_fee;
    private Integer coupon_value;
    private Integer r2s_fee;
    private Integer document_return;
    private Integer double_check;
    private Integer cod_fee;
    private Integer pick_remote_areas_fee;
    private Integer deliver_remote_areas_fee;

    public GhnResponseData() {
    }

    public GhnResponseData(Integer total, Integer service_fee, Integer insurance_fee, Integer pick_station_fee, Integer coupon_value, Integer r2s_fee, Integer document_return, Integer double_check, Integer cod_fee, Integer pick_remote_areas_fee, Integer deliver_remote_areas_fee) {
        this.total = total;
        this.service_fee = service_fee;
        this.insurance_fee = insurance_fee;
        this.pick_station_fee = pick_station_fee;
        this.coupon_value = coupon_value;
        this.r2s_fee = r2s_fee;
        this.document_return = document_return;
        this.double_check = double_check;
        this.cod_fee = cod_fee;
        this.pick_remote_areas_fee = pick_remote_areas_fee;
        this.deliver_remote_areas_fee = deliver_remote_areas_fee;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getService_fee() {
        return service_fee;
    }

    public void setService_fee(Integer service_fee) {
        this.service_fee = service_fee;
    }

    public Integer getInsurance_fee() {
        return insurance_fee;
    }

    public void setInsurance_fee(Integer insurance_fee) {
        this.insurance_fee = insurance_fee;
    }

    public Integer getPick_station_fee() {
        return pick_station_fee;
    }

    public void setPick_station_fee(Integer pick_station_fee) {
        this.pick_station_fee = pick_station_fee;
    }

    public Integer getCoupon_value() {
        return coupon_value;
    }

    public void setCoupon_value(Integer coupon_value) {
        this.coupon_value = coupon_value;
    }

    public Integer getR2s_fee() {
        return r2s_fee;
    }

    public void setR2s_fee(Integer r2s_fee) {
        this.r2s_fee = r2s_fee;
    }

    public Integer getDocument_return() {
        return document_return;
    }

    public void setDocument_return(Integer document_return) {
        this.document_return = document_return;
    }

    public Integer getDouble_check() {
        return double_check;
    }

    public void setDouble_check(Integer double_check) {
        this.double_check = double_check;
    }

    public Integer getCod_fee() {
        return cod_fee;
    }

    public void setCod_fee(Integer cod_fee) {
        this.cod_fee = cod_fee;
    }

    public Integer getPick_remote_areas_fee() {
        return pick_remote_areas_fee;
    }

    public void setPick_remote_areas_fee(Integer pick_remote_areas_fee) {
        this.pick_remote_areas_fee = pick_remote_areas_fee;
    }

    public Integer getDeliver_remote_areas_fee() {
        return deliver_remote_areas_fee;
    }

    public void setDeliver_remote_areas_fee(Integer deliver_remote_areas_fee) {
        this.deliver_remote_areas_fee = deliver_remote_areas_fee;
    }
}
