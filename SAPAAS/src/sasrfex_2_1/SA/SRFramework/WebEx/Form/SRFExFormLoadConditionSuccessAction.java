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

public class SRFExFormLoadConditionSuccessAction
extends SRFExFormAjaxSuccessAction {
    protected boolean bSearchAfterLoad = true;

    public SRFExFormLoadConditionSuccessAction() {
        this.strActionName = "onloadconditionok";
    }

    public boolean getSearchAfterLoad() {
        return this.bSearchAfterLoad;
    }

    public void setSearchAfterLoad(boolean bSearchAfterLoad) {
        this.bSearchAfterLoad = bSearchAfterLoad;
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExSearchForm form = (SRFExSearchForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                if (form.getFillAction() != null) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getFillAction().getActionName()));
                }
                if (!this.bSearchAfterLoad || form.getSearchAction() == null) break;
                writer.write(StringHelper.Format((String)"%1$s.%2$s();\r\n", (Object)form.getFormId(), (Object)form.getSearchAction().getActionName()));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

