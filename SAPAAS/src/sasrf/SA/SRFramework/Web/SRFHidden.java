/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFHidden
extends SRFWebControl
implements IWebCtrl {
    private String strValue = "";

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public String getValue() {
        return this.strValue;
    }

    @Override
    protected boolean OnInitFromRequest() {
        this.strValue = this.getPage().getRequest().getParameter(this.getUniqueID());
        return false;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<input ");
            this.OutputID(output);
            this.OutputName(output);
            this.OutputProperty(output, "type", "hidden");
            this.OutputProperty(output, "value", this.getValue());
            output.print(" />");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    @Override
    public void SetStrValue(String strValue) {
        this.setValue(strValue);
    }

    @Override
    public String GetCtrlValue() {
        return this.getValue();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }
}

