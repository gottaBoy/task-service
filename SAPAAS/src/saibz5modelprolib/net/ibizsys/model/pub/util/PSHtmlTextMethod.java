/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 */
package net.ibizsys.model.pub.util;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;

public class PSHtmlTextMethod
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
        return WebUtility.textToHTML((String)strSQLCode);
    }
}

