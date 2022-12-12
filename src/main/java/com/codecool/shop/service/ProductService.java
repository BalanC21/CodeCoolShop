package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.PropertyModel;

import java.util.List;

public class ProductService {
    private PropertyDao productDao;
    private ProductCategoryDao productCategoryDao;

    public ProductService(PropertyDao productDao, ProductCategoryDao productCategoryDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
    }

    public ProductCategory getProductCategory(int categoryId) {
        return productCategoryDao.find(categoryId);
    }

    public List<PropertyModel> getProductsForCategory(int categoryId) {
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }
}
