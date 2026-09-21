/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxAction;
import SA.SRFramework.WebEx.Form.SRFExFormLoadConditionSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import java.io.Writer;

public class SRFExFormLoadConditionAction
extends SRFExFormAjaxAction {
    protected SRFExFormLoadConditionSuccessAction ajaxSuccessAction = null;
    protected boolean bLoadDefault = false;

    public SRFExFormLoadConditionAction() {
        this.strActionName = "loadcondition";
        this.ajaxSuccessAction = new SRFExFormLoadConditionSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public SRFExFormLoadConditionSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExSearchForm form = (SRFExSearchForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_1,_2){\r\n", (Object)this.getActionName()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'loadcondition',searchpanelid:_1,searchthemeid:_2", (Object)this.getForm().getFormId());
            writer.write(StringHelper.Format((String)"var _PARAMS ={%1$s};\r\n", (Object)strPostParams));
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:%1$s.%2$s,", (Object)form.getFormId(), (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:%1$s.%2$s,", (Object)form.getFormId(), (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT");
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
            if (StringHelper.Length((String)this.strBeforeCode) > 0) {
                writer.write(this.strBeforeCode);
            }
            writer.write(StringHelper.Format((String)"%1$s.request('POST',_URL,_CALLBACK,_POSTDATA);\r\n", (Object)form.getFormId()));
            if (StringHelper.Length((String)this.strAfterCode) > 0) {
                writer.write(this.strAfterCode);
            }
            writer.write("},\r\n");
            this.ajaxSuccessAction.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

