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
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.util.StringHelper;

public class DEFieldExpMethod
implements TemplateMethodModel {
    private IDEDataQueryCode iDEDataQueryCode = null;

    public DEFieldExpMethod(IDEDataQueryCode iDEDataQueryCode) {
        this.iDEDataQueryCode = iDEDataQueryCode;
    }

    public Object exec(List arg0) throws TemplateModelException {
        try {
            if (arg0.size() == 0) {
                throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u6570\u636e\u53c2\u6570"));
            }
            String strKey = arg0.get(0).toString().toUpperCase();
            String strExp = this.iDEDataQueryCode.getDEFieldExp(strKey, false);
            return strExp;
        }
        catch (Exception ex) {
            throw new TemplateModelException(ex);
        }
    }
}

