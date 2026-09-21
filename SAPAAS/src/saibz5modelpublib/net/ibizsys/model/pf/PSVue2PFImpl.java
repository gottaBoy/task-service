/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRuntime
 *  net.ibizsys.model.pf.PSPFImpl
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 */
package net.ibizsys.model.pf;

import java.util.Map;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.pf.PSPFImpl;
import net.ibizsys.model.pub.vue2.PSVue2FileNameMethod;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;

public class PSVue2PFImpl
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
            return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), (Object)PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()), (Object)PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()), (Object)PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()));
        }
        return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), (Object)PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()), (Object)PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()), (Object)(String.valueOf(PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName())) + "/" + strUrlParams));
    }
}

