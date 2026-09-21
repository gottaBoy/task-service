/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.GridViewModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.GridViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class NDFolderViewModel
extends GridViewModel {
    private String strRootPath = "";
    private String strRootFSOId = "";
    private String strFolderPath = "";
    private String strViewMode = "";

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getRootPath())) {
            jo.put("rootpath", (Object)this.getRootPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRootFSOId())) {
            jo.put("rootfsoid", (Object)this.getRootFSOId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFolderPath())) {
            jo.put("folderpath", (Object)this.getFolderPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getViewMode())) {
            jo.put("viewmode", (Object)this.getViewMode());
        }
    }

    public String getRootPath() {
        return this.strRootPath;
    }

    public void setRootPath(String strRootPath) {
        this.strRootPath = strRootPath;
    }

    public String getRootFSOId() {
        return this.strRootFSOId;
    }

    public void setRootFSOId(String strRootFSOId) {
        this.strRootFSOId = strRootFSOId;
    }

    public String getFolderPath() {
        return this.strFolderPath;
    }

    public void setFolderPath(String strFolderPath) {
        this.strFolderPath = strFolderPath;
    }

    public String getViewMode() {
        return this.strViewMode;
    }

    public void setViewMode(String strViewMode) {
        this.strViewMode = strViewMode;
    }
}

