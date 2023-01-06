package com.hedspi.ltct.delivery.request.createRequest;

public class Product {
    private String id;
    private String name;
    private String color;
    private String size;
    private Integer price;
    private Integer quantity;

    public Product(){}

    public Product(String id, String name, String color, String size, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
