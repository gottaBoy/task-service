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

public class SearchPanelGroupConfig
extends XMLConfig {
    public static final String TAG_SPGROUP = "SRFEXSPGROUP";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_DEFAULT = "DEFAULT";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected SearchPanelConfig searchPanelConfig = null;
    protected boolean bDefault = false;

    public SearchPanelGroupConfig() {
    }

    public SearchPanelGroupConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULT, (boolean)true) == 0) {
            this.bDefault = SearchPanelGroupConfig.GetValue((String)strValue, (boolean)this.bDefault);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setDefault(boolean bDefault) {
        this.bDefault = bDefault;
    }

    public boolean getDefault() {
        return this.bDefault;
    }
}

