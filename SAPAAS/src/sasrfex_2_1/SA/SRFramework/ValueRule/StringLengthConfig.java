/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class StringLengthConfig
extends XMLConfig {
    public static final String TAG_STRINGLENGTH = "SRFEXSTRINGLENGTH";
    public static final String TAG_VALUE = "VALUE";
    protected int nValue = 0;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.nValue = StringLengthConfig.GetValue((String)strValue, (int)this.nValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getValue() {
        return this.nValue;
    }

    public void setValue(int nValue) {
        this.nValue = nValue;
    }
}

