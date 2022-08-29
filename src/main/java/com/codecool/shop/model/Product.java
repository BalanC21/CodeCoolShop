package com.codecool.shop.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Product extends BaseModel {

    private BigDecimal defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private AgentModel agentModel;


    public Product(String name, BigDecimal defaultPrice, String currencyString, String description, ProductCategory productCategory, AgentModel agentModel) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(agentModel);
        this.setProductCategory(productCategory);
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    public void setPrice(BigDecimal price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    public AgentModel getSupplier() {
        return agentModel;
    }

    public void setSupplier(AgentModel agentModel) {
        this.agentModel = agentModel;
        this.agentModel.addProduct(this);
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "agentModel: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.agentModel.getName());
    }
}
