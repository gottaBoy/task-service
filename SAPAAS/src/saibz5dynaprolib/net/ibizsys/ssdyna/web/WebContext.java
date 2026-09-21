/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.saas.web.WebContext
 */
package net.ibizsys.ssdyna.web;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.web.IDynaWebContext;

public class WebContext
extends net.ibizsys.saas.web.WebContext
implements IDynaWebContext {
    private static ThreadLocal<String> dynaSysInstId = new ThreadLocal();

    public static IDynaWebContext getDynaWebContext() throws Exception {
        return WebContext.getDynaWebContext(false);
    }

    public static IDynaWebContext getDynaWebContext(boolean bTryMode) throws Exception {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext != null && iWebContext instanceof IDynaWebContext) {
            return (IDynaWebContext)iWebContext;
        }
        if (!bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u7cfb\u7edf Web\u8bf7\u6c42\u4e0a\u4e0b\u6587\u5bf9\u8c61"));
        }
        return null;
    }

    public static String getDynaSysInstId(boolean bTryMode) throws Exception {
        String strDynaInstId = dynaSysInstId.get();
        if (!StringHelper.isNullOrEmpty((String)strDynaInstId)) {
            return strDynaInstId;
        }
        if (WebContext.getCurrent() != null) {
            strDynaInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent());
        }
        if (StringHelper.isNullOrEmpty((String)strDynaInstId) && !bTryMode) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u52a8\u6001\u5b9e\u4f8b\u6807\u8bc6");
        }
        return strDynaInstId;
    }

    public static void setDynaSysInstId(String strDynaInstId) {
        dynaSysInstId.set(strDynaInstId);
    }

    @Override
    public IDynaSysModel getDynaSysModel(boolean bTryMode) throws Exception {
        ISystemModel iSystemModel = this.getSystemModel();
        if (iSystemModel != null && iSystemModel instanceof IDynaSysModel) {
            return (IDynaSysModel)iSystemModel;
        }
        if (!bTryMode) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u52a8\u6001\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61");
        }
        return null;
    }
}

