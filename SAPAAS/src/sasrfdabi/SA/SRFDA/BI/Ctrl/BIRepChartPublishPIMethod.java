/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIRepChartPublishMethod;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateModelException;
import java.util.List;

public class BIRepChartPublishPIMethod
extends BaseBIRepChartPublishMethod {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u6ca1\u6709\u6307\u5b9a\u53c2\u6570");
        }
        String strPIId = arg0.get(0).toString();
        String strContent = this.getBIRepPartPublishContext().getBIRepPIModel(strPIId);
        if (StringHelper.IsNullOrEmpty((String)strContent)) {
            return "";
        }
        return strContent;
    }
}

