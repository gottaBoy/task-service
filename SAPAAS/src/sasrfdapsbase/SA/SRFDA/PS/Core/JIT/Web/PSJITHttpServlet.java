/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.web.HttpServletBase
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITHttpServlet
extends HttpServletBase {
    private static final Log log = LogFactory.getLog(PSJITHttpServlet.class);

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PSJITWebContext psJITWebContext = new PSJITWebContext();
        psJITWebContext.init(request, response, request.getSession().getServletContext());
        return psJITWebContext;
    }

    public IPSJITWebContext getPSJITWebContext() {
        return (IPSJITWebContext)this.getWebContext();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent((IWebContext)iWebContext);
            response.getWriter().print(this.output());
            response.getWriter().flush();
            response.getWriter().close();
            this.resetCurrent();
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            this.resetCurrent();
            throw new ServletException((Throwable)ex);
        }
    }

    public String output() throws Exception {
        return "";
    }
}

