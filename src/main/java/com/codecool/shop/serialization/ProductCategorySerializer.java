package com.codecool.shop.serialization;

import com.codecool.shop.model.ProductCategory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ProductCategorySerializer implements JsonSerializer<ProductCategory> {
    @Override
    public JsonElement serialize(ProductCategory productCategory, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", productCategory.getId());
        jsonObject.addProperty("name", productCategory.getName());
        jsonObject.addProperty("department", productCategory.getDepartment());
        jsonObject.addProperty("description", productCategory.getDescription());
        return jsonObject;
    }
}
