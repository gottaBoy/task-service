/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppPFHelperBase
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.appmodel.ionic;

import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class Ionic4R6AppPFHelper
extends AppPFHelperBase {
    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
        String EMTPY = null;
        jsonObj.put("viewmodule", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getModuleName())));
        jsonObj.put("viewtag", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getId())));
        jsonObj.put("viewname", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getName())));
        jsonObj.put("title", JSONObjectHelper.stripQuotes((String)iAppViewModel.getTitle()));
        jsonObj.put("url", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s_%2$s", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase()));
        jsonObj.put("className", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getName())));
        jsonObj.put("viewparams", JSONObjectHelper.stripQuotes(EMTPY));
        if (!StringHelper.isNullOrEmpty((Object)iAppViewModel.getWidth())) {
            jsonObj.put("width", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getWidth())));
        } else {
            jsonObj.put("width", (Object)"0");
        }
        if (!StringHelper.isNullOrEmpty((Object)iAppViewModel.getHeight())) {
            jsonObj.put("height", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s", (Object)iAppViewModel.getHeight())));
        } else {
            jsonObj.put("height", (Object)"0");
        }
        if (!StringHelper.isNullOrEmpty((String)iAppViewModel.getOpenMode())) {
            jsonObj.put("openMode", JSONObjectHelper.stripQuotes((String)iAppViewModel.getOpenMode()));
        }
    }

    protected String mapRealAppUrl(String strUrl) throws Exception {
        return "../../" + strUrl;
    }

    public int getAppType() {
        return 2;
    }

    public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
        return StringHelper.format((String)"%1$s", (Object)iAppViewModel.getName());
    }
}

