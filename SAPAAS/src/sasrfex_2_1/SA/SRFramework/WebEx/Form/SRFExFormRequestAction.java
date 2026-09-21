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

public class SRFExFormRequestAction
extends SRFExFormSystemAction {
    protected int nTimeout = 10;

    public SRFExFormRequestAction() {
        this.strActionName = "request";
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int nTimeout) {
        this.nTimeout = nTimeout;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_METHOD,_URL,_CALLBACK,_POSTDATA){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"if(this._REQ){Ext.lib.Ajax.abort(this._REQ);this._REQ=null;}\r\n"));
            if (form.getIndicatorAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"this.showindicator();\r\n"));
            }
            writer.write(StringHelper.Format((String)"this._REQ =Ext.lib.Ajax.request(_METHOD,_URL,_CALLBACK,_POSTDATA);\r\n"));
            writer.write(StringHelper.Format((String)"},\r\n"));
            writer.write(StringHelper.Format((String)"%1$sfinish:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"this._REQ=null;\r\n"));
            if (form.getIndicatorAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"this.hideindicator();\r\n"));
            }
            writer.write(StringHelper.Format((String)"}\r\n"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

