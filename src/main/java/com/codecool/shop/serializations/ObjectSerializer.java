package com.codecool.shop.serializations;

import com.codecool.shop.model.JsonObj;
import com.google.gson.*;

import java.lang.reflect.Type;


public class ObjectSerializer implements JsonSerializer<JsonObj>, JsonDeserializer<JsonObj> {
    @Override
    public JsonObj deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.isJsonNull())
            System.out.println("asd");
        else
            System.out.println("Ce porst esti!");
        String linkId = jsonObject.get("id").isJsonNull() ? " Ana is NULL " : jsonObject.get("id").getAsString();

        System.out.println("Id is: ");
        System.out.println(linkId);
        System.out.println("Id was: ");

        return new JsonObj(jsonObject.get("id").getAsString().trim());
    }

    @Override
    public JsonElement serialize(JsonObj objectAna, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        System.out.println("ObjectSerializer serialize ");
        jsonObject.addProperty("id", objectAna.getId());
        return jsonObject;
    }
}
