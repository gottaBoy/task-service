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
import java.util.List;

public class PSIBiz5MsgMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"");
        }
        Object strValue = arg0.get(0);
        if (strValue == null) {
            return "";
        }
        String strSQLCode = (String)strValue;
        strSQLCode = strSQLCode.replace("'", "''");
        return PSIBiz5MsgMethod.utf8ToUnicode(strSQLCode);
    }

    public static String utf8ToUnicode(String inStr) {
        try {
            StringBuffer unicode = new StringBuffer();
            int i = 0;
            while (i < inStr.length()) {
                char c = inStr.charAt(i);
                Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
                if (ub == Character.UnicodeBlock.BASIC_LATIN) {
                    unicode.append(c);
                } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    int j = c - 65248;
                    unicode.append((char)j);
                } else {
                    unicode.append("\\u" + Integer.toHexString(c));
                }
                ++i;
            }
            return unicode.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}

