/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FormConfig;

public class SearchFormConfig
extends FormConfig {
    public static final String TAG_SEARCHFORM = "SRFEXSEARCHFORM";
    public static final String TAG_RESETPARAMS = "RESETPARAMS";
    protected boolean bResetParams = true;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_RESETPARAMS, (boolean)true) == 0) {
            this.bResetParams = SearchFormConfig.GetValue((String)strValue, (boolean)this.bResetParams);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setResetParams(boolean bResetParams) {
        this.bResetParams = bResetParams;
    }

    public boolean getResetParams() {
        return this.bResetParams;
    }
}

