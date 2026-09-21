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

public class PSUnicodeStringMethod
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
        return PSUnicodeStringMethod.utf8ToUnicode(strSQLCode);
    }

    public static String utf8ToUnicode(String inStr) {
        char[] myBuffer = inStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < inStr.length()) {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(myBuffer[i]);
            if (ub == Character.UnicodeBlock.BASIC_LATIN) {
                sb.append(myBuffer[i]);
            } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                int j = myBuffer[i] - 65248;
                sb.append((char)j);
            } else {
                short s = (short)myBuffer[i];
                String hexS = Integer.toHexString(s);
                String unicode = "\\u" + hexS;
                sb.append(unicode.toLowerCase());
            }
            ++i;
        }
        return sb.toString();
    }
}

