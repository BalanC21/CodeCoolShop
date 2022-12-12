package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.implementation.DtoDefault;
import com.codecool.shop.dao.implementation.FilterMem;
import com.codecool.shop.model.PropertyModel;
import com.codecool.shop.serialization.PropertySerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "FilterServlet", urlPatterns = {"/api/sort"}, loadOnStartup = 1)
public class FilterByRentApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FilterMem filterMem = FilterMem.getInstance();
        StringBuffer buffer = getResponse(request);
        response.setContentType("application/json");

        Gson gson = new GsonBuilder().registerTypeAdapter(PropertyModel.class, new PropertySerializer()).create();
        DtoDefault anaTest = new Gson().fromJson(String.valueOf(buffer), DtoDefault.class);

        List<PropertyModel> filteredList = filterMem.filterByCriteria(anaTest.getFilterBy());

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(filteredList));
    }

    static StringBuffer getResponse(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buffer;
    }
}
