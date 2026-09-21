/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.dataview.IDataViewDataItem
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewDataItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewLogic;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewParam;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewDataItemImpl;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewItemImpl;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewLogicImpl;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewParamImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
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
import SA.SRFDA.PS.Data.PSDEDataView;
import SA.SRFDA.PS.Data.PSDEDataViewItem;
import SA.SRFDA.PS.Data.PSDEDataViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"DATAVIEW"})
public class PSDEDataViewImpl
extends PSMDAjaxControlContainerImpl2
implements IPSDEDataView {
    private static final Log log = LogFactory.getLog(PSDEDataViewImpl.class);
    protected PSDEDataView psDEDataView;
    protected Map<String, IPSDEDataViewDataItem> psDEDataViewDataItemMap = new LinkedHashMap<String, IPSDEDataViewDataItem>();
    protected ArrayList<IDataViewDataItem> dataViewDataItemList = new ArrayList();
    protected ArrayList<IPSDEDataViewItem> psDEDataViewItemList = new ArrayList();
    protected PSDEDataViewParamImpl psDEDataViewParamImpl = new PSDEDataViewParamImpl();
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected String strPSDEDataSetId = null;
    private IPSSysPFPlugin itemPSSysPFPlugin = null;
    private int nPagingSize = 1000;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    protected boolean bNoSort = false;
    private boolean bAppendDEItems = false;
    private boolean bEnablePaging = false;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bHasWFDataItems = false;
    private IPSSysLayoutPanel itemPSLayoutPanel = null;
    private IPSPFXCodeObject itemPSPFXCodeObject = null;
    private int nCardWidth = 0;
    private int nCardHeight = 0;
    private int nCardColXS = -1;
    private int nCardColSM = -1;
    private int nCardColMD = -1;
    private int nCardColLG = -1;
    private int nGroupWidth = 0;
    private int nGroupHeight = 0;
    private int nGroupColXS = -1;
    private int nGroupColSM = -1;
    private int nGroupColMD = -1;
    private int nGroupColLG = -1;
    private String strGroupMode = "NONE";
    private String strGroupLayout = "";
    private IPSDEField groupPSDEField = null;
    private IPSCodeList groupPSCodeList = null;
    private boolean bEnableGroup = false;
    private IPSAppDEField groupPSAppDEField = null;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private IPSSysCss itemPSSysCss = null;
    private IPSSysPFPlugin groupPSSysPFPlugin = null;
    private IPSSysCss groupPSSysCss = null;
    private IPSPFXCodeObject groupPSPFXCodeObject = null;
    private IPSDEToolbar groupQuickPSDEToolbar = null;
    private IPSUIActionGroup groupPSUIActionGroup = null;
    private IPSDEField orderValuePSDEField = null;
    private boolean bInvalidId = false;
    private IPSDataEntity groupPSDataEntity = null;
    private IPSAppDataEntity groupPSAppDataEntity = null;
    private String strGroupStyle = null;
    private IPSDEDataSet asyncPSDEDataSet = null;
    private IPSDEField groupTextPSDEField = null;
    private IPSAppDEField groupTextPSAppDEField = null;
    private IPSDEField swimlinePSDEField = null;
    private IPSAppDEField swimlinePSAppDEField = null;
    private IPSCodeList swimlinePSCodeList = null;
    protected List<PSDEDataViewLogicImpl> psDEDataViewLogicList = new ArrayList<PSDEDataViewLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEDataViewParam iPSDEDataViewParam = (IPSDEDataViewParam)iPSControlParam;
            this.psDEDataView = new PSDEDataView();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDataViewParam.getPSDEDataViewId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEDataView(iPSDEDataViewParam.getPSDEDataViewId(), this.psDEDataView);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEDataView.getPSDEDATAVIEWID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEDataView.getPSDEDATAVIEWNAME());
            this.setPSObjectData(this.psDEDataView);
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEDataView.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEDataView.getPSDEID()));
            }
            this.psDEDataViewParamImpl.setPSAjaxControlHandlerId(this.psDEDataView.getPSACHANDLERID());
            this.psDEDataViewParamImpl.setPSDEDataSetId(this.psDEDataView.getPSDEDATASETID());
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getPSDEDATASETID()) && this.getPSDataEntity() != null && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
                this.psDEDataViewParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataViewParamImpl.getPSDEDataSetId())) {
                this.psDEDataViewParamImpl.setCustomCond(this.psDEDataView.getCUSTOMCOND());
            }
            this.psDEDataViewParamImpl.setPSCtrlMsgId(this.psDEDataView.getPSCTRLMSGID());
            this.psDEDataViewParamImpl.setPSSysPFPluginId(this.psDEDataView.getPSSYSPFPLUGINID());
            this.psDEDataViewParamImpl.setPSSysCssId(this.psDEDataView.getPSSYSCSSID());
            this.psDEDataViewParamImpl.setPSDEUILogicGroupId(this.psDEDataView.getPSCTRLLOGICGROUPID());
            int nEditMode = this.psDEDataView.GetParamIntValue("ENABLEEDIT", 0);
            if (nEditMode > 0) {
                this.psDEDataViewParamImpl.setEditMode(nEditMode);
            }
            if (!this.psDEDataView.isMULTISELECTNull()) {
                this.psDEDataViewParamImpl.setSingleSelect(!this.psDEDataView.getMULTISELECT());
            }
            this.psDEDataViewParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEDataView.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.setCheckControlDataSet(true);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEDataViewParamImpl);
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
    protected void onInit() throws Exception {
        IPSSysPFPluginTempl iPSSysPFPluginTempl;
        String strPSSysPFPluginTemplId;
        String strMinorSortPSDEFName;
        if (!this.psDEDataView.isNOSORTNull()) {
            this.bNoSort = this.psDEDataView.getNOSORT();
        }
        if (!this.psDEDataView.isAPPENDDEITEMSNull()) {
            this.bAppendDEItems = this.psDEDataView.getAPPENDDEITEMS();
        }
        if (!this.psDEDataView.isENABLEPAGINGBARNull()) {
            boolean bl = this.bEnablePaging = this.psDEDataView.getENABLEPAGINGBAR() == 1;
        }
        if (this.getPagingMode() > 0) {
            this.nPagingSize = 20;
            if (!this.psDEDataView.isPAGINGSIZENull()) {
                this.nPagingSize = this.psDEDataView.getPAGINGSIZE();
            }
        }
        if (!this.psDEDataView.isCARDWIDTHNull() && this.psDEDataView.getCARDWIDTH() >= 0) {
            this.nCardWidth = this.psDEDataView.getCARDWIDTH();
        }
        if (!this.psDEDataView.isCARDHEIGHTNull() && this.psDEDataView.getCARDHEIGHT() >= 0) {
            this.nCardHeight = this.psDEDataView.getCARDHEIGHT();
        }
        String strPanelLayoutMode = this.getPSAppView().getPSApplication().getPSPF().getPanelLayoutMode();
        int nCardColumnCount = 12;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strPanelLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
            nCardColumnCount = 12;
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strPanelLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nCardColumnCount = 24;
        }
        if (!this.psDEDataView.isCARD_COL_XSNull()) {
            this.nCardColXS = this.psDEDataView.getCARD_COL_XS();
            if (this.nCardColXS <= 0 || this.nCardColXS > nCardColumnCount) {
                this.nCardColXS = -1;
            }
        }
        if (!this.psDEDataView.isCARD_COL_SMNull()) {
            this.nCardColSM = this.psDEDataView.getCARD_COL_SM();
            if (this.nCardColSM <= 0 || this.nCardColSM > nCardColumnCount) {
                this.nCardColSM = -1;
            }
        }
        if (!this.psDEDataView.isCARD_COL_MDNull()) {
            this.nCardColMD = this.psDEDataView.getCARD_COL_MD();
            if (this.nCardColMD <= 0 || this.nCardColMD > nCardColumnCount) {
                this.nCardColMD = -1;
            }
        }
        if (!this.psDEDataView.isCARD_COL_LGNull()) {
            this.nCardColLG = this.psDEDataView.getCARD_COL_LG();
            if (this.nCardColLG <= 0 || this.nCardColLG > nCardColumnCount) {
                this.nCardColLG = -1;
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPMODE())) {
            this.strGroupMode = this.psDEDataView.getGROUPMODE();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            if (!this.psDEDataView.isGROUPWIDTHNull() && this.psDEDataView.getGROUPWIDTH() >= 0) {
                this.nGroupWidth = this.psDEDataView.getGROUPWIDTH();
            }
            if (!this.psDEDataView.isGROUPHEIGHTNull() && this.psDEDataView.getGROUPHEIGHT() >= 0) {
                this.nGroupHeight = this.psDEDataView.getGROUPHEIGHT();
            }
            if (!this.psDEDataView.isGROUP_COL_XSNull()) {
                this.nGroupColXS = this.psDEDataView.getGROUP_COL_XS();
                if (this.nGroupColXS <= 0 || this.nGroupColXS > nCardColumnCount) {
                    this.nGroupColXS = -1;
                }
            }
            if (!this.psDEDataView.isGROUP_COL_SMNull()) {
                this.nGroupColSM = this.psDEDataView.getGROUP_COL_SM();
                if (this.nGroupColSM <= 0 || this.nGroupColSM > nCardColumnCount) {
                    this.nGroupColSM = -1;
                }
            }
            if (!this.psDEDataView.isGROUP_COL_MDNull()) {
                this.nGroupColMD = this.psDEDataView.getGROUP_COL_MD();
                if (this.nGroupColMD <= 0 || this.nGroupColMD > nCardColumnCount) {
                    this.nGroupColMD = -1;
                }
            }
            if (!this.psDEDataView.isGROUP_COL_LGNull()) {
                this.nGroupColLG = this.psDEDataView.getGROUP_COL_LG();
                if (this.nGroupColLG <= 0 || this.nGroupColLG > nCardColumnCount) {
                    this.nGroupColLG = -1;
                }
            }
            this.bEnableGroup = true;
            this.strGroupLayout = this.psDEDataView.getGROUPLAYOUT();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getGroupLayout())) {
                this.strGroupLayout = "ROW";
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSDEFID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u5c5e\u6027");
            }
            this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataView.getGROUPPSDEFID());
            this.groupPSCodeList = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSCODELISTID()) ? this.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEDataView.getGROUPPSCODELISTID()) : this.groupPSDEField.getPSCodeList();
            if (this.groupPSCodeList != null) {
                this.groupPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.groupPSCodeList, true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPTEXTPSDEFID())) {
                this.groupTextPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataView.getGROUPTEXTPSDEFID());
            } else if (this.groupPSCodeList == null && this.groupPSDEField instanceof IPSPickupDEField) {
                this.groupTextPSDEField = ((IPSPickupDEField)this.groupPSDEField).getPSPickupTextDEField();
            }
            if (this.getPSAppDataEntity() != null) {
                this.groupPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupPSDEField, true);
                if (this.groupTextPSDEField != null) {
                    this.groupTextPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupTextPSDEField, true);
                }
            }
            this.strGroupStyle = this.psDEDataView.getGROUPSTYLE();
        }
        this.strEmptyText = this.psDEDataView.getEMPTYTEXT();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEDataView.getEMPTYTEXTPSLANRESID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strMinorSortPSDEFName = this.psDEDataView.getMINORSORTPSDEFNAME()))) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEDataView.getMINORSORTDIR();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        this.orderValuePSDEField = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getORDERVALUEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEDataView.getORDERVALUEPSDEFID()) : this.getPSDataEntity().getOrderValuePSDEField();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getSWIMLANEPSDEFID())) {
            this.swimlinePSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataView.getSWIMLANEPSDEFID());
        }
        if (this.swimlinePSDEField != null && this.getPSAppDataEntity() != null) {
            this.swimlinePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.swimlinePSDEField, true);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getSWIMLANEPSCODELISTID())) {
            this.swimlinePSCodeList = this.getPSSystem().getPSCodeList(this.psDEDataView.getSWIMLANEPSCODELISTID());
        } else if (this.swimlinePSDEField != null) {
            this.swimlinePSCodeList = this.swimlinePSDEField.getPSCodeList();
        }
        if (this.swimlinePSCodeList != null) {
            this.swimlinePSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.swimlinePSCodeList, true);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSDEID())) {
            this.groupPSDataEntity = this.getPSApplication().getPSSystem().getPSDataEntity2(this.psDEDataView.getGROUPPSDEID(), false);
            this.groupPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.groupPSDataEntity, false);
        }
        super.onInit();
        this.onPrepareItemPSLayoutPanel();
        boolean bRegisterToContainer = this.getPSAppView().getPSPFStyle().isRegisterToContainer();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getITEMPSSYSCSSID())) {
            this.itemPSSysCss = this.getPSDataEntity().getPSSystem().getPSSysCss(this.psDEDataView.getITEMPSSYSCSSID());
            if (bRegisterToContainer) {
                this.getPSControlContainer().registerPSSysCss(this.itemPSSysCss);
            } else if (this.getPSAppView() != null) {
                this.getPSAppView().registerPSSysCss(this.itemPSSysCss);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getITEMPSSYSPFPLUGINID())) {
            this.itemPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEDataView.getITEMPSSYSPFPLUGINID(), "CONTROLITEM", this.getControlType(), "ITEM") : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEDataView.getITEMPSSYSPFPLUGINID());
            this.getPSAppView().registerPSSysPFPlugin(this.itemPSSysPFPlugin);
            strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.itemPSSysPFPlugin.getId(), (String)this.getPSApplication().getPSPF().getId());
            iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.itemPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this, null);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSSYSCSSID())) {
                this.groupPSSysCss = this.getPSDataEntity().getPSSystem().getPSSysCss(this.psDEDataView.getGROUPPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSControlContainer().registerPSSysCss(this.groupPSSysCss);
                } else if (this.getPSAppView() != null) {
                    this.getPSAppView().registerPSSysCss(this.groupPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSSYSPFPLUGINID())) {
                this.groupPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEDataView.getGROUPPSSYSPFPLUGINID(), "CONTROLITEM", this.getControlType(), "GROUP") : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEDataView.getGROUPPSSYSPFPLUGINID());
                this.getPSAppView().registerPSSysPFPlugin(this.groupPSSysPFPlugin);
                strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.groupPSSysPFPlugin.getId(), (String)this.getPSApplication().getPSPF().getId());
                iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.groupPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this, null);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPQUICKPSDETBID())) {
                this.groupQuickPSDEToolbar = this.registerPSDEToolbar("groupquicktoolbar", this.psDEDataView.getGROUPQUICKPSDETBID(), null, null);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPPSDEUAGROUPID())) {
                this.groupPSUIActionGroup = this.registerPSUIActionGroup("%1$s_group_%2$s_click", this.psDEDataView.getGROUPPSDEUAGROUPID());
            }
        }
        if (!this.bInvalidId) {
            this.onPreparePSDEDataViewDataItems();
            this.onPreparePSDEDataViewLogics();
        }
        this.initNavParams(this.psDEDataView);
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getItemPSLayoutPanel() != null) {
            this.getItemPSLayoutPanel().check();
        }
        this.getMinorSortPSAppDEField();
        return super.onCheck();
    }

    protected void onPreparePSDEDataSet() throws Exception {
        this.strPSDEDataSetId = this.psDEDataViewParamImpl.getPSDEDataSetId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.strPSDEDataSetId = this.psDEDataView.getPSDEDATASETID();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
        }
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
    }

    protected void onPreparePSDEDataViewDataItems() throws Exception {
        PSDataItemParamImpl psItemParamImpl;
        PSDEDataViewDataItemImpl psDEDataViewDataItemImpl;
        this.psDEDataViewDataItemMap.clear();
        this.dataViewDataItemList.clear();
        this.psDEDataViewItemList.clear();
        Vector<PSDEDataViewItem> psDEDataViewItemList = new Vector<PSDEDataViewItem>();
        CallResult callResult = this.getPSModelHelper().getPSDEDataViewItems(this.getId(), psDEDataViewItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u89c6\u56fe\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDataViewItem psDEDataViewItem : psDEDataViewItemList) {
            PSDEDataViewItemImpl iPSDEDataViewItem = new PSDEDataViewItemImpl();
            iPSDEDataViewItem.init(this.getDAGlobalHelper(), this, psDEDataViewItem);
            this.psDEDataViewItemList.add(iPSDEDataViewItem);
        }
        boolean bUseDTO = false;
        if (this.getPSApplication() != null) {
            bUseDTO = this.getPSApplication().isUseServiceApi();
        }
        for (IPSDEDataViewItem iPSDEDataViewItem : this.psDEDataViewItemList) {
            String[] fields;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEDataViewItem.getItemType(), (String)"ACTIONITEM", (boolean)true) == 0) continue;
            String strName = iPSDEDataViewItem.getName().toLowerCase();
            int nStdDataType = -1;
            if (this.psDEDataViewDataItemMap.containsKey(strName)) continue;
            nStdDataType = this.calcFieldStdDataType(strName);
            PSDEDataViewDataItemImpl psDEDataViewDataItemImpl2 = new PSDEDataViewDataItemImpl();
            psDEDataViewDataItemImpl2.setName(strName);
            psDEDataViewDataItemImpl2.setDataType(nStdDataType);
            if (!bUseDTO) {
                if (this.getPSSystemSetting() != null) {
                    psDEDataViewDataItemImpl2.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDEDataViewDataItemImpl2.setFormat("");
            }
            this.psDEDataViewDataItemMap.put(strName, psDEDataViewDataItemImpl2);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDataViewItem.getValueFormat())) {
                psDEDataViewDataItemImpl2.setFormat(iPSDEDataViewItem.getValueFormat());
            }
            if ((fields = iPSDEDataViewItem.getFields()) != null) {
                String[] stringArray = fields;
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    strName = strField.toLowerCase();
                    PSDataItemParamImpl dataItemParamImpl = new PSDataItemParamImpl();
                    dataItemParamImpl.setName(strName);
                    IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strName, true);
                    if (iPSDEField != null) {
                        dataItemParamImpl.setPSDEField(iPSDEField);
                        if (this.getPSAppDataEntity() != null) {
                            dataItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true));
                        }
                    }
                    psDEDataViewDataItemImpl2.addDataItemParam(dataItemParamImpl);
                    ++n2;
                }
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEDataViewItem.getCLConvertMode(), (String)"BACKEND", (boolean)true) == 0) {
                psDEDataViewDataItemImpl2.setPSCodeList(iPSDEDataViewItem.getPSCodeList());
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEDataViewItem.getCLConvertMode(), (String)"FRONT", (boolean)true) == 0) {
                psDEDataViewDataItemImpl2.setFrontPSCodeList(iPSDEDataViewItem.getPSCodeList());
            }
            if (iPSDEDataViewItem.isCustomCode()) {
                psDEDataViewDataItemImpl2.setCustomCode(true);
                psDEDataViewDataItemImpl2.setScriptCode(iPSDEDataViewItem.getScriptCode());
            }
            psDEDataViewDataItemImpl2.init(this);
            this.dataViewDataItemList.add(psDEDataViewDataItemImpl2);
        }
        if (!this.psDEDataViewDataItemMap.containsKey("srfkey")) {
            psDEDataViewDataItemImpl = new PSDEDataViewDataItemImpl();
            psDEDataViewDataItemImpl.setName("srfkey");
            if (!bUseDTO) {
                psDEDataViewDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDEDataViewDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDEDataViewDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
            psItemParamImpl.setPSDEField(this.getPSDataEntity().getKeyPSDEField());
            if (this.getPSAppDataEntity() != null) {
                psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getKeyPSDEField(), true));
            }
            psDEDataViewDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEDataViewDataItemImpl.init(this);
            this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl.getName(), psDEDataViewDataItemImpl);
            this.dataViewDataItemList.add(psDEDataViewDataItemImpl);
        }
        if (this.getPSDataEntity().getMajorPSDEField() != null && !this.psDEDataViewDataItemMap.containsKey("srfmajortext")) {
            psDEDataViewDataItemImpl = new PSDEDataViewDataItemImpl();
            psDEDataViewDataItemImpl.setName("srfmajortext");
            if (!bUseDTO) {
                psDEDataViewDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDEDataViewDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDEDataViewDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getMajorPSDEField().getName());
            psItemParamImpl.setPSDEField(this.getPSDataEntity().getMajorPSDEField());
            if (this.getPSAppDataEntity() != null) {
                psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), true));
            }
            psDEDataViewDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEDataViewDataItemImpl.init(this);
            this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl.getName(), psDEDataViewDataItemImpl);
            this.dataViewDataItemList.add(psDEDataViewDataItemImpl);
        }
        if (this.isAppendDEItems()) {
            IPSDEWF iPSDEWF;
            boolean bEditModeItem = false;
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSAppDEField iPSAppDEField;
                PSDataItemParamImpl psItemParamImpl2;
                IPSDEField iPSDEField = psDEFields.next();
                if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
                    if (!bEditModeItem && !this.psDEDataViewDataItemMap.containsKey("srfdatatype")) {
                        bEditModeItem = true;
                        PSDEDataViewDataItemImpl psDEDataViewDataItemImpl3 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl3.setName("srfdatatype");
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl3.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl3.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl3.setFormat("");
                        }
                        psDEDataViewDataItemImpl3.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
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
                        psDEDataViewDataItemImpl3.addDataItemParam(psItemParamImpl2);
                        psDEDataViewDataItemImpl3.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl3.getName(), psDEDataViewDataItemImpl3);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl3);
                    }
                    if (!this.psDEDataViewDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                        PSDEDataViewDataItemImpl psDEDataViewDataItemImpl4 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl4.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl4.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl4.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl4.setFormat("");
                        }
                        psDEDataViewDataItemImpl4.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
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
                        psDEDataViewDataItemImpl4.addDataItemParam(psItemParamImpl2);
                        psDEDataViewDataItemImpl4.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl4.getName(), psDEDataViewDataItemImpl4);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl4);
                        continue;
                    }
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || this.psDEDataViewDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
                PSDEDataViewDataItemImpl psDEDataViewDataItemImpl5 = new PSDEDataViewDataItemImpl();
                psDEDataViewDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                if (!bUseDTO) {
                    psDEDataViewDataItemImpl5.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEDataViewDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psDEDataViewDataItemImpl5.setFormat("");
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
                psDEDataViewDataItemImpl5.addDataItemParam(psItemParamImpl2);
                psDEDataViewDataItemImpl5.init(this);
                this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl5.getName(), psDEDataViewDataItemImpl5);
                this.dataViewDataItemList.add(psDEDataViewDataItemImpl5);
            }
            boolean bOutputMSTag = true;
            if (this.getPSDataEntity().getAllPSDEWFs() != null) {
                Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
                while (psDEWFs.hasNext()) {
                    IPSAppDEField iPSAppDEField;
                    PSDEDataViewDataItemImpl psDEDataViewDataItemImpl6;
                    IPSDEField iPSDEField;
                    IPSDEWF iPSDEWF2 = psDEWFs.next();
                    if (iPSDEWF2.getWFStepPSDEField() != null && !this.psDEDataViewDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFStepPSDEField()).getName().toLowerCase())) {
                        IPSAppDEField iPSAppDEField2;
                        psDEDataViewDataItemImpl6 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl6.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl6.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl6.setFormat("");
                        }
                        psDEDataViewDataItemImpl6.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
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
                        psDEDataViewDataItemImpl6.addDataItemParam(psItemParamImpl3);
                        psDEDataViewDataItemImpl6.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl6.getName(), psDEDataViewDataItemImpl6);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl6);
                    }
                    if (iPSDEWF2.getUDStatePSDEField() != null && !this.psDEDataViewDataItemMap.containsKey((iPSDEField = iPSDEWF2.getUDStatePSDEField()).getName().toLowerCase())) {
                        IPSAppDEField iPSAppDEField3;
                        psDEDataViewDataItemImpl6 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl6.setName(iPSDEField.getName().toLowerCase());
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl6.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl6.setFormat("");
                        }
                        psDEDataViewDataItemImpl6.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
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
                        psDEDataViewDataItemImpl6.addDataItemParam(psItemParamImpl4);
                        psDEDataViewDataItemImpl6.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl6.getName(), psDEDataViewDataItemImpl6);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl6);
                    }
                    if (iPSDEWF2.getWFVerPSDEField() == null || this.psDEDataViewDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFVerPSDEField()).getName().toLowerCase())) continue;
                    psDEDataViewDataItemImpl6 = new PSDEDataViewDataItemImpl();
                    psDEDataViewDataItemImpl6.setName(iPSDEField.getName().toLowerCase());
                    if (!bUseDTO) {
                        psDEDataViewDataItemImpl6.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psDEDataViewDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psDEDataViewDataItemImpl6.setFormat("");
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
                    psDEDataViewDataItemImpl6.addDataItemParam(psItemParamImpl5);
                    this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl6.getName(), psDEDataViewDataItemImpl6);
                    psDEDataViewDataItemImpl6.init(this);
                    this.dataViewDataItemList.add(psDEDataViewDataItemImpl6);
                }
            }
            if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView && (iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF()) != null) {
                PSDataItemParamImpl psItemParamImpl6;
                PSDEDataViewDataItemImpl psDEDataViewDataItemImpl7;
                IPSDEField iPSDEField;
                this.bHasWFDataItems = true;
                if (iPSDEWF.getWFStepPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFStepPSDEField();
                    if (!this.psDEDataViewDataItemMap.containsKey("srfwfstep")) {
                        IPSAppDEField iPSAppDEField;
                        psDEDataViewDataItemImpl7 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl7.setName("srfwfstep");
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl7.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl7.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl7.setFormat("");
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
                        psDEDataViewDataItemImpl7.addDataItemParam(psItemParamImpl6);
                        psDEDataViewDataItemImpl7.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl7.getName(), psDEDataViewDataItemImpl7);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl7);
                    }
                }
                if (iPSDEWF.getWFVerPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFVerPSDEField();
                    if (!this.psDEDataViewDataItemMap.containsKey("srfwfver")) {
                        IPSAppDEField iPSAppDEField;
                        psDEDataViewDataItemImpl7 = new PSDEDataViewDataItemImpl();
                        psDEDataViewDataItemImpl7.setName("srfwfver");
                        if (!bUseDTO) {
                            psDEDataViewDataItemImpl7.setFormat("%1$s");
                            if (this.getPSSystemSetting() != null) {
                                psDEDataViewDataItemImpl7.setFormat(this.getPSSystemSetting().getValueFormat());
                            }
                        } else {
                            psDEDataViewDataItemImpl7.setFormat("");
                        }
                        psDEDataViewDataItemImpl7.setFrontPSCodeList(this.getPSAppView().getPSApplication().getPSCodeList(iPSDEField.getPSCodeList(), true));
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
                        psDEDataViewDataItemImpl7.addDataItemParam(psItemParamImpl6);
                        psDEDataViewDataItemImpl7.init(this);
                        this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl7.getName(), psDEDataViewDataItemImpl7);
                        this.dataViewDataItemList.add(psDEDataViewDataItemImpl7);
                    }
                }
            }
            if (this.getPSDataEntity().isEnableDEMainState() && !this.psDEDataViewDataItemMap.containsKey("srfmstag")) {
                PSDEDataViewDataItemImpl psDEDataViewDataItemImpl8 = new PSDEDataViewDataItemImpl();
                psDEDataViewDataItemImpl8.setName("srfmstag");
                if (!bUseDTO) {
                    psDEDataViewDataItemImpl8.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEDataViewDataItemImpl8.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psDEDataViewDataItemImpl8.setFormat("");
                }
                psDEDataViewDataItemImpl8.init(this);
                this.psDEDataViewDataItemMap.put(psDEDataViewDataItemImpl8.getName(), psDEDataViewDataItemImpl8);
                this.dataViewDataItemList.add(psDEDataViewDataItemImpl8);
            }
        }
    }

    protected void onPreparePSDEDataViewLogics() throws Exception {
        this.psDEDataViewLogicList.clear();
        this.onPreparePSDEDataViewLogics(this.getId());
    }

    protected void onPreparePSDEDataViewLogics(String strPSDEDataViewId) throws Exception {
        Vector<PSDEDataViewLogic> psDEDataViewLogicList = new Vector<PSDEDataViewLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEDataViewLogics(strPSDEDataViewId, psDEDataViewLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5361\u7247\u89c6\u56fe\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDataViewLogic psDEDataViewLogic : psDEDataViewLogicList) {
            PSDEDataViewLogicImpl psDEDataViewLogicImpl = new PSDEDataViewLogicImpl();
            psDEDataViewLogicImpl.init(this.getDAGlobalHelper(), this, psDEDataViewLogic);
            this.psDEDataViewLogicList.add(psDEDataViewLogicImpl);
        }
    }

    @Override
    protected String onGetControlType() {
        return "DATAVIEW";
    }

    public Iterator<IDataViewDataItem> getDataViewDataItems() {
        return this.dataViewDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=163)
    public Iterator<IPSDEDataViewDataItem> getPSDEDataViewDataItems() {
        return this.psDEDataViewDataItemMap.values().iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEDataViewParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f", fields={"ENABLEPAGINGBAR"})
    public boolean isEnablePagingBar() {
        return this.bEnablePaging;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u6a21\u5f0f", codelist="PagingMode", ignoredumpvalues="0")
    public int getPagingMode() {
        if (this.psDEDataView.isENABLEPAGINGBARNull()) {
            return 0;
        }
        return this.psDEDataView.getENABLEPAGINGBAR();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f", fields={"PAGINGSIZE"})
    public int getPagingSize() {
        return this.nPagingSize;
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
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9", doc="\u7531\u89c6\u56fe\u90e8\u4ef6\u53c2\u6570\u4f20\u5165{@link net.ibizsys.centralstudio.dto.PSDEViewCtrlDTO#FIELD_MULTISELECT}")
    public boolean isSingleSelect() {
        if (this.psDEDataViewParamImpl.isSingleSelect() == null) {
            return false;
        }
        return this.psDEDataViewParamImpl.isSingleSelect();
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", hideempty2=true, codelist="SortDir", fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7981\u7528\u6392\u5e8f", fields={"NOSORT"})
    public boolean isNoSort() {
        return this.bNoSort;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u9879", fields={"APPENDDEITEMS"})
    public boolean isAppendDEItems() {
        return this.bAppendDEItems;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7ed8\u5236\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getItemPSSysPFPlugin() {
        return this.itemPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
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
        return "PSDEDATAVIEW";
    }

    protected boolean isFixWFDataItemsBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u9884\u7f6e\u6d41\u7a0b\u6570\u636e\u9879")
    public boolean hasWFDataItems() {
        return this.bHasWFDataItems;
    }

    protected void onPrepareItemPSLayoutPanel() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getItemPSSysLayoutPanelId())) {
            if (this.isRegisterPSLayoutPanel()) {
                PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                psSysPanelParamImpl.setPSSysPanelId(this.getItemPSSysLayoutPanelId());
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("PANEL");
                IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
                iPSControl.init(this.getDAGlobalHelper(), this, "itemlayoutpanel", psSysPanelParamImpl);
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
        return this.psDEDataView.getPSSYSVIEWPANELID();
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
    @PSModelRTMeta(description="\u5361\u7247\u5bbd\u5ea6", ignoredumpvalues="0", fields={"CARDWIDTH"})
    public int getCardWidth() {
        return this.nCardWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u9ad8\u5ea6", ignoredumpvalues="0", fields={"CARDHEIGHT"})
    public int getCardHeight() {
        return this.nCardHeight;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getItemRender() {
        return this.itemPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u6805\u683c\u5e03\u5c40\u8d85\u5c0f\u5217\u5bbd", ignoredumpvalues="-1", fields={"CARD_COL_XS"})
    public int getCardColXS() {
        return this.nCardColXS;
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u6805\u683c\u5e03\u5c40\u5c0f\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"CARD_COL_SM"})
    public int getCardColSM() {
        return this.nCardColSM;
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u6805\u683c\u5e03\u5c40\u4e2d\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"CARD_COL_MD"})
    public int getCardColMD() {
        return this.nCardColMD;
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u6805\u683c\u5e03\u5c40\u5927\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"CARD_COL_LG"})
    public int getCardColLG() {
        return this.nCardColLG;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5c5e\u6027", hideempty=true, fields={"GROUPPSDEFID"})
    public IPSDEField getGroupPSDEField() {
        return this.groupPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getGroupPSCodeList() {
        return this.groupPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5361\u7247\u65b0\u5efa")
    public boolean isEnableCardNew() {
        if (this.psDEDataViewParamImpl.getEditMode() != null && (this.psDEDataViewParamImpl.getEditMode() & 0x80) == 128) {
            return false;
        }
        return this.isEnableCardEdit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5361\u7247\u7f16\u8f91")
    public boolean isEnableCardEdit() {
        return this.psDEDataViewParamImpl.getEditMode() != null && (this.psDEDataViewParamImpl.getEditMode() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5361\u7247\u6b21\u5e8f\u8c03\u6574")
    public boolean isEnableCardEditOrder() {
        return this.psDEDataViewParamImpl.getEditMode() != null && (this.psDEDataViewParamImpl.getEditMode() & 0x100) == 256;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5361\u7247\u5206\u7ec4\u8c03\u6574")
    public boolean isEnableCardEditGroup() {
        return this.psDEDataViewParamImpl.getEditMode() != null && (this.psDEDataViewParamImpl.getEditMode() & 0x200) == 512;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e03\u5c40", hideempty2=true, codelist="MDCtrlGroupLayout", fields={"GROUPLAYOUT"})
    public String getGroupLayout() {
        return this.strGroupLayout;
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
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null) {
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            Iterator<IPSDEDataViewDataItem> psDEDataViewDataItems = this.getPSDEDataViewDataItems();
            if (psDEDataViewDataItems != null) {
                while (psDEDataViewDataItems.hasNext()) {
                    IPSDEDataViewDataItem iPSDEDataViewDataItem = psDEDataViewDataItems.next();
                    if (iPSDEDataViewDataItem.getPSAppDEField() == null) continue;
                    psAppDEFieldMap.put(iPSDEDataViewDataItem.getPSAppDEField().getName(), iPSDEDataViewDataItem.getPSAppDEField());
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
    @PSModelRTMeta(description="\u5361\u7247\u89c6\u56fe\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=162)
    public Iterator<IPSDEDataViewItem> getPSDEDataViewItems() {
        return this.psDEDataViewItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u9ed8\u8ba4\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getItemPSSysCss() {
        return this.itemPSSysCss;
    }

    @Override
    protected String getQuickPSDEToolbarId() {
        return this.psDEDataView.getQUICKPSDETOOLBARID();
    }

    @Override
    protected String getBatchPSDEToolbarId() {
        return this.psDEDataView.getBATPSDETOOLBARID();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6805\u683c\u5e03\u5c40\u8d85\u5c0f\u5217\u5bbd", ignoredumpvalues="-1", fields={"GROUP_COL_XS"})
    public int getGroupColXS() {
        return this.nGroupColXS;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6805\u683c\u5e03\u5c40\u5c0f\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"GROUP_COL_SM"})
    public int getGroupColSM() {
        return this.nGroupColSM;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6805\u683c\u5e03\u5c40\u4e2d\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"GROUP_COL_MD"})
    public int getGroupColMD() {
        return this.nGroupColMD;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6805\u683c\u5e03\u5c40\u5927\u578b\u5217\u5bbd", ignoredumpvalues="-1", fields={"GROUP_COL_LG"})
    public int getGroupColLG() {
        return this.nGroupColLG;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5bbd\u5ea6", ignoredumpvalues="0", fields={"GROUPWIDTH"})
    public int getGroupWidth() {
        return this.nGroupWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9ad8\u5ea6", ignoredumpvalues="0", fields={"GROUPHEIGHT"})
    public int getGroupHeight() {
        return this.nGroupHeight;
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
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"MINORSORTPSDEFID"})
    public IPSAppDEField getMinorSortPSAppDEField() {
        try {
            if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEField() != null) {
                return this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEField(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
        for (IPSDEDataViewItem iPSDEDataViewItem : this.psDEDataViewItemList) {
            if (iPSDEDataViewItem.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(iPSDEDataViewItem.getPSCodeList());
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEDataViewItem iPSDEDataViewItem : this.psDEDataViewItemList) {
            iPSDEDataViewItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5361\u7247\u89c6\u56fe\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEDataViewLogic> getPSDEDataViewLogics() {
        if (this.psDEDataViewLogicList == null || this.psDEDataViewLogicList.size() == 0) {
            return null;
        }
        return this.psDEDataViewLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEDataViewLogicList == null || this.psDEDataViewLogicList.size() == 0) {
            return null;
        }
        return this.psDEDataViewLogicList.iterator();
    }

    @Override
    protected boolean isNeedFillPSACHandlerData() {
        if (!(!this.isEnableUIModelEx() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGETDRAFTPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getCREATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGETPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUPDATEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getREMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getMOVEPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getCOPYPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUSERPSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUSER2PSDEACTIONID()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPMOVEPSDEACTIONID()))) {
            return true;
        }
        return super.isNeedFillPSACHandlerData();
    }

    @Override
    protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
        super.fillPSACHandlerData(psACHandler);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETDRAFTPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGETDRAFTPSDEACTIONID())) {
            psACHandler.setGETDRAFTPSDEACTIONID(this.psDEDataView.getGETDRAFTPSDEACTIONID());
            psACHandler.setGETDRAFTPSDEACTIONNAME(this.psDEDataView.getGETDRAFTPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCREATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getCREATEPSDEACTIONID())) {
            psACHandler.setCREATEPSDEACTIONID(this.psDEDataView.getCREATEPSDEACTIONID());
            psACHandler.setCREATEPSDEACTIONNAME(this.psDEDataView.getCREATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGETPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGETPSDEACTIONID())) {
            psACHandler.setGETPSDEACTIONID(this.psDEDataView.getGETPSDEACTIONID());
            psACHandler.setGETPSDEACTIONNAME(this.psDEDataView.getGETPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUPDATEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUPDATEPSDEACTIONID())) {
            psACHandler.setUPDATEPSDEACTIONID(this.psDEDataView.getUPDATEPSDEACTIONID());
            psACHandler.setUPDATEPSDEACTIONNAME(this.psDEDataView.getUPDATEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getREMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getREMOVEPSDEACTIONID())) {
            psACHandler.setREMOVEPSDEACTIONID(this.psDEDataView.getREMOVEPSDEACTIONID());
            psACHandler.setREMOVEPSDEACTIONNAME(this.psDEDataView.getREMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getMOVEPSDEACTIONID())) {
            psACHandler.setMOVEPSDEACTIONID(this.psDEDataView.getMOVEPSDEACTIONID());
            psACHandler.setMOVEPSDEACTIONNAME(this.psDEDataView.getMOVEPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getCOPYPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getCOPYPSDEACTIONID())) {
            psACHandler.setCOPYPSDEACTIONID(this.psDEDataView.getCOPYPSDEACTIONID());
            psACHandler.setCOPYPSDEACTIONNAME(this.psDEDataView.getCOPYPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSERPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUSERPSDEACTIONID())) {
            psACHandler.setUSERPSDEACTIONID(this.psDEDataView.getUSERPSDEACTIONID());
            psACHandler.setUSERPSDEACTIONNAME(this.psDEDataView.getUSERPSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getUSER2PSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getUSER2PSDEACTIONID())) {
            psACHandler.setUSER2PSDEACTIONID(this.psDEDataView.getUSER2PSDEACTIONID());
            psACHandler.setUSER2PSDEACTIONNAME(this.psDEDataView.getUSER2PSDEACTIONNAME());
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psACHandler.getGROUPMOVEPSDEACTIONID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataView.getGROUPMOVEPSDEACTIONID())) {
            psACHandler.setGROUPPSDEID(this.psDEDataView.getGROUPPSDEID());
            psACHandler.setGROUPPSDENAME(this.psDEDataView.getGROUPPSDENAME());
            psACHandler.setGROUPMOVEPSDEACTIONID(this.psDEDataView.getGROUPMOVEPSDEACTIONID());
            psACHandler.setGROUPMOVEPSDEACTIONNAME(this.psDEDataView.getGROUPMOVEPSDEACTIONNAME());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u79fb\u52a8\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGroupMovePSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSMDAjaxControlHandler() != null) {
            return this.getPSMDAjaxControlHandler().getPSAjaxHandlerAction("groupmove", true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getGroupPSDataEntity() {
        return this.groupPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getGroupPSAppDataEntity() {
        return this.groupPSAppDataEntity;
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

