/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseInputConfig;

public class CheckBoxConfig
extends BaseInputConfig {
    public static final String TAG_CHECKBOX = "SRFEXCHECKBOX";
    public static final String TAG_CHECKED = "CHECKED";
    public static final String TAG_UNCHECKVALUE = "UNCHECKVALUE";
    protected boolean bChecked = false;
    protected String strUncheckValue = "0";

    public CheckBoxConfig() {
        this.setValue("1");
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CHECKED, (boolean)true) == 0) {
            this.bChecked = CheckBoxConfig.GetValue((String)strValue, (boolean)this.bChecked);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UNCHECKVALUE, (boolean)true) == 0) {
            this.strUncheckValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getChecked() {
        return this.bChecked;
    }

    public void setChecked(boolean bChecked) {
        this.bChecked = bChecked;
    }

    public String getUncheckValue() {
        return this.strUncheckValue;
    }

    public void setUncheckValue(String strUncheckValue) {
        this.strUncheckValue = strUncheckValue;
    }
}

