/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.IndexViewPage
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.IndexViewPage;

public class PSJITIndexViewPage
extends IndexViewPage {
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PSJITWebContext psJITWebContext = new PSJITWebContext();
        psJITWebContext.init(request, response, request.getSession().getServletContext());
        return psJITWebContext;
    }

    public IPSJITWebContext getPSJITWebContext() {
        return (IPSJITWebContext)this.getWebContext();
    }
}

