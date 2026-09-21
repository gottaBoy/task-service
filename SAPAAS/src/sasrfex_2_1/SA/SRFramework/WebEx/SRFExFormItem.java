/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.ISRFExFormItem3;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.util.Vector;

public abstract class SRFExFormItem
extends SRFExControl
implements ISRFExFormItem,
ISRFExFormItem3 {
    protected SRFExBaseForm form = null;

    @Override
    public void setForm(SRFExBaseForm form) {
        this.form = form;
    }

    public SRFExBaseForm getForm() {
        return this.form;
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void setValue(String strValue) {
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V=$FGV(_ID);";
        }
        return "$FSV(_ID,_V);";
    }

    @Override
    public void GetFormItemIds(Vector vector) {
        vector.add(this.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return "";
    }

    @Override
    public void setEnabled(boolean bEnabled) {
        this.getBaseControlConfig().setEnabled(bEnabled);
    }

    @Override
    public boolean getEnabled() {
        return this.getBaseControlConfig().getEnabled();
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return "";
    }

    @Override
    public String getFireFIUpdateCode(String strCode) {
        return "";
    }

    @Override
    public boolean IsSupportModify() {
        return true;
    }

    @Override
    public String getItemFocusJSCall() {
        return "";
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        vector.add(this.getUniqueID());
    }
}

