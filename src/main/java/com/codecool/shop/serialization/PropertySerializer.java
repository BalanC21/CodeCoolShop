package com.codecool.shop.serialization;

import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.PropertyModel;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PropertySerializer implements JsonSerializer<PropertyModel> {

    @Override
    public JsonElement serialize(PropertyModel propertyModel, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        JsonObject pcJsonObject = new JsonObject();
        pcJsonObject.addProperty("id", propertyModel.getProductCategory().getId());
        pcJsonObject.addProperty("name", propertyModel.getProductCategory().getName());
        pcJsonObject.addProperty("department", propertyModel.getProductCategory().getDepartment());
        pcJsonObject.addProperty("description", propertyModel.getProductCategory().getDescription());




        jsonObject.addProperty("id", propertyModel.getId());
        jsonObject.addProperty("name", propertyModel.getName());
        jsonObject.addProperty("description", propertyModel.getDescription());
        jsonObject.addProperty("defaultPrice", propertyModel.getPrice());
        jsonObject.addProperty("defaultCurrency", propertyModel.getDefaultCurrency().toString());
        jsonObject.addProperty("numberOfBeds", propertyModel.getNumberOfBeds());
        jsonObject.addProperty("numberOfGarages", propertyModel.getNumberOfGarages());
        jsonObject.addProperty("numberOfBaths", propertyModel.getNumberOfBaths());
        jsonObject.addProperty("ares", propertyModel.getArea());
        jsonObject.add("propertyModelCategory", pcJsonObject);
//        jsonObject.add("propertyModelCategory", new Gson().toJsonTree(propertyModel.getProductCategory()));
        return jsonObject;
    }
}
