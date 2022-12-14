package com.codecool.shop.controller.apis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/increase"})
public class IncreaseApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = FilterByRentApi.getResponse(request);

        DecreaseApi.SetDtoCart(request, response, buffer);
    }
}
