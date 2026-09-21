/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSAppIndexView;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;

public class PSAppIndexViewImpl
extends PSAppViewImpl
implements IPSAppIndexView {
    protected PSAppIndexView psAppIndexView = new PSAppIndexView();
    protected IPSAppMenu iPSAppMenu = null;
    protected IPSAppMenu topSidePSAppMenu = null;
    protected IPSAppMenu leftSidePSAppMenu = null;
    protected IPSAppMenu bottomSidePSAppMenu = null;
    protected IPSAppMenu rightSidePSAppMenu = null;
    protected boolean bDefaultPage = false;
    private IPSSysCounterRef portalPSSysCounterRef = null;
    public static final String CTRL_APPMENU = "appmenu";
    public static final String CTRL_LEFTSIDEMENU = "leftsidemenu";
    public static final String CTRL_TOPSIDEMENU = "topsidemenu";
    public static final String CTRL_RIGHTSIDEMENU = "rightsidemenu";
    public static final String CTRL_BOTTOMSIDEMENU = "bottomsidemenu";
    private String strMainMenuAlign = "";
    private IPSAppView defPSAppView = null;
    private boolean bBlankMode = false;
    private int nAppSwitchMode = 0;

    @Override
    protected void onInit() throws Exception {
        PSAppMenuParamImpl psAppMenuParamImpl;
        super.onInit();
        CallResult callResult = this.getPSModelHelper().getPSAppIndexView(this.psApplicationView.getPSAPPVIEWID(), this.psAppIndexView);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u9996\u9875\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strPSAppMenuId = this.psAppIndexView.getPSAPPMENUID();
        if (!StringHelper.IsNullOrEmpty((String)strPSAppMenuId)) {
            PSAppMenuParamImpl psAppMenuParamImpl2 = new PSAppMenuParamImpl();
            psAppMenuParamImpl2.setPSAppMenuId(strPSAppMenuId);
            this.iPSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_APPMENU, "APPMENU", psAppMenuParamImpl2);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppIndexView.getLEFTSIDEPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(this.psAppIndexView.getLEFTSIDEPSAPPMENUID());
            this.leftSidePSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_LEFTSIDEMENU, "APPMENU", psAppMenuParamImpl);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppIndexView.getRIGHTSIDEPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(this.psAppIndexView.getRIGHTSIDEPSAPPMENUID());
            this.rightSidePSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_RIGHTSIDEMENU, "APPMENU", psAppMenuParamImpl);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppIndexView.getTOPSIDEPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(this.psAppIndexView.getTOPSIDEPSAPPMENUID());
            this.topSidePSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_TOPSIDEMENU, "APPMENU", psAppMenuParamImpl);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppIndexView.getBOTTOMSIDEPSAPPMENUID())) {
            psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(this.psAppIndexView.getBOTTOMSIDEPSAPPMENUID());
            this.bottomSidePSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_BOTTOMSIDEMENU, "APPMENU", psAppMenuParamImpl);
        }
        if (!this.psAppIndexView.isDEFAULTPAGENull()) {
            this.bDefaultPage = this.psAppIndexView.getDEFAULTPAGE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAppIndexView.getDEFPSAPPVIEWID())) {
            this.defPSAppView = this.getPSApplication().getPSAppView(this.psAppIndexView.getDEFPSAPPVIEWID(), "", this);
        }
        this.portalPSSysCounterRef = this.preparePortalPSSysCounterRef();
        this.strMainMenuAlign = this.psAppIndexView.getMAINMENUSIDE();
        if (!this.psAppIndexView.isBLANKMODENull()) {
            this.bBlankMode = this.psAppIndexView.getBLANKMODE();
        }
        if (!this.psAppIndexView.isAPPSWITCHMODENull()) {
            this.nAppSwitchMode = this.psAppIndexView.getAPPSWITCHMODE();
        }
    }

    protected IPSSysCounterRef preparePortalPSSysCounterRef() throws Exception {
        if (this.psAppIndexView.isENABLECOUNTERNull() || this.psAppIndexView.getENABLECOUNTER()) {
            String strPortalCounterId = this.psAppIndexView.getPSSYSCOUNTERID();
            IPSAppCounter iPSSysCounter = null;
            if (StringHelper.IsNullOrEmpty((String)strPortalCounterId)) {
                strPortalCounterId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getPSSystem().getId(), (String)"PORTAL");
                iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strPortalCounterId, true);
            } else {
                iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strPortalCounterId, false);
            }
            if (iPSSysCounter != null) {
                JSONObject refModeObj = new JSONObject();
                return this.getPSAppView().registerPSAppCounter(iPSSysCounter, refModeObj);
            }
        }
        return null;
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
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u8fb9\u680f\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getLeftSidePSAppMenu() {
        return this.leftSidePSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u8fb9\u680f\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getRightSidePSAppMenu() {
        return this.rightSidePSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u8fb9\u680f\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getTopSidePSAppMenu() {
        return this.topSidePSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u8fb9\u680f\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getBottomSidePSAppMenu() {
        return this.bottomSidePSAppMenu;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8d77\u59cb\u89c6\u56fe", ignoredumpvalues="false", fields={"DEFAULTPAGE"})
    public boolean isDefaultPage() {
        return this.bDefaultPage;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84", hideempty2=true, fields={"APPICONPATH"})
    public String getAppIconPath() {
        return this.psAppIndexView.getAPPICONPATH();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f842", hideempty2=true, fields={"APPICONPATH2"})
    public String getAppIconPath2() {
        return this.psAppIndexView.getAPPICONPATH2();
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic()) {
            if (!StringHelper.IsNullOrEmpty((String)this.getAppIconPath())) {
                this.registerPSAppViewParam("UI.APPICONPATH", this.getAppIconPath(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getAppIconPath2())) {
                this.registerPSAppViewParam("UI.APPICONPATH2", this.getAppIconPath2(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getMainMenuAlign())) {
                this.registerPSAppViewParam("UI.MAINMENUALIGN", this.getMainMenuAlign(), "");
            }
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPortalPSSysCounterRef() {
        return this.portalPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPortalPSAppCounterRef() {
        if (this.getPortalPSSysCounterRef() != null && this.getPortalPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPortalPSSysCounterRef();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u65b9\u5411", codelist="AppIndexViewMenuAlign", fields={"MAINMENUSIDE"})
    public String getMainMenuAlign() {
        if (StringHelper.IsNullOrEmpty((String)this.strMainMenuAlign)) {
            return super.getMainMenuAlign();
        }
        return this.strMainMenuAlign;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5185\u5bb9\u89c6\u56fe", dumpref=true)
    public IPSAppView getDefPSAppView() {
        return this.defPSAppView;
    }

    @Override
    public String getModelType() {
        return "PSAPPINDEXVIEW";
    }

    @Override
    protected boolean isUserRefModeDefault() {
        return true;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getDefPSAppView() != null) {
            relatedAppViewList.add(this.getDefPSAppView());
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u89c6\u56fe\u6a21\u5f0f", fields={"BLANKMODE"})
    public boolean isBlankMode() {
        return this.bBlankMode;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5e94\u7528\u5207\u6362", fields={"APPSWITCHMODE"})
    public boolean isEnableAppSwitch() {
        return this.getAppSwitchMode() != 0;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9009\u62e9\u6a21\u5f0f", codelist="AppSwitchMode", fields={"APPSWITCHMODE"})
    public int getAppSwitchMode() {
        return this.nAppSwitchMode;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934", fields={"TITLE"}, doc="\u9ed8\u8ba4\u9996\u9875\u89c6\u56fe\u4f18\u5148\u4f7f\u7528\u524d\u7aef\u5e94\u7528\u7684\u62ac\u5934\u5b9a\u4e49{@link net.ibizsys.centralstudio.dto.PSSysAppDTO#FIELD_TITLE}")
    public String getTitle() {
        String strTitle;
        if (this.isDefaultPage() && !StringHelper.IsNullOrEmpty((String)(strTitle = this.getPSApplication().getTitle()))) {
            return strTitle;
        }
        return super.getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898", group="\u57fa\u672c", order=120, fields={"CAPTION"}, doc="\u9ed8\u8ba4\u9996\u9875\u89c6\u56fe\u4f18\u5148\u4f7f\u7528\u524d\u7aef\u5e94\u7528\u7684\u6807\u9898\u5b9a\u4e49{@link net.ibizsys.centralstudio.dto.PSSysAppDTO#FIELD_CAPTION}")
    public String getCaption() {
        String strCaption;
        if (this.isDefaultPage() && !StringHelper.IsNullOrEmpty((String)(strCaption = this.getPSApplication().getCaption()))) {
            return strCaption;
        }
        return super.getCaption();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898", fields={"SUBCAPTION"}, doc="\u9ed8\u8ba4\u9996\u9875\u89c6\u56fe\u4f18\u5148\u4f7f\u7528\u524d\u7aef\u5e94\u7528\u7684\u5b50\u6807\u9898\u5b9a\u4e49{@link net.ibizsys.centralstudio.dto.PSSysAppDTO#FIELD_SUBCAPTION}")
    public String getSubCaption() {
        String strSubCaption;
        if (this.isDefaultPage() && !StringHelper.IsNullOrEmpty((String)(strSubCaption = this.getPSApplication().getSubCaption()))) {
            return strSubCaption;
        }
        return super.getSubCaption();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u4fe1\u606f", doc="\u9ed8\u8ba4\u9996\u9875\u89c6\u56fe\u4f7f\u7528\u524d\u7aef\u5e94\u7528\u7684\u5934\u90e8\u4fe1\u606f\u5b9a\u4e49{@link net.ibizsys.centralstudio.dto.PSSysAppDTO#FIELD_HEADERINFO}")
    public String getHeaderInfo() {
        if (this.isDefaultPage()) {
            return this.getPSApplication().getHeaderInfo();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u65b9\u4fe1\u606f", doc="\u9ed8\u8ba4\u9996\u9875\u89c6\u56fe\u4f7f\u7528\u524d\u7aef\u5e94\u7528\u7684\u4e0b\u65b9\u4fe1\u606f\u5b9a\u4e49{@link net.ibizsys.centralstudio.dto.PSSysAppDTO#FIELD_BOTTOMINFO}")
    public String getBottomInfo() {
        if (this.isDefaultPage()) {
            return this.getPSApplication().getBottomInfo();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        IPSSysImage iPSSysImage;
        if (this.isDefaultPage() && (iPSSysImage = this.getPSApplication().getPSSysImage()) != null) {
            return iPSSysImage;
        }
        return super.getPSSysImage();
    }
}

