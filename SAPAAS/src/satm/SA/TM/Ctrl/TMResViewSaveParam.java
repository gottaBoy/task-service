/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class TMResViewSaveParam {
    protected JSONObject jo = null;
    protected String strResources = "";

    public TMResViewSaveParam(String strValue) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            throw new Exception("\u4fdd\u5b58\u53c2\u6570\u65e0\u6548");
        }
        this.jo = JSONObject.fromString((String)strValue);
        if (this.jo == null) {
            throw new Exception("\u4fdd\u5b58\u53c2\u6570\u65e0\u6548");
        }
        this.strResources = this.jo.has("resources") ? this.jo.getString("resources") : "";
    }

    public String getResources() {
        return this.strResources;
    }
}

