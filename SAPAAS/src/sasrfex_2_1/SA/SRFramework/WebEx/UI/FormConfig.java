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

public class FormConfig
extends XMLConfig {
    public static final String TAG_FORM = "SRFFORM";
    public static final String TAG_FORMID = "FORMID";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FORMID, (boolean)true) == 0) {
            this.setID(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

