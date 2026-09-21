/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGExMacroParamConfig
extends XMLConfig {
    public static final String TAG_SRFEXDGEXMACROPARAM = "SRFEXDGEXMACROPARAM";
    public static final String TAG_NULLVALUE = "NULLVALUE";
    protected String strNullValue = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NULLVALUE, (boolean)true) == 0) {
            this.setNullValue(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getNullValue() {
        return this.strNullValue;
    }

    public void setNullValue(String strNullValue) {
        this.strNullValue = strNullValue;
    }
}

