/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;

public class SRFExFormAjaxResultAction
extends SRFExFormSystemAction {
    protected SRFExBaseFormAction parentFormAction = null;

    public void setParentAction(SRFExBaseFormAction parentFormAction) {
        this.parentFormAction = parentFormAction;
    }

    public SRFExBaseFormAction getParentAction() {
        return this.parentFormAction;
    }

    @Override
    public SRFExBaseForm getForm() {
        if (this.parentFormAction != null) {
            return this.parentFormAction.getForm();
        }
        return super.getForm();
    }
}

