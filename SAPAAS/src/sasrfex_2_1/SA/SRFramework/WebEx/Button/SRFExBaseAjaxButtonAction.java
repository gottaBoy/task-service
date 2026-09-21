/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import java.io.Writer;
import java.util.Vector;

public class SRFExBaseAjaxButtonAction {
    protected Vector params = null;
    protected String strActionName = "";
    protected SRFExAjaxButton ajaxButton = null;
    protected String strActionParams = "";

    public void setAjaxButton(SRFExAjaxButton ajaxButton) {
        this.ajaxButton = ajaxButton;
        this.OnSetAjaxButton();
    }

    protected void OnSetAjaxButton() {
    }

    public SRFExAjaxButton getAjaxButton() {
        return this.ajaxButton;
    }

    public String getActionName() {
        return this.strActionName;
    }

    public void Render(Writer writer) {
        this.OnRender(writer);
    }

    protected void OnRender(Writer writer) {
    }
}

