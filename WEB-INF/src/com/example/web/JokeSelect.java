package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class JokeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        /* Get id of joke-category from request, get joke (using JokeExpert) and pun joke into request */
        String subject = request.getParameter("subject");
        String result = JokeExpert.getJoke(subject);
        request.setAttribute("joke", result);

        /* Sending data to jsp */
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}