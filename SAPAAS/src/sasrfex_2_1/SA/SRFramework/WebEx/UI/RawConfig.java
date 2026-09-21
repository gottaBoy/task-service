/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FormControlConfig;

public class RawConfig
extends FormControlConfig {
    public static final String TAG_RAW = "SRFEXRAW";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_DIV = "DIV";
    protected String strText = "";
    protected boolean bDiv = true;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIV, (boolean)true) == 0) {
            this.bDiv = RawConfig.GetValue((String)strValue, (boolean)this.bDiv);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String value) {
        this.strText = value;
    }

    public boolean getDiv() {
        return this.bDiv;
    }

    public void setDiv(boolean bDiv) {
        this.bDiv = bDiv;
    }
}

