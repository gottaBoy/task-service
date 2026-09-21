/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.util.Vector;

public interface ISRFExFormItem {
    public void setForm(SRFExBaseForm var1);

    public FormItemConfig getFormItemConfig();

    public String getValue();

    public void setValue(String var1);

    public boolean FillValueJSON(Vector var1, boolean var2);

    public void GetFormItemIds(Vector var1);

    public String getItemValueJSCall(boolean var1);

    public String getItemEnableStateJSCall();

    public void setEnabled(boolean var1);

    public boolean getEnabled();

    public String getHookValueChangedCode(String var1);

    public String getFireFIUpdateCode(String var1);

    public String getItemFocusJSCall();

    public void GetFocusItemIds(Vector var1);
}

