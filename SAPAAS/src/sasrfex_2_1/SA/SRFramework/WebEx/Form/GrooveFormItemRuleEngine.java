/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Form.ISRFExFormItemRuleEngine;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.Utility.GrooveRuleEngine;

public class GrooveFormItemRuleEngine
extends GrooveRuleEngine
implements ISRFExFormItemRuleEngine {
    protected SRFExBaseForm form = null;

    @Override
    public boolean Init(SRFExBaseForm form, BaseDataEntity dataEntity) {
        this.form = form;
        this.dataEntity = dataEntity;
        return true;
    }

    @Override
    public boolean TestAllowEmpty(FormItemConfig formItemConfig) {
        return this.InternalTest(formItemConfig.getAllowEmptyCond(), false);
    }

    @Override
    public boolean TestProcess(FormItemConfig formItemConfig) {
        return this.InternalTest(formItemConfig.getValidCond(), false);
    }

    @Override
    public boolean TestValueRule(FormItemConfig formItemConfig) {
        return this.TestValueRule(formItemConfig, null, null);
    }

    @Override
    public boolean TestValueRule(FormItemConfig formItemConfig, Object objValue, String strValue) {
        return this.InternalTest(formItemConfig.getValueRuleCode(), false);
    }

    @Override
    protected ISRFExWebContext GetWebContext() {
        return this.form.getPage().getWebContext();
    }
}

