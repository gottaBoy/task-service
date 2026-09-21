/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import java.util.Properties;

public class PSEntitySetCodeMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 1) {
            throw new TemplateModelException("\u53c2\u6570\u4e0d\u6b63\u786e");
        }
        Properties setCodeProperties = (Properties)arg0.get(0);
        for (Object object : setCodeProperties.keySet()) {
        }
        String strFunc = (String)arg0.get(0);
        int nSrc = Integer.parseInt(arg0.get(1).toString());
        int nDst = Integer.parseInt(arg0.get(2).toString());
        if (StringHelper.Compare((String)strFunc, (String)"&", (boolean)true) == 0) {
            if ((nSrc & nDst) > 0) {
                return true;
            }
            return false;
        }
        if (StringHelper.Compare((String)strFunc, (String)"|", (boolean)true) == 0) {
            if ((nSrc | nDst) > 0) {
                return true;
            }
            return false;
        }
        return false;
    }
}

