package com.codecool.shop.model;


import java.math.BigDecimal;
import java.util.Currency;

public class PropertyModel extends BaseModel {
    private final AgentModel agentModel;
    private String numberOfBeds;
    private String numberOfBaths;
    private String numberOfGarages;
    private final BigDecimal price;
    private BigDecimal area;
    private ProductCategory productCategory;
    private Currency defaultCurrency;

    public PropertyModel(AgentModel agentModel, String name, String description, String numberOfBeds, String numberOfBaths, String numberOfGarages, BigDecimal price, BigDecimal area, ProductCategory category, String currency) {
        super(name, description);
        this.agentModel = agentModel;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBaths = numberOfBaths;
        this.numberOfGarages = numberOfGarages;
        this.price = price;
        this.area = area;
        this.productCategory = category;
        this.defaultCurrency = Currency.getInstance(currency);
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

    public String getPrice() {
        return String.valueOf(price);
    }

    public String getArea() {
        return String.valueOf(area);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    @Override
    public String toString() {
        return "PropertyModel{" +
                "agentModel=" + agentModel +
                ", numberOfBeds='" + numberOfBeds + '\'' +
                ", numberOfBaths='" + numberOfBaths + '\'' +
                ", numberOfGarages='" + numberOfGarages + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", productCategory=" + productCategory +
                ", defaultCurrency=" + defaultCurrency +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
