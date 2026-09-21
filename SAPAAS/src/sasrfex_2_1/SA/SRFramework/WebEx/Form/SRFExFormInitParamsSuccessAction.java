/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import java.io.IOException;
import java.io.Writer;

public class SRFExFormInitParamsSuccessAction
extends SRFExFormAjaxSuccessAction {
    public SRFExFormInitParamsSuccessAction() {
        this.strActionName = "oninitparamsok";
        this.RegisterRetCode(5);
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExSearchForm form = (SRFExSearchForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                if (form.getFillAction() == null) break;
                writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getFillAction().getActionName()));
                break;
            }
            case 5: {
                if (form.getShowErrorAction() != null) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getShowErrorAction().getActionName()));
                }
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

