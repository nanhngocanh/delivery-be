package com.example.demo.shipment;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table
public class Sorder {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    private ZonedDateTime createAt;
    private ZonedDateTime updateAt;
    private Integer statusCode;
    private String statusDesc;
    private String statusDetail;

    public Sorder() {
    }

    public Sorder(ZonedDateTime createAt, ZonedDateTime updateAt, Integer statusCode, String statusDesc, String statusDetail) {
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
        this.statusDetail = statusDetail;
    }

    public Sorder(ZonedDateTime createAt, ZonedDateTime updateAt, String statusDesc, String statusDetail) {
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.statusDesc = statusDesc;
        this.statusDetail = statusDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public ZonedDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(ZonedDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", statusCode=" + statusCode +
                ", statusDesc='" + statusDesc + '\'' +
                ", statusDetail='" + statusDetail + '\'' +
                '}';
    }
}
