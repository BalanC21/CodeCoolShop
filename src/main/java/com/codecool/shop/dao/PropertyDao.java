package com.codecool.shop.dao;

import com.codecool.shop.model.AgentModel;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.PropertyModel;

import java.util.List;

public interface PropertyDao {
    void add(PropertyModel product);

    PropertyModel find(int id);

    void remove(int id);

    List<PropertyModel> getAll();

    List<PropertyModel> getBy(AgentModel agentModel);

    List<PropertyModel> getBy(ProductCategory productCategory);
}
