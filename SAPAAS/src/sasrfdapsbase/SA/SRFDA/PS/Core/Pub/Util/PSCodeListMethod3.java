/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;

public class PSCodeListMethod3
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 1) {
            return StringHelper.Format((String)"%1$s", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u6807\u8bc6");
        }
        try {
            String strCodeListId = (String)arg0.get(0);
            if (!StringHelper.IsNullOrEmpty((String)strCodeListId) && strCodeListId.indexOf(".") == -1) {
                if (strCodeListId.equalsIgnoreCase("CODELIST_DE2050_002")) {
                    strCodeListId = "DEType";
                }
                strCodeListId = StringHelper.Format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)strCodeListId);
            }
            ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)strCodeListId);
            return iCodeListModel;
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

