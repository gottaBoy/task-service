/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxAction;
import SA.SRFramework.WebEx.Form.SRFExFormSearchSuccessAction;
import java.io.Writer;

public class SRFExFormSearchAction
extends SRFExFormAjaxAction {
    protected SRFExFormSearchSuccessAction ajaxSuccessAction = null;

    public SRFExFormSearchAction() {
        this.strActionName = "search";
        this.ajaxSuccessAction = new SRFExFormSearchSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExFormSearchSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){\r\n", (Object)this.getActionName()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'search'", (Object)this.getForm().getFormId());
            writer.write(StringHelper.Format((String)"var _PARAMS ={%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"for(var i=0;i<%1$s._ITEMS.length;i++){ \r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"_PARAMS[%1$s._ITEMS[i]]=%1$s.getvalue(%1$s._ITEMS[i]);\r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n", (Object)form.getFormId()));
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:this.%1$s,", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:this.%1$s,", (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT");
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"%1$s.request('POST',_URL,_CALLBACK,_POSTDATA);\r\n", (Object)form.getFormId()));
            this.OutputAfterCode(writer);
            writer.write("}");
            writer.write(",\r\n");
            this.ajaxSuccessAction.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

