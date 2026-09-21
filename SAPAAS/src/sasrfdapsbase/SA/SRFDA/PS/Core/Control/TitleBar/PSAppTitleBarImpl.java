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
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSAppTitleBar;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBarParam;
import SA.SRFDA.PS.Core.Control.TitleBar.PSTitleBarImplBase;
import SA.SRFDA.PS.Core.Control.TitleBar.PSTitleBarParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSAppTitleBar;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSAppTitleBarImpl
extends PSTitleBarImplBase
implements IPSAppTitleBar {
    public static final String LEFTAPPMENUNAME = "_leftappmenu";
    public static final String RIGHTAPPMENUNAME = "_rightappmenu";
    protected PSAppTitleBar psAppTitleBar;
    protected PSTitleBarParamImpl psTitleBarParamImpl = new PSTitleBarParamImpl();
    protected IPSAppMenu leftPSAppMenu = null;
    protected IPSAppMenu rightPSAppMenu = null;
    private IPSSysImage iPSSysImage = null;
    private boolean bInvalidId = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        IPSTitleBarParam iPSTitleBarParam = (IPSTitleBarParam)iPSControlParam;
        this.psAppTitleBar = new PSAppTitleBar();
        if (!StringHelper.IsNullOrEmpty((String)iPSTitleBarParam.getPSTitleBarId())) {
            CallResult callResult = this.getPSModelHelper().getPSAppTitleBar(iPSTitleBarParam.getPSTitleBarId(), this.psAppTitleBar);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u6807\u9898\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psAppTitleBar.getPSAPPTITLEBARID());
        } else {
            this.setId(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
            this.bInvalidId = true;
        }
        this.setName(strName);
        this.setLogicName(this.psAppTitleBar.getPSAPPTITLEBARNAME());
        this.setPSObjectData(this.psAppTitleBar);
        this.psTitleBarParamImpl.setPSSysCssId(this.psAppTitleBar.getPSSYSCSSID());
        this.psTitleBarParamImpl.setPSSysPFPluginId(this.psAppTitleBar.getPSSYSPFPLUGINID());
        this.psTitleBarParamImpl.setPSDEUILogicGroupId(this.psAppTitleBar.getPSCTRLLOGICGROUPID());
        this.psTitleBarParamImpl.merge(iPSControlParam);
        this.setCaption(this.psAppTitleBar.getCAPTION());
        if (!StringHelper.IsNullOrEmpty((String)this.psAppTitleBar.getCAPPSLANRESID())) {
            this.setCapPSLanguageRes(this.getPSApplication().getPSLanguageRes(this.psAppTitleBar.getCAPPSLANRESID()));
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psTitleBarParamImpl);
    }

    @Override
    protected void onInit() throws Exception {
        PSDEViewCtrl appmenuPSDEViewCtrl;
        PSAppMenuParamImpl psAppMenuParamImpl;
        if (!StringHelper.IsNullOrEmpty((String)this.psAppTitleBar.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSAppView().getPSApplication().getPSSystem().getPSSysImage(this.psAppTitleBar.getPSSYSIMAGEID());
            this.getPSAppView().registerPSSysImage(this.iPSSysImage);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppTitleBar.getLEFTPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            appmenuPSDEViewCtrl = new PSDEViewCtrl();
            appmenuPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + RIGHTAPPMENUNAME);
            psAppMenuParamImpl.setPSAppMenuId(this.psAppTitleBar.getLEFTPSAPPMENUID());
            psAppMenuParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), appmenuPSDEViewCtrl);
            this.leftPSAppMenu = (IPSAppMenu)this.registerPSControl(String.valueOf(this.getName()) + LEFTAPPMENUNAME, "APPMENU", psAppMenuParamImpl);
            if (this.getLeftPSAppMenu() != null) {
                this.registerLeftPSControl(this.getLeftPSAppMenu());
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppTitleBar.getRIGHTPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            appmenuPSDEViewCtrl = new PSDEViewCtrl();
            appmenuPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + RIGHTAPPMENUNAME);
            psAppMenuParamImpl.setPSAppMenuId(this.psAppTitleBar.getRIGHTPSAPPMENUID());
            psAppMenuParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), appmenuPSDEViewCtrl);
            this.rightPSAppMenu = (IPSAppMenu)this.registerPSControl(String.valueOf(this.getName()) + RIGHTAPPMENUNAME, "APPMENU", psAppMenuParamImpl);
            if (this.getRightPSAppMenu() != null) {
                this.registerRightPSControl(this.getRightPSAppMenu());
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u5e94\u7528\u83dc\u5355")
    public IPSAppMenu getLeftPSAppMenu() {
        return this.leftPSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u5e94\u7528\u83dc\u5355")
    public IPSAppMenu getRightPSAppMenu() {
        return this.rightPSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u6837\u5f0f", codelist="TitleBarStyle")
    public String getTitleBarStyle() {
        return this.psAppTitleBar.getTITLEBARSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u7c7b\u578b")
    public String getTitleBarType() {
        return "APPTITLEBAR";
    }

    @Override
    public String getModelType() {
        return "PSAPPTITLEBAR";
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }
}

