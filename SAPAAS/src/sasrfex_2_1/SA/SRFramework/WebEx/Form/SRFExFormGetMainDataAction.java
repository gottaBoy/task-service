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

public class SRFExFormGetMainDataAction
extends SRFExFormSystemAction {
    public SRFExFormGetMainDataAction() {
        this.strActionName = "getmaindata";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var fm=%1$s;", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"var _M={};", (Object)form.getFormId()));
            ArrayList<SRFExControl> ctrls = form.GetMainFormControls();
            int i = 0;
            while (i < ctrls.size()) {
                ISRFExFormItem formItem;
                SRFExControl keyControl = ctrls.get(i);
                if (keyControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)keyControl)).getFormItemConfig() != null) {
                    FormItemConfig formItemConfig = formItem.getFormItemConfig();
                    writer.write(StringHelper.Format((String)"_M.%1$s=fm.G('%2$s');", (Object)formItemConfig.getDBField().toLowerCase(), (Object)keyControl.getUniqueID()));
                }
                ++i;
            }
            this.OutputAfterCode(writer);
            writer.write("return _M;");
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

