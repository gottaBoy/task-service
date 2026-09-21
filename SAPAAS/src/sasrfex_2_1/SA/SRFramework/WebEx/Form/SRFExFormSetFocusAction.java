/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import java.io.Writer;
import java.util.Vector;

public class SRFExFormSetFocusAction
extends SRFExFormSystemAction {
    public SRFExFormSetFocusAction() {
        this.strActionName = "setfocus";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"%1$s:function(_ID){\r\n", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write("switch(_ID){\r\n");
            Vector controls = this.getForm().getFormControls();
            int i = 0;
            while (i < controls.size()) {
                ISRFExFormItem formItem;
                String strFocusCall;
                SRFExControl control = (SRFExControl)controls.get(i);
                if (control instanceof ISRFExFormItem && StringHelper.Length((String)(strFocusCall = (formItem = (ISRFExFormItem)((Object)control)).getItemFocusJSCall())) > 0) {
                    writer.write(StringHelper.Format((String)"case '%1$s':%2$sbreak;", (Object)control.getUniqueID(), (Object)strFocusCall));
                }
                ++i;
            }
            writer.write(StringHelper.Format((String)"default:$FSF(_ID);break;\r\n"));
            writer.write("}\r\n");
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

