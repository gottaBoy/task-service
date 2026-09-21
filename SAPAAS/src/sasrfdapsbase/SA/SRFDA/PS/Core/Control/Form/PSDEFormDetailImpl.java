/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupBase;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormMDCtrl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDCatGroupLogicImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlPreviewable;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSThickness;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutItem;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.PSThicknessImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormDetailImpl
extends PSObjectImpl
implements IPSDEFormDetail,
IPSPFCtrlPartCodeObject,
IPSLayoutItem {
    private static final Log log = LogFactory.getLog(PSDEFormDetailImpl.class);
    protected IPSDEForm iPSDEForm;
    protected IPSDEFormDetail parentPSDEFormDetail;
    protected PSDEFormDetail psDEFormDetail;
    protected IPSThickness padding = PSThicknessImpl.getEmpty();
    protected IPSThickness margin = PSThicknessImpl.getEmpty();
    protected String strCaption = "";
    protected double fContentHeight = 0.0;
    protected double fContentWidth = 0.0;
    protected double fWidth = 0.0;
    protected double fHeight = 0.0;
    protected String strParentLayoutMode = "";
    private Map<String, IPSDEFDCatGroupLogic> psDEFDGroupLogicMap = null;
    protected static String[] DEFDLogicCats = new String[]{"PANELVISIBLE", "ITEMBLANK", "ITEMENABLE", "SCRIPTCODE_BLUR", "SCRIPTCODE_CHANGE", "SCRIPTCODE_CLICK", "SCRIPTCODE_FOCUS"};
    protected int nColSpan = 1;
    protected int nRowSpan = 1;
    private String strUniqueId = "";
    protected IPSDEFormGroupBase parentPSDEFormGroupPanel = null;
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    private String strColCssClass = "";
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysCss labelPSSysCss = null;
    private IPSSysCss ctrlPSSysCss = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private int nColWidth = -1;
    private String strLayoutMode = "";
    private String strBorderLayoutPos = "";
    private IPSLayoutPos iPSLayoutPos = null;
    private ArrayList<IPSDEFDLogic> allPSDEFDLogicList = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private String strCodeName = "";
    private boolean bRepeatContent = false;
    private int nShowMoreMode = 0;
    private int nCounterMode = 0;
    private String strCounterId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEForm iPSDEForm, IPSDEFormDetail parentPSDEFormDetail, PSDEFormDetail psDEFormDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEForm = iPSDEForm;
            this.psDEFormDetail = psDEFormDetail;
            this.parentPSDEFormDetail = parentPSDEFormDetail;
            if (this.parentPSDEFormDetail != null) {
                if (this.parentPSDEFormDetail instanceof IPSDEFormGroupPanel) {
                    this.parentPSDEFormGroupPanel = (IPSDEFormGroupPanel)this.parentPSDEFormDetail;
                }
                if (this.parentPSDEFormDetail instanceof IPSDEFormMDCtrl) {
                    this.bRepeatContent = "REPEATER".equals(((IPSDEFormMDCtrl)this.parentPSDEFormDetail).getContentType());
                    if (this.bRepeatContent) {
                        this.parentPSDEFormGroupPanel = (IPSDEFormGroupBase)this.parentPSDEFormDetail;
                    }
                } else {
                    this.bRepeatContent = this.parentPSDEFormDetail.isRepeatContent();
                }
            }
            this.setId(psDEFormDetail.getPSDEFORMDETAILID());
            this.setName(psDEFormDetail.getPSDEFORMDETAILNAME().toLowerCase());
            this.setPSObjectData(psDEFormDetail);
            this.strCodeName = this.getName();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) && this.strCodeName.indexOf("@") != -1) {
                this.strCodeName = this.strCodeName.split("[@]")[0];
            }
            this.strUniqueId = iPSDEForm.getPSAppView().generateCtrlUniId();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getMARGIN())) {
                this.margin = new PSThicknessImpl(psDEFormDetail.getMARGIN());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPADDING())) {
                this.padding = new PSThicknessImpl(psDEFormDetail.getPADDING());
            }
            this.strCaption = this.psDEFormDetail.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEForm().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEFormDetail.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.getPSDEForm().getPSAppView().getPSApplication().getPSLanguageRes(psDEFormDetail.getTIPPSLANRESID());
            }
            if (!this.psDEFormDetail.isSHOWMOREMODENull()) {
                this.nShowMoreMode = this.psDEFormDetail.getSHOWMOREMODE();
            }
            this.strBorderLayoutPos = this.psDEFormDetail.getBL_POS();
            this.strLayoutMode = this.psDEFormDetail.getLAYOUTMODE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                if (this.parentPSDEFormGroupPanel == null) {
                    this.strLayoutMode = this.getPSDEForm().getLayoutMode();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                        this.strLayoutMode = "TABLE";
                    }
                } else {
                    this.strLayoutMode = this.parentPSDEFormGroupPanel.getLayoutMode();
                }
            }
            if (this.isDesignMode()) {
                IPSPF iPSPF = this.getPSDEForm().getPSAppView().getPSApplication().getPSPF();
                if (iPSPF.isUseJITDesignPreview()) {
                    this.strLayoutMode = ((IPSControlPreviewable)((Object)this.getPSDEForm())).getPreviewPSPF().getFormLayoutMode();
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0 && this.getPSDEForm().getPSAppView().getPSApplication().getPFType().indexOf("PREVIEW_") != 0) {
                    this.strLayoutMode = "TABLE_12COL";
                }
            }
            int nColumnCount = 12;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
                nColumnCount = 12;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
                nColumnCount = 24;
            }
            if (this.psDEFormDetail.getCOLSPAN() > 0) {
                this.nColSpan = this.psDEFormDetail.getCOLSPAN();
            }
            if (this.psDEFormDetail.getROWSPAN() > 0) {
                this.nRowSpan = this.psDEFormDetail.getROWSPAN();
            }
            if (!this.psDEFormDetail.isCOL_XSNull()) {
                this.nColXS = this.psDEFormDetail.getCOL_XS();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColXS *= 2;
                }
                if (this.nColXS <= 0 || this.nColXS > nColumnCount) {
                    this.nColXS = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_SMNull()) {
                this.nColSM = this.psDEFormDetail.getCOL_SM();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColSM *= 2;
                }
                if (this.nColSM <= 0 || this.nColSM > nColumnCount) {
                    this.nColSM = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_MDNull()) {
                this.nColMD = this.psDEFormDetail.getCOL_MD();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColMD *= 2;
                }
                if (this.nColMD <= 0 || this.nColMD > nColumnCount) {
                    this.nColMD = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_LGNull()) {
                this.nColLG = this.psDEFormDetail.getCOL_LG();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColLG *= 2;
                }
                if (this.nColLG <= 0 || this.nColLG > nColumnCount) {
                    this.nColLG = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_XS_OSNull()) {
                this.nColXSOffset = this.psDEFormDetail.getCOL_XS_OS();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColXSOffset *= 2;
                }
                if (this.nColXSOffset <= 0 || this.nColXSOffset > nColumnCount - 1) {
                    this.nColXSOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_SM_OSNull()) {
                this.nColSMOffset = this.psDEFormDetail.getCOL_SM_OS();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColSMOffset *= 2;
                }
                if (this.nColSMOffset <= 0 || this.nColSMOffset > nColumnCount - 1) {
                    this.nColSMOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_MD_OSNull()) {
                this.nColMDOffset = this.psDEFormDetail.getCOL_MD_OS();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColMDOffset *= 2;
                }
                if (this.nColMDOffset <= 0 || this.nColMDOffset > nColumnCount - 1) {
                    this.nColMDOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_LG_OSNull()) {
                this.nColLGOffset = this.psDEFormDetail.getCOL_LG_OS();
                if (this.getPSDEForm().isEnableCol12ToCol24()) {
                    this.nColLGOffset *= 2;
                }
                if (this.nColLGOffset <= 0 || this.nColLGOffset > nColumnCount - 1) {
                    this.nColLGOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_WIDTHNull()) {
                this.nColWidth = this.psDEFormDetail.getCOL_WIDTH();
                if (this.nColWidth <= 0) {
                    this.nColWidth = -1;
                }
            }
            if (this.parentPSDEFormGroupPanel != null) {
                if (this.nColXS == -1) {
                    this.nColXS = this.parentPSDEFormGroupPanel.getChildColXS();
                }
                if (this.nColSM == -1) {
                    this.nColSM = this.parentPSDEFormGroupPanel.getChildColSM();
                }
                if (this.nColMD == -1) {
                    this.nColMD = this.parentPSDEFormGroupPanel.getChildColMD();
                }
                if (this.nColLG == -1) {
                    this.nColLG = this.parentPSDEFormGroupPanel.getChildColLG();
                }
            }
            if (this.parentPSDEFormGroupPanel != null && this.parentPSDEFormGroupPanel instanceof IPSLayoutContainer) {
                IPSLayout iPSLayout = ((IPSLayoutContainer)((Object)this.parentPSDEFormGroupPanel)).getPSLayout();
                PSLayout psLayout = new PSLayout();
                psLayout.proxy(this.psDEFormDetail);
                this.iPSLayoutPos = iPSLayout.createPSLayoutPos(this, psLayout);
            }
            boolean bRegisterToContainer = true;
            if (this.getPSDEForm().getPSAppView() != null) {
                bRegisterToContainer = this.getPSDEForm().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEFormDetail.getPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDEForm().registerPSSysCss(this.iPSSysCss);
                } else if (this.getPSDEForm().getPSAppView() != null) {
                    this.getPSDEForm().getPSAppView().registerPSSysCss(this.iPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getLABELPSSYSCSSID())) {
                this.labelPSSysCss = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEFormDetail.getLABELPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDEForm().registerPSSysCss(this.labelPSSysCss);
                } else if (this.getPSDEForm().getPSAppView() != null) {
                    this.getPSDEForm().getPSAppView().registerPSSysCss(this.labelPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getCTRLPSSYSCSSID())) {
                this.ctrlPSSysCss = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEFormDetail.getCTRLPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDEForm().registerPSSysCss(this.ctrlPSSysCss);
                } else if (this.getPSDEForm().getPSAppView() != null) {
                    this.getPSDEForm().getPSAppView().registerPSSysCss(this.ctrlPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFormDetail.getPSSYSIMAGEID());
                if (bRegisterToContainer) {
                    this.getPSDEForm().registerPSSysImage(this.iPSSysImage);
                } else if (this.getPSDEForm().getPSAppView() != null) {
                    this.getPSDEForm().getPSAppView().registerPSSysImage(this.iPSSysImage);
                }
            }
            this.iPSSysCounterRef = this.preparePSSysCounterRef();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getCOUNTERID())) {
                this.strCounterId = this.psDEFormDetail.getCOUNTERID();
                if (!this.psDEFormDetail.isCOUNTERMODENull() && this.psDEFormDetail.getCOUNTERMODE() >= 0) {
                    this.nCounterMode = this.psDEFormDetail.getCOUNTERMODE();
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSSYSCOUNTERID())) {
            this.iPSSysCounter = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCounter(this.psDEFormDetail.getPSSYSCOUNTERID(), false);
            if (this.getPSDEForm().getPSAppView() != null) {
                IPSAppCounter iPSAppCounter = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppCounter(this.psDEFormDetail.getPSSYSCOUNTERID(), false);
                this.iPSSysCounter = iPSAppCounter;
                if (this.isPrepareTemplV2logic()) {
                    return this.getPSDEForm().registerPSAppCounter(iPSAppCounter, null);
                }
                return this.getPSDEForm().getPSAppView().registerPSSysCounter(iPSAppCounter, null);
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    protected void onInit() throws Exception {
        if (!this.getPSDEForm().isDesignMode() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getUCPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDEForm().getPSAppView().getPSApplication() != null ? this.getPSDEForm().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEFormDetail.getUCPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSDEForm().getControlType(), this.getDetailType()) : this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEFormDetail.getUCPSSYSPFPLUGINID());
            this.getPSDEForm().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
        }
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSDEForm().getPSAppView().getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDEForm().getPSAppView(), (Object)this.getPSDEForm(), (Object)this);
            }
        }
        super.onInit();
        this.strColCssClass = this.prepareColCssClass();
        this.onPreparePSDEFDLogics();
    }

    protected String prepareColCssClass() {
        StringBuilderEx sb = new StringBuilderEx();
        if (this.nColXS != -1) {
            sb.Append(" col-xs-%1$s", (Object)this.nColXS);
        }
        if (this.nColSM != -1) {
            sb.Append(" col-sm-%1$s", (Object)this.nColSM);
        }
        if (this.nColMD != -1) {
            sb.Append(" col-md-%1$s", (Object)this.nColMD);
        }
        if (this.nColLG != -1) {
            sb.Append(" col-lg-%1$s", (Object)this.nColLG);
        }
        if (this.nColXSOffset != -1) {
            sb.Append(" col-xs-offset-%1$s", (Object)this.nColXSOffset);
        }
        if (this.nColSMOffset != -1) {
            sb.Append(" col-sm-offset-%1$s", (Object)this.nColSMOffset);
        }
        if (this.nColMDOffset != -1) {
            sb.Append(" col-md-offset-%1$s", (Object)this.nColMDOffset);
        }
        if (this.nColLGOffset != -1) {
            sb.Append(" col-lg-offset-%1$s", (Object)this.nColLGOffset);
        }
        return sb.toString();
    }

    protected void onPreparePSDEFDLogics() throws Exception {
        FDLogicCatCodeListModel fdLogicCatCodeListModel = (FDLogicCatCodeListModel)CodeListGlobal.getCodeList(FDLogicCatCodeListModel.class);
        String[] stringArray = DEFDLogicCats;
        int n = DEFDLogicCats.length;
        int n2 = 0;
        while (n2 < n) {
            String strDEFDLogicCat = stringArray[n2];
            ArrayList<PSDEFDLogic> psDEFDLogicList = this.psDEFormDetail.getChildPSDEFDLogics(strDEFDLogicCat, false);
            if (psDEFDLogicList != null) {
                if (this.psDEFDGroupLogicMap == null) {
                    this.psDEFDGroupLogicMap = new LinkedHashMap<String, IPSDEFDCatGroupLogic>();
                }
                PSDEFDLogic psDEFDLogic = new PSDEFDLogic();
                psDEFDLogic.setPSDEFDLOGICID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strDEFDLogicCat));
                psDEFDLogic.setPSDEFDLOGICNAME(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355\u6210\u5458[%1$s][%2$s]\u903b\u8f91", (Object)this.getName(), (Object)fdLogicCatCodeListModel.getCodeListText(strDEFDLogicCat, true)));
                psDEFDLogic.setGROUPOP("AND");
                psDEFDLogic.setLOGICTYPE("GROUP");
                psDEFDLogic.setLOGICCAT(strDEFDLogicCat);
                psDEFDLogic.getChildPSDEFDLogics(true).addAll(psDEFDLogicList);
                PSDEFDCatGroupLogicImpl iPSDEFDLogic = new PSDEFDCatGroupLogicImpl();
                iPSDEFDLogic.init(this.getDAGlobalHelper(), this, null, psDEFDLogic);
                if (iPSDEFDLogic.getPSDEFDLogics() != null) {
                    this.psDEFDGroupLogicMap.put(strDEFDLogicCat, iPSDEFDLogic);
                    this.fillAllPSDEFDLogic(iPSDEFDLogic);
                }
            }
            ++n2;
        }
    }

    @Override
    public void layout() throws Exception {
        this.onLayout();
    }

    protected void onLayout() throws Exception {
        if (this.getParentPSDEFormDetail() == null) {
            return;
        }
        this.fHeight = this.psDEFormDetail.getHEIGHT();
        double fHeight = this.fHeight;
        if (fHeight > 0.0 && (fHeight -= (double)(this.getMargin().getTop() + this.getMargin().getBottom())) < 0.0) {
            fHeight = 0.0;
        }
        this.fContentHeight = fHeight;
        this.fWidth = this.psDEFormDetail.getWIDTH();
        double fWidth = this.fWidth;
        if (fWidth > 0.0 && (fWidth -= (double)(this.getMargin().getLeft() + this.getMargin().getRight())) < 0.0) {
            fWidth = 0.0;
        }
        this.fContentWidth = fWidth;
        IPSDEFormGroupPanel iPSDEFormGroupPanel = null;
        if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel) {
            iPSDEFormGroupPanel = (IPSDEFormGroupPanel)this.getParentPSDEFormDetail();
        }
        if (iPSDEFormGroupPanel == null) {
            return;
        }
        String strLayoutType = iPSDEFormGroupPanel.getLayoutMode();
        this.setParentLayoutMode(iPSDEFormGroupPanel.getLayoutMode());
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"TABLE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"AUTOTABLE", (boolean)true) == 0) {
            int nColSpan = iPSDEFormGroupPanel.getItemColSpan(this);
            int nRowId = iPSDEFormGroupPanel.getItemRowId(this);
            int nColId = iPSDEFormGroupPanel.getItemColId(this);
            fWidth = 0.0;
            int i = nColId;
            while (i < nColId + nColSpan) {
                fWidth += iPSDEFormGroupPanel.getColumnWidths()[i];
                ++i;
            }
            if (fWidth <= 1.0) {
                this.fWidth = fWidth;
                this.fContentWidth = fWidth;
            } else {
                this.fWidth = fWidth;
                this.fContentWidth = fWidth -= (double)(this.getMargin().getLeft() + this.getMargin().getRight());
            }
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"TABLE_12COL", (boolean)true) != 0) {
            SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"TABLE_24COL", (boolean)true);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"BORDER", (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getBorderLayoutPos())) {
                this.setBorderLayoutPos("CENTER");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getBorderLayoutPos())) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e", (Object)this.getName()));
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"CENTER", (boolean)true) == 0) {
                this.fWidth = 0.0;
                this.fHeight = 0.0;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"EAST", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"WEST", (boolean)true) == 0) {
                this.fHeight = 0.0;
                if (this.fWidth <= 1.0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u5bbd\u5ea6", (Object)this.getName()));
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"NORTH", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"SOUTH", (boolean)true) == 0) {
                this.fWidth = 0.0;
                if (this.fHeight <= 1.0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u9ad8\u5ea6", (Object)this.getName()));
                }
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.onGetCapPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    protected IPSLanguageRes onGetCapPSLanguageRes() {
        return null;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", fields={"SHOWCAPTION"})
    public boolean isShowCaption() {
        if (this.psDEFormDetail.isSHOWCAPTIONNull()) {
            return true;
        }
        return this.psDEFormDetail.getSHOWCAPTION();
    }

    @Override
    public IPSThickness getPadding() {
        return this.padding;
    }

    @Override
    public IPSThickness getMargin() {
        return this.margin;
    }

    @Override
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @Override
    public IPSDEFormDetail getParentPSDEFormDetail() {
        return this.parentPSDEFormDetail;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="FormDetailType2", fields={"DETAILTYPE"})
    public final String getDetailType() {
        return this.onGetDetailType();
    }

    protected String onGetDetailType() {
        return this.psDEFormDetail.getDETAILTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getContentWidth() {
        return this.fContentWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getContentHeight() {
        return this.fContentHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignoredumpvalues="0.0", fields={"WIDTH"}, ignoresetvalues="0.0")
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignoredumpvalues="0.0", fields={"HEIGHT"}, ignoresetvalues="0.0")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
    }

    protected void setParentLayoutMode(String strParentLayoutMode) {
        this.strParentLayoutMode = strParentLayoutMode;
    }

    @Override
    public String getParentLayoutMode() {
        return this.strParentLayoutMode;
    }

    @Override
    public IPSDEFDCatGroupLogic getPSDEFDGroupLogic(String strCat) throws Exception {
        if (this.psDEFDGroupLogicMap == null) {
            return null;
        }
        IPSDEFDCatGroupLogic iPSDEFDGroupLogic = this.psDEFDGroupLogicMap.get(strCat);
        return iPSDEFDGroupLogic;
    }

    protected void registerPSDEFDGroupLogic(String strCat, IPSDEFDCatGroupLogic iPSDEFDGroupLogic) throws Exception {
        if (this.psDEFDGroupLogicMap == null) {
            this.psDEFDGroupLogicMap = new LinkedHashMap<String, IPSDEFDCatGroupLogic>();
        }
        this.psDEFDGroupLogicMap.put(strCat, iPSDEFDGroupLogic);
    }

    protected void removePSDEFDGroupLogic(String strCat) throws Exception {
        if (this.psDEFDGroupLogicMap != null) {
            this.psDEFDGroupLogicMap.remove(strCat);
            if (this.psDEFDGroupLogicMap.size() == 0) {
                this.psDEFDGroupLogicMap = null;
            }
        }
    }

    public boolean isDesignMode() {
        return this.iPSDEForm.isDesignMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEForm.getPSSysModelInstId();
    }

    @Override
    public int getColSpan() throws Exception {
        return this.nColSpan;
    }

    @Override
    public int getRowSpan() throws Exception {
        return this.nRowSpan;
    }

    @Override
    public final String getUniqueId() {
        return this.strUniqueId;
    }

    @Override
    public int getColXS() {
        return this.nColXS;
    }

    @Override
    public int getColSM() {
        return this.nColSM;
    }

    @Override
    public int getColMD() {
        return this.nColMD;
    }

    @Override
    public int getColLG() {
        return this.nColLG;
    }

    @Override
    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    @Override
    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    @Override
    public int getColMDOffset() {
        return this.nColMDOffset;
    }

    @Override
    public int getColLGOffset() {
        return this.nColLGOffset;
    }

    @Override
    public String getColCssClass() {
        return this.strColCssClass;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u56fe\u6807", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.onGetPSSysImage();
    }

    protected IPSSysImage onGetPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u7b7e\u6837\u5f0f\u8868", fields={"LABELPSSYSCSSID"})
    public IPSSysCss getLabelPSSysCss() {
        return this.labelPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"LABELRAWCSSSTYLE"})
    public String getLabelCssStyle() {
        return this.psDEFormDetail.getLABELRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868", hideempty2=true, fields={"LABELDYNACLASS"})
    public String getLabelDynaClass() {
        return this.psDEFormDetail.getLABELDYNACLASS();
    }

    @Override
    public int getColWidth() {
        return this.nColWidth;
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        psDEFormDetailList.add(this);
    }

    @Override
    public IPSDEFormDetail getRootPSDEFormDetail() {
        if (this.getParentPSDEFormDetail() == null) {
            return this;
        }
        return this.getParentPSDEFormDetail().getRootPSDEFormDetail();
    }

    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEForm().getPSDataEntity().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6837\u5f0f", codelist="FormDetailStyle", fields={"DETAILSTYLE"})
    public String getDetailStyle() {
        String strDetailStyle = this.psDEFormDetail.getDETAILSTYLE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDetailStyle)) {
            strDetailStyle = this.getDefaultDetailStyle();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDetailStyle)) {
            return "DEFAULT";
        }
        return strDetailStyle;
    }

    protected String getDefaultDetailStyle() {
        return this.getPSDEForm().getDefaultDetailStyle();
    }

    @Override
    public String getBorderLayoutPos() {
        return this.strBorderLayoutPos;
    }

    protected void setBorderLayoutPos(String strBorderLayoutPos) {
        this.strBorderLayoutPos = strBorderLayoutPos;
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEForm().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEForm().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEForm().getPSAppView().getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSDEForm().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u4ee3\u7801\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"DETAIL_%1$s", (Object)this.getDetailType());
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u6210\u5458\u52a8\u6001\u903b\u8f91", child=true)
    public Iterator<IPSDEFDCatGroupLogic> getPSDEFDGroupLogics() {
        if (this.psDEFDGroupLogicMap == null || this.psDEFDGroupLogicMap.size() == 0) {
            return null;
        }
        return this.psDEFDGroupLogicMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u4f4d\u7f6e", child=true)
    public IPSLayoutPos getPSLayoutPos() {
        return this.iPSLayoutPos;
    }

    @Override
    public Iterator<IPSDEFDLogic> getAllPSDEFDLogics() {
        if (this.allPSDEFDLogicList == null || this.allPSDEFDLogicList.size() == 0) {
            return null;
        }
        return this.allPSDEFDLogicList.iterator();
    }

    protected void fillAllPSDEFDLogic(IPSDEFDLogic iPSDEFDLogic) throws Exception {
        IPSDEFDGroupLogic iPSDEFDGroupLogic;
        Iterator<IPSDEFDLogic> psDEFDLogics;
        if (this.allPSDEFDLogicList == null) {
            this.allPSDEFDLogicList = new ArrayList();
        }
        this.allPSDEFDLogicList.add(iPSDEFDLogic);
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic && (psDEFDLogics = (iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic).getPSDEFDLogics()) != null) {
            while (psDEFDLogics.hasNext()) {
                this.fillAllPSDEFDLogic(psDEFDLogics.next());
            }
        }
    }

    @Override
    public IPSLayout getPSLayout() {
        return null;
    }

    protected boolean isPrepareTemplV2logic() {
        return this.getPSDEForm().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEForm();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u8f93\u51fa\u5185\u5bb9", ignoredumpvalues="false")
    public boolean isRepeatContent() {
        return this.bRepeatContent;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u66f4\u591a\u6a21\u5f0f", codelist="FormDetailShowMoreMode", ignoredumpvalues="0", fields={"SHOWMOREMODE"})
    public int getShowMoreMode() {
        return this.nShowMoreMode;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u66f4\u591a\u7ba1\u7406\u8005", dumpref=true, doc="\u6210\u5458\u914d\u7f6e\u663e\u5f0f\u66f4\u591a\u6a21\u5f0f\u4e3a\u53d7\u63a7\u5185\u5bb9(1)\u65f6\u83b7\u53d6\u914d\u7f6e\u4e3a\u7ba1\u7406\u5bb9\u5668(2)\u7684\u4ece\u7236\u6210\u5458")
    public IPSDEFormDetail getShowMoreMgrPSDEFormDetail() {
        if (this.getShowMoreMode() != 1) {
            return null;
        }
        IPSDEFormDetail parent = this.getParentPSDEFormDetail();
        while (parent != null) {
            if (parent.getShowMoreMode() == 2) {
                return parent;
            }
            parent = parent.getParentPSDEFormDetail();
        }
        return null;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSDEForm();
    }

    public String getPredefinedType() {
        return this.psDEFormDetail.getPREDEFINEDTYPE();
    }

    public String getRenderMode() {
        return this.psDEFormDetail.getRENDERMODE();
    }

    public IPSSysCss getCtrlPSSysCss() {
        return this.ctrlPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psDEFormDetail.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"RAWCSSSTYLE"})
    public String getCssStyle() {
        return this.psDEFormDetail.getRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6c34\u5e73\u5bf9\u9f50", codelist="GridColAlign", fields={"COLALIGN"})
    public String getColumnAlign() {
        return this.onGetColumnAlign();
    }

    protected String onGetColumnAlign() {
        return this.psDEFormDetail.getCOLALIGN();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.nCounterMode;
    }

    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="IPSDEForm", fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u72b6\u6001", ignorert=3, ignoredumpvalues="0", fields={"MODELSTATE"})
    public int getModelState() {
        if (!this.psDEFormDetail.isMODELSTATENull()) {
            return this.psDEFormDetail.getMODELSTATE();
        }
        return 0;
    }
}

