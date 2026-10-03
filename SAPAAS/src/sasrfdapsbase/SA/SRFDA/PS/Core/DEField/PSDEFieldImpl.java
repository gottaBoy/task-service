package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.Search.PSDEFSearchGlobalModel;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDEFieldImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldImpl extends PSDataEntityObjectImpl implements IPSDEField, IPSDataEntityObject, IPSDEFieldRuntime {
   private static final Log log = LogFactory.getLog(PSDEFieldImpl.class);
   public static final String MODELGROUP_LOGIC = "处理逻辑";
   public static final String MODELGROUP_SEARCH = "搜索逻辑";
   public static final String MODELGROUP_PERSISTENT = "持久化";
   public static final String MODELGROUP_DB = "数据库存储";
   public static final String MODELGROUP_VALUERULE = "值规则";
   public static final String MODELGROUP_DER = "关系";
   public static final String MODELGROUP_ACCCTRL = "访问控制";
   public static final String MODELGROUP_TEST = "测试";
   public static final String MODELGROUP_ADVMODEL = "模型高级";
   public static final String[] MODELGROUPS = new String[]{"基本", "处理逻辑", "搜索逻辑", "持久化", "数据库存储", "值规则", "关系", "访问控制", "测试", "模型高级", "用户扩展", "其它"};
   public static final int MODELORDER_LOGIC = 200;
   public static final int MODELORDER_SEARCH = 250;
   public static final int MODELORDER_PERSISTENT = 280;
   public static final int MODELORDER_DB = 310;
   public static final int MODELORDER_VALUERULE = 340;
   public static final int MODELORDER_DER = 390;
   public static final int MODELORDER_ACCCTRL = 420;
   public static final int MODELORDER_TEST = 450;
   public static final int MODELORDER_ADVMODEL = 500;
   protected PSDEField psDEField = null;
   protected IPSDEFieldType iPSDEFieldType = null;
   protected IPSSysDEFType iPSSysDEFType = null;
   private static final ArrayList<IPSDEFSearchMode> emptyPSDEFSearchModeList = new ArrayList<>();
   private static final ArrayList<IPSDEFInputTip> emptyPSDEFInputTipList = new ArrayList<>();
   private static final ArrayList<IPSDEFSearch> emptyPSDEFSearchList = new ArrayList<>();
   private static final ArrayList<IPSDEFLogic> emptyPSDEFLogicList = new ArrayList<>();
   protected static HashMap<String, Integer> systemFields = new HashMap<>();
   private static Map<String, String> ignoreAuditDEFPredefinedTypeMap = new HashMap<>();
   protected Properties defProperties = null;
   protected boolean bUserVisible = true;
   private boolean bMajorField = false;
   private boolean bKeyNameField = false;
   private boolean bKeyField = false;
   private boolean bIndexTypeField = false;
   private boolean bFormTypeField = false;
   private boolean bUniTagField = false;
   private boolean bValidFlag = true;
   private boolean bInit = false;
   private boolean bAllowEmpty = true;
   private String strCodeListId = "";
   private String strValueFormat = "";
   private String strJSFormat = "";
   private String strJsonFormat = "";
   private String strPreDefinedType = "";
   private boolean bEnableQuickSearch = false;
   private IPSCodeList iPSCodeList = null;
   private String strDupCheckMode = "NONE";
   private String[] dupCheckValues = null;
   private String strUpdateDBValueMode = null;
   private String strInsertDBValueMode = null;
   private int nStringLength = -1;
   private int nMinStringLength = -1;
   private int nLength = -1;
   private int nPrecision = 0;
   private int nImportOrder = 1000;
   private String strImportTag = "";
   private boolean bEnablePrivilege = false;
   private int nOrderValue = 1000;
   private String strLNLanResTag = "";
   private IPSLanguageRes lnPSLanguageRes = null;
   private IPSSysUnit iPSSysUnit = null;
   private boolean bCheckRecursion = false;
   private int nExtendMode = 0;
   private boolean bDynaStorageDEField = false;
   private boolean bPhisicalDEField = true;
   private int nEnableActions = 0;
   protected PSDEFUIModeGlobalModel psDEFUIModeGlobalModel = new PSDEFUIModeGlobalModel();
   protected PSDEFValueRuleGlobalModel psDEFValueRuleGlobalModel = new PSDEFValueRuleGlobalModel();
   protected PSDEFSearchModeGlobalModel psDEFSearchModeGlobalModel = null;
   protected PSDEFInputTipGlobalModel psDEFInputTipGlobalModel = null;
   protected PSDEFSearchGlobalModel psDEFSearchGlobalModel = null;
   private String strCodeName = "";
   private boolean bQueryColumn = true;
   private int nStdDataType = 0;
   private IPSSysSampleValue iPSSysSampleValue = null;
   protected String strXmlTagName = null;
   private boolean bEnableTempData = false;
   private long nCreateTime = 0L;
   private int nViewColLevel = 0;
   private ArrayList<IPSDEFDTColumn> psDEFDTColumnList = null;
   private int nDEFType = 0;
   private String strNullValueOrderMode = null;
   private int nUserInputMode = 0;
   private String strServiceCodeName = null;
   private IPSDEDBTable iPSDEDBTable = null;
   private IPSSysDBColumn iPSSysDBColumn = null;
   private IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = null;
   private String strMinValue = null;
   private String strMaxValue = null;
   private ArrayList<IPSDEFLogic> psDEFLogicList = null;
   private IPSSysValueRule iPSSysValueRule = null;
   private IPSSysSequence iPSSysSequence = null;
   private IPSSysTranslator iPSSysTranslator = null;
   private String strSequenceMode = "NONE";
   private String strTranslatorMode = "NONE";
   private boolean bEnableAudit = false;
   private IPSSysTranslator importPSSysTranslator = null;
   private IPSSysTranslator exportPSSysTranslator = null;
   private Integer nInitFlag = 0;
   private boolean bCalcSystemReserver = false;
   private boolean bSystemReserver = false;
   private boolean bCalcDataType = false;
   private String strDataType = "";
   private boolean bCalcUnit = false;
   private String strUnit = "";
   private boolean bCalcUnitWidth = false;
   private int nUnitWidth = 0;
   private boolean bCalcRestrictedPSDEField = false;
   private IPSDEField restrictedPSDEField = null;
   private boolean bCalcValuePSDEField = false;
   private IPSDEField valuePSDEField = null;

   static {
      systemFields.put("LOGICVALID", 0);
      systemFields.put("CREATEMAN", 0);
      systemFields.put("CREATEMANNAME", 0);
      systemFields.put("CREATEDATE", 0);
      systemFields.put("UPDATEMAN", 0);
      systemFields.put("UPDATEMANNAME", 0);
      systemFields.put("UPDATEDATE", 1);
      ignoreAuditDEFPredefinedTypeMap.put("LOGICVALID", "");
      ignoreAuditDEFPredefinedTypeMap.put("CREATEMAN", "");
      ignoreAuditDEFPredefinedTypeMap.put("CREATEMANNAME", "");
      ignoreAuditDEFPredefinedTypeMap.put("CREATEDATE", "");
      ignoreAuditDEFPredefinedTypeMap.put("UPDATEMAN", "");
      ignoreAuditDEFPredefinedTypeMap.put("UPDATEMANNAME", "");
      ignoreAuditDEFPredefinedTypeMap.put("UPDATEDATE", "");
   }

   @Override
   public void setInitParam(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEFieldType iPSDEFieldType, PSDEField psDEField) {
      this.setDAGlobalHelper(iDAGlobalHelper);
      this.setPSDataEntity(iPSDataEntity);
      this.psDEField = psDEField;
      this.iPSDEFieldType = iPSDEFieldType;
      if (this.iPSDEFieldType instanceof IPSSysDEFType) {
         this.iPSSysDEFType = (IPSSysDEFType)this.iPSDEFieldType;
      }

      this.setId(this.psDEField.getPSDEFIELDID());
      this.setName(this.psDEField.getPSDEFIELDNAME().toUpperCase());
      this.setPSObjectData(this.psDEField);
      if (!this.psDEField.isDEFTYPENull()) {
         this.nDEFType = this.psDEField.getDEFTYPE();
      }

      this.bDynaStorageDEField = this.nDEFType == 4;
      if (this.nDEFType == 5) {
         this.bPhisicalDEField = false;
      }

      this.bEnableTempData = iPSDataEntity.isEnableTempData();
      if (this.bEnableTempData && !this.psDEField.isENABLETEMPDATANull()) {
         this.bEnableTempData = this.psDEField.getENABLETEMPDATA();
      }

      if (!this.psDEField.isMAJORFIELDNull()) {
         if (this.psDEField.getMAJORFIELD() == 1) {
            this.bMajorField = true;
         }

         if (this.psDEField.getMAJORFIELD() == 2) {
            this.bKeyNameField = true;
         }
      }

      if (!this.psDEField.isPKEYNull()) {
         if (this.psDEField.getPKEY() == 1) {
            this.bKeyField = true;
         }

         if (this.psDEField.getPKEY() == 2) {
            this.bUniTagField = true;
         }
      }

      if (!this.psDEField.isREADONLYMODENull()) {
         int nAction = this.psDEField.getREADONLYMODE();
         if ((nAction & 1) == 0) {
            this.nEnableActions |= 1;
         }

         if ((nAction & 2) == 0) {
            this.nEnableActions |= 2;
         }
      } else {
         this.nEnableActions = 3;
      }

      this.nUserInputMode = this.psDEField.getENABLEUSERINPUT();
      if (this.psDEField.getINDEXTYPE()) {
         this.bIndexTypeField = true;
      }

      if (this.psDEField.getMULTIFORMFIELD()) {
         this.bFormTypeField = true;
      }

      this.strCodeName = this.psDEField.getCODENAME();
      if (StringHelper.IsNullOrEmpty(this.strCodeName)) {
         this.strCodeName = this.psDEField.getPSDEFIELDNAME().toLowerCase();
      }

      if (!StringHelper.IsNullOrEmpty(this.strCodeName)
         && (iPSDataEntity == null || !iPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
         String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
         this.strCodeName = strHeader + this.strCodeName.substring(1);
      }

      this.strXmlTagName = this.strCodeName.toUpperCase();
      this.nStdDataType = this.iPSDEFieldType.getStdDataType();
      this.psDEFUIModeGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psDEFValueRuleGlobalModel.Init(this.getDAGlobalHelper(), this);
      if (this.psDEField.getPSDEFSearchModes(false) != null) {
         this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
         this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
      }

      if (this.psDEField.getPSDEFInputTips(false) != null) {
         this.psDEFInputTipGlobalModel = new PSDEFInputTipGlobalModel();
         this.psDEFInputTipGlobalModel.Init(this.getDAGlobalHelper(), this);
      }

      if (this.psDEField.getPSSysSearchDEFields(false) != null) {
         this.psDEFSearchGlobalModel = new PSDEFSearchGlobalModel();
         this.psDEFSearchGlobalModel.Init(this.getDAGlobalHelper(), this);
      }

      this.strValueFormat = this.psDEField.getVALUEFORMAT();
      if (StringHelper.IsNullOrEmpty(this.strValueFormat) && !this.isLinkDEField()) {
         this.strValueFormat = this.iPSDEFieldType.getValueFormat(this.getPSDataEntity().getPSSystem().getSFType());
      }

      this.strJSFormat = this.psDEField.getJSFORMAT();
      if (StringHelper.IsNullOrEmpty(this.strJSFormat) && !this.isLinkDEField()) {
         this.strJSFormat = this.iPSDEFieldType.getValueFormat("JS");
      }

      this.strJsonFormat = this.psDEField.getJSONFORMAT();
      if (StringHelper.IsNullOrEmpty(this.strJsonFormat)) {
         if (!this.isLinkDEField()) {
            this.strJsonFormat = this.iPSDEFieldType.getValueFormat("JS");
         }

         if (!StringHelper.IsNullOrEmpty(this.strJsonFormat)) {
            this.strJsonFormat = this.strJsonFormat.replace("YYYY-MM-DD", "yyyy-MM-dd");
         }
      }

      if (!this.psDEField.isENABLEQSNull()) {
         this.bEnableQuickSearch = this.psDEField.getENABLEQS();
      } else {
         this.bEnableQuickSearch = this.isMajorDEField();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEField.getDUPCHECKMODE())) {
         this.strDupCheckMode = this.psDEField.getDUPCHECKMODE();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEField.getDUPCHECKVALUES())) {
         String strDupCheckValues = this.psDEField.getDUPCHECKVALUES();
         strDupCheckValues = strDupCheckValues.trim();
         this.dupCheckValues = strDupCheckValues.split("[;]");
      }

      if (!this.psDEField.isDBVALUEMODENull()) {
         this.strUpdateDBValueMode = this.psDEField.getDBVALUEMODE();
      }

      if (!this.psDEField.isDBVALUEMODE2Null()) {
         this.strInsertDBValueMode = this.psDEField.getDBVALUEMODE2();
      }

      if (!this.psDEField.isIMPORTORDERNull()) {
         this.nImportOrder = this.psDEField.getIMPORTORDER();
      }

      if (!this.psDEField.isIMPORTTAGNull()) {
         this.strImportTag = this.psDEField.getIMPORTTAG();
      }

      if (!this.psDEField.isENABLECOLPRIVNull()) {
         this.bEnablePrivilege = this.psDEField.getENABLECOLPRIV();
      }

      if (!this.psDEField.isORDERVALUENull() && this.psDEField.getORDERVALUE() >= 0) {
         this.nOrderValue = this.psDEField.getORDERVALUE();
      }

      if (!this.psDEField.isCREATEDATENull()) {
         this.nCreateTime = this.psDEField.getCREATEDATE().getTime();
      }

      if (!this.psDEField.isEXTENDMODENull()) {
         this.nExtendMode = this.psDEField.getEXTENDMODE();
      }

      this.strNullValueOrderMode = this.psDEField.getNULLVALORDER();
      this.strServiceCodeName = this.psDEField.getSERVICECODENAME();
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getSEQUENCEMODE())) {
         this.strSequenceMode = this.psDEField.getSEQUENCEMODE();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEField.getPSCODELISTID())) {
         this.strCodeListId = this.psDEField.getPSCODELISTID();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEField.getTRANSLATORMODE())) {
         this.strTranslatorMode = this.psDEField.getTRANSLATORMODE();
         if ((StringHelper.Compare(this.strTranslatorMode, "TRANSLATE", false) == 0 || StringHelper.Compare(this.strTranslatorMode, "TRANSLATE2", false) == 0)
            && StringHelper.IsNullOrEmpty(this.getPSSysTranslatorId())) {
            this.strTranslatorMode = "NONE";
         }
      }

      this.bInit = false;
   }

   @Override
   public synchronized void init() throws Exception {
      if (!this.bInit) {
         try {
            if (this.iPSDataEntity == null || this.psDEField == null || this.iPSDEFieldType == null || this.getDAGlobalHelper() == null) {
               throw new Exception("初始化参数无效");
            }

            if (StringHelper.IsNullOrEmpty(this.getName())) {
               throw new Exception("属性名称不能为空");
            }

            this.bInit = true;
            if (!this.psDEField.isVIEWCOLLEVELNull()) {
               this.nViewColLevel = this.psDEField.getVIEWCOLLEVEL();
            } else {
               this.nViewColLevel = this.onCalcViewLevel();
            }

            if (!StringHelper.IsNullOrEmpty(this.psDEField.getPSSYSSAMPLEVALUEID())) {
               this.iPSSysSampleValue = this.getPSDataEntity().getPSSystem().getPSSysSampleValue(this.psDEField.getPSSYSSAMPLEVALUEID());
            }

            if (!StringHelper.IsNullOrEmpty(this.psDEField.getPSSYSUNITID())) {
               this.iPSSysUnit = this.getPSDataEntity().getPSSystem().getPSSysUnit(this.psDEField.getPSSYSUNITID());
            } else if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty(this.iPSSysDEFType.getPSSysUnitId())) {
               this.iPSSysUnit = this.getPSDataEntity().getPSSystem().getPSSysUnit(this.iPSSysDEFType.getPSSysUnitId());
            }

            if (!StringHelper.IsNullOrEmpty(this.psDEField.getLNPSLANRESID())) {
               this.lnPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEField.getLNPSLANRESID());
            }

            this.onInit();
         } catch (Exception ex) {
            String strLogName = StringHelper.Format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
            String strExInfo = StringHelper.Format("初始化发生异常，%1$s", ex.getMessage());
            log.error(StringHelper.Format("%1$s%2$s", strLogName, strExInfo), ex);
            if (this.getPSSystemUtil() != null) {
               this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }

            this.throwInitException(ex);
         }
      }
   }

   @Override
   public boolean isInit() {
      return this.bInit;
   }

   @Override
   public void init2() throws Exception {
      synchronized (this.nInitFlag) {
         if (this.nInitFlag != 1) {
            this.strCodeListId = this.onGetCodeListId();
            this.strMinValue = this.onGetMinValueString();
            this.strMaxValue = this.onGetMaxValueString();
            this.nStdDataType = this.onGetStdDataType();
            this.bCheckRecursion = this.onCalcCheckRecursion();
            this.bAllowEmpty = this.onGetAllowEmpty();
            if (this.getPSDataEntity().getAuditMode() != 0) {
               if (!this.psDEField.isENABLEAUDITNull()) {
                  this.bEnableAudit = this.psDEField.getENABLEAUDIT();
               } else {
                  this.bEnableAudit = this.onGetEnableAudit();
               }
            }

            if (!this.psDEField.isLENGTHNull()) {
               this.nLength = this.psDEField.getLENGTH();
            }

            if (DataTypeHelper.IsStringType(this.nStdDataType)) {
               if (!this.psDEField.isSTRLENGTHNull()) {
                  this.nStringLength = this.psDEField.getSTRLENGTH();
               }

               if (this.nStringLength <= 0) {
                  this.nStringLength = this.psDEField.getLENGTH();
               }

               if (this.nStringLength <= 0) {
                  this.nStringLength = this.onGetStringLength();
               }

               if (this.nStringLength <= 0) {
                  if (DataTypeHelper.IsLongStringType(this.nStdDataType)) {
                     this.nStringLength = 1048576;
                  } else {
                     this.nStringLength = 200;
                  }
               }

               if (this.nLength <= 0) {
                  this.nLength = this.nStringLength;
               }

               if (!this.psDEField.isMINSTRLENGTHNull()) {
                  this.nMinStringLength = this.psDEField.getMINSTRLENGTH();
               } else {
                  this.nMinStringLength = this.onGetMinStringLength();
               }

               if (this.nMinStringLength < 0) {
                  this.nMinStringLength = 0;
               }
            } else {
               if (!this.psDEField.isPRECISION2Null() && this.psDEField.getPRECISION2() > 0) {
                  this.nPrecision = this.psDEField.getPRECISION2();
               } else {
                  this.nPrecision = this.onGetPrecision();
               }

               if (this.nLength < 0) {
                  this.nLength = this.onGetLength();
               }
            }

            if (!this.psDEField.isQUERYCOLUMNNull()) {
               this.bQueryColumn = this.psDEField.getQUERYCOLUMN();
            } else {
               this.bQueryColumn = this.onCalcQueryColumn();
            }

            this.nInitFlag = 1;
         }
      }
   }

   protected boolean onCalcQueryColumn() {
      return DataTypeHelper.IsLongStringType(this.nStdDataType) ? false : this.nStdDataType != 24;
   }

   protected boolean initEx() {
      try {
         this.init2();
         return true;
      } catch (Exception ex) {
         log.error(ex);
         return false;
      }
   }

   @Override
   protected void onInit() throws Exception {
      IPSSysEngineConfig iPSSysEngineConfig = this.getPSSysEngineConfig();
      if (iPSSysEngineConfig != null && iPSSysEngineConfig.getImpDEFRule() != -1) {
         if (this.psDEField.isIMPORTORDERNull()) {
            this.nImportOrder = this.onCalcImportOrder(iPSSysEngineConfig.getImpDEFRule());
         }

         if (this.getImportOrder() != -1 && this.psDEField.isIMPORTTAGNull()) {
            this.strImportTag = this.onCalcImportTag(iPSSysEngineConfig.getImpDEFRule());
         }
      }

      super.onInit();
   }

   @PSModelRTMeta(description = "实体对象", outputdoc = "false")
   @Override
   public IPSDataEntity getPSDataEntity() {
      return this.iPSDataEntity;
   }

   @Override
   public PSDEField getPSDEFieldData() {
      return this.psDEField;
   }

   @Override
   public int check() throws Exception {
      return super.check();
   }

   @Override
   protected int onCheck() throws Exception {
      this.getDupCheckPSDEField();
      this.getNo2DupCheckPSDEField();
      this.getNo3DupCheckPSDEField();
      this.getPSCodeList();
      if (!StringHelper.IsNullOrEmpty(this.getSequenceMode()) && !"NONE".equals(this.getSequenceMode()) && this.getPSSysSequence() == null) {
         throw new Exception("未指定系统值序列对象");
      } else if (!StringHelper.IsNullOrEmpty(this.getTranslatorMode())
         && !"NONE".equals(this.getTranslatorMode())
         && ("TRANSLATE".equals(this.getTranslatorMode()) || "TRANSLATE2".equals(this.getTranslatorMode()))
         && this.getPSSysTranslator() == null) {
         throw new Exception("未指定系统值转换器对象");
      } else {
         return super.onCheck();
      }
   }

   @PSModelRTMeta(description = "逻辑名称", fields = "LOGICNAME")
   @Override
   public String getLogicName() {
      return this.getLogicName("");
   }

   @Override
   public String getLogicName(String strLanguage) {
      return StringHelper.IsNullOrEmpty(this.psDEField.getLOGICNAME()) ? this.getName() : this.psDEField.getLOGICNAME();
   }

   public static boolean isLinkDataType(String strDataType) {
      if (StringHelper.Compare(strDataType, "PICKUP", true) == 0) {
         return true;
      } else {
         return StringHelper.Compare(strDataType, "PICKUPTEXT", true) == 0 ? true : StringHelper.Compare(strDataType, "PICKUPDATA", true) == 0;
      }
   }

   @Override
   public boolean isLinkDEField() {
      return false;
   }

   @Override
   public boolean isFormulaDEField() {
      return false;
   }

   @PSModelRTMeta(description = "物理属性", ignoredumpvalues = "true")
   @Override
   public boolean isPhisicalDEField() {
      return this.bPhisicalDEField;
   }

   protected void setPhisicalDEField(boolean bPhisicalDEField) {
      this.bPhisicalDEField = bPhisicalDEField;
   }

   @PSModelRTMeta(description = "主属性", ignoredumpvalues = "false", group = "基本", order = 141, fields = "MAJORFIELD")
   @Override
   public boolean isMajorDEField() {
      return this.bMajorField;
   }

   @PSModelRTMeta(description = "键名属性", ignoredumpvalues = "false", group = "基本", order = 141, fields = "MAJORFIELD")
   @Override
   public boolean isKeyNameDEField() {
      return this.bKeyNameField;
   }

   @PSModelRTMeta(description = "主键属性", ignoredumpvalues = "false", group = "基本", order = 140, fields = "PKEY")
   @Override
   public boolean isKeyDEField() {
      return this.bKeyField;
   }

   @PSModelRTMeta(description = "唯一业务标识属性", ignoredumpvalues = "false", group = "基本", order = 142, fields = "PKEY")
   @Override
   public boolean isUniTagField() {
      return this.bUniTagField;
   }

   @PSModelRTMeta(description = "索引类型属性", ignoredumpvalues = "false", group = "基本", order = 143, fields = "INDEXTYPE")
   @Override
   public boolean isIndexTypeDEField() {
      return this.bIndexTypeField;
   }

   @Override
   public boolean isInheritDEField() {
      return false;
   }

   @PSModelRTMeta(description = "数据类型属性", ignoredumpvalues = "false", group = "基本", order = 144)
   @Override
   public boolean isDataTypeDEField() {
      return this.getPSDataEntity().getDataTypePSDEField() != null && this.getPSDataEntity().getDataTypePSDEField().getId().equals(this.getId());
   }

   @PSModelRTMeta(description = "系统属性", ignoredumpvalues = "false")
   @Override
   public boolean isSystemReserver() {
      if (!this.bCalcSystemReserver) {
         this.bSystemReserver = this.onCalcSystemReserver();
         this.bCalcSystemReserver = true;
      }

      return this.bSystemReserver;
   }

   protected boolean onCalcSystemReserver() {
      return systemFields.containsKey(this.getPredefinedType());
   }

   @Override
   public boolean isUserVisible() {
      return this.bUserVisible;
   }

   @Override
   public final String getCodeListId() {
      this.initEx();
      return this.strCodeListId;
   }

   protected String onGetCodeListId() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getPSCODELISTID())) {
         return this.psDEField.getPSCODELISTID();
      }

      if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty(this.iPSSysDEFType.getPSCodeListId())) {
         return this.iPSSysDEFType.getPSCodeListId();
      }

      String strCodeListTemplId = this.iPSDEFieldType.getPSCodeListTemplId();
      return StringHelper.IsNullOrEmpty(strCodeListTemplId) ? "" : this.getPSDataEntity().getPSSystem().getPSCodeListByTempl(strCodeListTemplId).getId();
   }

   @PSModelRTMeta(description = "标准数据类型", codelist = "StdDataType", group = "基本", order = 131, fields = "STDDATATYPE")
   @Override
   public final int getStdDataType() {
      this.initEx();
      return this.nStdDataType;
   }

   protected int onGetStdDataType() throws Exception {
      return this.iPSDEFieldType.getStdDataType();
   }

   protected int onGetLength() throws Exception {
      return this.iPSDEFieldType.getLength();
   }

   protected int onGetPrecision() throws Exception {
      return this.iPSDEFieldType.getPrecision();
   }

   protected int onGetStringLength() throws Exception {
      return this.iPSDEFieldType.getStringLength();
   }

   protected int onGetMinStringLength() throws Exception {
      return this.iPSDEFieldType.getMinStringLength();
   }

   @PSModelRTMeta(description = "数据类型", codelist = "DEFDataType", group = "基本", order = 130, fields = "PSDATATYPEID")
   @Override
   public String getDataType() {
      if (!this.bCalcDataType) {
         this.strDataType = this.onGetDataType();
         this.bCalcDataType = true;
      }

      return this.strDataType;
   }

   protected String onGetDataType() {
      return this.psDEField.getPSDATATYPEID();
   }

   @Override
   public String getUnit() {
      if (!this.bCalcUnit) {
         this.strUnit = this.onGetUnit();
         this.bCalcUnit = true;
      }

      return this.strUnit;
   }

   protected String onGetUnit() {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getUNIT())) {
         return this.psDEField.getUNIT();
      } else {
         return this.getPSSysUnit() != null ? this.getPSSysUnit().getName() : this.iPSDEFieldType.getUnit();
      }
   }

   @Override
   public int getUnitWidth() {
      if (!this.bCalcUnitWidth) {
         this.nUnitWidth = this.onGetUnitWidth();
         this.bCalcUnitWidth = true;
      }

      return this.nUnitWidth;
   }

   protected int onGetUnitWidth() {
      return this.psDEField.getUNITWIDTH() != 0 ? this.psDEField.getUNITWIDTH() : this.iPSDEFieldType.getUnitWidth();
   }

   @PSModelRTMeta(description = "拷贝重置", ignoredumpvalues = "false", fields = "PASTERESET")
   @Override
   public boolean isPasteReset() {
      return !this.isKeyDEField() && !this.isUniTagField() ? this.psDEField.getPASTERESET() : true;
   }

   @Override
   public Object getDEFValue(String strValue) {
      return DataTypeParse.Parse(this.getStdDataType(), strValue);
   }

   @PSModelRTMeta(description = "支持审计", ignoredumpvalues = "false", fields = "ENABLEAUDIT")
   @Override
   public boolean isEnableAudit() {
      this.initEx();
      if (this.bEnableAudit) {
         if (!StringHelper.IsNullOrEmpty(this.getPredefinedType()) && ignoreAuditDEFPredefinedTypeMap.containsKey(this.getPredefinedType())) {
            return false;
         }

         if (this.isKeyDEField() || this.isUniTagField()) {
            return false;
         }
      }

      return this.bEnableAudit;
   }

   protected boolean onGetEnableAudit() throws Exception {
      return !this.isKeyDEField() && !this.isUniTagField() && this.isPhisicalDEField() && this.getPSSystemSetting().isEnableDEFieldAudit();
   }

   @PSModelRTMeta(description = "审计格式", fields = "AUDITINFOFORMAT")
   @Override
   public String getAuditInfoFormat() {
      return !this.isEnableAudit() ? "" : this.psDEField.getAUDITINFOFORMAT();
   }

   @PSModelRTMeta(description = "数据精度", ignoredumpvalues = "0", group = "基本", order = 135, fields = "PRECISION")
   @Override
   public final int getPrecision() {
      this.initEx();
      return this.nPrecision;
   }

   @Override
   public String getUpdateOVMode() {
      return this.psDEField.getUPDATEOVMODE();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.onGetCodeName();
   }

   protected String onGetCodeName() {
      return this.strCodeName;
   }

   @Override
   public boolean isEnableUserInsert() {
      return (this.getUserInputMode() & 1) > 0;
   }

   @Override
   public boolean isEnableUserUpdate() {
      return (this.getUserInputMode() & 2) > 0;
   }

   @Override
   public boolean testUserInput(int nUserInput) {
      return (this.getUserInputMode() & nUserInput) == nUserInput;
   }

   @Override
   public int getUserInputMode() {
      return this.nUserInputMode;
   }

   @Override
   public boolean isFormulaPhisical() {
      return false;
   }

   @Override
   public IPSDEFDTColumn getPSDTColumn(String strDBType) throws Exception {
      try {
         return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
      } catch (Exception ex) {
         throw ex;
      }
   }

   @Override
   public boolean isIgnoreInherit() {
      return false;
   }

   @Override
   public String getDupCheckCode(boolean bInsert) {
      return null;
   }

   @Override
   public boolean isEnablePriv() {
      return false;
   }

   @PSModelRTMeta(description = "字符串转化", codelist = "StringCaseMode", fields = "STRINGCASE")
   @Override
   public String getStringCase() {
      return this.psDEField.getSTRINGCASE();
   }

   @Override
   public String getCodeListParam() {
      return null;
   }

   @Override
   public String getFullName() {
      return StringHelper.Format("%1$s|%2$s", this.getPSDataEntity().getFullName(), this.getName());
   }

   @Override
   public IPSDEFieldType getPSDEFieldType() {
      return this.iPSDEFieldType;
   }

   @Override
   public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode psDEFUIMode) throws Exception {
      return this.getPSDEFieldType().createPSDEFGridColumn(psDEFUIMode);
   }

   @Override
   public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode psDEFUIMode) throws Exception {
      return this.getPSDEFieldType().createPSDEFUIMode(psDEFUIMode);
   }

   @Override
   public IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId) throws Exception {
      return this.psDEFUIModeGlobalModel.FindModelHelper(strPSDEFUIModeId);
   }

   @Override
   public IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId, boolean bTryMode) throws Exception {
      return this.psDEFUIModeGlobalModel.FindModelHelper(strPSDEFUIModeId, bTryMode);
   }

   @PSModelRTMeta(description = "属性界面模式集合", child = true, ignorert = 3, dynamodelmode = 4, outputdoc = "false")
   @Override
   public Iterator<IPSDEFUIMode> getAllPSDEFUIModes() throws Exception {
      return this.psDEFUIModeGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
      return this.getPSDEFieldType().createPSDEFSearchMode(psDEFSearchMode);
   }

   @Override
   public IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId) throws Exception {
      if (this.psDEFSearchModeGlobalModel == null) {
         this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
         this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
      }

      return this.psDEFSearchModeGlobalModel.FindModelHelper(strPSDEFSearchModeId);
   }

   @Override
   public IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId, boolean bTryMode) throws Exception {
      if (this.psDEFSearchModeGlobalModel == null) {
         if (bTryMode) {
            return null;
         }

         this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
         this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
      }

      return this.psDEFSearchModeGlobalModel.FindModelHelper(strPSDEFSearchModeId, bTryMode);
   }

   @PSModelRTMeta(description = "允许空值输入", ignoredumpvalues = "true", group = "基本", order = 180, fields = "ALLOWEMPTY")
   @Override
   public boolean isAllowEmpty() {
      this.initEx();
      return this.bAllowEmpty;
   }

   protected boolean onGetAllowEmpty() {
      return this.psDEField.getALLOWEMPTY();
   }

   @Override
   public int getEncryptStorage() {
      return 0;
   }

   @Override
   public IDataEntity getDataEntity() {
      return this.getPSDataEntity();
   }

   @PSModelRTMeta(description = "支持快速搜索", ignoredumpvalues = "false", fields = "ENABLEQS")
   @Override
   public boolean isEnableQuickSearch() {
      return this.bEnableQuickSearch;
   }

   @Override
   public Iterator<IDEFSearchMode> getDEFSearchModes() {
      return null;
   }

   @PSModelRTMeta(description = "支持字段权限", ignoredumpvalues = "false", fields = "ENABLECOLPRIV")
   @Override
   public boolean isEnablePrivilege() {
      return this.bEnablePrivilege;
   }

   @Override
   public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception {
      return this.psDEFValueRuleGlobalModel.FindModelHelper(strPSDEFValueRuleId);
   }

   @Override
   public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId, boolean bTryMode) throws Exception {
      return this.psDEFValueRuleGlobalModel.FindModelHelper(strPSDEFValueRuleId, bTryMode);
   }

   @PSModelRTMeta(description = "属性值规则集合", child = true, group = "值规则", order = 380)
   @Override
   public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
      return this.psDEFValueRuleGlobalModel.getAllModelHelpers();
   }

   @Override
   public IDEFValueRule getDEFValueRule(String strDVRId) throws Exception {
      return this.getPSDEFValueRule(strDVRId);
   }

   @PSModelRTMeta(description = "值格式化", fields = "VALUEFORMAT")
   @Override
   public String getValueFormat() {
      return this.strValueFormat;
   }

   protected void setValueFormat(String strValueFormat) {
      this.strValueFormat = strValueFormat;
   }

   @PSModelRTMeta(description = "JS格式化", fields = "JSFORMAT", dump = false)
   @Override
   public String getJSFormat() {
      return this.strJSFormat;
   }

   protected void setJSFormat(String strJSFormat) {
      this.strJSFormat = strJSFormat;
   }

   @PSModelRTMeta(description = "Json格式化", fields = "JSONFORMAT")
   @Override
   public String getJsonFormat() {
      return this.strJsonFormat;
   }

   protected void setJsonFormat(String strJsonFormat) {
      this.strJsonFormat = strJsonFormat;
   }

   @PSModelRTMeta(description = "属性搜索模式集合", child = true, dynamodelmode = 4, group = "搜索逻辑", order = 290)
   @Override
   public Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes() throws Exception {
      return this.psDEFSearchModeGlobalModel != null ? this.psDEFSearchModeGlobalModel.getAllModelHelpers() : emptyPSDEFSearchModeList.iterator();
   }

   @Override
   public String getPreDefinedType() {
      return this.strPreDefinedType;
   }

   @PSModelRTMeta(description = "预置业务类型", codelist = "PredefinedFieldType", group = "基本", order = 150, fields = "PREDEFINEDTYPE")
   @Override
   public String getPredefinedType() {
      return this.strPreDefinedType;
   }

   @PSModelRTMeta(description = "预置类型参数", fields = "PREDEFINEDTYPEPARAM")
   @Override
   public String getPredefinedTypeParam() {
      return this.psDEField.getPREDEFINEDTYPEPARAM();
   }

   @Override
   public void setPreDefinedType(String strPreDefinedType) {
      this.strPreDefinedType = strPreDefinedType;
   }

   @Override
   public int getEnableUserInput() {
      return this.psDEField.getENABLEUSERINPUT();
   }

   @PSModelRTMeta(description = "联合键值属性", ignorert = 3, codelist = "UnionKeyValueMode", fields = "UNIONKEYVALUE")
   @Override
   public String getUnionKeyValue() {
      return this.psDEField.getUNIONKEYVALUE();
   }

   @PSModelRTMeta(description = "多表单识别属性", ignoredumpvalues = "false", fields = "MULTIFORMFIELD")
   @Override
   public boolean isMultiFormDEField() {
      return this.psDEField.getMULTIFORMFIELD();
   }

   @PSModelRTMeta(description = "属性代码表", dumpref = true, group = "基本", order = 143, fields = "PSCODELISTID")
   @Override
   public IPSCodeList getPSCodeList() throws Exception {
      if (this.iPSCodeList == null && !StringHelper.IsNullOrEmpty(this.getCodeListId())) {
         this.iPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(this.strCodeListId);
         return this.iPSCodeList;
      } else {
         return this.iPSCodeList;
      }
   }

   @Override
   public boolean isFormTypeDEField() {
      return this.bFormTypeField;
   }

   @PSModelRTMeta(
      description = "重复值检查",
      codelist = "DEFDupCheckMode",
      ignoredumpvalues = "NONE",
      dynamodelmode = 4,
      group = "值规则",
      order = 356,
      fields = "DUPCHECKMODE"
   )
   @Override
   public String getDupCheckMode() {
      return this.strDupCheckMode;
   }

   @PSModelRTMeta(description = "重复值检查集合", hideempty = true, child = true, dynamodelmode = 4, fields = "DUPCHECKVALUES")
   @Override
   public String[] getDupCheckValues() {
      return this.dupCheckValues;
   }

   @PSModelRTMeta(
      description = "重复值检查范围属性集合",
      child = true,
      hideempty = true,
      dumpref = true,
      rtdump = 3,
      rtname = "getDupCheckDEFields",
      from = "IPSDataEntity",
      dynamodelmode = 4,
      outputdoc = "false",
      fields = {"DUPCHKPSDEFID", "NO2DUPCHKPSDEFID", "NO3DUPCHKPSDEFID"}
   )
   @Override
   public Iterator<IPSDEField> getDupCheckPSDEFields() throws Exception {
      IPSDEField field1 = this.getDupCheckPSDEField();
      IPSDEField field2 = this.getNo2DupCheckPSDEField();
      IPSDEField field3 = this.getNo3DupCheckPSDEField();
      if (field1 == null && field2 == null && field3 == null) {
         return null;
      }

      List<IPSDEField> list = new ArrayList<>();
      if (field1 != null) {
         list.add(field1);
      }

      if (field2 != null) {
         list.add(field2);
      }

      if (field3 != null) {
         list.add(field3);
      }

      return list.iterator();
   }

   @PSModelRTMeta(description = "重复值检查范围属性", hideempty = true, group = "值规则", order = 358, fields = "DUPCHKPSDEFID")
   @Override
   public IPSDEField getDupCheckPSDEField() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.psDEField.getDUPCHKPSDEFID())) {
         return null;
      } else {
         return StringHelper.Compare(this.getDupCheckMode(), "NONE", true) == 0 ? null : this.getPSDataEntity().getPSDEField(this.psDEField.getDUPCHKPSDEFID());
      }
   }

   @PSModelRTMeta(description = "重复值检查范围属性2", group = "值规则", order = 359, fields = "NO2DUPCHKPSDEFID")
   @Override
   public IPSDEField getNo2DupCheckPSDEField() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.psDEField.getNO2DUPCHKPSDEFID())) {
         return null;
      } else {
         return StringHelper.Compare(this.getDupCheckMode(), "NONE", true) == 0
            ? null
            : this.getPSDataEntity().getPSDEField(this.psDEField.getNO2DUPCHKPSDEFID());
      }
   }

   @PSModelRTMeta(description = "重复值检查范围属性3", group = "值规则", order = 360, fields = "NO3DUPCHKPSDEFID")
   @Override
   public IPSDEField getNo3DupCheckPSDEField() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.psDEField.getNO3DUPCHKPSDEFID())) {
         return null;
      } else {
         return StringHelper.Compare(this.getDupCheckMode(), "NONE", true) == 0
            ? null
            : this.getPSDataEntity().getPSDEField(this.psDEField.getNO3DUPCHKPSDEFID());
      }
   }

   @PSModelRTMeta(
      description = "最大字符串长度",
      ignoredumpvalues = "0;-1",
      group = "值规则",
      order = 346,
      outputdoc = "item.getStdDataType()==25",
      fields = "STRLENGTH"
   )
   @Override
   public final int getStringLength() {
      this.initEx();
      return this.nStringLength;
   }

   @PSModelRTMeta(description = "字段长度", ignoredumpvalues = "0;-1", group = "基本", order = 133, fields = "LENGTH")
   @Override
   public final int getLength() {
      this.initEx();
      return this.nLength;
   }

   @PSModelRTMeta(description = "默认值类型", codelist = "DEFDefaultValueType", group = "处理逻辑", order = 201, fields = "DVT")
   @Override
   public String getDefaultValueType() {
      return this.psDEField.getDVT();
   }

   @PSModelRTMeta(description = "默认值", group = "处理逻辑", order = 202, fields = "DEFAULTVALUE")
   @Override
   public String getDefaultValue() {
      return this.psDEField.getDEFAULTVALUE();
   }

   @PSModelRTMeta(description = "查询列", ignoredumpvalues = "true", group = "搜索逻辑", order = 253, fields = "QUERYCOLUMN")
   @Override
   public final boolean isQueryColumn() {
      this.initEx();
      return this.bQueryColumn;
   }

   @Override
   public String getDBValueFunc() {
      return this.strUpdateDBValueMode;
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSDataEntity().getPSSysModelInstId();
   }

   @Override
   public String getPSSysValueRuleId() {
      String strPSSysValueRuleId = this.psDEField.getPSSYSVALUERULEID();
      if (!StringHelper.IsNullOrEmpty(strPSSysValueRuleId)) {
         return strPSSysValueRuleId;
      }

      if (this.iPSSysDEFType != null) {
         this.iPSSysDEFType.getPSSysValueRuleId();
      }

      return strPSSysValueRuleId;
   }

   @PSModelRTMeta(description = "系统值规则", group = "值规则", order = 355, fields = "PSSYSVALUERULEID")
   @Override
   public IPSSysValueRule getPSSysValueRule() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.getPSSysValueRuleId())) {
         return null;
      }

      if (this.iPSSysValueRule == null) {
         this.iPSSysValueRule = this.getPSSystem().getPSSysValueRule(this.getPSSysValueRuleId());
      }

      return this.iPSSysValueRule;
   }

   @PSModelRTMeta(description = "限定属性", hideempty = true, fields = "RESTRICTEDPSDEFID")
   @Override
   public IPSDEField getRestrictedPSDEField() throws Exception {
      if (!this.bCalcRestrictedPSDEField) {
         this.restrictedPSDEField = this.onGetRestrictedPSDEField();
         this.bCalcRestrictedPSDEField = true;
      }

      return this.restrictedPSDEField;
   }

   protected IPSDEField onGetRestrictedPSDEField() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getRESTRICTEDPSDEFID())) {
         if (StringHelper.Compare(this.getId(), this.psDEField.getRESTRICTEDPSDEFID(), false) == 0) {
            throw new Exception(StringHelper.Format("属性[%1$s]的限定属性不能指向自身", this.getFullName()));
         } else {
            return this.getPSDataEntity().getPSDEField(this.psDEField.getRESTRICTEDPSDEFID());
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "值项属性", hideempty = true, dumpref = true, from = "IPSDataEntity", fields = "VALUEPSDEFID")
   @Override
   public IPSDEField getValuePSDEField() throws Exception {
      if (!this.bCalcValuePSDEField) {
         this.valuePSDEField = this.onGetValuePSDEField();
         this.bCalcValuePSDEField = true;
      }

      return this.valuePSDEField;
   }

   protected IPSDEField onGetValuePSDEField() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getVALUEPSDEFID())) {
         if (StringHelper.Compare(this.getId(), this.psDEField.getVALUEPSDEFID(), false) == 0) {
            throw new Exception(StringHelper.Format("属性[%1$s]的值项属性不能指向自身", this.getFullName()));
         } else {
            return this.getPSDataEntity().getPSDEField(this.psDEField.getVALUEPSDEFID());
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "主状态属性模式", codelist = "DEMSFieldMode", ignorert = 3, fields = "STATEFIELD")
   @Override
   public String getDEMSFieldMode() {
      return this.psDEField.getSTATEFIELD();
   }

   @PSModelRTMeta(description = "导入次序", ignorert = 3, fields = "IMPORTORDER")
   @Override
   public int getImportOrder() {
      return this.nImportOrder;
   }

   @PSModelRTMeta(description = "导入标识", ignorert = 3, fields = "IMPORTTAG")
   @Override
   public String getImportTag() {
      return this.strImportTag;
   }

   protected int onCalcImportOrder(int nRuleMode) throws Exception {
      switch (nRuleMode) {
         case 1:
            if (this.isMajorDEField()) {
               return 100;
            }

            return -1;
         default:
            return this.nImportOrder;
      }
   }

   protected String onCalcImportTag(int nRuleMode) throws Exception {
      return this.strImportTag;
   }

   @Override
   public String getMemo() {
      return this.psDEField.getMEMO();
   }

   @Override
   public String getDERName() {
      return null;
   }

   @Override
   public String getLinkDEFName() {
      return null;
   }

   @PSModelRTMeta(description = "数据表名称", dump = false)
   @Override
   public String getTableName() {
      return this.isPhisicalDEField() && !this.isDynaStorageDEField() ? this.getPSDataEntity().getTableName() : "";
   }

   public boolean isEnableWriteBack() throws Exception {
      return false;
   }

   @Override
   public String getTestDataValue() {
      String strTestDataValue = this.getTestDataValueDefault();
      return StringHelper.IsNullOrEmpty(strTestDataValue) ? this.getPSDEFieldType().getTestDataValue() : strTestDataValue;
   }

   protected String getTestDataValueDefault() {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getTESTDATA())) {
         return this.psDEField.getTESTDATA();
      } else {
         return this.getPSSampleValue() != null ? this.getPSSampleValue().getSampleValue(false) : "";
      }
   }

   @Override
   public IPSSysSampleValue getPSSampleValue() {
      return this.iPSSysSampleValue;
   }

   @PSModelRTMeta(description = "系统示例数据", fields = "PSSYSSAMPLEVALUEID")
   @Override
   public IPSSysSampleValue getPSSysSampleValue() {
      return this.iPSSysSampleValue;
   }

   @Override
   public String getXmlTagName() {
      return this.strXmlTagName;
   }

   @Override
   public boolean isEnableTempData() {
      return this.bEnableTempData;
   }

   @Override
   public IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId, boolean bTryMode) throws Exception {
      if (this.psDEFInputTipGlobalModel != null) {
         IPSDEFInputTip iPSDEFInputTip = this.psDEFInputTipGlobalModel.FindModelHelper(strPSDEFInputTipId, true);
         if (iPSDEFInputTip != null) {
            return iPSDEFInputTip;
         }
      }

      return this.getPSDataEntity().getPSSystem().getPSSysDEFInputTip(strPSDEFInputTipId, bTryMode);
   }

   @Override
   public IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId) throws Exception {
      if (this.psDEFInputTipGlobalModel != null) {
         IPSDEFInputTip iPSDEFInputTip = this.psDEFInputTipGlobalModel.FindModelHelper(strPSDEFInputTipId, true);
         if (iPSDEFInputTip != null) {
            return iPSDEFInputTip;
         }
      }

      return this.getPSDataEntity().getPSSystem().getPSSysDEFInputTip(strPSDEFInputTipId);
   }

   @Override
   public Iterator<IPSDEFInputTip> getAllPSDEFInputTips() throws Exception {
      return this.psDEFInputTipGlobalModel != null ? this.psDEFInputTipGlobalModel.getAllModelHelpers() : emptyPSDEFInputTipList.iterator();
   }

   @Override
   public IPSDEFInputTip getDefaultPSDEFInputTip() {
      return this.psDEFInputTipGlobalModel != null ? this.psDEFInputTipGlobalModel.getDefaultPSDEFInputTip() : null;
   }

   @PSModelRTMeta(description = "排序值", ignorert = 3, fields = "ORDERVALUE")
   @Override
   public int getOrderValue() {
      return this.nOrderValue;
   }

   @Override
   public String getLNLanResTag() {
      return this.getLNPSLanguageRes() == null ? this.strLNLanResTag : this.getLNPSLanguageRes().getLanResTag();
   }

   @PSModelRTMeta(description = "逻辑名称语言资源")
   @Override
   public IPSLanguageRes getLNPSLanguageRes() {
      return this.lnPSLanguageRes;
   }

   @PSModelRTMeta(description = "单位对象")
   @Override
   public IPSSysUnit getPSSysUnit() {
      return this.iPSSysUnit;
   }

   @Override
   public String getUnitLanResTag() {
      return this.getUnitPSLanguageRes() != null ? this.getUnitPSLanguageRes().getLanResTag() : null;
   }

   @Override
   public long getCreateTime() {
      return this.nCreateTime;
   }

   @Override
   public IPSLanguageRes getUnitPSLanguageRes() {
      return this.getPSSysUnit() != null ? this.getPSSysUnit().getNamePSLanguageRes() : null;
   }

   protected IPSSysEngineConfig getPSSysEngineConfig() {
      return ((IPSSystemSetting)this.getPSDataEntity().getPSSystem()).getPSSysEngineConfig();
   }

   @PSModelRTMeta(description = "检查递归", ignoredumpvalues = "false", group = "值规则", order = 365, fields = "CHECKRECURSION")
   @Override
   public final boolean isCheckRecursion() {
      this.initEx();
      return this.bCheckRecursion;
   }

   protected boolean onCalcCheckRecursion() throws Exception {
      return this.psDEField.isCHECKRECURSIONNull() ? false : this.psDEField.getCHECKRECURSION();
   }

   @PSModelRTMeta(description = "查询列级别", ignoredumpvalues = "1", group = "搜索逻辑", order = 254, fields = "VIEWCOLLEVEL")
   @Override
   public int getViewLevel() {
      return this.nViewColLevel;
   }

   protected int onCalcViewLevel() {
      return this.isPhisicalDEField() ? 1 : 0;
   }

   @Override
   public boolean isQueryColumn(int nViewLevel) {
      if (this.isDynaStorageDEField() || this.isUIAssistDEField()) {
         return false;
      } else if (nViewLevel == -1) {
         return this.isQueryColumn();
      } else if (this.isKeyDEField()) {
         return true;
      } else {
         return StringHelper.Compare(this.getPreDefinedType(), "LOGICVALID", true) == 0 ? true : this.getViewLevel() >= nViewLevel;
      }
   }

   @PSModelRTMeta(description = "数据库自动产生值", ignoredumpvalues = "false")
   @Override
   public boolean isEnableDBAutoValue() {
      return this.isEnableDBValueInsertUpdateMode() && !StringHelper.IsNullOrEmpty(this.getDBValueInsertMode()) ? true : this.iPSDEFieldType.isAutoIncrement();
   }

   @PSModelRTMeta(description = "数据库新建值模式", codelist = "DBValueMode", hideempty2 = true, fields = "DBVALUEMODE")
   @Override
   public String getDBValueInsertMode() {
      return this.strInsertDBValueMode;
   }

   @PSModelRTMeta(description = "数据库更新值模式", codelist = "DBValueMode", hideempty2 = true, fields = "DBVALUEMODE2")
   @Override
   public String getDBValueUpdateMode() {
      return this.strUpdateDBValueMode;
   }

   @Override
   public String getModelType() {
      return "PSDEFIELD";
   }

   @Override
   public String getModelName() {
      return StringHelper.Format("%1$s#%2$s", this.getName(), this.getLogicName());
   }

   @Override
   public String getFullModelName() {
      return StringHelper.Format("%1$s|%2$s#%3$s", this.getPSDataEntity().getFullModelName(), this.getName(), this.getLogicName());
   }

   @Override
   public IPSSystem getPSSystem() {
      return this.getPSDataEntity().getPSSystem();
   }

   @Override
   public boolean isEnableDBValueInsertUpdateMode() {
      return this.getPSSystemSetting().isEnableDBValueInsertUpdateMode();
   }

   @Override
   public IDEFDBValueFunc getDEFDBValueFunc(String strDBType, boolean bInsert) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public IPSDEFDTColumn getPSDETDTColumn(String strDBType) throws Exception {
      return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
   }

   @Override
   public IPSDEFDTColumn getPSDEFDTColumn(String strDBType) throws Exception {
      return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
   }

   @PSModelRTMeta(description = "数据库列对象集合", child = true, dynamodelmode = 4, group = "数据库存储", order = 330)
   @Override
   public synchronized Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception {
      if (this.psDEFDTColumnList == null) {
         ArrayList<IPSDEFDTColumn> psDEFDTColumnList = new ArrayList<>();
         if (!this.isDynaStorageDEField() && !this.isUIAssistDEField()) {
            Iterator<IPSDEDBConfig> psDEDBConfigs = this.getPSDataEntity().getAllPSDEDBConfigs();

            while (psDEDBConfigs.hasNext()) {
               IPSDEFDTColumn iPSDEFDTColumn = psDEDBConfigs.next().getPSDEFDTColumn(this.getName());
               psDEFDTColumnList.add(iPSDEFDTColumn);
            }
         }

         if (this.psDEFDTColumnList == null) {
            this.psDEFDTColumnList = psDEFDTColumnList;
         }
      }

      return this.psDEFDTColumnList.iterator();
   }

   @PSModelRTMeta(description = "子系统扩展", codelist = "DEExtendMode", ignoredumpvalues = "0")
   @Override
   public int getExtendMode() {
      return this.nExtendMode;
   }

   @Override
   public IDEFDTColumn getDEFDTColumn(String strDBType) throws Exception {
      return this.getPSDETDTColumn(strDBType);
   }

   @Override
   public boolean isEnableGetPSObjectParam() {
      return true;
   }

   @PSModelRTMeta(description = "属性类型", codelist = "DEFieldType", group = "基本", order = 125, fields = "DEFTYPE")
   @Override
   public int getDEFType() {
      return this.nDEFType;
   }

   @PSModelRTMeta(description = "动态存储属性", ignoredumpvalues = "false")
   @Override
   public boolean isDynaStorageDEField() {
      return this.bDynaStorageDEField;
   }

   protected void setDynaStorageDEField(boolean bDynaStorageDEField) {
      this.bDynaStorageDEField = bDynaStorageDEField;
   }

   @PSModelRTMeta(description = "默认属性搜索模式", dumpref = true, from = "__self__", dynamodelmode = 4, group = "搜索逻辑", order = 260)
   @Override
   public IPSDEFSearchMode getDefaultPSDEFSearchMode() {
      return this.psDEFSearchModeGlobalModel == null ? null : this.psDEFSearchModeGlobalModel.getDefaultPSDEFSearchMode();
   }

   @PSModelRTMeta(description = "数据空值排序模式", codelist = "DBNullValueOrderMode", fields = "NULLVALORDER")
   @Override
   public String getNullValueOrderMode() {
      return this.strNullValueOrderMode;
   }

   @PSModelRTMeta(description = "业务标记", codelist = "DEFBizTag", fields = "BIZTAG")
   @Override
   public String getBizTag() {
      return this.psDEField.getBIZTAG();
   }

   @PSModelRTMeta(description = "服务代码标识", dynamodelmode = 8, calccode = "this.getCodeName()", fields = "SERVICECODENAME")
   @Override
   public String getServiceCodeName() {
      return this.onGetServiceCodeName();
   }

   protected String onGetServiceCodeName() {
      return !StringHelper.IsNullOrEmpty(this.strServiceCodeName)
         ? this.strServiceCodeName
         : this.getPSDataEntity().getAPICodeName(null, this.getCodeName(), null);
   }

   @PSModelRTMeta(description = "实体数据表对象", hideempty = true, dumpref = true, from = "IPSDataEntity", dynamodelmode = 4, group = "数据库存储", order = 312)
   @Override
   public IPSDEDBTable getPSDEDBTable() throws Exception {
      if (this.iPSDEDBTable != null) {
         return this.iPSDEDBTable;
      }

      if (this.getPSDataEntity().getPSSysDBScheme() != null && !StringHelper.IsNullOrEmpty(this.getTableName())) {
         this.iPSDEDBTable = this.getPSDataEntity().getPSDEDBTable(this.getTableName(), true);
      }

      return this.iPSDEDBTable;
   }

   @PSModelRTMeta(
      description = "关系数据库列对象",
      hideempty = true,
      dumpref = true,
      from = "__self__",
      from_method = "getPSDEDBTableMust().getPSSysDBTableMust().getPSSysDBColumn",
      dynamodelmode = 4,
      group = "数据库存储",
      order = 316
   )
   @Override
   public IPSSysDBColumn getPSSysDBColumn() throws Exception {
      if (this.iPSSysDBColumn != null) {
         return this.iPSSysDBColumn;
      }

      if (this.getPSDEDBTable() != null && this.getPSDEDBTable().getPSSysDBTable() != null) {
         this.iPSSysDBColumn = this.getPSDEDBTable().getPSSysDBTable().getPSSysDBColumn(this.getName(), true);
      }

      return this.iPSSysDBColumn;
   }

   @PSModelRTMeta(description = "外部服务实体属性对象", hideempty = true)
   @Override
   public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField() throws Exception {
      if (this.iPSSubSysServiceAPIDEField != null) {
         return this.iPSSubSysServiceAPIDEField == PSSubSysServiceAPIDEFieldImpl.EMPTY ? null : this.iPSSubSysServiceAPIDEField;
      }

      if (this.getPSDataEntity().getPSSubSysServiceAPIDE() != null) {
         if (!StringHelper.IsNullOrEmpty(this.psDEField.getPSSUBSYSSADEFIELDID())) {
            this.iPSSubSysServiceAPIDEField = this.getPSDataEntity()
               .getPSSubSysServiceAPIDE()
               .getPSSubSysServiceAPIDEField(this.psDEField.getPSSUBSYSSADEFIELDID());
         } else {
            this.iPSSubSysServiceAPIDEField = this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEField(this.getName(), true);
         }
      }

      if (this.iPSSubSysServiceAPIDEField == null) {
         this.iPSSubSysServiceAPIDEField = PSSubSysServiceAPIDEFieldImpl.EMPTY;
         return null;
      } else {
         return this.iPSSubSysServiceAPIDEField;
      }
   }

   @Override
   public Iterator<IPSDEFSearch> getAllPSDEFSearchs() throws Exception {
      return this.psDEFSearchGlobalModel != null ? this.psDEFSearchGlobalModel.getAllModelHelpers() : emptyPSDEFSearchList.iterator();
   }

   @PSModelRTMeta(description = "属性全文检索集合", group = "搜索逻辑", order = 292)
   @Override
   public Iterator<IPSDEFSearch> getAllPSDEFSearches() throws Exception {
      return this.psDEFSearchGlobalModel != null ? this.psDEFSearchGlobalModel.getAllModelHelpers() : emptyPSDEFSearchList.iterator();
   }

   @Override
   public IPSDEFSearch getPSDEFSearch(String strPSDEFSearchId) throws Exception {
      return this.getPSDEFSearch(strPSDEFSearchId, false);
   }

   @Override
   public IPSDEFSearch getPSDEFSearch(String strPSDEFSearchId, boolean bTryMode) throws Exception {
      if (this.psDEFSearchGlobalModel == null) {
         if (bTryMode) {
            return null;
         } else {
            throw new Exception(StringHelper.Format("无法获取属性[%1$s]全文检索[%2$s]", this.getName(), strPSDEFSearchId));
         }
      } else {
         return this.psDEFSearchGlobalModel.FindModelHelper(strPSDEFSearchId, bTryMode);
      }
   }

   @Override
   public void setPSSubSysServiceAPIDEField(IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField) {
      this.iPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
   }

   @PSModelRTMeta(description = "部署数据标识", dump = false)
   @Override
   public String getDeployId() {
      return KeyValueHelper.genUniqueId(this.getPSDataEntity().getDeployId(), this.getName());
   }

   @PSModelRTMeta(description = "界面辅助属性", ignoredumpvalues = "false")
   @Override
   public boolean isUIAssistDEField() {
      return this.getDEFType() == 5;
   }

   @PSModelRTMeta(
      description = "最小字符串长度",
      ignoredumpvalues = "0;-1",
      group = "值规则",
      order = 345,
      outputdoc = "item.getStdDataType()==25",
      fields = "MINSTRLENGTH"
   )
   @Override
   public int getMinStringLength() {
      this.initEx();
      return this.nMinStringLength;
   }

   @PSModelRTMeta(description = "最大值（字符串）", group = "值规则", order = 347, fields = "MAXVALUE")
   @Override
   public String getMaxValueString() {
      this.initEx();
      return this.strMaxValue;
   }

   @PSModelRTMeta(description = "最小值（字符串）", group = "值规则", order = 349, fields = "MINVALUE")
   @Override
   public String getMinValueString() {
      this.initEx();
      return this.strMinValue;
   }

   protected String onGetMinValueString() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getMINVALUE())) {
         return this.psDEField.getMINVALUE();
      } else {
         return this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty(this.iPSSysDEFType.getMinValueString())
            ? this.iPSSysDEFType.getMinValueString()
            : this.iPSDEFieldType.getMinValueString();
      }
   }

   protected String onGetMaxValueString() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEField.getMAXVALUE())) {
         return this.psDEField.getMAXVALUE();
      } else {
         return this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty(this.iPSSysDEFType.getMaxValueString())
            ? this.iPSSysDEFType.getMaxValueString()
            : this.iPSDEFieldType.getMaxValueString();
      }
   }

   @PSModelRTMeta(description = "实体属性逻辑集合", outputdoc = "false")
   @Override
   public synchronized Iterator<IPSDEFLogic> getAllPSDEFLogics() throws Exception {
      if (this.psDEFLogicList == null) {
         ArrayList<IPSDEFLogic> psDEFLogicList = new ArrayList<>();
         Iterator<IPSDELogic> psDELogics = this.getPSDataEntity().getAllPSDELogics();
         if (psDELogics != null) {
            while (psDELogics.hasNext()) {
               IPSDELogic iPSDELogic = psDELogics.next();
               if (iPSDELogic instanceof IPSDEFLogic) {
                  IPSDEFLogic iPSDEFLogic = (IPSDEFLogic)iPSDELogic;
                  if (StringHelper.Compare(iPSDEFLogic.getPSDEField().getId(), this.getId(), false) == 0) {
                     psDEFLogicList.add(iPSDEFLogic);
                  }
               }
            }
         }

         if (this.psDEFLogicList == null) {
            if (psDEFLogicList.size() != 0) {
               this.psDEFLogicList = psDEFLogicList;
            } else {
               this.psDEFLogicList = emptyPSDEFLogicList;
            }
         }
      }

      return this.psDEFLogicList.iterator();
   }

   @PSModelRTMeta(
      description = "默认值逻辑",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 204
   )
   @Override
   public IPSDEFLogic getDefaultValuePSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("DEFAULT");
   }

   @PSModelRTMeta(
      description = "值变更逻辑",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 210
   )
   @Override
   public IPSDEFLogic getOnChangePSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("ONCHANGE");
   }

   @PSModelRTMeta(
      description = "值计算逻辑",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 205
   )
   @Override
   public IPSDEFLogic getComputePSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("COMPUTE");
   }

   @PSModelRTMeta(
      description = "值检查逻辑",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 215
   )
   @Override
   public IPSDEFLogic getCheckPSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("CHECK");
   }

   @PSModelRTMeta(
      description = "用户自定义逻辑",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 216
   )
   @Override
   public IPSDEFLogic getUserPSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("USER");
   }

   @PSModelRTMeta(
      description = "用户自定义逻辑2",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 217
   )
   @Override
   public IPSDEFLogic getUser2PSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("USER2");
   }

   @PSModelRTMeta(
      description = "用户自定义逻辑3",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 218
   )
   @Override
   public IPSDEFLogic getUser3PSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("USER3");
   }

   @PSModelRTMeta(
      description = "用户自定义逻辑4",
      dumpref = true,
      from = "IPSDataEntity",
      from_method = "getPSDELogic",
      origin = "IPSDEFLogic",
      group = "处理逻辑",
      order = 219
   )
   @Override
   public IPSDEFLogic getUser4PSDEFLogic() throws Exception {
      return this.getPSDEFLogicByMode("USER4");
   }

   protected IPSDEFLogic getPSDEFLogicByMode(String strMode) throws Exception {
      Iterator<IPSDEFLogic> psDEFLogics = this.getAllPSDEFLogics();
      if (psDEFLogics != null) {
         while (psDEFLogics.hasNext()) {
            IPSDEFLogic iPSDEFLogic = psDEFLogics.next();
            if (iPSDEFLogic.isEnableBackend() && StringHelper.Compare(iPSDEFLogic.getDEFLogicMode(), strMode, false) == 0) {
               return iPSDEFLogic;
            }
         }
      }

      return null;
   }

   @Override
   public int getEnableActions() {
      return this.nEnableActions;
   }

   @PSModelRTMeta(description = "支持建立", ignoredumpvalues = "true")
   @Override
   public boolean isEnableCreate() {
      return (this.getEnableActions() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持修改", ignoredumpvalues = "true")
   @Override
   public boolean isEnableModify() {
      return (this.getEnableActions() & 2) == 2;
   }

   @PSModelRTMeta(description = "支持界面建立", ignoredumpvalues = "true")
   @Override
   public boolean isEnableUICreate() {
      return this.isEnableUserInsert();
   }

   @PSModelRTMeta(description = "支持界面修改", ignoredumpvalues = "true")
   @Override
   public boolean isEnableUIModify() {
      return this.isEnableUserUpdate();
   }

   @PSModelRTMeta(description = "默认属性数据库列")
   @Override
   public IPSDEFDTColumn getDefaultPSDEFDTColumn() throws Exception {
      if (this.getPSDataEntity().getPSSystem().getDefaultPSSystemDBConfig() != null) {
         String strDBType = this.getPSDataEntity().getPSSystem().getDefaultPSSystemDBConfig().getDBType();
         IPSDEDBConfig iPSDEDBConfig = this.getPSDataEntity().getPSDEDBConfig(strDBType, true);
         if (iPSDEDBConfig != null) {
            return iPSDEDBConfig.getPSDEFDTColumn(this.getName(), true);
         }
      }

      return null;
   }

   @PSModelRTMeta(description = "系统值序列", hideempty = true, dumpref = true, group = "处理逻辑", order = 225, fields = "PSSYSSEQUENCEID")
   @Override
   public IPSSysSequence getPSSysSequence() throws Exception {
      if (StringHelper.Compare(this.getSequenceMode(), "NONE", false) == 0) {
         return null;
      }

      if (StringHelper.IsNullOrEmpty(this.getPSSysSequenceId())) {
         return null;
      }

      if (this.iPSSysSequence == null) {
         this.iPSSysSequence = this.getPSSystem().getPSSysSequence(this.getPSSysSequenceId());
      }

      return this.iPSSysSequence;
   }

   public String getPSSysSequenceId() {
      return this.psDEField.getPSSYSSEQUENCEID();
   }

   @PSModelRTMeta(description = "值计算表达式", hideempty = true, fields = "COMPUTEEXP")
   @Override
   public String getComputeExpression() {
      return this.psDEField.getCOMPUTEEXP();
   }

   @PSModelRTMeta(description = "值序列使用模式", ignoredumpvalues = "NONE", codelist = "DEFSequenceMode", group = "处理逻辑", order = 224, fields = "SEQUENCEMODE")
   @Override
   public String getSequenceMode() {
      return this.strSequenceMode;
   }

   @PSModelRTMeta(description = "值转换器使用模式", ignoredumpvalues = "NONE", codelist = "DEFTranslatorMode", group = "处理逻辑", order = 226, fields = "TRANSLATORMODE")
   @Override
   public String getTranslatorMode() {
      return this.strTranslatorMode;
   }

   @PSModelRTMeta(description = "系统值转换器", hideempty = true, dumpref = true, group = "处理逻辑", order = 227, fields = "PSSYSTRANSLATORID")
   @Override
   public IPSSysTranslator getPSSysTranslator() throws Exception {
      if (StringHelper.Compare(this.getTranslatorMode(), "NONE", false) == 0) {
         return null;
      }

      if (StringHelper.IsNullOrEmpty(this.getPSSysTranslatorId())) {
         return null;
      }

      if (this.iPSSysTranslator == null) {
         this.iPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getPSSysTranslatorId());
      }

      return this.iPSSysTranslator;
   }

   public String getPSSysTranslatorId() {
      return this.psDEField.getPSSYSTRANSLATORID();
   }

   @PSModelRTMeta(description = "主1:N关系属性映射集合", hideempty = true, group = "关系", order = 410)
   @Override
   public Iterator<IPSDER1NDEFieldMap> getMajorPSDER1NDEFieldMaps() throws Exception {
      Iterator<IPSDER1N> psDER1Ns = this.getPSDataEntity().getMajorPSDER1Ns();
      if (psDER1Ns == null) {
         return null;
      }

      List<IPSDER1NDEFieldMap> list = null;

      while (psDER1Ns.hasNext()) {
         IPSDER1N iPSDER1N = psDER1Ns.next();
         Iterator<IPSDER1NDEFieldMap> psDER1NDEFieldMaps = iPSDER1N.getPSDER1NDEFieldMaps();
         if (psDER1NDEFieldMaps != null) {
            while (psDER1NDEFieldMaps.hasNext()) {
               IPSDER1NDEFieldMap iPSDER1NDEFieldMap = psDER1NDEFieldMaps.next();
               if (iPSDER1NDEFieldMap.getMajorPSDEField() != null
                  && StringHelper.Compare(iPSDER1NDEFieldMap.getMajorPSDEField().getId(), this.getId(), false) == 0) {
                  if (list == null) {
                     list = new ArrayList<>();
                  }

                  list.add(iPSDER1NDEFieldMap);
               }
            }
         }
      }

      return list != null && list.size() != 0 ? list.iterator() : null;
   }

   @PSModelRTMeta(description = "从1:N关系属性映射集合", hideempty = true, group = "关系", order = 411)
   @Override
   public Iterator<IPSDER1NDEFieldMap> getMinorPSDER1NDEFieldMaps() throws Exception {
      Iterator<IPSDER1N> psDER1Ns = this.getPSDataEntity().getMinorPSDER1Ns();
      if (psDER1Ns == null) {
         return null;
      }

      List<IPSDER1NDEFieldMap> list = null;

      while (psDER1Ns.hasNext()) {
         IPSDER1N iPSDER1N = psDER1Ns.next();
         Iterator<IPSDER1NDEFieldMap> psDER1NDEFieldMaps = iPSDER1N.getPSDER1NDEFieldMaps();
         if (psDER1NDEFieldMaps != null) {
            while (psDER1NDEFieldMaps.hasNext()) {
               IPSDER1NDEFieldMap iPSDER1NDEFieldMap = psDER1NDEFieldMaps.next();
               if (iPSDER1NDEFieldMap.getMinorPSDEField() != null
                  && StringHelper.Compare(iPSDER1NDEFieldMap.getMinorPSDEField().getId(), this.getId(), false) == 0) {
                  if (list == null) {
                     list = new ArrayList<>();
                  }

                  list.add(iPSDER1NDEFieldMap);
               }
            }
         }
      }

      return list != null && list.size() != 0 ? list.iterator() : null;
   }

   @PSModelRTMeta(description = "查询选项", codelist = "DEFQueryCSMode", group = "搜索逻辑", order = 254, fields = "QUERYCS")
   @Override
   public String getQueryOption() {
      return this.psDEField.getQUERYCS();
   }

   @PSModelRTMeta(description = "属性标记", hideempty2 = true, fields = "FIELDTAG")
   @Override
   public String getFieldTag() {
      return this.psDEField.getFIELDTAG();
   }

   @PSModelRTMeta(description = "属性标记2", hideempty2 = true, fields = "FIELDTAG2")
   @Override
   public String getFieldTag2() {
      return this.psDEField.getFIELDTAG2();
   }

   public String getImportPSSysTranslatorId() {
      return this.psDEField.getIMPPSSYSTRANSLATORID();
   }

   @PSModelRTMeta(description = "默认导入值转换器", hideempty2 = true, fields = "IMPPSSYSTRANSLATORID")
   @Override
   public IPSSysTranslator getImportPSSysTranslator() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.getImportPSSysTranslatorId())) {
         return null;
      }

      if (this.importPSSysTranslator == null) {
         this.importPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getImportPSSysTranslatorId());
      }

      return this.importPSSysTranslator;
   }

   public String getExportPSSysTranslatorId() {
      return this.psDEField.getEXPPSSYSTRANSLATORID();
   }

   @PSModelRTMeta(description = "默认导出值转换器", hideempty2 = true, fields = "EXPPSSYSTRANSLATORID")
   @Override
   public IPSSysTranslator getExportPSSysTranslator() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.getExportPSSysTranslatorId())) {
         return null;
      }

      if (this.exportPSSysTranslator == null) {
         this.exportPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getExportPSSysTranslatorId());
      }

      return this.exportPSSysTranslator;
   }

   @Override
   protected String onGetMOSFileName() {
      return this.getName();
   }

   @Override
   public String getDynaModelFilePath() {
      return null;
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      putJsonProperty(objectNode, "name", this.getName());
      putJsonProperty(objectNode, "codeName", this.getCodeName());
   }

   @Override
   protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
      super.onFillModelNode(objectNode, strModelType);
      if (StringHelper.Compare(this.getCodeName(), this.getServiceCodeName(), false) != 0 && !StringHelper.IsNullOrEmpty(this.getServiceCodeName())) {
         objectNode.remove("serviceCodeName");
         objectNode.put("serviceCodeName", this.getServiceCodeName());
      }
   }

   @PSModelRTMeta(description = "代码表（运行时内联）", rtdump = 2, hideempty = true, child = true)
   @Override
   public IPSCodeList getInlinePSCodeList() {
      return null;
   }
}
