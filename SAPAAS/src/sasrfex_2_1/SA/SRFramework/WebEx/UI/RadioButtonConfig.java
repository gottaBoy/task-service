/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseInputConfig;

public class RadioButtonConfig
extends BaseInputConfig {
    public static final String TAG_RADIOBUTTON = "SRFEXRADIOBUTTON";
    public static final String TAG_CHECKED = "CHECKED";
    protected boolean bChecked = false;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CHECKED, (boolean)true) == 0) {
            this.bChecked = RadioButtonConfig.GetValue((String)TAG_CHECKED, (boolean)this.bChecked);
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
}

