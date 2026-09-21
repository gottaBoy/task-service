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

public class SRFExFormIsDirtyAction
extends SRFExFormSystemAction {
    public SRFExFormIsDirtyAction() {
        this.strActionName = "isdirty";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"if(!_F._FF)return false;"));
            writer.write(StringHelper.Format((String)"var _R=SRFForm.isDirty(_F);"));
            this.OutputAfterCode(writer);
            writer.write("return _R;\r\n");
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

