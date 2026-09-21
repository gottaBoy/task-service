/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.Button.SRFExBaseAjaxButtonAction;
import SA.SRFramework.WebEx.Button.SRFExButtonSystemAction;

public class SRFExButtonAjaxResultAction
extends SRFExButtonSystemAction {
    protected SRFExBaseAjaxButtonAction parentButtonAction = null;

    public void setParentAction(SRFExBaseAjaxButtonAction parentButtonAction) {
        this.parentButtonAction = parentButtonAction;
    }

    public SRFExBaseAjaxButtonAction getParentAction() {
        return this.parentButtonAction;
    }

    @Override
    public SRFExAjaxButton getAjaxButton() {
        if (this.parentButtonAction != null) {
            return this.parentButtonAction.getAjaxButton();
        }
        return super.getAjaxButton();
    }
}

