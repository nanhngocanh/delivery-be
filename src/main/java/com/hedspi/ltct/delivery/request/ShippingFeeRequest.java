package com.hedspi.ltct.delivery.request;

public class ShippingFeeRequest {
    private Integer from_district_id;
    private Integer to_district_id;
    private String to_ward_code;
    private Integer cod_value;

    public ShippingFeeRequest() {
    }

    public ShippingFeeRequest(Integer from_district_id, Integer to_district_id, String to_ward_code, Integer cod_value) {
        this.from_district_id = from_district_id;
        this.to_district_id = to_district_id;
        this.to_ward_code = to_ward_code;
        this.cod_value = cod_value;
    }

    public Integer getFrom_district_id() {
        return from_district_id;
    }

    public void setFrom_district_id(Integer from_district_id) {
        this.from_district_id = from_district_id;
    }

    public Integer getTo_district_id() {
        return to_district_id;
    }

    public void setTo_district_id(Integer to_district_id) {
        this.to_district_id = to_district_id;
    }

    public String getTo_ward_code() {
        return to_ward_code;
    }

    public void setTo_ward_code(String to_ward_code) {
        this.to_ward_code = to_ward_code;
    }

    public Integer getCod_value() {
        return cod_value;
    }

    public void setCod_value(Integer cod_value) {
        this.cod_value = cod_value;
    }
}

