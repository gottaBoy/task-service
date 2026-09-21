/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.DAConfigPublishContext;

public class ToolbarConfigPublishContext
extends DAConfigPublishContext
implements IToolbarConfigPublishContext {
    private boolean bReadOnlyMode = false;
    private boolean bEmbedMode = false;
    private boolean bMiniMode = false;

    @Override
    public boolean getReadOnlyMode() {
        return this.bReadOnlyMode;
    }

    @Override
    public boolean getEmbedMode() {
        return this.bEmbedMode;
    }

    public void setEmbedMode(boolean bEmbedMode) {
        this.bEmbedMode = bEmbedMode;
    }

    public void setReadOnlyMode(boolean bReadOnlyMode) {
        this.bReadOnlyMode = bReadOnlyMode;
    }

    @Override
    public boolean getMiniMode() {
        return this.bMiniMode;
    }

    public void setMiniMode(boolean bMiniMode) {
        this.bMiniMode = bMiniMode;
    }
}

