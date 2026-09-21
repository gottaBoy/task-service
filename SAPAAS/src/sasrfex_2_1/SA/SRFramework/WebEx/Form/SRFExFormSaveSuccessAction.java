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

public class SRFExFormSaveSuccessAction
extends SRFExFormAjaxSuccessAction {
    protected boolean bFillForm = true;

    public boolean getFillForm() {
        return this.bFillForm;
    }

    public void setFillForm(boolean bFillForm) {
        this.bFillForm = bFillForm;
    }

    public SRFExFormSaveSuccessAction() {
        this.strActionName = "onsaveok";
        this.RegisterRetCode(5);
        this.RegisterRetCode(10);
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                writer.write(StringHelper.Format((String)"%1$s._COPYID='';%1$s._FS=_JO.fs;%1$s._UF=_JO.uf;\r\n", (Object)form.getFormId()));
                if (form.getResetErrorAction().getEnabled()) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s();\r\n", (Object)form.getFormId(), (Object)form.getResetErrorAction().getActionName()));
                }
                if (this.bFillForm && form.getFillAction().getEnabled()) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getFillAction().getActionName()));
                }
                writer.write(StringHelper.Format((String)"$P.form['%1$s'].firestatechanged();\r\n", (Object)form.getFormId()));
                writer.write(StringHelper.Format((String)"$P.form['%1$s'].firesaved($V(_JO.savetag,''));\r\n", (Object)form.getFormId()));
                break;
            }
            case 5: {
                if (!form.getShowErrorAction().getEnabled()) break;
                writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getShowErrorAction().getActionName()));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

