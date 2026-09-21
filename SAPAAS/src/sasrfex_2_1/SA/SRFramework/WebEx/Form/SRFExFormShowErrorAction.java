/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import java.io.Writer;

public class SRFExFormShowErrorAction
extends SRFExFormSystemAction {
    protected String strShowErrorFunc = "SRFForm.showFormItemError";
    protected String strAddErrorFunc = "SRFForm.addFormError";

    public SRFExFormShowErrorAction() {
        this.strActionName = "showerror";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_JO){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;\r\n", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            if (form.getResetErrorAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"_F.%1$s();", (Object)form.getResetErrorAction().getActionName()));
            }
            writer.write(StringHelper.Format((String)"if(_JO.items==null||_JO.items==undefined)return;\r\n"));
            writer.write(StringHelper.Format((String)"for(var i=0;i<_JO.items.length;i++){\r\n"));
            writer.write(StringHelper.Format((String)"var _I = _JO.items[i];\r\n"));
            writer.write(StringHelper.Format((String)"%1$s(_I.errid,_I.info);", (Object)this.strShowErrorFunc));
            if (StringHelper.Length((String)form.getErrorIndicator()) > 0) {
                writer.write(StringHelper.Format((String)"%1$s('%2$s',_I.info,_I.errid);", (Object)this.strAddErrorFunc, (Object)form.getErrorIndicator()));
            }
            writer.write(StringHelper.Format((String)"}\r\n"));
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getShowFormItemErrorFunc() {
        return this.strShowErrorFunc;
    }

    public void setShowFormItemErrorFunc(String strShowErrorFunc) {
        this.strShowErrorFunc = strShowErrorFunc;
    }

    public String getAddErrorFunc() {
        return this.strAddErrorFunc;
    }

    public void setAddErrorFunc(String strAddErrorFunc) {
        this.strAddErrorFunc = strAddErrorFunc;
    }
}

