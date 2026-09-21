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
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import java.io.Writer;

public class SRFExFormCustomAjaxActionEx
extends SRFExFormAjaxAction {
    protected SRFExFormAjaxSuccessAction ajaxSuccessAction = null;
    protected boolean bAppendAll = true;
    protected boolean bAppendKey = false;

    public SRFExFormCustomAjaxActionEx(SRFExFormAjaxSuccessAction ajaxSuccessAction) {
        this.ajaxSuccessAction = ajaxSuccessAction;
        ajaxSuccessAction.setParentAction(this);
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

    public SRFExFormAjaxSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_P,_T){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;", (Object)form.getFormId()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=_F._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;if(_T!=undefined){_TIMEOUT=_T;}\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"srfactiontype:'formaction',srfformid:'%1$s',srfaction:'%2$s'", (Object)this.getForm().getFormId(), (Object)this.getActionName());
            writer.write(StringHelper.Format((String)"var _PARAMS={%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"if(_P){Ext.apply(_PARAMS,_P);}\r\n"));
            if (this.isAppendAll()) {
                writer.write(StringHelper.Format((String)"for(var i=0;i<_F._ITEMS.length;i++){\r\n", (Object)form.getFormId()));
                writer.write(StringHelper.Format((String)"_PARAMS[_F._ITEMS[i]]=_F.G(_F._ITEMS[i]);\r\n", (Object)form.getFormId()));
                writer.write(StringHelper.Format((String)"}\r\n"));
            } else if (this.isAppendKey()) {
                writer.write(StringHelper.Format((String)"Ext.apply(_PARAMS,_F.getkeys());}\r\n", (Object)form.getFormId()));
            }
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:this.%1$s.createDelegate(this),", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:this.%1$s.createDelegate(this),", (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT ");
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);");
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

    public boolean isAppendAll() {
        return this.bAppendAll;
    }

    public boolean isAppendKey() {
        return this.bAppendKey;
    }

    public void setAppendAll(boolean appendAll) {
        this.bAppendAll = appendAll;
    }

    public void setAppendKey(boolean appendKey) {
        this.bAppendKey = appendKey;
    }
}

