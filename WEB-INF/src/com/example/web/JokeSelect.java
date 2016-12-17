package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class JokeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        /* Get id of joke-category from request, get joke (using JokeExpert) and pun joke into request */
        String c = request.getParameter("subject");
        String result = JokeExpert.getJoke(c);
        request.setAttribute("joke", result);

        /* Get designer from SERVLET CONFIGURATION and pun it into request */
        String markupDesigner = getServletConfig().getInitParameter("markup-designer");
        request.setAttribute("markup_designer", markupDesigner);

        /* Get  tagline from SERVLET CONTEXT and put it into request */
        String slogan = getServletContext().getInitParameter("slogan");
        request.setAttribute("slogan", slogan);

        /* Sending data to jsp */
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}