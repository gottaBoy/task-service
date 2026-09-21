/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package net.ibizsys.model.pub.ionic4;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSIonic4FileNameMethod
implements TemplateMethodModel {
    public Object exec(List list) throws TemplateModelException {
        throw new Error("Unresolved compilation problem: \n\tStringHelper cannot be resolved\n");
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

