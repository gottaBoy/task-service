/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

import SA.SRFramework.Base.XMLConfig;
import java.util.HashMap;

public class PropertyConfig
extends XMLConfig {
    public static final String TAG_PROPERTY = "SRFPROPERTY";
    public static final String TAG_VALUE = "VALUE";
    protected String strValue = "";

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = attrMap.remove(TAG_VALUE);
        if (strValue != null) {
            this.setValue(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }
}

