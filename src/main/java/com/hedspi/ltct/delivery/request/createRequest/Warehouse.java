package com.hedspi.ltct.delivery.request.createRequest;

public class Warehouse {
    private Address address = new Address("1A0302", 1488, 201, "Kho Đại học Bách Khoa Hà Nội");

    public Warehouse(Address address) {
        this.address.setDetail(address.getDetail());
    }

    public Warehouse(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address.setDetail(address.getDetail());
    }
}
