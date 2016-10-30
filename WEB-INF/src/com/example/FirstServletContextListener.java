package com.example;

import javax.servlet.*;

import com.example.aboutDeveloper.DeveloperInformation;

/**
 * Created by kvark85 on 14.10.2016.
 */

public class FirstServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent var1) {
        ServletContext sc = var1.getServletContext();
        String developerName = sc.getInitParameter("developer_name");
        String developerEmail = sc.getInitParameter("developer_email");

        DeveloperInformation developer = new DeveloperInformation(developerName, developerEmail);

        sc.setAttribute("developer", developer);
    }

    public void contextDestroyed(ServletContextEvent var1) {
        // а здесь пусто
    }
}
