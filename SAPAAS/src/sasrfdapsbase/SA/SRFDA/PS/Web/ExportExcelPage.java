/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.ExportExcelPage
 *  net.ibizsys.paas.web.util.SimpleWebContext
 */
package SA.SRFDA.PS.Web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;

public class ExportExcelPage
extends net.ibizsys.paas.web.util.ExportExcelPage {
    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strUserId = request.getHeader("X-SRFUSERID");
        if (StringHelper.isNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u8eab\u4efd");
        }
        String strLoginName = request.getHeader("X-SRFLOGINNAME");
        SimpleWebContext iWebContext = new SimpleWebContext();
        iWebContext.init(this.getRequest(), this.getResponse(), this.getRequest().getSession().getServletContext());
        iWebContext.parseRequest();
        WebContext.setCurrent((IWebContext)iWebContext);
        iWebContext.setSessionValue("SRFPERSONID", (Object)strUserId);
        iWebContext.setSessionValue("SRFLOGINNAME", (Object)strLoginName);
        return iWebContext;
    }
}

