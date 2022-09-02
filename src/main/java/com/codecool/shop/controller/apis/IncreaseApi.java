package com.codecool.shop.controller.apis;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/increase"})
public class IncreaseApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartDao cartDao = CartDaoMem.getInstance();

        System.out.println("Treaba");

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


        System.out.println("Treaba2");
        int propertyIdAsInt = Integer.parseInt(String.valueOf(buffer).replace("\"", ""));
        System.out.println(propertyIdAsInt);
        System.out.println("Treaba3");


        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}
