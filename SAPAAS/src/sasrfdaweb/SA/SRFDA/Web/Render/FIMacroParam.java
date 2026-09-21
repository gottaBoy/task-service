/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Web.Render;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class FIMacroParam
implements TemplateMethodModel {
    protected SRFExForm form = null;
    protected IDEHelper iDEHelper = null;

    public void setForm(SRFExForm form) {
        this.form = form;
    }

    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (this.form == null) {
            throw new TemplateModelException("\u8868\u5355\u5bf9\u8c61\u65e0\u6548");
        }
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
        }
        String strParam = arg0.get(0).toString();
        SRFExControl control = this.form.FindControl(strParam);
        if (control != null) {
            return StringHelper.Format((String)"'%1$s'", (Object)control.getUniqueID());
        }
        throw new TemplateModelException(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strParam));
    }
}

