package com.logistic.tracking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private String trackingNumber;

    private String productName;
    private Double price;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}