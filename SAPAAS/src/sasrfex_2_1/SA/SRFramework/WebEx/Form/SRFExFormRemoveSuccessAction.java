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

public class SRFExFormRemoveSuccessAction
extends SRFExFormAjaxSuccessAction {
    public SRFExFormRemoveSuccessAction() {
        this.strActionName = "onremoveok";
        this.RegisterRetCode(10);
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                if (form.getResetAction() == null) break;
                writer.write(StringHelper.Format((String)"%1$s.%2$s();\r\n", (Object)form.getFormId(), (Object)form.getResetAction().getActionName()));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

