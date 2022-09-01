package com.codecool.shop.dao;

import com.codecool.shop.model.PropertyModel;

import java.util.List;

public interface CartDao {
    void add(PropertyModel product);

    void remove(int id);

    List<PropertyModel> getAll();

    PropertyModel getBy(String id);

    PropertyModel getById(int id);
}
