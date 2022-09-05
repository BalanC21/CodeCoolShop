package com.codecool.shop.serialization;

import com.codecool.shop.model.PropertyModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PropertySerializer implements JsonSerializer<PropertyModel> {

    @Override
    public JsonElement serialize(PropertyModel propertyModel, Type type, JsonSerializationContext jsonSerializationContext) {
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
        jsonObject.addProperty("propertyModelCategory", propertyModel.getProductCategory().toString());

        return jsonObject;
    }
}
