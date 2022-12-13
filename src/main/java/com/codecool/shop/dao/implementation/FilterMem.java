package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.PropertyModel;

import java.util.*;
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

    public List<PropertyModel> filterByCriteria(String criteria) {
        switch (criteria){
            case "1": return filterByNewToOld();
            case "2": return filterByRent();
            case "3": return filterBySale();
            default: return getAll;
        }
    }

    private List<PropertyModel> filterByRent(){
        return getAll.stream().filter(model -> model.getProductCategory().getName().trim().equals("rent")).collect(Collectors.toList());
    }
    private List<PropertyModel> filterBySale(){
        return getAll.stream().filter(model -> model.getProductCategory().getName().trim().equals("sale")).collect(Collectors.toList());
    }
    private List<PropertyModel> filterByNewToOld(){
        return getAll.stream().sorted(Comparator.comparingInt(PropertyModel::getId).reversed()).collect(Collectors.toList());
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

    public List<PropertyModel> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PropertyModel> filteredList) {
        this.filteredList = filteredList;
    }
}
