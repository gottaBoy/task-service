/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Form
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IEditViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Data.Form;

public class EditViewToolbarConfigPublishContext
extends ToolbarConfigPublishContext
implements IEditViewToolbarConfigPublishContext {
    private Form form = null;

    @Override
    public Form getForm() {
        return this.form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}

