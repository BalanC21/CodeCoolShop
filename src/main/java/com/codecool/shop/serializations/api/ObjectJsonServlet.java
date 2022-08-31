package com.codecool.shop.serializations.api;

import com.codecool.shop.model.JsonObj;
import com.codecool.shop.serializations.ObjectSerializer;
import com.codecool.shop.serializations.daos.ObjectDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "JsonServlet", urlPatterns = {"/JsonServlet"})
public class ObjectJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        ObjectDao objectDao = new ObjectDao("id");
        JsonObj linkId = objectDao.getId();

        System.out.println(linkId + " ObjectJsonServlet Java");

        Gson gson = new GsonBuilder().registerTypeAdapter(JsonObj.class, new ObjectSerializer()).create();
        out.println(gson.toJson(linkId));
    }
}

