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
import java.util.HashMap;
import java.util.List;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PSSysRTDEFInputTipHelper;

public class PSCodeListContentMethod
implements TemplateMethodModel {
    public Object exec(List list) throws TemplateModelException {
        if (list.size() == 0) {
            return StringHelper.format((String)"%1$s", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u6807\u8bc6");
        }
        try {
            ICodeListModel iCodeListModel;
            String string = (String)list.get(0);
            if (string.indexOf(".") == -1) {
                string = StringHelper.format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)string);
            }
            if ((iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)string)) == null) {
                return StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)string);
            }
            String string2 = "GLOBAL_CODELIST";
            if (list.size() >= 2) {
                string2 = (String)list.get(1);
            }
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("codelist", iCodeListModel);
            return PSSysRTDEFInputTipHelper.getDEFInputTip(string2, null, hashMap, false, false).getContent();
        }
        catch (Exception exception) {
            throw new TemplateModelException(exception);
        }
    }
}

