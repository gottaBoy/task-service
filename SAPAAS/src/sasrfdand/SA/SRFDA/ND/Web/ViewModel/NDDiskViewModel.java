/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.TreePageModel
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.TabViewModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class NDDiskViewModel
extends TreePageModel {
    protected TabViewModel tabViewModel = new TabViewModel();
    protected String strNDDiskId = "";
    protected String strNDDiskName = "";
    protected String strFolderBrowserViewUrl = "";

    public NDDiskViewModel() {
        this.RegisterCtrlModel("tabview", (ControlModel)this.tabViewModel);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getNDDiskId())) {
            jo.put("nddiskid", (Object)this.getNDDiskId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getNDDiskName())) {
            jo.put("nddiskname", (Object)this.getNDDiskName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFolderBrowserViewUrl())) {
            jo.put("folderbrowserviewurl", (Object)this.getFolderBrowserViewUrl());
        }
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }

    public void setNDDiskId(String strNDDiskId) {
        this.strNDDiskId = strNDDiskId;
    }

    public String getNDDiskId() {
        return this.strNDDiskId;
    }

    public void setNDDiskName(String strNDDiskName) {
        this.strNDDiskName = strNDDiskName;
    }

    public String getNDDiskName() {
        return this.strNDDiskName;
    }

    public String getFolderBrowserViewUrl() {
        return this.strFolderBrowserViewUrl;
    }

    public void setFolderBrowserViewUrl(String strFolderBrowserViewUrl) {
        this.strFolderBrowserViewUrl = strFolderBrowserViewUrl;
    }
}

