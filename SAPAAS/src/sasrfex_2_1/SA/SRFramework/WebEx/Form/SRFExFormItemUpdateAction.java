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
import SA.SRFramework.WebEx.Form.SRFExFormItemUpdateSuccessAction;
import java.io.Writer;

public class SRFExFormItemUpdateAction
extends SRFExFormAjaxAction {
    protected SRFExFormItemUpdateSuccessAction ajaxSuccessAction = null;

    public SRFExFormItemUpdateAction() {
        this.strActionName = "itemupdate";
        this.ajaxSuccessAction = new SRFExFormItemUpdateSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExFormItemUpdateSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(param){\r\n", (Object)this.getActionName()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"srfactiontype:'formaction',srfformid:'%1$s',srfaction:'itemupdate'", (Object)this.getForm().getFormId());
            writer.write(StringHelper.Format((String)"var _PARAMS={%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"if(param){Ext.apply(_PARAMS,param);}\r\n"));
            writer.write(StringHelper.Format((String)"var _ITS=%1$s._ITEMS;\r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"for(var i=0;i<_ITS.length;i++){\r\n"));
            writer.write(StringHelper.Format((String)"_PARAMS[_ITS[i]]=%1$s.G(_ITS[i]);", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n"));
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

