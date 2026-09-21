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

public class ValueTransformConfig
extends XMLConfig {
    public static final String TAG_VALUETRANSFORM = "SRFEXVALUETRANSFORM";
    public static final String TAG_TYPE = "TYPE";
    protected String strType = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TYPE, (boolean)true) == 0) {
            this.strType = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }
}

