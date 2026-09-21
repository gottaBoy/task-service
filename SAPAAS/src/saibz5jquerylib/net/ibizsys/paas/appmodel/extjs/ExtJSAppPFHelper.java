/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppPFHelperBase
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.appmodel.extjs;

import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class ExtJSAppPFHelper
extends AppPFHelperBase {
    public void init(IApplicationModel iApplicationModel) throws Exception {
        super.init(iApplicationModel);
        this.setImagesPath("resources/images/");
    }

    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
        jsonObj.put("view", JSONObjectHelper.stripQuotes((String)StringHelper.format((String)"%1$s.view.%2$s.%3$s", (Object)this.getAppModel().getName(), (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName())));
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
        return strUrl;
    }

    public int getAppType() {
        return 1;
    }

    public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
        return StringHelper.format((String)"%1$s.view.%2$s.%3$s", (Object)this.getAppModel().getName(), (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName());
    }
}

