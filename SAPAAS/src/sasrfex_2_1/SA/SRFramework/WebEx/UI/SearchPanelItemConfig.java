/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;

public class SearchPanelItemConfig
extends ControlPanelConfig {
    public static final String TAG_SPITEM = "SRFEXSPITEM";
    public static final String TAG_GROUPID = "GROUPID";
    public static final String TAG_SHOWDEFAULT = "SHOWDEFAULT";
    protected SearchPanelConfig searchPanelConfig = null;
    protected String strGroupId = "";
    protected boolean bShowDefault = true;

    public SearchPanelItemConfig() {
    }

    public SearchPanelItemConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWDEFAULT, (boolean)true) == 0) {
            this.bShowDefault = SearchPanelItemConfig.GetValue((String)strValue, (boolean)this.bShowDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPID, (boolean)true) == 0) {
            this.strGroupId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getShowDefault() {
        return this.bShowDefault;
    }

    public void setShowDefault(boolean bShowDefault) {
        this.bShowDefault = bShowDefault;
    }

    public String getGroupId() {
        return this.strGroupId;
    }

    public void setGroupId(String strGroupId) {
        this.strGroupId = strGroupId;
    }
}

