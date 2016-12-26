package com.example.filters;

import com.example.CompressionResponseWrapper;
import com.example.logger.FileLogger;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class CompressionFilter implements Filter {

    private ServletContext ctx;
    private FilterConfig cfg;

    public void init(FilterConfig config) throws ServletException {
        this.cfg = config;

        FileLogger.log("C:/New_file_from_java.txt", cfg.getFilterName() + " initialized.");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String valid_encoding = request.getHeader("Accept-Encoding");

        if ( valid_encoding.indexOf("gzip") > -1 ) {
            CompressionResponseWrapper wrappedResp = new CompressionResponseWrapper(response);
            wrappedResp.setHeader("Content-Encoding", "gzip");
            wrappedResp.setHeader("Content-Type", "text/html;charset=UTF-8");
            chain.doFilter(req, wrappedResp);
            GZIPOutputStream gzos = wrappedResp.getGZIPOutputStream();
            gzos.finish();
        }
    }

    public void destroy() {
        ctx = null;
        cfg = null;
    }
}
