package com.example.filters;

import com.example.logger.FileLogger;

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

        if (name == null) { name = "Someone"; }

        FileLogger.log(LogFileName, "User " + name + " visited a secret page\r\n");

        chain.doFilter(req, resp);

        FileLogger.log("C:/New_file_from_java.txt", "User " + name + " visited a secret page\r\n");
        FileLogger.log("C:/New_file_from_java.txt", "1111111111111111e\r\n");
    }

    public void destroy() {
        fc = null;
        LogFileName = null;
    }
}
