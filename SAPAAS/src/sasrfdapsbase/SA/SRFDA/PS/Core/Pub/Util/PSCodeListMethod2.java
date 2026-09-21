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

public class PSCodeListMethod2
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 2) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u6807\u8bc6");
        }
        try {
            ICodeListModel iCodeListModel;
            String strCodeListId = (String)arg0.get(0);
            if (!StringHelper.IsNullOrEmpty((String)strCodeListId) && strCodeListId.indexOf(".") == -1) {
                if (strCodeListId.equalsIgnoreCase("CODELIST_DE2050_002")) {
                    strCodeListId = "DEType";
                }
                strCodeListId = StringHelper.Format((String)"net.ibizsys.pscore.srv.codelist.%1$sCodeListModel", (Object)strCodeListId);
            }
            if ((iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList((String)strCodeListId)) != null) {
                String strValue = (String)arg0.get(1);
                try {
                    String strCodeItemText = iCodeListModel.getCodeListText(strValue, true);
                    return strCodeItemText;
                }
                catch (Exception ex) {
                    return StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u4ee3\u7801\u503c[%1$s]", (Object)strValue);
                }
            }
            return StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", arg0.get(0));
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

