/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.HiddenConfig
 */
package SA.SRFDA.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.HiddenConfig;

public class DGExDesignerConfig
extends HiddenConfig {
    public static final String TAG_DEFORMITEM = "DEFORMITEM";
    protected String strDEFormItem = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_DEFORMITEM, (String)strName, (boolean)true) == 0) {
            this.strDEFormItem = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEFormItem() {
        return this.strDEFormItem;
    }

    public void setDEFormItem(String strDEFormItem) {
        this.strDEFormItem = strDEFormItem;
    }
}

