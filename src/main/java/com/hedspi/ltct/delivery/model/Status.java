package com.hedspi.ltct.delivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_code", nullable = false)
    private Integer id;

    @Column(name = "`desc`")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public Integer getId() {
        return id;
    }

}