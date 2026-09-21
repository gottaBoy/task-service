/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListDataItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEListLogic;
import SA.SRFDA.PS.Core.Control.List.IPSDEListParam;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Control.List.PSDEListDataItemImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEListItemImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEListLogicImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.Control.List.PSListImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSDEList;
import SA.SRFDA.PS.Data.PSDEListItem;
import SA.SRFDA.PS.Data.PSDEListLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"LIST"})
public class PSDEListImpl
extends PSListImpl
implements IPSDEList {
    private static final Log log = LogFactory.getLog(PSDEListImpl.class);
    protected PSDEList psDEList;
    protected ArrayList<IPSDEListItem> psDEListItemList = new ArrayList();
    protected ArrayList<IPSDEListItem> psDEListItemList2 = new ArrayList();
    private ArrayList<IPSDEListDataItem> psDEListDataItemList = null;
    protected PSDEListParamImpl psDEListParamImpl = null;
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected String strPSDEDataSetId = null;
    private String strActiveDataPSDELogicId = null;
    private IPSDELogic activeDataPSDELogic = null;
    private int nPagingSize = 1000;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private boolean bHideHeader = false;
    protected boolean bNoSort = false;
    private boolean bAppendDEItems = false;
    private String strMobListStyle = null;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bHasWFDataItems = false;
    private IPSSysLayoutPanel itemPSLayoutPanel = null;
    private IPSSysPFPlugin itemPSSysPFPlugin = null;
    private IPSPFXCodeObject itemPSPFXCodeObject = null;
    private String strGroupMode = "NONE";
    private IPSDEField groupPSDEField = null;
    private IPSCodeList groupPSCodeList = null;
    private boolean bEnableGroup = false;
    private IPSAppDEField groupPSAppDEField = null;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private IPSAppDEField minorPSAppDEField = null;
    private IPSDEField orderValuePSDEField = null;
    private boolean bInvalidId = false;
    private boolean bEnablePaging = false;
    private IPSSysPFPlugin groupPSSysPFPlugin = null;
    private IPSSysCss groupPSSysCss = null;
    private IPSPFXCodeObject groupPSPFXCodeObject = null;
    private IPSDEToolbar groupQuickPSDEToolbar = null;
    private IPSUIActionGroup groupPSUIActionGroup = null;
    private String strGroupStyle = null;
    private IPSDEDataSet asyncPSDEDataSet = null;
    protected List<PSDEListLogicImpl> psDEListLogicList = new ArrayList<PSDEListLogicImpl>();
    private IPSDEField groupTextPSDEField = null;
    private IPSAppDEField groupTextPSAppDEField = null;
    private IPSDEField swimlinePSDEField = null;
    private IPSAppDEField swimlinePSAppDEField = null;
    private IPSCodeList swimlinePSCodeList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEListParam iPSDEListParam = (IPSDEListParam)iPSControlParam;
            this.psDEList = new PSDEList();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEListParam.getPSDEListId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEList(iPSDEListParam.getPSDEListId(), this.psDEList);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5217\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEList.getPSDELISTID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEList.getPSDELISTNAME());
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEList.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEList.getPSDEID()));
            }
            this.psDEListParamImpl = this.createPSDEListParam();
            this.psDEListParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEList.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.setCheckControlDataSet(true);
            this.setCheckControlHandler(false);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEListParamImpl);
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

    protected PSDEListParamImpl createPSDEListParam() {
        int nEditMode;
        PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
        psDEListParamImpl.setPSSysPFPluginId(this.psDEList.getPSSYSPFPLUGINID());
        psDEListParamImpl.setPSAjaxControlHandlerId(this.psDEList.getPSACHANDLERID());
        psDEListParamImpl.setActiveDataPSDELogicId(this.psDEList.getADPSDELOGICID());
        psDEListParamImpl.setPSSysCssId(this.psDEList.getPSSYSCSSID());
        psDEListParamImpl.setPSDEUILogicGroupId(this.psDEList.getPSCTRLLOGICGROUPID());
        psDEListParamImpl.setPSDEDataSetId(this.psDEList.getPSDEDSID());
        try {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getPSDEDSID()) && this.getPSDataEntity() != null && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
                psDEListParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEListParamImpl.getPSDEDataSetId())) {
            psDEListParamImpl.setCustomCond(this.psDEList.getCUSTOMCOND());
        }
        if ((nEditMode = this.psDEList.GetParamIntValue("ENABLEEDIT", 0)) > 0) {
            psDEListParamImpl.setEditMode(nEditMode);
        }
        if (!this.psDEList.isMULTISELECTNull()) {
            psDEListParamImpl.setSingleSelect(!this.psDEList.getMULTISELECT());
        }
        return psDEListParamImpl;
    }

    @Override
    protected void onInit() throws Exception {
        IPSSysPFPluginTempl iPSSysPFPluginTempl;
        String strPSSysPFPluginTemplId;
        String strMinorSortPSDEFName;
        if (!this.psDEList.isENABLEPAGINGBARNull()) {
            boolean bl = this.bEnablePaging = this.psDEList.getENABLEPAGINGBAR() == 1;
        }
        if (!this.psDEList.isPAGESIZENull() && this.psDEList.getPAGESIZE() > 0) {
            this.nPagingSize = this.psDEList.getPAGESIZE();
        }
        if (!this.psDEList.isSHOWHEADERNull()) {
            boolean bl = this.bHideHeader = !this.psDEList.getSHOWHEADER();
        }
        if (!this.psDEList.isNOSORTNull()) {
            this.bNoSort = this.psDEList.getNOSORT();
        }
        if (!this.psDEList.isAPPENDDEITEMSNull()) {
            this.bAppendDEItems = this.psDEList.getAPPENDDEITEMS();
        }
        if (!this.psDEList.isMOBLISTSTYLENull()) {
            this.strMobListStyle = this.psDEList.getMOBLISTSTYLE();
        }
        this.strEmptyText = this.psDEList.getEMPTYTEXT();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPMODE())) {
            this.strGroupMode = this.psDEList.getGROUPMODE();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            this.bEnableGroup = true;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPPSDEFID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u5c5e\u6027");
            }
            this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psDEList.getGROUPPSDEFID());
            this.groupPSCodeList = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPPSCODELISTID()) ? this.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEList.getGROUPPSCODELISTID()) : this.groupPSDEField.getPSCodeList();
            if (this.groupPSCodeList != null) {
                this.groupPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.groupPSCodeList, true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPTEXTPSDEFID())) {
                this.groupTextPSDEField = this.getPSDataEntity().getPSDEField(this.psDEList.getGROUPTEXTPSDEFID());
            } else if (this.groupPSCodeList == null && this.groupPSDEField instanceof IPSPickupDEField) {
                this.groupTextPSDEField = ((IPSPickupDEField)this.groupPSDEField).getPSPickupTextDEField();
            }
            if (this.getPSAppDataEntity() != null) {
                this.groupPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupPSDEField, true);
                if (this.groupTextPSDEField != null) {
                    this.groupTextPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupTextPSDEField, true);
                }
            }
            this.strGroupStyle = this.psDEList.getGROUPSTYLE();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEList.getEMPTYTEXTPSLANRESID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strMinorSortPSDEFName = this.psDEList.getMINORSORTPSDEFNAME()))) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEList.getMINORSORTDIR();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
            if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEF() != null) {
                this.minorPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEF(), true);
            }
        }
        this.orderValuePSDEField = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getORDERVALUEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEList.getORDERVALUEPSDEFID()) : this.getPSDataEntity().getOrderValuePSDEField();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getSWIMLANEPSDEFID())) {
            this.swimlinePSDEField = this.getPSDataEntity().getPSDEField(this.psDEList.getSWIMLANEPSDEFID());
        }
        if (this.swimlinePSDEField != null && this.getPSAppDataEntity() != null) {
            this.swimlinePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.swimlinePSDEField, true);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getSWIMLANEPSCODELISTID())) {
            this.swimlinePSCodeList = this.getPSSystem().getPSCodeList(this.psDEList.getSWIMLANEPSCODELISTID());
        } else if (this.swimlinePSDEField != null) {
            this.swimlinePSCodeList = this.swimlinePSDEField.getPSCodeList();
        }
        if (this.swimlinePSCodeList != null) {
            this.swimlinePSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.swimlinePSCodeList, true);
        }
        super.onInit();
        boolean bRegisterToContainer = this.getPSAppView().getPSPFStyle().isRegisterToContainer();
        this.onPrepareItemPSLayoutPanel();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getITEMPSSYSPFPLUGINID())) {
            this.itemPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEList.getITEMPSSYSPFPLUGINID(), "CONTROLITEM", this.getControlType(), "ITEM") : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEList.getITEMPSSYSPFPLUGINID());
            this.getPSAppView().registerPSSysPFPlugin(this.itemPSSysPFPlugin);
            strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.itemPSSysPFPlugin.getId(), (String)this.getPSAppView().getPSApplication().getPSPF().getId());
            iPSSysPFPluginTempl = this.getPSAppView().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.itemPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this, null);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPPSSYSCSSID())) {
                this.groupPSSysCss = this.getPSDataEntity().getPSSystem().getPSSysCss(this.psDEList.getGROUPPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSControlContainer().registerPSSysCss(this.groupPSSysCss);
                } else if (this.getPSAppView() != null) {
                    this.getPSAppView().registerPSSysCss(this.groupPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPPSSYSPFPLUGINID())) {
                this.groupPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEList.getGROUPPSSYSPFPLUGINID(), "CONTROLITEM", this.getControlType(), "GROUP") : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEList.getGROUPPSSYSPFPLUGINID());
                this.getPSAppView().registerPSSysPFPlugin(this.groupPSSysPFPlugin);
                strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.groupPSSysPFPlugin.getId(), (String)this.getPSApplication().getPSPF().getId());
                iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.groupPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this, null);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGROUPPSDEUAGROUPID())) {
                this.groupPSUIActionGroup = this.registerPSUIActionGroup("%1$s_group_%2$s_click", this.psDEList.getGROUPPSDEUAGROUPID());
            }
        }
        if (!this.bInvalidId) {
            this.onPreparePSDEDataSet();
            this.onPreparePSDEListItems();
            this.onPreparePSDEListDataItems();
            this.onPreparePSDEListLogics();
        }
        this.initNavParams(this.psDEList);
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getItemPSLayoutPanel() != null) {
            this.getItemPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    protected void onPreparePSDEDataSet() throws Exception {
        this.strPSDEDataSetId = this.psDEListParamImpl.getPSDEDataSetId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.strPSDEDataSetId = this.psDEList.getPSDEDSID();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
        }
        this.strActiveDataPSDELogicId = this.psDEListParamImpl.getActiveDataPSDELogicId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.strActiveDataPSDELogicId = this.psDEList.getADPSDELOGICID();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.strActiveDataPSDELogicId);
        }
    }

    protected void onPreparePSDEListItems() throws Exception {
        this.psDEListItemList.clear();
        Vector<PSDEListItem> psDEListItemList = new Vector<PSDEListItem>();
        CallResult callResult = this.getPSModelHelper().getPSDEListItems(this.getId(), psDEListItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5217\u8868\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEListItem psDEListItem : psDEListItemList) {
            PSDEListItemImpl iPSDEListItem = new PSDEListItemImpl();
            iPSDEListItem.init(this.getDAGlobalHelper(), this, psDEListItem);
            this.psDEListItemList2.add(iPSDEListItem);
            if (iPSDEListItem.isHiddenDataItem()) continue;
            this.psDEListItemList.add(iPSDEListItem);
            this.addPSListItem(iPSDEListItem);
        }
    }

    protected void onPreparePSDEListDataItems() throws Exception {
        HashMap<String, PSDEListDataItemImpl> psListDataItemMap = new HashMap<String, PSDEListDataItemImpl>();
        boolean bUseDTO = false;
        if (this.getPSApplication() != null) {
            bUseDTO = this.getPSApplication().isUseServiceApi();
        }
        for (IPSDEListItem iPSDEListItem : this.psDEListItemList2) {
            String[] fields;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEListItem.getItemType(), (String)"ACTIONITEM", (boolean)true) == 0) continue;
            String strName = iPSDEListItem.getName().toLowerCase();
            int nStdDataType = -1;
            if (psListDataItemMap.containsKey(strName)) continue;
            nStdDataType = this.calcFieldStdDataType(strName);
            PSDEListDataItemImpl psListDataItemImpl = new PSDEListDataItemImpl();
            psListDataItemImpl.setName(strName);
            psListDataItemImpl.setDataType(nStdDataType);
            if (!bUseDTO) {
                if (this.getPSSystemSetting() != null) {
                    psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psListDataItemImpl.setFormat("");
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEListItem.getItemPrivId())) {
                psListDataItemImpl.setPrivilegeId(iPSDEListItem.getItemPrivId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEListItem.getGroupItem())) {
                psListDataItemImpl.setGroupItem(iPSDEListItem.getGroupItem());
            }
            psListDataItemMap.put(strName, psListDataItemImpl);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEListItem.getValueFormat())) {
                psListDataItemImpl.setFormat(iPSDEListItem.getValueFormat());
            }
            if ((fields = iPSDEListItem.getFields()) != null) {
                String[] stringArray = fields;
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    strName = strField.toLowerCase();
                    PSDataItemParamImpl dataItemParamImpl = new PSDataItemParamImpl();
                    dataItemParamImpl.setName(strName);
                    psListDataItemImpl.addDataItemParam(dataItemParamImpl);
                    IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strName, true);
                    if (iPSDEField != null) {
                        dataItemParamImpl.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null) {
                            dataItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true));
                        }
                    }
                    ++n2;
                }
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEListItem.getCLConvertMode(), (String)"BACKEND", (boolean)true) == 0) {
                psListDataItemImpl.setPSCodeList(iPSDEListItem.getPSCodeList());
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEListItem.getCLConvertMode(), (String)"FRONT", (boolean)true) == 0) {
                psListDataItemImpl.setFrontPSCodeList(iPSDEListItem.getPSCodeList());
            }
            if (iPSDEListItem.isCustomCode()) {
                psListDataItemImpl.setCustomCode(true);
                psListDataItemImpl.setScriptCode(iPSDEListItem.getScriptCode());
            }
            psListDataItemImpl.init(this);
            this.addPSListDataItem(psListDataItemImpl);
        }
        if (this.isAppendDEItems()) {
            IPSDEWF iPSDEWF;
            PSDataItemParamImpl psItemParamImpl;
            PSDEListDataItemImpl psListDataItemImpl;
            if (!psListDataItemMap.containsKey("srfkey")) {
                psListDataItemImpl = new PSDEListDataItemImpl();
                psListDataItemImpl.setName("srfkey");
                if (!bUseDTO) {
                    psListDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psListDataItemImpl.setFormat("");
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
                psItemParamImpl.setPSDEField(this.getPSDataEntity().getKeyPSDEField());
                if (this.getPSAppDataEntity() != null) {
                    psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getKeyPSDEField(), true));
                }
                psListDataItemImpl.addDataItemParam(psItemParamImpl);
                psListDataItemMap.put(psListDataItemImpl.getName(), psListDataItemImpl);
                psListDataItemImpl.init(this);
                this.addPSListDataItem(psListDataItemImpl);
            }
            if (this.getPSDataEntity().getMajorPSDEField() != null && !psListDataItemMap.containsKey("srfmajortext")) {
                psListDataItemImpl = new PSDEListDataItemImpl();
                psListDataItemImpl.setName("srfmajortext");
                if (!bUseDTO) {
                    psListDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psListDataItemImpl.setFormat("");
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDataEntity().getMajorPSDEField().getName());
                psItemParamImpl.setPSDEField(this.getPSDataEntity().getMajorPSDEField());
                if (this.getPSAppDataEntity() != null) {
                    psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), true));
                }
                psListDataItemImpl.addDataItemParam(psItemParamImpl);
                psListDataItemMap.put(psListDataItemImpl.getName(), psListDataItemImpl);
                psListDataItemImpl.init(this);
                this.addPSListDataItem(psListDataItemImpl);
            }
            boolean bEditModeItem = false;
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSAppDEField iPSAppDEField;
                PSDataItemParamImpl psItemParamImpl2;
                IPSDEField iPSDEField = psDEFields.next();
                if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
                    if (!bEditModeItem && !psListDataItemMap.containsKey("srfdatatype")) {
                        bEditModeItem = true;
                        PSDEListDataItemImpl psListDataItemImpl2 = new PSDEListDataItemImpl();
                        psListDataItemImpl2.setName("srfdatatype");
                        if (!bUseDTO) {
                            psListDataItemImpl2.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl2.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl2.setFormat("");
                        }
                        psListDataItemImpl2.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
                        psItemParamImpl2 = new PSDataItemParamImpl();
                        psItemParamImpl2.setName(iPSDEField.getName());
                        psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl2.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl2.setPSAppDEField(iPSAppDEField);
                            if (bUseDTO) {
                                psItemParamImpl2.setFormat(iPSAppDEField.getValueFormat());
                            }
                        }
                        psListDataItemImpl2.addDataItemParam(psItemParamImpl2);
                        psListDataItemMap.put(psListDataItemImpl2.getName(), psListDataItemImpl2);
                        psListDataItemImpl2.init(this);
                        this.addPSListDataItem(psListDataItemImpl2);
                    }
                    if (!psListDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                        PSDEListDataItemImpl psListDataItemImpl3 = new PSDEListDataItemImpl();
                        psListDataItemImpl3.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psListDataItemImpl3.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl3.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl3.setFormat("");
                        }
                        psListDataItemImpl3.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
                        psItemParamImpl2 = new PSDataItemParamImpl();
                        psItemParamImpl2.setName(iPSDEField.getName());
                        psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl2.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl2.setPSAppDEField(iPSAppDEField);
                            if (bUseDTO) {
                                psItemParamImpl2.setFormat(iPSAppDEField.getValueFormat());
                            }
                        }
                        psListDataItemImpl3.addDataItemParam(psItemParamImpl2);
                        psListDataItemMap.put(psListDataItemImpl3.getName(), psListDataItemImpl3);
                        psListDataItemImpl3.init(this);
                        this.addPSListDataItem(psListDataItemImpl3);
                        continue;
                    }
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || psListDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
                PSDEListDataItemImpl psListDataItemImpl4 = new PSDEListDataItemImpl();
                psListDataItemImpl4.setName(iPSDEField.getName().toLowerCase());
                if (!bUseDTO) {
                    psListDataItemImpl4.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psListDataItemImpl4.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psListDataItemImpl4.setFormat("");
                }
                psItemParamImpl2 = new PSDataItemParamImpl();
                psItemParamImpl2.setName(iPSDEField.getName());
                psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                psItemParamImpl2.setPSDEField(iPSDEField);
                if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                    psItemParamImpl2.setPSAppDEField(iPSAppDEField);
                    if (bUseDTO) {
                        psItemParamImpl2.setFormat(iPSAppDEField.getValueFormat());
                    }
                }
                psListDataItemImpl4.addDataItemParam(psItemParamImpl2);
                psListDataItemMap.put(psListDataItemImpl4.getName(), psListDataItemImpl4);
                psListDataItemImpl4.init(this);
                this.addPSListDataItem(psListDataItemImpl4);
            }
            boolean bOutputMSTag = true;
            if (this.getPSDataEntity().getAllPSDEWFs() != null) {
                Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
                while (psDEWFs.hasNext()) {
                    IPSAppDEField iPSAppDEField;
                    PSDEListDataItemImpl psListDataItemImpl5;
                    IPSDEField iPSDEField;
                    IPSDEWF iPSDEWF2 = psDEWFs.next();
                    if (iPSDEWF2.getWFStepPSDEField() != null && !psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFStepPSDEField()).getName().toLowerCase())) {
                        IPSAppDEField iPSAppDEField2;
                        psListDataItemImpl5 = new PSDEListDataItemImpl();
                        psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psListDataItemImpl5.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl5.setFormat("");
                        }
                        psListDataItemImpl5.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
                        PSDataItemParamImpl psItemParamImpl3 = new PSDataItemParamImpl();
                        psItemParamImpl3.setName(iPSDEField.getName());
                        psItemParamImpl3.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl3.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField2 = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl3.setPSAppDEField(iPSAppDEField2);
                            if (bUseDTO) {
                                psItemParamImpl3.setFormat(iPSAppDEField2.getValueFormat());
                            }
                        }
                        psListDataItemImpl5.addDataItemParam(psItemParamImpl3);
                        psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                        psListDataItemImpl5.init(this);
                        this.addPSListDataItem(psListDataItemImpl5);
                    }
                    if (iPSDEWF2.getUDStatePSDEField() != null && !psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getUDStatePSDEField()).getName().toLowerCase())) {
                        IPSAppDEField iPSAppDEField3;
                        psListDataItemImpl5 = new PSDEListDataItemImpl();
                        psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psListDataItemImpl5.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl5.setFormat("");
                        }
                        psListDataItemImpl5.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
                        PSDataItemParamImpl psItemParamImpl4 = new PSDataItemParamImpl();
                        psItemParamImpl4.setName(iPSDEField.getName());
                        psItemParamImpl4.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl4.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField3 = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl4.setPSAppDEField(iPSAppDEField3);
                            if (bUseDTO) {
                                psItemParamImpl4.setFormat(iPSAppDEField3.getValueFormat());
                            }
                        }
                        psListDataItemImpl5.addDataItemParam(psItemParamImpl4);
                        psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                        psListDataItemImpl5.init(this);
                        this.addPSListDataItem(psListDataItemImpl5);
                    }
                    if (iPSDEWF2.getWFVerPSDEField() == null || psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFVerPSDEField()).getName().toLowerCase())) continue;
                    psListDataItemImpl5 = new PSDEListDataItemImpl();
                    psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                    if (!bUseDTO) {
                        psListDataItemImpl5.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psListDataItemImpl5.setFormat("");
                    }
                    PSDataItemParamImpl psItemParamImpl5 = new PSDataItemParamImpl();
                    psItemParamImpl5.setName(iPSDEField.getName());
                    psItemParamImpl5.setFormat(iPSDEField.getValueFormat());
                    psItemParamImpl5.setPSDEField(iPSDEField);
                    if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                        psItemParamImpl5.setPSAppDEField(iPSAppDEField);
                        if (bUseDTO) {
                            psItemParamImpl5.setFormat(iPSAppDEField.getValueFormat());
                        }
                    }
                    psListDataItemImpl5.addDataItemParam(psItemParamImpl5);
                    psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                    psListDataItemImpl5.init(this);
                    this.addPSListDataItem(psListDataItemImpl5);
                }
            }
            if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView && (iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF()) != null) {
                PSDataItemParamImpl psItemParamImpl6;
                PSDEListDataItemImpl psListDataItemImpl6;
                IPSDEField iPSDEField;
                this.bHasWFDataItems = true;
                if (iPSDEWF.getWFStepPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFStepPSDEField();
                    if (!psListDataItemMap.containsKey("srfwfstep")) {
                        IPSAppDEField iPSAppDEField;
                        psListDataItemImpl6 = new PSDEListDataItemImpl();
                        psListDataItemImpl6.setName("srfwfstep");
                        if (!bUseDTO) {
                            psListDataItemImpl6.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl6.setFormat("");
                        }
                        psItemParamImpl6 = new PSDataItemParamImpl();
                        psItemParamImpl6.setName(iPSDEField.getName());
                        psItemParamImpl6.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl6.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl6.setPSAppDEField(iPSAppDEField);
                            if (bUseDTO) {
                                psItemParamImpl6.setFormat(iPSAppDEField.getValueFormat());
                            }
                        }
                        psListDataItemImpl6.addDataItemParam(psItemParamImpl6);
                        psListDataItemMap.put(psListDataItemImpl6.getName(), psListDataItemImpl6);
                        psListDataItemImpl6.init(this);
                        this.addPSListDataItem(psListDataItemImpl6);
                    }
                }
                if (iPSDEWF.getWFVerPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFVerPSDEField();
                    if (!psListDataItemMap.containsKey("srfwfver")) {
                        IPSAppDEField iPSAppDEField;
                        psListDataItemImpl6 = new PSDEListDataItemImpl();
                        psListDataItemImpl6.setName("srfwfver");
                        if (!bUseDTO) {
                            psListDataItemImpl6.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psListDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psListDataItemImpl6.setFormat("");
                        }
                        psListDataItemImpl6.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
                        psItemParamImpl6 = new PSDataItemParamImpl();
                        psItemParamImpl6.setName(iPSDEField.getName());
                        psItemParamImpl6.setFormat(iPSDEField.getValueFormat());
                        psItemParamImpl6.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                            psItemParamImpl6.setPSAppDEField(iPSAppDEField);
                            if (bUseDTO) {
                                psItemParamImpl6.setFormat(iPSAppDEField.getValueFormat());
                            }
                        }
                        psListDataItemImpl6.addDataItemParam(psItemParamImpl6);
                        psListDataItemMap.put(psListDataItemImpl6.getName(), psListDataItemImpl6);
                        psListDataItemImpl6.init(this);
                        this.addPSListDataItem(psListDataItemImpl6);
                    }
                }
            }
            if (this.getPSDataEntity().isEnableDEMainState() && !psListDataItemMap.containsKey("srfmstag")) {
                PSDEListDataItemImpl psListDataItemImpl7 = new PSDEListDataItemImpl();
                psListDataItemImpl7.setName("srfmstag");
                if (!bUseDTO) {
                    psListDataItemImpl7.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psListDataItemImpl7.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psListDataItemImpl7.setFormat("");
                }
                psListDataItemMap.put(psListDataItemImpl7.getName(), psListDataItemImpl7);
                psListDataItemImpl7.init(this);
                this.addPSListDataItem(psListDataItemImpl7);
            }
        }
    }

    protected void onPreparePSDEListLogics() throws Exception {
        this.psDEListLogicList.clear();
        this.onPreparePSDEListLogics(this.getId());
    }

    protected void onPreparePSDEListLogics(String strPSDEListId) throws Exception {
        Vector<PSDEListLogic> psDEListLogicList = new Vector<PSDEListLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEListLogics(strPSDEListId, psDEListLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5217\u8868\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEListLogic psDEListLogic : psDEListLogicList) {
            PSDEListLogicImpl psDEListLogicImpl = new PSDEListLogicImpl();
            psDEListLogicImpl.init(this.getDAGlobalHelper(), this, psDEListLogic);
            this.psDEListLogicList.add(psDEListLogicImpl);
        }
    }

    protected int calcFieldStdDataType(String strFieldName) throws Exception {
        IPSDEDataSetGroupParam iPSDEDataSetGroupParam;
        if (this.getPSDEDataSet() != null && this.getPSDEDataSet().isEnableGroup() && (iPSDEDataSetGroupParam = this.getPSDEDataSet().getPSDEDataSetGroupParam(strFieldName, true)) != null && iPSDEDataSetGroupParam.getStdDataType() != -1) {
            return iPSDEDataSetGroupParam.getStdDataType();
        }
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strFieldName, true);
        if (iPSDEField != null) {
            return iPSDEField.getStdDataType();
        }
        log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5c5e\u6027[%1$s]\u6570\u636e\u7c7b\u578b", (Object)strFieldName));
        return 25;
    }

    @Override
    protected String onGetControlType() {
        return "LIST";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEListItem> getPSDEListItems() {
        return this.psDEListItemList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEListParamImpl;
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
        return "DE";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5934\u90e8", fields={"SHOWHEADER"})
    public boolean isShowHeader() {
        return !this.bHideHeader;
    }

    @Override
    public boolean isForceFit() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f", fields={"ENABLEPAGINGBAR"}, ignoredumpvalues="false")
    public boolean isEnablePagingBar() {
        return this.bEnablePaging;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u6a21\u5f0f", codelist="PagingMode", ignoredumpvalues="0")
    public int getPagingMode() {
        if (this.psDEList.isENABLEPAGINGBARNull()) {
            return 0;
        }
        return this.psDEList.getENABLEPAGINGBAR();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f", fields={"PAGESIZE"})
    public int getPagingSize() {
        return this.nPagingSize;
    }

    @Override
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7981\u7528\u6392\u5e8f", fields={"NOSORT"})
    public boolean isNoSort() {
        return this.bNoSort;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u9879", dump=false)
    public boolean isAppendDEItems() {
        return this.bAppendDEItems;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u5217\u8868\u6837\u5f0f", codelist="MobMDCtrlTypes", fields={"MOBLISTSTYLE"})
    public String getMobListStyle() {
        return this.strMobListStyle;
    }

    @Override
    public String getControlSubType() {
        return this.getMobListStyle();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText) && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    public String getModelType() {
        return "PSDELIST";
    }

    protected boolean isFixWFDataItemsBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u9884\u7f6e\u6d41\u7a0b\u6570\u636e\u9879")
    public boolean hasWFDataItems() {
        return this.bHasWFDataItems;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    protected void onPrepareItemPSLayoutPanel() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getItemPSSysLayoutPanelId())) {
            if (this.isRegisterPSLayoutPanel()) {
                PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                psSysPanelParamImpl.setPSSysPanelId(this.getItemPSSysLayoutPanelId());
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("PANEL");
                IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
                iPSControl.init(this.getDAGlobalHelper(), this, String.valueOf(this.getName()) + "_itempanel", psSysPanelParamImpl);
                this.itemPSLayoutPanel = (IPSSysLayoutPanel)iPSControl;
                this.registerPSLayoutPanel(this.itemPSLayoutPanel);
            } else {
                PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                psSysPanelParamImpl.setPSSysPanelId(this.getItemPSSysLayoutPanelId());
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
                IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
                iPSControl.init(this.getDAGlobalHelper(), this.getPSControlContainer(), "itemlayoutpanel", psSysPanelParamImpl);
                this.itemPSLayoutPanel = (IPSSysLayoutPanel)iPSControl;
            }
        }
    }

    protected String getItemPSSysLayoutPanelId() {
        return this.psDEList.getPSSYSVIEWPANELID();
    }

    @Override
    public IPSSysLayoutPanel getItemPSSysLayoutPanel() {
        return this.itemPSLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u5e03\u5c40\u9762\u677f", child=true, fields={"PSSYSVIEWPANELID"})
    public IPSLayoutPanel getItemPSLayoutPanel() {
        return this.getItemPSSysLayoutPanel();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getItemRender() {
        return this.itemPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSDEField getGroupPSDEField() {
        return this.groupPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getGroupPSCodeList() {
        return this.groupPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPTEXTPSDEFID"})
    public IPSAppDEField getGroupTextPSAppDEField() {
        return this.groupTextPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6587\u672c\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDEField getGroupTextPSDEField() {
        return this.groupTextPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u65b0\u5efa")
    public boolean isEnableRowNew() {
        if (this.psDEListParamImpl.getEditMode() != null && (this.psDEListParamImpl.getEditMode() & 0x80) == 128) {
            return false;
        }
        return this.isEnableRowEdit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91")
    public boolean isEnableRowEdit() {
        return this.psDEListParamImpl.getEditMode() != null && (this.psDEListParamImpl.getEditMode() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u6b21\u5e8f\u8c03\u6574")
    public boolean isEnableRowEditOrder() {
        return this.psDEListParamImpl.getEditMode() != null && (this.psDEListParamImpl.getEditMode() & 0x100) == 256;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u5206\u7ec4\u8c03\u6574")
    public boolean isEnableRowEditGroup() {
        return this.psDEListParamImpl.getEditMode() != null && (this.psDEListParamImpl.getEditMode() & 0x200) == 512;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", hideempty2=true, codelist="MDCtrlGroupMode", fields={"GROUPMODE"})
    public String getGroupMode() {
        return this.strGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6837\u5f0f", hideempty2=true, codelist="CtrlGroupStyle", ignoredumpvalues="DEFAULT", fields={"GROUPSTYLE"})
    public String getGroupStyle() {
        return this.strGroupStyle;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4", doc="\u8ba1\u7b97{@link #getGroupMode}\u8fd4\u56de\u4e0d\u7b49\u4e8e(NONE)")
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPPSDEFID"})
    public IPSAppDEField getGroupPSAppDEField() {
        return this.groupPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"MINORSORTPSDEFID"})
    public IPSAppDEField getMinorSortPSAppDEField() {
        return this.minorPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null) {
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            Iterator<IPSListDataItem> psListDataItems = this.getPSListDataItems();
            if (psListDataItems != null) {
                while (psListDataItems.hasNext()) {
                    IPSDEListDataItem iPSDEListDataItem;
                    IPSListDataItem iPSListDataItem = psListDataItems.next();
                    if (!(iPSListDataItem instanceof IPSDEListDataItem) || (iPSDEListDataItem = (IPSDEListDataItem)iPSListDataItem).getPSAppDEField() == null) continue;
                    psAppDEFieldMap.put(iPSDEListDataItem.getPSAppDEField().getName(), iPSDEListDataItem.getPSAppDEField());
                }
            }
            ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<IPSAppDEField>();
            psAppDEFieldList.addAll(psAppDEFieldMap.values());
            Collections.sort(psAppDEFieldList, new Comparator<IPSAppDEField>(){

                @Override
                public int compare(IPSAppDEField o1, IPSAppDEField o2) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
            });
            if (this.psAppDEFieldList == null) {
                this.psAppDEFieldList = psAppDEFieldList;
            }
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    protected String getQuickPSDEToolbarId() {
        return this.psDEList.getQUICKPSDETOOLBARID();
    }

    @Override
    protected String getBatchPSDEToolbarId() {
        return this.psDEList.getBATPSDETOOLBARID();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027")
    public IPSDEField getOrderValuePSDEField() {
        return this.orderValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"ORDERVALUEPSDEFID"})
    public IPSAppDEField getOrderValuePSAppDEField() {
        try {
            if (this.getPSAppDataEntity() != null && this.getOrderValuePSDEField() != null) {
                return this.getPSAppDataEntity().getPSAppDEField(this.getOrderValuePSDEField(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEField() {
        return this.getMinorSortPSDEF();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ed8\u5236\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getGroupPSSysPFPlugin() {
        return this.groupPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ed8\u5236\u5668", hideempty=true)
    public IPSPFXCodeObject getGroupRender() {
        return this.groupPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9ed8\u8ba4\u754c\u9762\u6837\u5f0f", hideempty=true, fields={"GROUPPSSYSCSSID"})
    public IPSSysCss getGroupPSSysCss() {
        return this.groupPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u754c\u9762\u884c\u4e3a\u7ec4", hideempty=true, child=true, fields={"GROUPPSDEUAGROUPID"})
    public IPSUIActionGroup getGroupPSUIActionGroup() {
        return this.groupPSUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5feb\u901f\u64cd\u4f5c\u5de5\u5177\u680f", hideempty=true)
    public IPSDEToolbar getGroupQuickPSDEToolbar() {
        return this.groupQuickPSDEToolbar;
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
        for (IPSDEListItem iPSDEListItem : this.psDEListItemList) {
            if (iPSDEListItem.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(iPSDEListItem.getPSCodeList());
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEListItem iPSDEListItem : this.psDEListItemList) {
            iPSDEListItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @PSModelRTMeta(description="\u5217\u8868\u6570\u636e\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEListDataItem> getPSDEListDataItems() {
        if (this.psDEListDataItemList == null) {
            ArrayList<IPSDEListDataItem> psDEListDataItemList2 = new ArrayList<IPSDEListDataItem>();
            Iterator<IPSListDataItem> psListDataItems = super.getPSListDataItems();
            if (psListDataItems != null) {
                while (psListDataItems.hasNext()) {
                    IPSListDataItem iPSListDataItem = psListDataItems.next();
                    if (!(iPSListDataItem instanceof IPSDEListDataItem)) continue;
                    psDEListDataItemList2.add((IPSDEListDataItem)iPSListDataItem);
                }
            }
            this.psDEListDataItemList = psDEListDataItemList2;
        }
        return this.psDEListDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEListLogic> getPSDEListLogics() {
        if (this.psDEListLogicList == null || this.psDEListLogicList.size() == 0) {
            return null;
        }
        return this.psDEListLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEListLogicList == null || this.psDEListLogicList.size() == 0) {
            return null;
        }
        return this.psDEListLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9", doc="\u7531\u89c6\u56fe\u90e8\u4ef6\u53c2\u6570\u4f20\u5165{@link net.ibizsys.centralstudio.dto.PSDEViewCtrlDTO#FIELD_MULTISELECT}")
    public boolean isSingleSelect() {
        if (this.psDEListParamImpl.isSingleSelect() == null) {
            return false;
        }
        return this.psDEListParamImpl.isSingleSelect();
    }

    @Override
    protected boolean isNeedFillPSACHandlerData() {
        if (!(!this.isEnableUIModelEx() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGETDRAFTPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getCREATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGETPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUPDATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getREMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getCOPYPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUSERPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUSER2PSDEACTIONID()))) {
            return true;
        }
        return super.isNeedFillPSACHandlerData();
    }

    @Override
    protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
        super.fillPSACHandlerData(psACHandler);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETDRAFTPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGETDRAFTPSDEACTIONID())) {
            psACHandler.setGETDRAFTPSDEACTIONID(this.psDEList.getGETDRAFTPSDEACTIONID());
            psACHandler.setGETDRAFTPSDEACTIONNAME(this.psDEList.getGETDRAFTPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCREATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getCREATEPSDEACTIONID())) {
            psACHandler.setCREATEPSDEACTIONID(this.psDEList.getCREATEPSDEACTIONID());
            psACHandler.setCREATEPSDEACTIONNAME(this.psDEList.getCREATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getGETPSDEACTIONID())) {
            psACHandler.setGETPSDEACTIONID(this.psDEList.getGETPSDEACTIONID());
            psACHandler.setGETPSDEACTIONNAME(this.psDEList.getGETPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUPDATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUPDATEPSDEACTIONID())) {
            psACHandler.setUPDATEPSDEACTIONID(this.psDEList.getUPDATEPSDEACTIONID());
            psACHandler.setUPDATEPSDEACTIONNAME(this.psDEList.getUPDATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getREMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getREMOVEPSDEACTIONID())) {
            psACHandler.setREMOVEPSDEACTIONID(this.psDEList.getREMOVEPSDEACTIONID());
            psACHandler.setREMOVEPSDEACTIONNAME(this.psDEList.getREMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getMOVEPSDEACTIONID())) {
            psACHandler.setMOVEPSDEACTIONID(this.psDEList.getMOVEPSDEACTIONID());
            psACHandler.setMOVEPSDEACTIONNAME(this.psDEList.getMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCOPYPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getCOPYPSDEACTIONID())) {
            psACHandler.setCOPYPSDEACTIONID(this.psDEList.getCOPYPSDEACTIONID());
            psACHandler.setCOPYPSDEACTIONNAME(this.psDEList.getCOPYPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSERPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUSERPSDEACTIONID())) {
            psACHandler.setUSERPSDEACTIONID(this.psDEList.getUSERPSDEACTIONID());
            psACHandler.setUSERPSDEACTIONNAME(this.psDEList.getUSERPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSER2PSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEList.getUSER2PSDEACTIONID())) {
            psACHandler.setUSER2PSDEACTIONID(this.psDEList.getUSER2PSDEACTIONID());
            psACHandler.setUSER2PSDEACTIONNAME(this.psDEList.getUSER2PSDEACTIONNAME());
        }
    }

    @Override
    @PSModelRTMeta(description="\u6cf3\u9053\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSDEField getSwimlanePSDEField() {
        return this.swimlinePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6cf3\u9053\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"SWIMLANEPSDEFID"})
    public IPSAppDEField getSwimlanePSAppDEField() {
        return this.swimlinePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6cf3\u9053\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"SWIMLANEPSCODELISTID"})
    public IPSCodeList getSwimlanePSCodeList() {
        return this.swimlinePSCodeList;
    }
}

