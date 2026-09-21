/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl.Model;

import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEDCRuleUserLogicItemConfig
extends DEDCRuleBaseLogicConfig {
    public static final String TAG_SRFDADEDCRULEUSERLOGICITEM = "SRFDADEDCRULEUSERLOGICITEM";
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

