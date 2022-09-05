package com.codecool.shop.serialization;

import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.PropertyModel;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PropertySerializer implements JsonSerializer<PropertyModel> {

    @Override
    public JsonElement serialize(PropertyModel propertyModel, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject productCategoryJsonObject = new JsonObject();
        productCategoryJsonObject.addProperty("id", propertyModel.getProductCategory().getId());
        productCategoryJsonObject.addProperty("name", propertyModel.getProductCategory().getName());
        productCategoryJsonObject.addProperty("department", propertyModel.getProductCategory().getDepartment());
        productCategoryJsonObject.addProperty("description", propertyModel.getProductCategory().getDescription());

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", propertyModel.getId());
        jsonObject.addProperty("name", propertyModel.getName());
        jsonObject.addProperty("description", propertyModel.getDescription());
        jsonObject.addProperty("defaultPrice", propertyModel.getPrice());
        jsonObject.addProperty("defaultCurrency", propertyModel.getDefaultCurrency().toString());
        jsonObject.addProperty("numberOfBeds", propertyModel.getNumberOfBeds());
        jsonObject.addProperty("numberOfGarages", propertyModel.getNumberOfGarages());
        jsonObject.addProperty("numberOfBaths", propertyModel.getNumberOfBaths());
        jsonObject.addProperty("ares", propertyModel.getArea());
        jsonObject.add("propertyModelCategory", productCategoryJsonObject);
        return jsonObject;

        // TODO: 05.09.2022 Other Way to do Serialization
//        jsonObject.add("propertyModelCategory", new Gson().toJsonTree(propertyModel.getProductCategory()));
    }
}
