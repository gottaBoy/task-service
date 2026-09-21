/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import java.io.IOException;
import java.io.Writer;

public class SRFExFormCustomAjaxActionSuccessAction
extends SRFExFormAjaxSuccessAction {
    protected boolean bFillForm = true;

    public SRFExFormCustomAjaxActionSuccessAction() {
        this.strActionName = "";
    }

    public boolean getFillForm() {
        return this.bFillForm;
    }

    public void setFillForm(boolean bFillForm) {
        this.bFillForm = bFillForm;
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                if (form.getFillAction() == null || !this.bFillForm) break;
                writer.write(StringHelper.Format((String)"this.%1$s(_JO);\r\n", (Object)form.getFillAction().getActionName()));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

