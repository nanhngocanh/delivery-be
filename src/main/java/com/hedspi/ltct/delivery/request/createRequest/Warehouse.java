package com.hedspi.ltct.delivery.request.createRequest;

public class Warehouse {
    private Address address;

    public Warehouse(Address address) {
        this.address = address;
    }

    public Warehouse(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
