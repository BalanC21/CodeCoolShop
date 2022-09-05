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
import java.util.function.ToDoubleBiFunction;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // TODO: 30.08.2022 Delete all ProductRelated Clas;
        ProductDao productDataStore = ProductDaoMem.getInstance();
        // TODO: 30.08.2022 Delete all ProductRelated Clas;

        PropertyDao propertyDataStore = PropertyDaoMem.getInstance();

        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        AgentModel moni = new AgentModel("Moni", "Best RealEstate Ever", "0742-034-186", "monibuciuman@gmail.com");
        AgentModel cristi = new AgentModel("Cristi", "Best RealEstate Almost Ever", "0741-616-375", "cristianbalan2021@gmail.com");
        supplierDataStore.add(moni);
        supplierDataStore.add(cristi);

        //setting up a new product category
        ProductCategory rent = new ProductCategory("rent", "Properties", "A house computer, commonly shortened to house, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory sale = new ProductCategory("sale", "Properties", "A house computer, commonly shortened to house, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(rent);
        productCategoryDataStore.add(sale);

        //setting up products and printing it
        propertyDataStore.add(new PropertyModel(cristi, "Mount Oliver RoadTwo", "Very Good Lighting", "6", "3", "2", new BigDecimal(20_000), new BigDecimal(110), rent, "USD"));
        propertyDataStore.add(new PropertyModel(moni, "Ana RoadTwo", "Very Good Area", "10", "4", "6", new BigDecimal(35_000), new BigDecimal(210), sale, "USD"));
        propertyDataStore.add(new PropertyModel(cristi, "Banana RoadTwo", "Very Good Road", "2", "5", "1", new BigDecimal(15_000), new BigDecimal(310), rent, "USD"));
        propertyDataStore.add(new PropertyModel(moni, "Oliver Car", "Very Good Car", "7", "2", "0", new BigDecimal(24_000), new BigDecimal(456), sale, "USD"));
    }
}
