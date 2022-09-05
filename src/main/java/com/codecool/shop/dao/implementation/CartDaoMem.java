package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem implements CartDao {
    private List<PropertyModel> propertyModels;
    private static CartDaoMem instance = null;

    private CartDaoMem() {
        propertyModels = new ArrayList<>();
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(PropertyModel product) {
        if (propertyModels.stream().noneMatch(propertyModel -> propertyModel.getId() == product.getId()))
            propertyModels.add(product);
    }

    @Override
    public void remove(int id) {
        propertyModels.removeIf(propertyModel -> propertyModel.getId() == id);
    }

    @Override
    public List<PropertyModel> getAll() {
        return propertyModels;
    }

    @Override
    public PropertyModel getBy(String id) {
        return propertyModels.stream().filter(propertyModel -> String.valueOf(propertyModel.getId()).equals(id)).findFirst().get();
    }

    @Override
    public PropertyModel getById(int id) {
        return propertyModels.stream().filter(propertyModel -> propertyModel.getId() == id).findFirst().get();
    }

    @Override
    public String toString() {
        return "CartDaoMem{" +
                "propertyModels=" + propertyModels +
                '}';
    }
}
