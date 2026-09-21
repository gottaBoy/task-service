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
import net.ibizsys.paas.util.StringHelper;

public class PSSubCodeMethod
implements TemplateMethodModel {
    private HashMap<String, String> subCodeMap = new HashMap();

    public Object get(String strName) throws TemplateModelException {
        if (StringHelper.isNullOrEmpty((String)strName)) {
            return StringHelper.format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u540d\u79f0");
        }
        try {
            return this.subCodeMap.get(strName);
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }

    public Object exec(List arg0) throws TemplateModelException {
        String strSubCode;
        block4: {
            if (arg0.size() == 0) {
                return StringHelper.format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u540d\u79f0");
            }
            try {
                strSubCode = this.subCodeMap.get((String)arg0.get(0));
                if (strSubCode != null) break block4;
                return "";
            }
            catch (Exception e) {
                throw new TemplateModelException(e);
            }
        }
        return strSubCode;
    }

    public void resetSubCode() {
        this.subCodeMap.clear();
    }

    public void registerSubCode(String strName, String strCode) {
        this.subCodeMap.put(strName, strCode);
    }
}

