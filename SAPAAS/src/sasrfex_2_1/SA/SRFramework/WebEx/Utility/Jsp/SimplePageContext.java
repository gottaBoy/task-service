/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Servlet
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletContext
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpSession
 *  javax.servlet.jsp.JspWriter
 *  javax.servlet.jsp.PageContext
 *  javax.servlet.jsp.el.ExpressionEvaluator
 *  javax.servlet.jsp.el.VariableResolver
 */
package SA.SRFramework.WebEx.Utility.Jsp;

import SA.SRFramework.WebEx.Utility.Jsp.SimpleServletRequest;
import SA.SRFramework.WebEx.Utility.Jsp.SimpleServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Collections;
import java.util.HashMap;
import javax.el.ArrayELResolver;
import javax.el.BeanELResolver;
import javax.el.CompositeELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.FunctionMapper;
import javax.el.ListELResolver;
import javax.el.MapELResolver;
import javax.el.VariableMapper;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.ScopedAttributeELResolver;
import javax.servlet.jsp.el.VariableResolver;

public class SimplePageContext
extends PageContext {
    protected SimpleServletRequest simpleServletRequest = null;
    protected SimpleServletResponse simpleServletResponse = null;
    protected Servlet servlet = null;
    protected ServletContext servletContext = null;
    protected HashMap<String, Object> attributeMap = new HashMap();
    private ELContext elContext;

    public void initialize(ServletContext servletContext, ServletRequest arg1, ServletResponse arg2) {
        this.simpleServletRequest = (SimpleServletRequest)arg1;
        this.simpleServletResponse = (SimpleServletResponse)arg2;
        this.servletContext = servletContext;
    }

    public void initialize(Servlet arg0, ServletRequest arg1, ServletResponse arg2, String arg3, boolean arg4, int arg5, boolean arg6) throws IOException, IllegalStateException, IllegalArgumentException {
        this.simpleServletRequest = (SimpleServletRequest)arg1;
        this.simpleServletResponse = (SimpleServletResponse)arg2;
        this.servlet = arg0;
        this.servletContext = arg0.getServletConfig().getServletContext();
    }

    public void forward(String arg0) throws ServletException, IOException {
    }

    public Exception getException() {
        return null;
    }

    public Object getPage() {
        return null;
    }

    public ServletRequest getRequest() {
        return this.simpleServletRequest;
    }

    public ServletResponse getResponse() {
        return this.simpleServletResponse;
    }

    public ServletConfig getServletConfig() {
        return this.servlet == null ? null : this.servlet.getServletConfig();
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    public HttpSession getSession() {
        return this.simpleServletRequest.getSession();
    }

    public void handlePageException(Exception arg0) throws ServletException, IOException {
    }

    public void handlePageException(Throwable arg0) throws ServletException, IOException {
    }

    public void include(String arg0) throws ServletException, IOException {
    }

    public void include(String arg0, boolean arg1) throws ServletException, IOException {
    }

    public void release() {
        this.attributeMap.clear();
        this.elContext = null;
    }

    public Object findAttribute(String arg0) {
        return this.attributeMap.get(arg0);
    }

    public Object getAttribute(String arg0) {
        return this.attributeMap.get(arg0);
    }

    public Object getAttribute(String arg0, int arg1) {
        if (arg1 != PAGE_SCOPE) {
            throw new IllegalArgumentException("Unsupported simulated page scope: " + arg1);
        }
        return this.attributeMap.get(arg0);
    }

    public Enumeration getAttributeNamesInScope(int arg0) {
        if (arg0 != PAGE_SCOPE) {
            throw new IllegalArgumentException("Unsupported simulated page scope: " + arg0);
        }
        return Collections.enumeration(this.attributeMap.keySet());
    }

    public int getAttributesScope(String arg0) {
        return this.attributeMap.containsKey(arg0) ? PAGE_SCOPE : 0;
    }

    public ELContext getELContext() {
        if (this.elContext == null) {
            final CompositeELResolver resolver = new CompositeELResolver();
            resolver.add(new ScopedAttributeELResolver());
            resolver.add(new MapELResolver());
            resolver.add(new ListELResolver());
            resolver.add(new ArrayELResolver());
            resolver.add(new BeanELResolver());
            this.elContext = new ELContext() {
                public ELResolver getELResolver() {
                    return resolver;
                }

                public FunctionMapper getFunctionMapper() {
                    return null;
                }

                public VariableMapper getVariableMapper() {
                    return null;
                }
            };
            this.elContext.putContext(JspContext.class, this);
        }
        return this.elContext;
    }

    public ExpressionEvaluator getExpressionEvaluator() {
        return null;
    }

    public JspWriter getOut() {
        return null;
    }

    public VariableResolver getVariableResolver() {
        return null;
    }

    public void removeAttribute(String arg0) {
        this.attributeMap.remove(arg0);
    }

    public void removeAttribute(String arg0, int arg1) {
        if (arg1 != PAGE_SCOPE) {
            throw new IllegalArgumentException("Unsupported simulated page scope: " + arg1);
        }
        this.attributeMap.remove(arg0);
    }

    public void setAttribute(String arg0, Object arg1) {
        this.attributeMap.put(arg0, arg1);
    }

    public void setAttribute(String arg0, Object arg1, int arg2) {
        if (arg2 != PAGE_SCOPE) {
            throw new IllegalArgumentException("Unsupported simulated page scope: " + arg2);
        }
        this.attributeMap.put(arg0, arg1);
    }
}
