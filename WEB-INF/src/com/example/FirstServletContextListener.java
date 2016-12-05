package com.example;

import javax.servlet.*;

import com.example.aboutDeveloper.DeveloperInformation;

/**
 * Created by kvark85 on 14.10.2016.
 */

public class FirstServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent var1) {
        ServletContext servletContext = var1.getServletContext();
        String developerName = servletContext.getInitParameter("developer_name");
        String developerEmail = servletContext.getInitParameter("developer_email");

        DeveloperInformation developer = new DeveloperInformation(developerName, developerEmail);

        /* Помещаем в контекст сервлетов обьект "developer"
         * (данный параметр видно везде в приложении) */
        servletContext.setAttribute("developer", developer);
    }

    public void contextDestroyed(ServletContextEvent var1) {
        // а здесь пусто
    }
}
