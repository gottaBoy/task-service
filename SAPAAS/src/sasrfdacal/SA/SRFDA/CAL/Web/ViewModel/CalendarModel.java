/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class CalendarModel
extends ControlModel {
    protected int nStartHour = 0;
    protected String strGroup = "";
    protected String strDataPath = "";
    protected String strInitView = "";

    public int getStartHour() {
        return this.nStartHour;
    }

    public void setStartHour(int nStartHour) {
        this.nStartHour = nStartHour;
    }

    public String getGroup() {
        return this.strGroup;
    }

    public void setGroup(String strGroup) {
        this.strGroup = strGroup;
    }

    public String getInitView() {
        return this.strInitView;
    }

    public void setInitView(String strInitView) {
        this.strInitView = strInitView;
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getInitView())) {
            jo.put("initview", (Object)this.getInitView());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getGroup())) {
            jo.put("group", (Object)this.getGroup());
        }
        if (this.getStartHour() > 0) {
            jo.put("starthour", this.getStartHour());
        }
    }
}

