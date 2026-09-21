/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.panel.IPanelField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.PSControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.PSControlContainerImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelLogic2;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelParam;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelEngineImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelLogic2Impl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelLogicImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelModelImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.PS.Data.PSPanelEngine;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSSysPanel;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFDA.PS.Data.PSSysPanelLogic;
import SA.SRFDA.PS.Data.PSSysPanelModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.control.panel.IPanelField;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"PANEL"})
public class PSSysPanelImpl
extends PSControlContainerImpl
implements IPSSysPanel,
IPSSysLayoutPanel {
    private static final Log log = LogFactory.getLog(PSSysPanelImpl.class);
    protected PSSysPanel psSysPanel;
    private static final ArrayList<IPSPanelItem> emptyPSPanelItemList = new ArrayList();
    private static final ArrayList<IPanelField> emptyPanelFieldList = new ArrayList();
    private static final ArrayList<IPSPanelModel> emptyPSPanelModelList = new ArrayList();
    private static final ArrayList<IPSPanelLogic> emptyPSPanelLogicList = new ArrayList();
    private static final ArrayList<IPSPanelItem> emptyPSPanelRootItemList = new ArrayList();
    private static final ArrayList<IPSPanelField> emptyPSPanelFieldList = new ArrayList();
    private ArrayList<IPSPanelItem> psPanelRootItemList = null;
    private ArrayList<IPSPanelItem> psPanelItemList = null;
    private Map<String, IPSPanelItem> psPanelItemMap = null;
    private ArrayList<IPSPanelField> psPanelFieldList = null;
    private Map<String, IPSPanelField> psPanelFieldMap = null;
    private ArrayList<IPanelField> panelFieldList = null;
    private ArrayList<IPSPanelModel> psPanelModelList = null;
    private Map<String, IPSPanelModel> psPanelModelMap = null;
    private Map<String, List<PSSysPanelItem>> panelPartItemListMap = null;
    protected double fPanelWidth = 1.0;
    protected PSSysPanelParamImpl psSysPanelParamImpl = null;
    private String strCodeName = "";
    protected String strLayoutMode = "";
    private String strPanelStyle = "";
    private boolean bMobilePanel = false;
    private boolean bViewLayoutPanel = false;
    private boolean bViewProxyMode = false;
    private IPSLayout iPSLayout = null;
    private boolean bInvalidId = false;
    private int nGetDataMode = 0;
    private int nGetDataTimer = -1;
    private IPSControlHandler iPSControlHandler = null;
    private String strDataName = "";
    private List<PSSysPanelLogic2Impl> psSysPanelLogic2List = new ArrayList<PSSysPanelLogic2Impl>();
    private Map<String, String> panelIdMap = new LinkedHashMap<String, String>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSSysPanelParam iPSSysPanelParam = (IPSSysPanelParam)iPSControlParam;
            this.psSysPanel = new PSSysPanel();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSysPanelParam.getPSSysPanelId())) {
                CallResult callResult = this.getPSModelHelper().getPSSysPanel(iPSSysPanelParam.getPSSysPanelId(), this.psSysPanel);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u9762\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psSysPanel.getPSSYSVIEWPANELID());
            } else if (!this.isLayoutPanel()) {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psSysPanel.getPSSYSVIEWPANELNAME());
            this.setPSObjectData(this.psSysPanel);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanel.getPSDEID())) {
                if (this.getPSDataEntity() != null) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysPanel.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                        this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psSysPanel.getPSDEID()));
                    }
                } else {
                    this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psSysPanel.getPSDEID()));
                }
            }
            if (this.getId().indexOf("SRFTEMPKEY:") == 0) {
                this.setDesignMode(true);
                this.setPreviewPSPF(this.calcPreviewPSPF());
            }
            this.psSysPanelParamImpl = this.createPSSysPanelParamImpl();
            this.psSysPanelParamImpl.setPSSysPFPluginId(this.psSysPanel.getPSSYSPFPLUGINID());
            this.psSysPanelParamImpl.setPSSysCssId(this.psSysPanel.getPSSYSCSSID());
            this.psSysPanelParamImpl.setPSDEUILogicGroupId(this.psSysPanel.getPSCTRLLOGICGROUPID());
            this.psSysPanelParamImpl.merge(iPSControlParam);
            if (!this.psSysPanel.isPANELWIDTHNull()) {
                this.fPanelWidth = this.psSysPanel.getPANELWIDTH();
            } else if (this.getPSAppView() != null && this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
                this.fPanelWidth = 0.0;
            }
            this.strCodeName = this.psSysPanel.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strPanelStyle = this.psSysPanel.getPANELSTYLE();
            if (!this.psSysPanel.isMOBFLAGNull()) {
                this.bMobilePanel = this.psSysPanel.getMOBFLAG();
            }
            if (!this.psSysPanel.isVIEWLAYOUTFLAGNull()) {
                this.bViewLayoutPanel = this.psSysPanel.getVIEWLAYOUTFLAG() != 0;
                boolean bl = this.bViewProxyMode = this.psSysPanel.getVIEWLAYOUTFLAG() == 2;
            }
            if (!this.isViewLayoutPanel()) {
                if (!this.psSysPanel.isGETDATAMODENull()) {
                    this.nGetDataMode = this.psSysPanel.getGETDATAMODE();
                }
                if (this.getDataMode() != 0) {
                    if (this.getDataMode() == 1 || this.getDataMode() == 2) {
                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanel.getGETPSDEACTIONID())) {
                            throw new Exception("\u672a\u6307\u5b9a\u83b7\u53d6\u6570\u636e\u884c\u4e3a");
                        }
                        if (this.psSysPanel.getGETDATATIMER() > 0) {
                            this.nGetDataTimer = this.psSysPanel.getGETDATATIMER();
                        }
                    } else if (this.getDataMode() == 3 || this.getDataMode() == 4 || this.getDataMode() == 5) {
                        this.strDataName = this.psSysPanel.getDATANAME();
                        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDataName)) {
                            this.strDataName = this.getCodeName();
                        }
                    }
                }
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psSysPanelParamImpl);
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

    protected PSSysPanelParamImpl createPSSysPanelParamImpl() {
        return new PSSysPanelParamImpl();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getDataMode() != 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanel.getGETPSDEACTIONID())) {
            this.onPreparePSControlHandler();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getId())) {
            this.psPanelRootItemList = new ArrayList();
            this.psPanelItemList = new ArrayList();
            this.psPanelItemMap = new LinkedHashMap<String, IPSPanelItem>();
            this.psPanelFieldList = new ArrayList();
            this.psPanelFieldMap = new LinkedHashMap<String, IPSPanelField>();
            this.panelFieldList = new ArrayList();
            this.psPanelModelList = new ArrayList();
            this.psPanelModelMap = new LinkedHashMap<String, IPSPanelModel>();
            this.panelPartItemListMap = new LinkedHashMap<String, List<PSSysPanelItem>>();
            if (!this.bInvalidId) {
                this.onPreparePSSysPanelModels();
                this.onPreparePSSysPanelLayout();
                this.onPreparePSSysPanelItems();
                this.onPreparePSSysPanelFields();
                this.onPreparePSSysPanelLogics();
                this.onPreparePSPanelEngines();
            }
        }
        if (this.psPanelRootItemList != null) {
            for (IPSPanelItem iPSPanelRootItem : this.psPanelRootItemList) {
                iPSPanelRootItem.layout();
            }
        }
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<? extends IPSPanelItem> psPanelItems = this.getAllPSPanelItems();
        if (psPanelItems != null) {
            while (psPanelItems.hasNext()) {
                IPSPanelItem iPSPanelItem = psPanelItems.next();
                iPSPanelItem.check();
            }
        }
        return super.onCheck();
    }

    protected void onPreparePSControlHandler() throws Exception {
        PSControlHandlerImpl psControlHandlerImpl = new PSControlHandlerImpl();
        PSACHandler psACHandler = new PSACHandler();
        psControlHandlerImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psACHandler);
        this.iPSControlHandler = psControlHandlerImpl;
        PSControlHandlerActionImpl psControlHandlerActionImpl = new PSControlHandlerActionImpl();
        PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
        psACHandlerAction.setPSACHANDLERACTIONID("load");
        psACHandlerAction.setPSACHANDLERACTIONNAME("load");
        psACHandlerAction.setACTIONTYPE("DEACTION");
        psACHandlerAction.setPSDEACTIONID(this.psSysPanel.getGETPSDEACTIONID());
        psACHandlerAction.setPSDEACTIONNAME(this.psSysPanel.getGETPSDEACTIONNAME());
        psControlHandlerActionImpl.init(this.getDAGlobalHelper(), psControlHandlerImpl, psACHandlerAction);
        psControlHandlerImpl.registerPSControlAction(psControlHandlerActionImpl);
    }

    protected void onPreparePSSysPanelLayout() throws Exception {
        this.strLayoutMode = this.psSysPanel.getLAYOUTMODE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            if (this.isDesignMode()) {
                this.strLayoutMode = this.getPreviewPSPF().getPanelLayoutMode();
            } else {
                String strPFType = "";
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPFType)) {
                    strPFType = this.getPSAppView().getPSApplication().getPFType();
                }
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPFType);
                this.strLayoutMode = iPSPF.getPanelLayoutMode();
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            PSLayout psLayout = new PSLayout();
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.strLayoutMode, psLayout);
        }
    }

    protected void onPreparePSSysPanelItems() throws Exception {
        this.psPanelRootItemList.clear();
        this.panelPartItemListMap.clear();
        this.panelIdMap.clear();
        this.onPreparePSSysPanelItems(this.getId());
    }

    protected void onPreparePSSysPanelItems(String strPSSysPanelId) throws Exception {
        Vector<PSSysPanelItem> psPanelRootItemList = new Vector<PSSysPanelItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysPanelItems(strPSSysPanelId, psPanelRootItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u9762\u677f\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        this.panelIdMap.put(strPSSysPanelId, "");
        HashMap<String, PSSysPanelItem> psSysPanelItemMap = new HashMap<String, PSSysPanelItem>();
        for (PSSysPanelItem psSysPanelItem : psPanelRootItemList) {
            psSysPanelItemMap.put(psSysPanelItem.getPSSYSVIEWPANELITEMID(), psSysPanelItem);
        }
        for (PSSysPanelItem psSysPanelItem : psPanelRootItemList) {
            if ("PANELPART".equals(psSysPanelItem.getITEMTYPE())) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysPanelId, (String)this.getId(), (boolean)true) == 0) {
                    String strPSDEPanelId = psSysPanelItem.getPSDEPANELID();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEPanelId)) {
                        throw new Exception(String.format("\u9762\u677f\u90e8\u4ef6\u9879[%1$s]\u672a\u6307\u5b9a\u5f15\u7528\u9762\u677f\u90e8\u4ef6", psSysPanelItem.getPSSYSVIEWPANELITEMNAME()));
                    }
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEPanelId, (String)this.getId(), (boolean)false) == 0) {
                        throw new Exception(String.format("\u9762\u677f\u90e8\u4ef6\u9879[%1$s]\u4e0d\u80fd\u5f15\u7528\u81ea\u8eab", psSysPanelItem.getPSSYSVIEWPANELITEMNAME()));
                    }
                    this.onPreparePSSysPanelItems(strPSDEPanelId);
                    List<PSSysPanelItem> list = this.panelPartItemListMap.get(strPSDEPanelId);
                    if (list != null) {
                        for (PSSysPanelItem item : list) {
                            psSysPanelItem.getChildPSSysPanelItems(true).add(item);
                        }
                    }
                }
                psSysPanelItem.setITEMTYPE("CONTAINER");
                psSysPanelItem.setPSDEPANELID(null);
                psSysPanelItem.setPSDEPANELNAME(null);
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysPanelItem.getPPSSYSVIEWPANELITEMID())) continue;
            PSSysPanelItem psSysPanelItem2 = psSysPanelItem;
            Object parentPSSysPanelItem = (PSSysPanelItem)((Object)psSysPanelItemMap.get(psSysPanelItem.getPPSSYSVIEWPANELITEMID()));
            if (parentPSSysPanelItem == null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strPSSysPanelId, (boolean)false) == 0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)this.getLogicName(), (Object)psSysPanelItem2.getPSSYSVIEWPANELITEMNAME()));
                }
                PSSysPanel psSysPanel = new PSSysPanel();
                this.getPSModelHelper().getPSSysPanel(psSysPanelItem2.getPSSYSVIEWPANELID(), psSysPanel);
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)psSysPanel.getPSSYSVIEWPANELNAME(), (Object)psSysPanelItem2.getPSSYSVIEWPANELITEMNAME()));
            }
            ((PSSysPanelItem)((Object)parentPSSysPanelItem)).getChildPSSysPanelItems(true).add(psSysPanelItem);
        }
        Vector<PSPanelItemLogic> psPanelItemLogicList = new Vector<PSPanelItemLogic>();
        callResult = this.getPSModelHelper().getPSPanelItemLogics(strPSSysPanelId, psPanelItemLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u9762\u677f\u6210\u5458\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSPanelItemLogic> psPanelItemLogicMap = new HashMap<String, PSPanelItemLogic>();
        for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
            psPanelItemLogicMap.put(psPanelItemLogic.getPSPANELITEMLOGICID(), psPanelItemLogic);
        }
        for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psPanelItemLogic.getPPSPANELITEMLOGICID())) continue;
            PSPanelItemLogic parentPSPanelItemLogic = (PSPanelItemLogic)((Object)psPanelItemLogicMap.get(psPanelItemLogic.getPPSPANELITEMLOGICID()));
            if (parentPSPanelItemLogic != null) {
                parentPSPanelItemLogic.getChildPSPanelItemLogics(true).add(psPanelItemLogic);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u9762\u677f\u6210\u5458\u903b\u8f91[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psPanelItemLogic.getPPSPANELITEMLOGICID()), "PSPANELITEMLOGIC", "REMOVE", psPanelItemLogic.getPSPANELITEMLOGICID());
        }
        for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psPanelItemLogic.getPPSPANELITEMLOGICID())) continue;
            PSSysPanelItem psSysPanelItem = (PSSysPanelItem)((Object)psSysPanelItemMap.get(psPanelItemLogic.getPSSYSVIEWPANELITEMID()));
            if (psSysPanelItem != null) {
                psSysPanelItem.getChildPSPanelItemLogics(psPanelItemLogic.getLOGICCAT(), true).add(psPanelItemLogic);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9762\u677f\u6210\u5458[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psPanelItemLogic.getPPSPANELITEMLOGICID()), "PSPANELITEMLOGIC", "REMOVE", psPanelItemLogic.getPSPANELITEMLOGICID());
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysPanelId, (String)this.getId(), (boolean)true) == 0) {
            for (PSSysPanelItem psSysPanelItem : psPanelRootItemList) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysPanelItem.getPPSSYSVIEWPANELITEMID())) continue;
                IPSPanelDetailType iPSPanelDetailType = this.getPSModelStorage().getPSPanelDetailType(psSysPanelItem.getITEMTYPE());
                IPSSysPanelItem iPSSysPanelItem = iPSPanelDetailType.createPSSysPanelItem(psSysPanelItem);
                iPSSysPanelItem.init(this.getDAGlobalHelper(), this, null, psSysPanelItem);
                this.psPanelRootItemList.add(iPSSysPanelItem);
            }
            for (PSSysPanelItem psSysPanelItem : psPanelRootItemList) {
                psSysPanelItem.resetChildDatas();
            }
        } else {
            ArrayList<PSSysPanelItem> list = new ArrayList<PSSysPanelItem>();
            for (PSSysPanelItem psSysPanelItem : psPanelRootItemList) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysPanelItem.getPPSSYSVIEWPANELITEMID())) continue;
                list.add(psSysPanelItem);
            }
            this.panelPartItemListMap.put(strPSSysPanelId, list);
        }
    }

    protected void onPreparePSSysPanelFields() throws Exception {
        this.psPanelFieldList.clear();
        this.psPanelFieldMap.clear();
        this.psPanelItemList.clear();
        this.psPanelItemMap.clear();
        this.panelFieldList.clear();
        for (IPSPanelItem iPSPanelRootItem : this.psPanelRootItemList) {
            iPSPanelRootItem.fillPSPanelFields(this.psPanelFieldList);
        }
        for (IPSPanelItem iPSPanelRootItem : this.psPanelRootItemList) {
            iPSPanelRootItem.fillPSPanelItems(this.psPanelItemList);
        }
        HashMap<String, IPSPanelField> psPanelFieldMap = new HashMap<String, IPSPanelField>();
        for (IPSPanelField iPSSysPanelField : this.psPanelFieldList) {
            psPanelFieldMap.put(iPSSysPanelField.getName(), iPSSysPanelField);
        }
        HashMap<String, String> createItemMap = new HashMap<String, String>();
        this.fillExtPSPanelFields(psPanelFieldMap, createItemMap);
        for (IPSPanelField iPSPanelField : this.psPanelFieldList) {
            this.psPanelFieldMap.put(iPSPanelField.getId(), iPSPanelField);
            this.psPanelFieldMap.put(iPSPanelField.getName(), iPSPanelField);
        }
        for (IPSPanelItem iPSPanelItem : this.psPanelItemList) {
            this.psPanelItemMap.put(iPSPanelItem.getId(), iPSPanelItem);
            this.psPanelItemMap.put(iPSPanelItem.getName(), iPSPanelItem);
        }
        this.panelFieldList.addAll(this.psPanelFieldList);
    }

    protected void onPreparePSSysPanelModels() throws Exception {
        this.psPanelModelMap.clear();
        this.psPanelModelList.clear();
        this.onPreparePSSysPanelModels(this.getId());
    }

    protected void onPreparePSSysPanelModels(String strPSSysPanelId) throws Exception {
        PSSysPanelModelImpl psSysPanelModelImpl;
        String strCodeName;
        PSSysPanelModel psSysPanelModel;
        IPSPanelModel iPSPanelModel;
        Vector<PSSysPanelModel> psSysPanelModelList = new Vector<PSSysPanelModel>();
        CallResult callResult = this.getPSModelHelper().getPSSysPanelModels(strPSSysPanelId, psSysPanelModelList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u9762\u677f\u6a21\u578b\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, String> codeNameMap = new LinkedHashMap<String, String>();
        for (PSSysPanelModel psSysPanelModel2 : psSysPanelModelList) {
            PSSysPanelModelImpl psSysPanelModelImpl2 = new PSSysPanelModelImpl();
            psSysPanelModelImpl2.init(this.getDAGlobalHelper(), this, psSysPanelModel2);
            this.psPanelModelMap.put(psSysPanelModelImpl2.getId(), psSysPanelModelImpl2);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)psSysPanelModelImpl2.getType(), (String)"CONTEXTMODEL", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)psSysPanelModelImpl2.getType(), (String)"VIEWMODEL", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)psSysPanelModelImpl2.getType(), (String)"PANELMODEL", (boolean)false) == 0) {
                this.psPanelModelMap.put(psSysPanelModelImpl2.getType(), psSysPanelModelImpl2);
            }
            this.psPanelModelList.add(psSysPanelModelImpl2);
            codeNameMap.put(psSysPanelModelImpl2.getCodeName().toUpperCase(), "");
        }
        if (this.isLayoutPanel() && (iPSPanelModel = this.getPSPanelModel("VIEWMODEL", true)) == null) {
            psSysPanelModel = new PSSysPanelModel();
            psSysPanelModel.setPSSYSVIEWPANELMODELID("VIEWMODEL");
            psSysPanelModel.setPSSYSVIEWPANELMODELNAME("\u89c6\u56fe\u6a21\u578b");
            int nIndex = 1;
            strCodeName = "ViewModel";
            while (codeNameMap.containsKey(strCodeName.toUpperCase())) {
                strCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"ViewModel%1$s", (Object)(++nIndex));
            }
            psSysPanelModel.setCODENAME(strCodeName);
            psSysPanelModel.setMODELTYPE("VIEWMODEL");
            psSysPanelModelImpl = new PSSysPanelModelImpl();
            psSysPanelModelImpl.init(this.getDAGlobalHelper(), this, psSysPanelModel);
            this.psPanelModelMap.put(psSysPanelModelImpl.getId(), psSysPanelModelImpl);
            this.psPanelModelList.add(psSysPanelModelImpl);
        }
        if ((iPSPanelModel = this.getPSPanelModel("PANELMODEL", true)) == null) {
            psSysPanelModel = new PSSysPanelModel();
            psSysPanelModel.setPSSYSVIEWPANELMODELID("PANELMODEL");
            psSysPanelModel.setPSSYSVIEWPANELMODELNAME("\u9762\u677f\u6a21\u578b");
            int nIndex = 1;
            strCodeName = "PanelModel";
            while (codeNameMap.containsKey(strCodeName.toUpperCase())) {
                strCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"PanelModel%1$s", (Object)(++nIndex));
            }
            psSysPanelModel.setCODENAME(strCodeName);
            psSysPanelModel.setMODELTYPE("PANELMODEL");
            psSysPanelModelImpl = new PSSysPanelModelImpl();
            psSysPanelModelImpl.init(this.getDAGlobalHelper(), this, psSysPanelModel);
            this.psPanelModelMap.put(psSysPanelModelImpl.getId(), psSysPanelModelImpl);
            this.psPanelModelList.add(psSysPanelModelImpl);
        }
    }

    protected void onPreparePSSysPanelLogics() throws Exception {
        this.onPreparePSSysPanelLogics(this.getId());
        for (String strSubPanelId : this.panelIdMap.keySet()) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strSubPanelId, (boolean)false) == 0) continue;
            this.onPreparePSSysPanelLogics(strSubPanelId);
        }
    }

    protected void onPreparePSSysPanelLogics(String strPSSysPanelId) throws Exception {
        Vector<PSSysPanelLogic> psSysPanelLogicList = new Vector<PSSysPanelLogic>();
        CallResult callResult = this.getPSModelHelper().getPSSysPanelLogics(strPSSysPanelId, psSysPanelLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u9762\u677f\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.isEnableUIModelEx()) {
            for (PSSysPanelLogic psSysPanelLogic : psSysPanelLogicList) {
                String strLogicName = psSysPanelLogic.getPSSYSVIEWPANELLOGICNAME();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicName)) {
                    boolean bExists = false;
                    for (PSSysPanelLogic2Impl item : this.psSysPanelLogic2List) {
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogicName, (String)item.getName(), (boolean)true) != 0) continue;
                        bExists = true;
                        break;
                    }
                    if (bExists) continue;
                }
                PSSysPanelLogic2Impl psSysPanelLogicImpl = new PSSysPanelLogic2Impl();
                psSysPanelLogicImpl.init(this.getDAGlobalHelper(), this, psSysPanelLogic);
                this.psSysPanelLogic2List.add(psSysPanelLogicImpl);
            }
        } else {
            LinkedHashMap<String, PSSysPanelLogic> psSysPanelLogicMap = new LinkedHashMap<String, PSSysPanelLogic>();
            for (PSSysPanelLogic psSysPanelLogic : psSysPanelLogicList) {
                psSysPanelLogicMap.put(psSysPanelLogic.getPSSYSVIEWPANELMODELID(), psSysPanelLogic);
            }
            for (PSSysPanelLogic psSysPanelLogic : psSysPanelLogicList) {
                PSSysPanelLogicImpl psSysPanelLogicImpl = new PSSysPanelLogicImpl();
                psSysPanelLogicImpl.init(this.getDAGlobalHelper(), this, psSysPanelLogic);
                this.registerPSAppViewLogic(psSysPanelLogicImpl);
            }
        }
    }

    protected void onPreparePSPanelEngines() throws Exception {
        Iterator<IPSControl> psControls;
        this.onPreparePSPanelEngines(this.getId());
        if (this.isEnableUIModelEx() && (psControls = this.getPSControls()) != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                try {
                    IPSControl refPSControl;
                    IPSUIEngineType iPSUIEngineType;
                    String strUIEngineType;
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControl.getInstallUIEngine())) {
                        strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine());
                        iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                        if (iPSUIEngineType != null) {
                            refPSControl = iPSControl.getRefPSControl();
                            this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine(), iPSUIEngineType, "default", 100);
                        }
                    }
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControl.getInstallUIEngine2())) continue;
                    strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine2());
                    iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                    if (iPSUIEngineType == null) continue;
                    refPSControl = iPSControl.getRefPSControl2();
                    this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine2(), iPSUIEngineType, "default2", 200);
                }
                catch (Exception ex) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u9762\u677f[%1$s]\u90e8\u4ef6[%2$s]\u9ed8\u8ba4\u754c\u9762\u5f15\u64ce\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getName(), (Object)iPSControl.getName(), (Object)ex.getMessage()), ex);
                }
            }
        }
    }

    protected void onPreparePSPanelEngines(String strPSPanelId) throws Exception {
        Vector<PSPanelEngine> psPanelEngineList = new Vector<PSPanelEngine>();
        CallResult callResult = this.getPSModelHelper().getPSPanelEngines(strPSPanelId, psPanelEngineList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u9762\u677f\u754c\u9762\u5f15\u64ce\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPanelEngine psPanelEngine : psPanelEngineList) {
            PSPanelEngineImpl psPanelEngineImpl = new PSPanelEngineImpl();
            psPanelEngineImpl.init(this.getDAGlobalHelper(), this, psPanelEngine);
            this.registerPSAppViewEngine(psPanelEngineImpl);
        }
    }

    protected void installPSControlUIEngine(IPSControl iPSControl, IPSControl refPSControl, String strRefUsage, IPSUIEngineType iPSUIEngineType, String strTag, int nOrder) throws Exception {
        PSPanelEngine psPanelEngine = new PSPanelEngine();
        String strEngineName = String.format("engine_%1$s_%2$s", iPSControl.getName(), strTag).toLowerCase();
        psPanelEngine.setPSPANELENGINEID(strEngineName);
        psPanelEngine.setPSPANELENGINENAME(strEngineName);
        psPanelEngine.setPSUIENGINETYPEID(iPSUIEngineType.getId());
        psPanelEngine.setORDERVALUE(nOrder + iPSControl.getOrderValue());
        psPanelEngine.setPSPANELITEMNAME(iPSControl.getName());
        if (refPSControl != null) {
            psPanelEngine.setNO2PSPANELITEMNAME(refPSControl.getName());
        }
        PSPanelEngineImpl psPanelEngineImpl = new PSPanelEngineImpl();
        psPanelEngineImpl.init(this.getDAGlobalHelper(), this, psPanelEngine);
        this.registerPSAppViewEngine(psPanelEngine.getPSPANELENGINENAME().toLowerCase(), psPanelEngineImpl);
    }

    protected void fillExtPSPanelFields(HashMap<String, IPSPanelField> psPanelFieldMap, HashMap<String, String> createItemMap) throws Exception {
    }

    @PSModelRTMeta(description="\u9762\u677f\u9876\u7ea7\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSPanelItem> getRootPSPanelItems() {
        if (this.psPanelRootItemList == null || this.psPanelRootItemList.size() == 0) {
            return emptyPSPanelRootItemList.iterator();
        }
        return this.psPanelRootItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u5b57\u6bb5\u9879\u96c6\u5408", child=true, dumpref=true, modelreftype="SIMPLE", ignorert=3)
    public Iterator<? extends IPSPanelField> getAllPSPanelFields() {
        if (this.psPanelFieldList == null || this.psPanelFieldList.size() == 0) {
            return emptyPSPanelFieldList.iterator();
        }
        return this.psPanelFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u5bbd\u5ea6", ignoredumpvalues="0.0", fields={"PANELWIDTH"})
    public double getPanelWidth() {
        return this.fPanelWidth;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.psPanelRootItemList != null) {
            for (IPSPanelItem iPSPanelRootItem : this.psPanelRootItemList) {
                iPSPanelRootItem.fillRelatedPSAppViews(relatedAppViewList);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    public String getModelScope() {
        return "APP";
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", codelist="PanelLayoutMode2", fields={"LAYOUTMODE"})
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (this.psPanelRootItemList != null) {
            for (IPSPanelItem iPSPanelRootItem : this.psPanelRootItemList) {
                iPSPanelRootItem.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
            }
        }
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        if (this.psPanelFieldList != null) {
            for (IPSPanelField iPSPanelField : this.psPanelFieldList) {
                if (iPSPanelField.getPSCodeList() == null) continue;
                relatedPSCodeListList.add(iPSPanelField.getPSCodeList());
            }
        }
    }

    @Override
    public IPSPanelField getPSPanelField(String strPSPanelFieldId) throws Exception {
        return this.getPSPanelField(strPSPanelFieldId, false);
    }

    @Override
    public IPSPanelField getPSPanelField(String strPSPanelFieldId, boolean bTryMode) throws Exception {
        IPSPanelField iPSPanelField;
        if (this.psPanelFieldMap != null && (iPSPanelField = this.psPanelFieldMap.get(strPSPanelFieldId)) != null) {
            return iPSPanelField;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9762\u677f\u5c5e\u6027[%1$s]", (Object)strPSPanelFieldId));
    }

    @Override
    public IPSPanelItem getPSPanelItem(String strPSPanelItemId) throws Exception {
        return this.getPSPanelItem(strPSPanelItemId, false);
    }

    @Override
    public IPSPanelItem getPSPanelItem(String strPSPanelItemId, boolean bTryMode) throws Exception {
        IPSPanelItem iPSPanelItem;
        if (this.psPanelItemMap != null && (iPSPanelItem = this.psPanelItemMap.get(strPSPanelItemId)) != null) {
            return iPSPanelItem;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9762\u677f\u5c5e\u6027[%1$s]", (Object)strPSPanelItemId));
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6210\u5458\u96c6\u5408")
    public Iterator<? extends IPSPanelItem> getAllPSPanelItems() {
        if (this.psPanelItemList == null || this.psPanelItemList.size() == 0) {
            return emptyPSPanelItemList.iterator();
        }
        return this.psPanelItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6837\u5f0f", fields={"PANELSTYLE"})
    public String getPanelStyle() {
        return this.strPanelStyle;
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6a21\u578b\u96c6\u5408")
    public Iterator<? extends IPSPanelModel> getPSPanelModels() {
        if (this.psPanelModelList == null || this.psPanelModelList.size() == 0) {
            return emptyPSPanelModelList.iterator();
        }
        return this.psPanelModelList.iterator();
    }

    @Override
    public IPSPanelModel getPSPanelModel(String strPSPanelModelId) throws Exception {
        return this.getPSPanelModel(strPSPanelModelId, false);
    }

    @Override
    public IPSPanelModel getPSPanelModel(String strPSPanelModelId, boolean bTryMode) throws Exception {
        IPSPanelModel iPSPanelModel;
        if (this.psPanelModelMap != null && (iPSPanelModel = this.psPanelModelMap.get(strPSPanelModelId)) != null) {
            return iPSPanelModel;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9762\u677f\u6a21\u578b[%1$s]", (Object)strPSPanelModelId));
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u9762\u677f", ignoredumpvalues="false", fields={"MOBFLAG"})
    public boolean isMobilePanel() {
        return this.bMobilePanel;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", ignoredumpvalues="false", fields={"VIEWLAYOUTFLAG"})
    public boolean isLayoutPanel() {
        return this.bViewLayoutPanel;
    }

    public boolean isViewLayoutPanel() {
        return this.isLayoutPanel();
    }

    @Override
    protected IPSPF calcPreviewPSPF() throws Exception {
        IPSPF iPSPF = this.getPSAppView().getPSApplication().getPSPF();
        if (iPSPF.isUseJITDesignPreview() && !this.getPSApplication().isEnableUIModelEx()) {
            if (iPSPF.getPSAppType().isMobileApp()) {
                return this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId());
            }
            iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
        }
        return iPSPF;
    }

    public Iterator<IPanelField> getPanelFields() {
        if (this.panelFieldList == null || this.panelFieldList.size() == 0) {
            return emptyPanelFieldList.iterator();
        }
        return this.panelFieldList.iterator();
    }

    public IPanelField getPanelField(String strName, boolean bTryMode) throws Exception {
        IPSPanelField iPSPanelField;
        if (this.psPanelFieldMap != null && ((iPSPanelField = this.psPanelFieldMap.get(strName)) != null || bTryMode)) {
            return iPSPanelField;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9762\u677f\u5c5e\u6027[%1$s]", (Object)strName));
    }

    @Override
    protected String onGetControlType() {
        return "PANEL";
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u5e03\u5c40\u5bf9\u8c61", child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    protected boolean isExportModelAlways() {
        if (this.getPSAppDataEntity() == null) {
            return true;
        }
        return super.isExportModelAlways();
    }

    @Override
    protected IPSControlHandler onGetPSControlHandler() {
        return this.iPSControlHandler;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetPSControlAction() {
        try {
            if (this.getPSControlHandler() != null) {
                return this.getPSControlHandler().getPSControlHandlerAction("load", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="0", codelist="PanelGetDataMode")
    public int getDataMode() {
        return this.nGetDataMode;
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6570\u636e\u5237\u65b0\u95f4\u9694", ignoredumpvalues="-1")
    public int getDataTimer() {
        return this.nGetDataTimer;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u540d\u79f0", hideempty2=true)
    public String getDataName() {
        return this.strDataName;
    }

    public boolean isViewProxyMode() {
        return this.bViewProxyMode;
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSSysPanelLogic2> getPSSysPanelLogic2s() {
        if (this.psSysPanelLogic2List == null || this.psSysPanelLogic2List.size() == 0) {
            return null;
        }
        return this.psSysPanelLogic2List.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psSysPanelLogic2List == null || this.psSysPanelLogic2List.size() == 0) {
            return null;
        }
        return this.psSysPanelLogic2List.iterator();
    }

    @Override
    protected ArrayList<IPSControl> onGetAllPSControls() {
        ArrayList<IPSControl> list = super.onGetAllPSControls();
        if ((this.getPSSystem().isEnableModelRT() || this.isEnableUIModelEx()) && this.psPanelRootItemList != null) {
            for (IPSPanelItem iPSPanelItem : this.psPanelRootItemList) {
                iPSPanelItem.fillPSControls(list);
            }
        }
        return list;
    }
}

