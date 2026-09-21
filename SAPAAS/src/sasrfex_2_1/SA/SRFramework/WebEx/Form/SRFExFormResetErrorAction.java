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

public class SRFExFormResetErrorAction
extends SRFExFormSystemAction {
    protected String strShowErrorFunc = "SRFForm.showFormItemError";

    public SRFExFormResetErrorAction() {
        this.strActionName = "reseterror";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;\r\n", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            if (StringHelper.Length((String)form.getErrorIndicator()) > 0) {
                writer.write(StringHelper.Format((String)"SRFForm.resetFormError('%1$s');", (Object)form.getErrorIndicator()));
            }
            writer.write(StringHelper.Format((String)"for(var i=0;i<_F._ERRORS.length;i++){\r\n"));
            writer.write(StringHelper.Format((String)"%1$s(_F._ERRORS[i],'');", (Object)this.strShowErrorFunc));
            writer.write(StringHelper.Format((String)"}\r\n"));
            if (form.isOptimizeErrorParam()) {
                writer.write(StringHelper.Format((String)"for(var i=0;i<_F._ITEMS.length;i++){\r\n"));
                writer.write(StringHelper.Format((String)"%1$s('E'+_F._ITEMS[i],'');", (Object)this.strShowErrorFunc));
                writer.write(StringHelper.Format((String)"}\r\n"));
            }
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
}

