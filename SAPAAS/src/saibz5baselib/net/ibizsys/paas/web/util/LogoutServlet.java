/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import javax.servlet.ServletException;
import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.util.HttpRedirectServlet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogoutServlet
extends HttpRedirectServlet {
    private static final long serialVersionUID = 7486761561445169301L;
    private static final Log log = LogFactory.getLog(LogoutServlet.class);
    private String strDefalutURL = "/index.html";
    private String strApplicationId = "";

    @Override
    public void init() throws ServletException {
        super.init();
        this.strApplicationId = this.getInitParameter("APPLICATIONID");
    }

    @Override
    protected String getRedirectUrl() {
        String strUrl = super.getRedirectUrl();
        if (StringHelper.isNullOrEmpty(strUrl)) {
            strUrl = this.strDefalutURL;
        }
        try {
            this.getWebContext().logout(true);
            if (!StringHelper.isNullOrEmpty(this.strApplicationId)) {
                IApplicationModel appModel = this.getApplicationModel();
                strUrl = StringHelper.format("/%1$s%2$s", appModel.getName().toLowerCase(), appModel.getUtilPageUrl("LOGIN"));
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u83b7\u53d6\u6ce8\u9500\u91cd\u5b9a\u5411\u5730\u5740\u9519\u8bef\uff1a%1$s", ex.getMessage()));
        }
        return strUrl;
    }

    protected IApplicationModel getApplicationModel() throws Exception {
        if (StringHelper.isNullOrEmpty(this.strApplicationId)) {
            return (IApplicationModel)AppModelGlobal.getDefaultApplication();
        }
        return (IApplicationModel)AppModelGlobal.getApplication(this.strApplicationId);
    }
}

