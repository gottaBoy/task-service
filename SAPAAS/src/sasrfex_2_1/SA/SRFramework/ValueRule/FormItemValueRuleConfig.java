/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleConfig;

public class FormItemValueRuleConfig
extends ValueRuleConfig {
    public static String TAG_SRFEXFORMITEMVALUERULE = "FORMITEMVALUERULE";
    public static String TAG_FORMITEMID = "FORMITEMID";
    protected String strFormItemId = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FORMITEMID, (boolean)true) == 0) {
            this.strFormItemId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getFormItemId() {
        return this.strFormItemId;
    }

    public void setFormItemId(String strFormItemId) {
        this.strFormItemId = strFormItemId;
    }
}

