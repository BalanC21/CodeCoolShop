package com.codecool.shop.dao;

import com.codecool.shop.model.AgentModel;

import java.util.List;

public interface SupplierDao {

    void add(AgentModel supplier);
    AgentModel find(int id);
    void remove(int id);

    List<AgentModel> getAll();
}
