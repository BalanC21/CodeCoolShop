package com.codecool.shop.controller.apis;

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
//        int decreaseValue = Integer.parseInt(String.valueOf(buffer).replace("\"", ""));

        System.out.println(buffer + " buffer decrease");

//        System.out.println(decreaseValue);

        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
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
