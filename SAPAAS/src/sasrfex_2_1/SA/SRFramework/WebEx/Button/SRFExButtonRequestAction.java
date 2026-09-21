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

public class SRFExButtonRequestAction
extends SRFExButtonSystemAction {
    protected int nTimeout = 10;

    public SRFExButtonRequestAction() {
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
            writer.write(StringHelper.Format((String)"%1$s:function(_METHOD, _URL, _CALLBACK, _POSTDATA){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"if(this._REQ == undefined || this._REQ == null){\r\n"));
            writer.write(StringHelper.Format((String)"this._REQ = Ext.lib.Ajax.request(_METHOD, _URL, _CALLBACK, _POSTDATA);\r\n"));
            if (this.getAjaxButton().getIndicatorAction() != null) {
                writer.write(StringHelper.Format((String)"this.showindicator();\r\n"));
            }
            writer.write(StringHelper.Format((String)"}\r\n"));
            writer.write(StringHelper.Format((String)"else{\r\n"));
            writer.write(StringHelper.Format((String)"alert('\u4e0a\u4e00\u6b21\u7684\u5904\u7406\u8fd8\u672a\u7ed3\u675f\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01');}\r\n"));
            writer.write(StringHelper.Format((String)"},\r\n"));
            writer.write(StringHelper.Format((String)"%1$sfinish:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"this._REQ = null;\r\n"));
            if (this.getAjaxButton().getIndicatorAction() != null) {
                writer.write(StringHelper.Format((String)"this.hideindicator();\r\n"));
            }
            writer.write(StringHelper.Format((String)"}\r\n"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

