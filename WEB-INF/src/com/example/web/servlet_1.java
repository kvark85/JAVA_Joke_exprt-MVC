package com.example.web;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class servlet_1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view = request.getRequestDispatcher("jsp_1.jsp");
        view.forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view = request.getRequestDispatcher("jsp_1.jsp");
        view.forward(request, response);
    }
}