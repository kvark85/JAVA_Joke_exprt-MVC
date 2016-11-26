package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class JokeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        /* Берем id темы шутки из request, достаем шутку с помощю JokeExpert и помещаем его в request*/
        String c = request.getParameter("subject");
        String result = JokeExpert.getJoke(c);
        request.setAttribute("joke", result);

        /* Берем "дизайнера" из КОНФИГУРАЦИИ СЕРВЛЕТА и помещаем его в request */
        String markupDesigner = getServletConfig().getInitParameter("markup-designer");
        request.setAttribute("markup_designer", markupDesigner);

        /* Берем слоган из КОНТЕКСТА СЕРВЛЕТОВ и помещаем его в request */
        String slogan = getServletContext().getInitParameter("slogan");
        request.setAttribute("slogan", slogan);

        /*Передаем данные дальше, в jsp*/
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}