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
import SA.SRFramework.WebEx.SRFExControl;
import java.io.Writer;
import java.util.ArrayList;

public class SRFExFormHasKeysAction
extends SRFExFormSystemAction {
    public SRFExFormHasKeysAction() {
        this.strActionName = "haskeys";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var fm=%1$s;", (Object)form.getFormId()));
            ArrayList<SRFExControl> ctrls = form.GetKeyFormControls();
            int i = 0;
            while (i < ctrls.size()) {
                SRFExControl keyControl = ctrls.get(i);
                writer.write(StringHelper.Format((String)"if(fm.G('%1$s')=='')return false;", (Object)keyControl.getUniqueID()));
                ++i;
            }
            this.OutputAfterCode(writer);
            writer.write("return true;");
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

