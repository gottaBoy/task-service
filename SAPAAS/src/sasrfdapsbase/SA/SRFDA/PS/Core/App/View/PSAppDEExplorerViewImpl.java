/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSAppDEExplorerViewImpl
extends PSAppDEViewImpl
implements IPSAppDEExplorerView {
    protected boolean bShowDataInfoBar = true;
    private boolean bLoadDefault = true;

    @Override
    protected void onInit() throws Exception {
        this.bLoadDefault = !this.psViewBase.isLOADDEFAULTNull() ? this.psViewBase.getLOADDEFAULT() : this.isLoadDefaultDefault();
        this.bShowDataInfoBar = !this.psViewBase.isVIEWPARAM6Null() ? this.psViewBase.getVIEWPARAM6() : this.isShowDataInfoBarDefault();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4fe1\u606f\u680f")
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    public boolean isIFrameMode() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e")
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    protected boolean isLoadDefaultDefault() {
        return true;
    }

    protected boolean isShowDataInfoBarDefault() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

