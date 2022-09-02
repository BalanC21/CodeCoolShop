package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.PropertyDaoMem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/deleteProduct"})
public class DeleteFromMem extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartDao cartDao = CartDaoMem.getInstance();

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

        int propertyIdAsInt = Integer.parseInt(String.valueOf(buffer).replace("\"", ""));
        cartDao.remove(propertyIdAsInt);

        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}
