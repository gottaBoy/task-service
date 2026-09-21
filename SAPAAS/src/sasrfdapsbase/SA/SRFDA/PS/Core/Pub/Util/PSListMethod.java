/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.SimpleCollection
 *  freemarker.template.SimpleSequence
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModel
 *  freemarker.template.TemplateModelException
 *  freemarker.template.TemplateModelIterator
 */
package SA.SRFDA.PS.Core.Pub.Util;

import freemarker.template.SimpleCollection;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import java.util.ArrayList;
import java.util.List;

public class PSListMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        ArrayList<TemplateModel> list;
        block5: {
            block4: {
                if (arg0.size() == 0) {
                    return null;
                }
                list = new ArrayList<TemplateModel>();
                if (!(arg0.get(0) instanceof SimpleCollection)) break block4;
                SimpleCollection it = (SimpleCollection)arg0.get(0);
                TemplateModelIterator it2 = it.iterator();
                if (it2 == null) break block5;
                while (it2.hasNext()) {
                    list.add(it2.next());
                }
                break block5;
            }
            if (arg0.get(0) instanceof SimpleSequence) {
                SimpleSequence simpleSequence = (SimpleSequence)arg0.get(0);
                int i = 0;
                while (i < simpleSequence.size()) {
                    list.add(simpleSequence.get(i));
                    ++i;
                }
            }
        }
        return list;
    }
}

