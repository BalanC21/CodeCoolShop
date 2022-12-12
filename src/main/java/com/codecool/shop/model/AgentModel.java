package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class AgentModel extends BaseModel {
    private List<Product> products;
    private final String phoneNumber;
    private final String email;
    private List<PropertyModel> properties;

    public AgentModel(String name, String description, String phoneNumber, String email) {
        super(name, description);
        this.products = new ArrayList<>();
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}