package com.codecool.shop.controller.apis;

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
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "FilterServlet", urlPatterns = {"/api/rent"}, loadOnStartup = 1)
public class FilterByRentApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FilterMem filterMem = FilterMem.getInstance();

        StringBuffer buffer = getResponse(request);
        String[] criteriaList = buffer.toString().split("\"");
        System.out.println(Arrays.toString(criteriaList) + " CriteriaList");
        String criteria = criteriaList[1];

        System.out.println(criteria + " Criteria");

        List<PropertyModel> filteredList = filterMem.filterByCriteria(criteria);

        response.setContentType("application/json");

        Gson gson = new GsonBuilder().registerTypeAdapter(PropertyModel.class, new PropertySerializer()).create();

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
