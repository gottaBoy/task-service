/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Web.Render;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class FormMacroParam
implements TemplateMethodModel {
    protected SRFExForm form = null;

    public void setForm(SRFExForm form) {
        this.form = form;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (this.form == null) {
            throw new TemplateModelException("\u8868\u5355\u5bf9\u8c61\u65e0\u6548");
        }
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"%1$s", (Object)this.form.getFormId());
        }
        String strParam = arg0.get(0).toString();
        if (StringHelper.Compare((String)strParam, (String)"id", (boolean)true) == 0) {
            return StringHelper.Format((String)"'%1$s'", (Object)this.form.getFormId());
        }
        throw new TemplateModelException(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u53c2\u6570[%1$s]", (Object)strParam));
    }
}

