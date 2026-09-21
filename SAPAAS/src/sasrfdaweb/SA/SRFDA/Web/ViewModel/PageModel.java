/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.BaseViewModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PageModel
extends BaseViewModel {
    protected Hashtable<String, ControlModel> ctrlModelMap = null;
    protected String strBackendUrl = "";
    protected String strPageDataEntityId = "";
    protected String strHelpItem = "";
    protected String strImportMode = "";
    protected String strPageCode = "";
    protected String strUIPartCode = "";
    protected String strSLPart = "";
    protected HashMap<String, Boolean> privilegeMap = null;

    public String getBackendUrl() {
        return this.strBackendUrl;
    }

    public void setBackendUrl(String strBackendUrl) {
        this.strBackendUrl = strBackendUrl;
    }

    public String getPageDataEntityId() {
        return this.strPageDataEntityId;
    }

    public void setPageDataEntityId(String strPageDataEntityId) {
        this.strPageDataEntityId = strPageDataEntityId;
    }

    public String getHelpItem() {
        return this.strHelpItem;
    }

    public void setHelpItem(String strHelpItem) {
        this.strHelpItem = strHelpItem;
    }

    public String getImportMode() {
        return this.strImportMode;
    }

    public void setImportMode(String strImportMode) {
        this.strImportMode = strImportMode;
    }

    public boolean RegisterCtrlModel(String strKey, ControlModel ctrlModel) {
        if (this.ctrlModelMap == null) {
            this.ctrlModelMap = new Hashtable();
        }
        if (this.ctrlModelMap.containsKey(strKey)) {
            return false;
        }
        this.ctrlModelMap.put(strKey, ctrlModel);
        return true;
    }

    public ControlModel GetCtrlModel(String strKey) {
        if (this.ctrlModelMap == null) {
            return null;
        }
        if (this.ctrlModelMap.containsKey(strKey)) {
            return this.ctrlModelMap.get(strKey);
        }
        return null;
    }

    public Enumeration<String> GetCtrlModelNames() {
        if (this.ctrlModelMap == null) {
            return null;
        }
        return this.ctrlModelMap.keys();
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getPageDataEntityId())) {
            jo.put("pagedataentityid", (Object)this.getPageDataEntityId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getBackendUrl())) {
            jo.put("backendurl", (Object)this.getBackendUrl());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getHelpItem())) {
            jo.put("helpitem", (Object)this.getHelpItem());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getImportMode())) {
            jo.put("importmode", (Object)this.getImportMode());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPageCode())) {
            jo.put("pagecode", (Object)this.getPageCode());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUIPartCode())) {
            jo.put("uipartcode", (Object)this.getUIPartCode());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getSLUIPart())) {
            jo.put("sluipart", (Object)this.getSLUIPart());
        }
        if (this.ctrlModelMap != null) {
            JSONObject ctrlsJO = new JSONObject();
            for (String strKey : this.ctrlModelMap.keySet()) {
                ctrlsJO.put(strKey, (Object)this.ctrlModelMap.get(strKey).GetJSONObject());
            }
            jo.put("ctrls", (Object)ctrlsJO);
        }
        if (this.privilegeMap != null) {
            ArrayList<JSONObject> jsList = new ArrayList<JSONObject>();
            for (String strKey : this.privilegeMap.keySet()) {
                JSONObject item = new JSONObject();
                item.put("id", (Object)strKey);
                item.put("value", (Object)this.privilegeMap.get(strKey));
                jsList.add(item);
            }
            jo.put("privileges", (Object)JSONArray.fromArray((Object[])jsList.toArray()));
        }
    }

    public String getPageCode() {
        return this.strPageCode;
    }

    public void AppendPageCode(String strPageCode) {
        this.strPageCode = String.valueOf(this.strPageCode) + strPageCode;
    }

    public void setPageCode(String strPageCode) {
        this.strPageCode = strPageCode;
    }

    public String getUIPartCode() {
        return this.strUIPartCode;
    }

    public void setUIPartCode(String strUIPartCode) {
        this.strUIPartCode = strUIPartCode;
    }

    public void AppendUIPartCode(String strUIPartCode) {
        this.strUIPartCode = String.valueOf(this.strUIPartCode) + strUIPartCode;
    }

    public String toString() {
        JSONObject jo = new JSONObject();
        this.FillJSONObject(jo);
        return jo.toString();
    }

    public String getSLUIPart() {
        return this.strSLPart;
    }

    public void setSLUIPart(String strSLPart) {
        this.strSLPart = strSLPart;
    }

    public void RegisterPrivilege(String strResourceId, Boolean bResult) {
        if (this.privilegeMap == null) {
            this.privilegeMap = new HashMap();
        }
        this.privilegeMap.put(strResourceId, bResult);
    }
}

