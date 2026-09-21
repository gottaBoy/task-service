/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.PF.PSPFImpl
 *  SA.SRFDA.PS.Data.PSAppModule
 *  SA.SRFDA.PS.Data.PSAppView
 *  SA.SRFDA.PS.Data.PSSubAppView
 *  SA.SRFDA.PS.Data.PSSysApp
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PF.PSPFImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2FileNameMethod;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.WebUtility;

public class PSVue2PFImpl
extends PSPFImpl {
    public void fillPSSubAppView(PSSubAppView psSubAppView, PSSysApp psSysApp, PSAppModule psAppModule, PSAppView psAppView) throws Exception {
        String strViewName = PSVue2FileNameMethod.replaceFullName(psAppView.getPSAPPVIEWNAME());
        String strPageUrl = StringHelper.Format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(psAppModule.getCODENAME()), (Object)strViewName, (Object)strViewName, (Object)strViewName).toLowerCase();
        psSubAppView.setPAGEURL(strPageUrl);
    }

    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        String strViewName = PSVue2FileNameMethod.replaceFullName(iPSAppView.getName());
        String strPageUrl = StringHelper.Format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), (Object)strViewName, (Object)strViewName, (Object)strViewName).toLowerCase();
        return strPageUrl;
    }

    public String getPSAppViewPageUrl(IPSAppView iPSAppView, Map<String, String> params) throws Exception {
        String strUrlParams = "";
        if (params != null && params.size() > 0) {
            HashMap<String, String> params2 = new HashMap<String, String>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                params2.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            strUrlParams = WebUtility.getQueryString(params2, (String)";");
        }
        String strViewName = PSVue2FileNameMethod.replaceFullName(iPSAppView.getName());
        String strPageUrl = String.valueOf(StringHelper.Format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s/", (Object)PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), (Object)strViewName, (Object)strViewName, (Object)strViewName).toLowerCase()) + strUrlParams;
        return strPageUrl;
    }
}

