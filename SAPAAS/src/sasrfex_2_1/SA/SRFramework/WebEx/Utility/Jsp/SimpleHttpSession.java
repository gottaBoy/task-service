/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpSession
 *  javax.servlet.http.HttpSessionContext
 */
package SA.SRFramework.WebEx.Utility.Jsp;

import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class SimpleHttpSession
implements HttpSession {
    public Object getAttribute(String arg0) {
        return null;
    }

    public Enumeration getAttributeNames() {
        return null;
    }

    public long getCreationTime() {
        return 0L;
    }

    public String getId() {
        return null;
    }

    public long getLastAccessedTime() {
        return 0L;
    }

    public int getMaxInactiveInterval() {
        return 0;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public HttpSessionContext getSessionContext() {
        return null;
    }

    public Object getValue(String arg0) {
        return null;
    }

    public String[] getValueNames() {
        return null;
    }

    public void invalidate() {
    }

    public boolean isNew() {
        return false;
    }

    public void putValue(String arg0, Object arg1) {
    }

    public void removeAttribute(String arg0) {
    }

    public void removeValue(String arg0) {
    }

    public void setAttribute(String arg0, Object arg1) {
    }

    public void setMaxInactiveInterval(int arg0) {
    }
}

