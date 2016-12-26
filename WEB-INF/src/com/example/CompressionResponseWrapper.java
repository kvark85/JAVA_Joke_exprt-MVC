package com.example;

// Servlet imports
import javax.servlet.http.*;
import javax.servlet.*;
// I/O imports
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {
    private GZIPServletOutputStream servletGzipOS = null;
    private PrintWriter pw = null;

    public CompressionResponseWrapper(HttpServletResponse resp) {
        super(resp);
    }

    private Object streamUsed = null;

    public void setContentLength (int len) {}


    public GZIPOutputStream getGZIPOutputStream() {
        return this.servletGzipOS.internalGzipOS;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if((streamUsed != null) && (streamUsed != pw)) {
            throw new IllegalStateException();
        }

        if (servletGzipOS == null) {
            servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
            streamUsed = servletGzipOS;
        }

        return servletGzipOS;
    }

    public PrintWriter  getWriter() throws IOException {
        if ( (streamUsed != null) && (streamUsed != servletGzipOS)) {
            throw new IllegalStateException();
        }

        if (pw == null) {
            servletGzipOS = new GZIPServletOutputStream (getResponse().getOutputStream());
            //OutputStream osw = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
            //pw = new PrintWriter(new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding()));

            OutputStreamWriter osw = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
            pw = new PrintWriter(osw);

            streamUsed = pw;
        }
        return pw;

    }

}