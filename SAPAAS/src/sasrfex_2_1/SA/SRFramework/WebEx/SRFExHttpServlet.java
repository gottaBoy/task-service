/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletResponse
 */
package SA.SRFramework.WebEx;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class SRFExHttpServlet
extends HttpServlet {
    protected void addTimeOutHeaders(HttpServletResponse response) {
        response.setDateHeader("Expires", System.currentTimeMillis());
    }
}

