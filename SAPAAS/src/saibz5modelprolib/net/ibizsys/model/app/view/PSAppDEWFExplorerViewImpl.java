/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFExplorerView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEWFExplorerView;
import net.ibizsys.model.app.view.PSAppDEExplorerViewImpl;

public class PSAppDEWFExplorerViewImpl
extends PSAppDEExplorerViewImpl
implements IPSAppDEWFExplorerView {
    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }
}

