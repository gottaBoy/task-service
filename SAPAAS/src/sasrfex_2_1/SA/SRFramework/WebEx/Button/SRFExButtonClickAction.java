/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.Button.SRFExButtonAjaxAction;
import SA.SRFramework.WebEx.Button.SRFExButtonClickSuccessAction;
import java.io.Writer;

public class SRFExButtonClickAction
extends SRFExButtonAjaxAction {
    protected SRFExButtonClickSuccessAction ajaxSuccessAction = null;
    protected boolean bLoadDefault = false;
    protected String strPostParams = "{}";

    public SRFExButtonClickAction() {
        this.strActionName = "click";
        this.ajaxSuccessAction = new SRFExButtonClickSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExButtonClickSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    public String getPostParams() {
        return this.strPostParams;
    }

    public void setPostParams(String strPostParams) {
        this.strPostParams = strPostParams;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExAjaxButton ajaxButton = this.getAjaxButton();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _URL = '%1$s';\r\n", (Object)this.getRemotePath()));
            writer.write(StringHelper.Format((String)"var _TIMEOUT = %1$s;\r\n", (Object)this.getTimeout()));
            writer.write(StringHelper.Format((String)"var _PARAMS = %1$s;\r\n", (Object)this.strPostParams));
            writer.write(StringHelper.Format((String)"Ext.apply(_PARAMS,{actiontype:'buttonaction',buttonid:'%1$s',srfactionhelper:'%2$s',action:'click'});\r\n", (Object)ajaxButton.getUniqueID(), (Object)ajaxButton.getAjaxButtonConfig().getBackEndCtrl()));
            writer.write("var _CALLBACK =\r\n");
            writer.write("{\r\n");
            writer.write(StringHelper.Format((String)"\tsuccess:this.%1$s.createDelegate(this), \r\n", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"\tfailure:this.%1$s.createDelegate(this), \r\n", (Object)ajaxButton.getAjaxFailedAction().getActionName()));
            writer.write(" timeout:_TIMEOUT");
            writer.write("};\r\n");
            writer.write("var _POSTDATA =  Ext.urlEncode(_PARAMS);\r\n");
            if (StringHelper.Length((String)this.strBeforeCode) > 0) {
                writer.write(this.strBeforeCode);
            }
            writer.write(StringHelper.Format((String)"this.request('POST',_URL, _CALLBACK, _POSTDATA);\r\n"));
            if (StringHelper.Length((String)this.strAfterCode) > 0) {
                writer.write(this.strAfterCode);
            }
            writer.write("}");
            writer.write(",\r\n");
            this.ajaxSuccessAction.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

