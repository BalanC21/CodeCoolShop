package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.PropertyModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterMem {

    private static FilterMem instance = null;

    private List<PropertyModel> filteredList = new ArrayList<>();

    private List<PropertyModel> getAll = PropertyDaoMem.getInstance().getAll();

    public FilterMem() {
    }

    public static FilterMem getInstance() {
        if (instance == null) {
            instance = new FilterMem();
        }
        return instance;
    }

    public List<PropertyModel> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PropertyModel> filteredList) {
        this.filteredList = filteredList;
    }

    public List<PropertyModel> filterByCriteria(String criteria) {
        return getAll.stream().filter(model -> model.getProductCategory().getName().trim().equals("rent")).collect(Collectors.toList());
    }

    public List<PropertyModel> filterByStatus(String criteria) {
        filteredList = new ArrayList<>();
        for (PropertyModel product : getAll) {
            if (Objects.equals(product.getProductCategory().getName(), criteria)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    public List<PropertyModel> orderByPrice(String criteria) {
        filteredList = new ArrayList<>();

        if (Objects.equals(criteria, "Low to High")) {
            filteredList = getAll.stream()
                    .sorted(Comparator.comparing(PropertyModel::getPrice))
                    .collect(Collectors.toList());
        } else {
            filteredList = getAll.stream()
                    .sorted(Comparator.comparing(PropertyModel::getPrice).reversed())
                    .collect(Collectors.toList());
        }

        return filteredList;
    }
}
