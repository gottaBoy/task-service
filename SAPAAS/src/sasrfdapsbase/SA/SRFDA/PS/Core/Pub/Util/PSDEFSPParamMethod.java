/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;

public class PSDEFSPParamMethod
implements TemplateMethodModel {
    private HashMap<String, String> defieldParamMap = null;

    public PSDEFSPParamMethod(HashMap<String, String> defieldParamMap) {
        this.defieldParamMap = defieldParamMap;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u540d\u79f0");
        }
        try {
            return this.defieldParamMap.get(arg0.get(0).toString().toUpperCase());
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

