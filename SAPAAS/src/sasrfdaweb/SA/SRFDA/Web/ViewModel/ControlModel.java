/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.BaseViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class ControlModel
extends BaseViewModel {
    protected String strConfigId = "";
    protected String strCtrlId = "";
    protected String strRemoteCtrlId = "";
    protected String strBackendUrl = "";
    protected boolean bVisible = true;

    public String getConfigId() {
        return this.strConfigId;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public String getRemoteCtrlId() {
        return this.strRemoteCtrlId;
    }

    public void setConfigId(String strConfigId) {
        this.strConfigId = strConfigId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public void setRemoteCtrlId(String strRemoteCtrlId) {
        this.strRemoteCtrlId = strRemoteCtrlId;
    }

    public String getBackendUrl() {
        return this.strBackendUrl;
    }

    public void setBackendUrl(String strBackendUrl) {
        this.strBackendUrl = strBackendUrl;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getConfigId())) {
            jo.put("configid", (Object)this.getConfigId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCtrlId())) {
            jo.put("ctrlid", (Object)this.getCtrlId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRemoteCtrlId())) {
            jo.put("remotectrlid", (Object)this.getRemoteCtrlId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getBackendUrl())) {
            jo.put("backendurl", (Object)this.getBackendUrl());
        }
        if (!this.isVisible()) {
            jo.put("visible", this.isVisible());
        }
    }

    public boolean isVisible() {
        return this.bVisible;
    }

    public void setVisible(boolean bVisible) {
        this.bVisible = bVisible;
    }
}

