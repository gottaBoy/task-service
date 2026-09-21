/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;

public class DGExSNCellConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXSNCELL = "SRFEXDGEXSNCELL";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_STARTFROM = "STARTFROM";
    public static final String TAG_TEXTCSSCLASS = "TEXTCSSCLASS";
    protected int nStartFrom = 1;
    protected String strItemFormat = "";
    protected String strTextCssClass = "";

    public DGExSNCellConfig() {
        this.strAlign = "right";
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_STARTFROM, (boolean)true) == 0) {
            this.nStartFrom = this.GetExtValue(strValue, this.nStartFrom);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTCSSCLASS, (boolean)true) == 0) {
            this.strTextCssClass = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getTextCssClass() {
        return this.strTextCssClass;
    }

    public void setTextCssClass(String strTextCssClass) {
        this.strTextCssClass = strTextCssClass;
    }

    public int getStartFrom() {
        return this.nStartFrom;
    }

    public void setStartFrom(int nStartFrom) {
        this.nStartFrom = nStartFrom;
    }
}

