/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.FormControlConfig;
import java.util.HashMap;

public abstract class EditableControlConfig
extends FormControlConfig {
    public static final String TAG_READONLY = "READONLY";
    protected boolean bReadOnly = false;

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_READONLY);
        if (strValue != null) {
            this.bReadOnly = EditableControlConfig.GetValue((String)strValue, (boolean)this.bReadOnly);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public void setReadOnly(boolean bReadOnly) {
        this.bReadOnly = bReadOnly;
    }

    public boolean getReadOnly() {
        return this.bReadOnly;
    }
}

