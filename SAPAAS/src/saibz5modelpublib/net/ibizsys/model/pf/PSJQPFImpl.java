/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.pf.PSPFImpl
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 */
package net.ibizsys.model.pf;

import java.util.Map;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.pf.PSPFImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;

public class PSJQPFImpl
extends PSPFImpl {
    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        String strPageUrl = StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getName()).toLowerCase();
        return strPageUrl;
    }

    public String getPSAppViewPageUrl(IPSAppView iPSAppView, Map<String, String> params) throws Exception {
        String strUrlParams = "";
        if (params != null) {
            strUrlParams = WebUtility.getQueryString(params);
        }
        if (StringHelper.isNullOrEmpty((String)strUrlParams)) {
            return StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getName()).toLowerCase();
        }
        return String.valueOf(StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getName()).toLowerCase()) + "?" + strUrlParams;
    }
}

