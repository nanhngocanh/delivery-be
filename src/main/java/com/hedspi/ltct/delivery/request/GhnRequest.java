package com.hedspi.ltct.delivery.request;

public class GhnRequest {
    private Integer from_district_id;
    private Integer service_id = 53320;//chuyen phat thuong mai dien tu
    private String service_type_id = null;
    private Integer to_district_id;
    private Integer to_ward_code;
    private Integer height = 50;
    private Integer length = 20;
    private Integer weight = 500;
    private Integer width = 20;
    private Integer insurance_value = 0;
    private String coupon = null;
    private Integer cod_value;

    public GhnRequest(Integer from_district_id, Integer service_id, String service_type_id, Integer to_district_id, Integer to_ward_code, Integer height, Integer length, Integer weight, Integer width, Integer insurance_value, String coupon, Integer cod_value) {
        this.from_district_id = from_district_id;
        this.service_id = service_id;
        this.service_type_id = service_type_id;
        this.to_district_id = to_district_id;
        this.to_ward_code = to_ward_code;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.width = width;
        this.insurance_value = insurance_value;
        this.coupon = coupon;
        this.cod_value = cod_value;
    }

    public GhnRequest(Integer from_district_id, Integer to_district_id, Integer to_ward_code, Integer cod_value) {
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

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(String service_type_id) {
        this.service_type_id = service_type_id;
    }

    public Integer getTo_district_id() {
        return to_district_id;
    }

    public void setTo_district_id(Integer to_district_id) {
        this.to_district_id = to_district_id;
    }

    public Integer getTo_ward_code() {
        return to_ward_code;
    }

    public void setTo_ward_code(Integer to_ward_code) {
        this.to_ward_code = to_ward_code;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getInsurance_value() {
        return insurance_value;
    }

    public void setInsurance_value(Integer insurance_value) {
        this.insurance_value = insurance_value;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Integer getCod_value() {
        return cod_value;
    }

    public void setCod_value(Integer cod_value) {
        this.cod_value = cod_value;
    }
}
