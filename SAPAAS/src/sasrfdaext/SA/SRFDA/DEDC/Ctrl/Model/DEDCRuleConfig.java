/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl.Model;

import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleLogicGroupConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEDCRuleConfig
extends DEDCRuleLogicGroupConfig {
    public static final String TAG_SRFDADEDCRULE = "SRFDADEDCRULE";
    public static final String TAG_RULEVALUE = "RULEVALUE";
    protected String strRuleValue = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_RULEVALUE, (boolean)true) == 0) {
            this.setRuleValue(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getRuleValue() {
        return this.strRuleValue;
    }

    public void setRuleValue(String strRuleValue) {
        this.strRuleValue = strRuleValue;
    }
}

