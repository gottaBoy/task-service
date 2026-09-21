/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util.pub;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PSSysRTDEFInputTipHelper;

public class PSSysRTDEFInputTipMethod
implements TemplateMethodModel {
    public Object exec(List list) throws TemplateModelException {
        if (list.size() == 0) {
            return StringHelper.format((String)"%1$s", (Object)"\u6ca1\u6709\u6307\u5b9a\u8fd0\u884c\u65f6\u63d0\u793a\u6807\u8bb0");
        }
        try {
            String string = (String)list.get(0);
            return PSSysRTDEFInputTipHelper.getDEFInputTip(string).getContent();
        }
        catch (Exception exception) {
            throw new TemplateModelException(exception);
        }
    }
}

