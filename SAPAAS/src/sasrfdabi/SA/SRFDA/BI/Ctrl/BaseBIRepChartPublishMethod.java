/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepPartPublishContext;
import freemarker.template.TemplateMethodModel;

public abstract class BaseBIRepChartPublishMethod
implements TemplateMethodModel {
    protected BIRepPartPublishContext iBIRepPartPublishContext = null;

    public BIRepPartPublishContext getBIRepPartPublishContext() {
        return this.iBIRepPartPublishContext;
    }

    public void setBIRepPartPublishContext(BIRepPartPublishContext iBIRepPartPublishContext) {
        this.iBIRepPartPublishContext = iBIRepPartPublishContext;
    }
}

