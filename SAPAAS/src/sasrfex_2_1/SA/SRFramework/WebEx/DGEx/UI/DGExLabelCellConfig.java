/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;

public class DGExLabelCellConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXLABELCELL = "SRFEXDGEXLABELCELL";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_TEXTCSSCLASS = "TEXTCSSCLASS";
    protected String strText = "";
    protected String strTextCssClass = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.setText(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTCSSCLASS, (boolean)true) == 0) {
            this.strTextCssClass = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getTextCssClass() {
        return this.strTextCssClass;
    }

    public void setTextCssClass(String strTextCssClass) {
        this.strTextCssClass = strTextCssClass;
    }
}

