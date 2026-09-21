/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDESideBarExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDESideBarExplorerViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDESideBarExplorerView {
    private boolean bShowDataInfoBar = true;
    private String strSideBarLayout = "LEFT";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.bShowDataInfoBar = !this.psViewBase.isVIEWPARAM6Null() ? this.psViewBase.getVIEWPARAM6() : this.isShowDataInfoBarDefault();
        this.strSideBarLayout = this.psViewBase.getVIEWPARAM8();
        if (StringHelper.isNullOrEmpty((String)this.strSideBarLayout)) {
            this.strSideBarLayout = this.isMobileView() ? "TOP" : "LEFT";
        }
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
    }

    @Override
    public boolean isIFrameMode() {
        return false;
    }

    @Override
    protected boolean isIgnoreMDViewCheck() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4fe1\u606f\u680f", fields={"VIEWPARAM6"})
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u8fb9\u680f\u4f4d\u7f6e", codelist="ExpBarPos", fields={"VIEWPARAM8"})
    public String getSideBarLayout() {
        return this.strSideBarLayout;
    }

    protected boolean isShowDataInfoBarDefault() {
        if (!StringHelper.isNullOrEmpty((String)this.getViewType())) {
            return this.getViewType().indexOf("VIEW9") == -1;
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

