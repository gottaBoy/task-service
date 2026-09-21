/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import java.io.IOException;
import java.io.Writer;

public class SRFExFormItemUpdateSuccessAction
extends SRFExFormAjaxSuccessAction {
    public SRFExFormItemUpdateSuccessAction() {
        this.strActionName = "onitemupdateok";
        this.RegisterRetCode(5);
    }

    @Override
    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                writer.write("for(var i=0;i<_JO.items.length;i++){");
                writer.write(StringHelper.Format((String)"var _I=_JO.items[i];if(_I._T==0){%1$s.enable(_I.id,_I.enabled);}}", (Object)this.getForm().getFormId()));
                writer.write("for(var i=0;i<_JO.items.length;i++){\r\n");
                writer.write(StringHelper.Format((String)"var _I=_JO.items[i];if(_I._T==0){%1$s.S(_I.id,SRFUtility.parsestring(_I.value));continue;}\r\n", (Object)this.getForm().getFormId()));
                writer.write(StringHelper.Format((String)"if((_I._T==1)&&Ext.getDom(_I.id)){Ext.getDom(_I.id).innerHTML=_I.html;continue;}}\r\n", (Object)this.getForm().getFormId()));
                break;
            }
            default: {
                super.OnRenderProcessOnRet(nRetCode, writer);
            }
        }
    }
}

