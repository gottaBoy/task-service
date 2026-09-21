/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxResultAction;
import java.io.Writer;

public class SRFExFormAjaxFailedAction
extends SRFExFormAjaxResultAction {
    public SRFExFormAjaxFailedAction() {
        this.strActionName = "onajaxfailed";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_RO){\r\n", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            if (form.getRequestAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"%1$s.%2$sfinish();", (Object)form.getFormId(), (Object)form.getRequestAction().getActionName()));
            }
            writer.write("$URC(_RO,false,null);\r\n");
            writer.write("alert($P.msg['networkerror']);");
            this.OutputAfterCode(writer);
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

