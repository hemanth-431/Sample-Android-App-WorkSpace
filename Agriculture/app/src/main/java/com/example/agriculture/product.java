package com.example.agriculture;

public class product {
    private String name,brand,des;
    private double price;
    private int qty;
    public product()
    {}


    public product(String name, String brand, String des, double price, int qty) {
        this.name = name;
        this.brand = brand;
        this.des = des;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDes() {
        return des;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}
