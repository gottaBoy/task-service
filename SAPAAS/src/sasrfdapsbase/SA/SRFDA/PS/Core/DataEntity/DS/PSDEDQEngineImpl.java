package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.Ctrl.DAQueryModelGrooveEngine;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDQEngineImpl implements IPSDEDQEngine {
   public static final String QMVALUE_ISNULL = "__SRFQMVALUE_ISNULL__";
   public static final String QMVALUE_ISNOTNULL = "__SRFQMVALUE_ISNOTNULL__";
   protected IPSDataEntity majorPSDataEntity = null;
   protected ISRFDAGlobalHelper iDAGlobalHelper = null;
   protected Hashtable<String, String> fieldExpMap = new Hashtable<>();
   protected Hashtable<String, Integer> fieldDataTypeMap = new Hashtable<>();
   private static final Log log = LogFactory.getLog(PSDEDQEngineImpl.class);
   protected String strQueryScript = "";
   protected String strQueryScriptTemp = "";
   protected String strQueryScriptWithCondition = "";
   protected ArrayList<CallParam> callParams = new ArrayList<>();
   protected String strDAQueryModelHelperId = "";
   private int nAliasIndex = 0;
   private ArrayList<String> majorDERList = null;
   private TreeMap<String, Integer> majorDERAliasMap = null;
   private ArrayList<String> majorConditionList = null;
   private DAQueryModelGrooveEngine grooveEngine = null;
   protected TreeMap<String, PSDEDQAlias> qmAliasMap = new TreeMap<>();
   protected TreeMap<String, PSDEDQDeclare> qmDeclareMap = new TreeMap<>();
   protected TreeMap<String, Integer> fieldCaseSensitiveMap = new TreeMap<>();
   public static final int QUERYCASESENSITIVE_EQ = 1;
   public static final int QUERYCASESENSITIVE_LIKE = 2;
   public static final int QUERYOPTION_LIKESPLIT = 4;
   public static final String TAG_DYNAMICTABLES = "__DYNAMICTABLES__";
   private int nMacroIndex = 1;
   protected ArrayList<PSDEDQEngineImpl.URLCondPair> urlCondPairList = new ArrayList<>();
   protected Map<String, Object> macroParams = new TreeMap<>();
   protected Map<String, String> globalParamMap = new LinkedHashMap<>();
   protected Map<String, Object> attributeMap = new LinkedHashMap<>();
   protected IPSDBType iPSDBType = null;
   protected ArrayList<IDEDataQueryCodeExp> deDataQueryCodeExpImplList = new ArrayList<>();
   protected ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondImplList = new ArrayList<>();
   protected boolean bTempData = false;
   private boolean bEnablePQL = false;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType, IPSDataEntity iPSDataEntity) throws Exception {
      this.majorPSDataEntity = iPSDataEntity;
      this.iDAGlobalHelper = iDAGlobalHelper;
      this.iPSDBType = iPSDBType;
      this.onInit();
   }

   protected void onInit() throws Exception {
   }

   protected String getDBType() {
      return this.iPSDBType.getId();
   }

   public void registerStaticParamValue(String strMacroParam, String strValue) {
      this.globalParamMap.put(strMacroParam, strValue);
   }

   public String getStaticParamValue(String strMacroParam) {
      return this.globalParamMap.get(strMacroParam);
   }

   public void compile(
      IPSDEDQMain mainQueryConfig,
      IPSDEDQMain mainQueryConfig2,
      boolean bDPControl,
      ArrayList<ArrayList<IPSDEDQMain>> notQueryConfigs,
      ArrayList<ArrayList<IPSDEDQMain>> orQueryConfigs
   ) throws Exception {
      this.compileEx(mainQueryConfig, mainQueryConfig2, bDPControl, notQueryConfigs, orQueryConfigs, false);
   }

   public void compileEx(
      IPSDEDQMain mainQueryConfig,
      IPSDEDQMain mainQueryConfig2,
      boolean bDPControl,
      ArrayList<ArrayList<IPSDEDQMain>> notQueryConfigs,
      ArrayList<ArrayList<IPSDEDQMain>> orQueryConfigs,
      boolean bDelete
   ) throws Exception {
      this.bEnablePQL = mainQueryConfig.getPSDEDataQuery().isEnablePQL();
      this.callParams.clear();
      ArrayList<String> mainConditionList = new ArrayList<>();
      ArrayList<String> derList = new ArrayList<>();
      TreeMap<String, Integer> derAliasMap = new TreeMap<>();
      derAliasMap.put("", 0);
      this.fieldExpMap.clear();
      this.deDataQueryCodeExpImplList.clear();
      TreeMap<String, String> extSelects = new TreeMap<>();
      StringBuilderEx script = new StringBuilderEx();
      StringBuilderEx scriptTemp = null;
      if (this.majorPSDataEntity.isEnableTempDataBackend()) {
         scriptTemp = new StringBuilderEx();
      }

      TreeMap<String, Integer> selectColumns = new TreeMap<>();
      Iterator<IPSDEDQColumn> selectPSQMColumns = mainQueryConfig.getSelectedPSDEDQColumns();
      if (selectPSQMColumns != null) {
         while (selectPSQMColumns.hasNext()) {
            IPSDEDQColumn iPSQMColumn = selectPSQMColumns.next();
            selectColumns.put(iPSQMColumn.getName().toUpperCase(), 1);
         }
      }

      if (mainQueryConfig2 != null) {
         selectPSQMColumns = mainQueryConfig2.getSelectedPSDEDQColumns();
         if (selectPSQMColumns != null) {
            while (selectPSQMColumns.hasNext()) {
               IPSDEDQColumn iPSQMColumn = selectPSQMColumns.next();
               selectColumns.put(iPSQMColumn.getName().toUpperCase(), 1);
            }
         }
      }

      if (mainQueryConfig.getPSDEDataQuery().getViewLevel() == 100 && mainQueryConfig.getPSDEDataQuery().getPSDEFGroup() != null) {
         Iterator<IPSDEFGroupDetail> psDEFGroupDetails = mainQueryConfig.getPSDEDataQuery().getPSDEFGroup().getPSDEFGroupDetails();
         if (psDEFGroupDetails != null) {
            while (psDEFGroupDetails.hasNext()) {
               IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
               selectColumns.put(iPSDEFGroupDetail.getPSDEField().getName().toUpperCase(), 1);
            }
         }

         selectColumns.put(this.majorPSDataEntity.getKeyPSDEField().getName().toUpperCase(), 1);
      }

      String strRealQueryCode = null;
      if (this.majorPSDataEntity.isVirtual() && this.majorPSDataEntity.getVirtualMode() == 3) {
         int nIndex = 0;
         net.ibizsys.paas.util.StringBuilderEx unionAll = new net.ibizsys.paas.util.StringBuilderEx();
         Iterator<IPSDERIndex> psDERIndexs = this.majorPSDataEntity.getPSDERIndexs(true);
         if (psDERIndexs != null) {
            while (psDERIndexs.hasNext()) {
               IPSDERIndex iPSDERIndex = psDERIndexs.next();
               if (!iPSDERIndex.isInherit()) {
                  Map<String, IPSDEField> fieldMap = new LinkedHashMap<>();
                  ArrayList<IPSDEDQColumn> psDEDQColumnList = new ArrayList<>();
                  if (this.majorPSDataEntity.getKeyPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField() != null) {
                     PSDEDQColumnImpl psDEDQColumnImpl = new PSDEDQColumnImpl();
                     psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField().getName());
                     psDEDQColumnList.add(psDEDQColumnImpl);
                     fieldMap.put(this.majorPSDataEntity.getKeyPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField());
                  }

                  if (this.majorPSDataEntity.getMajorPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField() != null) {
                     PSDEDQColumnImpl psDEDQColumnImpl = new PSDEDQColumnImpl();
                     psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField().getName());
                     psDEDQColumnList.add(psDEDQColumnImpl);
                     fieldMap.put(this.majorPSDataEntity.getMajorPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField());
                  }

                  Iterator<IPSDERIndexDEFieldMap> psDERIndexDEFieldMaps = iPSDERIndex.getPSDERIndexDEFieldMaps();
                  if (psDERIndexDEFieldMaps != null) {
                     while (psDERIndexDEFieldMaps.hasNext()) {
                        IPSDERIndexDEFieldMap iPSDERIndexDEFieldMap = psDERIndexDEFieldMaps.next();
                        if (iPSDERIndexDEFieldMap.getMinorPSDEField() != null && iPSDERIndexDEFieldMap.getMajorPSDEField() != null) {
                           PSDEDQColumnImpl psDEDQColumnImpl = new PSDEDQColumnImpl();
                           psDEDQColumnImpl.setName(iPSDERIndexDEFieldMap.getMinorPSDEField().getName());
                           psDEDQColumnList.add(psDEDQColumnImpl);
                           fieldMap.put(iPSDERIndexDEFieldMap.getMajorPSDEField().getName(), iPSDERIndexDEFieldMap.getMinorPSDEField());
                        }
                     }
                  }

                  PSDEDQEngineImpl psDEDQEngineImpl = new PSDEDQEngineImpl();
                  psDEDQEngineImpl.init(this.GetDAGlobalHelper(), this.iPSDBType, iPSDERIndex.getMinorPSDataEntity());
                  SimplePSDEDQMainImpl simplePSDEDQMainImpl = new SimplePSDEDQMainImpl();
                  simplePSDEDQMainImpl.init(this.iDAGlobalHelper, iPSDERIndex.getMinorPSDataEntity(), psDEDQColumnList);
                  psDEDQEngineImpl.compile(simplePSDEDQMainImpl);
                  String strCode = psDEDQEngineImpl.getQueryScript();
                  net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
                  nIndex++;
                  sb.append("SELECT\n");
                  if (this.majorPSDataEntity.getIndexTypePSDEField() == null) {
                     throw new Exception("索引主实体没有定义类型属性");
                  }

                  IPSDEFDTColumn iPSDEFDTColumn = this.majorPSDataEntity.getIndexTypePSDEField().getPSDTColumn(this.getDBType());
                  if (DataTypeHelper.IsStringType(this.majorPSDataEntity.getIndexTypePSDEField().getStdDataType())) {
                     sb.append("'%1$s' AS %2$s", iPSDERIndex.getTypeValue(), this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                  } else {
                     sb.append("%1$s AS %2$s", iPSDERIndex.getTypeValue(), this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                  }

                  Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();

                  while (psDEFields.hasNext()) {
                     IPSDEField iPSDEField = psDEFields.next();
                     if (!iPSDEField.isDynaStorageDEField() && !iPSDEField.isUIAssistDEField() && !iPSDEField.isIndexTypeDEField()) {
                        IPSDEFDTColumn iPSDEFDTColumnx = iPSDEField.getPSDTColumn(this.getDBType());
                        if (StringHelper.IsNullOrEmpty(iPSDEFDTColumnx.getFormulaFormat()) || StringHelper.IsNullOrEmpty(iPSDEFDTColumnx.getFormulaColumns())) {
                           IPSDEField minorPSDEField = fieldMap.get(iPSDEField.getName());
                           if (minorPSDEField == null) {
                              sb.append(",NULL AS %1$s\n", this.iPSDBType.getDBObjStandardName(iPSDEFDTColumnx.getColumnName()));
                           } else {
                              IPSDEFDTColumn minorPSDEFDTColumn = minorPSDEField.getPSDTColumn(this.getDBType());
                              sb.append(
                                 ",v%1$s.%2$s AS %3$s\n",
                                 nIndex,
                                 this.iPSDBType.getDBObjStandardName(minorPSDEFDTColumn.getColumnName()),
                                 this.iPSDBType.getDBObjStandardName(iPSDEFDTColumnx.getColumnName())
                              );
                           }
                        }
                     }
                  }

                  sb.append("FROM\n");
                  sb.append("(%1$s) v%2$s\n", strCode, nIndex);
                  if (nIndex > 1) {
                     unionAll.append("UNION ALL\n");
                  }

                  unionAll.append(sb.toString());
               }
            }
         }

         strRealQueryCode = unionAll.toString();
         if (StringHelper.IsNullOrEmpty(strRealQueryCode)) {
            throw new Exception("索引主实体未定义任何索引关系");
         }
      }

      boolean bSelectColumn = selectColumns.size() > 0;
      Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         if (!iPSDEField.isDynaStorageDEField() && !iPSDEField.isUIAssistDEField()) {
            if (!iPSDEField.isPhisicalDEField() && iPSDEField.isLinkDEField()) {
               IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
               boolean bIgnore = false;

               while (iPSLinkDEField != null) {
                  if (iPSLinkDEField.getPSDER() instanceof IPSDER1NBase) {
                     IPSDER1NBase iPSDER1NBase = (IPSDER1NBase)iPSLinkDEField.getPSDER();
                     if (iPSDER1NBase.getPickupPSDEField() != null && !iPSDER1NBase.getPickupPSDEField().isPhisicalDEField()) {
                        bIgnore = true;
                        break;
                     }
                  }

                  IPSDEField relatedPSDEField = iPSLinkDEField.getRelatedPSDEField();
                  if (!relatedPSDEField.getPSDataEntity().isEnableSQLStorage() && iPSLinkDEField.getPSDataEntity().getVirtualMode() != 5) {
                     bIgnore = true;
                     break;
                  }

                  if (relatedPSDEField.isPhisicalDEField()) {
                     if (relatedPSDEField.isDynaStorageDEField()) {
                        bIgnore = true;
                     }
                     break;
                  }

                  if (!relatedPSDEField.isLinkDEField()) {
                     if (relatedPSDEField.isUIAssistDEField()) {
                        bIgnore = true;
                     }
                     break;
                  }

                  iPSLinkDEField = (IPSLinkDEField)relatedPSDEField;
               }

               if (bIgnore) {
                  String strMsg = String.format(
                     "属性[%1$s]引用实体[%2$s]属性[%3$s]不支持SQL存储，忽略",
                     iPSDEField.getName(),
                     iPSLinkDEField.getRelatedPSDataEntity().getName(),
                     iPSLinkDEField.getRelatedPSDEField().getName()
                  );
                  log.warn(strMsg);
                  ((IPSSystemUtil)this.getPSSystem())
                     .getPSSysConsole()
                     .warn(String.format("实体[%1$s]数据查询[%2$s]", this.getMajorPSDataEntity().getName(), mainQueryConfig.getPSDEDataQuery().getName()), strMsg);
                  continue;
               }
            }

            if ((!bSelectColumn || !selectColumns.containsKey(iPSDEField.getName()))
               && (!iPSDEField.isQueryColumn(mainQueryConfig.getPSDEDataQuery().getViewLevel()) || bSelectColumn)
               && (!iPSDEField.isQueryColumn() || !selectColumns.containsKey(iPSDEField.getName()))) {
               if (iPSDEField.isPhisicalDEField() || iPSDEField.isInheritDEField()) {
                  IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
                  String strPSDEFieldExp = null;
                  if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
                     strPSDEFieldExp = StringHelper.Format("%1$s.%2$s", "t1", this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                     this.setFieldQueryCaseSensitive(strPSDEFieldExp, iPSDEFDTColumn.getQueryCaseSenstive());
                  } else {
                     strPSDEFieldExp = this.getPSDEFieldExp(iPSDEField, "", derAliasMap, derList);
                  }

                  int nDataType = iPSDEField.getStdDataType();
                  this.fieldDataTypeMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), nDataType);
                  this.fieldExpMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), strPSDEFieldExp);
               }
            } else {
               IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
               String strPSDEFieldExp = null;
               if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
                  strPSDEFieldExp = StringHelper.Format("%1$s.%2$s", "t1", this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                  this.setFieldQueryCaseSensitive(strPSDEFieldExp, iPSDEFDTColumn.getQueryCaseSenstive());
               } else {
                  strPSDEFieldExp = this.getPSDEFieldExp(iPSDEField, "", derAliasMap, derList);
               }

               if (iPSDEField.getStringLength() != -1 && iPSDEField.getStringLength() > 8000) {
                  log.error(StringHelper.Format("长文本属性[%1$s]放入查询中，会影响检索性能", iPSDEField.getName()));
               }

               extSelects.put(iPSDEFDTColumn.getFormalColumnName().toUpperCase(), strPSDEFieldExp);
               int nDataType = iPSDEField.getStdDataType();
               this.fieldDataTypeMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), nDataType);
               this.fieldExpMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), strPSDEFieldExp);
            }
         }
      }

      IPSDEField keyPSDEField = this.majorPSDataEntity.getKeyPSDEField();
      if (keyPSDEField == null) {
         throw PSDataEntityException.create(this.getMajorPSDataEntity(), 20014);
      }

      IPSDEDBConfig majorPSDEDBConfig = this.majorPSDataEntity.getPSDEDBConfig(this.getDBType());
      String strMainTable = majorPSDEDBConfig.getTableName();
      String strUserTable = "";
      String strSaaSDCIdColName = "";
      if (this.majorPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD || this.majorPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3) {
         strSaaSDCIdColName = majorPSDEDBConfig.getSaaSDCIdColumnName();
      }

      if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
         strMainTable = majorPSDEDBConfig.getViewName(mainQueryConfig.getPSDEDataQuery().getViewLevel());
      }

      if (this.getMajorPSDataEntity().isVirtual()) {
         if (this.getMajorPSDataEntity().getKeyPSDEField() == null) {
            throw PSDataEntityException.create(this.getMajorPSDataEntity(), 20014);
         }

         if (this.getMajorPSDataEntity().getKeyPSDEField() instanceof IPSLinkDEField) {
            IPSDataEntity realPSDataEntity = ((IPSLinkDEField)this.getMajorPSDataEntity().getKeyPSDEField()).getRealPSDEField(true).getPSDataEntity();
            strMainTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getTableName();
            strUserTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getUserTable();
            if (realPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD || realPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3) {
               strSaaSDCIdColName = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
            }

            if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
               strMainTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getViewName(mainQueryConfig.getPSDEDataQuery().getViewLevel());
               strUserTable = "";
            }
         }
      }

      boolean bDynamicTable = false;
      if (!StringHelper.IsNullOrEmpty(strRealQueryCode)) {
         script.Append("\nFROM (%1$s) t1 \n", strRealQueryCode);
      } else {
         script.Append("\nFROM %1$s t1 \n", this.iPSDBType.getDBObjStandardName(strMainTable));
         if (!StringHelper.IsNullOrEmpty(strUserTable) && !bDelete) {
            script.Append(
               "INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s",
               this.iPSDBType.getDBObjStandardName(strUserTable),
               this.iPSDBType.getDBObjStandardName(keyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
            );
            if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
               script.Append(" AND t2.%1$s = '__SRFSAASDCID__'", strSaaSDCIdColName);
            }

            script.Append("\n");
         }

         if (scriptTemp != null) {
            scriptTemp.Append("\nFROM %1$s t1 \n", this.iPSDBType.getDBObjStandardName(strMainTable + "_TMP"));
            if (!StringHelper.IsNullOrEmpty(strUserTable) && !bDelete) {
               scriptTemp.Append(
                  "INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s",
                  this.iPSDBType.getDBObjStandardName(strUserTable + "_TMP"),
                  this.iPSDBType.getDBObjStandardName(keyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  scriptTemp.Append(" AND t2.%1$s = '__SRFSAASDCID__'", strSaaSDCIdColName);
               }

               scriptTemp.Append("\n");
            }
         }
      }

      PSDEDQAlias qmAlias = new PSDEDQAlias();
      qmAlias.setPSDataEntity(this.majorPSDataEntity);
      qmAlias.setParentDER("");
      qmAlias.setDERAliasMap(derAliasMap);
      qmAlias.setDERList(derList);
      qmAlias.setAliasIndex(0);
      this.qmAliasMap.put("MAIN", qmAlias);
      if (!StringHelper.IsNullOrEmpty(mainQueryConfig.getAlias())) {
         this.qmAliasMap.put(mainQueryConfig.getAlias().toLowerCase(), qmAlias);
      }

      if (mainQueryConfig.getChildPSDEDQJoins() != null) {
         Iterator<IPSDEDQJoin> psQMJoinQuerys = mainQueryConfig.getChildPSDEDQJoins();

         while (psQMJoinQuerys.hasNext()) {
            IPSDEDQJoin joinQueryConfig = psQMJoinQuerys.next();
            if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1RIGHT", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOMN1", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11M", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NLEFTOUT", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1N", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
               mainConditionList.add(strCondition);
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1N", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
               mainConditionList.add(strCondition);
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NNOT", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
               mainConditionList.add("NOT(" + strCondition + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1NNOT", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
               mainConditionList.add("NOT(" + strCondition + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEX", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEXM", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  mainConditionList,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  extSelects
               );
            }
         }
      }

      if (mainQueryConfig2 != null && mainQueryConfig2.getChildPSDEDQJoins() != null) {
         if (!StringHelper.IsNullOrEmpty(mainQueryConfig2.getAlias())) {
            this.qmAliasMap.put(mainQueryConfig2.getAlias().toLowerCase(), qmAlias);
         }

         this.complie(mainQueryConfig2, this.majorPSDataEntity, derAliasMap, derList, mainConditionList, extSelects);
      }

      if (bDPControl) {
         if (notQueryConfigs != null) {
            for (ArrayList<IPSDEDQMain> notList : notQueryConfigs) {
               ArrayList<String> listconditions = new ArrayList<>();

               for (IPSDEDQMain queryConfig : notList) {
                  if (!StringHelper.IsNullOrEmpty(queryConfig.getAlias())) {
                     this.qmAliasMap.put(queryConfig.getAlias().toLowerCase(), qmAlias);
                  }

                  ArrayList<String> conditions = new ArrayList<>();
                  this.complie(queryConfig, this.majorPSDataEntity, derAliasMap, derList, conditions, null);
                  if (queryConfig.getPSDEDQGroupCondition() != null) {
                     String strGroupCondition = this.getGroupCondition(this.majorPSDataEntity, "", queryConfig.getPSDEDQGroupCondition(), derAliasMap, derList);
                     if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
                        conditions.add(strGroupCondition);
                     }
                  }

                  if (conditions.size() != 0) {
                     String strTotalCond = "";

                     for (String strCond : conditions) {
                        if (!StringHelper.IsNullOrEmpty(strCond)) {
                           if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                              strTotalCond = strTotalCond + " AND ";
                           }

                           strTotalCond = strTotalCond + strCond;
                        }
                     }

                     if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                        if (queryConfig.isExcludeMode()) {
                           strTotalCond = "NOT " + strTotalCond;
                        }

                        listconditions.add(strTotalCond);
                     }
                  }
               }

               if (listconditions.size() != 0) {
                  String strTotalCond = "";

                  for (String strCond : listconditions) {
                     if (!StringHelper.IsNullOrEmpty(strCond)) {
                        if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                           strTotalCond = strTotalCond + " AND ";
                        }

                        strTotalCond = strTotalCond + strCond;
                     }
                  }

                  if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                     mainConditionList.add("NOT (" + strTotalCond + ")");
                  }
               }
            }
         }

         String strOrTotalCond = "";
         if (orQueryConfigs != null) {
            for (ArrayList<IPSDEDQMain> orList : orQueryConfigs) {
               ArrayList<String> listconditions = new ArrayList<>();

               for (IPSDEDQMain queryConfig : orList) {
                  if (!StringHelper.IsNullOrEmpty(queryConfig.getAlias())) {
                     this.qmAliasMap.put(queryConfig.getAlias().toLowerCase(), qmAlias);
                  }

                  ArrayList<String> conditions = new ArrayList<>();
                  this.complie(queryConfig, this.majorPSDataEntity, derAliasMap, derList, conditions, null);
                  if (queryConfig.getPSDEDQGroupCondition() != null) {
                     String strGroupCondition = this.getGroupCondition(this.majorPSDataEntity, "", queryConfig.getPSDEDQGroupCondition(), derAliasMap, derList);
                     if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
                        conditions.add(strGroupCondition);
                     }
                  }

                  if (conditions.size() != 0) {
                     String strTotalCond = "";

                     for (String strCond : conditions) {
                        if (!StringHelper.IsNullOrEmpty(strCond)) {
                           if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                              strTotalCond = strTotalCond + " AND ";
                           }

                           strTotalCond = strTotalCond + strCond;
                        }
                     }

                     if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                        if (queryConfig.isExcludeMode()) {
                           strTotalCond = "NOT" + strTotalCond;
                        }

                        listconditions.add(strTotalCond);
                     }
                  }
               }

               if (listconditions.size() != 0) {
                  String strTotalCond = "";

                  for (String strCond : listconditions) {
                     if (!StringHelper.IsNullOrEmpty(strCond)) {
                        if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                           strTotalCond = strTotalCond + " AND ";
                        }

                        strTotalCond = strTotalCond + strCond;
                     }
                  }

                  if (!StringHelper.IsNullOrEmpty(strTotalCond)) {
                     if (!StringHelper.IsNullOrEmpty(strOrTotalCond)) {
                        strOrTotalCond = strOrTotalCond + " OR ";
                     }

                     strOrTotalCond = strOrTotalCond + "(" + strTotalCond + ")";
                  }
               }
            }
         }

         if (StringHelper.IsNullOrEmpty(strOrTotalCond)) {
            strOrTotalCond = "(1<>1)";
         }

         mainConditionList.add(strOrTotalCond);
      }

      if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
         mainConditionList.add(StringHelper.Format("t1.%1$s = '__SRFSAASDCID__'", strSaaSDCIdColName));
      }

      if (this.majorPSDataEntity.isLogicValid()) {
         IPSDEField iPSDEField = this.majorPSDataEntity.getPSDEFieldByPDT("LOGICVALID", false);
         if (iPSDEField == null) {
            throw new Exception(StringHelper.Format("无法找到实体[%1$s]的逻辑有效属性", this.majorPSDataEntity.getFullName()));
         }

         mainConditionList.add(
            StringHelper.Format(
               "t1.%1$s = %2$s",
               iPSDEField.getPSDTColumn(this.getDBType()).getFormalColumnName(),
               this.majorPSDataEntity.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true)
            )
         );
      }

      if (this.majorPSDataEntity.isVirtual() && this.majorPSDataEntity.getVirtualMode() == 2) {
         IPSDERInherit iPSDERInherit = this.majorPSDataEntity.getPSDERInherit();
         if (iPSDERInherit == null) {
            throw new Exception(StringHelper.Format("无法找到实体[%1$s]的继承关系", this.majorPSDataEntity.getFullName()));
         }

         IPSDEField indexTypePSDEField = this.majorPSDataEntity.getInheritPSDataEntity().getIndexTypePSDEField();
         IPSDEField curIndexTypePSDEField = null;
         psDEFields = this.majorPSDataEntity.getAllPSDEFields();

         while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (iPSDEField instanceof IPSLinkDEField
               && StringHelper.Compare(((IPSLinkDEField)iPSDEField).getRelatedPSDEField().getId(), indexTypePSDEField.getId(), false) == 0) {
               curIndexTypePSDEField = iPSDEField;
               break;
            }
         }

         if (curIndexTypePSDEField == null) {
            throw new Exception(StringHelper.Format("无法找到实体[%1$s]的继承识别属性", this.majorPSDataEntity.getFullName()));
         }

         String strPSDEFieldExp = this.getPSDEFieldExp(curIndexTypePSDEField, "", derAliasMap, derList);
         mainConditionList.add(this.getConditionSQL(strPSDEFieldExp, curIndexTypePSDEField.getStdDataType(), "=", iPSDERInherit.getTypeValue(), ""));
      }

      if (mainQueryConfig.getPSDEDQGroupCondition() != null) {
         String strGroupCondition = this.getGroupCondition(this.majorPSDataEntity, "", mainQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList);
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      if (mainQueryConfig2 != null && mainQueryConfig2.getPSDEDQGroupCondition() != null) {
         String strGroupCondition = this.getGroupCondition(this.majorPSDataEntity, "", mainQueryConfig2.getPSDEDQGroupCondition(), derAliasMap, derList);
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      TreeMap<String, Integer> joinMap = new TreeMap<>();

      for (String strDERs : derList) {
         this.getJoin(script, scriptTemp, this.majorPSDataEntity, this.majorPSDataEntity.isEnableTempDataBackend(), "", strDERs, derAliasMap, joinMap);
      }

      this.majorConditionList = mainConditionList;
      if (bDelete) {
         this.strQueryScript = "DELETE \n";
      } else {
         this.strQueryScript = "SELECT\n";
         if (mainQueryConfig.isDistinctMode()) {
            this.strQueryScript = this.strQueryScript + " DISTINCT\n";
         }

         int nIndex = 0;
         boolean bFirst = true;

         for (String strColumnName : extSelects.keySet()) {
            if (bFirst) {
               bFirst = false;
            } else {
               this.strQueryScript = this.strQueryScript + ",\n";
            }

            String strField = extSelects.get(strColumnName);
            if (StringHelper.Compare(majorPSDEDBConfig.getObjNameCase(), "UCASE", true) == 0) {
               strColumnName = strColumnName.toUpperCase();
            } else if (StringHelper.Compare(majorPSDEDBConfig.getObjNameCase(), "LCASE", true) == 0) {
               strColumnName = strColumnName.toLowerCase();
            }

            String[] parts = strField.split("[.]");
            String strAlias = this.iPSDBType.getDBObjStandardName(strColumnName);
            if (parts.length == 2 && StringHelper.Compare(parts[1], strAlias, false) == 0) {
               this.strQueryScript = this.strQueryScript + StringHelper.Format("%1$s", strField);
            } else {
               this.strQueryScript = this.strQueryScript + StringHelper.Format("%1$s AS %2$s", strField, strAlias);
            }

            PSDEDQEngineImpl.DEDataQueryCodeExpImpl deDataQueryCodeExpImpl = new PSDEDQEngineImpl.DEDataQueryCodeExpImpl();
            deDataQueryCodeExpImpl.setName(strColumnName);
            deDataQueryCodeExpImpl.setExpression(strField);
            deDataQueryCodeExpImpl.setShowOrder(nIndex);
            nIndex++;
            this.deDataQueryCodeExpImplList.add(deDataQueryCodeExpImpl);
         }
      }

      if (scriptTemp != null) {
         this.strQueryScriptTemp = this.strQueryScript;
         if (!bDelete) {
            this.strQueryScriptTemp = this.strQueryScriptTemp
               + StringHelper.Format(
                  ",t1.%1$s AS %1$s,t1.%2$s AS %2$s", this.iPSDBType.getDBObjStandardName("SRFORIKEY"), this.iPSDBType.getDBObjStandardName("SRFDRAFTFLAG")
               );
         }
      }

      this.strQueryScript = this.strQueryScript + script.toString();
      if (scriptTemp != null) {
         this.strQueryScriptTemp = this.strQueryScriptTemp + scriptTemp.toString();
      }

      this.majorDERList = derList;
      this.majorDERAliasMap = derAliasMap;

      for (String strColumnName : this.fieldExpMap.keySet()) {
         if (!extSelects.containsKey(strColumnName)) {
            String strExpression = this.fieldExpMap.get(strColumnName);
            PSDEDQEngineImpl.DEDataQueryCodeExpImpl deDataQueryCodeExpImpl = new PSDEDQEngineImpl.DEDataQueryCodeExpImpl();
            deDataQueryCodeExpImpl.setName(strColumnName);
            deDataQueryCodeExpImpl.setExpression(strExpression);
            deDataQueryCodeExpImpl.setShowOrder(-1);
            this.deDataQueryCodeExpImplList.add(deDataQueryCodeExpImpl);
         }
      }

      for (String strCondition : this.majorConditionList) {
         PSDEDQEngineImpl.DEDataQueryCodeCondImpl deDataQueryCodeCondImpl = new PSDEDQEngineImpl.DEDataQueryCodeCondImpl();
         deDataQueryCodeCondImpl.setName("");
         deDataQueryCodeCondImpl.setCustomCond(strCondition);
         deDataQueryCodeCondImpl.setShowOrder(-1);
         this.deDataQueryCodeCondImplList.add(deDataQueryCodeCondImpl);
      }

      String strAlias = "";

      for (String strAliasName : this.qmAliasMap.keySet()) {
         if (StringHelper.Compare(strAliasName, "MAIN", true) != 0) {
            PSDEDQAlias psDEDQAlias = this.qmAliasMap.get(strAliasName);
            if (!StringHelper.IsNullOrEmpty(strAlias)) {
               strAlias = strAlias + ",";
            }

            strAlias = strAlias + String.format("ALIAS.%1$s=t%2$s", strAliasName, psDEDQAlias.getAliasIndex() + 1);
         }
      }

      if (!StringHelper.IsNullOrEmpty(strAlias)) {
         this.strQueryScript = this.strQueryScript + String.format("\r\n/*%1$s*/", strAlias);
      }
   }

   @Override
   public void compile(IPSDEDQMain mainQueryConfig) throws Exception {
      this.compile(mainQueryConfig, null, false, null, null);
   }

   public void compile(IPSDEDQMain mainQueryConfig, IPSDEDQMain mainQueryConfig2) throws Exception {
      this.compileEx(mainQueryConfig, mainQueryConfig2, false, null, null, false);
   }

   public void compileEx(IPSDEDQMain mainQueryConfig, IPSDEDQMain mainQueryConfig2, boolean bDeleteMode) throws Exception {
      this.compileEx(mainQueryConfig, mainQueryConfig2, false, null, null, bDeleteMode);
   }

   private final void complie(
      IPSDEDQMain mainQueryConfig,
      IPSDataEntity iPSDataEntity,
      TreeMap<String, Integer> derAliasMap,
      ArrayList<String> derList,
      ArrayList<String> conditionList,
      TreeMap<String, String> extSelects
   ) throws Exception {
      Iterator<IPSDEDQJoin> psQMJoinQuerys = mainQueryConfig.getChildPSDEDQJoins();
      if (psQMJoinQuerys != null) {
         while (psQMJoinQuerys.hasNext()) {
            IPSDEDQJoin joinQueryConfig = psQMJoinQuerys.next();
            if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1RIGHT", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOMN1", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11M", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NLEFTOUT", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1N", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
               conditionList.add(strCondition);
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1N", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
               conditionList.add(strCondition);
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NNOT", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
               conditionList.add("NOT(" + strCondition + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1NNOT", true) == 0) {
               String strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
               conditionList.add("NOT(" + strCondition + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEX", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  false,
                  extSelects
               );
            } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEXM", true) == 0) {
               this.buildJoinQuery(
                  this.majorPSDataEntity,
                  joinQueryConfig,
                  "",
                  derAliasMap,
                  derList,
                  conditionList,
                  false,
                  false,
                  false,
                  false,
                  false,
                  true,
                  false,
                  false,
                  extSelects
               );
            }
         }
      }
   }

   public void compileRawCodeMode(String strQuerySQL, String strQueryCond, String strQueryParam, String strQueryField) throws Exception {
      this.strQueryScript = strQuerySQL;
      if (!StringHelper.IsNullOrEmpty(strQueryCond)) {
         if (this.majorConditionList == null) {
            this.majorConditionList = new ArrayList<>();
         }

         this.majorConditionList.add(strQueryCond);
      }

      try {
         strQueryParam = strQueryParam.replace("\r\n", "\n");
         String[] params = strQueryParam.split("[\n]");

         for (int i = 0; i < params.length; i++) {
            String strParam = params[i];
            strParam = strParam.trim();
            if (!StringHelper.IsNullOrEmpty(strParam)) {
               CallParam callParam = new CallParam();
               callParam.setParamName(strParam);
               this.callParams.add(callParam);
            }
         }
      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new Exception(StringHelper.Format("加载查询变量发生错误，%1$s", e.getMessage()));
      }

      this.fieldExpMap.clear();
      this.fieldDataTypeMap.clear();
      Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();

      while (psDEFields.hasNext()) {
         IPSDEField iPSDEField = psDEFields.next();
         if (!iPSDEField.isDynaStorageDEField() && !iPSDEField.isUIAssistDEField()) {
            this.fieldDataTypeMap.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), iPSDEField.getStdDataType());
            this.fieldExpMap
               .put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), iPSDEField.getPSDTColumn(this.getDBType()).getColumnName());
         }
      }
   }

   @Override
   public String getQueryScript() {
      return this.strQueryScript;
   }

   @Override
   public String getQueryScriptTemp() {
      return this.strQueryScriptTemp;
   }

   public String getQueryModelScriptEx(ISRFExWebContext webContext) throws Exception {
      String strFinalScript = this.strQueryScript;

      for (PSDEDQEngineImpl.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   public String replaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext, boolean bTestPost) throws Exception {
      for (PSDEDQEngineImpl.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue) && bTestPost) {
            strParamValue = webContext.GetPostValue(condPair.strURLParam.toLowerCase());
         }

         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   public String replaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext) throws Exception {
      return this.replaceURLParamMacro(strFinalScript, webContext, false);
   }

   public String replaceDynamicTableMacro(String strFinalScript, ArrayList<String> dynamicTables) throws Exception {
      if (dynamicTables.size() == 0) {
         return strFinalScript.replace("__DYNAMICTABLES__", "没有找到对应的表");
      }

      if (dynamicTables.size() == 1) {
         strFinalScript = strFinalScript.replace("__DYNAMICTABLES__", dynamicTables.get(0));
      } else {
         String strTables = "(";
         boolean bFirst = true;

         for (String strTableName : dynamicTables) {
            if (bFirst) {
               bFirst = false;
            } else {
               strTables = strTables + " UNION ALL \n";
            }

            strTables = strTables + StringHelper.Format("SELECT * FROM %1$s \n", strTableName);
         }

         strTables = strTables + ")";
         strFinalScript = strFinalScript.replace("__DYNAMICTABLES__", strTables);
      }

      return strFinalScript;
   }

   public String getQueryModelScript(ArrayList<String> userConditionList) {
      ArrayList<String> conditionList = userConditionList;
      if (userConditionList == null) {
         conditionList = this.majorConditionList;
      }

      String strSql = this.strQueryScript;
      if (conditionList != null && conditionList.size() > 0) {
         strSql = strSql + " WHERE \n";
         boolean bFirst = true;

         for (String strCondition : conditionList) {
            if (bFirst) {
               bFirst = false;
            } else {
               strSql = strSql + " AND ";
            }

            strSql = strSql + strCondition;
         }
      }

      return strSql;
   }

   public String getQueryModelScriptEx(ArrayList<String> userConditionList, ISRFExWebContext webContext) throws Exception {
      ArrayList<String> conditionList = userConditionList;
      if (userConditionList == null) {
         conditionList = this.majorConditionList;
      }

      String strSql = this.strQueryScript;
      if (conditionList != null && conditionList.size() > 0) {
         strSql = strSql + " WHERE \n";
         boolean bFirst = true;

         for (String strCondition : conditionList) {
            if (bFirst) {
               bFirst = false;
            } else {
               strSql = strSql + " AND ";
            }

            strSql = strSql + strCondition;
         }
      }

      String strFinalScript = strSql;

      for (PSDEDQEngineImpl.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   public void fillQMDeclareParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId) {
      this.fillQMDeclareParams(list, webContext, iDAGlobalHelper, strCurPersonId, null);
   }

   public void fillQMDeclareParams(
      ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId, BaseDataEntity baseDataEntity
   ) {
      CallResult callResult = null;

      for (String strName : this.qmDeclareMap.keySet()) {
         PSDEDQDeclare qmDeclare = this.qmDeclareMap.get(strName);

         for (CallParam callParam : qmDeclare.getParams()) {
            CallParam cp = callParam.Clone();
            callResult = MacroHelper.GetValue(cp.getParamName(), webContext, iDAGlobalHelper, strCurPersonId, baseDataEntity);
            if (callResult.getRetCode() == 0) {
               Object objValue = callResult.getUserObject();
               if (objValue == null || StringHelper.Compare(objValue.toString(), cp.getParamName(), true) != 0) {
                  cp.setValue(objValue);
               }
            }

            list.add(cp);
         }
      }
   }

   public void fillCallParams(
      ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId, BaseDataEntity baseDataEntity
   ) {
      CallResult callResult = null;

      for (CallParam callParam : this.callParams) {
         CallParam cp = callParam.Clone();
         callResult = MacroHelper.GetValue(cp.getParamName(), webContext, iDAGlobalHelper, strCurPersonId, baseDataEntity);
         if (callResult.getRetCode() == 0) {
            Object objValue = callResult.getUserObject();
            if (objValue == null || StringHelper.Compare(objValue.toString(), cp.getParamName(), true) != 0) {
               cp.setValue(objValue);
            }
         }

         list.add(cp);
      }
   }

   public void fillCallParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId) {
      this.fillCallParams(list, webContext, iDAGlobalHelper, strCurPersonId, null);
   }

   public void fillMajorConditions(ArrayList<String> list) {
      if (this.majorConditionList != null) {
         for (String strCondition : this.majorConditionList) {
            list.add(strCondition);
         }
      }
   }

   private void buildJoinQuery(
      IPSDataEntity iPSDataEntity,
      IPSDEDQJoin joinQueryConfig,
      String strParentDER,
      TreeMap<String, Integer> derAliasMap,
      ArrayList<String> derList,
      ArrayList<String> mainConditionList,
      boolean bN1,
      boolean b11,
      boolean b11M,
      boolean b1NLEFTOUTER,
      boolean bIndex,
      boolean bIndexM,
      boolean bCustom,
      boolean bN1RIGHT,
      TreeMap<String, String> extSelects
   ) throws Exception {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      if (iPSDataEntity == null) {
         throw new Exception(StringHelper.Format("无法获取实体辅助对象"));
      }

      if (!iPSDataEntity.isEnableSQLStorage()) {
         log.warn(String.format("实体[%1$s]不支持SQL存储，忽略连接", iPSDataEntity.getName()));
      } else {
         String strDERID = joinQueryConfig.getDERId();
         String strMajorDEID = "";
         if (bN1 || b1NLEFTOUTER || bN1RIGHT) {
            if (bCustom) {
               IPSDERCustom der1N = (IPSDERCustom)this.getPSSystem().getPSDER(strDERID);
               if (bN1) {
                  strMajorDEID = der1N.getMajorPSDEId();
               } else if (b1NLEFTOUTER) {
                  strMajorDEID = der1N.getMinorPSDEId();
                  strDERID = "1NLO:" + strDERID;
               } else {
                  strMajorDEID = der1N.getMajorPSDEId();
                  strDERID = "N1R:" + strDERID;
               }
            } else {
               IPSDERBase derBase = this.getPSSystem().getPSDER(strDERID);
               if (bN1) {
                  strMajorDEID = derBase.getMajorPSDEId();
               } else if (b1NLEFTOUTER) {
                  strMajorDEID = derBase.getMinorPSDEId();
                  strDERID = "1NLO:" + strDERID;
               } else {
                  strMajorDEID = derBase.getMajorPSDEId();
                  strDERID = "N1R:" + strDERID;
               }
            }
         }

         if (b11 || b11M) {
            IPSDERBase derBase = this.getPSSystem().getPSDER(strDERID);
            if (b11) {
               strMajorDEID = derBase.getMajorPSDEId();
            } else {
               strMajorDEID = derBase.getMinorPSDEId();
               strDERID = "11M:" + strDERID;
            }
         }

         if (bIndex || bIndexM) {
            IPSDERIndex derIndex = (IPSDERIndex)this.getPSSystem().getPSDER(strDERID);
            if (bIndex) {
               strMajorDEID = derIndex.getMajorPSDEId();
               strDERID = "INDEX:" + strDERID;
            } else {
               strMajorDEID = derIndex.getMinorPSDEId();
               strDERID = "INDEXM:" + strDERID;
            }
         }

         String strNewDER = strParentDER;
         if (!StringHelper.IsNullOrEmpty(strNewDER)) {
            strNewDER = strNewDER + "|";
         }

         strNewDER = strNewDER + strDERID;
         if (!derAliasMap.containsKey(strNewDER)) {
            derAliasMap.put(strNewDER, this.getAliasIndex());
            String strLastDERID = "";
            if (derList.size() > 0) {
               strLastDERID = derList.get(derList.size() - 1);
            }

            if (strNewDER.indexOf(strLastDERID) == 0
               && (strNewDER.length() == strLastDERID.length() || strNewDER.charAt(strLastDERID.length()) == '|')
               && !StringHelper.IsNullOrEmpty(strLastDERID)) {
               derList.set(derList.size() - 1, strNewDER);
            } else {
               derList.add(strNewDER);
            }
         }

         int nCurAliasIndex = derAliasMap.get(strNewDER);
         IPSDataEntity iCurDEHelper = this.getPSDataEntity(strMajorDEID);
         if (extSelects != null) {
            Iterator<IPSDEDQColumn> psDEDQColumns = joinQueryConfig.getSelectedPSDEDQColumns();
            if (psDEDQColumns != null) {
               while (psDEDQColumns.hasNext()) {
                  IPSDEDQColumn iPSDEDQColumn = psDEDQColumns.next();
                  IPSDEField iPSDEField = iCurDEHelper.getPSDEField(iPSDEDQColumn.getName(), false);
                  String strFieldName = this.getPSDEFieldExp(iPSDEField, strNewDER, derAliasMap, derList);
                  extSelects.put(iPSDEDQColumn.getAlias(), strFieldName);
               }
            }
         }

         if (!StringHelper.IsNullOrEmpty(joinQueryConfig.getAlias())) {
            PSDEDQAlias qmAlias = new PSDEDQAlias();
            qmAlias.setPSDataEntity(iCurDEHelper);
            qmAlias.setParentDER(strNewDER);
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            qmAlias.setAliasIndex(nCurAliasIndex);
            this.qmAliasMap.put(joinQueryConfig.getAlias().toLowerCase(), qmAlias);
         }

         if (joinQueryConfig.getChildPSDEDQJoins() != null) {
            Iterator<IPSDEDQJoin> psDEDQJoinsIterator = joinQueryConfig.getChildPSDEDQJoins();

            while (psDEDQJoinsIterator.hasNext()) {
               IPSDEDQJoin subjoinQueryConfig = psDEDQJoinsIterator.next();
               if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "N1", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     true,
                     false,
                     false,
                     false,
                     false,
                     false,
                     false,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "N1RIGHT", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     false,
                     false,
                     false,
                     false,
                     false,
                     false,
                     true,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "CUSTOMN1", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     true,
                     false,
                     false,
                     false,
                     false,
                     false,
                     true,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "11", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     true,
                     false,
                     false,
                     false,
                     false,
                     false,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "11M", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     false,
                     true,
                     false,
                     false,
                     false,
                     false,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "1NLEFTOUT", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     false,
                     false,
                     true,
                     false,
                     false,
                     false,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "1N", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                  mainConditionList.add(strCondition);
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "CUSTOM1N", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                  mainConditionList.add(strCondition);
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "1NNOT", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                  mainConditionList.add("NOT(" + strCondition + ")");
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "CUSTOM1NNOT", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                  mainConditionList.add("NOT(" + strCondition + ")");
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "INDEX", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     false,
                     false,
                     false,
                     true,
                     false,
                     false,
                     false,
                     extSelects
                  );
               } else if (StringHelper.Compare(subjoinQueryConfig.getJoinType(), "INDEXM", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper,
                     subjoinQueryConfig,
                     strNewDER,
                     derAliasMap,
                     derList,
                     mainConditionList,
                     false,
                     false,
                     false,
                     false,
                     false,
                     true,
                     false,
                     false,
                     extSelects
                  );
               }
            }
         }

         if (joinQueryConfig.getPSDEDQGroupCondition() != null) {
            String strGroupCondition = this.getGroupCondition(iCurDEHelper, strNewDER, joinQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
               mainConditionList.add(strGroupCondition);
            }
         }
      }
   }

   protected String buildExistQuery(IPSDataEntity iPSDataEntity, IPSDEDQJoin existQueryConfig, int nAlias, boolean bCustom) throws Exception {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      if (iPSDataEntity == null) {
         throw new Exception(StringHelper.Format("无法获取实体辅助对象"));
      }

      if (!iPSDataEntity.isEnableSQLStorage()) {
         throw new Exception(StringHelper.Format("实体[%1$s]不支持SQL存储", iPSDataEntity.getName()));
      }

      String strDERID = existQueryConfig.getDERId();
      ArrayList<String> mainConditionList = new ArrayList<>();
      ArrayList<String> derList = new ArrayList<>();
      TreeMap<String, Integer> derAliasMap = new TreeMap<>();
      IPSDataEntity iCurDEHelper = null;
      int nCurAliasIndex = -1;
      StringBuilderEx script = new StringBuilderEx();
      boolean bFirst = true;
      if (bCustom) {
         IPSDERCustom der1N = (IPSDERCustom)this.getPSSystem().getPSDER(strDERID);
         iCurDEHelper = this.getPSDataEntity(der1N.getMinorPSDEId());
         nCurAliasIndex = this.getAliasIndex();
         if (!StringHelper.IsNullOrEmpty(existQueryConfig.getAlias())) {
            PSDEDQAlias qmAlias = new PSDEDQAlias();
            qmAlias.setPSDataEntity(iCurDEHelper);
            qmAlias.setParentDER("");
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            qmAlias.setAliasIndex(nCurAliasIndex);
            this.qmAliasMap.put(existQueryConfig.getAlias().toLowerCase(), qmAlias);
         }

         IPSDEField pKeyDEFHelper = iCurDEHelper.getKeyPSDEField();
         String strMainTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
         String strUserTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
         String strMainTable2 = strMainTable;
         String strUserTable2 = strUserTable;
         if (StringHelper.Compare(iCurDEHelper.getDBSchema(), this.majorPSDataEntity.getDBSchema(), true) != 0) {
            strMainTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.getDBSchema(), strMainTable);
            strUserTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.getDBSchema(), strUserTable);
         }

         derAliasMap.put("", nCurAliasIndex);
         script.Append("SELECT * FROM %1$s t%2$s \n", this.iPSDBType.getDBObjStandardName(strMainTable2), nCurAliasIndex + 1);
         if (!StringHelper.IsNullOrEmpty(strUserTable)) {
            script.Append(
               "INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n",
               this.iPSDBType.getDBObjStandardName(strUserTable2),
               this.iPSDBType.getDBObjStandardName(pKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
               nCurAliasIndex + 1,
               nCurAliasIndex + 2
            );
         }

         if (iCurDEHelper.isLogicValid()) {
            IPSDEField iValidDEFHelper = iCurDEHelper.getPSDEFieldByPDT("LOGICVALID", false);
            mainConditionList.add(
               StringHelper.Format(
                  "t%3$s.%1$s = %2$s",
                  this.iPSDBType.getDBObjStandardName(iValidDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  iCurDEHelper.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true),
                  nCurAliasIndex + 1
               )
            );
         }

         throw new Exception("没有实现自定义关系");
      } else {
         nCurAliasIndex = this.getAliasIndex();
         IPSDERBase derBase = this.getPSSystem().getPSDER(strDERID);
         if (!StringHelper.IsNullOrEmpty(existQueryConfig.getAlias())) {
            PSDEDQAlias qmAlias = new PSDEDQAlias();
            qmAlias.setPSDataEntity(iCurDEHelper);
            qmAlias.setParentDER("");
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            qmAlias.setAliasIndex(nCurAliasIndex);
            this.qmAliasMap.put(existQueryConfig.getAlias().toLowerCase(), qmAlias);
         }

         iCurDEHelper = this.getPSDataEntity(derBase.getMinorPSDEId());
         IPSDEField pKeyDEFHelper = iCurDEHelper.getKeyPSDEField();
         IPSDEField pickupDEFHelper = null;
         IPSDERCustom derCustom = null;
         if (derBase instanceof IPSDER1N) {
            IPSDER1N der1N = (IPSDER1N)derBase;
            pickupDEFHelper = der1N.getPickupPSDEField();
         } else if (derBase instanceof IPSDERCustom) {
            derCustom = (IPSDERCustom)derBase;
            pickupDEFHelper = derCustom.getPickupPSDEField();
         }

         if (pKeyDEFHelper == null) {
            throw new Exception(StringHelper.Format("无法获取实体[%1$s]的主键属性 ", iCurDEHelper.getFullName()));
         }

         if (pickupDEFHelper == null) {
            throw new Exception(StringHelper.Format("无法获取实体[%1$s]的与相关实体的关系属性 ", iCurDEHelper.getFullName()));
         }

         IPSDEField pickupRelatedDEFHelper = null;
         if (pickupDEFHelper instanceof IPSLinkDEField) {
            pickupRelatedDEFHelper = ((IPSLinkDEField)pickupDEFHelper).getRelatedPSDEField();
         }

         if (pickupRelatedDEFHelper == null) {
            if (derCustom != null) {
               pickupRelatedDEFHelper = iPSDataEntity.getKeyPSDEField();
            }

            if (pickupRelatedDEFHelper == null) {
               throw new Exception(StringHelper.Format("无法获取属性[%1$s]的关系属性 ", pickupDEFHelper.getFullName()));
            }
         }

         if (StringHelper.Compare(pickupRelatedDEFHelper.getPSDataEntity().getId(), iPSDataEntity.getId(), true) != 0) {
            throw new Exception(StringHelper.Format("关系属性[%1$s]的实体与上级实体不一致 ", pickupDEFHelper.getFullName()));
         }

         String strMainTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
         String strUserTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
         String strMainTable2 = strMainTable;
         String strUserTable2 = strUserTable;
         String strSaaSDCIdColName = "";
         if (iCurDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD || iCurDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3) {
            strSaaSDCIdColName = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
         }

         if (StringHelper.Compare(iCurDEHelper.getDBSchema(), this.majorPSDataEntity.getDBSchema(), true) != 0) {
            strMainTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.getDBSchema(), strMainTable);
            strUserTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.getDBSchema(), strUserTable);
         }

         derAliasMap.put("", nCurAliasIndex);
         script.Append("SELECT * FROM %1$s t%2$s \n", this.iPSDBType.getDBObjStandardName(strMainTable2), nCurAliasIndex + 1);
         if (!StringHelper.IsNullOrEmpty(strUserTable)) {
            script.Append(
               "INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s",
               this.iPSDBType.getDBObjStandardName(strUserTable2),
               this.iPSDBType.getDBObjStandardName(pKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
               nCurAliasIndex + 1,
               nCurAliasIndex + 2
            );
            if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
               script.Append(" AND t%1$s.%2$s = '__SRFSAASDCID__'", nCurAliasIndex + 2, strSaaSDCIdColName);
            }

            script.Append("\n");
         }

         if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
            mainConditionList.add(StringHelper.Format("t%1$s.%2$s = '__SRFSAASDCID__'", nCurAliasIndex + 1, strSaaSDCIdColName));
         }

         if (iCurDEHelper.isLogicValid()) {
            IPSDEField iValidDEFHelper = iCurDEHelper.getPSDEFieldByPDT("LOGICVALID", false);
            if (iValidDEFHelper == null) {
               throw new Exception(StringHelper.Format("无法找到实体[%1$s]的逻辑有效属性", iCurDEHelper.getFullName()));
            }

            mainConditionList.add(
               StringHelper.Format(
                  "t%3$s.%1$s = %2$s",
                  this.iPSDBType.getDBObjStandardName(iValidDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  iCurDEHelper.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true),
                  nCurAliasIndex + 1
               )
            );
         }

         boolean bMT = true;
         if (StringHelper.Compare(pickupDEFHelper.getPSDTColumn(this.getDBType()).getRealTableName(), strMainTable, true) == 0) {
            bMT = true;
         } else {
            bMT = false;
         }

         mainConditionList.add(
            StringHelper.Format(
               "t%1$s.%3$s = t%2$s.%4$s",
               nAlias + 1,
               nCurAliasIndex + (bMT ? 1 : 2),
               this.iPSDBType.getDBObjStandardName(pickupRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
               this.iPSDBType.getDBObjStandardName(pickupDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
            )
         );
         if (derCustom != null) {
            IPSDEField parentType = iCurDEHelper.getParentTypePSDEField();
            IPSDEField parentSubType = iCurDEHelper.getPSDEFieldByPDT("PARENTSUBTYPE", true);
            if (parentType != null) {
               String strFieldName = String.format(
                  "t%1$s.%2$s", nCurAliasIndex + (bMT ? 1 : 2), this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName())
               );
               mainConditionList.add(
                  parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null)
               );
            }

            if (parentSubType != null) {
               String strFieldName = String.format(
                  "t%1$s.%2$s",
                  nCurAliasIndex + (bMT ? 1 : 2),
                  this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName())
               );
               String strTypeValue = derCustom.getTypeValue();
               if (StringHelper.IsNullOrEmpty(strTypeValue)) {
                  strTypeValue = derCustom.getMinorCodeName();
               }

               if (!StringHelper.IsNullOrEmpty(strTypeValue)) {
                  mainConditionList.add(parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null));
               } else {
                  mainConditionList.add(parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null));
               }
            }
         }

         if (existQueryConfig.getChildPSDEDQJoins() != null) {
            Iterator<IPSDEDQJoin> childPSDEDQJoins = existQueryConfig.getChildPSDEDQJoins();

            while (childPSDEDQJoins.hasNext()) {
               IPSDEDQJoin joinQueryConfig = childPSDEDQJoins.next();
               if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "N1RIGHT", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOMN1", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "11M", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NLEFTOUT", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1N", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                  mainConditionList.add(strCondition);
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1N", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                  mainConditionList.add(strCondition);
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "1NNOT", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                  mainConditionList.add("NOT(" + strCondition + ")");
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "CUSTOM1NNOT", true) == 0) {
                  String strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                  mainConditionList.add("NOT(" + strCondition + ")");
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEX", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, null
                  );
               } else if (StringHelper.Compare(joinQueryConfig.getJoinType(), "INDEXM", true) == 0) {
                  this.buildJoinQuery(
                     iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, null
                  );
               }
            }
         }

         if (existQueryConfig.getPSDEDQGroupCondition() != null) {
            String strGroupCondition = this.getGroupCondition(iCurDEHelper, "", existQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
               mainConditionList.add(strGroupCondition);
            }
         }

         TreeMap<String, Integer> joinMap = new TreeMap<>();

         for (String strDERs : derList) {
            this.getJoin(script, null, iCurDEHelper, false, "", strDERs, derAliasMap, joinMap);
         }

         if (mainConditionList.size() > 0) {
            script.Append(" WHERE \n");
            bFirst = true;

            for (String strCondition : mainConditionList) {
               if (bFirst) {
                  bFirst = false;
               } else {
                  script.Append(" AND ");
               }

               script.Append(" %1$s ", strCondition);
            }
         }

         return "EXISTS(" + script.toString() + ")";
      }
   }

   public String getGroupCondition(IPSDEDQGroupCondition iPSDEDQGroupCondition) throws Exception {
      return this.getGroupCondition(this.majorPSDataEntity, "", iPSDEDQGroupCondition, this.majorDERAliasMap, this.majorDERList);
   }

   public String getPSDEFieldExp(String strDEField) throws Exception {
      IPSDEField iPSDEField = this.majorPSDataEntity.getPSDEField(strDEField);
      if (iPSDEField == null) {
         throw new Exception(StringHelper.Format("无法获取实体属性[%1$s]对象", strDEField));
      } else {
         return this.getPSDEFieldExp(iPSDEField);
      }
   }

   public String getPSDEFieldExp(IPSDEField iPSDEField) throws Exception {
      return this.getPSDEFieldExp(iPSDEField, "", this.majorDERAliasMap, this.majorDERList);
   }

   public int getMajorDERAlias(String strDERId) {
      return this.majorDERAliasMap.containsKey(strDERId) ? this.majorDERAliasMap.get(strDERId) : -1;
   }

   protected String getGroupCondition(
      IPSDataEntity iPSDataEntity,
      String strParentDER,
      IPSDEDQGroupCondition iPSDEDQGroupCondition,
      TreeMap<String, Integer> derAliasMap,
      ArrayList<String> derList
   ) throws Exception {
      boolean bHasCondition = false;
      StringBuilderEx script = new StringBuilderEx();
      if (iPSDEDQGroupCondition.getPSDEDQConditions() == null) {
         return "";
      }

      if (iPSDEDQGroupCondition.isNotMode()) {
         script.Append("NOT");
      }

      script.Append("(");
      Iterator<IPSDEDQCondition> psDEDQConditions = iPSDEDQGroupCondition.getPSDEDQConditions();

      while (psDEDQConditions.hasNext()) {
         IPSDEDQCondition iPSDEDQCondition = psDEDQConditions.next();
         if (iPSDEDQCondition instanceof IPSDEDQGroupCondition) {
            String strCond = this.getGroupCondition(iPSDataEntity, strParentDER, (IPSDEDQGroupCondition)iPSDEDQCondition, derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty(strCond)) {
               strCond = strCond.trim();
            }

            if (!StringHelper.IsNullOrEmpty(strCond)) {
               if (bHasCondition) {
                  if (StringHelper.Compare(iPSDEDQGroupCondition.getCondOp(), "AND", true) == 0) {
                     script.Append(" AND ");
                  } else {
                     script.Append(" OR ");
                  }
               }

               script.Append(" %1$s ", strCond);
               bHasCondition = true;
            }
         } else if (iPSDEDQCondition instanceof IPSDEDQFieldCondition) {
            IPSDEDQFieldCondition iPSDEDQFieldCondition = (IPSDEDQFieldCondition)iPSDEDQCondition;
            String strCond = this.getSingleCondition(iPSDataEntity, strParentDER, iPSDEDQFieldCondition, derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty(strCond)) {
               strCond = strCond.trim();
            }

            if (!StringHelper.IsNullOrEmpty(strCond)) {
               if (bHasCondition) {
                  if (StringHelper.Compare(iPSDEDQGroupCondition.getCondOp(), "AND", true) == 0) {
                     script.Append(" AND ");
                  } else {
                     script.Append(" OR ");
                  }
               }

               script.Append(" %1$s ", strCond);
               bHasCondition = true;
            }
         } else if (iPSDEDQCondition instanceof IPSDEDQCustomCondition) {
            IPSDEDQCustomCondition iPSDEDQCustomCondition = (IPSDEDQCustomCondition)iPSDEDQCondition;
            String strCond = this.getCustomCondition(iPSDataEntity, strParentDER, iPSDEDQCustomCondition, derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty(strCond)) {
               strCond = strCond.trim();
            }

            if (!StringHelper.IsNullOrEmpty(strCond)) {
               if (bHasCondition) {
                  if (StringHelper.Compare(iPSDEDQGroupCondition.getCondOp(), "AND", true) == 0) {
                     script.Append(" AND ");
                  } else {
                     script.Append(" OR ");
                  }
               }

               script.Append(" %1$s ", strCond);
               bHasCondition = true;
            }
         }
      }

      script.Append(")");
      return bHasCondition ? script.toString() : "";
   }

   protected String getSingleCondition(
      IPSDataEntity iPSDataEntity,
      String strParentDER,
      IPSDEDQFieldCondition iPSDEDQFieldCondition,
      TreeMap<String, Integer> derAliasMap,
      ArrayList<String> derList
   ) throws Exception {
      if (iPSDataEntity == null) {
         throw new Exception("没有指定实体辅助对象");
      }

      IPSDEField iPSDEField = iPSDataEntity.getPSDEField(iPSDEDQFieldCondition.getPSDEFId());
      if (iPSDEField == null) {
         throw new Exception(StringHelper.Format("无法找到属性[%1$s]", iPSDEDQFieldCondition.getPSDEFId()));
      }

      String strFieldName = this.getPSDEFieldExp(iPSDEField, strParentDER, derAliasMap, derList);
      String strFunc = iPSDEDQFieldCondition.getPSSysDBVFId();
      if (StringHelper.IsNullOrEmpty(strFunc)) {
         String strParamName = iPSDEDQFieldCondition.getPSVARTypeId();
         String strParamValue = iPSDEDQFieldCondition.getCondValue();
         if (this.globalParamMap.containsKey(strParamName)) {
            strParamValue = this.globalParamMap.get(strParamName);
            strParamName = "";
         }

         String strCode = null;
         if (!StringHelper.IsNullOrEmpty(strParamName) && this.isEnablePQL()) {
            String strDefaultParamName = "__PARAM__NAME__";
            String strDefaultParamName2 = "__PARAM__PARAM__";
            String strDefaultFuncName = "srf" + strDefaultParamName.toLowerCase();
            strCode = iPSDEField.getPSDTColumn(this.getDBType())
               .getConditionSQL(this, strFieldName, iPSDEDQFieldCondition.getCondOp(), strParamValue, strDefaultParamName, strDefaultParamName2);
            int nPos = strCode.indexOf(strDefaultFuncName);
            if (nPos == -1) {
               throw new Exception(String.format("语句[%1$s]格式不正确", strCode));
            }

            StringBuilder sb = new StringBuilder();
            String strPart1 = strCode.substring(0, nPos);
            int nPos2 = strPart1.lastIndexOf("$");
            if (nPos2 == -1) {
               throw new Exception(String.format("语句[%1$s]格式不正确", strCode));
            }

            sb.append(strPart1.substring(0, nPos2));
            String strPart2 = strCode.substring(nPos + strDefaultFuncName.length());
            strPart2 = strPart2.trim();
            nPos2 = strPart2.indexOf("'" + strDefaultParamName2 + "'");
            if (nPos2 == -1) {
               throw new Exception(String.format("语句[%1$s]格式不正确", strCode));
            }

            strPart1 = strPart2.substring(0, nPos2);
            strPart1 = strPart1.trim();
            strPart1 = strPart1.substring(1);
            strPart1 = strPart1.substring(0, strPart1.length() - 1);
            if (StringHelper.Compare(strParamName, "PQL", false) == 0) {
               strPart1 = strPart1.substring(1);
               strPart1 = strPart1.substring(0, strPart1.length() - 1);
               sb.append(strPart1);
            } else {
               sb.append(strParamName);
               sb.append("(");
               sb.append(strPart1);
               sb.append(")");
            }

            strPart2 = strPart2.substring(nPos2 + strDefaultParamName2.length() + 2);
            strPart2 = strPart2.trim();
            if (strPart2.length() > 0) {
               strPart2 = strPart2.substring(1);
            }

            strPart2 = strPart2.trim();
            if (strPart2.length() > 0) {
               strPart2 = strPart2.substring(1);
            }

            sb.append(strPart2);
            strCode = sb.toString();
         } else {
            strCode = iPSDEField.getPSDTColumn(this.getDBType())
               .getConditionSQL(this, strFieldName, iPSDEDQFieldCondition.getCondOp(), strParamValue, strParamName, iPSDEDQFieldCondition.getVARTypeParam());
         }

         if (!StringHelper.IsNullOrEmpty(strCode)) {
            strCode = strCode.trim();
            if (!StringHelper.IsNullOrEmpty(strCode)) {
               if (this.getMajorPSDataEntity().getPSSysSFPub() != null && this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle() != null) {
                  String strDEDQFieldCondTempl = this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle().getStyleParam("%DEDQ_FIELDCOND%", "");
                  if (!StringHelper.IsNullOrEmpty(strDEDQFieldCondTempl)) {
                     Map<String, Object> params = new HashMap<>();
                     params.put("dbtype", this.getDBType());
                     params.put("code", strCode);
                     params.put("cond", iPSDEDQFieldCondition);
                     params.put("field", strFieldName);
                     return PSTemplHelper.generateCode(strDEDQFieldCondTempl, params);
                  }
               }

               if (this.isUseRazorEngine()) {
                  if (!StringHelper.IsNullOrEmpty(iPSDEDQFieldCondition.getPSVARTypeId())) {
                     String strTag = StringHelper.Format(
                        "${srf%1$s('%2$s','%3$s')}",
                        iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(),
                        iPSDEDQFieldCondition.getCondValue(),
                        iPSDEDQFieldCondition.getVARTypeParam()
                     );
                     String strParam = iPSDEDQFieldCondition.getVARTypeParam();
                     if (!StringHelper.IsNullOrEmpty(strParam)) {
                        strParam = strParam.replace("\"", "\\\"\"");
                     }

                     String strEmptyCond = "";
                     String strTag2 = StringHelper.Format(
                        "@Model.GetFunc(\"\"%1$s\"\").GetCode(\"\"%2$s\"\",\"\"%3$s\"\",\"\"%4$s\"\")",
                        iPSDEDQFieldCondition.getPSVARTypeId(),
                        iPSDEDQFieldCondition.getCondValue(),
                        strParam,
                        strEmptyCond
                     );
                     if (strCode.indexOf(strTag) != -1) {
                        strCode = strCode.replace(strTag, strTag2);
                     }

                     return strCode;
                  }
               } else if (iPSDEDQFieldCondition.isIgnoreEmpty() && !StringHelper.IsNullOrEmpty(iPSDEDQFieldCondition.getPSVARTypeId())) {
                  if (!this.isEnablePQL()) {
                     String strTag = StringHelper.Format(
                        "${srf%1$s('%2$s','%3$s')}",
                        iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(),
                        iPSDEDQFieldCondition.getCondValue(),
                        iPSDEDQFieldCondition.getVARTypeParam()
                     );
                     if (strCode.indexOf(strTag) != -1) {
                        strCode = strCode.replace(strTag, "${_value}");
                     }

                     return StringHelper.Format(
                        "<#assign _value=srf%2$s('%3$s','%4$s')><#if _value?length gt 0>%1$s<#else>1=1</#if>",
                        strCode,
                        iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(),
                        iPSDEDQFieldCondition.getCondValue(),
                        iPSDEDQFieldCondition.getVARTypeParam()
                     );
                  }

                  if (StringHelper.Compare(strParamName, "PQL", false) != 0) {
                     return StringHelper.Format("%1$sIF('%2$s', %3$s)", strParamName, iPSDEDQFieldCondition.getCondValue(), strCode);
                  }
               }
            }
         }

         return strCode;
      } else {
         String strParamName = iPSDEDQFieldCondition.getPSVARTypeId();
         String strParamValue = iPSDEDQFieldCondition.getCondValue();
         if (this.globalParamMap.containsKey(strParamName)) {
            strParamValue = this.globalParamMap.get(strParamName);
            strParamName = "";
         }

         IPSSysDBValueFunc iPSSysDBValueFunc = this.getPSSystem().getPSSysDBValueFunc(strFunc);
         IDBFunction iDBFunction = this.iPSDBType.getDBFunction(iPSSysDBValueFunc.getCodeName());
         return iPSDEField.getPSDTColumn(this.getDBType())
            .getConditionSQL(
               this, strFieldName, iDBFunction, iPSDEDQFieldCondition.getCondOp(), strParamValue, strParamName, iPSDEDQFieldCondition.getVARTypeParam()
            );
      }
   }

   protected String getCustomCondition(
      IPSDataEntity iPSDataEntity,
      String strParentDER,
      IPSDEDQCustomCondition iPSDEDQCustomCondition,
      TreeMap<String, Integer> derAliasMap,
      ArrayList<String> derList
   ) throws Exception {
      if (this.getMajorPSDataEntity().getPSSysSFPub() != null && this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle() != null) {
         String strDEDQCustomCondTempl = this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle().getStyleParam("%DEDQ_CUSTOMCOND%", "");
         if (!StringHelper.IsNullOrEmpty(strDEDQCustomCondTempl)) {
            Map<String, Object> params = new HashMap<>();
            params.put("dbtype", this.getDBType());
            params.put("code", iPSDEDQCustomCondition.getCondition());
            params.put("cond", iPSDEDQCustomCondition);
            return PSTemplHelper.generateCode(strDEDQCustomCondTempl, params);
         }
      }

      return iPSDEDQCustomCondition.getCondition();
   }

   protected void getJoin(
      StringBuilderEx script,
      StringBuilderEx scriptTemp,
      IPSDataEntity iPSDataEntity,
      boolean bEnableTemp,
      String strParentDERs,
      String strDER,
      TreeMap<String, Integer> derAliasMap,
      TreeMap<String, Integer> joinMap
   ) throws Exception {
      if (StringHelper.IsNullOrEmpty(strDER)) {
         throw new Exception(StringHelper.Format("无法指定连接关系"));
      }

      String[] strDERs = strDER.split("[|]");
      String strCurDERId = strDERs[0];
      String strCurTotalDER = strParentDERs;
      if (!StringHelper.IsNullOrEmpty(strCurTotalDER)) {
         strCurTotalDER = strCurTotalDER + "|";
      }

      strCurTotalDER = strCurTotalDER + strCurDERId;
      IPSDataEntity iNextDEHelper = null;
      IPSDEDBConfig iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(this.getDBType());
      IPSDEField joinDEFHelper = null;
      boolean bInheritMode = false;
      boolean bSameTable = false;
      boolean bRightJoin = false;
      String strRealDERId = strCurDERId;
      if (strCurDERId.indexOf("N1R:") == 0) {
         strRealDERId = strCurDERId.substring(4);
         bRightJoin = true;
      }

      IPSDERCustom derCustom = null;
      IPSDERBase iPSDERBase = iPSDataEntity.getPSDER(false, strRealDERId, true);
      if (iPSDERBase != null && iPSDERBase instanceof IPSDERCustom) {
         derCustom = (IPSDERCustom)iPSDERBase;
      }

      if (iPSDERBase instanceof IPSDER1NBase) {
         IPSDER1NBase iPSDER1NBase = (IPSDER1NBase)iPSDERBase;
         if (iPSDER1NBase.getPickupPSDEField() != null && !iPSDER1NBase.getPickupPSDEField().isPhisicalDEField()) {
            return;
         }
      }

      if (derCustom != null) {
         joinDEFHelper = derCustom.getPickupPSDEField();
      } else {
         Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();

         while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (!iPSDEField.isDynaStorageDEField() && !iPSDEField.isUIAssistDEField() && iPSDEField.isLinkDEField() && iPSDEField instanceof IPSLinkDEField) {
               IPSLinkDEField linkDEFHelper = (IPSLinkDEField)iPSDEField;
               if (StringHelper.Compare(linkDEFHelper.getDERId(), strCurDERId, true) == 0
                  || bRightJoin && StringHelper.Compare(linkDEFHelper.getDERId(), strCurDERId.substring(4), true) == 0) {
                  if (StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
                     joinDEFHelper = iPSDEField;
                     break;
                  }

                  if (StringHelper.Compare(iPSDEField.getDataType(), "INHERIT", true) == 0) {
                     bInheritMode = true;
                     iNextDEHelper = linkDEFHelper.getRelatedPSDEField().getPSDataEntity();
                     break;
                  }
               }
            }
         }

         if (joinDEFHelper == null
            && iNextDEHelper == null
            && (iPSDataEntity.getPSDERInherit() != null && iPSDataEntity.getPSDERInherit().isSameTable() || iPSDataEntity.getVirtualMode() == 5)) {
            bSameTable = true;
            psDEFields = iPSDataEntity.getPSDEFields();

            while (psDEFields.hasNext()) {
               IPSDEField iPSDEField = psDEFields.next();
               if (!iPSDEField.isDynaStorageDEField()
                  && !iPSDEField.isUIAssistDEField()
                  && iPSDEField.isLinkDEField()
                  && iPSDEField instanceof IPSLinkDEField
                  && StringHelper.Compare(iPSDEField.getDataType(), "INHERIT", true) == 0) {
                  IPSLinkDEField linkDEFHelper = (IPSLinkDEField)iPSDEField;
                  if (linkDEFHelper.getRelatedPSDEField() instanceof IPSLinkDEField) {
                     linkDEFHelper = (IPSLinkDEField)linkDEFHelper.getRelatedPSDEField();
                  } else {
                     linkDEFHelper = null;
                  }

                  if (linkDEFHelper != null) {
                     iPSDEField = linkDEFHelper;
                     if (StringHelper.Compare(linkDEFHelper.getDERId(), strCurDERId, true) == 0
                        || bRightJoin && StringHelper.Compare(linkDEFHelper.getDERId(), strCurDERId.substring(4), true) == 0) {
                        if (StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
                           joinDEFHelper = iPSDEField;
                           break;
                        }

                        if (StringHelper.Compare(iPSDEField.getDataType(), "INHERIT", true) == 0) {
                           bInheritMode = true;
                           iNextDEHelper = linkDEFHelper.getRelatedPSDEField().getPSDataEntity();
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

      if (!bInheritMode) {
         boolean bLeftOuterJoin = false;
         boolean bNextEnableTemp = false;
         IPSDEField joinRelatedDEFHelper = null;
         if (joinDEFHelper != null) {
            if (joinDEFHelper instanceof IPSLinkDEField) {
               joinRelatedDEFHelper = ((IPSLinkDEField)joinDEFHelper).getRelatedPSDEField();
               IPSDER1N iPSDER1N = (IPSDER1N)((IPSLinkDEField)joinDEFHelper).getPSDER();
               if (bEnableTemp) {
                  bEnableTemp = iPSDER1N.getTempDataOrder() >= 0;
               }
            }

            if (joinRelatedDEFHelper == null) {
               if (derCustom != null) {
                  joinRelatedDEFHelper = derCustom.getMajorPSDataEntity().getKeyPSDEField();
               }

               if (joinRelatedDEFHelper == null) {
                  throw new Exception(StringHelper.Format("无法找到属性[%1$s]关联属性", joinDEFHelper.getFullName()));
               }
            }

            iNextDEHelper = joinRelatedDEFHelper.getPSDataEntity();
         } else {
            String strTempCurDERId = "";
            if (strCurDERId.indexOf("1NLO:") == 0) {
               strTempCurDERId = strCurDERId.substring(5);
               IPSDERBase derBase = this.getPSSystem().getPSDER(strTempCurDERId);
               if (derBase instanceof IPSDER1N) {
                  IPSDER1N der1N = (IPSDER1N)derBase;
                  if (bEnableTemp) {
                     bNextEnableTemp = der1N.getTempDataOrder() >= 0;
                  }
               } else if (derBase instanceof IPSDERCustom) {
                  derCustom = (IPSDERCustom)derBase;
               }

               if (StringHelper.Compare(iPSDataEntity.getId(), derBase.getMajorPSDEId(), true) != 0) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iPSDataEntity.getFullName(), strTempCurDERId));
               }

               iNextDEHelper = this.getPSDataEntity(derBase.getMinorPSDEId());
               if (iNextDEHelper == null) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", derBase.getMinorPSDEId()));
               }

               Iterator<IPSDEField> psDEFields = iNextDEHelper.getPSDEFields();

               while (psDEFields.hasNext()) {
                  IPSDEField iPSDEField = psDEFields.next();
                  if (!iPSDEField.isDynaStorageDEField()
                     && !iPSDEField.isUIAssistDEField()
                     && iPSDEField.isLinkDEField()
                     && iPSDEField instanceof IPSLinkDEField) {
                     IPSLinkDEField linkDEFHelper = (IPSLinkDEField)iPSDEField;
                     if (StringHelper.Compare(linkDEFHelper.getDERId(), strTempCurDERId, true) == 0
                        && StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
                        joinRelatedDEFHelper = iPSDEField;
                        joinDEFHelper = linkDEFHelper.getRelatedPSDEField();
                        break;
                     }
                  }
               }

               if (joinRelatedDEFHelper == null) {
                  if (derCustom != null) {
                     joinRelatedDEFHelper = derCustom.getPickupPSDEField();
                     joinDEFHelper = derBase.getMajorPSDataEntity().getKeyPSDEField();
                  }

                  if (joinRelatedDEFHelper == null) {
                     throw new Exception(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iNextDEHelper.getFullName(), strCurDERId));
                  }
               }

               bLeftOuterJoin = true;
            } else if (strCurDERId.indexOf("11M:") != 0) {
               if (strCurDERId.indexOf("INDEX:") != 0 && strCurDERId.indexOf("INDEXM:") != 0) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iPSDataEntity.getFullName(), strCurDERId));
               }

               boolean bIndexM = false;
               if (strCurDERId.indexOf("INDEXM:") == 0) {
                  bIndexM = true;
               }

               strTempCurDERId = "";
               if (bIndexM) {
                  strTempCurDERId = strCurDERId.substring(7);
               } else {
                  strTempCurDERId = strCurDERId.substring(6);
               }

               IPSDERIndex derIndex = (IPSDERIndex)this.getPSSystem().getPSDER(strTempCurDERId);
               if (bIndexM) {
                  iNextDEHelper = this.getPSDataEntity(derIndex.getMinorPSDEId());
               } else {
                  iNextDEHelper = this.getPSDataEntity(derIndex.getMajorPSDEId());
               }

               if (iNextDEHelper == null) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", bIndexM ? derIndex.getMinorPSDEId() : derIndex.getMajorPSDEId()));
               }

               joinRelatedDEFHelper = iNextDEHelper.getKeyPSDEField();
               joinDEFHelper = iPSDataEntity.getKeyPSDEField();
            } else {
               strTempCurDERId = strCurDERId.substring(4);
               IPSDER11 der11 = (IPSDER11)this.getPSSystem().getPSDER(strTempCurDERId);
               if (StringHelper.Compare(iPSDataEntity.getId(), der11.getMajorPSDEId(), true) != 0) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iPSDataEntity.getFullName(), strTempCurDERId));
               }

               iNextDEHelper = this.getPSDataEntity(der11.getMinorPSDEId());
               if (iNextDEHelper == null) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", der11.getMinorPSDEId()));
               }

               Iterator<IPSDEField> psDEFields = iNextDEHelper.getPSDEFields();

               while (psDEFields.hasNext()) {
                  IPSDEField iPSDEField = psDEFields.next();
                  if (!iPSDEField.isDynaStorageDEField()
                     && !iPSDEField.isUIAssistDEField()
                     && iPSDEField.isLinkDEField()
                     && iPSDEField instanceof IPSLinkDEField) {
                     IPSLinkDEField linkDEFHelper = (IPSLinkDEField)iPSDEField;
                     if (StringHelper.Compare(linkDEFHelper.getDERId(), strTempCurDERId, true) == 0
                        && StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
                        joinRelatedDEFHelper = iPSDEField;
                        joinDEFHelper = linkDEFHelper.getRelatedPSDEField();
                        break;
                     }
                  }
               }

               if (joinRelatedDEFHelper == null) {
                  throw new Exception(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iNextDEHelper.getFullName(), strCurDERId));
               }
            }
         }

         if (!joinMap.containsKey(strCurTotalDER)) {
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty(strParentDERs)) {
               Integer nAlias = derAliasMap.get("");
               strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
               strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
            } else {
               if (!derAliasMap.containsKey(strParentDERs)) {
                  throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
               }

               Integer nAlias = derAliasMap.get(strParentDERs);
               strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
               strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
            }

            String strCurMTAlias = "";
            String strCurUTAlias = "";
            if (!derAliasMap.containsKey(strCurTotalDER)) {
               throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
            }

            Integer nAlias = derAliasMap.get(strCurTotalDER);
            strCurMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
            strCurUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
            boolean bJoinAsMain = true;
            if (!bSameTable && StringHelper.Compare(joinDEFHelper.getPSDTColumn(this.getDBType()).getTableScope(), iPSDataEntity.getTableName(), true) != 0) {
               bJoinAsMain = false;
            } else {
               bJoinAsMain = true;
            }

            String strMainTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
            String strUserTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
            String strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            String strMainTable3 = strMainTable;
            String strUserTable3 = strUserTable;
            if (iNextDEHelper.isEnableTempDataBackend() && bEnableTemp) {
               strMainTable3 = strMainTable + "_TMP";
               strUserTable3 = strUserTable + "_TMP";
            }

            String strSaaSDCIdColName = "";
            if (iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD || iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3) {
               strSaaSDCIdColName = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
            }

            if (StringHelper.Compare(iNextDEHelper.getDBSchema(), this.majorPSDataEntity.getDBSchema(), true) != 0) {
               strMainTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strMainTable);
               strUserTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strUserTable);
               strMainTable3 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strMainTable3);
               strUserTable3 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strUserTable3);
            }

            if (bLeftOuterJoin) {
               script.Append(
                  "LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                  this.iPSDBType.getDBObjStandardName(strMainTable2),
                  strCurMTAlias,
                  bJoinAsMain ? strMTAlias : strUTAlias,
                  this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
               }

               if (derCustom != null) {
                  script.Append("\n");
                  IPSDEField parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                  IPSDEField parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                  if (parentType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s", strCurMTAlias, this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     script.Append(
                        " AND "
                           + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null)
                     );
                  }

                  if (parentSubType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s", strCurMTAlias, this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     String strTypeValue = derCustom.getTypeValue();
                     if (StringHelper.IsNullOrEmpty(strTypeValue)) {
                        strTypeValue = derCustom.getMinorCodeName();
                     }

                     if (!StringHelper.IsNullOrEmpty(strTypeValue)) {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null)
                        );
                     } else {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null)
                        );
                     }
                  }
               }

               script.Append("\n");
               if (scriptTemp != null) {
                  scriptTemp.Append(
                     "LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                     this.iPSDBType.getDBObjStandardName(strMainTable3),
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                     this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
                  );
                  if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                     scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
                  }

                  scriptTemp.Append("\n");
               }
            } else if (bRightJoin) {
               script.Append(
                  "RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                  this.iPSDBType.getDBObjStandardName(strMainTable2),
                  strCurMTAlias,
                  bJoinAsMain ? strMTAlias : strUTAlias,
                  this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
               }

               if (derCustom != null) {
                  script.Append("\n");
                  IPSDEField parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                  IPSDEField parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                  if (parentType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s",
                        bJoinAsMain ? strMTAlias : strUTAlias,
                        this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     script.Append(
                        " AND "
                           + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null)
                     );
                  }

                  if (parentSubType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s",
                        bJoinAsMain ? strMTAlias : strUTAlias,
                        this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     String strTypeValue = derCustom.getTypeValue();
                     if (StringHelper.IsNullOrEmpty(strTypeValue)) {
                        strTypeValue = derCustom.getMinorCodeName();
                     }

                     if (!StringHelper.IsNullOrEmpty(strTypeValue)) {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null)
                        );
                     } else {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null)
                        );
                     }
                  }
               }

               script.Append("\n");
               if (scriptTemp != null) {
                  scriptTemp.Append(
                     "RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                     this.iPSDBType.getDBObjStandardName(strMainTable3),
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                     this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
                  );
                  if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                     scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
                  }

                  scriptTemp.Append("\n");
               }
            } else {
               script.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                  this.iPSDBType.getDBObjStandardName(strMainTable2),
                  strCurMTAlias,
                  bJoinAsMain ? strMTAlias : strUTAlias,
                  this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
               }

               if (derCustom != null) {
                  script.Append("\n");
                  IPSDEField parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                  IPSDEField parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                  if (parentType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s",
                        bJoinAsMain ? strMTAlias : strUTAlias,
                        this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     script.Append(
                        " AND "
                           + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null)
                     );
                  }

                  if (parentSubType != null) {
                     String strFieldName = String.format(
                        "%1$s.%2$s",
                        bJoinAsMain ? strMTAlias : strUTAlias,
                        this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName())
                     );
                     String strTypeValue = derCustom.getTypeValue();
                     if (StringHelper.IsNullOrEmpty(strTypeValue)) {
                        strTypeValue = derCustom.getMinorCodeName();
                     }

                     if (!StringHelper.IsNullOrEmpty(strTypeValue)) {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null)
                        );
                     } else {
                        script.Append(
                           " AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null)
                        );
                     }
                  }
               }

               script.Append("\n");
               if (scriptTemp != null) {
                  scriptTemp.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                     this.iPSDBType.getDBObjStandardName(strMainTable3),
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                     this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())
                  );
                  if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                     scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
                  }

                  scriptTemp.Append("\n");
               }
            }

            if (!StringHelper.IsNullOrEmpty(strUserTable)) {
               IPSDEField pkeyPSDEField = null;
               if (joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).isPKey()) {
                  pkeyPSDEField = joinRelatedDEFHelper;
               } else {
                  pkeyPSDEField = iNextDEHelper.getKeyPSDEField();
               }

               script.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s",
                  this.iPSDBType.getDBObjStandardName(strUserTable2),
                  strCurUTAlias,
                  strCurMTAlias,
                  this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurUTAlias, strSaaSDCIdColName);
               }

               script.Append("\n");
               if (scriptTemp != null) {
                  scriptTemp.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s",
                     this.iPSDBType.getDBObjStandardName(strUserTable3),
                     strCurUTAlias,
                     strCurMTAlias,
                     this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
                  );
                  if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                     scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurUTAlias, strSaaSDCIdColName);
                  }

                  scriptTemp.Append("\n");
               }
            }

            joinMap.put(strCurTotalDER, 1);
         }

         String strNextDERId = "";

         for (int i = 1; i < strDERs.length; i++) {
            if (!StringHelper.IsNullOrEmpty(strNextDERId)) {
               strNextDERId = strNextDERId + "|";
            }

            strNextDERId = strNextDERId + strDERs[i];
         }

         if (StringHelper.IsNullOrEmpty(strNextDERId)) {
            return;
         }

         this.getJoin(script, scriptTemp, iNextDEHelper, bNextEnableTemp, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
      } else {
         if (!joinMap.containsKey(strCurTotalDER)) {
            String strPreFix = "t";
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty(strParentDERs)) {
               strMTAlias = strPreFix + "1";
               strUTAlias = strPreFix + "2";
            } else {
               if (!derAliasMap.containsKey(strParentDERs)) {
                  throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
               }

               Integer nAlias = derAliasMap.get(strParentDERs);
               strMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
               strUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
            }

            String strCurMTAlias = "";
            String strCurUTAlias = "";
            if (!derAliasMap.containsKey(strCurTotalDER)) {
               throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
            }

            Integer nAlias = derAliasMap.get(strCurTotalDER);
            strCurMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
            strCurUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
            boolean bJoinAsMain = true;
            IPSDEField iKeyDEFHelper = iPSDataEntity.getKeyPSDEField();
            if (StringHelper.Compare(iKeyDEFHelper.getPSDTColumn(this.getDBType()).getTableScope(), iPSDataEntity.getTableName(), true) == 0) {
               bJoinAsMain = true;
            } else {
               bJoinAsMain = false;
            }

            String strMainTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
            String strUserTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
            String strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            String strMainTable3 = strMainTable;
            String strUserTable3 = strUserTable;
            if (iNextDEHelper.isEnableTempDataBackend() && bEnableTemp) {
               strMainTable3 = strMainTable + "_TMP";
               if (!StringHelper.IsNullOrEmpty(strUserTable)) {
                  strUserTable3 = strUserTable + "_TMP";
               }
            }

            String strSaaSDCIdColName = "";
            if (iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD || iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3) {
               strSaaSDCIdColName = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
            }

            if (StringHelper.Compare(iNextDEHelper.getDBSchema(), this.majorPSDataEntity.getDBSchema(), true) != 0) {
               strMainTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strMainTable);
               strUserTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strUserTable);
               strMainTable3 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strMainTable3);
               strUserTable3 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.getDBSchema(), strUserTable3);
            }

            script.Append(
               "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
               this.iPSDBType.getDBObjStandardName(strMainTable2),
               strCurMTAlias,
               bJoinAsMain ? strMTAlias : strUTAlias,
               this.iPSDBType.getDBObjStandardName(iKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
               this.iPSDBType.getDBObjStandardName(iNextDEHelper.getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName())
            );
            if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
               script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
            }

            script.Append("\n");
            if (!StringHelper.IsNullOrEmpty(strUserTable)) {
               IPSDEField pkeyPSDEField = iNextDEHelper.getKeyPSDEField();
               script.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s",
                  this.iPSDBType.getDBObjStandardName(strUserTable2),
                  strCurUTAlias,
                  strCurMTAlias,
                  this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurUTAlias, strSaaSDCIdColName);
               }

               script.Append("\n");
            }

            if (scriptTemp != null) {
               scriptTemp.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ",
                  this.iPSDBType.getDBObjStandardName(strMainTable3),
                  strCurMTAlias,
                  bJoinAsMain ? strMTAlias : strUTAlias,
                  this.iPSDBType.getDBObjStandardName(iKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()),
                  this.iPSDBType.getDBObjStandardName(iNextDEHelper.getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName())
               );
               if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                  script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurMTAlias, strSaaSDCIdColName);
               }

               script.Append("\n");
               if (!StringHelper.IsNullOrEmpty(strUserTable)) {
                  IPSDEField pkeyPSDEField = iNextDEHelper.getKeyPSDEField();
                  scriptTemp.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s",
                     this.iPSDBType.getDBObjStandardName(strUserTable3),
                     strCurUTAlias,
                     strCurMTAlias,
                     this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName())
                  );
                  if (!StringHelper.IsNullOrEmpty(strSaaSDCIdColName)) {
                     script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", strCurUTAlias, strSaaSDCIdColName);
                  }

                  script.Append("\n");
               }
            }

            joinMap.put(strCurTotalDER, 1);
         }

         String strNextDERId = "";

         for (int i = 1; i < strDERs.length; i++) {
            if (!StringHelper.IsNullOrEmpty(strNextDERId)) {
               strNextDERId = strNextDERId + "|";
            }

            strNextDERId = strNextDERId + strDERs[i];
         }

         if (StringHelper.IsNullOrEmpty(strNextDERId)) {
            return;
         }

         this.getJoin(script, scriptTemp, iNextDEHelper, bEnableTemp, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
      }
   }

   protected String getPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
      boolean bClose = false;
      ActionSession actionSession = null;

      try {
         actionSession = ActionSessionManager.getCurrentSession();
         if (actionSession == null) {
            bClose = true;
            actionSession = ActionSessionManager.openSession("PSDEDQEngineImpl");
            actionSession.registerRecursion("PSDEFIELDEXP", iPSDEField.getId());
         } else if (!actionSession.registerRecursion("PSDEFIELDEXP", iPSDEField.getId())) {
            throw new Exception(StringHelper.Format("属性[%1$s]SQL表达式存在递归关系", iPSDEField.getFullName()));
         }

         String strPSDEFieldExp = this.onGetPSDEFieldExp(iPSDEField, strParentDER, derAliasMap, derList);
         actionSession.unregisterRecursion("PSDEFIELDEXP", iPSDEField.getId());
         if (bClose) {
            ActionSessionManager.closeSession();
         }

         return strPSDEFieldExp;
      } catch (Exception ex) {
         if (bClose) {
            ActionSessionManager.closeSession();
         }

         throw ex;
      }
   }

   protected String onGetPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
      try {
         CallResult callResult = new CallResult();
         callResult.setRetCode(1);
         IPSDataEntity iPSDataEntity = iPSDEField.getPSDataEntity();
         IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
         if (iPSDEField.isInheritDEField()) {
            IPSDEField relatedPSPSDEField = ((IPSInheritDEField)iPSDEField).getRelatedPSDEField();
            IPSDEFDTColumn iPSDEFDTColumn2 = relatedPSPSDEField.getPSDTColumn(this.getDBType());
            if (iPSDEFDTColumn2.isFormula()) {
               iPSDEFDTColumn = iPSDEFDTColumn2;
            }
         }

         if (iPSDEFDTColumn.isFormula() && !iPSDEFDTColumn.isFormulaPhisical()) {
            String strFormulaFields = iPSDEFDTColumn.getFormulaColumns();
            if (!StringHelper.IsNullOrEmpty(strFormulaFields)) {
               Object[] params = null;
               String[] strFields = strFormulaFields.split("[;]");
               params = new Object[strFields.length];

               for (int i = 0; i < strFields.length; i++) {
                  String strDEFName = strFields[i].toUpperCase();
                  IPSDEField argvField = iPSDEField.getPSDataEntity().getPSDEField(strDEFName, true);
                  if (argvField != null) {
                     params[i] = this.getPSDEFieldExp(argvField, strParentDER, derAliasMap, derList);
                  } else {
                     params[i] = strDEFName;
                  }
               }

               return StringHelper.Format(iPSDEFDTColumn.getFormulaFormat(), params);
            } else if (iPSDEField.getPSDataEntity().isVirtual() && iPSDEField.getPSDataEntity().getVirtualMode() == 3) {
               String strExp = StringHelper.Format("%1$s.%2$s", "t1", this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
               this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
               return strExp;
            } else {
               String strExp = StringHelper.Format(iPSDEFDTColumn.getFormulaFormat());
               this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
               return strExp;
            }
         } else {
            IPSDataEntity realPSDataEntity = null;
            if (StringHelper.IsNullOrEmpty(strParentDER) && this.getMajorPSDataEntity().isVirtual()) {
               if (this.getMajorPSDataEntity().getKeyPSDEField() == null) {
                  throw PSDataEntityException.create(this.getMajorPSDataEntity(), 20014);
               }

               if (this.getMajorPSDataEntity().getKeyPSDEField() instanceof IPSLinkDEField) {
                  realPSDataEntity = ((IPSLinkDEField)this.getMajorPSDataEntity().getKeyPSDEField()).getRealPSDEField(true).getPSDataEntity();
                  if (StringHelper.Compare(((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDataEntity().getId(), realPSDataEntity.getId(), false) != 0
                     )
                   {
                     realPSDataEntity = null;
                  }
               }
            }

            String strDERID = "";
            boolean bAddJoin = false;
            if (realPSDataEntity == null) {
               IPSLinkDEField linkDEFHelper = null;
               if (iPSDEField instanceof IPSLinkDEField) {
                  linkDEFHelper = (IPSLinkDEField)iPSDEField;
                  strDERID = linkDEFHelper.getDERId();
                  bAddJoin = true;
               }

               if (StringHelper.Compare(iPSDEField.getDataType(), "PICKUP", true) == 0) {
                  strDERID = "";
                  bAddJoin = false;
               } else {
                  if (StringHelper.Compare(iPSDEField.getDataType(), "PICKUPTEXT", true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                     strDERID = "";
                     bAddJoin = false;
                  }

                  if (StringHelper.Compare(iPSDEField.getDataType(), "PICKUPDATA", true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                     strDERID = "";
                     bAddJoin = false;
                  }

                  if (linkDEFHelper != null && StringHelper.Compare(iPSDEField.getDataType(), "INHERIT", true) == 0) {
                     if (iPSDEField.getPSDataEntity().getPSDERInherit() != null && iPSDEField.getPSDataEntity().getPSDERInherit().isSameTable()) {
                        bAddJoin = false;
                        if (linkDEFHelper.getRelatedPSDEField() != null && linkDEFHelper.getRelatedPSDEField().isPhisicalDEField()) {
                           strDERID = "";
                        }
                     } else if (iPSDEField.getPSDataEntity().getVirtualMode() == 5) {
                        bAddJoin = false;
                        if (linkDEFHelper.getRelatedPSDEField() != null && linkDEFHelper.getRelatedPSDEField().isPhisicalDEField()) {
                           strDERID = "";
                        }
                     }
                  }
               }
            }

            if (StringHelper.IsNullOrEmpty(strDERID)) {
               boolean bDynamicTable = false;
               String strMainTable = "";
               String strUserTable = "";
               if (realPSDataEntity != null) {
                  strMainTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getTableName();
                  strUserTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getUserTable();
               } else {
                  strMainTable = iPSDataEntity.getPSDEDBConfig(this.getDBType()).getTableName();
                  strUserTable = iPSDataEntity.getPSDEDBConfig(this.getDBType()).getUserTable();
               }

               String strMTAlias = "";
               String strUTAlias = "";
               if (StringHelper.IsNullOrEmpty(strParentDER)) {
                  int nAlias = derAliasMap.get("");
                  strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
                  strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
                  bDynamicTable = false;
               } else {
                  if (!derAliasMap.containsKey(strParentDER)) {
                     throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDER));
                  }

                  Integer nAlias = derAliasMap.get(strParentDER);
                  strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
                  strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
               }

               String strDEFTableName = iPSDEFDTColumn.getRealTableName();
               if (StringHelper.IsNullOrEmpty(strDEFTableName) && this.getMajorPSDataEntity().isVirtual() && iPSDEField instanceof IPSLinkDEField) {
                  strDEFTableName = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDTColumn(this.getDBType()).getRealTableName();
                  iPSDEFDTColumn = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDTColumn(this.getDBType());
               }

               if (bDynamicTable || StringHelper.Compare(strMainTable, strDEFTableName, true) == 0) {
                  String strExp = StringHelper.Format("%1$s.%2$s", strMTAlias, this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                  this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                  return strExp;
               } else if (StringHelper.Compare(strUserTable, strDEFTableName, true) == 0) {
                  String strExp = StringHelper.Format("%1$s.%2$s", strUTAlias, this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                  this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                  return strExp;
               } else {
                  throw new Exception(StringHelper.Format("无法识别的属性[%1$s]表名[%2$s]", iPSDEField.getFullName(), strDEFTableName));
               }
            } else {
               String strNewDER = strParentDER;
               if (bAddJoin) {
                  if (!StringHelper.IsNullOrEmpty(strNewDER)) {
                     strNewDER = strNewDER + "|";
                  }

                  strNewDER = strNewDER + strDERID;
               }

               IPSDEField relatedDEFHelper = null;
               if (iPSDEField instanceof IPSLinkDEField) {
                  relatedDEFHelper = ((IPSLinkDEField)iPSDEField).getRelatedPSDEField();
               }

               if (relatedDEFHelper == null) {
                  throw new Exception(StringHelper.Format("无法获取属性[%1$s]的关系属性", iPSDEField.getFullName()));
               }

               if (bAddJoin && !derAliasMap.containsKey(strNewDER)) {
                  derAliasMap.put(strNewDER, this.getAliasIndex());
                  String strLastDERID = "";
                  if (derList.size() > 0) {
                     strLastDERID = derList.get(derList.size() - 1);
                  }

                  if (strNewDER.indexOf(strLastDERID) == 0
                     && (strNewDER.length() == strLastDERID.length() || strNewDER.charAt(strLastDERID.length()) == '|')
                     && !StringHelper.IsNullOrEmpty(strLastDERID)) {
                     derList.set(derList.size() - 1, strNewDER);
                  } else {
                     derList.add(strNewDER);
                  }
               }

               return this.getPSDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList);
            }
         }
      } catch (Exception ex) {
         throw new Exception(StringHelper.Format("获取实体属性[%1$s]表达式发生异常，%2$s", iPSDEField.getFullModelName(), ex.getMessage()), ex);
      }
   }

   protected String getTableAlias(
      IPSDataEntity iPSDataEntity, boolean bMain, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList
   ) throws Exception {
      int nAlias = derAliasMap.get("");
      String strMTAlias = "";
      String strUTAlias = "";
      strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
      strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
      if (StringHelper.IsNullOrEmpty(strParentDER)) {
         strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
         strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
      } else {
         if (!derAliasMap.containsKey(strParentDER)) {
            throw new Exception(StringHelper.Format("无法找到关系[%1$s]别名", strParentDER));
         }

         strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
         strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
      }

      return bMain ? strMTAlias : strUTAlias;
   }

   protected String getConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
      if (StringHelper.Compare(strCondition, "TESTNULL", true) == 0) {
         return StringHelper.Compare(strValue, "1", true) == 0
            ? StringHelper.Format("%1$s IS NULL", strFieldName)
            : StringHelper.Format("%1$s IS NOT NULL", strFieldName);
      } else if (StringHelper.Compare(strCondition, "ISNULL", true) == 0) {
         return StringHelper.Format("%1$s IS NULL", strFieldName);
      } else if (StringHelper.Compare(strCondition, "ISNOTNULL", true) == 0) {
         return StringHelper.Format("%1$s IS NOT NULL", strFieldName);
      } else if (!StringHelper.IsNullOrEmpty(strParamName)) {
         throw new Exception(StringHelper.Format("没有实现"));
      } else if (DataTypeHelper.IsStringType(nDataType)) {
         return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else if (DataTypeHelper.IsIntType(nDataType)) {
         return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else if (DataTypeHelper.IsDoubleType(nDataType)) {
         return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else if (DataTypeHelper.IsDateTimeType(nDataType)) {
         return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else {
         throw new Exception(StringHelper.Format("无法识别的数据类型[%1$s]", nDataType));
      }
   }

   public String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
      return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
      if (StringHelper.Compare(strCondition, "=", true) != 0 && StringHelper.Compare(strCondition, "==", true) != 0) {
         if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format("%1$s <> '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">", true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format("%1$s > '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format("%1$s >= '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<", true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format("%1$s < '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format("%1$s <= '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "LIKE", true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue + "%";
            return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "LEFTLIKE", true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = strValue + "%";
            return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "RIGHTLIKE", true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue;
            return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
            return "";
         }

         strValue = strValue.replace(",", ";");
         strValue = strValue.replace("'", "''");
         String[] items = StringHelper.SplitEx(strValue);
         if (items.length == 0) {
            throw new Exception("没有指定参数");
         }

         StringBuilderEx sb = new StringBuilderEx();
         sb.Append(strFieldName);
         if (StringHelper.Compare(strCondition, "NOTIN", true) == 0) {
            sb.Append(" NOT ");
         }

         sb.Append(" IN (");

         for (int i = 0; i < items.length; i++) {
            if (i != 0) {
               sb.Append(",");
            }

            sb.Append("'%1$s'", items[i]);
         }

         sb.Append(")");
         return sb.toString();
      } else {
         strValue = strValue.replace("'", "''");
         return StringHelper.Format("%1$s = '%2$s'", strFieldName, strValue);
      }
   }

   public String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
      return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
      Object objValue = null;
      if (StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
         objValue = DataTypeParse.TestBigInt(strValue);
         if (objValue == null) {
            throw new Exception(StringHelper.Format("值[%1$s]非整数值", strValue));
         }
      }

      if (!StringHelper.IsNullOrEmpty(strParamName)) {
         CallParam callParam = new CallParam();
         callParam.setParamName(strParamName);
         callParam.setValue(objValue);
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s = ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <> ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, ">", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s > ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s >=?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s < ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <= ?", strFieldName);
         } else {
            return "";
         }
      } else {
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            return StringHelper.Format("%1$s = %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            return StringHelper.Format("%1$s <> %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">", true) == 0) {
            return StringHelper.Format("%1$s > %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            return StringHelper.Format("%1$s >= %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<", true) == 0) {
            return StringHelper.Format("%1$s < %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            return StringHelper.Format("%1$s <= %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
            return "";
         }

         if (!StringHelper.IsNullOrEmpty(strValue)) {
            strValue = strValue.replace(",", ";");
            String[] items = StringHelper.SplitEx(strValue);
            String strSQL = "";
            if (StringHelper.Compare(strCondition, "IN", true) == 0) {
               strSQL = StringHelper.Format("%1$s IN (", strFieldName);
            } else {
               strSQL = StringHelper.Format("%1$s NOT IN (", strFieldName);
            }

            for (int i = 0; i < items.length; i++) {
               Object objItem = DataTypeParse.TestBigInt(items[i]);
               if (objItem == null) {
                  throw new Exception(StringHelper.Format("值[%1$s]非整数值", items[i]));
               }

               if (i != 0) {
                  strSQL = strSQL + ",";
               }

               strSQL = strSQL + StringHelper.Format("%1$s", items[i]);
            }

            return strSQL + ")";
         } else {
            return StringHelper.Compare(strCondition, "IN", true) == 0 ? "1<>1" : "1=1";
         }
      }
   }

   public String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
      return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
      Object objValue = DataTypeParse.TestDouble(strValue);
      if (objValue == null && StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
         throw new Exception(StringHelper.Format("值[%1$s]非浮点值", strValue));
      }

      if (!StringHelper.IsNullOrEmpty(strParamName)) {
         CallParam callParam = new CallParam();
         callParam.setParamName(strParamName);
         callParam.setValue(objValue);
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s = ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <> ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, ">", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s > ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s >=?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s < ?", strFieldName);
         } else if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <= ?", strFieldName);
         } else {
            return "";
         }
      } else {
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            return StringHelper.Format("%1$s = %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            return StringHelper.Format("%1$s <> %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">", true) == 0) {
            return StringHelper.Format("%1$s > %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            return StringHelper.Format("%1$s >= %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<", true) == 0) {
            return StringHelper.Format("%1$s < %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            return StringHelper.Format("%1$s <= %2$s", strFieldName, strValue);
         }

         if (StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
            return "";
         }

         if (!StringHelper.IsNullOrEmpty(strValue)) {
            strValue = strValue.replace(",", ";");
            String[] items = StringHelper.SplitEx(strValue);
            String strSQL = "";
            if (StringHelper.Compare(strCondition, "IN", true) == 0) {
               strSQL = StringHelper.Format("%1$s IN (", strFieldName);
            } else {
               strSQL = StringHelper.Format("%1$s NOT IN (", strFieldName);
            }

            for (int i = 0; i < items.length; i++) {
               Object objItem = DataTypeParse.TestDouble(items[i]);
               if (objItem == null) {
                  throw new Exception(StringHelper.Format("值[%1$s]非浮点值", items[i]));
               }

               if (i != 0) {
                  strSQL = strSQL + ",";
               }

               strSQL = strSQL + StringHelper.Format("%1$s", items[i]);
            }

            return strSQL + ")";
         } else {
            return StringHelper.Compare(strCondition, "IN", true) == 0 ? "1<>1" : "1=1";
         }
      }
   }

   public String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
      return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
      Object objValue = null;
      if (!StringHelper.IsNullOrEmpty(strValue)) {
         objValue = DataTypeParse.TestDateTime(strValue);
         if (objValue == null) {
            log.error(StringHelper.Format("值[%1$s]非日期时间性", strValue));
            return "";
         }

         Timestamp ts = (Timestamp)objValue;
         strValue = StringHelper.Format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ts);
         if (StringHelper.Compare(strCondition, "<", true) == 0 || StringHelper.Compare(strCondition, "<=", true) == 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(ts.getTime()));
            if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
               strValue = StringHelper.Format("%1$tY-%1$tm-%1$td 23:59:59", ts);
               objValue = DataTypeParse.TestDateTime(strValue);
            }
         }
      }

      if (StringHelper.IsNullOrEmpty(strParamName)) {
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            return StringHelper.Format("%1$s = '%2$s'", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            return StringHelper.Format("%1$s <> '%2$s'", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">", true) == 0) {
            return StringHelper.Format("%1$s > '%2$s'", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            return StringHelper.Format("%1$s >= '%2$s'", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<", true) == 0) {
            return StringHelper.Format("%1$s < '%2$s'", strFieldName, strValue);
         } else {
            return StringHelper.Compare(strCondition, "<=", true) == 0 ? StringHelper.Format("%1$s <= '%2$s'", strFieldName, strValue) : "";
         }
      } else {
         CallParam callParam = new CallParam();
         callParam.setParamName(strParamName);
         callParam.setValue(objValue);
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s = ?", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <> ?", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s > ?", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s >= ?", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s < ?", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<=", true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format("%1$s <= ?", strFieldName, strValue);
         } else {
            return "";
         }
      }
   }

   public String getCountSQL(String strSQL) {
      return "";
   }

   public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
      return "";
   }

   public String getPagingSQL(
      String strSQL,
      int nStartPos,
      int nPageSize,
      String strGroup,
      String strGroupDir,
      String strMajor,
      String strMajorDirection,
      String strMinor,
      String strMinorDirection
   ) {
      return StringHelper.IsNullOrEmpty(strGroup)
         ? this.getPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection)
         : this.getPagingSQL(strSQL, nStartPos, nPageSize, strGroup, strGroupDir, strMajor, strMajorDirection);
   }

   public String getSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
      return "";
   }

   public String getSortSQL(boolean bSubQuery, String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
      if (bSubQuery) {
         StringBuilderEx script = new StringBuilderEx();
         if (!StringHelper.IsNullOrEmpty(strMajor)) {
            String strFieldName = this.fieldExpMap.get(strMajor.toUpperCase());
            if (!StringHelper.IsNullOrEmpty(strFieldName)) {
               script.Append("%1$s ORDER BY %2$s %3$s", strSQL, strFieldName, strMajorDirection);
               if (!StringHelper.IsNullOrEmpty(strMinor)) {
                  strFieldName = this.fieldExpMap.get(strMinor.toUpperCase());
                  if (!StringHelper.IsNullOrEmpty(strFieldName)) {
                     script.Append(",%1$s %2$s", strFieldName, strMinorDirection);
                  }
               }
            }

            return script.toString();
         } else {
            return strSQL;
         }
      } else {
         return this.getSortSQL(strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
      }
   }

   private final int getAliasIndex() {
      this.nAliasIndex += 10;
      return this.nAliasIndex;
   }

   private final int getCurAliasIndex() {
      return this.nAliasIndex;
   }

   protected int getAliasIndex2() {
      this.nAliasIndex += 10;
      return this.nAliasIndex;
   }

   public IPSDataEntity getMajorPSDataEntity() {
      return this.majorPSDataEntity;
   }

   public String getGroupSQL(
      String strSQL,
      QueryGroupModelConfig queryGroupModelConfig,
      ArrayList<CallParam> list,
      ISRFDAWebContext webContext,
      ISRFDAGlobalHelper iDAGlobalHelper,
      String strCurPersonId,
      BaseDataEntity baseDataEntity
   ) throws Exception {
      if (StringHelper.IsNullOrEmpty(strSQL)) {
         strSQL = this.getQueryModelScript(null);
      }

      if (StringHelper.IsNullOrEmpty(strSQL)) {
         log.error(StringHelper.Format("主查询语句无效"));
         return "";
      }

      StringBuilderEx sqlGroup = new StringBuilderEx();
      IPSDataEntity majorDEHelper = this.getMajorPSDataEntity();
      sqlGroup.Append("SELECT ");
      boolean bFirst = true;
      int nAliasIndex = 0;
      TreeMap<Integer, String> orderMap = new TreeMap<>();
      ArrayList<String> groupFields = new ArrayList<>();
      ArrayList<QueryGroupItemConfig> recalcItems = new ArrayList<>();

      for (QueryGroupItemConfig queryGroupItemConfig : queryGroupModelConfig) {
         if (queryGroupItemConfig.isReCalc()) {
            recalcItems.add(queryGroupItemConfig);
         } else {
            nAliasIndex++;
            String strFormular = queryGroupItemConfig.getFormular();
            String strDEFields = queryGroupItemConfig.getDEFields();
            if (!StringHelper.IsNullOrEmpty(strFormular) || !StringHelper.IsNullOrEmpty(strDEFields)) {
               String strFieldCode = "";
               String strAlias = queryGroupItemConfig.getAlias();
               if (!StringHelper.IsNullOrEmpty(strDEFields)) {
                  String[] fields = strDEFields.split("[,]");
                  String[] fieldCodes = new String[fields.length];
                  if (StringHelper.IsNullOrEmpty(strFormular)) {
                     strFormular = "%1$s";
                     String strDEField = fields[0];
                     IPSDEField defHelper = majorDEHelper.getPSDEField(strDEField);
                     if (defHelper == null) {
                        if (StringHelper.IsNullOrEmpty(strAlias)) {
                           strAlias = fields[0];
                        }

                        fieldCodes[0] = strDEField;
                     } else {
                        if (StringHelper.IsNullOrEmpty(strAlias)) {
                           strAlias = fields[0];
                        }

                        String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
                        fieldCodes[0] = strRealCode;
                     }
                  } else {
                     for (int i = 0; i < fields.length; i++) {
                        String strDEField = fields[i];
                        IPSDEField defHelper = majorDEHelper.getPSDEField(strDEField);
                        if (defHelper == null) {
                           fieldCodes[i] = strDEField;
                        } else {
                           String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
                           fieldCodes[i] = strRealCode;
                        }
                     }
                  }

                  strFieldCode = StringHelper.Format(strFormular, fieldCodes);
               } else {
                  strFieldCode = strFormular;
               }

               if (bFirst) {
                  bFirst = false;
               } else {
                  sqlGroup.Append(",");
               }

               if (StringHelper.IsNullOrEmpty(strAlias)) {
                  strAlias = StringHelper.Format("A%1$s", nAliasIndex);
                  queryGroupItemConfig.setAlias(strAlias);
               }

               sqlGroup.Append("%1$s as %2$s", strFieldCode, strAlias);
               if (queryGroupItemConfig.getIsGroup()) {
                  groupFields.add(strFieldCode);
               }

               if (!StringHelper.IsNullOrEmpty(queryGroupItemConfig.getOrderDirection())) {
                  orderMap.put(queryGroupItemConfig.getOrder(), StringHelper.Format("%1$s %2$s", strAlias, queryGroupItemConfig.getOrderDirection()));
               }

               String strParams = queryGroupItemConfig.getUserTag();
               if (!StringHelper.IsNullOrEmpty(strParams)) {
                  String[] params = strParams.split("[;]");

                  for (int i = 0; i < params.length; i++) {
                     CallParam cp = new CallParam();
                     cp.setParamName(params[i]);
                     CallResult callResult = MacroHelper.GetValue(cp.getParamName(), webContext, iDAGlobalHelper, strCurPersonId, baseDataEntity);
                     if (callResult.getRetCode() == 0) {
                        Object objValue = callResult.getUserObject();
                        if (objValue == null || StringHelper.Compare(objValue.toString(), cp.getParamName(), true) != 0) {
                           cp.setValue(objValue);
                        }
                     }

                     list.add(cp);
                  }
               }
            }
         }
      }

      sqlGroup.Append(" FROM (%1$s) m1 ", strSQL);
      if (groupFields.size() == 0) {
         log.error(StringHelper.Format("没有指定任何分组属性"));
         return "";
      }

      bFirst = true;

      for (String strFieldCode : groupFields) {
         if (bFirst) {
            sqlGroup.Append(" GROUP BY ");
            bFirst = false;
         } else {
            sqlGroup.Append(" , ");
         }

         sqlGroup.Append(strFieldCode);
      }

      String strGroupSql = sqlGroup.toString();
      if (recalcItems.size() > 0) {
         sqlGroup.Reset();
         sqlGroup.Append("SELECT m3.*");

         for (QueryGroupItemConfig queryGroupItemConfig : recalcItems) {
            nAliasIndex++;
            String strFormular = queryGroupItemConfig.getFormular();
            String strDEFields = queryGroupItemConfig.getDEFields();
            if (!StringHelper.IsNullOrEmpty(strFormular) || !StringHelper.IsNullOrEmpty(strDEFields)) {
               String strFieldCode = "";
               String strAlias = queryGroupItemConfig.getAlias();
               strFieldCode = strFormular;
               sqlGroup.Append(",");
               if (StringHelper.IsNullOrEmpty(strAlias)) {
                  strAlias = StringHelper.Format("A%1$s", nAliasIndex);
                  queryGroupItemConfig.setAlias(strAlias);
               }

               sqlGroup.Append("%1$s as %2$s", strFieldCode, strAlias);
               if (!StringHelper.IsNullOrEmpty(queryGroupItemConfig.getOrderDirection())) {
                  orderMap.put(queryGroupItemConfig.getOrder(), StringHelper.Format("%1$s %2$s", strAlias, queryGroupItemConfig.getOrderDirection()));
               }
            }
         }

         sqlGroup.Append(" FROM (%1$s) m3", strGroupSql);
         strGroupSql = sqlGroup.toString();
      }

      if (!StringHelper.IsNullOrEmpty(queryGroupModelConfig.getGroupCond())) {
         sqlGroup.Reset();
         sqlGroup.Append("SELECT m4.*");
         sqlGroup.Append(" FROM (%1$s) m4 where %2$s", strGroupSql, queryGroupModelConfig.getGroupCond());
         strGroupSql = sqlGroup.toString();
      }

      if (orderMap.size() > 0) {
         StringBuilderEx sqlGroupEx = new StringBuilderEx();
         sqlGroupEx.Append("SELECT * FROM (%1$s) m2 ", strGroupSql);
         bFirst = true;

         for (int nValue : orderMap.keySet()) {
            if (bFirst) {
               sqlGroupEx.Append(" ORDER BY ");
               bFirst = false;
            } else {
               sqlGroupEx.Append(" , ");
            }

            sqlGroupEx.Append(orderMap.get(nValue));
         }

         strGroupSql = sqlGroupEx.toString();
      }

      return queryGroupModelConfig.getTopCount() == 0 ? strGroupSql : this.getFetchTopRowSQL(strGroupSql, queryGroupModelConfig.getTopCount());
   }

   public String getFetchTopRowSQL(String strSQL, int nTopCount) {
      return strSQL;
   }

   protected String getDEFieldStatisticsNullConvertCode(IPSDEField defHelper) throws Exception {
      String strStaNullConv = defHelper.getPSDTColumn(this.getDBType()).getStatisticsNullConvert();
      return !StringHelper.IsNullOrEmpty(strStaNullConv)
         ? StringHelper.Format("(CASE WHEN %1$s IS NULL THEN %2$s ELSE %1$s END)", defHelper.getPSDTColumn(this.getDBType()).getColumnName(), strStaNullConv)
         : defHelper.getName();
   }

   public void registerCallParam(String strParamName, Object objValue) {
      CallParam callParam = new CallParam();
      callParam.setParamName(strParamName);
      callParam.setValue(objValue);
      this.callParams.add(callParam);
   }

   public void registerQMDeclare(String strDeclareName, PSDEDQDeclare qmDeclare) {
      strDeclareName = strDeclareName.toUpperCase();
      this.qmDeclareMap.put(strDeclareName, qmDeclare);
   }

   public boolean isContainsQMDeclare(String strDeclareName) {
      strDeclareName = strDeclareName.toUpperCase();
      return this.qmDeclareMap.containsKey(strDeclareName);
   }

   public String getQMDeclareScript() {
      String strQMDeclareScript = "";

      for (String strName : this.qmDeclareMap.keySet()) {
         PSDEDQDeclare qmDeclare = this.qmDeclareMap.get(strName);
         strQMDeclareScript = strQMDeclareScript + qmDeclare.getDeclareCode();
         strQMDeclareScript = strQMDeclareScript + "\n";
      }

      return strQMDeclareScript;
   }

   public static void appendConditionSQL(StringBuilderEx script, ArrayList<String> userConditions) {
      if (userConditions.size() != 0) {
         script.Append(" WHERE ");
         boolean bFirst = true;

         for (String strCondition : userConditions) {
            if (bFirst) {
               bFirst = false;
            } else {
               script.Append(" AND ");
            }

            script.Append("(%1$s)", strCondition);
         }
      }
   }

   public void setFieldQueryCaseSensitive(String strField, String strValue) {
      strField = strField.toUpperCase();
      if (StringHelper.IsNullOrEmpty(strValue)) {
         this.fieldCaseSensitiveMap.remove(strField);
      } else {
         int nValue = 0;
         String[] values = strValue.split("[;]");

         for (int i = 0; i < values.length; i++) {
            if (StringHelper.Compare(values[i], "LIKE", true) == 0) {
               nValue |= 2;
            } else if (StringHelper.Compare(values[i], "=", true) == 0) {
               nValue |= 1;
            } else if (StringHelper.Compare(values[i], "LIKESPLIT", true) == 0) {
               nValue |= 4;
            }
         }

         this.fieldCaseSensitiveMap.put(strField, nValue);
      }
   }

   public boolean isFieldQueryCaseSensitive(String strField, String strCondition) {
      strField = strField.toUpperCase();
      if (!this.fieldCaseSensitiveMap.containsKey(strField)) {
         return false;
      }

      int nValue = this.fieldCaseSensitiveMap.get(strField);
      return StringHelper.Compare(strCondition, "LIKE", true) != 0
            && StringHelper.Compare(strCondition, "LEFTLIKE", true) != 0
            && StringHelper.Compare(strCondition, "RIGHTLIKE", true) != 0
         ? (nValue & 1) != 0
         : (nValue & 2) != 0;
   }

   public boolean TestQueryOption(String strField, int nOption) {
      strField = strField.toUpperCase();
      if (!this.fieldCaseSensitiveMap.containsKey(strField)) {
         return false;
      }

      int nValue = this.fieldCaseSensitiveMap.get(strField);
      return (nValue & nOption) > 0;
   }

   public void setAttribute(String strKey, Object objValue) {
      strKey = strKey.toUpperCase();
      if (objValue == null) {
         this.attributeMap.remove(strKey);
      } else {
         this.attributeMap.put(strKey, objValue);
      }
   }

   public Object getAttribute(String strKey, Object objDefaultValue) {
      strKey = strKey.toUpperCase();
      Object objValue = this.attributeMap.get(strKey);
      return objValue == null ? objDefaultValue : objValue;
   }

   public ISRFDAGlobalHelper GetDAGlobalHelper() {
      return this.iDAGlobalHelper;
   }

   protected IPSDataEntity getPSDataEntity(String strPSDEId) throws Exception {
      return this.majorPSDataEntity.getPSSystem().getPSDataEntity2(strPSDEId);
   }

   protected IPSSystem getPSSystem() {
      return this.majorPSDataEntity.getPSSystem();
   }

   @Override
   public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
      return this.deDataQueryCodeExpImplList != null && this.deDataQueryCodeExpImplList.size() != 0 ? this.deDataQueryCodeExpImplList.iterator() : null;
   }

   @Override
   public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
      return this.deDataQueryCodeCondImplList != null && this.deDataQueryCodeCondImplList.size() != 0 ? this.deDataQueryCodeCondImplList.iterator() : null;
   }

   protected boolean isUseRazorEngine() {
      return this.getMajorPSDataEntity().getPSSystem().getPSSFId().indexOf("DOTNET") == 0;
   }

   @Override
   public Iterator<String> getPSDEDQAliasNames() {
      return this.qmAliasMap.size() == 0 ? null : this.qmAliasMap.keySet().iterator();
   }

   @Override
   public PSDEDQAlias getPSDEDQAlias(String strName, boolean bTryMode) throws Exception {
      PSDEDQAlias psDEDQAlias = this.qmAliasMap.get(strName.toLowerCase());
      if (psDEDQAlias != null) {
         return psDEDQAlias;
      } else {
         psDEDQAlias = this.qmAliasMap.get(strName.toUpperCase());
         if (psDEDQAlias != null) {
            return psDEDQAlias;
         } else if (bTryMode) {
            return null;
         } else {
            throw new Exception(String.format("无法获取指定别名[%1$s]", strName));
         }
      }
   }

   @Override
   public boolean isEnablePQL() {
      return this.bEnablePQL;
   }

   protected class DEDataQueryCodeCondImpl extends PSObjectImpl implements IDEDataQueryCodeCond {
      private String strCustomCond = "";
      private int nShowOrder = -1;

      @Override
      public void setName(String strName) {
         super.setName(strName);
      }

      public int getShowOrder() {
         return this.nShowOrder;
      }

      public void setShowOrder(int nShowOrder) {
         this.nShowOrder = nShowOrder;
      }

      @Override
      public String getDEFName() {
         return null;
      }

      @Override
      public String getCondType() {
         return "CUSTOM";
      }

      @Override
      public String getCondOp() {
         return null;
      }

      @Override
      public String getCondValue() {
         return null;
      }

      public void setCustomCond(String strCustomCond) {
         this.strCustomCond = strCustomCond;
      }

      @Override
      public String getCustomCond() {
         return this.strCustomCond;
      }

      @Override
      public String getPredefindedCond() {
         return null;
      }

      @Override
      public String getPredefinedCode() {
         return null;
      }

      @Override
      public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
         return null;
      }

      @Override
      public String getDEFieldExp() {
         return null;
      }

      @Override
      public boolean isNotMode() {
         return false;
      }

      @Override
      public int getStdDataType() {
         return 0;
      }

      @Override
      public String getPSSysModelInstId() {
         return null;
      }

      @Override
      public String getValueFunc() {
         return null;
      }
   }

   protected class DEDataQueryCodeExpImpl extends PSObjectImpl implements IDEDataQueryCodeExp {
      private String strExpression = "";
      private int nShowOrder = -1;

      @Override
      public void setName(String strName) {
         super.setName(strName);
      }

      @Override
      public String getExpression() {
         return this.strExpression;
      }

      @Override
      public int getShowOrder() {
         return this.nShowOrder;
      }

      public void setExpression(String strExpression) {
         this.strExpression = strExpression;
      }

      public void setShowOrder(int nShowOrder) {
         this.nShowOrder = nShowOrder;
      }

      @Override
      public String getPSSysModelInstId() {
         return null;
      }
   }

   class URLCondPair {
      public String strFieldName;
      public int nDataType;
      public String strCondition;
      public String strMacro;
      public String strURLParam;
      public boolean bAll = true;
   }
}
