package com.hedspi.ltct.delivery.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;

@Entity
@Table(name = "shipping_order")
@EntityListeners(AuditingEntityListener.class)
public class ShippingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_code", length = 50)
    private String orderCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_code")
    private Status statusCode;

    @Column(name = "status_detail")
    private String statusDetail;

    @Column(name = "create_at")
    @CreatedDate
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;

    @Column(name = "service_fee")
    private Integer serviceFee;

    @Column(name = "insurance_fee")
    private Integer insuranceFee;

    @Column(name = "pick_station_fee")
    private Integer pickStationFee;

    @Column(name = "total_shipping_fee")
    private Integer totalShippingFee;

    @Column(name = "warehouse_ward", length = 50)
    private String warehouseWard;

    @Column(name = "warehouse_district", length = 50)
    private String warehouseDistrict;

    @Column(name = "warehouse_provice", length = 50)
    private String warehouseProvice;

    @Column(name = "warehouse_detail")
    private String warehouseDetail;

    @Column(name = "receiver_name", length = 50)
    private String receiverName;

    @Column(name = "receiver_phone", length = 50)
    private String receiverPhone;

    @Column(name = "receiver_ward", length = 50)
    private String receiverWard;

    @Column(name = "receiver_district", length = 50)
    private String receiverDistrict;

    @Column(name = "receiver_province", length = 50)
    private String receiverProvince;

    @Column(name = "receiver_detail")
    private String receiverDetail;

    @Column(name = "cod")
    private Integer cod;

    @Column(name = "weight")
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getReceiverDetail() {
        return receiverDetail;
    }

    public void setReceiverDetail(String receiverDetail) {
        this.receiverDetail = receiverDetail;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverWard() {
        return receiverWard;
    }

    public void setReceiverWard(String receiverWard) {
        this.receiverWard = receiverWard;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getWarehouseDetail() {
        return warehouseDetail;
    }

    public void setWarehouseDetail(String warehouseDetail) {
        this.warehouseDetail = warehouseDetail;
    }

    public String getWarehouseProvice() {
        return warehouseProvice;
    }

    public void setWarehouseProvice(String warehouseProvice) {
        this.warehouseProvice = warehouseProvice;
    }

    public String getWarehouseDistrict() {
        return warehouseDistrict;
    }

    public void setWarehouseDistrict(String warehouseDistrict) {
        this.warehouseDistrict = warehouseDistrict;
    }

    public String getWarehouseWard() {
        return warehouseWard;
    }

    public void setWarehouseWard(String warehouseWard) {
        this.warehouseWard = warehouseWard;
    }

    public Integer getTotalShippingFee() {
        return totalShippingFee;
    }

    public void setTotalShippingFee(Integer totalShippingFee) {
        this.totalShippingFee = totalShippingFee;
    }

    public Integer getPickStationFee() {
        return pickStationFee;
    }

    public void setPickStationFee(Integer pickStationFee) {
        this.pickStationFee = pickStationFee;
    }

    public Integer getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Integer insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public Status getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Status statusCode) {
        this.statusCode = statusCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public Integer getId() {
        return id;
    }

    public ShippingOrder(String orderCode, Integer serviceFee, Integer insuranceFee, Integer pickStationFee, Integer totalShippingFee, String warehouseWard, String warehouseDistrict, String warehouseProvice, String warehouseDetail, String receiverName, String receiverPhone, String receiverWard, String receiverDistrict, String receiverProvince, String receiverDetail, Integer cod, Integer weight) {
        this.orderCode = orderCode;
        this.serviceFee = serviceFee;
        this.insuranceFee = insuranceFee;
        this.pickStationFee = pickStationFee;
        this.totalShippingFee = totalShippingFee;
        this.warehouseWard = warehouseWard;
        this.warehouseDistrict = warehouseDistrict;
        this.warehouseProvice = warehouseProvice;
        this.warehouseDetail = warehouseDetail;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverWard = receiverWard;
        this.receiverDistrict = receiverDistrict;
        this.receiverProvince = receiverProvince;
        this.receiverDetail = receiverDetail;
        this.cod = cod;
        this.weight = weight;
    }

    public ShippingOrder() {
    }
}