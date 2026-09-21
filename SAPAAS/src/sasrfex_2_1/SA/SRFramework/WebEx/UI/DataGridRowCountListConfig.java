/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class DataGridRowCountListConfig
extends BaseControlConfig {
    public static final String TAG_DATAGRIDROWCOUNTLIST = "DATAGRIDROWCOUNTLIST";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_ACTIVEPAGESIZE = "ACTIVEPAGESIZE";
    protected String strDataGridId = "";
    protected boolean bShowCaption = false;
    protected String strCaption = "\u9009\u62e9";
    protected String strCaptionCssClass = "";
    protected int nActivePageSize = 20;

    public DataGridRowCountListConfig() {
        this.strCssClass = "sx-select";
        this.strCaptionCssClass = "sx-normaltext";
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAGRIDID, (boolean)true) == 0) {
            this.strDataGridId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWCAPTION, (boolean)true) == 0) {
            this.bShowCaption = DataGridRowCountListConfig.GetValue((String)strValue, (boolean)this.bShowCaption);
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
            this.nActivePageSize = DataGridRowCountListConfig.GetValue((String)strValue, (int)this.nActivePageSize);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setDataGridId(String strDataGridId) {
        this.strDataGridId = strDataGridId;
    }

    public String getDataGridId() {
        return this.strDataGridId;
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

