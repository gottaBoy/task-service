/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.appmodel;

import java.util.Map;
import net.ibizsys.paas.appmodel.IAppPFHelper;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public abstract class AppPFHelperBase
implements IAppPFHelper {
    private IApplicationModel iApplicationModel = null;
    private String strImagesPath = "";

    @Override
    public void init(IApplicationModel iApplicationModel) throws Exception {
        this.iApplicationModel = iApplicationModel;
    }

    public IApplicationModel getAppModel() {
        return this.iApplicationModel;
    }

    public void setImagesPath(String strImagesPath) {
        this.strImagesPath = strImagesPath;
    }

    public String getImagesPath() {
        return this.strImagesPath;
    }

    @Override
    public JSONObject getAppViewJSONObject(IAppViewModel iAppViewModel) throws Exception {
        JSONObject jsonObj = new JSONObject();
        this.onFillAppViewJSONObject(iAppViewModel, jsonObj);
        return jsonObj;
    }

    protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
    }

    @Override
    public String mapRealUrl(String strUrl) throws Exception {
        if (StringHelper.isNullOrEmpty(strUrl)) {
            return strUrl;
        }
        if (strUrl.indexOf(47) == 0 || strUrl.indexOf("../") == 0 || strUrl.indexOf("://") != -1) {
            return strUrl;
        }
        return this.mapRealAppUrl(strUrl);
    }

    protected abstract String mapRealAppUrl(String var1) throws Exception;

    @Override
    public String mapImageRealUrl(String strImageUrl) throws Exception {
        if (StringHelper.isNullOrEmpty(strImageUrl)) {
            return strImageUrl;
        }
        if (strImageUrl.indexOf(47) == 0 || strImageUrl.indexOf("../") == 0 || strImageUrl.indexOf("://") != -1) {
            return strImageUrl;
        }
        return this.mapRealAppUrl(String.valueOf(this.getImagesPath()) + strImageUrl);
    }

    @Override
    public int getAppType() {
        return 0;
    }

    @Override
    public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

