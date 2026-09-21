/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.SimpleCollection
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 *  freemarker.template.TemplateModelIterator
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.SimpleCollection;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import java.util.List;

public class PSNotEmptyMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return false;
        }
        Object obj = arg0.get(0);
        if (obj instanceof String) {
            return !StringHelper.IsNullOrEmpty((String)((String)obj));
        }
        if (obj instanceof SimpleCollection) {
            SimpleCollection it = (SimpleCollection)obj;
            TemplateModelIterator it2 = it.iterator();
            if (it2.hasNext()) {
                return true;
            }
            return false;
        }
        return false;
    }
}

