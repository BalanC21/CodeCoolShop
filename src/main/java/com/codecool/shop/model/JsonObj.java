package com.codecool.shop.model;

public class JsonObj {
    private final String id;

    public JsonObj(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "JsonObj{" +
                "id='" + id + '\'' +
                '}';
    }
}
