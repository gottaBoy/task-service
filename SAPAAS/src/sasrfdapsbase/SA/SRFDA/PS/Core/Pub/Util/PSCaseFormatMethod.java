/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.CaseFormat
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Util;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSCaseFormatMethod
implements TemplateMethodModel {
    static Map<String, CaseFormat> CaseFormatMap = new HashMap<String, CaseFormat>();
    private static String Format;

    static {
        CaseFormatMap.put("l-h", CaseFormat.LOWER_HYPHEN);
        CaseFormatMap.put("lC", CaseFormat.LOWER_CAMEL);
        CaseFormatMap.put("l_u", CaseFormat.LOWER_UNDERSCORE);
        CaseFormatMap.put("U_U", CaseFormat.UPPER_UNDERSCORE);
        CaseFormatMap.put("UC", CaseFormat.UPPER_CAMEL);
        Format = "(value,'x2y')\uff0cxy\u4e3al-h;lC;l_u;U_U;UC";
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 2) {
            return Format;
        }
        Object objValue = arg0.get(0);
        if (StringHelper.isNullOrEmpty(objValue)) {
            return "";
        }
        Object objFormat = arg0.get(1);
        if (StringHelper.isNullOrEmpty(objFormat)) {
            return Format;
        }
        String[] parts = ((String)objFormat).split("[2]");
        if (parts.length != 2) {
            return Format;
        }
        CaseFormat from = CaseFormatMap.get(parts[0]);
        CaseFormat to = CaseFormatMap.get(parts[1]);
        if (from == null || to == null) {
            return Format;
        }
        return from.to(to, (String)objValue);
    }
}

