/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Form.ISRFExFormItemRuleEngine;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.UI.FormItemConfig;

public class DefaultFormItemRuleEngine
implements ISRFExFormItemRuleEngine {
    protected BaseDataEntity dataEntity = null;
    private SRFExBaseForm form = null;

    @Override
    public boolean Init(SRFExBaseForm form, BaseDataEntity dataEntity) {
        this.form = form;
        this.dataEntity = dataEntity;
        return true;
    }

    @Override
    public boolean TestProcess(FormItemConfig formItemConfig) {
        return true;
    }

    protected SRFExBaseForm getForm() {
        return this.form;
    }

    @Override
    public boolean TestAllowEmpty(FormItemConfig formItemConfig) {
        return false;
    }

    @Override
    public boolean TestValueRule(FormItemConfig formItemConfig, Object objValue, String strValue) {
        return false;
    }

    @Override
    public boolean TestValueRule(FormItemConfig formItemConfig) {
        return this.TestValueRule(formItemConfig, null, null);
    }
}

