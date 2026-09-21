/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class MenuTreeGridViewModel
extends TreePageModel {
    protected String strTreeName = "";
    protected String strMenuMode = "";
    protected TabViewModel tabViewModel = new TabViewModel();

    public MenuTreeGridViewModel() {
        this.RegisterCtrlModel("tabview", this.tabViewModel);
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getTreeName())) {
            jo.put("treename", (Object)this.getTreeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMenuMode())) {
            jo.put("menumode", (Object)this.getMenuMode());
        }
    }

    public String getTreeName() {
        return this.strTreeName;
    }

    public void setTreeName(String strTreeName) {
        this.strTreeName = strTreeName;
    }

    public String getMenuMode() {
        return this.strMenuMode;
    }

    public void setMenuMode(String strMenuMode) {
        this.strMenuMode = strMenuMode;
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }
}

