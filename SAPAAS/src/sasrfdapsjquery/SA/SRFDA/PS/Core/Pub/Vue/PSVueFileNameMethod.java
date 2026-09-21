/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Vue;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSVueFileNameMethod
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
        return this.replaceFullName(strSQLCode);
    }

    private String replaceFullName(String strFullName) {
        strFullName = strFullName.replaceAll("_", "-");
        boolean state = false;
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
        if (Character.isUpperCase(str.charAt(0))) {
            strBuilder.append(str.substring(0, 1).toLowerCase());
            state = true;
        } else {
            strBuilder.append(str.substring(0, 1));
            state = false;
        }
        int i = 1;
        while (i < str.length()) {
            char chr = str.charAt(i);
            if (Character.isUpperCase(chr)) {
                if (state) {
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                } else {
                    strBuilder.append("-");
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                }
                state = true;
            } else {
                strBuilder.append(chr);
                state = false;
            }
            ++i;
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
        return resultStr;
    }
}

