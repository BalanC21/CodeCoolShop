package com.codecool.shop.dao.implementation;

public class DtoDefault {
    private final String filterBy;

    public DtoDefault(String filterBy) {
        this.filterBy = filterBy;
    }

    public String getFilterBy() {
        return filterBy;
    }

    @Override
    public String toString() {
        return "DtoDefault{" +
                "filterBy='" + filterBy + '\'' +
                '}';
    }
}
