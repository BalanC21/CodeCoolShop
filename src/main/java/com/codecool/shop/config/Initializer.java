package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.PropertyDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.AgentModel;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.PropertyModel;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        PropertyDao propertyDataStore = PropertyDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        AgentModel moni = new AgentModel("Moni", "Best RealEstate Ever", "0742-034-186", "monibuciuman@gmail.com");
        AgentModel cristi = new AgentModel("Cristi", "Best RealEstate Almost Ever", "0741-616-375", "cristianbalan2021@gmail.com");
        supplierDataStore.add(moni);
        supplierDataStore.add(cristi);

        //setting up a new product category
        ProductCategory rent = new ProductCategory("Rent", "Properties", "A house computer, commonly shortened to house, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory sale = new ProductCategory("Sale", "Properties", "A house computer, commonly shortened to house, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(rent);
        productCategoryDataStore.add(sale);

        //setting up products and printing it
        productDataStore.add(new Product("Best PentHouse", new BigDecimal("1200.000"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", rent, moni));
        productDataStore.add(new Product("Second Best PentHouse", new BigDecimal("2200.000"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", rent, cristi));
        productDataStore.add(new Product("Third Best PentHouse", new BigDecimal("1470.000"), "USD", "Amazon's latest Fire HD 8 house is a great value for media consumption.", sale, moni));

        propertyDataStore.add(new PropertyModel(moni, "Mount Oliver RoadTwo", "Very Good Lighting", "6", "3", "2", 20_000, 110));
        propertyDataStore.add(new PropertyModel(moni, "Ana RoadTwo", "Very Good Area", "10", "4", "6", 35_000, 210));
        propertyDataStore.add(new PropertyModel(moni, "Banana RoadTwo", "Very Good Road", "2", "5", "1", 15_000, 310));
        propertyDataStore.add(new PropertyModel(moni, "Oliver Car", "Very Good Car", "7", "2", "0", 24_000, 40));
    }
}
