package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.implementation.CartData;
import com.codecool.shop.dao.implementation.DtoCart;
import com.codecool.shop.dao.implementation.DtoDefault;
import com.codecool.shop.model.PropertyModel;
import com.codecool.shop.serialization.PropertySerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/decrease"})
public class DecreaseApi extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartData cartData = CartData.getInstance();
        request.setAttribute("total", cartData.getTotal());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = ana(request);
        System.out.println(buffer + " doPost Buffer");

        SetDtoCart(request, response, buffer);
    }

    static void SetDtoCart(HttpServletRequest request, HttpServletResponse response, StringBuffer buffer) throws IOException {
        CartData cartData = CartData.getInstance();

        DtoCart dtoCart = new Gson().fromJson(String.valueOf(buffer), DtoCart.class);
        cartData.addDtoCart(dtoCart);

//        Gson gson = new GsonBuilder().registerTypeAdapter(PropertyModel.class, new DtoDefault(String.valueOf(cartData.getTotal()))).create();

        response.setContentType("application/json");
        request.setAttribute("total", cartData.getTotal());
//        PrintWriter out = response.getWriter();

//        out.println(gson.toJson(String.valueOf(cartData.getTotal())));
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
