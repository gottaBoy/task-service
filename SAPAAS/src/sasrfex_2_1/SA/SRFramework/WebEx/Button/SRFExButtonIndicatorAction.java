/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExButtonSystemAction;
import java.io.Writer;

public class SRFExButtonIndicatorAction
extends SRFExButtonSystemAction {
    public SRFExButtonIndicatorAction() {
        this.strActionName = "showindicator";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var _I = Ext.get('%1$s');\r\n", (Object)this.getAjaxButton().getAjaxButtonConfig().getLoadingIndicator()));
            writer.write(StringHelper.Format((String)"if(_I == null) return;\r\n"));
            writer.write("this._BTN.disable();\r\n");
            writer.write(StringHelper.Format((String)"_I.show();\r\n"));
            this.OutputAfterCode(writer);
            writer.write("}");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)"hideindicator"));
            writer.write(StringHelper.Format((String)"var _I = Ext.get('%1$s');\r\n", (Object)this.getAjaxButton().getAjaxButtonConfig().getLoadingIndicator()));
            writer.write(StringHelper.Format((String)"if(_I == null) return;\r\n"));
            writer.write(StringHelper.Format((String)"_I.hide();\r\n"));
            writer.write("this._BTN.enable();\r\n");
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

