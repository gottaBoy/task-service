/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NavFrameViewModel
extends MainViewModel {
    protected TabViewModel tabViewModel = new TabViewModel();
    protected Vector panelList = null;

    public NavFrameViewModel() {
        this.RegisterCtrlModel("tabview", this.tabViewModel);
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getPanelList() != null) {
            jo.put("panels", (Object)JSONArray.fromArray((Object[])this.getPanelList().toArray()));
        }
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }

    public Vector getPanelList() {
        return this.panelList;
    }

    public void setPanelList(Vector panelList) {
        this.panelList = panelList;
    }
}

