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
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlPreviewable;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelItemCatGroupLogicImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
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
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSSysPanelItem;
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

public class PSSysPanelItemImpl
extends PSObjectImpl
implements IPSSysPanelItem,
IPSPFCtrlPartCodeObject,
IPSControlObject {
    private static final Log log = LogFactory.getLog(PSSysPanelItemImpl.class);
    protected IPSSysPanel iPSSysPanel;
    protected IPSSysPanelItem parentPSSysPanelItem;
    protected PSSysPanelItem psSysPanelItem;
    protected String strCaption = "";
    protected double fContentWidth = 0.0;
    protected double fContentHeight = 0.0;
    protected double fWidth = 0.0;
    protected double fHeight = 0.0;
    protected String strParentLayoutMode = "";
    protected int nColSpan = 1;
    protected int nRowSpan = 1;
    private String strUniqueId = "";
    protected IPSSysPanelContainer parentPSSysPanelContainer = null;
    private Map<String, IPSPanelItemCatGroupLogic> psPanelItemGroupLogicMap = null;
    protected static String[] PanelItemLogicCats = new String[]{"PANELVISIBLE", "ITEMBLANK", "ITEMENABLE", "SCRIPTCODE_BLUR", "SCRIPTCODE_CHANGE", "SCRIPTCODE_CLICK", "SCRIPTCODE_FOCUS"};
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
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysCss labelPSSysCss = null;
    private IPSSysCss ctrlPSSysCss = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private int nColWidth = -1;
    private String strLayoutMode = "";
    private String strBorderLayoutPos = "";
    private int nFlexGrow = -1;
    private IPSLayoutPos iPSLayoutPos = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private ArrayList<IPSPanelItemLogic> allPSPanelItemLogicList = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private int nCounterMode = 0;
    private String strCounterId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysPanel iPSSysPanel, IPSSysPanelItem parentPSSysPanelItem, PSSysPanelItem psSysPanelItem) throws Exception {
        try {
            IPSLayout iPSLayout;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysPanel = iPSSysPanel;
            this.psSysPanelItem = psSysPanelItem;
            this.parentPSSysPanelItem = parentPSSysPanelItem;
            if (this.parentPSSysPanelItem != null) {
                if (this.parentPSSysPanelItem instanceof IPSSysPanelContainer) {
                    this.parentPSSysPanelContainer = (IPSSysPanelContainer)this.parentPSSysPanelItem;
                    this.setParentLayoutMode(this.parentPSSysPanelContainer.getLayoutMode());
                }
            } else {
                this.setParentLayoutMode(iPSSysPanel.getLayoutMode());
            }
            this.setId(psSysPanelItem.getPSSYSVIEWPANELITEMID());
            this.setName(psSysPanelItem.getPSSYSVIEWPANELITEMNAME().toLowerCase());
            this.setPSObjectData(psSysPanelItem);
            this.strUniqueId = iPSSysPanel.getPSAppView().generateCtrlUniId();
            this.strCaption = this.psSysPanelItem.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSSysPanel().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysPanelItem.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysPanelItem.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.getPSSysPanel().getPSAppView().getPSApplication().getPSLanguageRes(psSysPanelItem.getTIPPSLANRESID());
            }
            this.strBorderLayoutPos = this.psSysPanelItem.getBL_POS();
            this.strLayoutMode = this.psSysPanelItem.getLAYOUTMODE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                if (this.parentPSSysPanelContainer == null) {
                    this.strLayoutMode = this.getPSSysPanel().getLayoutMode();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                        this.strLayoutMode = this.isDesignMode() ? ((IPSControlPreviewable)((Object)this.getPSPanel())).getPreviewPSPF().getPanelLayoutMode() : "TABLE";
                    }
                } else {
                    this.strLayoutMode = this.parentPSSysPanelContainer.getLayoutMode();
                }
            }
            int nColumnCount = 12;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
                nColumnCount = 12;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
                nColumnCount = 24;
            }
            if (this.psSysPanelItem.getCOLSPAN() > 0) {
                this.nColSpan = this.psSysPanelItem.getCOLSPAN();
            }
            if (this.psSysPanelItem.getROWSPAN() > 0) {
                this.nRowSpan = this.psSysPanelItem.getROWSPAN();
            }
            if (!this.psSysPanelItem.isCOL_XSNull()) {
                this.nColXS = this.psSysPanelItem.getCOL_XS();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColXS *= 2;
                }
                if (this.nColXS <= 0 || this.nColXS > nColumnCount) {
                    this.nColXS = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_SMNull()) {
                this.nColSM = this.psSysPanelItem.getCOL_SM();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColSM *= 2;
                }
                if (this.nColSM <= 0 || this.nColSM > nColumnCount) {
                    this.nColSM = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_MDNull()) {
                this.nColMD = this.psSysPanelItem.getCOL_MD();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColMD *= 2;
                }
                if (this.nColMD <= 0 || this.nColMD > nColumnCount) {
                    this.nColMD = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_LGNull()) {
                this.nColLG = this.psSysPanelItem.getCOL_LG();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColLG *= 2;
                }
                if (this.nColLG <= 0 || this.nColLG > nColumnCount) {
                    this.nColLG = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_XS_OSNull()) {
                this.nColXSOffset = this.psSysPanelItem.getCOL_XS_OS();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColXSOffset *= 2;
                }
                if (this.nColXSOffset <= 0 || this.nColXSOffset > nColumnCount - 1) {
                    this.nColXSOffset = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_SM_OSNull()) {
                this.nColSMOffset = this.psSysPanelItem.getCOL_SM_OS();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColSMOffset *= 2;
                }
                if (this.nColSMOffset <= 0 || this.nColSMOffset > nColumnCount - 1) {
                    this.nColSMOffset = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_MD_OSNull()) {
                this.nColMDOffset = this.psSysPanelItem.getCOL_MD_OS();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColMDOffset *= 2;
                }
                if (this.nColMDOffset <= 0 || this.nColMDOffset > nColumnCount - 1) {
                    this.nColMDOffset = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_LG_OSNull()) {
                this.nColLGOffset = this.psSysPanelItem.getCOL_LG_OS();
                if (this.getPSSysPanel().isEnableCol12ToCol24()) {
                    this.nColLGOffset *= 2;
                }
                if (this.nColLGOffset <= 0 || this.nColLGOffset > nColumnCount - 1) {
                    this.nColLGOffset = -1;
                }
            }
            if (!this.psSysPanelItem.isCOL_WIDTHNull()) {
                this.nColWidth = this.psSysPanelItem.getCOL_WIDTH();
                if (this.nColWidth <= 0) {
                    this.nColWidth = -1;
                }
            }
            if (!this.psSysPanelItem.isFLEXGROWNull()) {
                this.nFlexGrow = this.psSysPanelItem.getFLEXGROW();
            }
            if (this.parentPSSysPanelContainer != null) {
                if (this.nColXS == -1) {
                    this.nColXS = this.parentPSSysPanelContainer.getChildColXS();
                }
                if (this.nColSM == -1) {
                    this.nColSM = this.parentPSSysPanelContainer.getChildColSM();
                }
                if (this.nColMD == -1) {
                    this.nColMD = this.parentPSSysPanelContainer.getChildColMD();
                }
                if (this.nColLG == -1) {
                    this.nColLG = this.parentPSSysPanelContainer.getChildColLG();
                }
            }
            if (this.parentPSSysPanelContainer != null) {
                if (this.parentPSSysPanelContainer instanceof IPSLayoutContainer) {
                    iPSLayout = ((IPSLayoutContainer)((Object)this.parentPSSysPanelContainer)).getPSLayout();
                    PSLayout psLayout = new PSLayout();
                    psLayout.proxy(this.psSysPanelItem);
                    this.iPSLayoutPos = iPSLayout.createPSLayoutPos(this, psLayout);
                }
            } else {
                iPSLayout = this.getPSSysPanel().getPSLayout();
                PSLayout psLayout = new PSLayout();
                psLayout.proxy(this.psSysPanelItem);
                this.iPSLayoutPos = iPSLayout.createPSLayoutPos(this, psLayout);
            }
            boolean bRegisterToContainer = true;
            if (this.getPSSysPanel().getPSAppView() != null) {
                bRegisterToContainer = this.getPSSysPanel().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysCss(this.psSysPanelItem.getPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSSysPanel().registerPSSysCss(this.iPSSysCss);
                } else if (this.getPSSysPanel().getPSAppView() != null) {
                    this.getPSSysPanel().getPSAppView().registerPSSysCss(this.iPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getLABELPSSYSCSSID())) {
                this.labelPSSysCss = this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysCss(this.psSysPanelItem.getLABELPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSSysPanel().registerPSSysCss(this.labelPSSysCss);
                } else if (this.getPSSysPanel().getPSAppView() != null) {
                    this.getPSSysPanel().getPSAppView().registerPSSysCss(this.labelPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getCTRLPSSYSCSSID())) {
                this.ctrlPSSysCss = this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysCss(this.psSysPanelItem.getCTRLPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSSysPanel().registerPSSysCss(this.ctrlPSSysCss);
                } else if (this.getPSSysPanel().getPSAppView() != null) {
                    this.getPSSysPanel().getPSAppView().registerPSSysCss(this.ctrlPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysImage(this.psSysPanelItem.getPSSYSIMAGEID());
                if (bRegisterToContainer) {
                    this.getPSSysPanel().registerPSSysImage(this.iPSSysImage);
                } else if (this.getPSSysPanel().getPSAppView() != null) {
                    this.getPSSysPanel().getPSAppView().registerPSSysImage(this.iPSSysImage);
                }
            }
            this.iPSSysCounterRef = this.preparePSSysCounterRef();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getCOUNTERID())) {
                this.strCounterId = this.psSysPanelItem.getCOUNTERID();
                if (!this.psSysPanelItem.isCOUNTERMODENull() && this.psSysPanelItem.getCOUNTERMODE() >= 0) {
                    this.nCounterMode = this.psSysPanelItem.getCOUNTERMODE();
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

    @Override
    public String getCodeName() {
        return this.getName();
    }

    @Override
    protected void onInit() throws Exception {
        if (!this.getPSSysPanel().isDesignMode() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSSysPanel().getPSAppView().getPSApplication() != null ? this.getPSSysPanel().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psSysPanelItem.getPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSSysPanel().getControlType(), this.getItemType()) : this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysPFPlugin(this.psSysPanelItem.getPSSYSPFPLUGINID());
            this.getPSSysPanel().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
        }
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSSysPanel().getPSAppView().getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSysPanel().getPSAppView().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSSysPanel().getPSAppView(), (Object)this.getPSSysPanel(), (Object)this);
            }
        }
        super.onInit();
        this.strColCssClass = this.prepareColCssClass();
        this.onPreparePSPanelItemLogics();
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

    protected void onPreparePSPanelItemLogics() throws Exception {
        FDLogicCatCodeListModel fdLogicCatCodeListModel = (FDLogicCatCodeListModel)CodeListGlobal.getCodeList(FDLogicCatCodeListModel.class);
        String[] stringArray = PanelItemLogicCats;
        int n = PanelItemLogicCats.length;
        int n2 = 0;
        while (n2 < n) {
            String strPanelItemLogicCat = stringArray[n2];
            ArrayList<PSPanelItemLogic> psPanelItemLogicList = this.psSysPanelItem.getChildPSPanelItemLogics(strPanelItemLogicCat, false);
            if (psPanelItemLogicList != null) {
                if (this.psPanelItemGroupLogicMap == null) {
                    this.psPanelItemGroupLogicMap = new LinkedHashMap<String, IPSPanelItemCatGroupLogic>();
                }
                PSPanelItemLogic psPanelItemLogic = new PSPanelItemLogic();
                psPanelItemLogic.setPSPANELITEMLOGICID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strPanelItemLogicCat));
                psPanelItemLogic.setPSPANELITEMLOGICNAME(SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f\u6210\u5458[%1$s][%2$s]\u903b\u8f91", (Object)this.getName(), (Object)fdLogicCatCodeListModel.getCodeListText(strPanelItemLogicCat, true)));
                psPanelItemLogic.setGROUPOP("AND");
                psPanelItemLogic.setLOGICTYPE("GROUP");
                psPanelItemLogic.setLOGICCAT(strPanelItemLogicCat);
                psPanelItemLogic.getChildPSPanelItemLogics(true).addAll(psPanelItemLogicList);
                PSPanelItemCatGroupLogicImpl psPanelItemCatGroupLogicImpl = new PSPanelItemCatGroupLogicImpl();
                psPanelItemCatGroupLogicImpl.init(this.getDAGlobalHelper(), this, null, psPanelItemLogic);
                if (psPanelItemCatGroupLogicImpl.getPSPanelItemLogics() != null) {
                    this.psPanelItemGroupLogicMap.put(strPanelItemLogicCat, psPanelItemCatGroupLogicImpl);
                    this.fillAllPSPanelItemLogic(psPanelItemCatGroupLogicImpl);
                }
            }
            ++n2;
        }
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSSYSCOUNTERID()) && this.getPSSysPanel().getPSAppView() != null) {
            this.iPSSysCounter = this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysCounter(this.psSysPanelItem.getPSSYSCOUNTERID(), false);
            IPSAppCounter iPSAppCounter = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppCounter(this.psSysPanelItem.getPSSYSCOUNTERID(), false);
            this.iPSSysCounter = iPSAppCounter;
            if (this.isPrepareTemplV2logic()) {
                return this.getPSSysPanel().registerPSAppCounter(iPSAppCounter, null);
            }
            return this.getPSSysPanel().getPSAppView().registerPSSysCounter(iPSAppCounter, null);
        }
        return null;
    }

    @Override
    public void layout() throws Exception {
        this.onLayout();
    }

    protected void onLayout() throws Exception {
        double fWidth;
        double fHeight;
        this.fContentHeight = fHeight = (this.fHeight = (double)this.psSysPanelItem.getHEIGHT());
        this.fContentWidth = fWidth = (this.fWidth = (double)this.psSysPanelItem.getWIDTH());
        String strLayoutType = this.getParentLayoutMode();
        if ((SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"TABLE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutType, (String)"AUTOTABLE", (boolean)true) == 0) && this.parentPSSysPanelContainer != null) {
            int nColSpan = this.parentPSSysPanelContainer.getItemColSpan(this);
            int nRowId = this.parentPSSysPanelContainer.getItemRowId(this);
            int nColId = this.parentPSSysPanelContainer.getItemColId(this);
            fWidth = 0.0;
            int i = nColId;
            while (i < nColId + nColSpan) {
                fWidth += this.parentPSSysPanelContainer.getColumnWidths()[i];
                ++i;
            }
            if (fWidth <= 1.0) {
                this.fWidth = fWidth;
                this.fContentWidth = fWidth;
            } else {
                this.fWidth = fWidth;
                this.fContentWidth = fWidth;
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
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u9762\u677f\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e", (Object)this.getName()));
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"CENTER", (boolean)true) == 0) {
                this.fWidth = 0.0;
                this.fHeight = 0.0;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"EAST", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"WEST", (boolean)true) == 0) {
                this.fHeight = 0.0;
                if (this.fWidth <= 1.0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u9762\u677f\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u5bbd\u5ea6", (Object)this.getName()));
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"NORTH", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getBorderLayoutPos(), (String)"SOUTH", (boolean)true) == 0) {
                this.fWidth = 0.0;
                if (this.fHeight <= 1.0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u9762\u677f\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u9ad8\u5ea6", (Object)this.getName()));
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
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", ignoredumpvalues="false", fields={"SHOWCAPTION"})
    public boolean isShowCaption() {
        if (this.psSysPanelItem.isSHOWCAPTIONNull()) {
            if (this.getPSSystemSetting().isPanelItemAutoShowCaption()) {
                return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCaption());
            }
            return true;
        }
        return this.psSysPanelItem.getSHOWCAPTION();
    }

    @Override
    public IPSSysPanel getPSSysPanel() {
        return this.iPSSysPanel;
    }

    @Override
    public IPSSysPanelItem getParentPSSysPanelItem() {
        return this.parentPSSysPanelItem;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", fields={"ITEMTYPE"})
    public String getItemType() {
        return this.onGetItemType();
    }

    protected String onGetItemType() {
        return this.psSysPanelItem.getITEMTYPE();
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
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignoredumpvalues="0.0", fields={"WIDTH"})
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignoredumpvalues="0.0", fields={"HEIGHT"})
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
    }

    protected void setParentLayoutMode(String strParentLayoutMode) {
        this.strParentLayoutMode = strParentLayoutMode;
    }

    @Override
    public String getParentLayoutMode() {
        return this.strParentLayoutMode;
    }

    @Override
    public IPSPanelItemGroupLogic getPSPanelItemGroupLogic(String strCat) throws Exception {
        if (this.psPanelItemGroupLogicMap == null) {
            return null;
        }
        IPSPanelItemGroupLogic iPSPanelItemGroupLogic = this.psPanelItemGroupLogicMap.get(strCat);
        return iPSPanelItemGroupLogic;
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6210\u5458\u52a8\u6001\u903b\u8f91", child=true)
    public Iterator<IPSPanelItemCatGroupLogic> getPSPanelItemGroupLogics() {
        if (this.psPanelItemGroupLogicMap == null || this.psPanelItemGroupLogicMap.size() == 0) {
            return null;
        }
        return this.psPanelItemGroupLogicMap.values().iterator();
    }

    public boolean isDesignMode() {
        return this.iPSSysPanel.isDesignMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysPanel.getPSSysModelInstId();
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
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.onGetPSSysImage();
    }

    protected IPSSysImage onGetPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u6837\u5f0f\u8868\u5bf9\u8c61", fields={"LABELPSSYSCSSID"})
    public IPSSysCss getLabelPSSysCss() {
        return this.labelPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"LABELRAWCSSSTYLE"})
    public String getLabelCssStyle() {
        return this.psSysPanelItem.getLABELRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868", hideempty2=true, fields={"LABELDYNACLASS"})
    public String getLabelDynaClass() {
        return this.psSysPanelItem.getLABELDYNACLASS();
    }

    public IPSSysCss getCtrlPSSysCss() {
        return this.ctrlPSSysCss;
    }

    @Override
    public int getColWidth() {
        return this.nColWidth;
    }

    @Override
    public void fillPSPanelItems(ArrayList<IPSPanelItem> psPanelItemList) {
        psPanelItemList.add(this);
    }

    @Override
    public IPSPanelItem getRootPSPanelItem() {
        if (this.getParentPSSysPanelItem() == null) {
            return this;
        }
        return this.getParentPSPanelItem().getRootPSPanelItem();
    }

    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    public IPSSystem getPSSystem() {
        if (this.getPSSysPanel().getPSDataEntity() != null) {
            return this.getPSSysPanel().getPSDataEntity().getPSSystem();
        }
        if (this.getPSSysPanel().getPSAppView() != null) {
            return this.getPSSysPanel().getPSAppView().getPSSystem();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6837\u5f0f", codelist="FormDetailStyle", fields={"DETAILSTYLE"})
    public String getItemStyle() {
        String strItemStyle = this.psSysPanelItem.getDETAILSTYLE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strItemStyle)) {
            return "DEFAULT";
        }
        return strItemStyle;
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e", dump=false)
    public String getBorderLayoutPos() {
        return this.strBorderLayoutPos;
    }

    protected void setBorderLayoutPos(String strBorderLayoutPos) {
        this.strBorderLayoutPos = strBorderLayoutPos;
    }

    @Override
    @PSModelRTMeta(description="Flex\u5ef6\u4f38", dump=false)
    public int getFlexGrow() {
        return this.nFlexGrow;
    }

    @Override
    public IPSPanelItem getParentPSPanelItem() {
        return this.getParentPSSysPanelItem();
    }

    @Override
    public IPSPanel getPSPanel() {
        return this.getPSSysPanel();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysPanel().getModelId(), (Object)this.getName());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysPanel().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysPanel().getPSAppView().getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSSysPanel();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u4ee3\u7801\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"ITEM_%1$s", (Object)this.getItemType());
    }

    @Override
    @PSModelRTMeta(description="\u4f4d\u7f6e", child=true)
    public IPSLayoutPos getPSLayoutPos() {
        return this.iPSLayoutPos;
    }

    @Override
    public IPSLayout getPSLayout() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    protected boolean isPrepareTemplV2logic() {
        return this.getPSSysPanel().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public Iterator<IPSPanelItemLogic> getAllPSPanelItemLogics() {
        if (this.allPSPanelItemLogicList == null || this.allPSPanelItemLogicList.size() == 0) {
            return null;
        }
        return this.allPSPanelItemLogicList.iterator();
    }

    protected void fillAllPSPanelItemLogic(IPSPanelItemLogic iPSPanelItemLogic) throws Exception {
        IPSPanelItemGroupLogic iPSPanelItemGroupLogic;
        Iterator<IPSPanelItemLogic> psDEFDLogics;
        if (this.allPSPanelItemLogicList == null) {
            this.allPSPanelItemLogicList = new ArrayList();
        }
        this.allPSPanelItemLogicList.add(iPSPanelItemLogic);
        if (iPSPanelItemLogic instanceof IPSPanelItemGroupLogic && (psDEFDLogics = (iPSPanelItemGroupLogic = (IPSPanelItemGroupLogic)iPSPanelItemLogic).getPSPanelItemLogics()) != null) {
            while (psDEFDLogics.hasNext()) {
                this.fillAllPSPanelItemLogic(psDEFDLogics.next());
            }
        }
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public void fillPSControls(ArrayList<IPSControl> psControlList) {
    }

    public String getPredefinedType() {
        return this.psSysPanelItem.getPREDEFINEDTYPE();
    }

    public String getRenderMode() {
        return this.psSysPanelItem.getRENDERMODE();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psSysPanelItem.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"RAWCSSSTYLE"})
    public String getCssStyle() {
        return this.psSysPanelItem.getRAWCSSSTYLE();
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
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="IPSSysPanel", fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
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
    protected String onGetMOSFilePath() {
        return null;
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }

    protected boolean isRegisterToPSAppDataEntity() {
        return this.getPSSysPanel().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }
}

