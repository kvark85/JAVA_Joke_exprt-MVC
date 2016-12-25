package com.example;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPServletOutputStream extends ServletOutputStream {
    GZIPOutputStream internalGzipOS;

    GZIPServletOutputStream(ServletOutputStream sos) throws IOException {
        this.internalGzipOS = new GZIPOutputStream(sos);
    }

    public void write(int param) throws java.io.IOException {
        internalGzipOS.write(param);
    }
}