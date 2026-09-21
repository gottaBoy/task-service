/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;

public class PSIBiz5LocaleMethod
implements TemplateMethodModel {
    private static HashMap<String, String> localeMap = new HashMap();

    static {
        localeMap.put("ZH_CN", "zh_CN");
        localeMap.put("EN", "en");
        localeMap.put("ZH_HK", "zh_HK");
        localeMap.put("ZH_TW", "zh_TW");
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u8bed\u8a00\u6807\u8bc6");
        }
        String strValue = localeMap.get((String)arg0.get(0));
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return (String)arg0.get(0);
        }
        String[] parts = strValue.split("[_]");
        if (parts.length == 1) {
            return parts[0].toLowerCase();
        }
        return StringHelper.Format((String)"%1$s_%2$s", (Object)parts[0].toLowerCase(), (Object)parts[1]);
    }
}

