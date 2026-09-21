/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.web.servlet.support.RequestContext
 */
package SA.SRFDA.PS.Core.JIT.Web;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.support.RequestContext;

public class PSJITRequestContext
extends RequestContext {
    public PSJITRequestContext(HttpServletRequest request) {
        super(request, null, null, null);
    }

    public PSJITRequestContext(HttpServletRequest request, HttpServletResponse response) {
        super(request, response, null, null);
    }

    public PSJITRequestContext(HttpServletRequest request, ServletContext servletContext) {
        super(request, null, servletContext, null);
    }

    public PSJITRequestContext(HttpServletRequest request, Map<String, Object> model) {
        super(request, null, null, model);
    }

    public PSJITRequestContext(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, Map<String, Object> model) {
        super(request, response, servletContext, model);
    }

    protected void initContext(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, Map<String, Object> model) {
    }
}

