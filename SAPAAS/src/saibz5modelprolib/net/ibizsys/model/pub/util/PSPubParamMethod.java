/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package net.ibizsys.model.pub.util;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.model.pub.util.PSTemplHelper;

public class PSPubParamMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return null;
        }
        if (PSTemplHelper.getCurrentParams() == null) {
            return null;
        }
        Object strValue = arg0.get(0);
        if (strValue == null) {
            return null;
        }
        String strKey = (String)strValue;
        return PSTemplHelper.getCurrentParams().get(strKey);
    }
}

