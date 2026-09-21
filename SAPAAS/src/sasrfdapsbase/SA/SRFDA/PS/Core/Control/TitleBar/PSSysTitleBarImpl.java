/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSSysTitleBar;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBarParam;
import SA.SRFDA.PS.Core.Control.TitleBar.PSTitleBarImplBase;
import SA.SRFDA.PS.Core.Control.TitleBar.PSTitleBarParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysTitleBar;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSSysTitleBarImpl
extends PSTitleBarImplBase
implements IPSSysTitleBar {
    public static final String LEFTTOOLBARNAME = "_lefttoolbar";
    public static final String RIGHTTOOLBARNAME = "_righttoolbar";
    protected PSSysTitleBar psSysTitleBar;
    protected PSTitleBarParamImpl psTitleBarParamImpl = new PSTitleBarParamImpl();
    protected IPSDEToolbar leftPSDEToolbar = null;
    protected IPSDEToolbar rightPSDEToolbar = null;
    private boolean bInvalidId = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        IPSTitleBarParam iPSTitleBarParam = (IPSTitleBarParam)iPSControlParam;
        this.psSysTitleBar = new PSSysTitleBar();
        if (!StringHelper.IsNullOrEmpty((String)iPSTitleBarParam.getPSTitleBarId())) {
            CallResult callResult = this.getPSModelHelper().getPSSysTitleBar(iPSTitleBarParam.getPSTitleBarId(), this.psSysTitleBar);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u6807\u9898\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psSysTitleBar.getPSSYSTITLEBARID());
        } else {
            this.setId(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
            this.bInvalidId = true;
        }
        this.setName(strName);
        this.setLogicName(this.psSysTitleBar.getPSSYSTITLEBARNAME());
        this.setPSObjectData(this.psSysTitleBar);
        this.psTitleBarParamImpl.setPSSysPFPluginId(this.psSysTitleBar.getPSSYSPFPLUGINID());
        this.psTitleBarParamImpl.merge(iPSControlParam);
        this.setCaption(this.psSysTitleBar.getCAPTION());
        if (!StringHelper.IsNullOrEmpty((String)this.psSysTitleBar.getCAPPSLANRESID())) {
            this.setCapPSLanguageRes(this.getPSApplication().getPSLanguageRes(this.psSysTitleBar.getCAPPSLANRESID()));
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psTitleBarParamImpl);
    }

    @Override
    protected void onInit() throws Exception {
        PSDEViewCtrl toolbarPSDEViewCtrl;
        PSDEToolbarParamImpl psDEToolbarParamImpl;
        if (!StringHelper.IsNullOrEmpty((String)this.psSysTitleBar.getLEFTPSDETOOLBARID())) {
            psDEToolbarParamImpl = new PSDEToolbarParamImpl();
            toolbarPSDEViewCtrl = new PSDEViewCtrl();
            toolbarPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + LEFTTOOLBARNAME);
            toolbarPSDEViewCtrl.setPSDETOOLBARID(this.psSysTitleBar.getLEFTPSDETOOLBARID());
            psDEToolbarParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), toolbarPSDEViewCtrl);
            this.leftPSDEToolbar = (IPSDEToolbar)this.registerPSControl(String.valueOf(this.getName()) + LEFTTOOLBARNAME, "TOOLBAR", psDEToolbarParamImpl);
            if (this.getLeftPSDEToolbar() != null) {
                this.registerLeftPSControl(this.getLeftPSDEToolbar());
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSysTitleBar.getRIGHTPSDETOOLBARID())) {
            psDEToolbarParamImpl = new PSDEToolbarParamImpl();
            toolbarPSDEViewCtrl = new PSDEViewCtrl();
            toolbarPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + RIGHTTOOLBARNAME);
            toolbarPSDEViewCtrl.setPSDETOOLBARID(this.psSysTitleBar.getRIGHTPSDETOOLBARID());
            psDEToolbarParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), toolbarPSDEViewCtrl);
            this.rightPSDEToolbar = (IPSDEToolbar)this.registerPSControl(String.valueOf(this.getName()) + RIGHTTOOLBARNAME, "TOOLBAR", psDEToolbarParamImpl);
            if (this.getRightPSDEToolbar() != null) {
                this.registerRightPSControl(this.getRightPSDEToolbar());
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u5de5\u5177\u680f")
    public IPSDEToolbar getLeftPSDEToolbar() {
        return this.leftPSDEToolbar;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u5de5\u5177\u680f")
    public IPSDEToolbar getRightPSDEToolbar() {
        return this.rightPSDEToolbar;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u6837\u5f0f", codelist="TitleBarStyle")
    public String getTitleBarStyle() {
        return this.psSysTitleBar.getTITLEBARSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u7c7b\u578b")
    public String getTitleBarType() {
        return "SYSTITLEBAR";
    }

    @Override
    public String getModelType() {
        return "PSSYSTITLEBAR";
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90")
    public IPSSysImage getPSSysImage() {
        return null;
    }
}

