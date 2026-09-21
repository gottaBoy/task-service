/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.jsp.PageContext
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.io.Writer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSJITJSPViewPage {
    private static final Log log = LogFactory.getLog(PSJITJSPViewPage.class);
    private boolean bNoCache = true;
    private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal();
    private ThreadLocal<PageContext> pageContext = new ThreadLocal();
    private int nAccessUserMode = AccessUserModes.ALLUSER;
    private String strAccessKey = null;

    public final boolean init(PageContext context) throws Exception {
        this.pageContext.set(context);
        if (this.isNoCache()) {
            this.getResponse().addHeader("cache-control", "no-cache");
            this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
        }
        IWebContext iWebContext = this.createWebContext(this.getRequest(), this.getResponse());
        WebContext.setCurrent((IWebContext)iWebContext);
        try {
            String strJSPPath = this.getWebContext().getParamValue("JSPPATH");
            log.info((Object)StringHelper.format((String)"JSP\u4ee3\u7406[%1$s]", (Object)strJSPPath));
            this.onInit();
        }
        catch (Exception ex) {
            this.getResponse().getWriter().print("<B><FONT style='color:red;'>&nbsp;&nbsp;\u52a8\u6001JSP\u8f93\u51fa\u53d1\u751f\u9519\u8bef\uff0c\u6ce8\u610f\uff1aJIT\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49\u6837\u5f0f\u5185\u5bb9\u9884\u89c8</FONT></B>");
            this.getResponse().getWriter().print("<BR>&nbsp;&nbsp;");
            this.getResponse().getWriter().print(ex.getMessage());
        }
        return true;
    }

    protected void resetCurrent() {
        this.setSessionFactory(null);
        WebContext.setCurrent(null);
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PSJITWebContext psJITWebContext = new PSJITWebContext();
        psJITWebContext.init(request, response, request.getSession().getServletContext());
        return psJITWebContext;
    }

    protected void onInit() throws Exception {
    }

    public final Writer getWriter() {
        return this.getPageContext().getOut();
    }

    public final HttpServletRequest getRequest() {
        return (HttpServletRequest)this.getPageContext().getRequest();
    }

    public final HttpServletResponse getResponse() {
        return (HttpServletResponse)this.getPageContext().getResponse();
    }

    public boolean isNoCache() {
        return this.bNoCache;
    }

    protected void setNoCache(boolean bNoCache) {
        this.bNoCache = bNoCache;
    }

    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    public final PageContext getPageContext() {
        return this.pageContext.get();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory.get();
    }

    public IPSJITWebContext getPSJITWebContext() {
        return (IPSJITWebContext)this.getWebContext();
    }

    public String getIncludeJSPFile() {
        return (String)this.getRequest().getAttribute("includejsp");
    }
}

