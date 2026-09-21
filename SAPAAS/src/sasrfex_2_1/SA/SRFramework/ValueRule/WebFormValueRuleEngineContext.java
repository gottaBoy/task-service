/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleEngineContext;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebFormValueRuleEngineContext
extends ValueRuleEngineContext {
    private static final Log log = LogFactory.getLog(WebFormValueRuleEngineContext.class);
    protected SRFExBaseForm baseForm = null;

    public SRFExBaseForm getForm() {
        return this.baseForm;
    }

    public void setForm(SRFExBaseForm baseForm) {
        this.baseForm = baseForm;
    }

    @Override
    public String GetDataEntityParamInfo(String strParamName) {
        ISRFExFormItem iFormItem;
        SRFExControl control;
        if (this.baseForm != null && (control = this.baseForm.FindControl(strParamName)) != null && control instanceof ISRFExFormItem && (iFormItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null) {
            String strParamInfo = iFormItem.getFormItemConfig().getName();
            if (StringHelper.Length((String)strParamInfo) == 0) {
                log.warn((Object)StringHelper.Format((String)"\u5b58\u5728\u8868\u5355\u9879[%1$s]\uff0c\u4f46\u672a\u5411\u5176\u5b9a\u4e49\u53c2\u6570\u4fe1\u606f\u3002", (Object)strParamName));
            }
            return strParamInfo;
        }
        return super.GetDataEntityParamInfo(strParamName);
    }
}

