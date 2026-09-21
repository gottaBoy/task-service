/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class SearchBarConfig
extends BaseControlConfig {
    public static final String TAG_SEARCHBAR = "SRFEXSEARCHBAR";
    public static final String TAG_SUPPORTCUSTOM = "SUPPORTCUSTOM";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_JSNAME = "JSNAME";
    public static final String TAG_SEARCHONREADY = "SEARCHONREADY";
    public static final String TAG_SMALLMODE = "SMALLMODE";
    public static final String TAG_SPEXPAND = "SPEXPAND";
    protected String strText = "\u641c\u7d22\u4e3b\u9898";
    protected boolean bSupportCustom = true;
    protected boolean bSearchOnReady = true;
    protected boolean bSmallMode = false;
    protected boolean bSPExpand = true;

    public SearchBarConfig() {
        this.setCssClass("sx-searchbar");
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SUPPORTCUSTOM, (boolean)true) == 0) {
            this.bSupportCustom = SearchBarConfig.GetValue((String)strValue, (boolean)this.bSupportCustom);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SEARCHONREADY, (boolean)true) == 0) {
            this.bSearchOnReady = SearchBarConfig.GetValue((String)strValue, (boolean)this.bSearchOnReady);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SMALLMODE, (boolean)true) == 0) {
            this.bSmallMode = SearchBarConfig.GetValue((String)strValue, (boolean)this.bSmallMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SPEXPAND, (boolean)true) == 0) {
            this.bSPExpand = SearchBarConfig.GetValue((String)strValue, (boolean)this.bSPExpand);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getText() {
        return this.strText;
    }

    public void setSupportCustom(boolean bSupportCustom) {
        this.bSupportCustom = bSupportCustom;
    }

    public boolean getSupportCustom() {
        return this.bSupportCustom;
    }

    public void setSearchOnReady(boolean bSearchOnReady) {
        this.bSearchOnReady = bSearchOnReady;
    }

    public boolean getSearchOnReady() {
        return this.bSearchOnReady;
    }

    public void setSmallMode(boolean bSmallMode) {
        this.bSmallMode = bSmallMode;
    }

    public boolean getSmallMode() {
        return this.bSmallMode;
    }

    public boolean isSPExpand() {
        return this.bSPExpand;
    }

    public void setSPExpand(boolean expand) {
        this.bSPExpand = expand;
    }
}

