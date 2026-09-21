/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.Model;

import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public abstract class BaseBIObjectModel {
    private String strId = "";
    private String strCaption = "";
    private String strName = "";
    private String strUniqueName = "";

    public String getId() {
        return this.strId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public JSONObject ToJSONObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        this.OnFillJSONObject(jsonObject);
        return jsonObject;
    }

    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.getId())) {
            jsonObject.put("id", (Object)this.getId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getName())) {
            jsonObject.put("name", (Object)this.getName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            jsonObject.put("caption", (Object)this.getCaption());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUniqueName())) {
            jsonObject.put("uniquename", (Object)this.getUniqueName());
        }
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getUniqueName() {
        return this.strUniqueName;
    }

    public void setUniqueName(String strUniqueName) {
        this.strUniqueName = strUniqueName;
    }
}

