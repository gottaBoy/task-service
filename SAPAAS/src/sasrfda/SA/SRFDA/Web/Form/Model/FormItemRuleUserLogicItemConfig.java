/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Form.Model;

import SA.SRFDA.Web.Form.Model.FormItemRuleBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class FormItemRuleUserLogicItemConfig
extends FormItemRuleBaseLogicConfig {
    public static final String TAG_SRFDAFORMITEMRULEUSERLOGICITEM = "SRFDAFORMITEMRULEUSERLOGICITEM";
    public static final String TAG_CODE = "CODE";
    protected String strCode = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CODE, (boolean)true) == 0) {
            this.setCode(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getCode() {
        return this.strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }
}

