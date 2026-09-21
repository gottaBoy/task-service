/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppExplorerView
 *  net.ibizsys.model.control.expbar.IPSExpBar
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppExplorerView;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.model.control.expbar.IPSExpBar;

public class PSAppExplorerViewImpl
extends PSAppViewImpl
implements IPSAppExplorerView {
    public static final String CTRL_EXPBAR = "expbar";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public boolean isEnableDP() {
        return true;
    }

    public boolean isEnableWF() {
        return false;
    }

    protected IPSExpBar getPSExpBar() throws Exception {
        return (IPSExpBar)this.getPSControl(CTRL_EXPBAR);
    }

    public boolean isIFrameMode() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSAPPPORTALVIEW";
    }
}

