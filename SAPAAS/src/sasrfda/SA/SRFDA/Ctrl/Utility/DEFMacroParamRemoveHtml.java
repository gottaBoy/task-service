/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.WebUtility
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFDA.Ctrl.Utility.DEFMacroParam;
import SA.SRFramework.Web.WebUtility;
import freemarker.template.TemplateModelException;
import java.util.List;

public class DEFMacroParamRemoveHtml
extends DEFMacroParam {
    @Override
    public Object exec(List arg0) throws TemplateModelException {
        Object objValue = super.exec(arg0);
        if (objValue == null) {
            return "";
        }
        if (objValue instanceof String) {
            return WebUtility.Html2Text((String)((String)objValue));
        }
        return objValue;
    }
}

