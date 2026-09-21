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

public class SRFExFormIndicatorAction
extends SRFExFormSystemAction {
    public SRFExFormIndicatorAction() {
        this.strActionName = "showindicator";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var _I=Ext.get('%1$s');", (Object)form.getLoadingIndicator()));
            writer.write(StringHelper.Format((String)"if(_I==null)return;"));
            writer.write(StringHelper.Format((String)"_I.show();"));
            this.OutputAfterCode(writer);
            writer.write("}\r\n");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)"hideindicator"));
            writer.write(StringHelper.Format((String)"var _I=Ext.get('%1$s');", (Object)form.getLoadingIndicator()));
            writer.write(StringHelper.Format((String)"if(_I==null)return;"));
            writer.write(StringHelper.Format((String)"_I.hide();"));
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

