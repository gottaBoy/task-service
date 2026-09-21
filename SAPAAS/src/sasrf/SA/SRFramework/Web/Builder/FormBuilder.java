/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.FormErrorMgr;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.util.Hashtable;
import javax.servlet.jsp.JspWriter;

public abstract class FormBuilder
extends UIBuilder {
    protected FormErrorMgr formErrorMgr = null;
    protected Hashtable childCtrls = null;

    public void setFormError(FormErrorMgr value) {
        this.formErrorMgr = value;
    }

    public void setChildCtrls(Hashtable value) {
        this.childCtrls = value;
    }

    public void BindCtrlStyle(SRFWebControl ctrl, WebCtrlConfig webCtrlConfig) {
    }

    protected void RenderControl(JspWriter output, String strKey) {
        if (this.childCtrls.containsKey(strKey)) {
            SRFWebControl ctrl = (SRFWebControl)this.childCtrls.get(strKey);
            if (ctrl != null) {
                ctrl.RenderControl(output);
            }
        } else {
            try {
                output.print("&nbsp;");
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}

