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

public class DataGridThemeConfig
extends XMLConfig {
    public static final String TAG_DATAGRIDTHEME = "DATAGRIDTHEME";
    public static final String TAG_THEMENAME = "THEMENAME";
    public static final String TAG_ACTIVE = "ACTIVE";
    public static final String TAG_URL = "URL";
    protected String strThemeName = "";
    protected boolean bActive = false;
    protected String strURL = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_THEMENAME, (boolean)true) == 0) {
            this.strThemeName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_URL, (boolean)true) == 0) {
            this.strURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIVE, (boolean)true) == 0) {
            this.bActive = DataGridThemeConfig.GetValue((String)strValue, (boolean)this.bActive);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getThemeName() {
        return this.strThemeName;
    }

    public void setThemeName(String strThemeName) {
        this.strThemeName = strThemeName;
    }

    public boolean isActive() {
        return this.bActive;
    }

    public void setActive(boolean active) {
        this.bActive = active;
    }

    public String getURL() {
        return this.strURL;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }
}

