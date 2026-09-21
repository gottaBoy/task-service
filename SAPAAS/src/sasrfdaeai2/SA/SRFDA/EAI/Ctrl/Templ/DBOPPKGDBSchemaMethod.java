/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.EAI.Ctrl.Templ;

import SA.SRFDA.EAI.Ctrl.Templ.BaseDBOPTemplMethod;
import freemarker.template.TemplateModelException;
import java.util.List;

public class DBOPPKGDBSchemaMethod
extends BaseDBOPTemplMethod {
    public Object exec(List arg0) throws TemplateModelException {
        try {
            if (arg0.size() == 0) {
                return this.getDBOPPKGContext().FindDBSchema("");
            }
            String strParam = arg0.get(0).toString();
            return this.getDBOPPKGContext().FindDBSchema(strParam);
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

