/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.IWSPagePublishContext;
import freemarker.template.TemplateMethodModel;

public abstract class BaseWSPagePublishMethodModel
implements TemplateMethodModel {
    IWSPagePublishContext iWSPagePublishContext = null;

    public IWSPagePublishContext getWSPagePublishContext() {
        return this.iWSPagePublishContext;
    }

    public void setWSPagePublishContext(IWSPagePublishContext iWSPagePublishContext) {
        this.iWSPagePublishContext = iWSPagePublishContext;
    }
}

