package com.wkcto.stream;

import java.util.Objects;

/**
 * Author : 动力节点老崔
 */
public class Car {
    private String brand;   //品牌
    private  boolean sold;  //是否已卖
    private int price;
    private CarType type;   //车型

    public Car(String brand, boolean sold, int price, CarType type) {
        this.brand = brand;
        this.sold = sold;
        this.price = price;
        this.type = type;
    }

    public Car() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return sold == car.sold &&
                price == car.price &&
                Objects.equals(brand, car.brand) &&
                type == car.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, sold, price, type);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", sold=" + sold +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public Car setPrice(int price) {
        this.price = price;
        return this;
    }

    public CarType getType() {
        return type;
    }

    public Car setType(CarType type) {
        this.type = type;
        return this;
    }
}
