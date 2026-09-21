/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxAction;
import SA.SRFramework.WebEx.Form.SRFExFormSaveConditionSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import java.io.Writer;

public class SRFExFormSaveConditionAction
extends SRFExFormAjaxAction {
    protected SRFExFormSaveConditionSuccessAction ajaxSuccessAction = null;

    public SRFExFormSaveConditionAction() {
        this.strActionName = "savecondition";
        this.ajaxSuccessAction = new SRFExFormSaveConditionSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExFormSaveConditionSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExSearchForm form = (SRFExSearchForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_1,_2,_3){\r\n", (Object)this.getActionName()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'savecondition',searchpanelid:'%2$s',searchthemeid:_1,searchthemename:_2", (Object)form.getFormId(), (Object)form.getSearchPanelId());
            writer.write(StringHelper.Format((String)"var _PARAMS={%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"for(var i=0;i<%1$s._ITEMS.length;i++){ \r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"_PARAMS[%1$s._ITEMS[i]]=%1$s.getvalue(%1$s._ITEMS[i]);\r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n"));
            writer.write("var _ARGS={};\r\n");
            writer.write("_ARGS.cb=_3;\r\n");
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:this.%1$s,", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:this.%1$s,", (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("argument:_ARGS,");
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

