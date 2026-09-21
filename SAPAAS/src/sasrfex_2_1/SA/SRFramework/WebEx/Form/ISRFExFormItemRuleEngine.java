/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.UI.FormItemConfig;

public interface ISRFExFormItemRuleEngine {
    public boolean Init(SRFExBaseForm var1, BaseDataEntity var2);

    public boolean TestProcess(FormItemConfig var1);

    public boolean TestAllowEmpty(FormItemConfig var1);

    public boolean TestValueRule(FormItemConfig var1, Object var2, String var3);

    public boolean TestValueRule(FormItemConfig var1);
}

