/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Form.Model;

import SA.SRFDA.Web.Form.Model.FormItemRuleLogicGroupConfig;
import SA.SRFramework.Utility.StringHelper;

public class FormItemRuleConfig
extends FormItemRuleLogicGroupConfig {
    public static final String TAG_SRFDAFORMITEMRULE = "SRFDAFORMITEMRULE";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String RULETYPE_CONTROLENABLE = "CONTROLENABLE";
    public static final String RULETYPE_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String RULETYPE_CUSTOMCALL = "CUSTOMCALL";
    public static final String RULETYPE_VALUERESET = "VALUERESET";
    public static final String RULETYPE_VALUEVALID = "VALUEVALID";
    protected String strRuleType = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_RULETYPE, (boolean)true) == 0) {
            this.setRuleType(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getRuleType() {
        return this.strRuleType;
    }

    public void setRuleType(String strRuleType) {
        this.strRuleType = strRuleType;
    }
}

