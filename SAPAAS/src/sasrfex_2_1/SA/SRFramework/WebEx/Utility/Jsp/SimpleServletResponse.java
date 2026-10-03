/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletResponse
 */
package SA.SRFramework.WebEx.Utility.Jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SimpleServletResponse
implements HttpServletResponse {
    private final Map<String, Collection<String>> headers = new TreeMap<String, Collection<String>>(String.CASE_INSENSITIVE_ORDER);
    private int status = SC_OK;

    public void flushBuffer() throws IOException {
    }

    public int getBufferSize() {
        return 0;
    }

    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public Locale getLocale() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        return null;
    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {
        this.headers.clear();
        this.status = SC_OK;
    }

    public void resetBuffer() {
    }

    public void setBufferSize(int arg0) {
    }

    public void setCharacterEncoding(String arg0) {
    }

    public void setContentLength(int arg0) {
        this.setHeader("Content-Length", Integer.toString(arg0));
    }

    public void setContentLengthLong(long length) {
        this.setHeader("Content-Length", Long.toString(length));
    }

    public void setContentType(String arg0) {
    }

    public void setLocale(Locale arg0) {
    }

    public void addCookie(Cookie arg0) {
    }

    public void addDateHeader(String arg0, long arg1) {
        this.addHeader(arg0, Long.toString(arg1));
    }

    public void addHeader(String arg0, String arg1) {
        Collection<String> values = this.headers.get(arg0);
        if (values == null) {
            values = new ArrayList<String>();
            this.headers.put(arg0, values);
        }
        values.add(arg1);
    }

    public void addIntHeader(String arg0, int arg1) {
        this.addHeader(arg0, Integer.toString(arg1));
    }

    public boolean containsHeader(String arg0) {
        return this.headers.containsKey(arg0);
    }

    public String encodeRedirectURL(String arg0) {
        return null;
    }

    public String encodeRedirectUrl(String arg0) {
        return null;
    }

    public String encodeURL(String arg0) {
        return null;
    }

    public String encodeUrl(String arg0) {
        return null;
    }

    public void sendError(int arg0) throws IOException {
    }

    public void sendError(int arg0, String arg1) throws IOException {
    }

    public void sendRedirect(String arg0) throws IOException {
    }

    public void setDateHeader(String arg0, long arg1) {
        this.setHeader(arg0, Long.toString(arg1));
    }

    public void setHeader(String arg0, String arg1) {
        Collection<String> values = new ArrayList<String>();
        values.add(arg1);
        this.headers.put(arg0, values);
    }

    public void setIntHeader(String arg0, int arg1) {
        this.setHeader(arg0, Integer.toString(arg1));
    }

    public void setStatus(int arg0) {
        this.status = arg0;
    }

    public void setStatus(int arg0, String arg1) {
        this.status = arg0;
    }

    public int getStatus() {
        return this.status;
    }

    public String getHeader(String name) {
        Collection<String> values = this.headers.get(name);
        return values == null || values.isEmpty() ? null : values.iterator().next();
    }

    public Collection<String> getHeaders(String name) {
        Collection<String> values = this.headers.get(name);
        return values == null ? Collections.<String>emptyList() : Collections.unmodifiableCollection(values);
    }

    public Collection<String> getHeaderNames() {
        return Collections.unmodifiableCollection(this.headers.keySet());
    }
}
