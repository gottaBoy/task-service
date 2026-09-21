/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppPFHelperBase
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.appmodel.jquery;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.sf.json.JSONObject;

public class JQAppPFHelper
extends AppPFHelperBase {
    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
        jsonObj.put("viewurl", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase()));
        if (iAppViewModel.getWidth() > 0) {
            jsonObj.put("width", iAppViewModel.getWidth());
        }
        if (iAppViewModel.getHeight() > 0) {
            jsonObj.put("height", iAppViewModel.getHeight());
        }
        jsonObj.put("title", JSONObjectHelper.stripQuotes((String)iAppViewModel.getTitle()));
        if (!StringHelper.isNullOrEmpty((String)iAppViewModel.getOpenMode())) {
            jsonObj.put("openMode", JSONObjectHelper.stripQuotes((String)iAppViewModel.getOpenMode()));
        }
    }

    protected String mapRealAppUrl(String strUrl) throws Exception {
        return "../../" + strUrl;
    }

    public int getAppType() {
        return 1;
    }

    public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
        return StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iAppViewModel.getModuleName().toLowerCase(), (Object)iAppViewModel.getName()).toLowerCase();
    }

    public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
        String strUrlParams = "";
        if (params != null && params.size() > 0) {
            HashMap<String, String> params2 = new HashMap<String, String>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                params2.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            strUrlParams = WebUtility.getQueryString(params2);
        }
        if (StringHelper.isNullOrEmpty((String)strUrlParams)) {
            return StringHelper.format((String)"/jsp/%1$s/%2$s.jsp?", (Object)iAppViewModel.getModuleName().toLowerCase(), (Object)iAppViewModel.getName().toLowerCase());
        }
        return StringHelper.format((String)"/jsp/%1$s/%2$s.jsp?%3$s", (Object)iAppViewModel.getModuleName().toLowerCase(), (Object)iAppViewModel.getName().toLowerCase(), (Object)strUrlParams);
    }
}

