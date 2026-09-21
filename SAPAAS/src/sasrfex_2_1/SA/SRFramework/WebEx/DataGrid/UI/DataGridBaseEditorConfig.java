/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DataGrid.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;

public abstract class DataGridBaseEditorConfig
extends DataGridColumnEditorConfig {
    public static final String TAG_EMPTY = "EMPTY";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_VALUEFIELD = "VALUEFIELD";
    protected boolean bAllowEmpty = true;
    protected String strValueField = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTY, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_ALLOWEMPTY, (boolean)true) == 0) {
            this.bAllowEmpty = DataGridBaseEditorConfig.GetValue((String)strValue, (boolean)this.bAllowEmpty);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUEFIELD, (boolean)true) == 0) {
            this.strValueField = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public void setValueField(String strValueField) {
        this.strValueField = strValueField;
    }

    public String getValueField() {
        return this.strValueField;
    }
}

