/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseInputConfig;

public class HtmlEditorExConfig
extends BaseInputConfig {
    public static final String TAG_HTMLEDITOREX = "SRFEXHTMLEDITOREX";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_TEXTBOXMODE = "TEXTBOXMODE";
    public static final String TAG_ROWS = "ROWS";
    protected int nRows = 5;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.setValue(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getRows() {
        return this.nRows;
    }

    public void setRows(int value) {
        this.nRows = value;
    }

    public String getText() {
        return this.getValue();
    }

    public void setText(String value) {
        this.setValue(value);
    }
}

