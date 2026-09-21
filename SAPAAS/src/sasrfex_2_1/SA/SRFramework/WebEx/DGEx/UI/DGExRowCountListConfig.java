/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class DGExRowCountListConfig
extends BaseControlConfig {
    public static final String TAG_DGEXROWCOUNTLIST = "DGEXROWCOUNTLIST";
    public static final String TAG_DGEXID = "DGEXID";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_ACTIVEPAGESIZE = "ACTIVEPAGESIZE";
    protected String strDGExId = "";
    protected boolean bShowCaption = false;
    protected String strCaption = "\u9009\u62e9";
    protected String strCaptionCssClass = "";
    protected int nActivePageSize = 20;

    public DGExRowCountListConfig() {
        this.strCssClass = "sx-select";
        this.strCaptionCssClass = "sx-normaltext";
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DGEXID, (boolean)true) == 0) {
            this.strDGExId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWCAPTION, (boolean)true) == 0) {
            this.bShowCaption = DGExRowCountListConfig.GetValue((String)strValue, (boolean)this.bShowCaption);
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
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIVEPAGESIZE, (boolean)true) == 0) {
            this.nActivePageSize = DGExRowCountListConfig.GetValue((String)strValue, (int)this.nActivePageSize);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setDGExId(String strDGExId) {
        this.strDGExId = strDGExId;
    }

    public String getDGExId() {
        return this.strDGExId;
    }

    public boolean getShowCaption() {
        return this.bShowCaption;
    }

    public void setShowCaption(boolean bShowCaption) {
        this.bShowCaption = bShowCaption;
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

    public int getActivePageSize() {
        return this.nActivePageSize;
    }

    public void setActivePageSize(int activePageSize) {
        this.nActivePageSize = activePageSize;
    }
}

