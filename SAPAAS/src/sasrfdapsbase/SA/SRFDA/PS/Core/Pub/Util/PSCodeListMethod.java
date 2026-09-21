/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSCodeListMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 2) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u6807\u8bc6");
        }
        try {
            String strCodeListId = (String)arg0.get(0);
            CodeListConfig codeListConfig = GlobalHelperEx.getInstance().getCodeListMgr().GetCodeListConfig(strCodeListId);
            if (codeListConfig == null) {
                return StringHelper.Format((String)"\u65e0\u6548\u4ee3\u7801\u8868[%1$s]", (Object)strCodeListId);
            }
            String strValue = (String)arg0.get(1);
            return codeListConfig.GetCodeListValue(strValue, true);
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

