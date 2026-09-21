/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util.pub;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;

public class PSCodeListMethod
implements TemplateMethodModel {
    public Object exec(List list) throws TemplateModelException {
        if (list.size() == 0) {
            return StringHelper.format((String)"%1$s", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u6807\u8bc6");
        }
        try {
            String string = (String)list.get(0);
            if (string.indexOf(".") == -1) {
                string = StringHelper.format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)string);
            }
            ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)string);
            return iCodeListModel;
        }
        catch (Exception exception) {
            throw new TemplateModelException(exception);
        }
    }
}

