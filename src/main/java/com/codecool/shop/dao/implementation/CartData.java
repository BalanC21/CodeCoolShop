package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class CartData {
    private static CartData instance = null;
    private List<PropertyModel> allProperties;
    private List<DtoCart> dtoCarts;

    public CartData() {
        allProperties = PropertyDaoMem.getInstance().getAll();
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

    public int getTotal() {
        int total = 0;
        for (PropertyModel property : allProperties) {
            for (DtoCart dtoCart : dtoCarts) {
                if (property.getId() == Integer.parseInt(dtoCart.getPropertyId()))
                    total += (Integer.parseInt(property.getPrice())) * Integer.parseInt(dtoCart.getNumberOfProperties());
            }
        }
        return total;
    }


    @Override
    public String toString() {
        return "CartData{" +
                "allProperties=" + allProperties +
                '}';
    }
}
