package com.hedspi.ltct.delivery.request.createRequest;

import java.util.List;

public class CreateShippingOrderRequest {
    private String orderId;
    private Warehouse warehouse;
    private Receiver receiver;
    private Integer cod;
    private Integer weight;
    private List<Product> products;

    public CreateShippingOrderRequest() {
    }

    public CreateShippingOrderRequest(String order_id, Warehouse warehouse, Receiver receiver, Integer cod, Integer weight, List<Product> products) {
        this.orderId = order_id;
        this.warehouse = warehouse;
        this.receiver = receiver;
        this.cod = cod;
        this.weight = weight;
        this.products = products;
    }

    public CreateShippingOrderRequest(String order_id, List<Product> products) {
        this.orderId = order_id;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
