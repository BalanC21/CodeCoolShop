package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.implementation.CartData;
import com.codecool.shop.dao.implementation.DtoCart;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/decrease"})
public class DecreaseApi extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = ana(request);

        SetDtoCart(response, buffer);
    }

    static void SetDtoCart(HttpServletResponse response, StringBuffer buffer) throws IOException {
        CartData cartData = CartData.getInstance();

        DtoCart dtoCart = new Gson().fromJson(String.valueOf(buffer), DtoCart.class);
        cartData.addDtoCart(dtoCart);
        System.out.println(cartData.getTotal() + " Total");
    }

    static StringBuffer ana(HttpServletRequest request) {
        String line;
        StringBuffer buffer = new StringBuffer();
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
