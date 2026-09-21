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
package net.ibizsys.paas.appmodel.vue;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.sf.json.JSONObject;

public class VueAppPFHelper
extends AppPFHelperBase {
    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
        jsonObj.put("viewurl", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s_%2$s", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase()));
        jsonObj.put("modulename", (Object)iAppViewModel.getModuleName());
        jsonObj.put("viewtag", (Object)iAppViewModel.getId());
        jsonObj.put("viewname", (Object)iAppViewModel.getName());
        jsonObj.put("title", JSONObjectHelper.stripQuotes((String)iAppViewModel.getTitle()));
        jsonObj.put("width", iAppViewModel.getWidth());
        jsonObj.put("height", iAppViewModel.getHeight());
        String openmode = "";
        if (!StringHelper.isNullOrEmpty((String)iAppViewModel.getOpenMode())) {
            jsonObj.put("openMode", JSONObjectHelper.stripQuotes((String)iAppViewModel.getOpenMode()));
            openmode = JSONObjectHelper.stripQuotes((String)iAppViewModel.getOpenMode()).toString();
        }
        jsonObj.put("openmode", (Object)openmode);
    }

    protected String mapRealAppUrl(String strUrl) throws Exception {
        return "../../" + strUrl;
    }

    public int getAppType() {
        return 1;
    }

    public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
        return StringHelper.format((String)"%1$s_%2$s", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase();
    }

    public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
        String strUrlParams = "";
        if (params != null && params.size() > 0) {
            HashMap<String, String> params2 = new HashMap<String, String>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                params2.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            strUrlParams = WebUtility.getQueryString(params2, (String)";");
        }
        if (StringHelper.isNullOrEmpty((String)strUrlParams)) {
            return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getModuleName()), (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getName()), (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getName()), (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getName()));
        }
        return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getModuleName()), (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getName()), (Object)VueAppPFHelper.replaceFullName(iAppViewModel.getName()), (Object)(String.valueOf(VueAppPFHelper.replaceFullName(iAppViewModel.getName())) + "/" + strUrlParams));
    }

    public static String replaceFullName(String strFullName) {
        strFullName = strFullName.replaceAll("_", "-");
        boolean state = false;
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
        if (Character.isUpperCase(str.charAt(0))) {
            strBuilder.append(str.substring(0, 1).toLowerCase());
            state = true;
        } else {
            strBuilder.append(str.substring(0, 1));
            state = false;
        }
        int i = 1;
        while (i < str.length()) {
            char chr = str.charAt(i);
            if (Character.isUpperCase(chr)) {
                if (state) {
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                } else {
                    strBuilder.append("-");
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                }
                state = true;
            } else {
                strBuilder.append(chr);
                state = false;
            }
            ++i;
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
        return resultStr;
    }
}

