/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEDataExportGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEDataImportGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEFieldImpl2;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDELogicGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMapGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMethodDTOImpl;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMethodImpl;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEPrintGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEReportGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEUIActionGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEUILogicGlobalModel;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEUILogicGroupGlobalModel;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.PSDEACModeImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDataEntityImpl
extends PSApplicationObjectImpl
implements IPSAppDataEntity,
IPSAppDataEntityRuntime {
    private static final Log log = LogFactory.getLog(PSAppDataEntityImpl.class);
    private static Map<String, String> FilterActions = new LinkedHashMap<String, String>();
    private static Map<String, String> WFActions = new LinkedHashMap<String, String>();
    public static final String MODELGROUP_MODEL = "\u6a21\u578b";
    public static final String MODELGROUP_LOGIC = "\u5904\u7406\u903b\u8f91";
    public static final String MODELGROUP_UILOGIC = "\u754c\u9762\u903b\u8f91";
    public static final String MODELGROUP_UI = "\u754c\u9762&\u7ec4\u4ef6";
    public static final String MODELGROUP_ACCCTRL = "\u8bbf\u95ee\u63a7\u5236";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String[] MODELGROUPS;
    public static final int MODELORDER_MODEL = 150;
    public static final int MODELORDER_LOGIC = 180;
    public static final int MODELORDER_UILOGIC = 230;
    public static final int MODELORDER_UI = 280;
    public static final int MODELORDER_ACCCTRL = 330;
    public static final int MODELORDER_TEST = 380;
    protected PSAppLocalDE psAppLocalDE = null;
    private IPSDataEntity iPSDataEntity = null;
    private ArrayList<IPSControl> psControlList = null;
    private ArrayList<IPSControl> refPSControlList = null;
    private Map<String, IPSDEDataSet> refPSDEDataSetMap = null;
    private Map<String, IPSAppView> refPSAppViewMap = null;
    private boolean bPrepareRefPSAppView = false;
    private ArrayList<IPSAppView> allPSAppViewList = null;
    private ArrayList<IPSAppDEMethod> allPSAppDEMethodList = null;
    private Map<String, IPSAppDEMethod> psAppDEMethodMap = null;
    private boolean bMajor = true;
    private IPSDER1N iPSDER1N = null;
    private String strCodeName = null;
    private boolean bDefaultMode = true;
    private int nDataAccCtrlArch = 0;
    private int nDataAccCtrlMode = 0;
    private IPSDEServiceAPI iPSDEServiceAPI = null;
    private int nStorageMode = IPSAppDataEntity.STORAGEMODE_NOLOCAL;
    private ArrayList<IPSAppDERS> majorPSAppDERSList = null;
    private ArrayList<IPSAppDERS> minorPSAppDERSList = null;
    private Map<Integer, ArrayList<IPSAppDERS>> psAppDERSPathMap = null;
    private IPSDEFGroup iPSDEFGroup = null;
    private String strDEFGroupMode = "";
    private ArrayList<IPSAppDEField> psAppDEFieldList = null;
    private Map<String, IPSAppDEField> psAppDEFieldMap = null;
    private IPSAppDEField keyPSAppDEField = null;
    private IPSAppDEField majorPSAppDEField = null;
    private PSAppDEUIActionGlobalModel psAppDEUIActionGlobalModel = new PSAppDEUIActionGlobalModel();
    private PSAppDEUIActionGroupGlobalModel psAppDEUIActionGroupGlobalModel = new PSAppDEUIActionGroupGlobalModel();
    private PSAppDELogicGlobalModel psAppDELogicGlobalModel = new PSAppDELogicGlobalModel();
    private PSAppDEUILogicGlobalModel psAppDEUILogicGlobalModel = new PSAppDEUILogicGlobalModel();
    private PSAppDEUILogicGroupGlobalModel psAppDEUILogicGroupGlobalModel = new PSAppDEUILogicGroupGlobalModel();
    private PSAppDEPrintGlobalModel psAppDEPrintGlobalModel = new PSAppDEPrintGlobalModel();
    private PSAppDEReportGlobalModel psAppDEReportGlobalModel = new PSAppDEReportGlobalModel();
    private PSAppDEDataImportGlobalModel psAppDEDataImportGlobalModel = new PSAppDEDataImportGlobalModel();
    private PSAppDEDataExportGlobalModel psAppDEDataExportGlobalModel = new PSAppDEDataExportGlobalModel();
    private PSAppDEMapGlobalModel psAppDEMapGlobalModel = new PSAppDEMapGlobalModel();
    private Map<String, IPSAppDEUIAction> psAppDEUIActionMap = new ConcurrentHashMap<String, IPSAppDEUIAction>();
    private Map<String, IPSAppDEUIActionGroup> psAppDEUIActionGroupMap = new ConcurrentHashMap<String, IPSAppDEUIActionGroup>();
    private Map<String, IPSAppDEUILogic> psAppDEUILogicMap = new ConcurrentHashMap<String, IPSAppDEUILogic>();
    private Map<String, IPSAppDEACMode> psAppDEACModeMap = new ConcurrentHashMap<String, IPSAppDEACMode>();
    private boolean bEnableFilterActions = true;
    private boolean bEnableWFActions = true;
    private IPSAppWF iPSAppWF = null;
    private List<IPSAppDataEntity> siblingList = null;
    private List<IPSAppPortlet> psAppPortletList = null;
    private List<IPSAppPortletCat> psAppPortletCatList = null;
    private boolean bLoadPSAppDEUIActionGroupNow = false;
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private ArrayList<IPSAppDEField> quickSearchPSAppDEFieldList = null;
    private ArrayList<IPSAppCodeList> psAppCodeListList;
    private int nEnableUIActions = 0;
    private IPSAppModule iPSAppModule = null;
    private IPSLanguageRes lnPSLanguageRes = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSysUniRes iPSSysUniRes = null;
    private Map<String, IPSAppDEMethodDTO> psAppDEMethodDTOMap = new TreeMap<String, IPSAppDEMethodDTO>();

    static {
        FilterActions.put("FILTERGET", "FilterGet");
        FilterActions.put("FILTERGETDRAFT", "FilterGetDraft");
        FilterActions.put("FILTERCREATE", "FilterCreate");
        FilterActions.put("FILTERUPDATE", "FilterUpdate");
        FilterActions.put("FILTERSEARCH", "FilterSearch");
        FilterActions.put("FILTERREMOVE", "FilterRemove");
        FilterActions.put("FILTERFETCH", "FilterFetch");
        WFActions.put("WFSTART", "WFStart");
        WFActions.put("WFSUBMIT", "WFSubmit");
        WFActions.put("WFCLOSE", "WFClose");
        WFActions.put("WFRESTART", "WFRestart");
        WFActions.put("WFROLLBACK", "WFRollback");
        WFActions.put("WFMARKREAD", "WFMarkRead");
        WFActions.put("WFGOTO", "WFGoto");
        WFActions.put("WFREASSIGN", "WFReassign");
        WFActions.put("WFSENDBACK", "WFSendBack");
        MODELGROUPS = new String[]{"\u57fa\u672c", MODELGROUP_MODEL, MODELGROUP_LOGIC, MODELGROUP_UILOGIC, MODELGROUP_UI, MODELGROUP_ACCCTRL, MODELGROUP_TEST, "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppLocalDE psAppLocalDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppLocalDE = psAppLocalDE;
            this.setId(this.psAppLocalDE.getPSAPPLOCALDEID());
            this.setName(this.psAppLocalDE.getPSAPPLOCALDENAME());
            this.setPSObjectData(psAppLocalDE);
            if (StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSDEID())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u76f8\u5173\u5b9e\u4f53"));
            }
            this.iPSDataEntity = this.getPSApplication().getPSSystem().getPSDataEntity2(this.psAppLocalDE.getPSDEID());
            this.bDefaultMode = this.psAppLocalDE.isDEFAULTFLAGNull() ? StringHelper.compare((String)psAppLocalDE.getPSAPPLOCALDEID(), (String)KeyValueHelper.genUniqueId((String)psAppLocalDE.getPSSYSAPPID(), (String)psAppLocalDE.getPSDEID()), (boolean)false) == 0 : this.psAppLocalDE.getDEFAULTFLAG();
            if (!this.psAppLocalDE.isENABLESTORAGENull()) {
                this.nStorageMode = this.psAppLocalDE.GetParamIntValue("ENABLESTORAGE", this.nStorageMode);
            }
            if (this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_LOCALONLY.intValue() && this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_DTOONLY.intValue() && this.getPSApplication().isUseServiceApi() && this.getPSApplication().getPSSysServiceAPI() != null) {
                if (StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSDESERVICEAPIID())) {
                    this.iPSDEServiceAPI = this.getPSApplication().getPSSysServiceAPI().getPSDEServiceAPI(this.getPSDataEntity().getId(), true);
                } else if (!StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSSYSSERVICEAPIID())) {
                    this.iPSSysServiceAPI = this.getPSApplication().getPSSystem().getPSSysServiceAPI(this.psAppLocalDE.getPSSYSSERVICEAPIID());
                    this.iPSDEServiceAPI = this.iPSSysServiceAPI.getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID());
                } else {
                    Iterator<IPSSysServiceAPI> psSysServiceAPIs;
                    this.iPSDEServiceAPI = this.getPSApplication().getPSSysServiceAPI().getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID(), true);
                    if (this.iPSDEServiceAPI == null && (psSysServiceAPIs = this.getPSApplication().getPSSystem().getAllPSSysServiceAPIs()) != null) {
                        while (psSysServiceAPIs.hasNext()) {
                            IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
                            this.iPSDEServiceAPI = iPSSysServiceAPI.getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID(), true);
                            if (this.iPSDEServiceAPI == null) continue;
                        }
                    }
                }
                if (this.getPSDEServiceAPI() == null) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]", (Object)this.getPSApplication().getPSSysServiceAPI().getName(), (Object)this.getPSDataEntity().getName()));
                }
            }
            if (this.getPSSysServiceAPI() == null && this.getPSDEServiceAPI() != null) {
                this.iPSSysServiceAPI = this.getPSDEServiceAPI().getPSSysServiceAPI();
            }
            if (!this.psAppLocalDE.isMAJORFLAGNull() && this.psAppLocalDE.getMAJORFLAG() != 2) {
                this.bMajor = this.psAppLocalDE.getMAJORFLAG() == 1;
            } else if (this.getPSDEServiceAPI() != null) {
                this.bMajor = this.getPSDEServiceAPI().isMajor();
            }
            this.strCodeName = this.psAppLocalDE.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                if (this.getPSDEServiceAPI() != null) {
                    this.strCodeName = this.getPSDEServiceAPI().getCodeName();
                }
                if (StringHelper.isNullOrEmpty((String)this.strCodeName) && this.isMajor() && this.getPSDataEntity() != null) {
                    this.strCodeName = this.getPSDataEntity().getCodeName();
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
                String strHeader = this.getName().substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.getName().substring(1);
            }
            this.nDataAccCtrlMode = !this.psAppLocalDE.isDATAACCMODENull() ? this.psAppLocalDE.getDATAACCMODE() : (this.getPSDEServiceAPI() != null ? this.getPSDEServiceAPI().getDataAccCtrlMode() : this.getPSDataEntity().getDataAccCtrlMode());
            this.nDataAccCtrlArch = !this.psAppLocalDE.isACCCTRLARCHNull() ? this.psAppLocalDE.getACCCTRLARCH() : (this.getPSDEServiceAPI() != null ? this.getPSDEServiceAPI().getDataAccCtrlArch() : this.getPSDataEntity().getDataAccCtrlArch());
            this.nEnableUIActions = this.getPSDataEntity().getEnableUIActions();
            if (!this.psAppLocalDE.isCUSTOMUSERACTIONNull() && this.psAppLocalDE.getCUSTOMUSERACTION() && !this.psAppLocalDE.isUSERACTIONNull()) {
                int nUIAction = this.psAppLocalDE.getUSERACTION();
                if ((nUIAction & 1) == 0) {
                    this.nEnableUIActions |= 1;
                }
                if ((nUIAction & 2) == 0) {
                    this.nEnableUIActions |= 2;
                }
                if ((nUIAction & 4) == 0) {
                    this.nEnableUIActions |= 4;
                }
                if ((nUIAction & 8) == 0) {
                    this.nEnableUIActions |= 8;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSDERID())) {
                IPSDERBase iPSDERBase = this.getPSApplication().getPSSystem().getPSDER(this.psAppLocalDE.getPSDERID());
                if (iPSDERBase instanceof IPSDER1N) {
                    this.iPSDER1N = (IPSDER1N)iPSDERBase;
                } else {
                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)iPSDERBase.getName()));
                }
            }
            if (!(this.getPSDEServiceAPI() == null && this.getStorageMode() == IPSAppDataEntity.STORAGEMODE_NOLOCAL.intValue() || StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSDEFGROUPID()))) {
                this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psAppLocalDE.getPSDEFGROUPID());
                this.strDEFGroupMode = this.psAppLocalDE.getDEFGROUPMODE();
                if (StringHelper.isNullOrEmpty((String)this.strDEFGroupMode)) {
                    this.strDEFGroupMode = "REPLACE";
                }
            }
            this.lnPSLanguageRes = !StringHelper.isNullOrEmpty((String)psAppLocalDE.getLNPSLANRESID()) ? this.getPSApplication().getPSLanguageRes(psAppLocalDE.getLNPSLANRESID()) : (this.getPSDEServiceAPI() != null ? this.getPSDEServiceAPI().getLNPSLanguageRes() : this.getPSDataEntity().getLNPSLanguageRes());
            if (this.getLNPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getLNPSLanguageRes().getId());
            }
            this.iPSSysUniRes = !StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSSYSUNIRESID()) ? this.getPSSystem().getPSSysUniRes(this.psAppLocalDE.getPSSYSUNIRESID()) : this.getPSDataEntity().getPSSysUniRes();
            this.psAppDEUIActionGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEUIActionGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDELogicGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEUILogicGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEUILogicGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEPrintGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEReportGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEDataImportGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEDataExportGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psAppDEMapGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.onInit();
        }
        catch (Exception ex) {
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
        this.onPreparePSAppWF();
        this.onPreparePSAppDEFields();
        this.onPreparePSAppDEMethods();
        super.onInit();
    }

    @Override
    public void loadAll() throws Exception {
        boolean bLoop;
        Iterator<IPSAppDEMap> psAppDEMaps;
        Iterator<IPSAppDEACMode> psAppDEACModes;
        Iterator<IPSAppDEUIAction> psAppDEUIActions;
        this.getAllPSAppDEUIActions();
        this.bLoadPSAppDEUIActionGroupNow = true;
        this.getAllPSAppDEUIActionGroups();
        this.bLoadPSAppDEUIActionGroupNow = false;
        this.getAllPSAppDEDataImports();
        this.getAllPSAppDEDataExports();
        this.getAllPSAppDEACModes();
        this.getAllPSAppDELogics();
        this.getAllPSAppDEPrints();
        this.getAllPSAppDEReports();
        this.getAllPSAppDEMaps();
        Iterator<IPSAppDEUILogic> psAppDEUILogics = this.getAllPSAppDEUILogics();
        if (psAppDEUILogics != null) {
            ArrayList<IPSAppDEUILogic> list = new ArrayList<IPSAppDEUILogic>();
            while (psAppDEUILogics.hasNext()) {
                list.add(psAppDEUILogics.next());
            }
            for (IPSAppDEUILogic iPSAppDEUILogic : list) {
                iPSAppDEUILogic.check();
            }
        }
        this.getAllPSAppDEUILogicGroups();
        Iterator<? extends IPSAppDEMethod> psAppDEMethods = this.getAllPSAppDEMethods();
        if (psAppDEMethods != null) {
            while (psAppDEMethods.hasNext()) {
                IPSAppDEMethod iPSAppDEMethod = psAppDEMethods.next();
                iPSAppDEMethod.check();
            }
        }
        if ((psAppDEUIActions = this.getAllPSAppDEUIActions()) != null) {
            ArrayList<IPSAppDEUIAction> list = new ArrayList<IPSAppDEUIAction>();
            while (psAppDEUIActions.hasNext()) {
                list.add(psAppDEUIActions.next());
            }
            for (IPSAppDEUIAction iPSAppDEUIAction : list) {
                iPSAppDEUIAction.check();
            }
        }
        if ((psAppDEACModes = this.getAllPSAppDEACModes()) != null) {
            ArrayList<IPSAppDEACMode> list = new ArrayList<IPSAppDEACMode>();
            while (psAppDEACModes.hasNext()) {
                list.add(psAppDEACModes.next());
            }
            for (IPSAppDEACMode iPSAppDEACMode : list) {
                iPSAppDEACMode.check();
            }
        }
        if ((psAppDEMaps = this.getAllPSAppDEMaps()) != null) {
            ArrayList<IPSAppDEMap> list = new ArrayList<IPSAppDEMap>();
            while (psAppDEMaps.hasNext()) {
                list.add(psAppDEMaps.next());
            }
            for (IPSAppDEMap iPSAppDEMap : list) {
                iPSAppDEMap.check();
            }
        }
        HashMap<String, IPSAppDEMethodDTO> psAppDEMethodDTOMap = new HashMap<String, IPSAppDEMethodDTO>();
        do {
            ArrayList<IPSAppDEMethodDTO> list = new ArrayList<IPSAppDEMethodDTO>();
            Iterator<IPSAppDEMethodDTO> psAppDEMethodDTOs = this.getAllPSAppDEMethodDTOs();
            if (psAppDEMethodDTOs != null) {
                while (psAppDEMethodDTOs.hasNext()) {
                    IPSAppDEMethodDTO iPSAppDEMethodDTO = psAppDEMethodDTOs.next();
                    list.add(iPSAppDEMethodDTO);
                }
            }
            bLoop = false;
            for (IPSAppDEMethodDTO iPSAppDEMethodDTO : list) {
                if (psAppDEMethodDTOMap.containsKey(iPSAppDEMethodDTO.getCodeName())) continue;
                iPSAppDEMethodDTO.check();
                psAppDEMethodDTOMap.put(iPSAppDEMethodDTO.getCodeName(), iPSAppDEMethodDTO);
                bLoop = true;
            }
        } while (bLoop);
    }

    @Override
    public IPSDataEntity getPSDE() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, ignorepf=true, group="\u6a21\u578b", order=155, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public String getFullName() {
        return String.format("%1$s|%2$s", this.getPSApplication().getName(), this.getName());
    }

    @Override
    public void registerPSControl(IPSControl iPSControl) throws Exception {
        if (this.psControlList == null) {
            this.psControlList = new ArrayList();
        }
        this.psControlList.add(iPSControl);
    }

    @Override
    public Iterator<IPSControl> getPSControls() throws Exception {
        if (this.psControlList == null || this.psControlList.size() == 0) {
            return null;
        }
        return this.psControlList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSControl> getAllPSControls() throws Exception {
        return this.getPSControls();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408\uff08\u5f15\u7528\u89c6\u56fe\uff09", outputdoc="false")
    public Iterator<IPSControl> getAllRefPSControls() throws Exception {
        if (this.refPSControlList != null) {
            if (this.refPSControlList.size() == 0) {
                return null;
            }
            return this.refPSControlList.iterator();
        }
        PSAppDataEntityImpl pSAppDataEntityImpl = this;
        synchronized (pSAppDataEntityImpl) {
            ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
            Iterator<IPSControl> psControls = this.getAllPSControls();
            if (psControls != null) {
                while (psControls.hasNext()) {
                    IPSControl iPSControl = psControls.next();
                    if (!iPSControl.getPSAppView().getRefFlag()) continue;
                    psControlList.add(iPSControl);
                }
            }
            if (this.refPSControlList == null) {
                this.refPSControlList = psControlList;
            }
        }
        if (this.refPSControlList.size() == 0) {
            return null;
        }
        return this.refPSControlList.iterator();
    }

    @Override
    public void registerRefPSDEDataSet(IPSDEDataSet iPSDEDataSet, Object refObject) throws Exception {
        if (this.refPSDEDataSetMap == null) {
            this.refPSDEDataSetMap = new LinkedHashMap<String, IPSDEDataSet>();
        }
        this.refPSDEDataSetMap.put(iPSDEDataSet.getId(), iPSDEDataSet);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEDataSet> getRefPSDEDataSets() throws Exception {
        if (this.refPSDEDataSetMap == null || this.refPSDEDataSetMap.size() == 0) {
            return null;
        }
        return this.refPSDEDataSetMap.values().iterator();
    }

    @Override
    public void registerRefPSAppView(IPSAppView iPSAppView, Object refObject) throws Exception {
        if (this.refPSAppViewMap == null) {
            this.refPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
        }
        this.refPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppView> getRefPSAppViews() throws Exception {
        if (!this.bPrepareRefPSAppView) {
            if (this.psControlList != null) {
                for (IPSControl iPSControl : this.psControlList) {
                    ArrayList<IPSAppView> relatedAppViewList = new ArrayList<IPSAppView>();
                    iPSControl.fillRelatedPSAppViews(relatedAppViewList);
                    for (IPSAppView iPSAppView : relatedAppViewList) {
                        this.registerRefPSAppView(iPSAppView, iPSControl);
                    }
                }
            }
            this.bPrepareRefPSAppView = true;
        }
        if (this.refPSAppViewMap == null || this.refPSAppViewMap.size() == 0) {
            return null;
        }
        return this.refPSAppViewMap.values().iterator();
    }

    @Override
    public String getModelType() {
        return "PSAPPDATAENTITY";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u81ea\u52a8\u586b\u5145\u6a21\u5f0f", outputdoc="false")
    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception {
        return this.getPSDE().getAllPSDEACModes();
    }

    @Override
    public IPSDEACMode getPSDEACMode(String strDEACModeId) throws Exception {
        return this.getPSDE().getPSDEACMode(strDEACModeId);
    }

    @Override
    public void resetPSDEACMode(String strDEACModeId) throws Exception {
        this.getPSDE().resetPSDEACMode(strDEACModeId);
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5e94\u7528\u89c6\u56fe", child=true, dumpref=true, ignorepf=true, ignorert=1, dynamodelmode=8, group="\u754c\u9762&\u7ec4\u4ef6", order=295)
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        if (this.allPSAppViewList == null) {
            ArrayList<IPSAppView> psAppDEViewList = new ArrayList<IPSAppView>();
            Iterator<IPSAppView> psAppViews = this.getPSApplication().getAllPSAppViews();
            if (psAppViews != null) {
                while (psAppViews.hasNext()) {
                    IPSAppView iPSAppView = psAppViews.next();
                    if (iPSAppView.getPSAppDataEntity() == null || StringHelper.compare((String)iPSAppView.getPSAppDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psAppDEViewList.add(iPSAppView);
                }
            }
            this.allPSAppViewList = psAppDEViewList;
        }
        if (this.allPSAppViewList == null || this.allPSAppViewList.size() == 0) {
            return null;
        }
        return this.allPSAppViewList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", codelist="AccCtrlArch", fields={"ACCCTRLARCH"})
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", codelist="DEDataAccCtrlMode", fields={"DATAACCMODE"})
    public int getDataAccCtrlMode() {
        return this.nDataAccCtrlMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53", fields={"MAJORFLAG"})
    public boolean isMajor() {
        return this.bMajor;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        String strLogicName = this.psAppLocalDE.getLOGICNAME();
        if (StringHelper.isNullOrEmpty((String)strLogicName)) {
            if (this.getPSDEServiceAPI() != null) {
                return this.getPSDEServiceAPI().getLogicName();
            }
            return this.getPSDE().getLogicName();
        }
        return strLogicName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    protected void setCodeName(String strCodeName) {
        this.strCodeName = strCodeName;
    }

    @Override
    public IPSAppDataEntity getMajorPSAppDataEntity() throws Exception {
        return null;
    }

    @Override
    public String getMajorPSAppDataEntityId() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u5236\u5b9e\u4f53\u5173\u7cfb", child=true, ignorert=3)
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4", fields={"DEFAULTFLAG"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.onGetCodeName2();
    }

    protected String onGetCodeName2() {
        return this.psAppLocalDE.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getPSSysServiceAPIMust().getPSDEServiceAPI", group="\u6a21\u578b", order=158, fields={"PSDESERVICEAPIID"})
    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.iPSDEServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<? extends IPSAppDEMethod> getAllPSAppDEMethods() {
        if (this.allPSAppDEMethodList == null || this.allPSAppDEMethodList.size() == 0) {
            return null;
        }
        return this.allPSAppDEMethodList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u96c6\u5408", child=true, ignorert=3, group="\u5904\u7406\u903b\u8f91", order=195)
    public Iterator<IPSAppDEAction> getAllPSAppDEActions() {
        Iterator<? extends IPSAppDEMethod> psAppDEMethods = this.getAllPSAppDEMethods();
        if (psAppDEMethods == null) {
            return null;
        }
        ArrayList<IPSAppDEAction> list = new ArrayList<IPSAppDEAction>();
        while (psAppDEMethods.hasNext()) {
            IPSAppDEMethod iPSAppDEMethod = psAppDEMethods.next();
            if (!"DEACTION".equals(iPSAppDEMethod.getMethodType())) continue;
            list.add((IPSAppDEAction)iPSAppDEMethod);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u96c6\u5408", child=true, ignorert=3, group="\u5904\u7406\u903b\u8f91", order=198)
    public Iterator<IPSAppDEDataSet> getAllPSAppDEDataSets() {
        Iterator<? extends IPSAppDEMethod> psAppDEMethods = this.getAllPSAppDEMethods();
        if (psAppDEMethods == null) {
            return null;
        }
        ArrayList<IPSAppDEDataSet> list = new ArrayList<IPSAppDEDataSet>();
        while (psAppDEMethods.hasNext()) {
            IPSAppDEMethod iPSAppDEMethod = psAppDEMethods.next();
            if (!"FETCH".equals(iPSAppDEMethod.getMethodType())) continue;
            list.add((IPSAppDEDataSet)iPSAppDEMethod);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    protected void onPreparePSAppWF() throws Exception {
        Iterator<IPSDEWF> psDEWFs;
        IPSDEWF iPSDEWF = this.getPSDataEntity().getDefaultPSDEWF();
        if (iPSDEWF != null && (iPSDEWF.getWFProxyMode() == 0 || (iPSDEWF.getWFProxyMode() & 2) == 2)) {
            this.iPSAppWF = this.getPSApplication().getPSAppWF(iPSDEWF.getPSWorkflow().getId(), true);
            if (this.iPSAppWF != null) {
                return;
            }
        }
        if ((psDEWFs = this.getPSDataEntity().getAllPSDEWFs()) != null) {
            while (psDEWFs.hasNext()) {
                iPSDEWF = psDEWFs.next();
                if (iPSDEWF.getWFProxyMode() != 0 && (iPSDEWF.getWFProxyMode() & 2) != 2) continue;
                this.iPSAppWF = this.getPSApplication().getPSAppWF(iPSDEWF.getPSWorkflow().getId(), true);
                if (this.iPSAppWF != null) break;
            }
        }
    }

    protected void onPreparePSAppDEFields() throws Exception {
        PSAppDEFieldImpl2 psAppDEFieldImpl;
        if (this.getPSDEServiceAPI() == null && this.getStorageMode() == IPSAppDataEntity.STORAGEMODE_NOLOCAL.intValue()) {
            return;
        }
        if (this.psAppDEFieldList == null) {
            this.psAppDEFieldList = new ArrayList();
        } else {
            this.psAppDEFieldList.clear();
        }
        if (this.psAppDEFieldMap == null) {
            this.psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
        } else {
            this.psAppDEFieldMap.clear();
        }
        if (this.getPSDEFGroup() != null) {
            Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
            if (psDEFGroupDetails != null) {
                if (StringHelper.compare((String)this.getDEFGroupMode(), (String)"REPLACE", (boolean)true) == 0) {
                    while (psDEFGroupDetails.hasNext()) {
                        IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                        psAppDEFieldImpl = new PSAppDEFieldImpl2();
                        psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                        this.psAppDEFieldList.add(psAppDEFieldImpl);
                    }
                } else {
                    PSAppDEFieldImpl2 psAppDEFieldImpl2;
                    IPSDEFGroupDetail iPSDEFGroupDetail;
                    boolean bOverwrite;
                    LinkedHashMap<String, IPSDEFGroupDetail> psDEFGroupDetailMap = new LinkedHashMap<String, IPSDEFGroupDetail>();
                    while (psDEFGroupDetails.hasNext()) {
                        IPSDEFGroupDetail iPSDEFGroupDetail2 = psDEFGroupDetails.next();
                        psDEFGroupDetailMap.put(iPSDEFGroupDetail2.getPSDEField().getId(), iPSDEFGroupDetail2);
                    }
                    if (this.getPSDEServiceAPI() == null) {
                        Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
                        if (psDEFields != null) {
                            bOverwrite = false;
                            if (StringHelper.compare((String)this.getDEFGroupMode(), (String)"OVERWRITE", (boolean)true) == 0) {
                                bOverwrite = true;
                            }
                            while (psDEFields.hasNext()) {
                                IPSDEField iPSDEField = psDEFields.next();
                                iPSDEFGroupDetail = (IPSDEFGroupDetail)psDEFGroupDetailMap.get(iPSDEField.getId());
                                if (iPSDEFGroupDetail != null) {
                                    if (!bOverwrite) continue;
                                    psAppDEFieldImpl2 = new PSAppDEFieldImpl2();
                                    psAppDEFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                                    this.psAppDEFieldList.add(psAppDEFieldImpl2);
                                    continue;
                                }
                                psAppDEFieldImpl2 = new PSAppDEFieldImpl2();
                                psAppDEFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEField);
                                this.psAppDEFieldList.add(psAppDEFieldImpl2);
                            }
                        }
                    } else {
                        Iterator<? extends IPSDEServiceAPIField> psDEServiceAPIFields = this.getPSDEServiceAPI().getPSDEServiceAPIFields();
                        if (psDEServiceAPIFields != null) {
                            bOverwrite = false;
                            if (StringHelper.compare((String)this.getDEFGroupMode(), (String)"OVERWRITE", (boolean)true) == 0) {
                                bOverwrite = true;
                            }
                            while (psDEServiceAPIFields.hasNext()) {
                                IPSDEServiceAPIField iPSDEServiceAPIField = psDEServiceAPIFields.next();
                                iPSDEFGroupDetail = null;
                                if (iPSDEServiceAPIField.getPSDEField() != null) {
                                    iPSDEFGroupDetail = (IPSDEFGroupDetail)psDEFGroupDetailMap.get(iPSDEServiceAPIField.getPSDEField().getId());
                                }
                                if (iPSDEFGroupDetail != null) {
                                    if (!bOverwrite) continue;
                                    psAppDEFieldImpl2 = new PSAppDEFieldImpl2();
                                    psAppDEFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                                    this.psAppDEFieldList.add(psAppDEFieldImpl2);
                                    continue;
                                }
                                psAppDEFieldImpl2 = new PSAppDEFieldImpl2();
                                psAppDEFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIField);
                                this.psAppDEFieldList.add(psAppDEFieldImpl2);
                            }
                        }
                    }
                }
                Collections.sort(this.psAppDEFieldList, new Comparator<IPSAppDEField>(){

                    @Override
                    public int compare(IPSAppDEField arg0, IPSAppDEField arg1) {
                        int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                        if (nValue == 0) {
                            return arg0.getName().compareTo(arg1.getName());
                        }
                        return new Integer(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
                    }
                });
            }
        } else if (this.getPSDEServiceAPI() != null) {
            Iterator<? extends IPSDEServiceAPIField> psDEServiceAPIFields = this.getPSDEServiceAPI().getPSDEServiceAPIFields();
            if (psDEServiceAPIFields != null) {
                while (psDEServiceAPIFields.hasNext()) {
                    IPSDEServiceAPIField iPSDEServiceAPIField = psDEServiceAPIFields.next();
                    psAppDEFieldImpl = new PSAppDEFieldImpl2();
                    psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIField);
                    this.psAppDEFieldList.add(psAppDEFieldImpl);
                }
            }
        } else {
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    psAppDEFieldImpl = new PSAppDEFieldImpl2();
                    psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
                    this.psAppDEFieldList.add(psAppDEFieldImpl);
                }
            }
        }
        for (IPSAppDEField iPSAppDEField : this.psAppDEFieldList) {
            if (iPSAppDEField.isMajorField()) {
                this.majorPSAppDEField = iPSAppDEField;
            }
            if (iPSAppDEField.isKeyField()) {
                this.keyPSAppDEField = iPSAppDEField;
            }
            this.psAppDEFieldMap.put(iPSAppDEField.getId(), iPSAppDEField);
            if (!this.psAppDEFieldMap.containsKey(iPSAppDEField.getName())) {
                this.psAppDEFieldMap.put(iPSAppDEField.getName(), iPSAppDEField);
            }
            if (iPSAppDEField.getPSDEField() == null || this.psAppDEFieldMap.containsKey(iPSAppDEField.getPSDEField().getId())) continue;
            this.psAppDEFieldMap.put(iPSAppDEField.getPSDEField().getId(), iPSAppDEField);
        }
    }

    protected void onPreparePSAppDEMethods() throws Exception {
        PSAppDEMethodImpl psAppDEMethodImpl;
        PSDESADetail psDESADetail;
        String strMethodTag2;
        String strMethodTag;
        String strMethodTag22;
        String strMethodTag3;
        PSAppDEMethodImpl psAppDEMethodImpl2;
        this.allPSAppDEMethodList = null;
        this.psAppDEMethodMap = null;
        if (this.getPSDEServiceAPI() == null && this.getStorageMode() != STORAGEMODE_LOCALONLY.intValue() && this.getStorageMode() != STORAGEMODE_DTOONLY.intValue()) {
            return;
        }
        this.allPSAppDEMethodList = new ArrayList();
        this.psAppDEMethodMap = new LinkedHashMap<String, IPSAppDEMethod>();
        if (this.getPSDEServiceAPI() != null && this.getPSDEServiceAPI().isNested() || this.getStorageMode() == STORAGEMODE_LOCALONLY.intValue() || this.getStorageMode() == STORAGEMODE_DTOONLY.intValue()) {
            Iterator<IPSDEDataSet> psDEDataSets;
            Iterator<IPSDEAction> psDEActions = this.getPSDataEntity().getAllPSDEActions();
            if (psDEActions != null) {
                while (psDEActions.hasNext()) {
                    IPSDEAction iPSDEAction = psDEActions.next();
                    if (!iPSDEAction.isEnableFront()) continue;
                    psAppDEMethodImpl2 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl2.init(this.getDAGlobalHelper(), this, iPSDEAction);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl2);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl2.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl2.getId(), psAppDEMethodImpl2);
                    }
                    strMethodTag3 = null;
                    strMethodTag22 = null;
                    strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEAction().getId());
                    strMethodTag22 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEAction().getName().toUpperCase());
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag3)) {
                        this.psAppDEMethodMap.put(strMethodTag3, psAppDEMethodImpl2);
                    }
                    if (StringHelper.isNullOrEmpty((String)strMethodTag22)) continue;
                    this.psAppDEMethodMap.put(strMethodTag22, psAppDEMethodImpl2);
                }
            }
            if ((psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets()) != null) {
                while (psDEDataSets.hasNext()) {
                    IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                    if (!iPSDEDataSet.isEnableFront()) continue;
                    PSAppDEMethodImpl psAppDEMethodImpl3 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl3.init(this.getDAGlobalHelper(), this, iPSDEDataSet);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl3);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl3.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl3.getId(), psAppDEMethodImpl3);
                    }
                    strMethodTag = null;
                    strMethodTag2 = null;
                    strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl3.getMethodType(), (Object)psAppDEMethodImpl3.getPSDEDataSet().getId());
                    strMethodTag2 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl3.getMethodType(), (Object)psAppDEMethodImpl3.getPSDEDataSet().getName().toUpperCase());
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag)) {
                        this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl3);
                    }
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag2)) {
                        this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl3);
                    }
                    if (!iPSDEDataSet.isEnableTempData() || !this.isEnableTempData()) continue;
                    psAppDEMethodImpl3 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl3.initTempMode(this.getDAGlobalHelper(), this, iPSDEDataSet);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl3);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl3.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl3.getId(), psAppDEMethodImpl3);
                    }
                    strMethodTag = null;
                    strMethodTag2 = null;
                    strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl3.getMethodType(), (Object)psAppDEMethodImpl3.getPSDEDataSet().getId());
                    strMethodTag2 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl3.getMethodType(), (Object)psAppDEMethodImpl3.getPSDEDataSet().getName().toUpperCase());
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag)) {
                        this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl3);
                    }
                    if (StringHelper.isNullOrEmpty((String)strMethodTag2)) continue;
                    this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl3);
                }
            }
        } else {
            Iterator<IPSDEDataSet> psDEDataSets;
            Iterator<IPSDEAction> psDEActions;
            Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = this.getPSDEServiceAPI().getPSDEServiceAPIMethods();
            if (psDEServiceAPIMethods != null) {
                while (psDEServiceAPIMethods.hasNext()) {
                    IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                    psAppDEMethodImpl2 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl2.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIMethod);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl2);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl2.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl2.getId(), psAppDEMethodImpl2);
                    }
                    strMethodTag3 = null;
                    strMethodTag22 = null;
                    if (StringHelper.compare((String)psAppDEMethodImpl2.getMethodType(), (String)"DEACTION", (boolean)false) == 0) {
                        if (psAppDEMethodImpl2.getPSDEAction() != null) {
                            strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEAction().getId());
                            strMethodTag22 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEAction().getName().toUpperCase());
                        }
                    } else if ((StringHelper.compare((String)psAppDEMethodImpl2.getMethodType(), (String)"FETCH", (boolean)false) == 0 || StringHelper.compare((String)psAppDEMethodImpl2.getMethodType(), (String)"FETCHTEMP", (boolean)false) == 0) && psAppDEMethodImpl2.getPSDEDataSet() != null) {
                        strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEDataSet().getId());
                        strMethodTag22 = StringHelper.format((String)"%1$s|%2$s", (Object)psAppDEMethodImpl2.getMethodType(), (Object)psAppDEMethodImpl2.getPSDEDataSet().getName().toUpperCase());
                    }
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag3)) {
                        this.psAppDEMethodMap.put(strMethodTag3, psAppDEMethodImpl2);
                    }
                    if (StringHelper.isNullOrEmpty((String)strMethodTag22)) continue;
                    this.psAppDEMethodMap.put(strMethodTag22, psAppDEMethodImpl2);
                }
            }
            if ((psDEActions = this.getPSDataEntity().getAllPSDEActions()) != null) {
                while (psDEActions.hasNext()) {
                    IPSDEAction iPSDEAction = psDEActions.next();
                    if (!iPSDEAction.isEnableFront()) continue;
                    strMethodTag3 = null;
                    strMethodTag22 = null;
                    strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)"DEACTION", (Object)iPSDEAction.getId());
                    strMethodTag22 = StringHelper.format((String)"%1$s|%2$s", (Object)"DEACTION", (Object)iPSDEAction.getName().toUpperCase());
                    if (this.psAppDEMethodMap.containsKey(strMethodTag3)) continue;
                    PSAppDEMethodImpl psAppDEMethodImpl4 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl4.init(this.getDAGlobalHelper(), this, iPSDEAction);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl4);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl4.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl4.getId(), psAppDEMethodImpl4);
                    }
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag3)) {
                        this.psAppDEMethodMap.put(strMethodTag3, psAppDEMethodImpl4);
                    }
                    if (StringHelper.isNullOrEmpty((String)strMethodTag22)) continue;
                    this.psAppDEMethodMap.put(strMethodTag22, psAppDEMethodImpl4);
                }
            }
            if ((psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets()) != null) {
                while (psDEDataSets.hasNext()) {
                    PSAppDEMethodImpl psAppDEMethodImpl5;
                    IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                    if (!iPSDEDataSet.isEnableFront()) continue;
                    strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCH", (Object)iPSDEDataSet.getId());
                    strMethodTag2 = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCH", (Object)iPSDEDataSet.getName().toUpperCase());
                    if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                        psAppDEMethodImpl5 = new PSAppDEMethodImpl();
                        psAppDEMethodImpl5.init(this.getDAGlobalHelper(), this, iPSDEDataSet);
                        this.allPSAppDEMethodList.add(psAppDEMethodImpl5);
                        if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl5.getId())) {
                            this.psAppDEMethodMap.put(psAppDEMethodImpl5.getId(), psAppDEMethodImpl5);
                        }
                        if (!StringHelper.isNullOrEmpty((String)strMethodTag)) {
                            this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl5);
                        }
                        if (!StringHelper.isNullOrEmpty((String)strMethodTag2)) {
                            this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl5);
                        }
                    }
                    if (!iPSDEDataSet.isEnableTempData() || !this.isEnableTempData()) continue;
                    strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCHTEMP", (Object)iPSDEDataSet.getId());
                    strMethodTag2 = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCHTEMP", (Object)iPSDEDataSet.getName().toUpperCase());
                    if (this.psAppDEMethodMap.containsKey(strMethodTag)) continue;
                    psAppDEMethodImpl5 = new PSAppDEMethodImpl();
                    psAppDEMethodImpl5.initTempMode(this.getDAGlobalHelper(), this, iPSDEDataSet);
                    this.allPSAppDEMethodList.add(psAppDEMethodImpl5);
                    if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl5.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl5.getId(), psAppDEMethodImpl5);
                    }
                    if (!StringHelper.isNullOrEmpty((String)strMethodTag)) {
                        this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl5);
                    }
                    if (StringHelper.isNullOrEmpty((String)strMethodTag2)) continue;
                    this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl5);
                }
            }
        }
        if (this.isEnableFilterActions()) {
            for (Map.Entry<String, String> entry : FilterActions.entrySet()) {
                psDESADetail = new PSDESADetail();
                psDESADetail.setPSDESADETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)entry.getKey()));
                psDESADetail.setPSDESADETAILNAME(entry.getKey());
                psDESADetail.setCODENAME(entry.getValue());
                psDESADetail.setDETAILTYPE("FILTERACTION");
                strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)"FILTERACTION", (Object)entry.getKey());
                if (this.psAppDEMethodMap.containsKey(strMethodTag3)) continue;
                psAppDEMethodImpl = new PSAppDEMethodImpl();
                psAppDEMethodImpl.initBuiltinMode(this.getDAGlobalHelper(), this, (Object)psDESADetail);
                this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl.getId())) {
                    this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                }
                if (StringHelper.isNullOrEmpty((String)strMethodTag3)) continue;
                this.psAppDEMethodMap.put(strMethodTag3, psAppDEMethodImpl);
            }
        }
        if (this.isEnableWFActions()) {
            for (Map.Entry<String, String> entry : WFActions.entrySet()) {
                psDESADetail = new PSDESADetail();
                psDESADetail.setPSDESADETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)entry.getKey()));
                psDESADetail.setPSDESADETAILNAME(entry.getKey());
                psDESADetail.setCODENAME(entry.getValue());
                psDESADetail.setDETAILTYPE("WFACTION");
                strMethodTag3 = StringHelper.format((String)"%1$s|%2$s", (Object)"WFACTION", (Object)entry.getKey());
                if (this.psAppDEMethodMap.containsKey(strMethodTag3)) continue;
                psAppDEMethodImpl = new PSAppDEMethodImpl();
                psAppDEMethodImpl.initBuiltinMode(this.getDAGlobalHelper(), this, (Object)psDESADetail);
                this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                if (!StringHelper.isNullOrEmpty((String)psAppDEMethodImpl.getId())) {
                    this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                }
                if (StringHelper.isNullOrEmpty((String)strMethodTag3)) continue;
                this.psAppDEMethodMap.put(strMethodTag3, psAppDEMethodImpl);
            }
        }
        if (this.allPSAppDEMethodList.size() == 0) {
            this.allPSAppDEMethodList = null;
        }
        if (this.psAppDEMethodMap.size() == 0) {
            this.psAppDEMethodMap = null;
        }
        if (this.allPSAppDEMethodList != null && this.allPSAppDEMethodList.size() != 0) {
            Collections.sort(this.allPSAppDEMethodList, new Comparator<IPSAppDEMethod>(){

                @Override
                public int compare(IPSAppDEMethod o1, IPSAppDEMethod o2) {
                    int nRet = o1.getMethodType().compareTo(o2.getMethodType());
                    if (nRet != 0) {
                        return nRet;
                    }
                    return StringHelper.compare((String)o1.getCodeName(), (String)o2.getCodeName(), (boolean)false);
                }
            });
        }
    }

    @Override
    @PSModelRTMeta(description="\u672c\u5730\u5b58\u50a8\u6a21\u5f0f", codelist="AppDEStorageMode", group="\u57fa\u672c", order=125, fields={"ENABLESTORAGE"})
    public int getStorageMode() {
        return this.nStorageMode;
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSs(boolean bMajor) {
        Iterator<IPSAppDERS> psAppDERSs;
        block10: {
            psAppDERSs = this.getPSApplication().getAllPSAppDERSs();
            if (psAppDERSs != null) break block10;
            return null;
        }
        try {
            if (bMajor) {
                if (this.majorPSAppDERSList == null) {
                    ArrayList<IPSAppDERS> list = new ArrayList<IPSAppDERS>();
                    while (psAppDERSs.hasNext()) {
                        IPSAppDERS iPSAppDERS = psAppDERSs.next();
                        if (StringHelper.compare((String)iPSAppDERS.getPPSAppDataEntityId(), (String)this.getId(), (boolean)true) != 0) continue;
                        list.add(iPSAppDERS);
                    }
                    if (this.majorPSAppDERSList == null) {
                        PSModelUtil.sort(list);
                        this.majorPSAppDERSList = list;
                    }
                }
                return this.majorPSAppDERSList.iterator();
            }
            if (this.minorPSAppDERSList == null) {
                ArrayList<IPSAppDERS> list = new ArrayList<IPSAppDERS>();
                while (psAppDERSs.hasNext()) {
                    IPSAppDERS iPSAppDERS = psAppDERSs.next();
                    if (StringHelper.compare((String)iPSAppDERS.getCPSAppDataEntityId(), (String)this.getId(), (boolean)true) != 0) continue;
                    list.add(iPSAppDERS);
                }
                if (this.minorPSAppDERSList == null) {
                    PSModelUtil.sort(list);
                    this.minorPSAppDERSList = list;
                }
            }
            return this.minorPSAppDERSList.iterator();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSs() {
        return this.getPSAppDERSs(true);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u4e3b\u5173\u7cfb\u96c6\u5408", group="\u6a21\u578b", order=166)
    public Iterator<? extends IPSAppDERS> getMajorPSAppDERSs() {
        return this.getPSAppDERSs(true);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u4ece\u5173\u7cfb\u96c6\u5408", child=true, group="\u6a21\u578b", order=165)
    public Iterator<? extends IPSAppDERS> getMinorPSAppDERSs() {
        return this.getPSAppDERSs(false);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false)
    public int getPSAppDERSPathCount() throws Exception {
        this.preparePSAppDERSPaths();
        if (this.psAppDERSPathMap == null) {
            return 0;
        }
        return this.psAppDERSPathMap.size();
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
        this.preparePSAppDERSPaths();
        if (this.psAppDERSPathMap == null) {
            return null;
        }
        ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected synchronized void preparePSAppDERSPaths() throws Exception {
        var1_1 = this;
        synchronized (var1_1) {
            if (this.psAppDERSPathMap != null) {
                return;
            }
            this.psAppDERSPathMap = new LinkedHashMap<Integer, ArrayList<IPSAppDERS>>();
            psAppDERSs = this.getPSAppDERSs(false);
            if (psAppDERSs != null) ** GOTO lbl17
            return;
lbl-1000:
            // 1 sources

            {
                iPSAppDERS = psAppDERSs.next();
                if (StringHelper.compare((String)iPSAppDERS.getPPSAppDataEntityId(), (String)iPSAppDERS.getCPSAppDataEntityId(), (boolean)false) == 0 || iPSAppDERS.getRSMode() != IPSAppDERS.RSMODE_DESARS.intValue()) continue;
                list = new ArrayList<IPSAppDERS>();
                nIndex = this.psAppDERSPathMap.size();
                this.psAppDERSPathMap.put(nIndex, list);
                this.fillPSAppDERSPath(iPSAppDERS, list);
lbl17:
                // 3 sources

                ** while (psAppDERSs.hasNext())
            }
lbl18:
            // 1 sources

            if (this.psAppDERSPathMap.size() > 1) {
                list = new ArrayList<ArrayList<IPSAppDERS>>();
                list.addAll(this.psAppDERSPathMap.values());
                Collections.sort(list, new Comparator<ArrayList<IPSAppDERS>>(){

                    @Override
                    public int compare(ArrayList<IPSAppDERS> arg0, ArrayList<IPSAppDERS> arg1) {
                        if (arg0.size() != arg1.size()) {
                            return Integer.valueOf(arg0.size()).compareTo(arg1.size());
                        }
                        int i = 0;
                        while (i < arg0.size()) {
                            int nRet = arg0.get(i).getName().compareTo(arg1.get(i).getName());
                            if (nRet != 0) {
                                return nRet;
                            }
                            ++i;
                        }
                        return 0;
                    }
                });
                Collections.reverse(list);
                this.psAppDERSPathMap.clear();
                i = 0;
                while (i < list.size()) {
                    this.psAppDERSPathMap.put(i, (ArrayList)list.get(i));
                    ++i;
                }
            }
        }
    }

    protected synchronized void fillPSAppDERSPath(IPSAppDERS iPSAppDERS, ArrayList<IPSAppDERS> list) throws Exception {
        for (IPSAppDERS tempPSAppDERS : list) {
            if (StringHelper.compare((String)iPSAppDERS.getId(), (String)tempPSAppDERS.getId(), (boolean)false) != 0) continue;
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528\u5173\u7cfb[%2$s]", (Object)this.getFullName(), (Object)iPSAppDERS.getName()));
        }
        list.add(0, iPSAppDERS);
        Iterator<? extends IPSAppDERS> majorList = iPSAppDERS.getMajorPSAppDataEntity().getPSAppDERSs(false);
        if (majorList == null) {
            return;
        }
        ArrayList<IPSAppDERS> srcList = new ArrayList<IPSAppDERS>();
        srcList.addAll(list);
        int nIndex = 0;
        while (majorList.hasNext()) {
            int nIndex2;
            ArrayList<IPSAppDERS> list2;
            IPSAppDERS tempPSAppDERS = majorList.next();
            if (StringHelper.compare((String)tempPSAppDERS.getPPSAppDataEntityId(), (String)tempPSAppDERS.getCPSAppDataEntityId(), (boolean)false) == 0 || tempPSAppDERS.getRSMode() != IPSAppDERS.RSMODE_DESARS.intValue()) continue;
            if (nIndex == 0) {
                if (iPSAppDERS.getMajorPSAppDataEntity().isMajor()) {
                    list2 = new ArrayList();
                    list2.addAll(srcList);
                    nIndex2 = this.psAppDERSPathMap.size();
                    this.psAppDERSPathMap.put(nIndex2, list2);
                }
                this.fillPSAppDERSPath(tempPSAppDERS, list);
            } else {
                list2 = new ArrayList<IPSAppDERS>();
                list2.addAll(srcList);
                nIndex2 = this.psAppDERSPathMap.size();
                this.psAppDERSPathMap.put(nIndex2, list2);
                this.fillPSAppDERSPath(tempPSAppDERS, list2);
            }
            ++nIndex;
        }
    }

    @Override
    public int check() throws Exception {
        this.getPSAppDERSPathCount();
        return super.check();
    }

    @Override
    public IPSAppDERS getPSAppDERSPathFirst(int nPathIndex) throws Exception {
        this.preparePSAppDERSPaths();
        if (this.psAppDERSPathMap == null) {
            return null;
        }
        ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public IPSAppDERS getPSAppDERSPathLast(int nPathIndex) throws Exception {
        this.preparePSAppDERSPaths();
        if (this.psAppDERSPathMap == null) {
            return null;
        }
        ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[0]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception {
        return this.getPSAppDERSPath(0);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[1]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception {
        return this.getPSAppDERSPath(1);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[2]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception {
        return this.getPSAppDERSPath(2);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[3]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception {
        return this.getPSAppDERSPath(3);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84[4]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception {
        return this.getPSAppDERSPath(4);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true)
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u4f7f\u7528\u6a21\u5f0f", codelist="DESADEFGroupMode", hideempty2=true)
    public String getDEFGroupMode() {
        return this.strDEFGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408", child=true, group="\u6a21\u578b", order=160)
    public Iterator<? extends IPSAppDEField> getAllPSAppDEFields() {
        if (this.psAppDEFieldList == null || this.psAppDEFieldList.size() == 0) {
            return null;
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    public IPSAppDEField getPSAppDEField(String strPSDEFieldId) throws Exception {
        return this.getPSAppDEField(strPSDEFieldId, false);
    }

    @Override
    public IPSAppDEField getPSAppDEField(IPSDEField iPSDEField, boolean bTryMode) throws Exception {
        IPSAppDEField iPSAppDEField = this.getPSAppDEField(iPSDEField.getId(), true);
        if (iPSAppDEField == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027[%2$s]", (Object)this.getFullName(), (Object)iPSDEField.getName()));
        }
        return iPSAppDEField;
    }

    @Override
    public IPSAppDEField getPSAppDEField(String strPSDEFieldId, boolean bTryMode) throws Exception {
        IPSAppDEField iPSAppDEField = null;
        if (this.psAppDEFieldMap != null) {
            iPSAppDEField = this.psAppDEFieldMap.get(strPSDEFieldId);
        }
        if (iPSAppDEField != null || bTryMode) {
            return iPSAppDEField;
        }
        throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027[%2$s]", (Object)this.getFullName(), (Object)strPSDEFieldId));
    }

    @Override
    public IPSAppDEMethod getPSAppDEMethod(Object objMethod) throws Exception {
        return this.getPSAppDEMethod(objMethod, false);
    }

    @Override
    public IPSAppDEMethod getPSAppDEMethod(Object objMethod, boolean bTryMode) throws Exception {
        String strMethodTag = null;
        if (objMethod instanceof String) {
            strMethodTag = (String)objMethod;
        } else if (objMethod instanceof IPSDEAction) {
            strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)"DEACTION", (Object)((IPSDEAction)objMethod).getId());
        } else if (objMethod instanceof IPSDEDataSet) {
            strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCH", (Object)((IPSDEDataSet)objMethod).getId());
        }
        if (StringHelper.isNullOrEmpty((String)strMethodTag)) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u8bc6\u522b\u6307\u5b9a\u7684\u76ee\u6807\u65b9\u6cd5\u5bf9\u8c61", (Object)this.getFullName()));
        }
        IPSAppDEMethod iPSAppDEMethod = null;
        if (this.psAppDEMethodMap != null) {
            iPSAppDEMethod = this.psAppDEMethodMap.get(strMethodTag);
        }
        if (iPSAppDEMethod == null && !bTryMode) {
            if (objMethod instanceof IPSDEAction) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u65b9\u6cd5[%2$s]", (Object)this.getFullName(), (Object)((IPSDEAction)objMethod).getFullName()));
            }
            if (objMethod instanceof IPSDEDataSet) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u65b9\u6cd5[%2$s]", (Object)this.getFullName(), (Object)((IPSDEDataSet)objMethod).getFullName()));
            }
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5[%2$s]", (Object)this.getFullName(), (Object)strMethodTag));
        }
        return iPSAppDEMethod;
    }

    @Override
    public IPSAppDEMethod getPSAppDEMethod(String strMethodType, String strMethodId, boolean bTryMode) throws Exception {
        String strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)strMethodType, (Object)strMethodId);
        IPSAppDEMethod iPSAppDEMethod = null;
        if (this.psAppDEMethodMap != null) {
            iPSAppDEMethod = this.psAppDEMethodMap.get(strMethodTag);
        }
        if (iPSAppDEMethod == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5[%2$s]", (Object)this.getFullName(), (Object)strMethodTag));
        }
        return iPSAppDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027", dumpref=true, from="__self__", group="\u6a21\u578b", order=151, doc="\u8ba1\u7b97\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u7684\u4e3b\u952e\u5c5e\u6027")
    public IPSAppDEField getKeyPSAppDEField() {
        return this.keyPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027", dumpref=true, from="__self__", group="\u6a21\u578b", order=152, doc="\u8ba1\u7b97\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u7684\u4e3b\u4fe1\u606f\u5c5e\u6027")
    public IPSAppDEField getMajorPSAppDEField() {
        return this.majorPSAppDEField;
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId) throws Exception {
        return this.getPSAppDEUIAction(strAppDEUIActionId, false);
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.getPSAppDEUIAction(strAppDEUIActionId, bTryMode);
        PSAppDataEntityImpl.registerRefPSModelObject(iPSAppDEUIAction, refPSModelObject);
        return iPSAppDEUIAction;
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction2(String strAppDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSAppDEUIAction)this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId, boolean bTryMode) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.psAppDEUIActionMap.get(strAppDEUIActionId);
        if (iPSAppDEUIAction != null) {
            return iPSAppDEUIAction;
        }
        iPSAppDEUIAction = (IPSAppDEUIAction)this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, true);
        if (iPSAppDEUIAction != null) {
            if (!this.bLoadPSAppDEUIActionGroupNow) {
                this.psAppDEUIActionMap.put(iPSAppDEUIAction.getId(), iPSAppDEUIAction);
            }
            return iPSAppDEUIAction;
        }
        iPSAppDEUIAction = !this.bLoadPSAppDEUIActionGroupNow ? this.getPSApplication().getPSAppDEUIAction(strAppDEUIActionId, true) : this.getPSApplication().getPSAppDEUIAction2(strAppDEUIActionId, true);
        if (iPSAppDEUIAction != null) {
            return iPSAppDEUIAction;
        }
        if (!bTryMode) {
            return (IPSAppDEUIAction)this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
        }
        return iPSAppDEUIAction;
    }

    @Override
    public void resetPSAppDEUIAction(String strAppDEUIActionId) throws Exception {
        this.psAppDEUIActionGlobalModel.ResetModel(strAppDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=252)
    public Iterator<IPSAppDEUIAction> getAllPSAppDEUIActions() throws Exception {
        this.psAppDEUIActionGlobalModel.getAllModelHelpers();
        return PSModelUtil.sort(this.psAppDEUIActionMap, IPSAppDEUIAction.class).iterator();
    }

    @Override
    public IPSAppDEUIAction registerPSAppDEUIAction(PSDEUIAction psDEUIAction) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.psAppDEUIActionMap.get(psDEUIAction.getPSDEUIACTIONID());
        if (iPSAppDEUIAction == null) {
            iPSAppDEUIAction = new PSDEUIActionImpl();
            iPSAppDEUIAction.init(this.getDAGlobalHelper(), this.getPSApplication(), this, psDEUIAction);
            this.psAppDEUIActionMap.put(iPSAppDEUIAction.getId(), iPSAppDEUIAction);
        }
        return iPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", child=true, ignorepf=true, group="\u754c\u9762\u903b\u8f91", order=253)
    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception {
        this.psAppDEUIActionGroupGlobalModel.getAllModelHelpers();
        return PSModelUtil.sort(this.psAppDEUIActionGroupMap, IPSAppDEUIActionGroup.class).iterator();
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId) throws Exception {
        return this.getPSAppDEUIActionGroup(strAppDEUIActionGroupId, false);
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
        IPSAppDEUIActionGroup iPSAppDEUIActionGroup = this.getPSAppDEUIActionGroup(strAppDEUIActionGroupId, bTryMode);
        PSAppDataEntityImpl.registerRefPSModelObject(iPSAppDEUIActionGroup, refPSModelObject);
        return iPSAppDEUIActionGroup;
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId, boolean bTryMode) throws Exception {
        IPSAppDEUIActionGroup iPSAppDEUIActionGroup = this.getPSApplication().getPSAppDEUIActionGroup(strAppDEUIActionGroupId, true);
        if (iPSAppDEUIActionGroup != null) {
            return iPSAppDEUIActionGroup;
        }
        iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)this.psAppDEUIActionGroupGlobalModel.FindModelHelper(strAppDEUIActionGroupId, bTryMode);
        if (iPSAppDEUIActionGroup != null && !this.bLoadPSAppDEUIActionGroupNow && !this.psAppDEUIActionGroupMap.containsKey(iPSAppDEUIActionGroup.getId())) {
            this.psAppDEUIActionGroupMap.put(iPSAppDEUIActionGroup.getId(), iPSAppDEUIActionGroup);
            Iterator<IPSDEUIAction> psDEUIActions = iPSAppDEUIActionGroup.getPSDEUIActions();
            if (psDEUIActions != null) {
                while (psDEUIActions.hasNext()) {
                    IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
                    this.getPSAppDEUIAction(iPSDEUIAction.getId());
                }
            }
        }
        return iPSAppDEUIActionGroup;
    }

    @Override
    public void resetPSAppDEUIActionGroup(String strAppDEUIActionGroupId) throws Exception {
        this.psAppDEUIActionGroupGlobalModel.ResetModel(strAppDEUIActionGroupId);
    }

    @Override
    public IPSAppDELogic getPSAppDELogic(String strAppDELogicId) throws Exception {
        return (IPSAppDELogic)this.psAppDELogicGlobalModel.FindModelHelper(strAppDELogicId, false);
    }

    @Override
    public IPSAppDELogic getPSAppDELogic(String strAppDELogicId, boolean bTryMode) throws Exception {
        return (IPSAppDELogic)this.psAppDELogicGlobalModel.FindModelHelper(strAppDELogicId, bTryMode);
    }

    @Override
    public void resetPSAppDELogic(String strAppDELogicId) throws Exception {
        this.psAppDELogicGlobalModel.ResetModel(strAppDELogicId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=197)
    public Iterator<IPSAppDELogic> getAllPSAppDELogics() throws Exception {
        return this.psAppDELogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic(String strAppDEUILogicId) throws Exception {
        return this.getPSAppDEUILogic(strAppDEUILogicId, false);
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic(String strAppDEUILogicId, boolean bTryMode) throws Exception {
        IPSAppDEUILogic iPSAppDEUILogic = this.psAppDEUILogicMap.get(strAppDEUILogicId);
        if (iPSAppDEUILogic != null) {
            return iPSAppDEUILogic;
        }
        iPSAppDEUILogic = (IPSAppDEUILogic)this.psAppDEUILogicGlobalModel.FindModelHelper(strAppDEUILogicId, bTryMode);
        if (iPSAppDEUILogic != null) {
            this.psAppDEUILogicMap.put(strAppDEUILogicId, iPSAppDEUILogic);
        }
        return iPSAppDEUILogic;
    }

    @Override
    public void resetPSAppDEUILogic(String strAppDEUILogicId) throws Exception {
        this.psAppDEUILogicGlobalModel.ResetModel(strAppDEUILogicId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=249)
    public Iterator<IPSAppDEUILogic> getAllPSAppDEUILogics() throws Exception {
        this.psAppDEUILogicGlobalModel.getAllModelHelpers();
        return PSModelUtil.sort(this.psAppDEUILogicMap, IPSAppDEUILogic.class).iterator();
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId) throws Exception {
        return this.getPSAppDEUILogicGroup(strAppDEUILogicGroupId, false);
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId, boolean bTryMode) throws Exception {
        IPSAppDEUILogicGroup iPSAppDEUILogicGroup = (IPSAppDEUILogicGroup)this.psAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, true);
        if (iPSAppDEUILogicGroup != null) {
            return iPSAppDEUILogicGroup;
        }
        iPSAppDEUILogicGroup = this.getPSApplication().getPSAppDEUILogicGroup(strAppDEUILogicGroupId, true);
        if (iPSAppDEUILogicGroup != null || bTryMode) {
            return iPSAppDEUILogicGroup;
        }
        return (IPSAppDEUILogicGroup)this.psAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, bTryMode);
    }

    @Override
    public void resetPSAppDEUILogicGroup(String strAppDEUILogicGroupId) throws Exception {
        this.psAppDEUILogicGroupGlobalModel.ResetModel(strAppDEUILogicGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u96c6\u5408", group="\u754c\u9762\u903b\u8f91", order=250)
    public Iterator<IPSAppDEUILogicGroup> getAllPSAppDEUILogicGroups() throws Exception {
        return this.psAppDEUILogicGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppDEACMode getPSAppDEACMode(String strAppDEACModeId) throws Exception {
        return this.getPSAppDEACMode(strAppDEACModeId, false);
    }

    @Override
    public IPSAppDEACMode getPSAppDEACMode(String strAppDEACModeId, boolean bTryMode) throws Exception {
        IPSAppDEACMode iPSAppDEACMode = this.psAppDEACModeMap.get(strAppDEACModeId);
        if (iPSAppDEACMode != null) {
            return iPSAppDEACMode;
        }
        IPSDEACMode iPSDEACMode = this.getPSDE().getPSDEACMode(strAppDEACModeId, bTryMode);
        if (iPSDEACMode == null) {
            return null;
        }
        PSDEACModeImpl psDEACModeImpl = new PSDEACModeImpl();
        PSDEACMode psDEACMode = new PSDEACMode();
        iPSDEACMode.getModelData().CopyTo((BaseDataEntity)psDEACMode, false);
        psDEACModeImpl.init(this.getDAGlobalHelper(), this, psDEACMode);
        this.psAppDEACModeMap.put(strAppDEACModeId, psDEACModeImpl);
        return psDEACModeImpl;
    }

    @Override
    public void resetPSAppDEACMode(String strAppDEACModeId) throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=245)
    public Iterator<IPSAppDEACMode> getAllPSAppDEACModes() throws Exception {
        return PSModelUtil.sort(this.psAppDEACModeMap, IPSAppDEACMode.class).iterator();
    }

    @Override
    public IPSAppDEAction getPSAppDEAction(String strPSDEActionId, boolean bTryMode) throws Exception {
        IPSDEAction iPSDEAction = this.getPSDataEntity().getPSDEAction(strPSDEActionId, bTryMode);
        if (iPSDEAction != null) {
            return this.getPSAppDEAction(iPSDEAction, bTryMode);
        }
        return null;
    }

    @Override
    public IPSAppDEAction getPSAppDEAction(IPSDEAction iPSDEAction, boolean bTryMode) throws Exception {
        IPSAppDEMethod iPSAppDEMethod = this.getPSAppDEMethod(iPSDEAction, bTryMode);
        if (iPSAppDEMethod instanceof IPSAppDEAction) {
            return (IPSAppDEAction)iPSAppDEMethod;
        }
        return null;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSet(String strPSDEDataSetId, boolean bTryMode) throws Exception {
        IPSDEDataSet iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(strPSDEDataSetId, bTryMode);
        if (iPSDEDataSet != null) {
            return this.getPSAppDEDataSet(iPSDEDataSet, bTryMode);
        }
        return null;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSet(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
        IPSAppDEMethod iPSAppDEMethod = this.getPSAppDEMethod(iPSDEDataSet, bTryMode);
        if (iPSAppDEMethod instanceof IPSAppDEDataSet) {
            return (IPSAppDEDataSet)iPSAppDEMethod;
        }
        return null;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSetTempMode(String strPSDEDataSetId, boolean bTryMode) throws Exception {
        IPSDEDataSet iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(strPSDEDataSetId, bTryMode);
        if (iPSDEDataSet != null) {
            return this.getPSAppDEDataSetTempMode(iPSDEDataSet, bTryMode);
        }
        return null;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSetTempMode(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
        IPSAppDEMethod objAppDEMethod;
        String strMethodTag = null;
        if (iPSDEDataSet != null) {
            strMethodTag = StringHelper.format((String)"%1$s|%2$s", (Object)"FETCHTEMP", (Object)iPSDEDataSet.getId());
        }
        if (StringHelper.isNullOrEmpty(strMethodTag)) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u8bc6\u522b\u7684\u76ee\u6807\u6570\u636e\u96c6\u5bf9\u8c61", (Object)this.getFullName()));
        }
        IPSAppDEDataSet iPSAppDEDataSet = null;
        if (this.psAppDEMethodMap != null && (objAppDEMethod = this.psAppDEMethodMap.get(strMethodTag)) instanceof IPSAppDEDataSet) {
            iPSAppDEDataSet = (IPSAppDEDataSet)objAppDEMethod;
        }
        if (iPSAppDEDataSet == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6[%2$s]", (Object)this.getFullName(), (Object)strMethodTag));
        }
        return iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="false", doc="\u8ba1\u7b97\u5b9e\u4f53\u662f\u5426\u652f\u6301\u524d\u7aef\u4e34\u65f6\u6570\u636e\u6a21\u5f0f{@link net.ibizsys.model.dataentity.IPSDataEntity#isEnableTempDataFront}")
    public boolean isEnableTempData() {
        return this.getPSDataEntity().isEnableTempDataFront();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u8fc7\u6ee4\u5668\u76f8\u5173\u884c\u4e3a")
    public boolean isEnableFilterActions() {
        return this.bEnableFilterActions;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u5de5\u4f5c\u6d41\u76f8\u5173\u884c\u4e3a")
    public boolean isEnableWFActions() {
        return this.bEnableWFActions && this.getPSAppWF() != null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5144\u5f1f\u5e94\u7528\u5b9e\u4f53\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppDataEntity> getSiblings() throws Exception {
        if (this.siblingList == null) {
            ArrayList<IPSAppDataEntity> siblingList = new ArrayList<IPSAppDataEntity>();
            Iterator<IPSAppDataEntity> psAppDataEntities = this.getPSApplication().getPSAppDataEntitiesByDEId(this.getPSDataEntity().getId());
            if (psAppDataEntities != null) {
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    if (StringHelper.compare((String)iPSAppDataEntity.getId(), (String)this.getId(), (boolean)false) == 0) continue;
                    siblingList.add(iPSAppDataEntity);
                }
            }
            if (this.siblingList == null) {
                this.siblingList = siblingList;
            }
        }
        if (this.siblingList.size() == 0) {
            return null;
        }
        return this.siblingList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u95e8\u6237\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception {
        if (this.psAppPortletList == null) {
            ArrayList<IPSAppPortlet> psAppPortletList = new ArrayList<IPSAppPortlet>();
            Iterator<IPSAppPortlet> psAppPortlets = this.getPSApplication().getAllPSAppPortlets();
            if (psAppPortlets != null) {
                while (psAppPortlets.hasNext()) {
                    IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                    if (!iPSAppPortlet.isEnableDEDashboard() || iPSAppPortlet.getPSAppDataEntity() == null || StringHelper.compare((String)iPSAppPortlet.getPSAppDataEntity().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psAppPortletList.add(iPSAppPortlet);
                }
                Collections.sort(psAppPortletList, new Comparator<IPSAppPortlet>(){

                    @Override
                    public int compare(IPSAppPortlet o1, IPSAppPortlet o2) {
                        return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                    }
                });
            }
            if (this.psAppPortletList == null) {
                this.psAppPortletList = psAppPortletList;
            }
        }
        if (this.psAppPortletList.size() == 0) {
            return null;
        }
        return this.psAppPortletList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception {
        if (this.psAppPortletCatList == null) {
            ArrayList<IPSAppPortletCat> psAppPortletCatList = new ArrayList<IPSAppPortletCat>();
            Iterator<IPSAppPortlet> psAppPortlets = this.getAllPSAppPortlets();
            if (psAppPortlets != null) {
                LinkedHashMap<String, IPSAppPortletCat> psAppPortletCatMap = new LinkedHashMap<String, IPSAppPortletCat>();
                while (psAppPortlets.hasNext()) {
                    IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                    if (iPSAppPortlet.getPSAppPortletCat() == null || psAppPortletCatMap.containsKey(iPSAppPortlet.getPSAppPortletCat().getId())) continue;
                    psAppPortletCatMap.put(iPSAppPortlet.getPSAppPortletCat().getId(), iPSAppPortlet.getPSAppPortletCat());
                    psAppPortletCatList.add(iPSAppPortlet.getPSAppPortletCat());
                }
                Collections.sort(psAppPortletCatList, new Comparator<IPSAppPortletCat>(){

                    @Override
                    public int compare(IPSAppPortletCat o1, IPSAppPortletCat o2) {
                        if (o1.isUngroup()) {
                            return 1;
                        }
                        return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                    }
                });
            }
            if (this.psAppPortletCatList == null) {
                this.psAppPortletCatList = psAppPortletCatList;
            }
        }
        if (this.psAppPortletCatList == null || this.psAppPortletCatList.size() == 0) {
            return null;
        }
        return this.psAppPortletCatList.iterator();
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.psAppLocalDE.getLINKPSDEVIEWID();
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.psAppLocalDE.getMDPSDEVIEWID();
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.psAppLocalDE.getSDPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, ignorepf=true, dynamodelmode=8, group="\u6a21\u578b", order=156)
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u5c5e\u6027\u96c6\u5408", child=true, dumpref=true, rtdump=1, outputdoc="false", doc="\u8ba1\u7b97\u5b9e\u4f53\u652f\u6301\u5feb\u901f\u641c\u7d22\u7684\u5c5e\u6027\u96c6\u5408")
    public Iterator<? extends IPSAppDEField> getQuickSearchPSAppDEFields() throws Exception {
        if (this.quickSearchPSAppDEFieldList == null) {
            ArrayList<IPSAppDEField> quickSearchPSAppDEFieldList = new ArrayList<IPSAppDEField>();
            Iterator<? extends IPSAppDEField> psAppDEFields = this.getAllPSAppDEFields();
            if (psAppDEFields != null) {
                while (psAppDEFields.hasNext()) {
                    IPSAppDEField iPSAppDEField = psAppDEFields.next();
                    if (!iPSAppDEField.isEnableQuickSearch()) continue;
                    quickSearchPSAppDEFieldList.add(iPSAppDEField);
                }
            }
            if (this.quickSearchPSAppDEFieldList == null) {
                this.quickSearchPSAppDEFieldList = quickSearchPSAppDEFieldList;
            }
        }
        if (this.quickSearchPSAppDEFieldList == null || this.quickSearchPSAppDEFieldList.size() == 0) {
            return null;
        }
        return this.quickSearchPSAppDEFieldList.iterator();
    }

    @Override
    public IPSAppDEPrint getPSAppDEPrint(String strAppDEPrintId) throws Exception {
        return (IPSAppDEPrint)this.psAppDEPrintGlobalModel.FindModelHelper(strAppDEPrintId, false);
    }

    @Override
    public IPSAppDEPrint getPSAppDEPrint(String strAppDEPrintId, boolean bTryMode) throws Exception {
        return (IPSAppDEPrint)this.psAppDEPrintGlobalModel.FindModelHelper(strAppDEPrintId, bTryMode);
    }

    @Override
    public void resetPSAppDEPrint(String strAppDEPrintId) throws Exception {
        this.psAppDEPrintGlobalModel.ResetModel(strAppDEPrintId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6253\u5370\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=199)
    public Iterator<IPSAppDEPrint> getAllPSAppDEPrints() throws Exception {
        return this.psAppDEPrintGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6253\u5370", dumpref=true, from="__self__")
    public IPSAppDEPrint getDefaultPSAppDEPrint() throws Exception {
        this.getAllPSAppDEPrints();
        return this.psAppDEPrintGlobalModel.getDefaultPSAppDEPrint();
    }

    @Override
    public IPSAppDEDataImport getPSAppDEDataImport(String strAppDEDataImportId) throws Exception {
        return (IPSAppDEDataImport)this.psAppDEDataImportGlobalModel.FindModelHelper(strAppDEDataImportId, false);
    }

    @Override
    public IPSAppDEDataImport getPSAppDEDataImport(String strAppDEDataImportId, boolean bTryMode) throws Exception {
        return (IPSAppDEDataImport)this.psAppDEDataImportGlobalModel.FindModelHelper(strAppDEDataImportId, bTryMode);
    }

    @Override
    public void resetPSAppDEDataImport(String strAppDEDataImportId) throws Exception {
        this.psAppDEDataImportGlobalModel.ResetModel(strAppDEDataImportId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=200)
    public Iterator<IPSAppDEDataImport> getAllPSAppDEDataImports() throws Exception {
        return this.psAppDEDataImportGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u5bfc\u5165", dumpref=true, from="__self__")
    public IPSAppDEDataImport getDefaultPSAppDEDataImport() throws Exception {
        this.getAllPSAppDEDataImports();
        return this.psAppDEDataImportGlobalModel.getDefaultPSAppDEDataImport();
    }

    @Override
    public IPSAppDEDataExport getPSAppDEDataExport(String strAppDEDataExportId) throws Exception {
        return (IPSAppDEDataExport)this.psAppDEDataExportGlobalModel.FindModelHelper(strAppDEDataExportId, false);
    }

    @Override
    public IPSAppDEDataExport getPSAppDEDataExport(String strAppDEDataExportId, boolean bTryMode) throws Exception {
        return (IPSAppDEDataExport)this.psAppDEDataExportGlobalModel.FindModelHelper(strAppDEDataExportId, bTryMode);
    }

    @Override
    public void resetPSAppDEDataExport(String strAppDEDataExportId) throws Exception {
        this.psAppDEDataExportGlobalModel.ResetModel(strAppDEDataExportId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=201)
    public Iterator<IPSAppDEDataExport> getAllPSAppDEDataExports() throws Exception {
        return this.psAppDEDataExportGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u5bfc\u5165", dumpref=true, from="__self__")
    public IPSAppDEDataExport getDefaultPSAppDEDataExport() throws Exception {
        this.getAllPSAppDEDataExports();
        return this.psAppDEDataExportGlobalModel.getDefaultPSAppDEDataExport();
    }

    @Override
    protected String getPSPFPubObjTarget() {
        return "PSAPPDATAENTITY";
    }

    @Override
    protected String getPSSFPubObjTarget() {
        return "PSAPPDATAENTITY";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u96c6\u5408", group="\u6a21\u578b", order=170)
    public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception {
        if (this.psAppCodeListList == null) {
            ArrayList<IPSAppCodeList> psAppCodeListList = new ArrayList<IPSAppCodeList>();
            Iterator<IPSAppCodeList> psAppCodeLists = this.getPSApplication().getAllPSAppCodeLists();
            if (psAppCodeLists != null) {
                while (psAppCodeLists.hasNext()) {
                    IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
                    if (iPSAppCodeList.getPSDataEntity() == null || StringHelper.compare((String)iPSAppCodeList.getPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) continue;
                    psAppCodeListList.add(iPSAppCodeList);
                }
            }
            if (this.psAppCodeListList == null) {
                this.psAppCodeListList = psAppCodeListList;
            }
        }
        if (this.psAppCodeListList == null || this.psAppCodeListList.size() == 0) {
            return null;
        }
        return this.psAppCodeListList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u652f\u6301\u754c\u9762\u884c\u4e3a", codelist="DEUserUIAbility2")
    public int getEnableUIActions() {
        return this.nEnableUIActions;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u5efa\u7acb", ignorert=3)
    public boolean isEnableUICreate() {
        return (this.getEnableUIActions() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u4fee\u6539", ignorert=3)
    public boolean isEnableUIModify() {
        return (this.getEnableUIActions() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u5220\u9664", ignorert=3)
    public boolean isEnableUIRemove() {
        return (this.getEnableUIActions() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90")
    public IPSSysImage getPSSysImage() {
        return this.getPSDataEntity().getPSSysImage();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.getPSDataEntity().getDynaInstMode();
    }

    @Override
    protected String onGetDynaInstTag() {
        return this.getPSDataEntity().getDynaInstTag();
    }

    @Override
    protected String onGetDynaInstTag2() {
        return this.getPSDataEntity().getDynaInstTag2();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getCodeName();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (!objectNode.has("getPSDataEntity")) {
            objectNode.put("getPSDataEntity", (JsonNode)this.getPSDataEntity().getModelRef());
        }
        if (objectNode.has("getAllPSAppDEUIActionGroups")) {
            objectNode.remove("getAllPSAppDEUIActionGroups");
        }
        if (!objectNode.has("getAllPSAppDEUIActionGroups")) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppDEUIActionGroups");
            Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = this.getAllPSAppDEUIActionGroups();
            if (psAppDEUIActionGroups != null) {
                while (psAppDEUIActionGroups.hasNext()) {
                    arrayNode.add((JsonNode)psAppDEUIActionGroups.next().toModel("APPDATAENTITY"));
                }
            }
            if (arrayNode.size() == 0) {
                objectNode.remove("getAllPSAppDEUIActionGroups");
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5757", ignorepf=true, dumpref=true, dynamodelmode=8, from="IPSApplication")
    public IPSAppModule getPSAppModule() throws Exception {
        if (this.iPSAppModule == null && !StringHelper.isNullOrEmpty((String)this.getPSAppModuleId())) {
            this.iPSAppModule = this.getPSApplication().getPSAppModule(this.getPSAppModuleId());
        }
        return this.iPSAppModule;
    }

    @Override
    public String getPSAppModuleId() {
        return this.psAppLocalDE.getPSAPPMODULEID();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception {
        return this.getPSDataEntity().getAllPSDEMainStates();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
        return this.getPSDataEntity().getAllPSDEOPPrivs();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u540d\u79f0", outputdoc="false", ignorert=2)
    public String getPSDEName() {
        return this.getPSDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u96c6\u5408", child=true, dynamodelmode=4, group="\u5904\u7406\u903b\u8f91", order=208)
    public Iterator<IPSAppDEMethodDTO> getAllPSAppDEMethodDTOs() throws Exception {
        if (this.psAppDEMethodDTOMap == null || this.psAppDEMethodDTOMap.size() == 0) {
            return null;
        }
        return this.psAppDEMethodDTOMap.values().iterator();
    }

    @Override
    public IPSAppDEMethodDTO getPSAppDEMethodDTO(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        for (Map.Entry<String, IPSAppDEMethodDTO> entry : this.psAppDEMethodDTOMap.entrySet()) {
            IPSAppDEMethodDTO iPSAppDEMethodDTO = entry.getValue();
            if (iPSAppDEMethodDTO.getPSDEMethodDTO() == null || StringHelper.compare((String)iPSAppDEMethodDTO.getPSDEMethodDTO().getId(), (String)iPSDEMethodDTO.getId(), (boolean)false) != 0) continue;
            return iPSAppDEMethodDTO;
        }
        PSAppDEMethodDTOImpl psAppDEMethodDTOImpl = new PSAppDEMethodDTOImpl();
        psAppDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodDTO);
        if (this.psAppDEMethodDTOMap.containsKey(psAppDEMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5e94\u7528\u5b9e\u4f53\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psAppDEMethodDTOImpl.getCodeName()));
        }
        this.psAppDEMethodDTOMap.put(psAppDEMethodDTOImpl.getCodeName(), psAppDEMethodDTOImpl);
        return psAppDEMethodDTOImpl;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true)
    public IPSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.iPSSysSFPlugin == null) {
            if (!StringHelper.isNullOrEmpty((String)this.psAppLocalDE.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psAppLocalDE.getPSSYSSFPLUGINID());
            } else if (!StringHelper.isNullOrEmpty((String)this.getPSApplication().getDEPSSysSFPluginId())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.getPSApplication().getDEPSSysSFPluginId());
            }
        }
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6807\u8bb0", hideempty=true)
    public String getSysAPITag() {
        if (this.getPSSysServiceAPI() != null) {
            return this.getPSSysServiceAPI().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", dump=false)
    public String getAPICodeNameMode() {
        if (this.getPSSysServiceAPI() != null) {
            return this.getPSSysServiceAPI().getAPICodeNameMode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6807\u8bb0", hideempty=true)
    public String getDEAPITag() {
        if (this.getPSDEServiceAPI() != null) {
            return this.getPSDEServiceAPI().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4ee3\u7801\u6807\u8bc6", hideempty=true)
    public String getDEAPICodeName() {
        String strCodeName;
        if (this.getPSDEServiceAPI() != null && !StringHelper.isNullOrEmpty((String)(strCodeName = this.getPSDEServiceAPI().getCodeName()))) {
            if (StringHelper.isNullOrEmpty((String)this.getAPICodeNameMode()) || "NONE".equals(this.getAPICodeNameMode())) {
                strCodeName = strCodeName.toLowerCase();
            }
            return strCodeName;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4ee3\u7801\u6807\u8bc62\uff08\u590d\u6570\uff09", hideempty=true)
    public String getDEAPICodeName2() {
        String strCodeName;
        if (this.getPSDEServiceAPI() != null && !StringHelper.isNullOrEmpty((String)(strCodeName = this.getPSDEServiceAPI().getCodeName2()))) {
            if (StringHelper.isNullOrEmpty((String)this.getAPICodeNameMode()) || "NONE".equals(this.getAPICodeNameMode())) {
                strCodeName = strCodeName.toLowerCase();
            }
            return strCodeName;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u6027\u96c6\u5408", hideempty=true, child=true, dumpref=true, rtdump=1, from="__self__", dynamodelmode=4, outputdoc="false")
    public Iterator<IPSAppDEField> getMainStatePSAppDEFields() throws Exception {
        Iterator<IPSDEField> mainStatePSDEFields = this.getPSDataEntity().getMainStatePSDEFields();
        if (mainStatePSDEFields == null) {
            return null;
        }
        ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<IPSAppDEField>();
        while (mainStatePSDEFields.hasNext()) {
            IPSAppDEField iPSAppDEField = this.getPSAppDEField(mainStatePSDEFields.next(), true);
            if (iPSAppDEField == null) {
                return null;
            }
            psAppDEFieldList.add(iPSAppDEField);
        }
        if (psAppDEFieldList.size() == 0) {
            return null;
        }
        return psAppDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u4e3b\u72b6\u6001", ignoredumpvalues="false", doc="\u8ba1\u7b97\u5f53\u524d\u5b9e\u4f53\u662f\u5426\u5b58\u5728\u4e3b\u72b6\u6001\u63a7\u5236\u5c5e\u6027")
    public boolean isEnableDEMainState() {
        try {
            return this.getMainStatePSAppDEFields() != null;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", hideempty2=true)
    public String getDynaInstTag() {
        return super.getDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u7c7b\u578b\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__")
    public IPSAppDEField getFormTypePSAppDEField() throws Exception {
        IPSDEField iPSDEField = this.getPSDataEntity().getFormTypePSDEField();
        if (iPSDEField != null) {
            return this.getPSAppDEField(iPSDEField, true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__")
    public IPSAppDEField getDataTypePSAppDEField() throws Exception {
        IPSDEField iPSDEField = this.getPSDataEntity().getDataTypePSDEField();
        if (iPSDEField != null) {
            return this.getPSAppDEField(iPSDEField, true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__")
    public IPSAppDEField getIndexTypePSAppDEField() throws Exception {
        IPSDEField iPSDEField = this.getPSDataEntity().getIndexTypePSDEField();
        if (iPSDEField != null) {
            return this.getPSAppDEField(iPSDEField, true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u7ec7\u6807\u8bc6\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__")
    public IPSAppDEField getOrgIdPSAppDEField() throws Exception {
        IPSDEField iPSDEField = this.getPSDataEntity().getOrgIdPSDEField();
        if (iPSDEField != null) {
            return this.getPSAppDEField(iPSDEField, true);
        }
        return null;
    }

    @Override
    public IPSAppDEReport getPSAppDEReport(String strAppDEReportId) throws Exception {
        return (IPSAppDEReport)this.psAppDEReportGlobalModel.FindModelHelper(strAppDEReportId, false);
    }

    @Override
    public IPSAppDEReport getPSAppDEReport(String strAppDEReportId, boolean bTryMode) throws Exception {
        return (IPSAppDEReport)this.psAppDEReportGlobalModel.FindModelHelper(strAppDEReportId, bTryMode);
    }

    @Override
    public void resetPSAppDEReport(String strAppDEReportId) throws Exception {
        this.psAppDEReportGlobalModel.ResetModel(strAppDEReportId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6253\u5370\u96c6\u5408", group="\u5904\u7406\u903b\u8f91", order=199)
    public Iterator<IPSAppDEReport> getAllPSAppDEReports() throws Exception {
        return this.psAppDEReportGlobalModel.getAllModelHelpers();
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!StringHelper.isNullOrEmpty((String)strModelRefType)) {
            if ("DATAENTITY".equals(strModelRefType)) {
                objectNode.put("app", this.getPSApplication().getCodeName());
            }
            if ("APPLICATION".equals(strModelRefType)) {
                objectNode.put("name", this.getName());
                objectNode.put("codeName", this.getCodeName());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84\u96c6\u5408", child=true)
    public String[] getRequestPaths() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u5c5e\u6027\u96c6\u5408", hideempty=true, child=true, dumpref=true, rtdump=1, from="__self__", dynamodelmode=4, outputdoc="false")
    public Iterator<IPSAppDEField> getUnionKeyValuePSAppDEFields() throws Exception {
        Iterator<IPSDEField> unionKeyValuePSDEFields = this.getPSDataEntity().getUnionKeyValuePSDEFields();
        if (unionKeyValuePSDEFields == null) {
            return null;
        }
        ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<IPSAppDEField>();
        while (unionKeyValuePSDEFields.hasNext()) {
            IPSAppDEField iPSAppDEField = this.getPSAppDEField(unionKeyValuePSDEFields.next(), true);
            if (iPSAppDEField == null) {
                return null;
            }
            psAppDEFieldList.add(iPSAppDEField);
        }
        if (psAppDEFieldList.size() == 0) {
            return null;
        }
        return psAppDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DEDynaSysMode", ignoredumpvalues="0")
    public int getDynaSysMode() {
        return this.getPSDataEntity().getDynaSysMode();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bc6")
    public String getDEName() {
        if (!this.getPSDataEntity().getName().equals(this.getName())) {
            return this.getPSDataEntity().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc6")
    public String getDECodeName() {
        if (!this.getPSDataEntity().getCodeName().equals(this.getCodeName())) {
            return this.getPSDataEntity().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5b8c\u5168\u6807\u8bc6")
    public String getDEFullTag() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6620\u5c04\u96c6\u5408", child=true, group="\u5904\u7406\u903b\u8f91", order=200)
    public Iterator<IPSAppDEMap> getAllPSAppDEMaps() throws Exception {
        return this.psAppDEMapGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u9ed8\u8ba4\u7edf\u4e00\u8d44\u6e90", dump=false, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }
}

