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

public class SRFExFormItemValueChangedAction
extends SRFExFormSystemAction {
    public SRFExFormItemValueChangedAction() {
        this.strActionName = "itemvaluechanged";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_I){", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"$P.form['%1$s'].firevaluechanged(_I);", (Object)form.getFormId()));
            this.OutputAfterCode(writer);
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

