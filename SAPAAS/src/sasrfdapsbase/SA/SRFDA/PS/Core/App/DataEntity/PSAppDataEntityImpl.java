package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.PSDEACModeImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
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
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDataEntityImpl extends PSApplicationObjectImpl implements IPSAppDataEntity, IPSAppDataEntityRuntime {
   private static final Log log = LogFactory.getLog(PSAppDataEntityImpl.class);
   private static Map<String, String> FilterActions = new LinkedHashMap<>();
   private static Map<String, String> WFActions = new LinkedHashMap<>();
   public static final String MODELGROUP_MODEL = "模型";
   public static final String MODELGROUP_LOGIC = "处理逻辑";
   public static final String MODELGROUP_UILOGIC = "界面逻辑";
   public static final String MODELGROUP_UI = "界面&组件";
   public static final String MODELGROUP_ACCCTRL = "访问控制";
   public static final String MODELGROUP_TEST = "测试";
   public static final String[] MODELGROUPS = new String[]{"基本", "模型", "处理逻辑", "界面逻辑", "界面&组件", "访问控制", "测试", "用户扩展", "其它"};
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
   private Map<String, IPSAppDEUIAction> psAppDEUIActionMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppDEUIActionGroup> psAppDEUIActionGroupMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppDEUILogic> psAppDEUILogicMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppDEACMode> psAppDEACModeMap = new ConcurrentHashMap<>();
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
   private Map<String, IPSAppDEMethodDTO> psAppDEMethodDTOMap = new TreeMap<>();

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
         if (StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSDEID())) {
            throw new Exception(StringHelper.format("没有指定相关实体"));
         }

         this.iPSDataEntity = this.getPSApplication().getPSSystem().getPSDataEntity2(this.psAppLocalDE.getPSDEID());
         if (this.psAppLocalDE.isDEFAULTFLAGNull()) {
            this.bDefaultMode = StringHelper.compare(
                  psAppLocalDE.getPSAPPLOCALDEID(), KeyValueHelper.genUniqueId(psAppLocalDE.getPSSYSAPPID(), psAppLocalDE.getPSDEID()), false
               )
               == 0;
         } else {
            this.bDefaultMode = this.psAppLocalDE.getDEFAULTFLAG();
         }

         if (!this.psAppLocalDE.isENABLESTORAGENull()) {
            this.nStorageMode = this.psAppLocalDE.GetParamIntValue("ENABLESTORAGE", this.nStorageMode);
         }

         if (this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_LOCALONLY
            && this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_DTOONLY
            && this.getPSApplication().isUseServiceApi()
            && this.getPSApplication().getPSSysServiceAPI() != null) {
            if (StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSDESERVICEAPIID())) {
               this.iPSDEServiceAPI = this.getPSApplication().getPSSysServiceAPI().getPSDEServiceAPI(this.getPSDataEntity().getId(), true);
            } else if (!StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSSYSSERVICEAPIID())) {
               this.iPSSysServiceAPI = this.getPSApplication().getPSSystem().getPSSysServiceAPI(this.psAppLocalDE.getPSSYSSERVICEAPIID());
               this.iPSDEServiceAPI = this.iPSSysServiceAPI.getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID());
            } else {
               this.iPSDEServiceAPI = this.getPSApplication().getPSSysServiceAPI().getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID(), true);
               if (this.iPSDEServiceAPI == null) {
                  Iterator<IPSSysServiceAPI> psSysServiceAPIs = this.getPSApplication().getPSSystem().getAllPSSysServiceAPIs();
                  if (psSysServiceAPIs != null) {
                     while (psSysServiceAPIs.hasNext()) {
                        IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
                        this.iPSDEServiceAPI = iPSSysServiceAPI.getPSDEServiceAPI(this.psAppLocalDE.getPSDESERVICEAPIID(), true);
                        if (this.iPSDEServiceAPI != null) {
                           break;
                        }
                     }
                  }
               }
            }

            if (this.getPSDEServiceAPI() == null) {
               throw new Exception(
                  StringHelper.format("系统服务接口[%1$s]不存在指定实体服务接口[%2$s]", this.getPSApplication().getPSSysServiceAPI().getName(), this.getPSDataEntity().getName())
               );
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
         if (StringHelper.isNullOrEmpty(this.strCodeName)) {
            if (this.getPSDEServiceAPI() != null) {
               this.strCodeName = this.getPSDEServiceAPI().getCodeName();
            }

            if (StringHelper.isNullOrEmpty(this.strCodeName) && this.isMajor() && this.getPSDataEntity() != null) {
               this.strCodeName = this.getPSDataEntity().getCodeName();
            }
         }

         if (StringHelper.isNullOrEmpty(this.getCodeName())) {
            String strHeader = this.getName().substring(0, 1).toUpperCase();
            this.strCodeName = strHeader + this.getName().substring(1);
         }

         if (!this.psAppLocalDE.isDATAACCMODENull()) {
            this.nDataAccCtrlMode = this.psAppLocalDE.getDATAACCMODE();
         } else if (this.getPSDEServiceAPI() != null) {
            this.nDataAccCtrlMode = this.getPSDEServiceAPI().getDataAccCtrlMode();
         } else {
            this.nDataAccCtrlMode = this.getPSDataEntity().getDataAccCtrlMode();
         }

         if (!this.psAppLocalDE.isACCCTRLARCHNull()) {
            this.nDataAccCtrlArch = this.psAppLocalDE.getACCCTRLARCH();
         } else if (this.getPSDEServiceAPI() != null) {
            this.nDataAccCtrlArch = this.getPSDEServiceAPI().getDataAccCtrlArch();
         } else {
            this.nDataAccCtrlArch = this.getPSDataEntity().getDataAccCtrlArch();
         }

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

         if (!StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSDERID())) {
            IPSDERBase iPSDERBase = this.getPSApplication().getPSSystem().getPSDER(this.psAppLocalDE.getPSDERID());
            if (!(iPSDERBase instanceof IPSDER1N)) {
               throw new Exception(StringHelper.format("实体关系[%1$s]不是1:N关系", iPSDERBase.getName()));
            }

            this.iPSDER1N = (IPSDER1N)iPSDERBase;
         }

         if ((this.getPSDEServiceAPI() != null || this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_NOLOCAL)
            && !StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSDEFGROUPID())) {
            this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psAppLocalDE.getPSDEFGROUPID());
            this.strDEFGroupMode = this.psAppLocalDE.getDEFGROUPMODE();
            if (StringHelper.isNullOrEmpty(this.strDEFGroupMode)) {
               this.strDEFGroupMode = "REPLACE";
            }
         }

         if (!StringHelper.isNullOrEmpty(psAppLocalDE.getLNPSLANRESID())) {
            this.lnPSLanguageRes = this.getPSApplication().getPSLanguageRes(psAppLocalDE.getLNPSLANRESID());
         } else if (this.getPSDEServiceAPI() != null) {
            this.lnPSLanguageRes = this.getPSDEServiceAPI().getLNPSLanguageRes();
         } else {
            this.lnPSLanguageRes = this.getPSDataEntity().getLNPSLanguageRes();
         }

         if (this.getLNPSLanguageRes() != null) {
            this.getPSApplication().getPSLanguageRes(this.getLNPSLanguageRes().getId());
         }

         if (!StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSSYSUNIRESID())) {
            this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psAppLocalDE.getPSSYSUNIRESID());
         } else {
            this.iPSSysUniRes = this.getPSDataEntity().getPSSysUniRes();
         }

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
      } catch (Exception ex) {
         String strLogName = StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
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
         List<IPSAppDEUILogic> list = new ArrayList<>();

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

      Iterator<? extends IPSAppDEUIAction> psAppDEUIActions = this.getAllPSAppDEUIActions();
      if (psAppDEUIActions != null) {
         List<IPSAppDEUIAction> list = new ArrayList<>();

         while (psAppDEUIActions.hasNext()) {
            list.add(psAppDEUIActions.next());
         }

         for (IPSAppDEUIAction iPSAppDEUIAction : list) {
            iPSAppDEUIAction.check();
         }
      }

      Iterator<? extends IPSAppDEACMode> psAppDEACModes = this.getAllPSAppDEACModes();
      if (psAppDEACModes != null) {
         List<IPSAppDEACMode> list = new ArrayList<>();

         while (psAppDEACModes.hasNext()) {
            list.add(psAppDEACModes.next());
         }

         for (IPSAppDEACMode iPSAppDEACMode : list) {
            iPSAppDEACMode.check();
         }
      }

      Iterator<? extends IPSAppDEMap> psAppDEMaps = this.getAllPSAppDEMaps();
      if (psAppDEMaps != null) {
         List<IPSAppDEMap> list = new ArrayList<>();

         while (psAppDEMaps.hasNext()) {
            list.add(psAppDEMaps.next());
         }

         for (IPSAppDEMap iPSAppDEMap : list) {
            iPSAppDEMap.check();
         }
      }

      Map<String, IPSAppDEMethodDTO> psAppDEMethodDTOMap = new HashMap<>();

      boolean bLoop;
      do {
         List<IPSAppDEMethodDTO> list = new ArrayList<>();
         Iterator<IPSAppDEMethodDTO> psAppDEMethodDTOs = this.getAllPSAppDEMethodDTOs();
         if (psAppDEMethodDTOs != null) {
            while (psAppDEMethodDTOs.hasNext()) {
               IPSAppDEMethodDTO iPSAppDEMethodDTO = psAppDEMethodDTOs.next();
               list.add(iPSAppDEMethodDTO);
            }
         }

         bLoop = false;

         for (IPSAppDEMethodDTO iPSAppDEMethodDTO : list) {
            if (!psAppDEMethodDTOMap.containsKey(iPSAppDEMethodDTO.getCodeName())) {
               iPSAppDEMethodDTO.check();
               psAppDEMethodDTOMap.put(iPSAppDEMethodDTO.getCodeName(), iPSAppDEMethodDTO);
               bLoop = true;
            }
         }
      } while (bLoop);
   }

   @Override
   public IPSDataEntity getPSDE() {
      return this.iPSDataEntity;
   }

   @PSModelRTMeta(description = "实体对象", dumpref = true, ignorepf = true, group = "模型", order = 155, fields = "PSDEID")
   @Override
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
         this.psControlList = new ArrayList<>();
      }

      this.psControlList.add(iPSControl);
   }

   @Override
   public Iterator<IPSControl> getPSControls() throws Exception {
      return this.psControlList != null && this.psControlList.size() != 0 ? this.psControlList.iterator() : null;
   }

   @PSModelRTMeta(description = "部件集合", outputdoc = "false")
   @Override
   public Iterator<IPSControl> getAllPSControls() throws Exception {
      return this.getPSControls();
   }

   @PSModelRTMeta(description = "部件集合（引用视图）", outputdoc = "false")
   @Override
   public Iterator<IPSControl> getAllRefPSControls() throws Exception {
      if (this.refPSControlList != null) {
         return this.refPSControlList.size() == 0 ? null : this.refPSControlList.iterator();
      }

      synchronized (this) {
         ArrayList<IPSControl> psControlList = new ArrayList<>();
         Iterator<IPSControl> psControls = this.getAllPSControls();
         if (psControls != null) {
            while (psControls.hasNext()) {
               IPSControl iPSControl = psControls.next();
               if (iPSControl.getPSAppView().getRefFlag()) {
                  psControlList.add(iPSControl);
               }
            }
         }

         if (this.refPSControlList == null) {
            this.refPSControlList = psControlList;
         }
      }

      return this.refPSControlList.size() == 0 ? null : this.refPSControlList.iterator();
   }

   @Override
   public void registerRefPSDEDataSet(IPSDEDataSet iPSDEDataSet, Object refObject) throws Exception {
      if (this.refPSDEDataSetMap == null) {
         this.refPSDEDataSetMap = new LinkedHashMap<>();
      }

      this.refPSDEDataSetMap.put(iPSDEDataSet.getId(), iPSDEDataSet);
   }

   @PSModelRTMeta(description = "引用实体结果集合", outputdoc = "false")
   @Override
   public Iterator<IPSDEDataSet> getRefPSDEDataSets() throws Exception {
      return this.refPSDEDataSetMap != null && this.refPSDEDataSetMap.size() != 0 ? this.refPSDEDataSetMap.values().iterator() : null;
   }

   @Override
   public void registerRefPSAppView(IPSAppView iPSAppView, Object refObject) throws Exception {
      if (this.refPSAppViewMap == null) {
         this.refPSAppViewMap = new LinkedHashMap<>();
      }

      this.refPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
   }

   @PSModelRTMeta(description = "引用视图集合", outputdoc = "false")
   @Override
   public Iterator<IPSAppView> getRefPSAppViews() throws Exception {
      if (!this.bPrepareRefPSAppView) {
         if (this.psControlList != null) {
            for (IPSControl iPSControl : this.psControlList) {
               ArrayList<IPSAppView> relatedAppViewList = new ArrayList<>();
               iPSControl.fillRelatedPSAppViews(relatedAppViewList);

               for (IPSAppView iPSAppView : relatedAppViewList) {
                  this.registerRefPSAppView(iPSAppView, iPSControl);
               }
            }
         }

         this.bPrepareRefPSAppView = true;
      }

      return this.refPSAppViewMap != null && this.refPSAppViewMap.size() != 0 ? this.refPSAppViewMap.values().iterator() : null;
   }

   @Override
   public String getModelType() {
      return "PSAPPDATAENTITY";
   }

   @Override
   public String getFullModelName() {
      return StringHelper.format("%1$s|%2$s", this.getPSApplication().getFullModelName(), this.getModelName());
   }

   @PSModelRTMeta(description = "全部自动填充模式", outputdoc = "false")
   @Override
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

   @PSModelRTMeta(description = "全部应用视图", child = true, dumpref = true, ignorepf = true, ignorert = 1, dynamodelmode = 8, group = "界面&组件", order = 295)
   @Override
   public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
      if (this.allPSAppViewList == null) {
         ArrayList<IPSAppView> psAppDEViewList = new ArrayList<>();
         Iterator<IPSAppView> psAppViews = this.getPSApplication().getAllPSAppViews();
         if (psAppViews != null) {
            while (psAppViews.hasNext()) {
               IPSAppView iPSAppView = psAppViews.next();
               if (iPSAppView.getPSAppDataEntity() != null && StringHelper.compare(iPSAppView.getPSAppDataEntity().getId(), this.getId(), false) == 0) {
                  psAppDEViewList.add(iPSAppView);
               }
            }
         }

         this.allPSAppViewList = psAppDEViewList;
      }

      return this.allPSAppViewList != null && this.allPSAppViewList.size() != 0 ? this.allPSAppViewList.iterator() : null;
   }

   @PSModelRTMeta(description = "实体访问控制体系", codelist = "AccCtrlArch", fields = "ACCCTRLARCH")
   @Override
   public int getDataAccCtrlArch() {
      return this.nDataAccCtrlArch;
   }

   @PSModelRTMeta(description = "实体数据访问控制方式", codelist = "DEDataAccCtrlMode", fields = "DATAACCMODE")
   @Override
   public int getDataAccCtrlMode() {
      return this.nDataAccCtrlMode;
   }

   @PSModelRTMeta(description = "主实体", fields = "MAJORFLAG")
   @Override
   public boolean isMajor() {
      return this.bMajor;
   }

   @PSModelRTMeta(description = "逻辑名称", fields = "LOGICNAME")
   @Override
   public String getLogicName() {
      String strLogicName = this.psAppLocalDE.getLOGICNAME();
      if (StringHelper.isNullOrEmpty(strLogicName)) {
         return this.getPSDEServiceAPI() != null ? this.getPSDEServiceAPI().getLogicName() : this.getPSDE().getLogicName();
      } else {
         return strLogicName;
      }
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
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

   @PSModelRTMeta(description = "控制实体关系", child = true, ignorert = 3)
   @Override
   public IPSDER1N getPSDER1N() {
      return this.iPSDER1N;
   }

   @PSModelRTMeta(description = "实体默认", fields = "DEFAULTFLAG")
   @Override
   public boolean isDefaultMode() {
      return this.bDefaultMode;
   }

   @PSModelRTMeta(description = "代码名称2", hideempty2 = true)
   @Override
   public String getCodeName2() {
      return this.onGetCodeName2();
   }

   protected String onGetCodeName2() {
      return this.psAppLocalDE.getCODENAME2();
   }

   @PSModelRTMeta(
      description = "实体服务接口",
      hideempty = true,
      dumpref = true,
      ignorepf = true,
      from = "__self__",
      from_method = "getPSSysServiceAPIMust().getPSDEServiceAPI",
      group = "模型",
      order = 158,
      fields = "PSDESERVICEAPIID"
   )
   @Override
   public IPSDEServiceAPI getPSDEServiceAPI() {
      return this.iPSDEServiceAPI;
   }

   @PSModelRTMeta(description = "应用实体方法集合", child = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDEMethod> getAllPSAppDEMethods() {
      return this.allPSAppDEMethodList != null && this.allPSAppDEMethodList.size() != 0 ? this.allPSAppDEMethodList.iterator() : null;
   }

   @PSModelRTMeta(description = "应用实体行为集合", child = true, ignorert = 3, group = "处理逻辑", order = 195)
   @Override
   public Iterator<IPSAppDEAction> getAllPSAppDEActions() {
      Iterator<? extends IPSAppDEMethod> psAppDEMethods = this.getAllPSAppDEMethods();
      if (psAppDEMethods == null) {
         return null;
      }

      List<IPSAppDEAction> list = new ArrayList<>();

      while (psAppDEMethods.hasNext()) {
         IPSAppDEMethod iPSAppDEMethod = psAppDEMethods.next();
         if ("DEACTION".equals(iPSAppDEMethod.getMethodType())) {
            list.add((IPSAppDEAction)iPSAppDEMethod);
         }
      }

      return list != null && list.size() != 0 ? list.iterator() : null;
   }

   @PSModelRTMeta(description = "应用实体数据集集合", child = true, ignorert = 3, group = "处理逻辑", order = 198)
   @Override
   public Iterator<IPSAppDEDataSet> getAllPSAppDEDataSets() {
      Iterator<? extends IPSAppDEMethod> psAppDEMethods = this.getAllPSAppDEMethods();
      if (psAppDEMethods == null) {
         return null;
      }

      List<IPSAppDEDataSet> list = new ArrayList<>();

      while (psAppDEMethods.hasNext()) {
         IPSAppDEMethod iPSAppDEMethod = psAppDEMethods.next();
         if ("FETCH".equals(iPSAppDEMethod.getMethodType())) {
            list.add((IPSAppDEDataSet)iPSAppDEMethod);
         }
      }

      return list != null && list.size() != 0 ? list.iterator() : null;
   }

   protected void onPreparePSAppWF() throws Exception {
      IPSDEWF iPSDEWF = this.getPSDataEntity().getDefaultPSDEWF();
      if (iPSDEWF != null && (iPSDEWF.getWFProxyMode() == 0 || (iPSDEWF.getWFProxyMode() & 2) == 2)) {
         this.iPSAppWF = this.getPSApplication().getPSAppWF(iPSDEWF.getPSWorkflow().getId(), true);
         if (this.iPSAppWF != null) {
            return;
         }
      }

      Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
      if (psDEWFs != null) {
         while (psDEWFs.hasNext()) {
            iPSDEWF = psDEWFs.next();
            if (iPSDEWF.getWFProxyMode() == 0 || (iPSDEWF.getWFProxyMode() & 2) == 2) {
               this.iPSAppWF = this.getPSApplication().getPSAppWF(iPSDEWF.getPSWorkflow().getId(), true);
               if (this.iPSAppWF != null) {
                  break;
               }
            }
         }
      }
   }

   protected void onPreparePSAppDEFields() throws Exception {
      if (this.getPSDEServiceAPI() != null || this.getStorageMode() != IPSAppDataEntity.STORAGEMODE_NOLOCAL) {
         if (this.psAppDEFieldList == null) {
            this.psAppDEFieldList = new ArrayList<>();
         } else {
            this.psAppDEFieldList.clear();
         }

         if (this.psAppDEFieldMap == null) {
            this.psAppDEFieldMap = new LinkedHashMap<>();
         } else {
            this.psAppDEFieldMap.clear();
         }

         if (this.getPSDEFGroup() != null) {
            Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
            if (psDEFGroupDetails != null) {
               if (StringHelper.compare(this.getDEFGroupMode(), "REPLACE", true) == 0) {
                  while (psDEFGroupDetails.hasNext()) {
                     IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                     PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                     psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                     this.psAppDEFieldList.add(psAppDEFieldImpl);
                  }
               } else {
                  Map<String, IPSDEFGroupDetail> psDEFGroupDetailMap = new LinkedHashMap<>();

                  while (psDEFGroupDetails.hasNext()) {
                     IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                     psDEFGroupDetailMap.put(iPSDEFGroupDetail.getPSDEField().getId(), iPSDEFGroupDetail);
                  }

                  if (this.getPSDEServiceAPI() == null) {
                     Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
                     if (psDEFields != null) {
                        boolean bOverwrite = false;
                        if (StringHelper.compare(this.getDEFGroupMode(), "OVERWRITE", true) == 0) {
                           bOverwrite = true;
                        }

                        while (psDEFields.hasNext()) {
                           IPSDEField iPSDEField = psDEFields.next();
                           IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetailMap.get(iPSDEField.getId());
                           if (iPSDEFGroupDetail != null) {
                              if (bOverwrite) {
                                 PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                                 psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                                 this.psAppDEFieldList.add(psAppDEFieldImpl);
                              }
                           } else {
                              PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                              psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
                              this.psAppDEFieldList.add(psAppDEFieldImpl);
                           }
                        }
                     }
                  } else {
                     Iterator<? extends IPSDEServiceAPIField> psDEServiceAPIFields = this.getPSDEServiceAPI().getPSDEServiceAPIFields();
                     if (psDEServiceAPIFields != null) {
                        boolean bOverwrite = false;
                        if (StringHelper.compare(this.getDEFGroupMode(), "OVERWRITE", true) == 0) {
                           bOverwrite = true;
                        }

                        while (psDEServiceAPIFields.hasNext()) {
                           IPSDEServiceAPIField iPSDEServiceAPIField = psDEServiceAPIFields.next();
                           IPSDEFGroupDetail iPSDEFGroupDetail = null;
                           if (iPSDEServiceAPIField.getPSDEField() != null) {
                              iPSDEFGroupDetail = psDEFGroupDetailMap.get(iPSDEServiceAPIField.getPSDEField().getId());
                           }

                           if (iPSDEFGroupDetail != null) {
                              if (bOverwrite) {
                                 PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                                 psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                                 this.psAppDEFieldList.add(psAppDEFieldImpl);
                              }
                           } else {
                              PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                              psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIField);
                              this.psAppDEFieldList.add(psAppDEFieldImpl);
                           }
                        }
                     }
                  }
               }

               Collections.sort(this.psAppDEFieldList, new Comparator<IPSAppDEField>() {
                  public int compare(IPSAppDEField arg0, IPSAppDEField arg1) {
                     int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                     return nValue == 0 ? arg0.getName().compareTo(arg1.getName()) : new Integer(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
                  }
               });
            }
         } else if (this.getPSDEServiceAPI() != null) {
            Iterator<? extends IPSDEServiceAPIField> psDEServiceAPIFields = this.getPSDEServiceAPI().getPSDEServiceAPIFields();
            if (psDEServiceAPIFields != null) {
               while (psDEServiceAPIFields.hasNext()) {
                  IPSDEServiceAPIField iPSDEServiceAPIField = psDEServiceAPIFields.next();
                  PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
                  psAppDEFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIField);
                  this.psAppDEFieldList.add(psAppDEFieldImpl);
               }
            }
         } else {
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
               while (psDEFields.hasNext()) {
                  IPSDEField iPSDEField = psDEFields.next();
                  PSAppDEFieldImpl2 psAppDEFieldImpl = new PSAppDEFieldImpl2();
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

            if (iPSAppDEField.getPSDEField() != null && !this.psAppDEFieldMap.containsKey(iPSAppDEField.getPSDEField().getId())) {
               this.psAppDEFieldMap.put(iPSAppDEField.getPSDEField().getId(), iPSAppDEField);
            }
         }
      }
   }

   protected void onPreparePSAppDEMethods() throws Exception {
      this.allPSAppDEMethodList = null;
      this.psAppDEMethodMap = null;
      if (this.getPSDEServiceAPI() != null || this.getStorageMode() == STORAGEMODE_LOCALONLY || this.getStorageMode() == STORAGEMODE_DTOONLY) {
         this.allPSAppDEMethodList = new ArrayList<>();
         this.psAppDEMethodMap = new LinkedHashMap<>();
         if ((this.getPSDEServiceAPI() == null || !this.getPSDEServiceAPI().isNested())
            && this.getStorageMode() != STORAGEMODE_LOCALONLY
            && this.getStorageMode() != STORAGEMODE_DTOONLY) {
            Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = this.getPSDEServiceAPI().getPSDEServiceAPIMethods();
            if (psDEServiceAPIMethods != null) {
               while (psDEServiceAPIMethods.hasNext()) {
                  IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                  PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                  psAppDEMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIMethod);
                  this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                  if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                     this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                  }

                  String strMethodTag = null;
                  String strMethodTag2 = null;
                  if (StringHelper.compare(psAppDEMethodImpl.getMethodType(), "DEACTION", false) == 0) {
                     if (psAppDEMethodImpl.getPSDEAction() != null) {
                        strMethodTag = StringHelper.format("%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEAction().getId());
                        strMethodTag2 = StringHelper.format(
                           "%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEAction().getName().toUpperCase()
                        );
                     }
                  } else if ((
                        StringHelper.compare(psAppDEMethodImpl.getMethodType(), "FETCH", false) == 0
                           || StringHelper.compare(psAppDEMethodImpl.getMethodType(), "FETCHTEMP", false) == 0
                     )
                     && psAppDEMethodImpl.getPSDEDataSet() != null) {
                     strMethodTag = StringHelper.format("%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getId());
                     strMethodTag2 = StringHelper.format(
                        "%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getName().toUpperCase()
                     );
                  }

                  if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                     this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                  }

                  if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                     this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                  }
               }
            }

            Iterator<IPSDEAction> psDEActions = this.getPSDataEntity().getAllPSDEActions();
            if (psDEActions != null) {
               while (psDEActions.hasNext()) {
                  IPSDEAction iPSDEAction = psDEActions.next();
                  if (iPSDEAction.isEnableFront()) {
                     String strMethodTag = null;
                     String strMethodTag2 = null;
                     strMethodTag = StringHelper.format("%1$s|%2$s", "DEACTION", iPSDEAction.getId());
                     strMethodTag2 = StringHelper.format("%1$s|%2$s", "DEACTION", iPSDEAction.getName().toUpperCase());
                     if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                        PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                        psAppDEMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEAction);
                        this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                        if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                           this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                        }

                        if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                           this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                        }

                        if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                           this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                        }
                     }
                  }
               }
            }

            Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
            if (psDEDataSets != null) {
               while (psDEDataSets.hasNext()) {
                  IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                  if (iPSDEDataSet.isEnableFront()) {
                     String strMethodTag = StringHelper.format("%1$s|%2$s", "FETCH", iPSDEDataSet.getId());
                     String strMethodTag2 = StringHelper.format("%1$s|%2$s", "FETCH", iPSDEDataSet.getName().toUpperCase());
                     if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                        PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                        psAppDEMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEDataSet);
                        this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                        if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                           this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                        }

                        if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                           this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                        }

                        if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                           this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                        }
                     }

                     if (iPSDEDataSet.isEnableTempData() && this.isEnableTempData()) {
                        strMethodTag = StringHelper.format("%1$s|%2$s", "FETCHTEMP", iPSDEDataSet.getId());
                        strMethodTag2 = StringHelper.format("%1$s|%2$s", "FETCHTEMP", iPSDEDataSet.getName().toUpperCase());
                        if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                           PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                           psAppDEMethodImpl.initTempMode(this.getDAGlobalHelper(), this, iPSDEDataSet);
                           this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                           if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                              this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                           }

                           if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                              this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                           }

                           if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                              this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                           }
                        }
                     }
                  }
               }
            }
         } else {
            Iterator<IPSDEAction> psDEActions = this.getPSDataEntity().getAllPSDEActions();
            if (psDEActions != null) {
               while (psDEActions.hasNext()) {
                  IPSDEAction iPSDEAction = psDEActions.next();
                  if (iPSDEAction.isEnableFront()) {
                     PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                     psAppDEMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEAction);
                     this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                     if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                     }

                     String strMethodTag = null;
                     String strMethodTag2 = null;
                     strMethodTag = StringHelper.format("%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEAction().getId());
                     strMethodTag2 = StringHelper.format(
                        "%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEAction().getName().toUpperCase()
                     );
                     if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                        this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                     }

                     if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                        this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                     }
                  }
               }
            }

            Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
            if (psDEDataSets != null) {
               while (psDEDataSets.hasNext()) {
                  IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                  if (iPSDEDataSet.isEnableFront()) {
                     PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                     psAppDEMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEDataSet);
                     this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                     if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                        this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                     }

                     String strMethodTag = null;
                     String strMethodTag2 = null;
                     strMethodTag = StringHelper.format("%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getId());
                     strMethodTag2 = StringHelper.format(
                        "%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getName().toUpperCase()
                     );
                     if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                        this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                     }

                     if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                        this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                     }

                     if (iPSDEDataSet.isEnableTempData() && this.isEnableTempData()) {
                        psAppDEMethodImpl = new PSAppDEMethodImpl();
                        psAppDEMethodImpl.initTempMode(this.getDAGlobalHelper(), this, iPSDEDataSet);
                        this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                        if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                           this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                        }

                        strMethodTag = null;
                        strMethodTag2 = null;
                        strMethodTag = StringHelper.format("%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getId());
                        strMethodTag2 = StringHelper.format(
                           "%1$s|%2$s", psAppDEMethodImpl.getMethodType(), psAppDEMethodImpl.getPSDEDataSet().getName().toUpperCase()
                        );
                        if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                           this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                        }

                        if (!StringHelper.isNullOrEmpty(strMethodTag2)) {
                           this.psAppDEMethodMap.put(strMethodTag2, psAppDEMethodImpl);
                        }
                     }
                  }
               }
            }
         }

         if (this.isEnableFilterActions()) {
            for (Entry<String, String> entry : FilterActions.entrySet()) {
               PSDESADetail psDESADetail = new PSDESADetail();
               psDESADetail.setPSDESADETAILID(KeyValueHelper.genUniqueId(this.getId(), entry.getKey()));
               psDESADetail.setPSDESADETAILNAME(entry.getKey());
               psDESADetail.setCODENAME(entry.getValue());
               psDESADetail.setDETAILTYPE("FILTERACTION");
               String strMethodTag = StringHelper.format("%1$s|%2$s", "FILTERACTION", entry.getKey());
               if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                  PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                  psAppDEMethodImpl.initBuiltinMode(this.getDAGlobalHelper(), this, psDESADetail);
                  this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                  if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                     this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                  }

                  if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                     this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                  }
               }
            }
         }

         if (this.isEnableWFActions()) {
            for (Entry<String, String> entry : WFActions.entrySet()) {
               PSDESADetail psDESADetail = new PSDESADetail();
               psDESADetail.setPSDESADETAILID(KeyValueHelper.genUniqueId(this.getId(), entry.getKey()));
               psDESADetail.setPSDESADETAILNAME(entry.getKey());
               psDESADetail.setCODENAME(entry.getValue());
               psDESADetail.setDETAILTYPE("WFACTION");
               String strMethodTag = StringHelper.format("%1$s|%2$s", "WFACTION", entry.getKey());
               if (!this.psAppDEMethodMap.containsKey(strMethodTag)) {
                  PSAppDEMethodImpl psAppDEMethodImpl = new PSAppDEMethodImpl();
                  psAppDEMethodImpl.initBuiltinMode(this.getDAGlobalHelper(), this, psDESADetail);
                  this.allPSAppDEMethodList.add(psAppDEMethodImpl);
                  if (!StringHelper.isNullOrEmpty(psAppDEMethodImpl.getId())) {
                     this.psAppDEMethodMap.put(psAppDEMethodImpl.getId(), psAppDEMethodImpl);
                  }

                  if (!StringHelper.isNullOrEmpty(strMethodTag)) {
                     this.psAppDEMethodMap.put(strMethodTag, psAppDEMethodImpl);
                  }
               }
            }
         }

         if (this.allPSAppDEMethodList.size() == 0) {
            this.allPSAppDEMethodList = null;
         }

         if (this.psAppDEMethodMap.size() == 0) {
            this.psAppDEMethodMap = null;
         }

         if (this.allPSAppDEMethodList != null && this.allPSAppDEMethodList.size() != 0) {
            Collections.sort(this.allPSAppDEMethodList, new Comparator<IPSAppDEMethod>() {
               public int compare(IPSAppDEMethod o1, IPSAppDEMethod o2) {
                  int nRet = o1.getMethodType().compareTo(o2.getMethodType());
                  return nRet != 0 ? nRet : StringHelper.compare(o1.getCodeName(), o2.getCodeName(), false);
               }
            });
         }
      }
   }

   @PSModelRTMeta(description = "本地存储模式", codelist = "AppDEStorageMode", group = "基本", order = 125, fields = "ENABLESTORAGE")
   @Override
   public int getStorageMode() {
      return this.nStorageMode;
   }

   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSs(boolean bMajor) {
      try {
         Iterator<IPSAppDERS> psAppDERSs = this.getPSApplication().getAllPSAppDERSs();
         if (psAppDERSs == null) {
            return null;
         }

         if (bMajor) {
            if (this.majorPSAppDERSList == null) {
               ArrayList<IPSAppDERS> list = new ArrayList<>();

               while (psAppDERSs.hasNext()) {
                  IPSAppDERS iPSAppDERS = psAppDERSs.next();
                  if (StringHelper.compare(iPSAppDERS.getPPSAppDataEntityId(), this.getId(), true) == 0) {
                     list.add(iPSAppDERS);
                  }
               }

               if (this.majorPSAppDERSList == null) {
                  PSModelUtil.sort(list);
                  this.majorPSAppDERSList = list;
               }
            }

            return this.majorPSAppDERSList.iterator();
         } else {
            if (this.minorPSAppDERSList == null) {
               ArrayList<IPSAppDERS> list = new ArrayList<>();

               while (psAppDERSs.hasNext()) {
                  IPSAppDERS iPSAppDERS = psAppDERSs.next();
                  if (StringHelper.compare(iPSAppDERS.getCPSAppDataEntityId(), this.getId(), true) == 0) {
                     list.add(iPSAppDERS);
                  }
               }

               if (this.minorPSAppDERSList == null) {
                  PSModelUtil.sort(list);
                  this.minorPSAppDERSList = list;
               }
            }

            return this.minorPSAppDERSList.iterator();
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSs() {
      return this.getPSAppDERSs(true);
   }

   @PSModelRTMeta(description = "应用实体主关系集合", group = "模型", order = 166)
   @Override
   public Iterator<? extends IPSAppDERS> getMajorPSAppDERSs() {
      return this.getPSAppDERSs(true);
   }

   @PSModelRTMeta(description = "应用实体从关系集合", child = true, group = "模型", order = 165)
   @Override
   public Iterator<? extends IPSAppDERS> getMinorPSAppDERSs() {
      return this.getPSAppDERSs(false);
   }

   @PSModelRTMeta(description = "应用实体关系路径数量", dump = false)
   @Override
   public int getPSAppDERSPathCount() throws Exception {
      this.preparePSAppDERSPaths();
      return this.psAppDERSPathMap == null ? 0 : this.psAppDERSPathMap.size();
   }

   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
      this.preparePSAppDERSPaths();
      if (this.psAppDERSPathMap == null) {
         return null;
      }

      ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
      return list == null ? null : list.iterator();
   }

   protected synchronized void preparePSAppDERSPaths() throws Exception {
      synchronized (this) {
         if (this.psAppDERSPathMap == null) {
            this.psAppDERSPathMap = new LinkedHashMap<>();
            Iterator<? extends IPSAppDERS> psAppDERSs = this.getPSAppDERSs(false);
            if (psAppDERSs != null) {
               while (psAppDERSs.hasNext()) {
                  IPSAppDERS iPSAppDERS = psAppDERSs.next();
                  if (StringHelper.compare(iPSAppDERS.getPPSAppDataEntityId(), iPSAppDERS.getCPSAppDataEntityId(), false) != 0
                     && iPSAppDERS.getRSMode() == IPSAppDERS.RSMODE_DESARS) {
                     ArrayList<IPSAppDERS> list = new ArrayList<>();
                     int nIndex = this.psAppDERSPathMap.size();
                     this.psAppDERSPathMap.put(nIndex, list);
                     this.fillPSAppDERSPath(iPSAppDERS, list);
                  }
               }

               if (this.psAppDERSPathMap.size() > 1) {
                  ArrayList<ArrayList<IPSAppDERS>> list = new ArrayList<>();
                  list.addAll(this.psAppDERSPathMap.values());
                  Collections.sort(list, new Comparator<ArrayList<IPSAppDERS>>() {
                     public int compare(ArrayList<IPSAppDERS> arg0, ArrayList<IPSAppDERS> arg1) {
                        if (arg0.size() != arg1.size()) {
                           return Integer.valueOf(arg0.size()).compareTo(arg1.size());
                        }

                        for (int i = 0; i < arg0.size(); i++) {
                           int nRet = arg0.get(i).getName().compareTo(arg1.get(i).getName());
                           if (nRet != 0) {
                              return nRet;
                           }
                        }

                        return 0;
                     }
                  });
                  Collections.reverse(list);
                  this.psAppDERSPathMap.clear();

                  for (int i = 0; i < list.size(); i++) {
                     this.psAppDERSPathMap.put(i, list.get(i));
                  }
               }
            }
         }
      }
   }

   protected synchronized void fillPSAppDERSPath(IPSAppDERS iPSAppDERS, ArrayList<IPSAppDERS> list) throws Exception {
      for (IPSAppDERS tempPSAppDERS : list) {
         if (StringHelper.compare(iPSAppDERS.getId(), tempPSAppDERS.getId(), false) == 0) {
            throw new Exception(StringHelper.format("应用实体[%1$s]存在递归引用关系[%2$s]", this.getFullName(), iPSAppDERS.getName()));
         }
      }

      list.add(0, iPSAppDERS);
      Iterator<? extends IPSAppDERS> majorList = iPSAppDERS.getMajorPSAppDataEntity().getPSAppDERSs(false);
      if (majorList != null) {
         ArrayList<IPSAppDERS> srcList = new ArrayList<>();
         srcList.addAll(list);
         int nIndex = 0;

         while (majorList.hasNext()) {
            IPSAppDERS tempPSAppDERS = majorList.next();
            if (StringHelper.compare(tempPSAppDERS.getPPSAppDataEntityId(), tempPSAppDERS.getCPSAppDataEntityId(), false) != 0
               && tempPSAppDERS.getRSMode() == IPSAppDERS.RSMODE_DESARS) {
               if (nIndex == 0) {
                  if (iPSAppDERS.getMajorPSAppDataEntity().isMajor()) {
                     ArrayList<IPSAppDERS> list2 = new ArrayList<>();
                     list2.addAll(srcList);
                     int nIndex2 = this.psAppDERSPathMap.size();
                     this.psAppDERSPathMap.put(nIndex2, list2);
                  }

                  this.fillPSAppDERSPath(tempPSAppDERS, list);
               } else {
                  ArrayList<IPSAppDERS> list2 = new ArrayList<>();
                  list2.addAll(srcList);
                  int nIndex2 = this.psAppDERSPathMap.size();
                  this.psAppDERSPathMap.put(nIndex2, list2);
                  this.fillPSAppDERSPath(tempPSAppDERS, list2);
               }

               nIndex++;
            }
         }
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
      return list != null && list.size() != 0 ? list.get(0) : null;
   }

   @Override
   public IPSAppDERS getPSAppDERSPathLast(int nPathIndex) throws Exception {
      this.preparePSAppDERSPaths();
      if (this.psAppDERSPathMap == null) {
         return null;
      }

      ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
      return list != null && list.size() != 0 ? list.get(list.size() - 1) : null;
   }

   @PSModelRTMeta(description = "应用实体路径[0]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception {
      return this.getPSAppDERSPath(0);
   }

   @PSModelRTMeta(description = "应用实体路径[1]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception {
      return this.getPSAppDERSPath(1);
   }

   @PSModelRTMeta(description = "接口关系路径[2]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception {
      return this.getPSAppDERSPath(2);
   }

   @PSModelRTMeta(description = "应用实体路径[3]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception {
      return this.getPSAppDERSPath(3);
   }

   @PSModelRTMeta(description = "应用实体关系路径[4]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception {
      return this.getPSAppDERSPath(4);
   }

   @PSModelRTMeta(description = "属性组对象", hideempty = true)
   @Override
   public IPSDEFGroup getPSDEFGroup() {
      return this.iPSDEFGroup;
   }

   @PSModelRTMeta(description = "属性组使用模式", codelist = "DESADEFGroupMode", hideempty2 = true)
   @Override
   public String getDEFGroupMode() {
      return this.strDEFGroupMode;
   }

   @PSModelRTMeta(description = "应用实体属性集合", child = true, group = "模型", order = 160)
   @Override
   public Iterator<? extends IPSAppDEField> getAllPSAppDEFields() {
      return this.psAppDEFieldList != null && this.psAppDEFieldList.size() != 0 ? this.psAppDEFieldList.iterator() : null;
   }

   @Override
   public IPSAppDEField getPSAppDEField(String strPSDEFieldId) throws Exception {
      return this.getPSAppDEField(strPSDEFieldId, false);
   }

   @Override
   public IPSAppDEField getPSAppDEField(IPSDEField iPSDEField, boolean bTryMode) throws Exception {
      IPSAppDEField iPSAppDEField = this.getPSAppDEField(iPSDEField.getId(), true);
      if (iPSAppDEField == null && !bTryMode) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体属性[%2$s]", this.getFullName(), iPSDEField.getName()));
      } else {
         return iPSAppDEField;
      }
   }

   @Override
   public IPSAppDEField getPSAppDEField(String strPSDEFieldId, boolean bTryMode) throws Exception {
      IPSAppDEField iPSAppDEField = null;
      if (this.psAppDEFieldMap != null) {
         iPSAppDEField = this.psAppDEFieldMap.get(strPSDEFieldId);
      }

      if (iPSAppDEField == null && !bTryMode) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体属性[%2$s]", this.getFullName(), strPSDEFieldId));
      } else {
         return iPSAppDEField;
      }
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
         strMethodTag = StringHelper.format("%1$s|%2$s", "DEACTION", ((IPSDEAction)objMethod).getId());
      } else if (objMethod instanceof IPSDEDataSet) {
         strMethodTag = StringHelper.format("%1$s|%2$s", "FETCH", ((IPSDEDataSet)objMethod).getId());
      }

      if (StringHelper.isNullOrEmpty(strMethodTag)) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法识别指定的目标方法对象", this.getFullName()));
      }

      IPSAppDEMethod iPSAppDEMethod = null;
      if (this.psAppDEMethodMap != null) {
         iPSAppDEMethod = this.psAppDEMethodMap.get(strMethodTag);
      }

      if (iPSAppDEMethod != null || bTryMode) {
         return iPSAppDEMethod;
      } else if (objMethod instanceof IPSDEAction) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体行为方法[%2$s]", this.getFullName(), ((IPSDEAction)objMethod).getFullName()));
      } else if (objMethod instanceof IPSDEDataSet) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体数据集方法[%2$s]", this.getFullName(), ((IPSDEDataSet)objMethod).getFullName()));
      } else {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体方法[%2$s]", this.getFullName(), strMethodTag));
      }
   }

   @Override
   public IPSAppDEMethod getPSAppDEMethod(String strMethodType, String strMethodId, boolean bTryMode) throws Exception {
      String strMethodTag = StringHelper.format("%1$s|%2$s", strMethodType, strMethodId);
      IPSAppDEMethod iPSAppDEMethod = null;
      if (this.psAppDEMethodMap != null) {
         iPSAppDEMethod = this.psAppDEMethodMap.get(strMethodTag);
      }

      if (iPSAppDEMethod == null && !bTryMode) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体方法[%2$s]", this.getFullName(), strMethodTag));
      } else {
         return iPSAppDEMethod;
      }
   }

   @PSModelRTMeta(description = "主键属性", dumpref = true, from = "__self__", group = "模型", order = 151, doc = "计算当前应用实体的主键属性")
   @Override
   public IPSAppDEField getKeyPSAppDEField() {
      return this.keyPSAppDEField;
   }

   @PSModelRTMeta(description = "主信息属性", dumpref = true, from = "__self__", group = "模型", order = 152, doc = "计算当前应用实体的主信息属性")
   @Override
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
      registerRefPSModelObject(iPSAppDEUIAction, refPSModelObject);
      return iPSAppDEUIAction;
   }

   @Override
   public IPSAppDEUIAction getPSAppDEUIAction2(String strAppDEUIActionId, boolean bTryMode) throws Exception {
      return this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
   }

   @Override
   public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId, boolean bTryMode) throws Exception {
      IPSAppDEUIAction iPSAppDEUIAction = this.psAppDEUIActionMap.get(strAppDEUIActionId);
      if (iPSAppDEUIAction != null) {
         return iPSAppDEUIAction;
      }

      iPSAppDEUIAction = this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, true);
      if (iPSAppDEUIAction != null) {
         if (!this.bLoadPSAppDEUIActionGroupNow) {
            this.psAppDEUIActionMap.put(iPSAppDEUIAction.getId(), iPSAppDEUIAction);
         }

         return iPSAppDEUIAction;
      } else {
         if (!this.bLoadPSAppDEUIActionGroupNow) {
            iPSAppDEUIAction = this.getPSApplication().getPSAppDEUIAction(strAppDEUIActionId, true);
         } else {
            iPSAppDEUIAction = this.getPSApplication().getPSAppDEUIAction2(strAppDEUIActionId, true);
         }

         if (iPSAppDEUIAction != null) {
            return iPSAppDEUIAction;
         } else {
            return !bTryMode ? this.psAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode) : iPSAppDEUIAction;
         }
      }
   }

   @Override
   public void resetPSAppDEUIAction(String strAppDEUIActionId) throws Exception {
      this.psAppDEUIActionGlobalModel.ResetModel(strAppDEUIActionId);
   }

   @PSModelRTMeta(description = "实体界面行为集合", child = true, group = "界面逻辑", order = 252)
   @Override
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

   @PSModelRTMeta(description = "实体界面行为组集合", child = true, ignorepf = true, group = "界面逻辑", order = 253)
   @Override
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
      registerRefPSModelObject(iPSAppDEUIActionGroup, refPSModelObject);
      return iPSAppDEUIActionGroup;
   }

   @Override
   public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId, boolean bTryMode) throws Exception {
      IPSAppDEUIActionGroup iPSAppDEUIActionGroup = this.getPSApplication().getPSAppDEUIActionGroup(strAppDEUIActionGroupId, true);
      if (iPSAppDEUIActionGroup != null) {
         return iPSAppDEUIActionGroup;
      }

      iPSAppDEUIActionGroup = this.psAppDEUIActionGroupGlobalModel.FindModelHelper(strAppDEUIActionGroupId, bTryMode);
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
      return this.psAppDELogicGlobalModel.FindModelHelper(strAppDELogicId, false);
   }

   @Override
   public IPSAppDELogic getPSAppDELogic(String strAppDELogicId, boolean bTryMode) throws Exception {
      return this.psAppDELogicGlobalModel.FindModelHelper(strAppDELogicId, bTryMode);
   }

   @Override
   public void resetPSAppDELogic(String strAppDELogicId) throws Exception {
      this.psAppDELogicGlobalModel.ResetModel(strAppDELogicId);
   }

   @PSModelRTMeta(description = "应用实体逻辑集合", child = true, group = "处理逻辑", order = 197)
   @Override
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

      iPSAppDEUILogic = this.psAppDEUILogicGlobalModel.FindModelHelper(strAppDEUILogicId, bTryMode);
      if (iPSAppDEUILogic != null) {
         this.psAppDEUILogicMap.put(strAppDEUILogicId, iPSAppDEUILogic);
      }

      return iPSAppDEUILogic;
   }

   @Override
   public void resetPSAppDEUILogic(String strAppDEUILogicId) throws Exception {
      this.psAppDEUILogicGlobalModel.ResetModel(strAppDEUILogicId);
   }

   @PSModelRTMeta(description = "实体界面逻辑集合", child = true, group = "界面逻辑", order = 249)
   @Override
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
      IPSAppDEUILogicGroup iPSAppDEUILogicGroup = this.psAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, true);
      if (iPSAppDEUILogicGroup != null) {
         return iPSAppDEUILogicGroup;
      }

      iPSAppDEUILogicGroup = this.getPSApplication().getPSAppDEUILogicGroup(strAppDEUILogicGroupId, true);
      return iPSAppDEUILogicGroup == null && !bTryMode
         ? this.psAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, bTryMode)
         : iPSAppDEUILogicGroup;
   }

   @Override
   public void resetPSAppDEUILogicGroup(String strAppDEUILogicGroupId) throws Exception {
      this.psAppDEUILogicGroupGlobalModel.ResetModel(strAppDEUILogicGroupId);
   }

   @PSModelRTMeta(description = "实体界面逻辑组集合", group = "界面逻辑", order = 250)
   @Override
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
      iPSDEACMode.getModelData().CopyTo(psDEACMode, false);
      psDEACModeImpl.init(this.getDAGlobalHelper(), this, psDEACMode);
      this.psAppDEACModeMap.put(strAppDEACModeId, psDEACModeImpl);
      return psDEACModeImpl;
   }

   @Override
   public void resetPSAppDEACMode(String strAppDEACModeId) throws Exception {
   }

   @PSModelRTMeta(description = "实体自填模式集合", child = true, group = "界面逻辑", order = 245)
   @Override
   public Iterator<IPSAppDEACMode> getAllPSAppDEACModes() throws Exception {
      return PSModelUtil.sort(this.psAppDEACModeMap, IPSAppDEACMode.class).iterator();
   }

   @Override
   public IPSAppDEAction getPSAppDEAction(String strPSDEActionId, boolean bTryMode) throws Exception {
      IPSDEAction iPSDEAction = this.getPSDataEntity().getPSDEAction(strPSDEActionId, bTryMode);
      return iPSDEAction != null ? this.getPSAppDEAction(iPSDEAction, bTryMode) : null;
   }

   @Override
   public IPSAppDEAction getPSAppDEAction(IPSDEAction iPSDEAction, boolean bTryMode) throws Exception {
      IPSAppDEMethod iPSAppDEMethod = this.getPSAppDEMethod(iPSDEAction, bTryMode);
      return iPSAppDEMethod instanceof IPSAppDEAction ? (IPSAppDEAction)iPSAppDEMethod : null;
   }

   @Override
   public IPSAppDEDataSet getPSAppDEDataSet(String strPSDEDataSetId, boolean bTryMode) throws Exception {
      IPSDEDataSet iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(strPSDEDataSetId, bTryMode);
      return iPSDEDataSet != null ? this.getPSAppDEDataSet(iPSDEDataSet, bTryMode) : null;
   }

   @Override
   public IPSAppDEDataSet getPSAppDEDataSet(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
      IPSAppDEMethod iPSAppDEMethod = this.getPSAppDEMethod(iPSDEDataSet, bTryMode);
      return iPSAppDEMethod instanceof IPSAppDEDataSet ? (IPSAppDEDataSet)iPSAppDEMethod : null;
   }

   @Override
   public IPSAppDEDataSet getPSAppDEDataSetTempMode(String strPSDEDataSetId, boolean bTryMode) throws Exception {
      IPSDEDataSet iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(strPSDEDataSetId, bTryMode);
      return iPSDEDataSet != null ? this.getPSAppDEDataSetTempMode(iPSDEDataSet, bTryMode) : null;
   }

   @Override
   public IPSAppDEDataSet getPSAppDEDataSetTempMode(IPSDEDataSet iPSDEDataSet, boolean bTryMode) throws Exception {
      String strMethodTag = null;
      if (iPSDEDataSet != null) {
         strMethodTag = StringHelper.format("%1$s|%2$s", "FETCHTEMP", iPSDEDataSet.getId());
      }

      if (StringHelper.isNullOrEmpty(strMethodTag)) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法识别的目标数据集对象", this.getFullName()));
      }

      IPSAppDEDataSet iPSAppDEDataSet = null;
      if (this.psAppDEMethodMap != null) {
         Object objAppDEMethod = this.psAppDEMethodMap.get(strMethodTag);
         if (objAppDEMethod instanceof IPSAppDEDataSet) {
            iPSAppDEDataSet = (IPSAppDEDataSet)objAppDEMethod;
         }
      }

      if (iPSAppDEDataSet == null && !bTryMode) {
         throw new Exception(StringHelper.format("应用实体[%1$s]无法获取指定应用实体数据集[%2$s]", this.getFullName(), strMethodTag));
      } else {
         return iPSAppDEDataSet;
      }
   }

   @PSModelRTMeta(
      description = "支持临时数据模式",
      ignoredumpvalues = "false",
      doc = "计算实体是否支持前端临时数据模式{@link net.ibizsys.model.dataentity.IPSDataEntity#isEnableTempDataFront}"
   )
   @Override
   public boolean isEnableTempData() {
      return this.getPSDataEntity().isEnableTempDataFront();
   }

   @PSModelRTMeta(description = "提供过滤器相关行为")
   @Override
   public boolean isEnableFilterActions() {
      return this.bEnableFilterActions;
   }

   @PSModelRTMeta(description = "提供工作流相关行为")
   @Override
   public boolean isEnableWFActions() {
      return this.bEnableWFActions && this.getPSAppWF() != null;
   }

   @PSModelRTMeta(description = "应用工作流")
   @Override
   public IPSAppWF getPSAppWF() {
      return this.iPSAppWF;
   }

   @PSModelRTMeta(description = "兄弟应用实体集合", outputdoc = "false")
   @Override
   public Iterator<IPSAppDataEntity> getSiblings() throws Exception {
      if (this.siblingList == null) {
         List<IPSAppDataEntity> siblingList = new ArrayList<>();
         Iterator<IPSAppDataEntity> psAppDataEntities = this.getPSApplication().getPSAppDataEntitiesByDEId(this.getPSDataEntity().getId());
         if (psAppDataEntities != null) {
            while (psAppDataEntities.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
               if (StringHelper.compare(iPSAppDataEntity.getId(), this.getId(), false) != 0) {
                  siblingList.add(iPSAppDataEntity);
               }
            }
         }

         if (this.siblingList == null) {
            this.siblingList = siblingList;
         }
      }

      return this.siblingList.size() == 0 ? null : this.siblingList.iterator();
   }

   @PSModelRTMeta(description = "应用实体门户部件集合")
   @Override
   public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception {
      if (this.psAppPortletList == null) {
         List<IPSAppPortlet> psAppPortletList = new ArrayList<>();
         Iterator<IPSAppPortlet> psAppPortlets = this.getPSApplication().getAllPSAppPortlets();
         if (psAppPortlets != null) {
            while (psAppPortlets.hasNext()) {
               IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
               if (iPSAppPortlet.isEnableDEDashboard()
                  && iPSAppPortlet.getPSAppDataEntity() != null
                  && StringHelper.compare(iPSAppPortlet.getPSAppDataEntity().getId(), this.getId(), false) == 0) {
                  psAppPortletList.add(iPSAppPortlet);
               }
            }

            Collections.sort(psAppPortletList, new Comparator<IPSAppPortlet>() {
               public int compare(IPSAppPortlet o1, IPSAppPortlet o2) {
                  return StringHelper.compare(o1.getName(), o2.getName(), false);
               }
            });
         }

         if (this.psAppPortletList == null) {
            this.psAppPortletList = psAppPortletList;
         }
      }

      return this.psAppPortletList.size() == 0 ? null : this.psAppPortletList.iterator();
   }

   @PSModelRTMeta(description = "实体门户部件分类集合", child = true, outputdoc = "false")
   @Override
   public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception {
      if (this.psAppPortletCatList == null) {
         List<IPSAppPortletCat> psAppPortletCatList = new ArrayList<>();
         Iterator<IPSAppPortlet> psAppPortlets = this.getAllPSAppPortlets();
         if (psAppPortlets != null) {
            Map<String, IPSAppPortletCat> psAppPortletCatMap = new LinkedHashMap<>();

            while (psAppPortlets.hasNext()) {
               IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
               if (iPSAppPortlet.getPSAppPortletCat() != null && !psAppPortletCatMap.containsKey(iPSAppPortlet.getPSAppPortletCat().getId())) {
                  psAppPortletCatMap.put(iPSAppPortlet.getPSAppPortletCat().getId(), iPSAppPortlet.getPSAppPortletCat());
                  psAppPortletCatList.add(iPSAppPortlet.getPSAppPortletCat());
               }
            }

            Collections.sort(psAppPortletCatList, new Comparator<IPSAppPortletCat>() {
               public int compare(IPSAppPortletCat o1, IPSAppPortletCat o2) {
                  return o1.isUngroup() ? 1 : StringHelper.compare(o1.getName(), o2.getName(), false);
               }
            });
         }

         if (this.psAppPortletCatList == null) {
            this.psAppPortletCatList = psAppPortletCatList;
         }
      }

      return this.psAppPortletCatList != null && this.psAppPortletCatList.size() != 0 ? this.psAppPortletCatList.iterator() : null;
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

   @PSModelRTMeta(description = "服务接口", hideempty = true, dumpref = true, ignorepf = true, dynamodelmode = 8, group = "模型", order = 156)
   @Override
   public IPSSysServiceAPI getPSSysServiceAPI() {
      return this.iPSSysServiceAPI;
   }

   @PSModelRTMeta(description = "快速搜索属性集合", child = true, dumpref = true, rtdump = 1, outputdoc = "false", doc = "计算实体支持快速搜索的属性集合")
   @Override
   public Iterator<? extends IPSAppDEField> getQuickSearchPSAppDEFields() throws Exception {
      if (this.quickSearchPSAppDEFieldList == null) {
         ArrayList<IPSAppDEField> quickSearchPSAppDEFieldList = new ArrayList<>();
         Iterator<? extends IPSAppDEField> psAppDEFields = this.getAllPSAppDEFields();
         if (psAppDEFields != null) {
            while (psAppDEFields.hasNext()) {
               IPSAppDEField iPSAppDEField = psAppDEFields.next();
               if (iPSAppDEField.isEnableQuickSearch()) {
                  quickSearchPSAppDEFieldList.add(iPSAppDEField);
               }
            }
         }

         if (this.quickSearchPSAppDEFieldList == null) {
            this.quickSearchPSAppDEFieldList = quickSearchPSAppDEFieldList;
         }
      }

      return this.quickSearchPSAppDEFieldList != null && this.quickSearchPSAppDEFieldList.size() != 0 ? this.quickSearchPSAppDEFieldList.iterator() : null;
   }

   @Override
   public IPSAppDEPrint getPSAppDEPrint(String strAppDEPrintId) throws Exception {
      return this.psAppDEPrintGlobalModel.FindModelHelper(strAppDEPrintId, false);
   }

   @Override
   public IPSAppDEPrint getPSAppDEPrint(String strAppDEPrintId, boolean bTryMode) throws Exception {
      return this.psAppDEPrintGlobalModel.FindModelHelper(strAppDEPrintId, bTryMode);
   }

   @Override
   public void resetPSAppDEPrint(String strAppDEPrintId) throws Exception {
      this.psAppDEPrintGlobalModel.ResetModel(strAppDEPrintId);
   }

   @PSModelRTMeta(description = "实体打印集合", child = true, group = "处理逻辑", order = 199)
   @Override
   public Iterator<IPSAppDEPrint> getAllPSAppDEPrints() throws Exception {
      return this.psAppDEPrintGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "默认实体打印", dumpref = true, from = "__self__")
   @Override
   public IPSAppDEPrint getDefaultPSAppDEPrint() throws Exception {
      this.getAllPSAppDEPrints();
      return this.psAppDEPrintGlobalModel.getDefaultPSAppDEPrint();
   }

   @Override
   public IPSAppDEDataImport getPSAppDEDataImport(String strAppDEDataImportId) throws Exception {
      return this.psAppDEDataImportGlobalModel.FindModelHelper(strAppDEDataImportId, false);
   }

   @Override
   public IPSAppDEDataImport getPSAppDEDataImport(String strAppDEDataImportId, boolean bTryMode) throws Exception {
      return this.psAppDEDataImportGlobalModel.FindModelHelper(strAppDEDataImportId, bTryMode);
   }

   @Override
   public void resetPSAppDEDataImport(String strAppDEDataImportId) throws Exception {
      this.psAppDEDataImportGlobalModel.ResetModel(strAppDEDataImportId);
   }

   @PSModelRTMeta(description = "实体数据导入集合", child = true, group = "处理逻辑", order = 200)
   @Override
   public Iterator<IPSAppDEDataImport> getAllPSAppDEDataImports() throws Exception {
      return this.psAppDEDataImportGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "默认实体数据导入", dumpref = true, from = "__self__")
   @Override
   public IPSAppDEDataImport getDefaultPSAppDEDataImport() throws Exception {
      this.getAllPSAppDEDataImports();
      return this.psAppDEDataImportGlobalModel.getDefaultPSAppDEDataImport();
   }

   @Override
   public IPSAppDEDataExport getPSAppDEDataExport(String strAppDEDataExportId) throws Exception {
      return this.psAppDEDataExportGlobalModel.FindModelHelper(strAppDEDataExportId, false);
   }

   @Override
   public IPSAppDEDataExport getPSAppDEDataExport(String strAppDEDataExportId, boolean bTryMode) throws Exception {
      return this.psAppDEDataExportGlobalModel.FindModelHelper(strAppDEDataExportId, bTryMode);
   }

   @Override
   public void resetPSAppDEDataExport(String strAppDEDataExportId) throws Exception {
      this.psAppDEDataExportGlobalModel.ResetModel(strAppDEDataExportId);
   }

   @PSModelRTMeta(description = "实体数据导出集合", child = true, group = "处理逻辑", order = 201)
   @Override
   public Iterator<IPSAppDEDataExport> getAllPSAppDEDataExports() throws Exception {
      return this.psAppDEDataExportGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "默认实体数据导入", dumpref = true, from = "__self__")
   @Override
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

   @PSModelRTMeta(description = "应用代码表集合", group = "模型", order = 170)
   @Override
   public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception {
      if (this.psAppCodeListList == null) {
         ArrayList<IPSAppCodeList> psAppCodeListList = new ArrayList<>();
         Iterator<IPSAppCodeList> psAppCodeLists = this.getPSApplication().getAllPSAppCodeLists();
         if (psAppCodeLists != null) {
            while (psAppCodeLists.hasNext()) {
               IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
               if (iPSAppCodeList.getPSDataEntity() != null
                  && StringHelper.compare(iPSAppCodeList.getPSDataEntity().getId(), this.getPSDataEntity().getId(), false) == 0) {
                  psAppCodeListList.add(iPSAppCodeList);
               }
            }
         }

         if (this.psAppCodeListList == null) {
            this.psAppCodeListList = psAppCodeListList;
         }
      }

      return this.psAppCodeListList != null && this.psAppCodeListList.size() != 0 ? this.psAppCodeListList.iterator() : null;
   }

   @PSModelRTMeta(description = "实体支持界面行为", codelist = "DEUserUIAbility2")
   @Override
   public int getEnableUIActions() {
      return this.nEnableUIActions;
   }

   @PSModelRTMeta(description = "支持界面建立", ignorert = 3)
   @Override
   public boolean isEnableUICreate() {
      return (this.getEnableUIActions() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持界面修改", ignorert = 3)
   @Override
   public boolean isEnableUIModify() {
      return (this.getEnableUIActions() & 2) == 2;
   }

   @PSModelRTMeta(description = "支持界面删除", ignorert = 3)
   @Override
   public boolean isEnableUIRemove() {
      return (this.getEnableUIActions() & 4) == 4;
   }

   @PSModelRTMeta(description = "系统图片资源")
   @Override
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
         objectNode.put("getPSDataEntity", this.getPSDataEntity().getModelRef());
      }

      if (objectNode.has("getAllPSAppDEUIActionGroups")) {
         objectNode.remove("getAllPSAppDEUIActionGroups");
      }

      if (!objectNode.has("getAllPSAppDEUIActionGroups")) {
         ArrayNode arrayNode = objectNode.putArray("getAllPSAppDEUIActionGroups");
         Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = this.getAllPSAppDEUIActionGroups();
         if (psAppDEUIActionGroups != null) {
            while (psAppDEUIActionGroups.hasNext()) {
               arrayNode.add(psAppDEUIActionGroups.next().toModel("APPDATAENTITY"));
            }
         }

         if (arrayNode.size() == 0) {
            objectNode.remove("getAllPSAppDEUIActionGroups");
         }
      }
   }

   @PSModelRTMeta(description = "应用模块", ignorepf = true, dumpref = true, dynamodelmode = 8, from = "IPSApplication")
   @Override
   public IPSAppModule getPSAppModule() throws Exception {
      if (this.iPSAppModule == null && !StringHelper.isNullOrEmpty(this.getPSAppModuleId())) {
         this.iPSAppModule = this.getPSApplication().getPSAppModule(this.getPSAppModuleId());
      }

      return this.iPSAppModule;
   }

   @Override
   public String getPSAppModuleId() {
      return this.psAppLocalDE.getPSAPPMODULEID();
   }

   @PSModelRTMeta(description = "实体主状态集合", child = true, outputdoc = "false")
   @Override
   public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception {
      return this.getPSDataEntity().getAllPSDEMainStates();
   }

   @PSModelRTMeta(description = "实体操作标识集合", child = true, outputdoc = "false")
   @Override
   public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
      return this.getPSDataEntity().getAllPSDEOPPrivs();
   }

   @PSModelRTMeta(description = "实体名称", outputdoc = "false", ignorert = 2)
   @Override
   public String getPSDEName() {
      return this.getPSDataEntity().getName();
   }

   @PSModelRTMeta(description = "逻辑名称语言资源")
   @Override
   public IPSLanguageRes getLNPSLanguageRes() {
      return this.lnPSLanguageRes;
   }

   @PSModelRTMeta(description = "应用实体方法DTO对象集合", child = true, dynamodelmode = 4, group = "处理逻辑", order = 208)
   @Override
   public Iterator<IPSAppDEMethodDTO> getAllPSAppDEMethodDTOs() throws Exception {
      return this.psAppDEMethodDTOMap != null && this.psAppDEMethodDTOMap.size() != 0 ? this.psAppDEMethodDTOMap.values().iterator() : null;
   }

   @Override
   public IPSAppDEMethodDTO getPSAppDEMethodDTO(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
      for (Entry<String, IPSAppDEMethodDTO> entry : this.psAppDEMethodDTOMap.entrySet()) {
         IPSAppDEMethodDTO iPSAppDEMethodDTO = entry.getValue();
         if (iPSAppDEMethodDTO.getPSDEMethodDTO() != null
            && StringHelper.compare(iPSAppDEMethodDTO.getPSDEMethodDTO().getId(), iPSDEMethodDTO.getId(), false) == 0) {
            return iPSAppDEMethodDTO;
         }
      }

      PSAppDEMethodDTOImpl psAppDEMethodDTOImpl = new PSAppDEMethodDTOImpl();
      psAppDEMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodDTO);
      if (this.psAppDEMethodDTOMap.containsKey(psAppDEMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("应用实体中已存在代码标识为[%1$s]的方法DTO对象", psAppDEMethodDTOImpl.getCodeName()));
      }

      this.psAppDEMethodDTOMap.put(psAppDEMethodDTOImpl.getCodeName(), psAppDEMethodDTOImpl);
      return psAppDEMethodDTOImpl;
   }

   @PSModelRTMeta(description = "后端扩展插件", hideempty = true, ignorepf = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() throws Exception {
      if (this.iPSSysSFPlugin == null) {
         if (!StringHelper.isNullOrEmpty(this.psAppLocalDE.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psAppLocalDE.getPSSYSSFPLUGINID());
         } else if (!StringHelper.isNullOrEmpty(this.getPSApplication().getDEPSSysSFPluginId())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.getPSApplication().getDEPSSysSFPluginId());
         }
      }

      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "系统服务接口标记", hideempty = true)
   @Override
   public String getSysAPITag() {
      return this.getPSSysServiceAPI() != null ? this.getPSSysServiceAPI().getCodeName() : null;
   }

   @PSModelRTMeta(description = "服务接口代码标识模式", codelist = "CodeNameMode", dump = false)
   @Override
   public String getAPICodeNameMode() {
      return this.getPSSysServiceAPI() != null ? this.getPSSysServiceAPI().getAPICodeNameMode() : null;
   }

   @PSModelRTMeta(description = "实体服务接口标记", hideempty = true)
   @Override
   public String getDEAPITag() {
      return this.getPSDEServiceAPI() != null ? this.getPSDEServiceAPI().getName() : null;
   }

   @PSModelRTMeta(description = "实体服务接口代码标识", hideempty = true)
   @Override
   public String getDEAPICodeName() {
      if (this.getPSDEServiceAPI() != null) {
         String strCodeName = this.getPSDEServiceAPI().getCodeName();
         if (!StringHelper.isNullOrEmpty(strCodeName)) {
            if (StringHelper.isNullOrEmpty(this.getAPICodeNameMode()) || "NONE".equals(this.getAPICodeNameMode())) {
               strCodeName = strCodeName.toLowerCase();
            }

            return strCodeName;
         }
      }

      return null;
   }

   @PSModelRTMeta(description = "实体服务接口代码标识2（复数）", hideempty = true)
   @Override
   public String getDEAPICodeName2() {
      if (this.getPSDEServiceAPI() != null) {
         String strCodeName = this.getPSDEServiceAPI().getCodeName2();
         if (!StringHelper.isNullOrEmpty(strCodeName)) {
            if (StringHelper.isNullOrEmpty(this.getAPICodeNameMode()) || "NONE".equals(this.getAPICodeNameMode())) {
               strCodeName = strCodeName.toLowerCase();
            }

            return strCodeName;
         }
      }

      return null;
   }

   @PSModelRTMeta(
      description = "主状态属性集合",
      hideempty = true,
      child = true,
      dumpref = true,
      rtdump = 1,
      from = "__self__",
      dynamodelmode = 4,
      outputdoc = "false"
   )
   @Override
   public Iterator<IPSAppDEField> getMainStatePSAppDEFields() throws Exception {
      Iterator<IPSDEField> mainStatePSDEFields = this.getPSDataEntity().getMainStatePSDEFields();
      if (mainStatePSDEFields == null) {
         return null;
      }

      List<IPSAppDEField> psAppDEFieldList = new ArrayList<>();

      while (mainStatePSDEFields.hasNext()) {
         IPSAppDEField iPSAppDEField = this.getPSAppDEField(mainStatePSDEFields.next(), true);
         if (iPSAppDEField == null) {
            return null;
         }

         psAppDEFieldList.add(iPSAppDEField);
      }

      return psAppDEFieldList.size() == 0 ? null : psAppDEFieldList.iterator();
   }

   @PSModelRTMeta(description = "启用实体主状态", ignoredumpvalues = "false", doc = "计算当前实体是否存在主状态控制属性")
   @Override
   public boolean isEnableDEMainState() {
      try {
         return this.getMainStatePSAppDEFields() != null;
      } catch (Exception e) {
         return false;
      }
   }

   @PSModelRTMeta(description = "动态实例标记", hideempty2 = true)
   @Override
   public String getDynaInstTag() {
      return super.getDynaInstTag();
   }

   @PSModelRTMeta(description = "表单类型应用实体属性", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSAppDEField getFormTypePSAppDEField() throws Exception {
      IPSDEField iPSDEField = this.getPSDataEntity().getFormTypePSDEField();
      return iPSDEField != null ? this.getPSAppDEField(iPSDEField, true) : null;
   }

   @PSModelRTMeta(description = "数据类型应用实体属性", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSAppDEField getDataTypePSAppDEField() throws Exception {
      IPSDEField iPSDEField = this.getPSDataEntity().getDataTypePSDEField();
      return iPSDEField != null ? this.getPSAppDEField(iPSDEField, true) : null;
   }

   @PSModelRTMeta(description = "索引类型应用实体属性", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSAppDEField getIndexTypePSAppDEField() throws Exception {
      IPSDEField iPSDEField = this.getPSDataEntity().getIndexTypePSDEField();
      return iPSDEField != null ? this.getPSAppDEField(iPSDEField, true) : null;
   }

   @PSModelRTMeta(description = "组织标识应用实体属性", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSAppDEField getOrgIdPSAppDEField() throws Exception {
      IPSDEField iPSDEField = this.getPSDataEntity().getOrgIdPSDEField();
      return iPSDEField != null ? this.getPSAppDEField(iPSDEField, true) : null;
   }

   @Override
   public IPSAppDEReport getPSAppDEReport(String strAppDEReportId) throws Exception {
      return this.psAppDEReportGlobalModel.FindModelHelper(strAppDEReportId, false);
   }

   @Override
   public IPSAppDEReport getPSAppDEReport(String strAppDEReportId, boolean bTryMode) throws Exception {
      return this.psAppDEReportGlobalModel.FindModelHelper(strAppDEReportId, bTryMode);
   }

   @Override
   public void resetPSAppDEReport(String strAppDEReportId) throws Exception {
      this.psAppDEReportGlobalModel.ResetModel(strAppDEReportId);
   }

   @PSModelRTMeta(description = "应用实体打印集合", group = "处理逻辑", order = 199)
   @Override
   public Iterator<IPSAppDEReport> getAllPSAppDEReports() throws Exception {
      return this.psAppDEReportGlobalModel.getAllModelHelpers();
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      super.onFillModelRefNode(objectNode, strModelRefType);
      if (!StringHelper.isNullOrEmpty(strModelRefType)) {
         if ("DATAENTITY".equals(strModelRefType)) {
            objectNode.put("app", this.getPSApplication().getCodeName());
         }

         if ("APPLICATION".equals(strModelRefType)) {
            objectNode.put("name", this.getName());
            objectNode.put("codeName", this.getCodeName());
         }
      }
   }

   @PSModelRTMeta(description = "请求路径集合", child = true)
   @Override
   public String[] getRequestPaths() {
      return null;
   }

   @PSModelRTMeta(
      description = "联合键值属性集合",
      hideempty = true,
      child = true,
      dumpref = true,
      rtdump = 1,
      from = "__self__",
      dynamodelmode = 4,
      outputdoc = "false"
   )
   @Override
   public Iterator<IPSAppDEField> getUnionKeyValuePSAppDEFields() throws Exception {
      Iterator<IPSDEField> unionKeyValuePSDEFields = this.getPSDataEntity().getUnionKeyValuePSDEFields();
      if (unionKeyValuePSDEFields == null) {
         return null;
      }

      List<IPSAppDEField> psAppDEFieldList = new ArrayList<>();

      while (unionKeyValuePSDEFields.hasNext()) {
         IPSAppDEField iPSAppDEField = this.getPSAppDEField(unionKeyValuePSDEFields.next(), true);
         if (iPSAppDEField == null) {
            return null;
         }

         psAppDEFieldList.add(iPSAppDEField);
      }

      return psAppDEFieldList.size() == 0 ? null : psAppDEFieldList.iterator();
   }

   @PSModelRTMeta(description = "动态系统模式", codelist = "DEDynaSysMode", ignoredumpvalues = "0")
   @Override
   public int getDynaSysMode() {
      return this.getPSDataEntity().getDynaSysMode();
   }

   @PSModelRTMeta(description = "实体标识")
   @Override
   public String getDEName() {
      return !this.getPSDataEntity().getName().equals(this.getName()) ? this.getPSDataEntity().getName() : null;
   }

   @PSModelRTMeta(description = "实体代码标识")
   @Override
   public String getDECodeName() {
      return !this.getPSDataEntity().getCodeName().equals(this.getCodeName()) ? this.getPSDataEntity().getCodeName() : null;
   }

   @PSModelRTMeta(description = "实体完全标识")
   @Override
   public String getDEFullTag() {
      return null;
   }

   @PSModelRTMeta(description = "实体映射集合", child = true, group = "处理逻辑", order = 200)
   @Override
   public Iterator<IPSAppDEMap> getAllPSAppDEMaps() throws Exception {
      return this.psAppDEMapGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "应用实体默认统一资源", dump = false, fields = "PSSYSUNIRESID")
   @Override
   public IPSSysUniRes getPSSysUniRes() {
      return this.iPSSysUniRes;
   }
}
