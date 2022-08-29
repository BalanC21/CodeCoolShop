package com.codecool.shop.model;

import java.util.List;
import java.util.UUID;

public class AgentModel extends BaseModel{
    private List<PropertyModel> properties;
    private String phoneNumber;
    private String email;

    public AgentModel(List<PropertyModel> properties, String name, String description, String phoneNumber, String email) {
        super(name, description);
        this.properties = properties;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
