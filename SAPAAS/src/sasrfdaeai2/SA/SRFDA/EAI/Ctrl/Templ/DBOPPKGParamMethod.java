/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.EAI.Ctrl.Templ;

import SA.SRFDA.EAI.Ctrl.Templ.BaseDBOPTemplMethod;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateModelException;
import java.util.List;

public class DBOPPKGParamMethod
extends BaseDBOPTemplMethod {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0 != null && arg0.size() > 0) {
            String strReal = this.getDBOPPKGContext().FindPkgParam(arg0.get(0).toString());
            if (StringHelper.IsNullOrEmpty((String)strReal)) {
                throw new TemplateModelException(StringHelper.Format((String)"\u672a\u627e\u5230[%1$s]\u5bf9\u5e94\u7684\u7cfb\u7edf\u53c2\u6570", arg0.get(0)));
            }
            return strReal;
        }
        throw new TemplateModelException("\u53c2\u6570\u4f20\u5165\u5931\u8d25");
    }
}

