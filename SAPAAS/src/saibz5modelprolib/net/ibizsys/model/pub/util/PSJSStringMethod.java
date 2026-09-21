/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub.util;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;

public class PSJSStringMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.format((String)"");
        }
        Object strValue = arg0.get(0);
        if (strValue == null) {
            return "";
        }
        String strSQLCode = (String)strValue;
        strSQLCode = strSQLCode.replace("\\", "\\\\");
        strSQLCode = strSQLCode.replace("'", "\\'");
        strSQLCode = strSQLCode.replace("\n", "\\n");
        strSQLCode = strSQLCode.replace("\r", "\\r");
        return strSQLCode;
    }
}

