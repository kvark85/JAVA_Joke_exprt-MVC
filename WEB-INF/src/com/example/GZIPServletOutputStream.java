package com.example;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
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

    public boolean isReady() {
        return false;
    }

    public void setWriteListener(WriteListener writeListener) {

    }
}