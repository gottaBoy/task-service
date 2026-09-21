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
package net.ibizsys.paas.appmodel.react;

import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class ReactMobAppPFHelper
extends AppPFHelperBase {
    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
        jsonObj.put("viewurl", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s_%2$s", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase()));
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
        return 2;
    }

    public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
        return StringHelper.format((String)"%1$s_%2$s", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase();
    }
}

