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

public class SPExModel
extends ControlModel {
    protected boolean bItemPrivilege = false;
    protected boolean bSaveLoad = false;
    protected boolean bCustomSearch = false;
    protected String strSaveLoadTag = "";

    public boolean getItemPrivilege() {
        return this.bItemPrivilege;
    }

    public void setItemPrivilege(boolean bItemPrivilege) {
        this.bItemPrivilege = bItemPrivilege;
    }

    public boolean getSaveLoad() {
        return this.bSaveLoad;
    }

    public void setSaveLoad(boolean bSaveLoad) {
        this.bSaveLoad = bSaveLoad;
    }

    public boolean getCustomSearch() {
        return this.bCustomSearch;
    }

    public void setCustomSearch(boolean bCustomSearch) {
        this.bCustomSearch = bCustomSearch;
    }

    public String getSaveLoadTag() {
        return this.strSaveLoadTag;
    }

    public void setSaveLoadTag(String strSaveLoadTag) {
        this.strSaveLoadTag = strSaveLoadTag;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getItemPrivilege()) {
            jo.put("itemprivilege", this.getItemPrivilege());
        }
        if (this.getSaveLoad()) {
            jo.put("saveload", this.getSaveLoad());
        }
        if (this.getCustomSearch()) {
            jo.put("customsearch", this.getCustomSearch());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getSaveLoadTag())) {
            jo.put("saveloadtag", (Object)this.getSaveLoadTag());
        }
    }
}

