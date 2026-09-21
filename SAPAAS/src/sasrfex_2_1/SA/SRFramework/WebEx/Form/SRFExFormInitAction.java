/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExFormInitFailedAction;
import SA.SRFramework.WebEx.Form.SRFExFormInitSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import java.io.Writer;

public class SRFExFormInitAction
extends SRFExFormSystemAction {
    protected SRFExFormInitSuccessAction ajaxSuccessAction = null;
    protected SRFExFormInitFailedAction ajaxFailedAction = null;

    public SRFExFormInitAction() {
        this.strActionName = "init";
        this.ajaxSuccessAction = new SRFExFormInitSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
        this.ajaxFailedAction = new SRFExFormInitFailedAction();
        this.ajaxFailedAction.setParentAction(this);
    }

    public SRFExFormInitSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    public SRFExFormInitFailedAction getFailedAction() {
        return this.ajaxFailedAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        super.OnRender(writer);
    }
}

