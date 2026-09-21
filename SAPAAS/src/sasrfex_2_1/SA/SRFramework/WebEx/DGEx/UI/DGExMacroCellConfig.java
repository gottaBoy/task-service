/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;

public class DGExMacroCellConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXMACROCELL = "SRFEXDGEXMACROCELL";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_TEXTCSSCLASS = "TEXTCSSCLASS";
    public static final String TAG_MACRO = "MACRO";
    protected String strItemFormat = "";
    protected String strTextCssClass = "";
    protected String strMacro = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTCSSCLASS, (boolean)true) == 0) {
            this.strTextCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MACRO, (boolean)true) == 0) {
            this.setMacro(strValue);
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

    public String getMacro() {
        return this.strMacro;
    }

    public void setMacro(String strMacro) {
        this.strMacro = strMacro;
    }
}

