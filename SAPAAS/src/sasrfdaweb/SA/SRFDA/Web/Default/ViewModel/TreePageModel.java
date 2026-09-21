/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.TreePanelModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class TreePageModel
extends MainViewModel {
    protected TreePanelModel treePanelModel = new TreePanelModel();
    protected String strTreeDefaultUrl = "";

    public TreePageModel() {
        this.RegisterCtrlModel("treepanel", this.treePanelModel);
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getDefaultUrl())) {
            jo.put("defaulturl", (Object)this.getDefaultUrl());
        }
    }

    public TreePanelModel getTreePanelModel() {
        return this.treePanelModel;
    }

    public String getDefaultUrl() {
        return this.strTreeDefaultUrl;
    }

    public void setDefaultUrl(String strTreeDefaultUrl) {
        this.strTreeDefaultUrl = strTreeDefaultUrl;
    }
}

