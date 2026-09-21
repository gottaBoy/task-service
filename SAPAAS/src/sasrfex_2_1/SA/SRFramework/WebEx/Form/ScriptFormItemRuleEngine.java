/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Form.ISRFExFormItemRuleEngine;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptFormItemRuleEngine
implements ISRFExFormItemRuleEngine {
    protected SRFExBaseForm form = null;
    protected ScriptEngine engine = null;
    protected BaseDataEntity dataEntity = null;

    @Override
    public boolean Init(SRFExBaseForm form, BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
        this.form = form;
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
        return this.engine != null;
    }

    @Override
    public boolean TestProcess(FormItemConfig formItemConfig) {
        return true;
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

