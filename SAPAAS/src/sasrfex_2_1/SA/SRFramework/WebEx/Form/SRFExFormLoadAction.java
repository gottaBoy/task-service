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
import SA.SRFramework.WebEx.Form.SRFExFormLoadSuccessAction;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Vector;

public class SRFExFormLoadAction
extends SRFExFormAjaxAction {
    protected SRFExFormLoadSuccessAction ajaxSuccessAction = null;
    protected boolean bLoadDefault = false;

    public SRFExFormLoadAction() {
        this.strActionName = "load";
        this.ajaxSuccessAction = new SRFExFormLoadSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public String getLoadDefaultActionName() {
        return "loaddefault";
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public SRFExFormLoadSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            String strCallParams = "";
            String strFuncParams = "";
            Vector controls = this.getForm().getFormControls();
            int i = 0;
            while (i < controls.size()) {
                FormItemConfig formItemConfig;
                ISRFExFormItem formItem;
                SRFExControl control = (SRFExControl)controls.get(i);
                if (control instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null && (formItemConfig = formItem.getFormItemConfig()).getKey()) {
                    if (StringHelper.Length((String)strCallParams) > 0) {
                        strCallParams = String.valueOf(strCallParams) + ",";
                    }
                    if (StringHelper.Length((String)strFuncParams) > 0) {
                        strFuncParams = String.valueOf(strFuncParams) + ",";
                    }
                    strCallParams = String.valueOf(strCallParams) + StringHelper.Format((String)"%1$s.G('%2$s')", (Object)this.getForm().getFormId(), (Object)control.getUniqueID());
                    strFuncParams = String.valueOf(strFuncParams) + StringHelper.Format((String)"var%1$s", (Object)control.getID());
                }
                ++i;
            }
            if (StringHelper.Length((String)strCallParams) > 0) {
                strCallParams = String.valueOf(strCallParams) + ",";
            }
            String strCallParamCopyMode = strCallParams;
            strCallParams = String.valueOf(strCallParams) + "false";
            strCallParamCopyMode = String.valueOf(strCallParamCopyMode) + "true";
            if (StringHelper.Length((String)strFuncParams) > 0) {
                strFuncParams = String.valueOf(strFuncParams) + ",";
            }
            strFuncParams = String.valueOf(strFuncParams) + "_COPYMODE";
            writer.write(StringHelper.Format((String)"%3$s.%1$s2(%2$s);", (Object)this.getActionName(), (Object)strCallParams, (Object)this.getForm().getFormId()));
            writer.write("}\r\n");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$scm:function(){", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"%3$s.%1$s2(%2$s);", (Object)this.getActionName(), (Object)strCallParamCopyMode, (Object)this.getForm().getFormId()));
            writer.write("}\r\n");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$s2:function(%2$s){", (Object)this.getActionName(), (Object)strFuncParams));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'load',copymode:_COPYMODE", (Object)this.getForm().getFormId());
            int i2 = 0;
            while (i2 < controls.size()) {
                FormItemConfig formItemConfig;
                ISRFExFormItem formItem;
                SRFExControl control = (SRFExControl)controls.get(i2);
                if (control instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null && (formItemConfig = formItem.getFormItemConfig()).getKey()) {
                    if (StringHelper.Length((String)strPostParams) > 0) {
                        strPostParams = String.valueOf(strPostParams) + ",";
                    }
                    strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"%1$s:var%2$s", (Object)control.getUniqueID(), (Object)control.getID());
                }
                ++i2;
            }
            writer.write(StringHelper.Format((String)"var _PARAMS={%1$s};\r\n", (Object)strPostParams));
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:%1$s.%2$s,", (Object)form.getFormId(), (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:%1$s.%2$s,", (Object)form.getFormId(), (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT");
            if (this.isSyncMode()) {
                writer.write(",sync:true");
            }
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
            if (StringHelper.Length((String)this.strBeforeCode) > 0) {
                writer.write(this.strBeforeCode);
            }
            writer.write(StringHelper.Format((String)"%1$s.request('POST',_URL, _CALLBACK,_POSTDATA);\r\n", (Object)form.getFormId()));
            if (StringHelper.Length((String)this.strAfterCode) > 0) {
                writer.write(this.strAfterCode);
            }
            writer.write("}");
            writer.write(",\r\n");
            if (this.bLoadDefault) {
                writer.write(StringHelper.Format((String)"%1$sdefault:function(){\r\n", (Object)this.getActionName()));
                if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                    writer.write(StringHelper.Format((String)"var _URL=%1$s._URL;\r\n", (Object)form.getFormId()));
                } else {
                    writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
                }
                writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
                strPostParams = "";
                strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'loaddefault'", (Object)this.getForm().getFormId());
                writer.write(StringHelper.Format((String)"var _PARAMS ={%1$s};\r\n", (Object)strPostParams));
                writer.write("var _CALLBACK=");
                writer.write("{");
                writer.write(StringHelper.Format((String)"success:%1$s.%2$s,", (Object)form.getFormId(), (Object)this.ajaxSuccessAction.getActionName()));
                writer.write(StringHelper.Format((String)"failure:%1$s.%2$s,", (Object)form.getFormId(), (Object)form.getAjaxFailedAction().getActionName()));
                writer.write("timeout:_TIMEOUT");
                if (this.isSyncMode()) {
                    writer.write(",sync:true");
                }
                writer.write("};\r\n");
                writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
                writer.write(StringHelper.Format((String)"%1$s.request('POST',_URL,_CALLBACK,_POSTDATA);\r\n", (Object)form.getFormId()));
                writer.write("}");
                writer.write(",\r\n");
            }
            this.ajaxSuccessAction.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

