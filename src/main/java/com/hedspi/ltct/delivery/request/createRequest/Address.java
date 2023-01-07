package com.hedspi.ltct.delivery.request.createRequest;

public class Address {
    private String ward;
    private Integer district;
    private Integer province;
    private String detail;

    public Address(){}

    public Address(String ward, Integer district, Integer province, String detail) {
        this.ward = ward;
        this.district = district;
        this.province = province;
        this.detail = detail;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
