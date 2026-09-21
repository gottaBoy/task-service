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

public class SRFExFormSearchSuccessAction
extends SRFExFormAjaxSuccessAction {
    protected boolean bFillForm = true;
    protected boolean bResetParams = true;

    public void setResetParams(boolean bResetParams) {
        this.bResetParams = bResetParams;
    }

    public boolean getResetParams() {
        return this.bResetParams;
    }

    public boolean getFillForm() {
        return this.bFillForm;
    }

    public void setFillForm(boolean bFillForm) {
        this.bFillForm = bFillForm;
    }

    public SRFExFormSearchSuccessAction() {
        this.strActionName = "onsearchok";
        this.RegisterRetCode(5);
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExSearchForm form = (SRFExSearchForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                if (form.getFillAction().getEnabled() && this.bFillForm) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getFillAction().getActionName()));
                }
                if (StringHelper.Length((String)form.getUserParamsName()) <= 0) break;
                if (this.bResetParams) {
                    writer.write(StringHelper.Format((String)"%1$s={};\r\n", (Object)form.getUserParamsName()));
                }
                writer.write("for(var i=0;i<_JO.items.length;i++){\r\n");
                writer.write(StringHelper.Format((String)"%1$s[_JO.items[i].id.toLowerCase()]=SRFUtility.parsestring(_JO.items[i].value);}\r\n", (Object)form.getUserParamsName()));
                writer.write(StringHelper.Format((String)"Ext.apply(%1$s,%2$s._DHC);\r\n", (Object)form.getUserParamsName(), (Object)form.getFormId()));
                writer.write(StringHelper.Format((String)"Ext.apply(%1$s,%2$s._SHC);\r\n", (Object)form.getUserParamsName(), (Object)form.getFormId()));
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

