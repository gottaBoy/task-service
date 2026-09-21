/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppFuncPickupView;
import SA.SRFDA.PS.Core.App.View.PSAppUtilViewImpl;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class PSAppFuncPickupViewImpl
extends PSAppUtilViewImpl
implements IPSAppFuncPickupView {
    protected IPSAppMenu iPSAppMenu = null;
    public static final String CTRL_APPMENU = "appmenu";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strPSAppMenuId = this.psAppUtilView.getPSAPPMENUID();
        if (!StringHelper.IsNullOrEmpty((String)strPSAppMenuId)) {
            PSAppMenuParamImpl psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(strPSAppMenuId);
            this.iPSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_APPMENU, "APPMENU", psAppMenuParamImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e94\u7528\u529f\u80fd\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        if (this.iPSAppMenu == null) {
            return null;
        }
        return this.iPSAppMenu.getPSAppFuncs();
    }

    @Override
    protected boolean isUserRefModeDefault() {
        return true;
    }
}

