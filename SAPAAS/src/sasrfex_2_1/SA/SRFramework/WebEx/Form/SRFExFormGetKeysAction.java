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
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.ArrayList;

public class SRFExFormGetKeysAction
extends SRFExFormSystemAction {
    public SRFExFormGetKeysAction() {
        this.strActionName = "getkeys";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var fm=%1$s;", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"var KEYS={};"));
            writer.write(StringHelper.Format((String)"var V='';"));
            ArrayList<SRFExControl> ctrls = form.GetKeyFormControls();
            int i = 0;
            while (i < ctrls.size()) {
                ISRFExFormItem formItem;
                SRFExControl keyControl = ctrls.get(i);
                if (keyControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)keyControl)).getFormItemConfig() != null) {
                    FormItemConfig formItemConfig = formItem.getFormItemConfig();
                    writer.write(StringHelper.Format((String)"V=fm.G('%2$s');if(V!=''){KEYS.%1$s=V;};", (Object)formItemConfig.getDBField().toLowerCase(), (Object)keyControl.getUniqueID()));
                }
                ++i;
            }
            this.OutputAfterCode(writer);
            writer.write("return KEYS;");
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

