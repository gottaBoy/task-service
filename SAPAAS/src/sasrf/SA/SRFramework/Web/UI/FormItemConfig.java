/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Web.UI.BaseFormItemConfig;

public class FormItemConfig
extends BaseFormItemConfig {
    protected static String EMPTY = "EMPTY";
    protected static String MAXLEN = "MAXLEN";
    protected static String UNITNAME = "UNITNAME";
    protected static String COPYMODEFILL = "COPYMODEFILL";
    protected static String LONGCAPTION = "LONGCAPTION";
    protected boolean bAllowEmpty = false;
    protected int nMaxLen = 0;
    protected boolean bCheckMaxLen = false;
    protected String strUnitName = "";
    protected boolean bCopyModeFill = true;
    protected boolean bLongCaption = false;

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public int getMaxLen() {
        return this.nMaxLen;
    }

    public boolean getCheckMaxLen() {
        return this.bCheckMaxLen;
    }

    public String getUnitName() {
        return this.strUnitName;
    }

    public boolean getCopyModeFill() {
        return this.bCopyModeFill;
    }

    public boolean getLongCaption() {
        return this.bLongCaption;
    }

    public void setLongCaption(boolean value) {
        this.bLongCaption = value;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(EMPTY) == 0) {
            this.bAllowEmpty = FormItemConfig.GetValue(strValue, this.bAllowEmpty);
            return;
        }
        if (strName.compareToIgnoreCase(MAXLEN) == 0) {
            this.nMaxLen = FormItemConfig.GetValue(strValue, this.nMaxLen);
            this.bCheckMaxLen = true;
            return;
        }
        if (strName.compareToIgnoreCase(UNITNAME) == 0) {
            this.strUnitName = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(COPYMODEFILL) == 0) {
            this.bCopyModeFill = FormItemConfig.GetValue(strValue, this.bCopyModeFill);
            return;
        }
        if (strName.compareToIgnoreCase(LONGCAPTION) == 0) {
            this.bLongCaption = FormItemConfig.GetValue(strValue, this.bLongCaption);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

