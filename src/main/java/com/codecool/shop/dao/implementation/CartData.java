package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.PropertyModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartData {
    private List<PropertyModel> propertyModels;
    private int numberOfProperties;

    public CartData(List<PropertyModel> propertyModels, int numberOfProperties) {
        this.propertyModels = propertyModels;
        this.numberOfProperties = numberOfProperties;
    }

    public List<PropertyModel> getPropertyModels() {
        return propertyModels;
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public void setNumberOfProperties(int numberOfProperties) {
        this.numberOfProperties = numberOfProperties;
    }

    public Map<PropertyModel, Integer> getCartProducts(){

        return new HashMap<>();
    }

    @Override
    public String toString() {
        return "CartData{" +
                "propertyModels=" + propertyModels +
                ", numberOfProperties=" + numberOfProperties +
                '}';
    }
}
