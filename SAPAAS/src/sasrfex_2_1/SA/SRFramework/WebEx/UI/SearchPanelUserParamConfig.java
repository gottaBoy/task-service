/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;

public class SearchPanelUserParamConfig
extends XMLConfig {
    public static final String TAG_SPUSERPARAM = "SRFEXSPUSERPARAM";
    public static final String TAG_VALUE = "VALUE";
    protected SearchPanelConfig searchPanelConfig = null;
    protected String strValue = "";

    public SearchPanelUserParamConfig() {
    }

    public SearchPanelUserParamConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.strValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public String getValue() {
        return this.strValue;
    }
}

