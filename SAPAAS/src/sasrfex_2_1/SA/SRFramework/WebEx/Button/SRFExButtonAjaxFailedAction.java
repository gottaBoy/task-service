/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExButtonAjaxResultAction;
import java.io.Writer;

public class SRFExButtonAjaxFailedAction
extends SRFExButtonAjaxResultAction {
    public SRFExButtonAjaxFailedAction() {
        this.strActionName = "onajaxfailed";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"%1$s:function(_RO){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"this.%1$sfinish();", (Object)this.getAjaxButton().getRequestAction().getActionName()));
            writer.write("if(_RO.argument!=undefined)\r\n");
            writer.write("if(_RO.argument.cb!=undefined && _RO.argument.cb !=null)\r\n");
            writer.write("_RO.argument.cb(_RO,false,null);\r\n");
            writer.write("alert($P.msg['networkerror']);");
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

