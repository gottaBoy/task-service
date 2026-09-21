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
import java.util.HashMap;
import java.util.List;

public class PSMethodNameMethod
implements TemplateMethodModel {
    private HashMap<String, String> nameMap = new HashMap();

    public Object exec(List arg0) throws TemplateModelException {
        String strValue;
        block5: {
            if (arg0.size() == 0) {
                return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5b57\u7b26\u4e32");
            }
            try {
                strValue = (String)arg0.get(0);
                if (!StringHelper.IsNullOrEmpty((String)strValue)) break block5;
                return "";
            }
            catch (Exception e) {
                throw new TemplateModelException(e);
            }
        }
        String strValue2 = this.nameMap.get(strValue.toUpperCase());
        if (strValue2 != null) {
            return strValue2;
        }
        return String.valueOf(strValue.substring(0, 1).toLowerCase()) + strValue.substring(1);
    }
}

