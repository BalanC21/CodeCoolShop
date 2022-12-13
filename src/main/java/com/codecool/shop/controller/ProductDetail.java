package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.PropertyDao;
import com.codecool.shop.dao.implementation.PropertyDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/productDetail"})
public class ProductDetail extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PropertyDao propertyDao = PropertyDaoMem.getInstance();
        String productId = request.getParameter("article");

        PrintWriter out = response.getWriter(); // todo //

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());

        WebContext context = new WebContext(request, response, request.getServletContext());

        context.setVariable("singleProperty", propertyDao.find(Integer.parseInt(productId)));

        context.setVariable("property", propertyDao.find(Integer.parseInt(productId)));

        engine.process("product/property-single.html", context, response.getWriter());
    }
}
