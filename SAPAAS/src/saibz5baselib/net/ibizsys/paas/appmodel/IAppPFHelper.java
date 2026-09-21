/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.appmodel;

import java.util.Map;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.sf.json.JSONObject;

public interface IAppPFHelper {
    public void init(IApplicationModel var1) throws Exception;

    public JSONObject getAppViewJSONObject(IAppViewModel var1) throws Exception;

    public String mapRealUrl(String var1) throws Exception;

    public String mapImageRealUrl(String var1) throws Exception;

    public int getAppType();

    public String getAppViewTag(IAppViewModel var1) throws Exception;

    public String getAppViewUrl(IAppViewModel var1, Map<String, String> var2) throws Exception;
}

