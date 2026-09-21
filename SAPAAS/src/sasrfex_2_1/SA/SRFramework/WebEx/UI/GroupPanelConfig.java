/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.PanelConfig;

public class GroupPanelConfig
extends PanelConfig {
    public static final String TAG_GROUPPANEL = "SRFEXGROUPPANEL";
    public static final String TAG_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    protected boolean bShowCaptionBar = false;
    protected String strCaption = "";
    protected String strCaptionCssClass = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWCAPTIONBAR, (boolean)true) == 0) {
            this.bShowCaptionBar = GroupPanelConfig.GetValue((String)strValue, (boolean)this.bShowCaptionBar);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getShowCaptionBar() {
        return this.bShowCaptionBar;
    }

    public void setShowCaptionBar(boolean bShowCaptionBar) {
        this.bShowCaptionBar = bShowCaptionBar;
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
}

