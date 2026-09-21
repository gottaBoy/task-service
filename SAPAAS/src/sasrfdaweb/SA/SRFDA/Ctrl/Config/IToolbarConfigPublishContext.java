/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.IDAConfigPublishContext;

public interface IToolbarConfigPublishContext
extends IDAConfigPublishContext {
    public boolean getReadOnlyMode();

    public boolean getEmbedMode();

    public boolean getMiniMode();
}

