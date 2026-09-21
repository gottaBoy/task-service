/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.EditableControlConfig;
import java.util.HashMap;

public abstract class BaseInputConfig
extends EditableControlConfig {
    public static final String TAG_VALUE = "VALUE";
    protected String strValue = "";

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_VALUE);
        if (strValue != null) {
            this.strValue = strValue;
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

