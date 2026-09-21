/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 */
package SA.SRFDA.EAI.Ctrl.Templ;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import freemarker.template.TemplateMethodModel;

public abstract class BaseDBOPTemplMethod
implements TemplateMethodModel {
    protected IDBOPPKGContext iDBOPPKGContext = null;

    public IDBOPPKGContext getDBOPPKGContext() {
        return this.iDBOPPKGContext;
    }

    public void setDBOPPKGContext(IDBOPPKGContext iDBOPPKGContext) {
        this.iDBOPPKGContext = iDBOPPKGContext;
    }
}

