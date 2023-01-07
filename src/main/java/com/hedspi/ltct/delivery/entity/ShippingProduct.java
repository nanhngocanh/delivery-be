package com.hedspi.ltct.delivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shipping_product")
public class ShippingProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_order_id")
    private ShippingOrder shippingOrder;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private Integer status = 1;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "size", length = 50)
    private String size;

    @Column(name = "price")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ShippingOrder getShippingOrder() {
        return shippingOrder;
    }

    public void setShippingOrder(ShippingOrder shippingOrder) {
        this.shippingOrder = shippingOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShippingProduct(ShippingOrder shippingOrder, String productId, Integer quantity, String name, String color, String size, Integer price) {
        this.shippingOrder = shippingOrder;
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public ShippingProduct(Integer id, String productId, Integer quantity, Integer status, String name, String color, String size, Integer price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public ShippingProduct() {
    }
}