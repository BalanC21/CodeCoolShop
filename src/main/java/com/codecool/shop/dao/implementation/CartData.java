package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class CartData {
    private static CartData instance = null;
    private List<PropertyModel> allProperties;
    private List<DtoCart> dtoCarts;

    public CartData(List<PropertyModel> allProperties, List<DtoCart> dtoCart) {
        this.allProperties = allProperties;
        this.dtoCarts = dtoCart;
    }

    public CartData() {
        allProperties = new ArrayList<>();
        dtoCarts = new ArrayList<>();
    }

    public static CartData getInstance() {
        if (instance == null) {
            instance = new CartData();
        }
        return instance;
    }

    public List<DtoCart> getDtoCarts() {
        return dtoCarts;
    }

    public void addDtoCart(DtoCart dtoCart) {
        for (DtoCart dtoElem : dtoCarts) {
            if (dtoElem.getPropertyId().equals(dtoCart.getPropertyId()))
                dtoElem.setNumberOfProperties(dtoCart.getNumberOfProperties());
        }
        if (dtoCarts.stream().noneMatch(dtoCart1 -> dtoCart1.getPropertyId().equals(dtoCart.getPropertyId())))
            dtoCarts.add(dtoCart);
    }


    @Override
    public String toString() {
        return "CartData{" +
                "allProperties=" + allProperties +
                '}';
    }
}
