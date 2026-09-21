/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class DGModel
extends ControlModel {
    protected boolean bItemPrivilege = false;
    protected String strThemeId = "";
    protected String strThemeModel = "";
    protected boolean bHideDERColumn = true;
    protected String strDERColumnName = "";
    protected int nSummaryHeight = 0;
    protected String strFIUpdateMode = "";
    protected boolean bEditable = false;

    public boolean getItemPrivilege() {
        return this.bItemPrivilege;
    }

    public void setItemPrivilege(boolean bItemPrivilege) {
        this.bItemPrivilege = bItemPrivilege;
    }

    public String getThemeId() {
        return this.strThemeId;
    }

    public void setThemeId(String strThemeId) {
        this.strThemeId = strThemeId;
    }

    public String getThemeModel() {
        return this.strThemeModel;
    }

    public void setThemeModel(String strThemeModel) {
        this.strThemeModel = strThemeModel;
    }

    public boolean getHideDERColumn() {
        return this.bHideDERColumn;
    }

    public void setHideDERColumn(boolean bHideDERColumn) {
        this.bHideDERColumn = bHideDERColumn;
    }

    public String getDERColumnName() {
        return this.strDERColumnName;
    }

    public void setDERColumnName(String strDERColumnName) {
        this.strDERColumnName = strDERColumnName;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getItemPrivilege()) {
            jo.put("itemprivilege", this.getItemPrivilege());
        }
        jo.put("hidedercolumn", this.getHideDERColumn());
        if (this.getHideDERColumn()) {
            jo.put("dercolumnname", (Object)this.getDERColumnName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getThemeId())) {
            jo.put("themeid", (Object)this.getThemeId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getThemeModel())) {
            jo.put("thememodel", (Object)this.getThemeModel());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFIUpdateMode())) {
            jo.put("fiupdatemode", (Object)this.getFIUpdateMode());
        }
        if (this.getSummaryHeight() > 0) {
            jo.put("summaryheight", this.getSummaryHeight());
        }
        if (this.getEditable()) {
            jo.put("editable", this.getEditable());
        }
    }

    public int getSummaryHeight() {
        return this.nSummaryHeight;
    }

    public void setSummaryHeight(int nSummaryHeight) {
        this.nSummaryHeight = nSummaryHeight;
    }

    public String getFIUpdateMode() {
        return this.strFIUpdateMode;
    }

    public void setFIUpdateMode(String strFIUpdateMode) {
        this.strFIUpdateMode = strFIUpdateMode;
    }

    public boolean getEditable() {
        return this.bEditable;
    }

    public void setEditable(boolean bEditable) {
        this.bEditable = bEditable;
    }
}

