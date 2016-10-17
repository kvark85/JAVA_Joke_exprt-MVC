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

        String just_test = getServletConfig().getInitParameter("just_test");
        String main_domain = getServletContext().getInitParameter("main_domain");
        String admin_email = getServletContext().getInitParameter("admin_email");

        request.setAttribute("joke", result);
        request.setAttribute("just_test", just_test);
        request.setAttribute("main_domain", main_domain);
        request.setAttribute("admin_email", admin_email);

        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}