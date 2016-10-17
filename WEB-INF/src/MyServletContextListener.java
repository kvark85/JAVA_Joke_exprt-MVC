import javax.servlet.*;

import com.example.testSlon.testSlon;

/**
 * Created by kvark85 on 14.10.2016.
 */

public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent var1) {
        ServletContext sc = var1.getServletContext();
        String name = sc.getInitParameter("name_s");

        testSlon s = new testSlon(name);

        sc.setAttribute("slon", s);
    }

    public void contextDestroyed(ServletContextEvent var1) {
        // а здесь пусто
    }
}
