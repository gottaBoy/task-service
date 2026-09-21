/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;

public class PSCtrlMethod
implements TemplateMethodModel {
    private HashMap<String, IPSGenerateCodeResult> ctrlResultMap = new HashMap();

    public Object get(String strName) throws TemplateModelException {
        if (StringHelper.IsNullOrEmpty((String)strName)) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u63a7\u4ef6\u540d\u79f0");
        }
        try {
            return this.ctrlResultMap.get(strName);
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u63a7\u4ef6\u540d\u79f0");
        }
        try {
            return this.ctrlResultMap.get((String)arg0.get(0));
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }

    public void resetCtrlResult() {
        this.ctrlResultMap.clear();
    }

    public void registerCtrlResult(String strName, IPSGenerateCodeResult iPSGenerateCodeResult) {
        this.ctrlResultMap.put(strName, iPSGenerateCodeResult);
    }
}

