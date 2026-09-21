/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExForm;
import java.io.Writer;

public class SRFExChartSearchAction
extends SRFExBaseFormAction {
    protected String strSearchCode = "";

    public SRFExChartSearchAction() {
        this.strActionName = "search";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var C={};\r\n"));
            writer.write(StringHelper.Format((String)"for(A in %1$s._UID){ \r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"var B=%1$s.G(%1$s._UID[A]);if(B!=''){C[A]=B;}\r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n", (Object)form.getFormId()));
            writer.write("var _PARAMS=Ext.urlEncode(C);\r\n");
            writer.write(this.strSearchCode);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getSearchCode() {
        return this.strSearchCode;
    }

    public void setSearchCode(String strSearchCode) {
        this.strSearchCode = strSearchCode;
    }
}

