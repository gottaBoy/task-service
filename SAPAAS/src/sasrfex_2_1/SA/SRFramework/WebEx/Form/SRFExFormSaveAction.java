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
import SA.SRFramework.WebEx.Form.SRFExFormSaveSuccessAction;
import java.io.Writer;

public class SRFExFormSaveAction
extends SRFExFormAjaxAction {
    protected SRFExFormSaveSuccessAction ajaxSuccessAction = null;
    public static String RESOURCEID = "SAVE";

    public SRFExFormSaveAction() {
        this.strActionName = "save";
        this.setResourceId(RESOURCEID);
        this.ajaxSuccessAction = new SRFExFormSaveSuccessAction();
        this.ajaxSuccessAction.setParentAction(this);
    }

    public SRFExFormSaveSuccessAction getSuccessAction() {
        return this.ajaxSuccessAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_NEW){", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"return %2$s.%1$s2({saveandnew:_NEW});", (Object)this.getActionName(), (Object)this.getForm().getFormId()));
            writer.write("}\r\n");
            writer.write(",");
            writer.write(StringHelper.Format((String)"%1$s2:function(param){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;\r\n", (Object)form.getFormId()));
            if (StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
                writer.write(StringHelper.Format((String)"var _URL=_F._URL;\r\n"));
            } else {
                writer.write(StringHelper.Format((String)"var _URL='%1$s';\r\n", (Object)this.getRemotePath()));
            }
            writer.write(StringHelper.Format((String)"var _TIMEOUT=%1$s;\r\n", (Object)this.getTimeout()));
            String strPostParams = "";
            strPostParams = String.valueOf(strPostParams) + StringHelper.Format((String)"actiontype:'formaction',srfformid:'%1$s',action:'save',srfcopyid:_F._COPYID,srfuf:_F._UF", (Object)this.getForm().getFormId());
            writer.write(StringHelper.Format((String)"var _PARAMS={%1$s};\r\n", (Object)strPostParams));
            writer.write(StringHelper.Format((String)"if(param){Ext.apply(_PARAMS,param);}\r\n"));
            writer.write(StringHelper.Format((String)"var _ITS=_F._ITEMS;\r\n"));
            writer.write(StringHelper.Format((String)"for(var i=0;i<_ITS.length;i++){\r\n"));
            writer.write(StringHelper.Format((String)"_PARAMS[_ITS[i]]=_F.G(_ITS[i]);", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"}\r\n"));
            writer.write("var _CALLBACK=");
            writer.write("{");
            writer.write(StringHelper.Format((String)"success:this.%1$s,", (Object)this.ajaxSuccessAction.getActionName()));
            writer.write(StringHelper.Format((String)"failure:this.%1$s,", (Object)form.getAjaxFailedAction().getActionName()));
            writer.write("timeout:_TIMEOUT");
            if (this.isSyncMode()) {
                writer.write(",sync:true");
            }
            writer.write("};\r\n");
            writer.write("var _POSTDATA=Ext.urlEncode(_PARAMS);\r\n");
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"_F.request('POST',_URL,_CALLBACK,_POSTDATA);\r\n"));
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

