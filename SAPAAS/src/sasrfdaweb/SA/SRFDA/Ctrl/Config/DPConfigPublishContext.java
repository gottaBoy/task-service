/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.Data.Form
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IDPConfigPublishContext;
import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.Data.Form;

public class DPConfigPublishContext
extends DAConfigPublishContext
implements IDPConfigPublishContext {
    private Form form = null;

    @Override
    public Form getForm() {
        return this.form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}

