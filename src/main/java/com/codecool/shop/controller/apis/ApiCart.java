package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.CartData;
import com.codecool.shop.dao.implementation.PropertyDaoMem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCartServlet", urlPatterns = {"/api/getCart", "/api/getTotal"}, loadOnStartup = 1)
public class ApiCart extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartData cartData = CartData.getInstance();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(cartData.getTotal());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PropertyDao propertyDao = PropertyDaoMem.getInstance();
        CartDao cartDao = CartDaoMem.getInstance();

        StringBuffer buffer = FilterByRentApi.getResponse(request);

        int propertyIdAsInt = Integer.parseInt(String.valueOf(buffer).replace("\"", ""));

        cartDao.add(propertyDao.getById(propertyIdAsInt));

        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}

