/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub.util;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.paas.util.StringHelper;

public class PSCtrlMethod
implements TemplateMethodModel {
    private HashMap<String, IPSGenerateCodeResult> ctrlResultMap = new HashMap();

    public Object get(String strName) throws TemplateModelException {
        if (StringHelper.isNullOrEmpty((String)strName)) {
            return StringHelper.format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u63a7\u4ef6\u540d\u79f0");
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
            return StringHelper.format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u63a7\u4ef6\u540d\u79f0");
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

