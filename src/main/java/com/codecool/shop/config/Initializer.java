package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier moni = new Supplier("Moni", "Best RealEstate Ever");
        supplierDataStore.add(moni);
        Supplier cristi = new Supplier("Cristi", "Best RealEstate Almost Ever");
        supplierDataStore.add(cristi);

        //setting up a new product category
        ProductCategory house = new ProductCategory("Rent", "Properties", "A house computer, commonly shortened to house, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(house);

        //setting up products and printing it
        productDataStore.add(new Product("Best PentHouse", new BigDecimal("1200.000"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", house, moni));
        productDataStore.add(new Product("Second Best PentHouse", new BigDecimal("2200.000"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", house, cristi));
        productDataStore.add(new Product("Third Best PentHouse", new BigDecimal("1470.000"), "USD", "Amazon's latest Fire HD 8 house is a great value for media consumption.", house, moni));
    }
}
