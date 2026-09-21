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
import SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxActionSuccessAction;
import java.io.Writer;

public class SRFExFormCustomAjaxAction
extends SRFExFormAjaxAction {
    protected SRFExFormCustomAjaxActionSuccessAction ajaxSuccessAction = new SRFExFormCustomAjaxActionSuccessAction();
    protected int nParamCount = 0;

    public SRFExFormCustomAjaxAction() {
        this.ajaxSuccessAction.setParentAction(this);
        this.setActionName("custom");
    }

    @Override
    protected void OnSetForm() {
        if (this.ajaxSuccessAction != null) {
            this.ajaxSuccessAction.setForm(this.getForm());
        }
    }

    public void setActionName(String strActionName) {
        this.strActionName = strActionName;
        this.ajaxSuccessAction.setActionName(StringHelper.Format((String)"on%1$sok", (Object)strActionName));
    }

    public void setParamCount(int nParamCount) {
        this.nParamCount = nParamCount;
    }

    public SRFExFormCustomAjaxActionSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            String strFuncParam = "";
            int i = 0;
            while (i < this.nParamCount) {
                if (StringHelper.Length((String)strFuncParam) != 0) {
                    strFuncParam = String.valueOf(strFuncParam) + ",";
                }
                strFuncParam = String.valueOf(strFuncParam) + StringHelper.Format((String)"_%1$s", (Object)(i + 1));
                ++i;
            }
            writer.write(StringHelper.Format((String)"%1$s:function(%2$s){\r\n", (Object)this.getActionName(), (Object)strFuncParam));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL = %1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL = '%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT = %1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'%2$s'", (Object)this.getForm().getFormId(), (Object)this.getActionName());
            writer.write(StringHelper.Format((String)"var _PARAMS = {%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"for(var i=0;i<%1$s._ITEMS.length;i++){ \r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"_PARAMS[%1$s._ITEMS[i]]=%1$s.G(%1$s._ITEMS[i]); \r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n", (Object)form.getFormId()));
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:this.%1$s.createDelegate(this),", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:this.%1$s.createDelegate(this),", (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout: _TIMEOUT");
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
            if (StringHelper.Length((String)this.strBeforeCode) > 0) {
                writer.write(this.strBeforeCode);
            }
            writer.write(StringHelper.Format((String)"%1$s.request('POST',_URL,_CALLBACK,_POSTDATA);\r\n", (Object)form.getFormId()));
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

