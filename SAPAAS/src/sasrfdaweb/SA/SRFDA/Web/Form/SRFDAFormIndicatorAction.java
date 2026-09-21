/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormIndicatorAction
 */
package SA.SRFDA.Web.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormIndicatorAction;
import java.io.Writer;

public class SRFDAFormIndicatorAction
extends SRFExFormIndicatorAction {
    public SRFDAFormIndicatorAction() {
        this.strActionName = "showindicator";
    }

    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"if($P.maskhelper)$P.maskhelper.maskprocessing($P.msg['processing']);\r\n"));
            this.OutputAfterCode(writer);
            writer.write("}");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)"hideindicator"));
            writer.write(StringHelper.Format((String)"if($P.maskhelper)$P.maskhelper.unmask();\r\n"));
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

