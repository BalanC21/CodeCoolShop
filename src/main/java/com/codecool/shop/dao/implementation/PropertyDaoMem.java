package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyDaoMem implements PropertyDao {

    private List<PropertyModel> data = new ArrayList<>();
    private static PropertyDaoMem instance = null;

    private PropertyDaoMem() {
    }

    public static PropertyDaoMem getInstance() {
        if (instance == null) {
            instance = new PropertyDaoMem();
        }
        return instance;
    }

    @Override
    public void add(PropertyModel product) {
        product.setId(data.size() + 1);
        data.add(product);
    }

    @Override
    public PropertyModel find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<PropertyModel> getAll() {
        return data;
    }

    @Override
    public List<PropertyModel> getBy(AgentModel agentModel) {
        return data.stream().filter(t -> t.getAgentModel().equals(agentModel)).collect(Collectors.toList());
    }

    @Override
    public List<PropertyModel> getBy(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }

    @Override
    public PropertyModel getById(int id) {
        return data.stream().filter(elem ->elem.getId() == id).collect(Collectors.toList()).get(0);
    }
}
