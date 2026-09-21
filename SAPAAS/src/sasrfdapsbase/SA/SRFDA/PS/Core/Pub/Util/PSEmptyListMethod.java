/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.SimpleCollection
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 *  freemarker.template.TemplateModelIterator
 */
package SA.SRFDA.PS.Core.Pub.Util;

import freemarker.template.SimpleCollection;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import java.util.List;

public class PSEmptyListMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return true;
        }
        SimpleCollection it = (SimpleCollection)arg0.get(0);
        TemplateModelIterator it2 = it.iterator();
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }
}

