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

public class SRFExFormResetAction
extends SRFExFormSystemAction {
    public SRFExFormResetAction() {
        this.strActionName = "reset";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;\r\n", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"for(var i=0;i<_F._ITEMS.length;i++){\r\n"));
            writer.write(StringHelper.Format((String)"_F.S(_F._ITEMS[i],'');"));
            writer.write(StringHelper.Format((String)"_F.enable(_F._ITEMS[i],_F._STATES[i]==1);\r\n"));
            writer.write(StringHelper.Format((String)"}\r\n"));
            if (form.getButtonStateAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"_F.%1$s(null);\r\n", (Object)form.getButtonStateAction().getActionName()));
            }
            if (form.getItemValueChangedAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"_F.%1$s('');\r\n", (Object)form.getItemValueChangedAction().getActionName()));
            }
            writer.write(StringHelper.Format((String)"$P.form['%1$s'].firereseted();\r\n", (Object)form.getFormId()));
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

