package com.codecool.shop.dao.implementation;

public class DtoCart {
    private String numberOfProperties;
    private String propertyId;

    public DtoCart(String numberOfProperties, String propertyId) {
        this.numberOfProperties = numberOfProperties;
        this.propertyId = propertyId;
    }

    public String getNumberOfProperties() {
        return numberOfProperties;
    }

    public String getPropertyId() {
        return propertyId;
    }


    @Override
    public String toString() {
        return "DtoCart{" +
                "numberOfProperties='" + numberOfProperties + '\'' +
                ", propertyId='" + propertyId + '\'' +
                '}';
    }
}
