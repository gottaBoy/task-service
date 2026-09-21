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
import SA.SRFramework.WebEx.Form.SRFExFormInitParamsSuccessAction;
import java.io.Writer;

public class SRFExFormInitParamsAction
extends SRFExFormAjaxAction {
    protected SRFExFormInitParamsSuccessAction ajaxSuccessAction = null;

    public SRFExFormInitParamsAction() {
        this.strActionName = "initparams";
        this.ajaxSuccessAction = new SRFExFormInitParamsSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExFormInitParamsSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_P){\r\n", (Object)this.getActionName()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL = %1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL = '%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT =%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'initparams'", (Object)this.getForm().getFormId());
            writer.write(StringHelper.Format((String)"var _PARAMS = {%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"Ext.apply(_PARAMS,_P);\r\n", (Object)strPostParams));
            writer.write("var _CALLBACK =\r\n");
            writer.write("{\r\n");
            writer.write(StringHelper.Format((String)"success:%1$s.%2$s, \r\n", (Object)form.getFormId(), (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:%1$s.%2$s, \r\n", (Object)form.getFormId(), (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT");
            writer.write("};\r\n");
            writer.write("var _POSTDATA =Ext.urlEncode(_PARAMS);\r\n");
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

