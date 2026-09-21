/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseButtonConfig;

public class ButtonConfig
extends BaseButtonConfig {
    public static final String TAG_BUTTON = "SRFEXBUTTON";
    public static final String TAG_JSCODE = "JSCODE";
    protected String strJSCode = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_JSCODE, (boolean)true) == 0) {
            this.strJSCode = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }
}

