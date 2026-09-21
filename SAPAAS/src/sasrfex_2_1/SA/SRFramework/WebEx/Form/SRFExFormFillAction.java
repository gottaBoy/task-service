/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import java.io.Writer;

public class SRFExFormFillAction
extends SRFExFormSystemAction {
    public SRFExFormFillAction() {
        this.strActionName = "fill";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_JO){", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;", (Object)form.getFormId()));
            if (form.getResetErrorAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"_F.%1$s();", (Object)form.getResetErrorAction().getActionName()));
            }
            this.OutputBeforeCode(writer);
            writer.write("for(var i=0;i<_JO.items.length;i++){");
            writer.write(StringHelper.Format((String)"var _I=_JO.items[i];if(_I._T==0){_F.enable(_I.id,_I.enabled);}}"));
            writer.write("for(var i=0;i<_JO.items.length;i++){\r\n");
            writer.write(StringHelper.Format((String)"var _I=_JO.items[i];"));
            if (form.isEnableItemPrivilege()) {
                writer.write(StringHelper.Format((String)"_F._IP[_I.id]=_I._P;"));
            }
            writer.write(StringHelper.Format((String)"if(_I._T==0){_F.S(_I.id,SRFUtility.parsestring(_I.value));continue;}\r\n"));
            writer.write(StringHelper.Format((String)"if((_I._T==1)&&Ext.getDom(_I.id)){Ext.getDom(_I.id).innerHTML=_I.html;continue;}}\r\n"));
            if (form.getItemValueChangedAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"_F.%1$s('');\r\n", (Object)form.getItemValueChangedAction().getActionName()));
            }
            writer.write(StringHelper.Format((String)"_F._FF=true;\r\n"));
            writer.write(StringHelper.Format((String)"$P.form['%1$s'].firefilled();\r\n", (Object)form.getFormId()));
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

