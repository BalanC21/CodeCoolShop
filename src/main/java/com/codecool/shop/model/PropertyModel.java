package com.codecool.shop.model;

import java.util.PrimitiveIterator;

public class PropertyModel extends BaseModel {
    private AgentModel agentModel;
    private String name;
    private String description;
    private String numberOfBeds;
    private String numberOfBaths;
    private String numberOfGarages;
    private int rent;
    private int area;

    public PropertyModel(AgentModel agentModel, String name, String description, String numberOfBeds, String numberOfBaths, String numberOfGarages, int rent, int area)  {
        super(name, description);
        this.agentModel = agentModel;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBaths = numberOfBaths;
        this.numberOfGarages = numberOfGarages;
        this.rent = rent;
        this.area = area;
    }

    public AgentModel getAgentModel() {
        return agentModel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public String getNumberOfBaths() {
        return numberOfBaths;
    }

    public String getNumberOfGarages() {
        return numberOfGarages;
    }

    public String getRent() {
        return "RENT | $ " + rent;
    }

    public String getArea() {
        return String.valueOf(area);
    }
}
