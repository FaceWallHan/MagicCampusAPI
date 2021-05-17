package com.hss.campus.controller;

import com.google.gson.Gson;
import com.hss.campus.util.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class BaseServlet extends HttpServlet {
    private  BufferedReader reader;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isGet()){
            reader=getSendStream(response, request);
            response.getWriter().write(new Gson().toJson(operatingGet(request)));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isGet()){
            reader=getSendStream(response, request);
            response.getWriter().write(new Gson().toJson(operatingGet(request)));
        }
    }
    public  abstract Response operatingGet(HttpServletRequest request);
    public abstract  boolean isGet();

    public <T> T getEntity(Class<T> clazz) {
        StringBuilder builder = new StringBuilder();
        String input;
        try {
            while ((input=reader.readLine())!=null){
                builder.append(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(builder.toString(),clazz);
    }
    private BufferedReader getSendStream(HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        return new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
    }
}
