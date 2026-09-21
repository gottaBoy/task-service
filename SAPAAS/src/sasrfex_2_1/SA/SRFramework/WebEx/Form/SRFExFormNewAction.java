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
import java.util.Enumeration;
import java.util.Hashtable;

public class SRFExFormNewAction
extends SRFExFormSystemAction {
    protected Hashtable formItemInitValues = null;

    public SRFExFormNewAction() {
        this.strActionName = "new";
    }

    public synchronized void RegisterFormItemInitValue(String strFormItemId, String strValue) {
        if (this.getForm().getPage().IsBackEndMode()) {
            return;
        }
        if (this.formItemInitValues == null) {
            this.formItemInitValues = new Hashtable();
        }
        this.formItemInitValues.put(strFormItemId, strValue);
    }

    public synchronized void UnregisterFormItemInitValue(String strFormItemId) {
        if (this.getForm().getPage().IsBackEndMode()) {
            return;
        }
        if (this.formItemInitValues == null) {
            return;
        }
        this.formItemInitValues.remove(strFormItemId);
        if (this.formItemInitValues.size() == 0) {
            this.formItemInitValues = null;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(){", (Object)this.getActionName()));
            if (form.getResetErrorAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"%1$s.%2$s();", (Object)form.getFormId(), (Object)form.getResetErrorAction().getActionName()));
            }
            this.OutputBeforeCode(writer);
            if (this.formItemInitValues != null) {
                Enumeration en = this.formItemInitValues.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String string = (String)this.formItemInitValues.get(strKey);
                }
            }
            form.getLoadAction().getLoadDefault();
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

