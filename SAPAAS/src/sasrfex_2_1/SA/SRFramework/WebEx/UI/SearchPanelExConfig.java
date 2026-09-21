/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;

public class SearchPanelExConfig
extends SearchPanelConfig {
    public static final String TAG_SEARCHPANELEX = "SRFEXSEARCHPANELEX";
    public static final String TAG_SEARCHONREADY = "SEARCHONREADY";
    protected boolean bSearchOnReady = true;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SEARCHONREADY, (boolean)true) == 0) {
            this.bSearchOnReady = SearchPanelExConfig.GetValue((String)strValue, (boolean)this.bSearchOnReady);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setSearchOnReady(boolean bSearchOnReady) {
        this.bSearchOnReady = bSearchOnReady;
    }

    public boolean getSearchOnReady() {
        return this.bSearchOnReady;
    }
}

