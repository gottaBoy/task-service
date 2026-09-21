/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPEVTabView
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Data.PP.PPEVTabView;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;

public interface ITabViewConfigPublishContext
extends IDAConfigPublishContext {
    public String getDERGroupId();

    public PPEVTabView getPPEVTabView();

    public boolean isPublishForm();
}

