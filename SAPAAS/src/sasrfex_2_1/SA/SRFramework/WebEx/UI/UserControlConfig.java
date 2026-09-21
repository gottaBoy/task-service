/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FormControlConfig;

public class UserControlConfig
extends FormControlConfig {
    public static final String TAG_USERCONTROL = "SRFEXUSERCONTROL";
    public static final String TAG_USERCONTROLEX = "SRFEXUSERCONTROLEX";
    public static final String TAG_TAGNAME = "TAGNAME";
    public static final String TAG_CONFIG = "CONFIG";
    protected String strTagName = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TAGNAME, (boolean)true) == 0) {
            this.strTagName = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getTagName() {
        return this.strTagName;
    }

    public void setTagName(String value) {
        this.strTagName = value;
    }
}

