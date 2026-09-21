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

public class SRFExFormLoadSuccessAction
extends SRFExFormAjaxSuccessAction {
    public SRFExFormLoadSuccessAction() {
        this.strActionName = "onloadok";
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                writer.write(StringHelper.Format((String)"if(!$V(_JO.igndef,false)){\r\n"));
                writer.write(StringHelper.Format((String)"%1$s._COPYID=$V(_JO.copyid,'');%1$s._FS=_JO.fs;%1$s._UF=_JO.uf;\r\n", (Object)form.getFormId()));
                if (form.getFillAction() != null) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getFillAction().getActionName()));
                }
                writer.write(StringHelper.Format((String)"$P.form['%1$s'].firestatechanged();\r\n", (Object)form.getFormId()));
                writer.write(StringHelper.Format((String)"}\r\n"));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

