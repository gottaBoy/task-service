/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;

public class PSAppExplorerViewImpl
extends PSAppViewImpl
implements IPSAppExplorerView {
    public static final String CTRL_EXPBAR = "expbar";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    protected IPSExpBar getPSExpBar() throws Exception {
        return (IPSExpBar)this.getPSControl(CTRL_EXPBAR);
    }

    @Override
    public boolean isIFrameMode() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSAPPPORTALVIEW";
    }
}

