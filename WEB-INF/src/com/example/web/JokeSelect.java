package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class JokeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String c = request.getParameter("subject");

        String result = JokeExpert.getJoke(c);

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("joke", result);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}