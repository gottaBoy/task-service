/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.io.Writer;
import java.util.Vector;

public class SRFExBaseFormAction {
    protected Vector params = null;
    protected String strActionName = "";
    protected SRFExBaseForm baseForm = null;
    protected String strActionParams = "";
    protected String strResourceId = "";
    protected boolean bEnabled = true;

    public void setForm(SRFExBaseForm form) {
        this.baseForm = form;
        this.OnSetForm();
    }

    protected void OnSetForm() {
    }

    public SRFExBaseForm getForm() {
        return this.baseForm;
    }

    public String getActionName() {
        return this.strActionName;
    }

    public synchronized void Render(Writer writer) {
        this.OnRender(writer);
    }

    protected void OnRender(Writer writer) {
    }

    public String getResourceId() {
        if (StringHelper.Length((String)this.strResourceId) != 0 && this.baseForm != null) {
            String strFormResourceId = this.baseForm.getResourceId();
            if (StringHelper.Length((String)strFormResourceId) == 0) {
                return "";
            }
            return StringHelper.Format((String)"%1$s.%2$s", (Object)strFormResourceId, (Object)this.strResourceId);
        }
        return "";
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    public void setEnabled(boolean bEnabled) {
        this.bEnabled = bEnabled;
    }

    public boolean getEnabled() {
        SRFExWebContext webContext;
        IUserPrivilegeMgr iUserPrivilegeMgr;
        if (!this.bEnabled) {
            return false;
        }
        String strButtonResourceId = this.getResourceId();
        if (StringHelper.Length((String)strButtonResourceId) > 0 && this.baseForm != null && (iUserPrivilegeMgr = (webContext = this.baseForm.getPage().getWebContext()).GetUserPrivilegeMgr()) != null) {
            return iUserPrivilegeMgr.Test(webContext, strButtonResourceId);
        }
        return true;
    }
}

