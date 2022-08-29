package com.codecool.shop.model;


public class PropertyModel extends BaseModel {
    private final AgentModel agentModel;
    private ProductCategory productCategory;
    private final String numberOfBeds;
    private final String numberOfBaths;
    private final String numberOfGarages;
    private final int rent;
    private final int area;

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

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
