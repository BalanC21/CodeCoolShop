package com.codecool.shop.serializations.daos;

import com.codecool.shop.model.JsonObj;
import com.codecool.shop.serializations.ObjectSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

public class ObjectDao implements ObjectRepository {

    private final String endpoint;

    public ObjectDao(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public JsonObj getId() {
        String jsonObject = getRequestFromExternalAPI();
        System.out.println(jsonObject);

        Type linkId = new TypeToken<JsonObj>() {
        }.getType();

        System.out.println(linkId);

        Gson gson = new GsonBuilder().registerTypeAdapter(JsonObj.class, new ObjectSerializer()).create();
        return gson.fromJson(jsonObject, linkId);
    }

    private String getRequestFromExternalAPI() {
        StringBuilder responseContent = new StringBuilder();
        String externalApi = "http://localhost:8080/";


        try {
            URL url = new URL(externalApi + endpoint + ".json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // TODO: 31.08.2022 getRequestFromExternalAPI
            System.out.println("getRequestFromExternalAPI " + externalApi + endpoint);

            System.out.println("getRequestFromExternalAPI " + externalApi + endpoint);

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseContent);
        return responseContent.toString();

    }
}

