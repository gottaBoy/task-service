/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;

public class CodeListMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        try {
            if (arg0.size() != 2) {
                throw new Exception(StringHelper.format("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e"));
            }
            String strCodeListId = arg0.get(0).toString();
            String strKey = arg0.get(1).toString();
            return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strKey, true);
        }
        catch (Exception ex) {
            throw new TemplateModelException(ex);
        }
    }
}

