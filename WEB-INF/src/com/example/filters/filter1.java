package com.example.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kvark85 on 20.12.2016.
 */
public class filter1 implements Filter {
    private FilterConfig fc;

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        String name = httpReq.getRemoteUser();
        if (name != name) {
            fc.getServletContext().log("User " + name + " is updating");
        }
        chain.doFilter(req, resp);
    }

    public void destroy() {
        // si cleanup stuff
    }
}
