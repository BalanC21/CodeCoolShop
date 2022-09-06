package com.codecool.shop.controller.apis;


import com.codecool.shop.dao.implementation.CartData;
import com.codecool.shop.dao.implementation.DtoCart;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/increase"})
public class IncreaseApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = FilterByRentApi.getResponse(request);

        DecreaseApi.SetDtoCart(response, buffer);
    }
}
