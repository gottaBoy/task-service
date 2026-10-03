package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIImpl extends PSDataEntityObjectImpl implements IPSDEServiceAPI, IPSDEServiceAPIRuntime, IPSModelSortable {
   private static final Log log = LogFactory.getLog(PSDEServiceAPIImpl.class);
   private PSDEServiceAPI psDEServiceAPI;
   private ArrayList<IPSDEServiceAPIMethod> psDEServiceAPIMethodList = new ArrayList<>();
   private Map<String, IPSDEServiceAPIMethod> psDEServiceAPIMethodMap = new LinkedHashMap<>();
   private ArrayList<IPSDEServiceAPIField> psDEServiceAPIFieldList = new ArrayList<>();
   private Map<String, IPSDEServiceAPIField> psDEServiceAPIFieldMap = new LinkedHashMap<>();
   private ArrayList<IPSDEServiceAPIVR> psDEServiceAPIVRList = new ArrayList<>();
   protected String strCodeName = "";
   private String strCodeName2 = "";
   private IPSSysServiceAPI iPSSysServiceAPI = null;
   private boolean bEnableDEAction = false;
   private boolean bEnableSelect = false;
   private boolean bEnableDEDataSet = false;
   private boolean bEnableTempData = false;
   private IPSDEFGroup iPSDEFGroup = null;
   private String strDEFGroupMode = "";
   private int nAPIMode = 1;
   private ArrayList<IPSDEServiceAPIRS> majorPSDEServiceAPIRSList = null;
   private ArrayList<IPSDEServiceAPIRS> minorPSDEServiceAPIRSList = null;
   private Map<Integer, ArrayList<IPSDEServiceAPIRS>> psDEServiceAPIRSPathMap = null;
   private int nDataAccCtrlArch = 0;
   private int nDataAccCtrlMode = 0;
   private IPSDEServiceAPIField keyPSDEServiceAPIField = null;
   private IPSDEServiceAPIField majorPSDEServiceAPIField = null;
   private IPSSysSFPlugin iPSSysSFPlugin = null;
   private IPSSFXCodeObject iPSSFXCodeObject = null;
   private String strLogicName = "";
   private IPSLanguageRes lnPSLanguageRes = null;
   private boolean bEnableDataImport = true;
   private boolean bEnableDataExport = true;
   private String strServiceParam = null;
   private String strServiceParam2 = null;
   private IPSSysTranslator outPSSysTranslator = null;
   private IPSSysUniRes iPSSysUniRes = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysServiceAPI iPSSysServiceAPI, IPSDataEntity iPSDataEntity, PSDEServiceAPI psDEServiceAPI) throws Exception {
      try {
         this.setPSDataEntity(iPSDataEntity);
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.iPSSysServiceAPI = iPSSysServiceAPI;
         this.psDEServiceAPI = psDEServiceAPI;
         this.setId(psDEServiceAPI.getPSDESERVICEAPIID());
         this.setName(psDEServiceAPI.getPSDESERVICEAPINAME());
         this.setPSObjectData(this.psDEServiceAPI);
         if (!this.psDEServiceAPI.isDATAACCMODENull()) {
            this.nDataAccCtrlMode = this.psDEServiceAPI.getDATAACCMODE();
         } else {
            this.nDataAccCtrlMode = this.getPSDataEntity().getDataAccCtrlMode();
         }

         if (!this.psDEServiceAPI.isACCCTRLARCHNull()) {
            this.nDataAccCtrlArch = this.psDEServiceAPI.getACCCTRLARCH();
         } else {
            this.nDataAccCtrlArch = this.getPSDataEntity().getDataAccCtrlArch();
         }

         this.strLogicName = psDEServiceAPI.getLOGICNAME();
         if (StringHelper.IsNullOrEmpty(this.strLogicName)) {
            this.strLogicName = iPSDataEntity.getLogicName();
         }

         if (!StringHelper.IsNullOrEmpty(psDEServiceAPI.getLNPSLANRESID())) {
            this.lnPSLanguageRes = this.getPSSystem().getPSLanguageRes(psDEServiceAPI.getLNPSLANRESID());
         } else {
            this.lnPSLanguageRes = iPSDataEntity.getLNPSLanguageRes();
         }

         this.strCodeName = psDEServiceAPI.getCODENAME();
         if (StringHelper.IsNullOrEmpty(this.strCodeName)) {
            this.strCodeName = this.getPSSysServiceAPI().getAPICodeName(null, iPSDataEntity.getServiceCodeName(), null);
         }

         this.strCodeName2 = psDEServiceAPI.getCODENAME2();
         if (StringHelper.IsNullOrEmpty(this.strCodeName2)) {
            this.strCodeName2 = Inflector.getInstance().pluralize(this.strCodeName);
            this.strCodeName2 = this.getPSSysServiceAPI().getAPICodeName(null, this.strCodeName2, null);
         }

         if (!this.psDEServiceAPI.isENABLEDEACTIONNull()) {
            this.bEnableDEAction = this.psDEServiceAPI.getENABLEDEACTION();
         } else {
            this.bEnableDEAction = iPSDataEntity.isEnableSADEAction();
         }

         if (!this.psDEServiceAPI.isENABLESELECTNull()) {
            this.bEnableSelect = this.psDEServiceAPI.getENABLESELECT();
         } else {
            this.bEnableSelect = iPSDataEntity.isEnableSASelect();
         }

         if (!this.psDEServiceAPI.isENABLEDEDATASETNull()) {
            this.bEnableDEDataSet = this.psDEServiceAPI.getENABLEDEDATASET();
         } else {
            this.bEnableDEDataSet = iPSDataEntity.isEnableSADEDataSet();
         }

         if (!this.psDEServiceAPI.isENABLEDATAIMPORTNull()) {
            this.bEnableDataImport = this.psDEServiceAPI.getENABLEDATAIMPORT();
         }

         if (!this.psDEServiceAPI.isENABLEDATAEXPORTNull()) {
            this.bEnableDataExport = this.psDEServiceAPI.getENABLEDATAEXPORT();
         }

         this.bEnableTempData = this.getPSDataEntity().isEnableTempDataBackend();
         if (this.bEnableTempData && !this.psDEServiceAPI.isENATEMPDATANull()) {
            this.bEnableTempData = this.psDEServiceAPI.getENATEMPDATA();
         }

         if (!this.psDEServiceAPI.isMAJORFLAGNull()) {
            this.nAPIMode = this.psDEServiceAPI.getMAJORFLAG();
         } else if (this.getPSSysServiceAPI().isEnableAPIModelEx() && this.getPSDataEntity().getDataAccCtrlMode() == 2) {
            this.nAPIMode = 0;
         }

         if (!StringHelper.IsNullOrEmpty(this.psDEServiceAPI.getPSDEFGROUPID())) {
            this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEServiceAPI.getPSDEFGROUPID());
            this.strDEFGroupMode = this.psDEServiceAPI.getDEFGROUPMODE();
            if (StringHelper.IsNullOrEmpty(this.strDEFGroupMode)) {
               this.strDEFGroupMode = "REPLACE";
            }
         }

         if (!StringHelper.IsNullOrEmpty(this.psDEServiceAPI.getOUTPSSYSTRANSLATORID())) {
            this.outPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.psDEServiceAPI.getOUTPSSYSTRANSLATORID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psDEServiceAPI.getPSSYSUNIRESID())) {
            this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psDEServiceAPI.getPSSYSUNIRESID());
         } else {
            this.iPSSysUniRes = this.getPSDataEntity().getPSSysUniRes();
         }

         this.strServiceParam = this.psDEServiceAPI.getSERVICEPARAM();
         this.strServiceParam2 = this.psDEServiceAPI.getSERVICEPARAM2();
         this.onInit();
      } catch (Exception ex) {
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void onInit() throws Exception {
      super.onInit();
      this.onPreparePSDEServiceAPIFields();
      this.onPreparePSDEServiceAPIMethods();
      this.onPreparePSDEServiceAPIVRs();
   }

   protected void onPreparePSDEServiceAPIMethods() throws Exception {
      this.psDEServiceAPIMethodList.clear();
      this.psDEServiceAPIMethodMap.clear();
      if (!this.isNested()) {
         Vector<PSDESADetail> psDEServiceAPIMethodList = new Vector<>();
         CallResult callResult = this.getPSModelHelper().getPSDESADetails(this.getId(), psDEServiceAPIMethodList);
         if (callResult.isError()) {
            throw new Exception(StringHelper.Format("查询实体服务API方法集合发生错误, %1$s", callResult.getErrorInfo()));
         }

         for (PSDESADetail psDEServiceAPIMethod : psDEServiceAPIMethodList) {
            if (StringHelper.IsNullOrEmpty(psDEServiceAPIMethod.getPSDESARSID())) {
               if (psDEServiceAPIMethod.GetParamIntValue("VALIDFLAG", 1) == 0) {
                  this.psDEServiceAPIMethodMap.put(psDEServiceAPIMethod.getUNIQUETAG(), null);
               } else {
                  IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                  iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDEServiceAPIMethod);
                  this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                  this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                  this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getUniqueTag(), iPSDEServiceAPIMethod);
               }
            }
         }

         if (this.isEnableSelect()) {
            String strUniqueTag = StringHelper.Format("%1$s__SELECT", this.getCodeName()).toUpperCase();
            if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
               PSDESADetail psDESADetail = new PSDESADetail();
               psDESADetail.setPSDESADETAILID(strUniqueTag);
               psDESADetail.setDETAILTYPE("SELECT");
               if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                  psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
               } else {
                  psDESADetail.setREQUESTMETHOD("POST");
               }

               psDESADetail.setPSDESERVICEAPIID(this.getId());
               psDESADetail.setMETHODTAG("SELECT");
               psDESADetail.setCODENAME("Select");
               psDESADetail.setPSDESADETAILNAME("Select");
               psDESADetail.set("AUTOMODEL", 1);
               if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "GET", true) == 0) {
                  psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
               } else if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "POST", true) == 0) {
                  psDESADetail.setREQUESTPARAMTYPE("ENTITY");
               }

               IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
               iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
               this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
               this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
            }

            if (this.isEnableTempData()) {
               strUniqueTag = StringHelper.Format("%1$s__SELECTTEMP", this.getCodeName()).toUpperCase();
               if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
                  PSDESADetail psDESADetail = new PSDESADetail();
                  psDESADetail.setPSDESADETAILID(strUniqueTag);
                  psDESADetail.setDETAILTYPE("SELECTTEMP");
                  if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                     psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
                  } else {
                     psDESADetail.setREQUESTMETHOD("POST");
                  }

                  psDESADetail.setPSDESERVICEAPIID(this.getId());
                  psDESADetail.setMETHODTAG("SELECTTEMP");
                  psDESADetail.setCODENAME("SelectTemp");
                  psDESADetail.setPSDESADETAILNAME("SelectTemp");
                  psDESADetail.set("AUTOMODEL", 1);
                  if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "GET", true) == 0) {
                     psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
                  } else if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "POST", true) == 0) {
                     psDESADetail.setREQUESTPARAMTYPE("ENTITY");
                  }

                  IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                  iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                  this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                  this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
               }
            }
         }

         if (this.isEnableDEAction()) {
            Iterator<IPSDEAction> psDEActions = this.getPSDataEntity().getAllPSDEActions();

            while (psDEActions.hasNext()) {
               IPSDEAction iPSDEAction = psDEActions.next();
               if (iPSDEAction.isEnableBackend() && iPSDEAction.isPubServiceDefault()) {
                  String strUniqueTag = StringHelper.Format("%1$s__DEACTION__%2$s", this.getCodeName(), iPSDEAction.getName()).toUpperCase();
                  if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
                     PSDESADetail psDESADetail = new PSDESADetail();
                     psDESADetail.setPSDESADETAILID(strUniqueTag);
                     psDESADetail.setDETAILTYPE("DEACTION");
                     psDESADetail.setPSDEACTIONID(iPSDEAction.getId());
                     psDESADetail.setPSDEACTIONNAME(iPSDEAction.getName());
                     psDESADetail.setPSDESADETAILNAME(iPSDEAction.getCodeName());
                     psDESADetail.set("AUTOMODEL", 1);
                     String strRequestPath = iPSDEAction.getPSRESTfulAPI().getRequestPath();
                     if (!StringHelper.IsNullOrEmpty(strRequestPath)) {
                        strRequestPath = strRequestPath.trim();
                        strRequestPath = strRequestPath.replace("/", "");
                        psDESADetail.setCODENAME(strRequestPath);
                     } else if (!this.getPSSystem().isEnableModelRT() && !this.getPSSysServiceAPI().isEnableAPIModelEx()) {
                        if (StringHelper.Compare(iPSDEAction.getName(), "CREATE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "UPDATE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "REMOVE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "GET", true) != 0) {
                           psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                        } else {
                           psDESADetail.setNOSERVICECODENAME(true);
                        }
                     } else if (this.getPSSysServiceAPI().isResetDefaultActionCodeName()) {
                        if (StringHelper.Compare(iPSDEAction.getName(), "CREATE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "UPDATE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "REMOVE", true) != 0
                           && StringHelper.Compare(iPSDEAction.getName(), "GET", true) != 0) {
                           psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                        } else {
                           psDESADetail.setNOSERVICECODENAME(true);
                        }
                     } else {
                        psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                     }

                     if (iPSDEAction.getPSRESTfulAPI() instanceof IPSDEActionRESTfulAPI) {
                        IPSDEActionRESTfulAPI iPSDEActionRESTfulAPI = (IPSDEActionRESTfulAPI)iPSDEAction.getPSRESTfulAPI();
                        psDESADetail.setREQUESTPARAMTYPE(iPSDEActionRESTfulAPI.getRequestParamType());
                        psDESADetail.setREQUESTFIELD(iPSDEActionRESTfulAPI.getRequestField());
                     }

                     if (!StringHelper.IsNullOrEmpty(iPSDEAction.getPSRESTfulAPI().getRequestMethod())) {
                        psDESADetail.setREQUESTMETHOD(iPSDEAction.getPSRESTfulAPI().getRequestMethod());
                     } else {
                        String strRequestMethod = null;
                        if (this.getPSSysServiceAPI().isEnableAPIModelEx()) {
                           String strActionMode = iPSDEAction.getActionMode();
                           if ("CREATE".equals(strActionMode)) {
                              strRequestMethod = this.getPSSysServiceAPI().getCreateReqMethod("POST");
                           } else if ("UPDATE".equals(strActionMode)) {
                              strRequestMethod = this.getPSSysServiceAPI().getUpdateReqMethod("PUT");
                           } else if ("READ".equals(strActionMode)) {
                              strRequestMethod = this.getPSSysServiceAPI().getGetReqMethod("GET");
                           } else if ("DELETE".equals(strActionMode)) {
                              strRequestMethod = this.getPSSysServiceAPI().getDeleteReqMethod("DELETE");
                           } else {
                              String strPSDEActionName = iPSDEAction.getName().toUpperCase();
                              if (strPSDEActionName.indexOf("CREATE") != -1) {
                                 strRequestMethod = this.getPSSysServiceAPI().getCreateReqMethod("POST");
                              } else if (strPSDEActionName.indexOf("UPDATE") != -1) {
                                 strRequestMethod = this.getPSSysServiceAPI().getUpdateReqMethod("PUT");
                              } else if (strPSDEActionName.indexOf("GET") != -1) {
                                 strRequestMethod = this.getPSSysServiceAPI().getGetReqMethod("GET");
                              } else if (strPSDEActionName.indexOf("REMOVE") != -1) {
                                 strRequestMethod = this.getPSSysServiceAPI().getDeleteReqMethod("DELETE");
                              } else if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultDEActionReqMethod())) {
                                 strRequestMethod = this.getPSSysServiceAPI().getDefaultDEActionReqMethod();
                              } else {
                                 strRequestMethod = "POST";
                              }
                           }
                        } else {
                           String strPSDEActionName = iPSDEAction.getName().toUpperCase();
                           if (strPSDEActionName.indexOf("CREATE") != -1) {
                              strRequestMethod = this.getPSSysServiceAPI().getCreateReqMethod("POST");
                           } else if (strPSDEActionName.indexOf("UPDATE") != -1) {
                              strRequestMethod = this.getPSSysServiceAPI().getUpdateReqMethod("PUT");
                           } else if (strPSDEActionName.indexOf("GET") != -1) {
                              strRequestMethod = this.getPSSysServiceAPI().getGetReqMethod("GET");
                           } else if (strPSDEActionName.indexOf("REMOVE") != -1) {
                              strRequestMethod = this.getPSSysServiceAPI().getDeleteReqMethod("DELETE");
                           } else if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultDEActionReqMethod())) {
                              strRequestMethod = this.getPSSysServiceAPI().getDefaultDEActionReqMethod();
                           } else {
                              strRequestMethod = "POST";
                           }
                        }

                        psDESADetail.setREQUESTMETHOD(strRequestMethod);
                     }

                     psDESADetail.setPSDESERVICEAPIID(this.getId());
                     psDESADetail.setMETHODTAG(StringHelper.Format("DEACTION__%1$s", iPSDEAction.getName()).toUpperCase());
                     IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                     iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                     this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                     this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                  }
               }
            }
         }

         if (this.isEnableDEDataSet()) {
            Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();

            while (psDEDataSets.hasNext()) {
               IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
               if (iPSDEDataSet.isEnableBackend() && iPSDEDataSet.isPubServiceDefault()) {
                  String strUniqueTag = StringHelper.Format("%1$s__FETCH__%2$s", this.getCodeName(), iPSDEDataSet.getName()).toUpperCase();
                  if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
                     PSDESADetail psDESADetail = new PSDESADetail();
                     psDESADetail.setPSDESADETAILID(strUniqueTag);
                     psDESADetail.setDETAILTYPE("FETCH");
                     psDESADetail.setPSDEDSID(iPSDEDataSet.getId());
                     psDESADetail.setPSDEDSNAME(iPSDEDataSet.getName());
                     psDESADetail.set("AUTOMODEL", 1);
                     String strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                     if (!StringHelper.IsNullOrEmpty(strRequestPath)) {
                        strRequestPath = strRequestPath.trim();
                        strRequestPath = strRequestPath.replace("/", "");
                        psDESADetail.setCODENAME(strRequestPath);
                     } else {
                        psDESADetail.setCODENAME(iPSDEDataSet.getServiceCodeName());
                     }

                     if (!StringHelper.IsNullOrEmpty(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                        psDESADetail.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                     } else if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod())) {
                        psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod());
                     } else {
                        psDESADetail.setREQUESTMETHOD("POST");
                     }

                     if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "GET", true) == 0) {
                        psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
                     } else if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "POST", true) == 0) {
                        psDESADetail.setREQUESTPARAMTYPE("ENTITY");
                     }

                     psDESADetail.setPSDESADETAILNAME(psDESADetail.getCODENAME());
                     psDESADetail.setPSDESERVICEAPIID(this.getId());
                     psDESADetail.setMETHODTAG(StringHelper.Format("FETCH__%1$s", iPSDEDataSet.getName()).toUpperCase());
                     IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                     iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                     this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                     this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                  }

                  if (this.isEnableTempData() && iPSDEDataSet.isEnableTempData()) {
                     strUniqueTag = StringHelper.Format("%1$s__FETCHTEMP__%2$s", this.getCodeName(), iPSDEDataSet.getName()).toUpperCase();
                     if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
                        PSDESADetail psDESADetail = new PSDESADetail();
                        psDESADetail.setPSDESADETAILID(strUniqueTag);
                        psDESADetail.setDETAILTYPE("FETCHTEMP");
                        psDESADetail.setPSDEDSID(iPSDEDataSet.getId());
                        psDESADetail.setPSDEDSNAME(iPSDEDataSet.getName());
                        psDESADetail.set("AUTOMODEL", 1);
                        String strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                        if (!StringHelper.IsNullOrEmpty(strRequestPath)) {
                           strRequestPath = strRequestPath.trim();
                           strRequestPath = strRequestPath.replace("/", "");
                           psDESADetail.setCODENAME(strRequestPath);
                        } else {
                           psDESADetail.setCODENAME(String.format("%1$s%2$s", "FetchTemp", PSModelCodeNameUtils.capitalize(iPSDEDataSet.getCodeName())));
                        }

                        if (!StringHelper.IsNullOrEmpty(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                           psDESADetail.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                        } else if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod())) {
                           psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod());
                        } else {
                           psDESADetail.setREQUESTMETHOD("POST");
                        }

                        if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "GET", true) == 0) {
                           psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
                        } else if (StringHelper.Compare(psDESADetail.getREQUESTMETHOD(), "POST", true) == 0) {
                           psDESADetail.setREQUESTPARAMTYPE("ENTITY");
                        }

                        psDESADetail.setPSDESADETAILNAME(psDESADetail.getCODENAME());
                        psDESADetail.setPSDESERVICEAPIID(this.getId());
                        psDESADetail.setMETHODTAG(StringHelper.Format("FETCHTEMP__%1$s", iPSDEDataSet.getName()).toUpperCase());
                        IPSDEServiceAPIMethod iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                        iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                        this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                        this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                     }
                  }
               }
            }
         }

         if (this.psDEServiceAPIMethodList != null && this.psDEServiceAPIMethodList.size() != 0) {
            Collections.sort(
               this.psDEServiceAPIMethodList,
               new Comparator<IPSDEServiceAPIMethod>() {
                  public int compare(IPSDEServiceAPIMethod o1, IPSDEServiceAPIMethod o2) {
                     int nRet = o1.getMethodType().compareTo(o2.getMethodType());
                     if (nRet != 0) {
                        return nRet;
                     } else {
                        return StringHelper.IsNullOrEmpty(o1.getCodeName())
                              && StringHelper.IsNullOrEmpty(o2.getCodeName())
                              && o1.getPSDEAction() != null
                              && o2.getPSDEAction() != null
                           ? net.ibizsys.paas.util.StringHelper.compare(o1.getPSDEAction().getCodeName(), o2.getPSDEAction().getCodeName(), false)
                           : net.ibizsys.paas.util.StringHelper.compare(o1.getCodeName(), o2.getCodeName(), false);
                     }
                  }
               }
            );
         }
      }
   }

   protected void onPreparePSDEServiceAPIFields() throws Exception {
      this.psDEServiceAPIFieldList.clear();
      this.psDEServiceAPIFieldMap.clear();
      if (this.getPSDEFGroup() != null) {
         Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
         if (psDEFGroupDetails != null) {
            if (StringHelper.Compare(this.getDEFGroupMode(), "REPLACE", true) == 0) {
               while (psDEFGroupDetails.hasNext()) {
                  IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                  PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
                  psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                  this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
               }
            } else {
               Map<String, IPSDEFGroupDetail> psDEFGroupDetailMap = new LinkedHashMap<>();

               while (psDEFGroupDetails.hasNext()) {
                  IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                  psDEFGroupDetailMap.put(iPSDEFGroupDetail.getPSDEField().getId(), iPSDEFGroupDetail);
               }

               Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
               if (psDEFields != null) {
                  boolean bOverwrite = false;
                  if (StringHelper.Compare(this.getDEFGroupMode(), "OVERWRITE", true) == 0) {
                     bOverwrite = true;
                  }

                  while (psDEFields.hasNext()) {
                     IPSDEField iPSDEField = psDEFields.next();
                     IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetailMap.get(iPSDEField.getId());
                     if (iPSDEFGroupDetail != null) {
                        if (bOverwrite) {
                           PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
                           psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                           this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
                        }
                     } else {
                        PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
                        psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
                        this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
                     }
                  }
               }
            }

            Collections.sort(this.psDEServiceAPIFieldList, new Comparator<IPSDEServiceAPIField>() {
               public int compare(IPSDEServiceAPIField arg0, IPSDEServiceAPIField arg1) {
                  int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                  return nValue == 0 ? arg0.getName().compareTo(arg1.getName()) : new Integer(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
               }
            });
         }
      } else {
         Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
         if (psDEFields != null) {
            while (psDEFields.hasNext()) {
               IPSDEField iPSDEField = psDEFields.next();
               PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
               psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
               this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
            }
         }
      }

      for (IPSDEServiceAPIField iPSDEServiceAPIField : this.psDEServiceAPIFieldList) {
         if (iPSDEServiceAPIField.isMajorField()) {
            this.majorPSDEServiceAPIField = iPSDEServiceAPIField;
         }

         if (iPSDEServiceAPIField.isKeyField()) {
            this.keyPSDEServiceAPIField = iPSDEServiceAPIField;
         }

         this.psDEServiceAPIFieldMap.put(iPSDEServiceAPIField.getId(), iPSDEServiceAPIField);
         this.psDEServiceAPIFieldMap.put(iPSDEServiceAPIField.getName(), iPSDEServiceAPIField);
      }
   }

   protected void onPreparePSDEServiceAPIVRs() throws Exception {
      this.psDEServiceAPIVRList.clear();
      Vector<PSDESAVR> psDEServiceAPIVRList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDESAVRs(this.getId(), psDEServiceAPIVRList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询实体服务API值规则集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      for (PSDESAVR psDEServiceAPIVR : psDEServiceAPIVRList) {
         IPSDEServiceAPIVR iPSDEServiceAPIVR = new PSDEServiceAPIVRImpl();
         iPSDEServiceAPIVR.init(this.getDAGlobalHelper(), this, psDEServiceAPIVR);
         this.psDEServiceAPIVRList.add(iPSDEServiceAPIVR);
      }
   }

   @PSModelRTMeta(description = "接口方法集合", child = true, group = "逻辑", order = 330)
   @Override
   public Iterator<IPSDEServiceAPIMethod> getPSDEServiceAPIMethods() {
      return this.psDEServiceAPIMethodList.iterator();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.strCodeName;
   }

   @PSModelRTMeta(description = "代码标识2（复数）")
   @Override
   public String getCodeName2() {
      return this.strCodeName2;
   }

   @Override
   public String getModelType() {
      return "PSDESERVICEAPI";
   }

   @Override
   public String getModelId() {
      try {
         return StringHelper.Format("%1$s#%2$s", this.getPSSysServiceAPI().getModelId(), super.getModelId());
      } catch (Exception ex) {
         return "";
      }
   }

   @Override
   public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String strPSDEServiceAPIMethodId) throws Exception {
      return this.getPSDEServiceAPIMethod(strPSDEServiceAPIMethodId, false);
   }

   @Override
   public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String strPSDEServiceAPIMethodId, boolean bTryMode) throws Exception {
      IPSDEServiceAPIMethod iPSDEServiceAPIMethod = this.psDEServiceAPIMethodMap.get(strPSDEServiceAPIMethodId);
      if (iPSDEServiceAPIMethod == null && !bTryMode) {
         throw PSDEServiceAPIException.create(this, 20020, strPSDEServiceAPIMethodId);
      } else {
         return iPSDEServiceAPIMethod;
      }
   }

   @PSModelRTMeta(description = "系统服务接口")
   @Override
   public IPSSysServiceAPI getPSSysServiceAPI() throws Exception {
      if (this.iPSSysServiceAPI == null) {
         this.iPSSysServiceAPI = this.getPSDataEntity().getPSSystem().getPSSysServiceAPI(this.psDEServiceAPI.getPSSYSSERVICEAPIID());
      }

      return this.iPSSysServiceAPI;
   }

   @PSModelRTMeta(description = "默认支持实体行为", dump = false)
   @Override
   public boolean isEnableDEAction() {
      return !this.isNested() && this.bEnableDEAction;
   }

   @PSModelRTMeta(description = "默认支持简单查询", dump = false)
   @Override
   public boolean isEnableSelect() {
      try {
         return !this.isNested() && this.bEnableSelect && !this.getPSSysServiceAPI().isEnableAPIModelEx();
      } catch (Exception ex) {
         log.error(ex);
         return false;
      }
   }

   @PSModelRTMeta(description = "默认支持结果集查询", dump = false)
   @Override
   public boolean isEnableDEDataSet() {
      return !this.isNested() && this.bEnableDEDataSet;
   }

   @PSModelRTMeta(description = "支持临时数据", ignoredumpvalues = "false", dump = false)
   @Override
   public boolean isEnableTempData() {
      try {
         return this.bEnableTempData && !this.getPSSysServiceAPI().isEnableAPIModelEx();
      } catch (Exception ex) {
         log.error(ex);
         return false;
      }
   }

   @Override
   public String getHandler() {
      try {
         return this.getPSSysServiceAPI().getHandler();
      } catch (Exception ex) {
         log.error(ex.getMessage());
         return null;
      }
   }

   @PSModelRTMeta(description = "服务接口属性集合", child = true, dynamodelmode = 8, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIField> getPSDEServiceAPIFields() {
      return this.psDEServiceAPIFieldList.iterator();
   }

   @Override
   public IPSDEServiceAPIField getPSDEServiceAPIField(String strPSDEFieldId) throws Exception {
      return this.getPSDEServiceAPIField(strPSDEFieldId, false);
   }

   @Override
   public IPSDEServiceAPIField getPSDEServiceAPIField(String strPSDEFieldId, boolean bTryMode) throws Exception {
      IPSDEServiceAPIField iPSDEServiceAPIField = this.psDEServiceAPIFieldMap.get(strPSDEFieldId);
      if (iPSDEServiceAPIField == null && !bTryMode) {
         throw PSDEServiceAPIException.create(this, 20023, strPSDEFieldId);
      } else {
         return iPSDEServiceAPIField;
      }
   }

   @PSModelRTMeta(description = "属性组对象")
   @Override
   public IPSDEFGroup getPSDEFGroup() {
      return this.iPSDEFGroup;
   }

   @PSModelRTMeta(description = "主接口")
   @Override
   public boolean isMajor() {
      return this.nAPIMode == 1;
   }

   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs(boolean bMajor) {
      try {
         Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSSysServiceAPI().getPSDEServiceAPIRSs();
         if (psDEServiceAPIRSs == null) {
            return null;
         }

         if (bMajor) {
            if (this.majorPSDEServiceAPIRSList == null) {
               ArrayList<IPSDEServiceAPIRS> list = new ArrayList<>();

               while (psDEServiceAPIRSs.hasNext()) {
                  IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                  if (StringHelper.Compare(iPSDEServiceAPIRS.getPPSDEServiceAPIId(), this.getId(), true) == 0) {
                     list.add(iPSDEServiceAPIRS);
                  }
               }

               if (this.majorPSDEServiceAPIRSList == null) {
                  PSModelUtil.sort(list);
                  this.majorPSDEServiceAPIRSList = list;
               }
            }

            return this.majorPSDEServiceAPIRSList.iterator();
         } else {
            if (this.minorPSDEServiceAPIRSList == null) {
               ArrayList<IPSDEServiceAPIRS> list = new ArrayList<>();

               while (psDEServiceAPIRSs.hasNext()) {
                  IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                  if (StringHelper.Compare(iPSDEServiceAPIRS.getCPSDEServiceAPIId(), this.getId(), true) == 0) {
                     list.add(iPSDEServiceAPIRS);
                  }
               }

               if (this.minorPSDEServiceAPIRSList == null) {
                  PSModelUtil.sort(list);
                  this.minorPSDEServiceAPIRSList = list;
               }
            }

            return this.minorPSDEServiceAPIRSList.iterator();
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs() {
      return this.getPSDEServiceAPIRSs(true);
   }

   @PSModelRTMeta(description = "接口主关系集合", child = true, dumpref = true, ignorert = 3, dynamodelmode = 8, from = "IPSSysServiceAPI", group = "逻辑", order = 332)
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getMajorPSDEServiceAPIRSs() {
      return this.getPSDEServiceAPIRSs(true);
   }

   @PSModelRTMeta(description = "接口从关系集合", child = true, dumpref = true, rtdump = 2, dynamodelmode = 8, from = "IPSSysServiceAPI", group = "逻辑", order = 334)
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getMinorPSDEServiceAPIRSs() {
      return this.getPSDEServiceAPIRSs(false);
   }

   @PSModelRTMeta(description = "接口关系路径数量", dump = false, outputdoc = "false")
   @Override
   public int getPSDEServiceAPIRSPathCount() throws Exception {
      this.preparePSDEServiceAPIRSPaths();
      return this.psDEServiceAPIRSPathMap == null ? 0 : this.psDEServiceAPIRSPathMap.size();
   }

   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath(int nPathIndex) throws Exception {
      this.preparePSDEServiceAPIRSPaths();
      if (this.psDEServiceAPIRSPathMap == null) {
         return null;
      }

      ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
      return list == null ? null : list.iterator();
   }

   protected synchronized void preparePSDEServiceAPIRSPaths() throws Exception {
      synchronized (this) {
         if (this.psDEServiceAPIRSPathMap == null) {
            this.psDEServiceAPIRSPathMap = new LinkedHashMap<>();
            if (!this.isNested()) {
               Iterator<? extends IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSDEServiceAPIRSs(false);
               if (psDEServiceAPIRSs != null) {
                  while (psDEServiceAPIRSs.hasNext()) {
                     IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                     if (StringHelper.Compare(iPSDEServiceAPIRS.getPPSDEServiceAPIId(), iPSDEServiceAPIRS.getCPSDEServiceAPIId(), false) != 0) {
                        ArrayList<IPSDEServiceAPIRS> list = new ArrayList<>();
                        int nIndex = this.psDEServiceAPIRSPathMap.size();
                        this.psDEServiceAPIRSPathMap.put(nIndex, list);
                        this.fillPSDEServiceAPIRSPath(iPSDEServiceAPIRS, list);
                     }
                  }

                  if (this.psDEServiceAPIRSPathMap.size() > 1) {
                     ArrayList<ArrayList<IPSDEServiceAPIRS>> list = new ArrayList<>();
                     list.addAll(this.psDEServiceAPIRSPathMap.values());
                     Collections.sort(list, new Comparator<ArrayList<IPSDEServiceAPIRS>>() {
                        public int compare(ArrayList<IPSDEServiceAPIRS> arg0, ArrayList<IPSDEServiceAPIRS> arg1) {
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
                     this.psDEServiceAPIRSPathMap.clear();

                     for (int i = 0; i < list.size(); i++) {
                        this.psDEServiceAPIRSPathMap.put(i, list.get(i));
                     }
                  }
               }
            }
         }
      }
   }

   protected synchronized void fillPSDEServiceAPIRSPath(IPSDEServiceAPIRS iPSDEServiceAPIRS, ArrayList<IPSDEServiceAPIRS> list) throws Exception {
      for (IPSDEServiceAPIRS tempPSDEServiceAPIRS : list) {
         if (StringHelper.Compare(iPSDEServiceAPIRS.getId(), tempPSDEServiceAPIRS.getId(), false) == 0) {
            throw new Exception(StringHelper.Format("实体服务接口[%1$s]存在递归引用关系[%2$s]", this.getName(), iPSDEServiceAPIRS.getName()));
         }
      }

      list.add(0, iPSDEServiceAPIRS);
      Iterator<? extends IPSDEServiceAPIRS> majorList = iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getPSDEServiceAPIRSs(false);
      if (majorList != null) {
         ArrayList<IPSDEServiceAPIRS> srcList = new ArrayList<>();
         srcList.addAll(list);
         int nIndex = 0;

         while (majorList.hasNext()) {
            IPSDEServiceAPIRS tempPSDEServiceAPIRS = majorList.next();
            if (StringHelper.Compare(tempPSDEServiceAPIRS.getPPSDEServiceAPIId(), tempPSDEServiceAPIRS.getCPSDEServiceAPIId(), false) != 0) {
               if (nIndex == 0) {
                  if (iPSDEServiceAPIRS.getMajorPSDEServiceAPI().isMajor()) {
                     ArrayList<IPSDEServiceAPIRS> list2 = new ArrayList<>();
                     list2.addAll(srcList);
                     int nIndex2 = this.psDEServiceAPIRSPathMap.size();
                     this.psDEServiceAPIRSPathMap.put(nIndex2, list2);
                  }

                  this.fillPSDEServiceAPIRSPath(tempPSDEServiceAPIRS, list);
               } else {
                  ArrayList<IPSDEServiceAPIRS> list2 = new ArrayList<>();
                  list2.addAll(srcList);
                  int nIndex2 = this.psDEServiceAPIRSPathMap.size();
                  this.psDEServiceAPIRSPathMap.put(nIndex2, list2);
                  this.fillPSDEServiceAPIRSPath(tempPSDEServiceAPIRS, list2);
               }

               nIndex++;
            }
         }
      }
   }

   @Override
   public int check() throws Exception {
      return super.check();
   }

   @Override
   protected int onCheck() throws Exception {
      this.getPSDEServiceAPIRSPathCount();
      int nRet = 0;
      Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = this.getPSDEServiceAPIMethods();
      if (psDEServiceAPIMethods != null) {
         while (psDEServiceAPIMethods.hasNext()) {
            IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
            nRet += iPSDEServiceAPIMethod.check();
         }
      }

      return nRet + super.onCheck();
   }

   @Override
   public IPSDEServiceAPIRS getPSDEServiceAPIRSPathFirst(int nPathIndex) throws Exception {
      this.preparePSDEServiceAPIRSPaths();
      if (this.psDEServiceAPIRSPathMap == null) {
         return null;
      }

      ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
      return list != null && list.size() != 0 ? list.get(0) : null;
   }

   @Override
   public IPSDEServiceAPIRS getPSDEServiceAPIRSPathLast(int nPathIndex) throws Exception {
      this.preparePSDEServiceAPIRSPaths();
      if (this.psDEServiceAPIRSPathMap == null) {
         return null;
      }

      ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
      return list != null && list.size() != 0 ? list.get(list.size() - 1) : null;
   }

   @PSModelRTMeta(description = "属性组使用模式", codelist = "DESADEFGroupMode", hideempty2 = true, dump = false)
   @Override
   public String getDEFGroupMode() {
      return this.strDEFGroupMode;
   }

   @PSModelRTMeta(description = "接口值规则集合", outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIVR> getPSDEServiceAPIVRs() {
      return this.psDEServiceAPIVRList.iterator();
   }

   @PSModelRTMeta(description = "接口关系路径[0]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath0() throws Exception {
      return this.getPSDEServiceAPIRSPath(0);
   }

   @PSModelRTMeta(description = "接口关系路径[1]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath1() throws Exception {
      return this.getPSDEServiceAPIRSPath(1);
   }

   @PSModelRTMeta(description = "接口关系路径[2]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath2() throws Exception {
      return this.getPSDEServiceAPIRSPath(2);
   }

   @PSModelRTMeta(description = "接口关系路径[3]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath3() throws Exception {
      return this.getPSDEServiceAPIRSPath(3);
   }

   @PSModelRTMeta(description = "接口关系路径[4]", hideempty = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath4() throws Exception {
      return this.getPSDEServiceAPIRSPath(4);
   }

   @PSModelRTMeta(description = "实体访问控制体系", codelist = "AccCtrlArch", dump = false)
   @Override
   public int getDataAccCtrlArch() {
      return this.nDataAccCtrlArch;
   }

   @PSModelRTMeta(description = "实体数据访问控制方式", codelist = "DEDataAccCtrlMode", dump = false)
   @Override
   public int getDataAccCtrlMode() {
      return this.nDataAccCtrlMode;
   }

   @PSModelRTMeta(description = "主键属性")
   @Override
   public IPSDEServiceAPIField getKeyPSDEServiceAPIField() {
      return this.keyPSDEServiceAPIField;
   }

   @PSModelRTMeta(description = "主信息属性")
   @Override
   public IPSDEServiceAPIField getMajorPSDEServiceAPIField() {
      return this.majorPSDEServiceAPIField;
   }

   @PSModelRTMeta(description = "接口模式", codelist = "DESAMode", group = "基本", order = 125, fields = "MAJORFLAG")
   @Override
   public int getAPIMode() {
      return this.nAPIMode;
   }

   @PSModelRTMeta(description = "嵌套成员", ignoredumpvalues = "false")
   @Override
   public boolean isNested() {
      return this.nAPIMode == 9;
   }

   @PSModelRTMeta(description = "后端扩展插件", hideempty = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() throws Exception {
      if (this.iPSSysSFPlugin == null) {
         if (!StringHelper.IsNullOrEmpty(this.psDEServiceAPI.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psDEServiceAPI.getPSSYSSFPLUGINID());
         } else if (!StringHelper.IsNullOrEmpty(this.getPSSysServiceAPI().getDEPSSysSFPluginId())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.getPSSysServiceAPI().getDEPSSysSFPluginId());
         }
      }

      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "绘制器", hideempty = true)
   @Override
   public IPSSFXCodeObject getRender() throws Exception {
      if (this.iPSSFXCodeObject == null && this.getPSSysSFPlugin() != null) {
         String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysSFPlugin().getId(), this.getPSSystem().getPSSFId());
         IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
         if (iPSSysSFPluginTempl != null) {
            this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
         }
      }

      return this.iPSSFXCodeObject;
   }

   @PSModelRTMeta(description = "逻辑名称", fields = "LOGICNAME")
   @Override
   public String getLogicName() {
      return this.strLogicName;
   }

   @PSModelRTMeta(description = "逻辑名称语言资源")
   @Override
   public IPSLanguageRes getLNPSLanguageRes() {
      return this.lnPSLanguageRes;
   }

   @Override
   public List<PSDESARS> getAutoPSDESARSs() throws Exception {
      String strDEBizTag = this.getPSDataEntity().getBizTag();
      if (StringHelper.IsNullOrEmpty(strDEBizTag)) {
         return null;
      }

      List<PSDESARS> list = new ArrayList<>();
      if (StringHelper.Compare(strDEBizTag, "DATAAUDIT", false) != 0) {
         return null;
      }

      Iterator<IPSDEServiceAPI> psDEServceAPIs = this.getPSSysServiceAPI().getPSDEServiceAPIs();
      if (psDEServceAPIs != null) {
         while (psDEServceAPIs.hasNext()) {
            IPSDEServiceAPI iPSDEServiceAPI = psDEServceAPIs.next();
            if (iPSDEServiceAPI.getAPIMode() != 9 && iPSDEServiceAPI.getPSDataEntity().getAuditMode() != 0) {
               IPSDEUtil iPSDEUtil = iPSDEServiceAPI.getPSDataEntity().getPSDEUtil("DATAAUDIT", true);
               if (iPSDEUtil != null && StringHelper.Compare(iPSDEUtil.getUtilPSDEId(), this.getPSDataEntity().getId(), false) == 0) {
                  PSDESARS psDESARS = new PSDESARS();
                  psDESARS.setPSDESARSID(KeyValueHelper.genUniqueId("DATAAUDIT", iPSDEServiceAPI.getId(), this.getId()));
                  psDESARS.setPSDESARSNAME(StringHelper.Format("DATAAUDIT__%1$s__%2$s", iPSDEServiceAPI.getName(), this.getName()));
                  psDESARS.setPPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                  psDESARS.setPPSDESERVICEAPINAME(iPSDEServiceAPI.getName());
                  psDESARS.setCPSDESERVICEAPIID(this.getId());
                  psDESARS.setCPSDESERVICEAPINAME(this.getName());
                  psDESARS.setVALIDFLAG(true);
                  psDESARS.set("AUTOMODEL", 1);
                  list.add(psDESARS);
               }
            }
         }
      }

      return list.size() != 0 ? list : null;
   }

   @PSModelRTMeta(description = "实体对象", dumpref = true)
   @Override
   public IPSDataEntity getPSDataEntity() {
      return this.iPSDataEntity;
   }

   @Override
   protected String onGetDynaModelFolder() {
      return null;
   }

   @PSModelRTMeta(description = "支持数据导入", ignoredumpvalues = "false")
   @Override
   public boolean isEnableDataImport() {
      return this.bEnableDataImport;
   }

   @PSModelRTMeta(description = "支持数据导出", ignoredumpvalues = "false")
   @Override
   public boolean isEnableDataExport() {
      return this.bEnableDataExport;
   }

   @PSModelRTMeta(description = "重定向外部服务接口实体对象", hideempty = true, doc = "指向实际的服务对象")
   @Override
   public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception {
      return this.getPSDataEntity().getPSSubSysServiceAPIDE();
   }

   @PSModelRTMeta(description = "服务参数", fields = "SERVICEPARAM")
   @Override
   public String getServiceParam() {
      return this.strServiceParam;
   }

   @PSModelRTMeta(description = "服务参数2", fields = "SERVICEPARAM2")
   @Override
   public String getServiceParam2() {
      return this.strServiceParam2;
   }

   @PSModelRTMeta(description = "输出值转换器", dumpref = true, ignorepf = true, fields = "OUTPSSYSTRANSLATORID")
   @Override
   public IPSSysTranslator getOutPSSysTranslator() {
      return this.outPSSysTranslator;
   }

   @PSModelRTMeta(description = "实体服务接口统一资源", dumpref = true, ignorepf = true, fields = "PSSYSUNIRESID")
   @Override
   public IPSSysUniRes getPSSysUniRes() {
      return this.iPSSysUniRes;
   }

   @Override
   public int getOrderValue() {
      return !this.psDEServiceAPI.isORDERVALUENull() && this.psDEServiceAPI.getORDERVALUE() >= 0 ? this.psDEServiceAPI.getORDERVALUE() : 99999;
   }

   @Override
   protected IPSModelObject onGetParentModel() {
      try {
         return this.getPSSysServiceAPI();
      } catch (Exception e) {
         return super.onGetParentModel();
      }
   }
}
