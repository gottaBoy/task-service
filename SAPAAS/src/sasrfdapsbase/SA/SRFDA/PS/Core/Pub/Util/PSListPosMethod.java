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

public class PSListPosMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 2) {
            throw new TemplateModelException("\u53c2\u6570\u4e0d\u6b63\u786e");
        }
        if (arg0.get(0) instanceof SimpleCollection) {
            SimpleCollection it = (SimpleCollection)arg0.get(0);
            Object obj = arg0.get(1);
            TemplateModelIterator it2 = it.iterator();
            if (it2 != null) {
                int nPos = 0;
                while (it2.hasNext()) {
                    if (it2.next() == obj) {
                        return nPos;
                    }
                    ++nPos;
                }
            }
        }
        return -1;
    }
}

