/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardContainer;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSGridLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBPortletPartImpl
extends PSAjaxControlContainerImpl
implements IPSDBPortletPart {
    private static final Log log = LogFactory.getLog(PSDBPortletPartImpl.class);
    private IPSDBPortletPartParam iPSDBPortletPartParam = null;
    private String strColCssClass = "";
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLayoutPos iPSLayoutPos = null;
    private int nTitleBarCloseMode = 0;
    private IPSSysUniRes iPSSysUniRes = null;
    private IPSSysImage iPSSysImage = null;
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "";
    private IPSDashboardContainer iPSDashboardContainer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.iPSDBPortletPartParam = (IPSDBPortletPartParam)iPSControlParam;
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        boolean bRegisterToContainer = true;
        if (this.getPSControlContainer().getPSAppView() != null) {
            bRegisterToContainer = this.getPSControlContainer().getPSAppView().getPSPFStyle().isRegisterToContainer();
        }
        if (this.iPSDBPortletPartParam.getTitleBarCloseMode() != null) {
            this.nTitleBarCloseMode = this.iPSDBPortletPartParam.getTitleBarCloseMode();
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSDBPortletPartParam.getPSSysUniResId())) {
            this.setPSSysUniRes(this.getPSSystem().getPSSysUniRes(this.iPSDBPortletPartParam.getPSSysUniResId()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSDBPortletPartParam.getPSSysImageId())) {
            this.setPSSysImage(this.getPSSystem().getPSSysImage(this.iPSDBPortletPartParam.getPSSysImageId()));
        }
        if (this.getPSSysImage() != null) {
            if (bRegisterToContainer) {
                this.getPSControlContainer().registerPSSysImage(this.getPSSysImage());
            } else {
                this.getPSControlContainer().getPSAppView().registerPSSysImage(this.getPSSysImage());
            }
        }
        this.iPSLayoutPos = this.calcPSLayoutPos();
        if (!StringHelper.isNullOrEmpty((String)this.iPSDBPortletPartParam.getTitlePSLanguageResId())) {
            this.titlePSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.iPSDBPortletPartParam.getTitlePSLanguageResId());
        }
        super.onInit();
        this.strColCssClass = this.prepareColCssClass();
    }

    protected IPSLayoutPos calcPSLayoutPos() throws Exception {
        IPSLayout iPSLayout = null;
        if (this.getPSDashboardContainer() != null) {
            iPSLayout = this.getPSDashboardContainer().getPSLayout();
        } else if (this.getPSControlContainer() != null && this.getPSControlContainer() instanceof IPSLayoutContainer) {
            iPSLayout = ((IPSLayoutContainer)((Object)this.getPSControlContainer())).getPSLayout();
        }
        if (iPSLayout != null) {
            int nValue;
            IPSGridLayout iPSGridLayout;
            int nDiv = 1;
            if (iPSLayout instanceof IPSGridLayout && (iPSGridLayout = (IPSGridLayout)iPSLayout).isEnableCol12ToCol24()) {
                nDiv = 2;
            }
            PSLayout psLayout = new PSLayout();
            psLayout.setBL_POS(this.iPSDBPortletPartParam.getBorderLayoutPos());
            if (this.iPSDBPortletPartParam.getColLG() > 0) {
                psLayout.setCOL_LG(this.iPSDBPortletPartParam.getColLG() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColLGOffset() > 0) {
                psLayout.setCOL_LG_OS(this.iPSDBPortletPartParam.getColLGOffset() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColMD() > 0) {
                psLayout.setCOL_MD(this.iPSDBPortletPartParam.getColMD() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColMDOffset() > 0) {
                psLayout.setCOL_MD_OS(this.iPSDBPortletPartParam.getColMDOffset() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColSM() > 0) {
                psLayout.setCOL_SM(this.iPSDBPortletPartParam.getColSM() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColSMOffset() > 0) {
                psLayout.setCOL_SM_OS(this.iPSDBPortletPartParam.getColSMOffset() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColXS() > 0) {
                psLayout.setCOL_XS(this.iPSDBPortletPartParam.getColXS() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getColXSOffset() > 0) {
                psLayout.setCOL_XS_OS(this.iPSDBPortletPartParam.getColXSOffset() / nDiv);
            }
            if (this.iPSDBPortletPartParam.getWidth() != null) {
                nValue = (int)this.iPSDBPortletPartParam.getWidth().doubleValue();
                psLayout.setWIDTH(nValue);
            }
            if (this.iPSDBPortletPartParam.getHeight() != null) {
                nValue = (int)this.iPSDBPortletPartParam.getHeight().doubleValue();
                psLayout.setHEIGHT(nValue);
            }
            psLayout.setCOLSPAN(this.iPSDBPortletPartParam.getColumnSpan());
            if (this.iPSDBPortletPartParam.getFlexGrow() > 0) {
                psLayout.setFLEXGROW(this.iPSDBPortletPartParam.getFlexGrow());
            }
            if (this.iPSDBPortletPartParam.getFlexBasis() >= 0) {
                psLayout.setFLEXBASIS(this.iPSDBPortletPartParam.getFlexBasis());
            }
            if (this.iPSDBPortletPartParam.getFlexShrink() >= 0) {
                psLayout.setFLEXSHRINK(this.iPSDBPortletPartParam.getFlexShrink());
            }
            psLayout.setVALIGNSELF(this.iPSDBPortletPartParam.getVAlignSelf());
            psLayout.setHALIGNSELF(this.iPSDBPortletPartParam.getHAlignSelf());
            return iPSLayout.createPSLayoutPos(this, psLayout);
        }
        return null;
    }

    @Override
    protected String onGetControlType() {
        return "PORTLET";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDBPortletPartParam;
    }

    @Override
    public String getModelScope() {
        return "APP";
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5e03\u5c40\u5217\u6807\u8bc6", dump=false)
    public int getDefaultColId() {
        return this.iPSDBPortletPartParam.getColumnId();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl")
    public IPSControl getContentPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6805\u683c\u5e03\u5c40\u6837\u5f0f", dump=false)
    public String getColCssClass() {
        return this.strColCssClass;
    }

    protected String prepareColCssClass() {
        StringBuilderEx sb = new StringBuilderEx();
        if (this.iPSDBPortletPartParam.getColXS() != -1) {
            sb.Append(" col-xs-%1$s", (Object)this.iPSDBPortletPartParam.getColXS());
        }
        if (this.iPSDBPortletPartParam.getColSM() != -1) {
            sb.Append(" col-sm-%1$s", (Object)this.iPSDBPortletPartParam.getColSM());
        }
        if (this.iPSDBPortletPartParam.getColMD() != -1) {
            sb.Append(" col-md-%1$s", (Object)this.iPSDBPortletPartParam.getColMD());
        }
        if (this.iPSDBPortletPartParam.getColLG() != -1) {
            sb.Append(" col-lg-%1$s", (Object)this.iPSDBPortletPartParam.getColLG());
        }
        if (this.iPSDBPortletPartParam.getColXSOffset() != -1) {
            sb.Append(" col-xs-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColXSOffset());
        }
        if (this.iPSDBPortletPartParam.getColSMOffset() != -1) {
            sb.Append(" col-sm-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColSMOffset());
        }
        if (this.iPSDBPortletPartParam.getColMDOffset() != -1) {
            sb.Append(" col-md-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColMDOffset());
        }
        if (this.iPSDBPortletPartParam.getColLGOffset() != -1) {
            sb.Append(" col-lg-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColLGOffset());
        }
        return sb.toString();
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignoredumpvalues="0.0", fields={"HEIGHT"})
    public double getHeight() {
        if (this.iPSDBPortletPartParam.getHeight() != null) {
            return this.iPSDBPortletPartParam.getHeight();
        }
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", fields={"TITLE"})
    public String getTitle() {
        return this.iPSDBPortletPartParam.getTitle();
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return this.getPSPortetType().getClassOrPkgName(strCodeType, iPSSysSFPub);
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90", fields={"TITLEPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getContentPSControl() != null) {
            this.getContentPSControl().fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        if (this.getContentPSControl() != null) {
            this.getContentPSControl().fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        if (this.getContentPSControl() != null) {
            this.getContentPSControl().fillRelatedPSCodeLists(relatedPSCodeListList);
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
    public String getModelType() {
        return "PSSYSDBPART";
    }

    @Override
    @PSModelRTMeta(description="\u663e\u5f0f\u6807\u9898\u680f", fields={"SHOWTITLEBAR"})
    public boolean isShowTitleBar() {
        if (this.iPSDBPortletPartParam.getShowTitleBar() == null) {
            return this.onGetShowTitleBar();
        }
        return this.iPSDBPortletPartParam.getShowTitleBar();
    }

    protected boolean onGetShowTitleBar() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e", dump=false)
    public String getBorderLayoutPos() {
        return this.iPSDBPortletPartParam.getBorderLayoutPos();
    }

    @Override
    @PSModelRTMeta(description="Flex\u5ef6\u4f38", dump=false)
    public int getFlexGrow() {
        if (this.iPSDBPortletPartParam.getFlexGrow() > 0) {
            return this.iPSDBPortletPartParam.getFlexGrow();
        }
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u4f4d\u7f6e", child=true)
    public IPSLayoutPos getPSLayoutPos() {
        return this.iPSLayoutPos;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0", fields={"TITLEBARCLOSEMODE"})
    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90")
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    protected void setPSSysUniRes(IPSSysUniRes iPSSysUniRes) {
        this.iPSSysUniRes = iPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    protected void setPSSysImage(IPSSysImage iPSSysImage) {
        this.iPSSysImage = iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true)
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    protected void setPSUIActionGroup(IPSUIActionGroup iPSUIActionGroup) throws Exception {
        if (this.iPSUIActionGroup != null) {
            return;
        }
        this.iPSUIActionGroup = iPSUIActionGroup;
        Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
        if (psUIActionGroupDetails != null) {
            while (psUIActionGroupDetails.hasNext()) {
                IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                if (iPSUIAction == null) continue;
                if (this.isPrepareDefaultPSAppViewLogics()) {
                    PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this);
                    this.registerPSAppViewUIAction(iPSAppViewUIAction);
                    this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                    continue;
                }
                this.getPSAppView().registerPSUIAction(iPSUIAction);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", hideempty2=true)
    public String getActionGroupExtractMode() {
        if (this.getPSUIActionGroup() == null) {
            return "";
        }
        return this.strGroupExtractMode;
    }

    protected void setActionGroupExtractMode(String strGroupExtractMode) {
        this.strGroupExtractMode = strGroupExtractMode;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getName();
        String strLogicTag = StringHelper.format((String)"%1$s_%2$s_click", (Object)strCtrlName, (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, iPSAppViewUIAction);
        this.registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3")
    public String getPortletType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868")
    public String getDynaClass() {
        return this.iPSDBPortletPartParam.getDynaClass();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u951a\u70b9", ignoredumpvalues="false")
    public boolean isEnableAnchor() {
        if (this.iPSDBPortletPartParam.isEnableAnchor() != null) {
            return this.iPSDBPortletPartParam.isEnableAnchor();
        }
        return false;
    }

    @Override
    public void setPSDashboardContainer(IPSDashboardContainer iPSDashboardContainer) {
        this.iPSDashboardContainer = iPSDashboardContainer;
        try {
            this.iPSLayoutPos = this.calcPSLayoutPos();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            this.iPSLayoutPos = null;
        }
    }

    @Override
    public IPSDashboardContainer getPSDashboardContainer() {
        return this.iPSDashboardContainer;
    }
}

