/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DataGrid.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridBaseEditorConfig;

public class DataGridTextEditorConfig
extends DataGridBaseEditorConfig {
    public static final String TAG_SRFEXDATAGRIDTEXTEDITOR = "SRFEXDATAGRIDTEXTEDITOR";
    protected boolean bMultiLine = false;
    public static final String TAG_MULTILINE = "MULTILINE";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_MULTILINE, (boolean)true) == 0) {
            this.bMultiLine = DataGridTextEditorConfig.GetValue((String)strValue, (boolean)this.bMultiLine);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isMultiLine() {
        return this.bMultiLine;
    }

    public void setMultiLine(boolean multiLine) {
        this.bMultiLine = multiLine;
    }
}

