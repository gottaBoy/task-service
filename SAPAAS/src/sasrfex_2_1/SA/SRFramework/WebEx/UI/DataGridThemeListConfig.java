/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeGroupsConfig;
import org.w3c.dom.Node;

public class DataGridThemeListConfig
extends BaseControlConfig {
    public static final String TAG_DATAGRIDTHEMELIST = "DATAGRIDTHEMELIST";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_MGRJSCODE = "MGRJSCODE";
    public static final String TAG_CUSTOMTHEME = "CUSTOMTHEME";
    protected String strDataGridId = "";
    protected boolean bShowCaption = false;
    protected String strCaption = "\u9009\u62e9";
    protected String strCaptionCssClass = "";
    protected String strMgrJSCode = "";
    protected boolean bCustomTheme = true;
    protected DataGridThemeGroupsConfig dataGridThemeGroupsConfig = new DataGridThemeGroupsConfig();

    public DataGridThemeListConfig() {
        this.strCssClass = "sx-select";
        this.strCaptionCssClass = "sx-normaltext";
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAGRIDID, (boolean)true) == 0) {
            this.strDataGridId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWCAPTION, (boolean)true) == 0) {
            this.bShowCaption = DataGridThemeListConfig.GetValue((String)strValue, (boolean)this.bShowCaption);
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
        if (StringHelper.Compare((String)strName, (String)TAG_MGRJSCODE, (boolean)true) == 0) {
            this.strMgrJSCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOMTHEME, (boolean)true) == 0) {
            this.bCustomTheme = DataGridThemeListConfig.GetValue((String)strValue, (boolean)this.bCustomTheme);
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

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"DATAGRIDTHEMEGROUPS", (boolean)true) == 0) {
            this.dataGridThemeGroupsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DataGridThemeGroupsConfig GetDataGridThemeGroupsConfig() {
        return this.dataGridThemeGroupsConfig;
    }

    public String getMgrJSCode() {
        return this.strMgrJSCode;
    }

    public void setMgrJSCode(String strMgrJSCode) {
        this.strMgrJSCode = strMgrJSCode;
    }

    public boolean isCustomTheme() {
        return this.bCustomTheme;
    }

    public void setCustomTheme(boolean bCustomTheme) {
        this.bCustomTheme = bCustomTheme;
    }
}

