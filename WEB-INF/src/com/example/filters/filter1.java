package com.example.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kvark85 on 20.12.2016.
 */
public class filter1 implements Filter {
    private FilterConfig fc;
    private String LogFileName;

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
        LogFileName = this.fc.getInitParameter("LogFileName");
        System.out.print("\nOne two three\n\n");
    }

    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        String name = httpReq.getRemoteUser();
        if (name != null) {
            //fc.getServletContext().log("User " + name + " is updating"); // it is don't work (don't know why)
            FileWriter writer = null;
            try {
                writer = new FileWriter(LogFileName, true);
                writer.write("User " + name + " visited a secret page\r\n");
            }
            catch(IOException e ){
                System.out.print(e.getMessage());
            }
            finally{
                writer.close();
            }
        }
        chain.doFilter(req, resp);
    }

    public void destroy() {
        fc = null;
        LogFileName = null;
    }
}
