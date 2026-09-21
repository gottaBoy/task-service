/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.SimpleCollection
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 *  freemarker.template.TemplateModelIterator
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import freemarker.template.SimpleCollection;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import java.util.List;

public class PSVue2CalculatingIteratorLengthMethod
implements TemplateMethodModelEx {
    public Integer exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return 0;
        }
        SimpleCollection iteratorObj = (SimpleCollection)arg0.get(0);
        TemplateModelIterator iterator = iteratorObj.iterator();
        int num = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++num;
        }
        return num;
    }
}

