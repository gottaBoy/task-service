package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.QM.QMCMacroParam;
import SA.SRFDA.Ctrl.Utility.EncryptHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Ctrl.Utility.StrTemplateLoader;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelCustomLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelJoinQueryConfig;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Model.DGModelSingleLogicConfig;
import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDAQueryModelHelper implements IDAQueryModelUserContext {
   public static final String QMVALUE_ISNULL = "__SRFQMVALUE_ISNULL__";
   public static final String QMVALUE_ISNOTNULL = "__SRFQMVALUE_ISNOTNULL__";
   protected IDEHelper iMajorDEHelper = null;
   protected ISRFDAGlobalHelper globalHelperEx = null;
   protected Hashtable<String, String> fieldExpMap = new Hashtable<>();
   protected Hashtable<String, String> fieldDataTypeMap = new Hashtable<>();
   private static final Log log = LogFactory.getLog(BaseDAQueryModelHelper.class);
   protected String strQueryScript = "";
   protected String strQueryScriptWithCondition = "";
   protected Vector<CallParam> callParams = new Vector<>();
   protected String strDAQueryModelHelperId = "";
   private int nAliasIndex = 0;
   private Vector<String> majorDERList = null;
   private TreeMap<String, Integer> majorDERAliasMap = null;
   private Vector<String> majorConditionList = null;
   private DAQueryModelGrooveEngine grooveEngine = null;
   protected TreeMap<String, DAQueryModelAlias> qmAliasMap = new TreeMap<>();
   protected TreeMap<String, QueryModelDeclare> qmDeclareMap = new TreeMap<>();
   protected TreeMap<String, Integer> fieldCaseSensitiveMap = new TreeMap<>();
   public static final int QUERYCASESENSITIVE_EQ = 1;
   public static final int QUERYCASESENSITIVE_LIKE = 2;
   public static final int QUERYOPTION_LIKESPLIT = 4;
   public static final String TAG_DYNAMICTABLES = "__DYNAMICTABLES__";
   private int nMacroIndex = 1;
   protected Vector<BaseDAQueryModelHelper.URLCondPair> urlCondPairList = new Vector<>();
   protected Map<String, Object> macroParams = new TreeMap<>();
   protected HashMap<String, String> globalParamMap = new HashMap<>();
   protected HashMap<String, Object> attributeMap = new HashMap<>();

   public CallResult Init(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelperEx) {
      CallResult callResult = new CallResult();
      this.iMajorDEHelper = iDEHelper;
      this.globalHelperEx = globalHelperEx;
      this.grooveEngine = new DAQueryModelGrooveEngine();
      this.grooveEngine.Init(this);
      QMCMacroParam qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(1);
      this.macroParams.put("curfield", qm1);
      qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(0);
      this.macroParams.put("field", qm1);
      qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(2);
      this.macroParams.put("mainfield", qm1);
      qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(4);
      this.macroParams.put("param", qm1);
      qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(5);
      this.macroParams.put("staticparam", qm1);
      qm1 = new QMCMacroParam();
      qm1.setDAQueryModelContext(this.grooveEngine);
      qm1.setMPType(3);
      this.macroParams.put("table", qm1);
      return callResult;
   }

   public void RegisterStaticParamValue(String strMacroParam, String strValue) {
      this.globalParamMap.put(strMacroParam, strValue);
   }

   public String GetStaticParamValue(String strMacroParam) {
      return this.globalParamMap.get(strMacroParam);
   }

   public CallResult Compile(
      DGModelMainQueryConfig mainQueryConfig,
      DGModelMainQueryConfig mainQueryConfig2,
      boolean bDPControl,
      Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs,
      Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs
   ) {
      return this.CompileEx(mainQueryConfig, mainQueryConfig2, bDPControl, notQueryConfigs, orQueryConfigs, false);
   }

   public CallResult CompileEx(
      DGModelMainQueryConfig mainQueryConfig,
      DGModelMainQueryConfig mainQueryConfig2,
      boolean bDPControl,
      Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs,
      Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs,
      boolean bDelete
   ) {
      CallResult callResult = new CallResult();
      this.callParams.clear();
      Vector<String> mainConditionList = new Vector<>();
      Vector<String> derList = new Vector<>();
      TreeMap<String, Integer> derAliasMap = new TreeMap<>();
      derAliasMap.put("", 0);
      this.fieldExpMap.clear();
      TreeMap<String, String> extSelects = new TreeMap<>();
      StringBuilderEx script = new StringBuilderEx();
      String strSelectColumns = mainQueryConfig.getExtSelect();
      if (!StringHelper.IsNullOrEmpty(strSelectColumns)) {
         if (mainQueryConfig2 != null) {
            String strSelectColumns2 = mainQueryConfig2.getExtSelect();
            if (!StringHelper.IsNullOrEmpty(strSelectColumns2)) {
               strSelectColumns = strSelectColumns + ";";
               strSelectColumns = strSelectColumns + strSelectColumns2;
            }
         }
      } else if (mainQueryConfig2 != null) {
         strSelectColumns = mainQueryConfig2.getExtSelect();
      }

      TreeMap<String, Integer> selectColumns = null;
      boolean bSelectColumn = false;
      if (!StringHelper.IsNullOrEmpty(strSelectColumns)) {
         selectColumns = new TreeMap<>();
         String[] columns = strSelectColumns.split("[;]");

         for (int i = 0; i < columns.length; i++) {
            String strColumn = columns[i];
            strColumn = strColumn.trim();
            if (!StringHelper.IsNullOrEmpty(strColumn)) {
               selectColumns.put(strColumn.toUpperCase(), 1);
            }
         }

         bSelectColumn = selectColumns.size() > 0;
      }

      for (IDEFHelper iDEFHelper : this.iMajorDEHelper.GetDEFHelpers()) {
         if (bSelectColumn && !selectColumns.containsKey(iDEFHelper.getName())) {
            if (iDEFHelper.GetDTColumn().isViewColumn() && (iDEFHelper.IsPhisicalDEField() || iDEFHelper.IsInheritDEField())) {
               callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
               String strDataType = iDEFHelper.GetStdDataType();
               if (StringHelper.IsNullOrEmpty(strDataType)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法获取属性[%1$s]的数据类型", iDEFHelper.GetFullName()));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               this.fieldDataTypeMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), strDataType);
               this.fieldExpMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), (String)callResult.getUserObject());
            }
         } else if (iDEFHelper.GetDTColumn().isViewColumn()) {
            callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
               log.error(StringHelper.Format("无法获取属性[%1$s]对应的表达式", iDEFHelper.getName()));
               return callResult;
            }

            IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
            if (StringHelper.Compare(iDEFHelper.GetDataType(), "TEXT", false) == 0) {
               log.error(StringHelper.Format("长文本属性[%1$s]放入查询中，会影响检索性能", iDEFHelper.getName()));
            }

            extSelects.put(iDEFDTColumn.GetFormalColumnName().toUpperCase(), (String)callResult.getUserObject());
            String strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty(strDataType)) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法获取属性[%1$s]的数据类型", iDEFHelper.GetFullName()));
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            this.fieldDataTypeMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), strDataType);
            this.fieldExpMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), (String)callResult.getUserObject());
         }
      }

      IDEFHelper keyDEFHelper = this.iMajorDEHelper.GetKeyDEFHelper();
      if (keyDEFHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]的主键属性 ", this.iMajorDEHelper.GetFullName()));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      String strMainTable = this.iMajorDEHelper.getDataEntity().getTABLENAME();
      String strUserTable = this.iMajorDEHelper.getDataEntity().getEXTABLENAME();
      boolean bDynamicTable = false;
      if (StringHelper.Compare(this.iMajorDEHelper.getDataEntity().getSTORAGETYPE(), "DYNAMIC", true) == 0) {
         bDynamicTable = true;
         script.Append("\nFROM %1$s t1 \n", "__DYNAMICTABLES__");
      } else {
         script.Append("\nFROM %1$s t1 \n", strMainTable);
         if (!StringHelper.IsNullOrEmpty(strUserTable) && !bDelete) {
            script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", strUserTable, keyDEFHelper.GetDTColumn().GetFormalColumnName());
         }
      }

      DAQueryModelAlias qmAlias = new DAQueryModelAlias();
      qmAlias.setIDEHelper(this.iMajorDEHelper);
      qmAlias.setParentDER("");
      qmAlias.setDERAliasMap(derAliasMap);
      qmAlias.setDERList(derList);
      this.qmAliasMap.put("MAIN", qmAlias);
      if (!StringHelper.IsNullOrEmpty(mainQueryConfig.getAlias())) {
         this.qmAliasMap.put(mainQueryConfig.getAlias().toUpperCase(), qmAlias);
      }

      if (mainQueryConfig.getJoinQueriesConfig() != null) {
         for (DGModelJoinQueryConfig joinQueryConfig : mainQueryConfig.getJoinQueriesConfig()) {
            if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1RIGHT", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOMN1", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11M", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NLEFTOUT", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1N", true) == 0) {
               callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1N", true) == 0) {
               callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEX", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEXM", true) == 0) {
               callResult = this.BuildJoinQuery(
                  this.iMajorDEHelper,
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
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            }
         }
      }

      if (mainQueryConfig2 != null && mainQueryConfig2.getJoinQueriesConfig() != null) {
         if (!StringHelper.IsNullOrEmpty(mainQueryConfig2.getAlias())) {
            this.qmAliasMap.put(mainQueryConfig2.getAlias().toUpperCase(), qmAlias);
         }

         callResult = this.Complie(mainQueryConfig2, this.iMajorDEHelper, derAliasMap, derList, mainConditionList, extSelects);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }
      }

      if (bDPControl) {
         if (notQueryConfigs != null) {
            for (Vector<DGModelMainQueryConfig> notList : notQueryConfigs) {
               Vector<String> listconditions = new Vector<>();

               for (DGModelMainQueryConfig queryConfig : notList) {
                  if (!StringHelper.IsNullOrEmpty(queryConfig.getAlias())) {
                     this.qmAliasMap.put(queryConfig.getAlias().toUpperCase(), qmAlias);
                  }

                  Vector<String> conditions = new Vector<>();
                  callResult = this.Complie(queryConfig, this.iMajorDEHelper, derAliasMap, derList, conditions, null);
                  if (callResult.getRetCode() != 0) {
                     return callResult;
                  }

                  if (queryConfig.getLogicConfig() != null) {
                     callResult = this.GetGroupCondition(this.iMajorDEHelper, "", queryConfig.getLogicConfig(), derAliasMap, derList);
                     if (callResult.getRetCode() != 0) {
                        return callResult;
                     }

                     String strGroupCondition = (String)callResult.getUserObject();
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
                        if (queryConfig.isExclude()) {
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
            for (Vector<DGModelMainQueryConfig> orList : orQueryConfigs) {
               Vector<String> listconditions = new Vector<>();

               for (DGModelMainQueryConfig queryConfig : orList) {
                  if (!StringHelper.IsNullOrEmpty(queryConfig.getAlias())) {
                     this.qmAliasMap.put(queryConfig.getAlias().toUpperCase(), qmAlias);
                  }

                  Vector<String> conditions = new Vector<>();
                  callResult = this.Complie(queryConfig, this.iMajorDEHelper, derAliasMap, derList, conditions, null);
                  if (callResult.getRetCode() != 0) {
                     return callResult;
                  }

                  if (queryConfig.getLogicConfig() != null) {
                     callResult = this.GetGroupCondition(this.iMajorDEHelper, "", queryConfig.getLogicConfig(), derAliasMap, derList);
                     if (callResult.getRetCode() != 0) {
                        return callResult;
                     }

                     String strGroupCondition = (String)callResult.getUserObject();
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
                        if (queryConfig.isExclude()) {
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

      if (this.iMajorDEHelper.IsLogicValid()) {
         IDEFHelper iDEFHelper = this.iMajorDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
         if (iDEFHelper == null) {
            callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]的逻辑有效属性", this.iMajorDEHelper.GetFullName()));
            callResult.setRetCode(1);
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         mainConditionList.add(
            StringHelper.Format("t1.%1$s = %2$s", iDEFHelper.GetDTColumn().GetFormalColumnName(), this.iMajorDEHelper.GetProperty("VALIDVALUE"))
         );
      }

      if (mainQueryConfig.getLogicConfig() != null) {
         callResult = this.GetGroupCondition(this.iMajorDEHelper, "", mainQueryConfig.getLogicConfig(), derAliasMap, derList);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }

         String strGroupCondition = (String)callResult.getUserObject();
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      if (mainQueryConfig2 != null && mainQueryConfig2.getLogicConfig() != null) {
         callResult = this.GetGroupCondition(this.iMajorDEHelper, "", mainQueryConfig2.getLogicConfig(), derAliasMap, derList);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }

         String strGroupCondition = (String)callResult.getUserObject();
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      TreeMap<String, Integer> joinMap = new TreeMap<>();

      for (String strDERs : derList) {
         callResult = this.GetJoin(script, this.iMajorDEHelper, "", strDERs, derAliasMap, joinMap);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }
      }

      this.majorConditionList = mainConditionList;
      if (bDelete) {
         this.strQueryScript = "DELETE \n";
      } else {
         this.strQueryScript = "SELECT\n";
         if (mainQueryConfig.isDistinct()) {
            this.strQueryScript = this.strQueryScript + " DISTINCT\n";
         }

         boolean bFirst = true;

         for (String strColumnName : extSelects.keySet()) {
            if (bFirst) {
               bFirst = false;
            } else {
               this.strQueryScript = this.strQueryScript + ",\n";
            }

            String strField = extSelects.get(strColumnName);
            this.strQueryScript = this.strQueryScript + StringHelper.Format("%1$s AS %2$s", strField, strColumnName);
         }
      }

      this.strQueryScript = this.strQueryScript + script.toString();
      this.majorDERList = derList;
      this.majorDERAliasMap = derAliasMap;
      return callResult;
   }

   public CallResult Compile(DGModelMainQueryConfig mainQueryConfig) {
      return this.Compile(mainQueryConfig, null, false, null, null);
   }

   public CallResult Compile(DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2) {
      return this.CompileEx(mainQueryConfig, mainQueryConfig2, false, null, null, false);
   }

   public CallResult CompileEx(DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, boolean bDeleteMode) {
      return this.CompileEx(mainQueryConfig, mainQueryConfig2, false, null, null, bDeleteMode);
   }

   private final CallResult Complie(
      DGModelMainQueryConfig mainQueryConfig,
      IDEHelper iDEHelper,
      TreeMap<String, Integer> derAliasMap,
      Vector<String> derList,
      Vector<String> conditionList,
      TreeMap<String, String> extSelects
   ) {
      CallResult callResult = new CallResult();
      if (mainQueryConfig.getJoinQueriesConfig() == null) {
         return callResult;
      }

      for (DGModelJoinQueryConfig joinQueryConfig : mainQueryConfig.getJoinQueriesConfig()) {
         if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1RIGHT", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, false, false, true, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOMN1", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, true, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, true, false, false, false, false, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11M", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, true, false, false, false, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NLEFTOUT", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, true, false, false, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1N", true) == 0) {
            callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            conditionList.add((String)callResult.getUserObject());
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1N", true) == 0) {
            callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            conditionList.add((String)callResult.getUserObject());
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NNOT", true) == 0) {
            callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            conditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1NNOT", true) == 0) {
            callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            conditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEX", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, true, false, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEXM", true) == 0) {
            callResult = this.BuildJoinQuery(
               this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, true, false, false, extSelects
            );
            if (callResult.getRetCode() != 0) {
               return callResult;
            }
         }
      }

      return callResult;
   }

   public CallResult CompileRawCodeMode(String strQuerySQL, String strQueryCond, String strQueryParam, String strQueryField) {
      CallResult callResult = new CallResult();
      this.strQueryScript = strQuerySQL;
      if (!StringHelper.IsNullOrEmpty(strQueryCond)) {
         if (this.majorConditionList == null) {
            this.majorConditionList = new Vector<>();
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
         e.printStackTrace();
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("加载查询变量发生错误，%1$s", e.getMessage()));
         return callResult;
      }

      this.fieldExpMap.clear();
      this.fieldDataTypeMap.clear();

      for (IDEFHelper iDEFHelper : this.iMajorDEHelper.GetDEFHelpers()) {
         this.fieldDataTypeMap.put(iDEFHelper.GetDTColumn().GetColumnName().toUpperCase(), iDEFHelper.GetDataType());
         this.fieldExpMap.put(iDEFHelper.GetDTColumn().GetColumnName().toUpperCase(), iDEFHelper.GetDTColumn().GetColumnName());
      }

      return callResult;
   }

   public String GetQueryModelScript() {
      return this.strQueryScript;
   }

   public String GetQueryModelScriptEx(ISRFExWebContext webContext) {
      String strFinalScript = this.strQueryScript;

      for (BaseDAQueryModelHelper.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   public String ReplaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext, boolean bTestPost) {
      for (BaseDAQueryModelHelper.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue) && bTestPost) {
            strParamValue = webContext.GetPostValue(condPair.strURLParam.toLowerCase());
         }

         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   public String ReplaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext) {
      return this.ReplaceURLParamMacro(strFinalScript, webContext, false);
   }

   public String ReplaceDynamicTableMacro(String strFinalScript, Vector<String> dynamicTables) {
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

   public String GetQueryModelScript(Vector<String> userConditionList) {
      Vector<String> conditionList = userConditionList;
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

   public String GetQueryModelScriptEx(Vector<String> userConditionList, ISRFExWebContext webContext) {
      Vector<String> conditionList = userConditionList;
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

      for (BaseDAQueryModelHelper.URLCondPair condPair : this.urlCondPairList) {
         String strParamValue = webContext.GetParamValue(condPair.strURLParam);
         if (StringHelper.IsNullOrEmpty(strParamValue)) {
            strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
         } else {
            String strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, "");
            if (StringHelper.IsNullOrEmpty(strCond)) {
               strFinalScript = strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1");
            } else {
               strFinalScript = strFinalScript.replace(condPair.strMacro, strCond);
            }
         }
      }

      return strFinalScript;
   }

   @Override
   public void FillQMDeclareParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId) {
      this.FillQMDeclareParams(list, webContext, globalHelperEx, strCurPersonId, null);
   }

   @Override
   public void FillQMDeclareParams(
      Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity
   ) {
      CallResult callResult = null;

      for (String strName : this.qmDeclareMap.keySet()) {
         QueryModelDeclare qmDeclare = this.qmDeclareMap.get(strName);

         for (CallParam callParam : qmDeclare.getParams()) {
            CallParam cp = callParam.Clone();
            callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
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

   public void FillCallParams(
      Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity
   ) {
      CallResult callResult = null;

      for (CallParam callParam : this.callParams) {
         CallParam cp = callParam.Clone();
         callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
         if (callResult.getRetCode() == 0) {
            Object objValue = callResult.getUserObject();
            if (objValue == null || StringHelper.Compare(objValue.toString(), cp.getParamName(), true) != 0) {
               cp.setValue(objValue);
            }
         }

         list.add(cp);
      }
   }

   public void FillCallParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId) {
      this.FillCallParams(list, webContext, globalHelperEx, strCurPersonId, null);
   }

   public void FillMajorConditions(Vector<String> list) {
      if (this.majorConditionList != null) {
         for (String strCondition : this.majorConditionList) {
            list.add(strCondition);
         }
      }
   }

   private CallResult BuildJoinQuery(
      IDEHelper iDEHelper,
      DGModelJoinQueryConfig joinQueryConfig,
      String strParentDER,
      TreeMap<String, Integer> derAliasMap,
      Vector<String> derList,
      Vector<String> mainConditionList,
      boolean bN1,
      boolean b11,
      boolean b11M,
      boolean b1NLEFTOUTER,
      boolean bIndex,
      boolean bIndexM,
      boolean bCustom,
      boolean bN1RIGHT,
      TreeMap<String, String> extSelects
   ) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      if (iDEHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法获取实体辅助对象"));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      String strDERID = joinQueryConfig.getDERID();
      String strMajorDEID = "";
      if (bN1 || b1NLEFTOUTER || bN1RIGHT) {
         if (bCustom) {
            DERCUSTOM der1N = new DERCUSTOM();
            callResult = this.globalHelperEx.getDAModelHelper().GetDERCUSTOM(strDERID, der1N);
            if (callResult.getRetCode() != 0) {
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            if (bN1) {
               strMajorDEID = der1N.getMAJORDEID();
            } else if (b1NLEFTOUTER) {
               strMajorDEID = der1N.getMINORDEID();
               strDERID = "1NLO:" + strDERID;
            } else {
               strMajorDEID = der1N.getMAJORDEID();
               strDERID = "N1R:" + strDERID;
            }
         } else {
            DER1N der1N = new DER1N();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strDERID, der1N);
            if (callResult.getRetCode() != 0) {
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            if (bN1) {
               strMajorDEID = der1N.getMAJORDEID();
            } else if (b1NLEFTOUTER) {
               strMajorDEID = der1N.getMINORDEID();
               strDERID = "1NLO:" + strDERID;
            } else {
               strMajorDEID = der1N.getMAJORDEID();
               strDERID = "N1R:" + strDERID;
            }
         }
      }

      if (b11 || b11M) {
         DER11 der11 = new DER11();
         callResult = this.globalHelperEx.getDAModelHelper().GetDER11(strDERID, der11);
         if (callResult.getRetCode() != 0) {
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (b11) {
            strMajorDEID = der11.getMAJORDEID();
         } else {
            strMajorDEID = der11.getMINORDEID();
            strDERID = "11M:" + strDERID;
         }
      }

      if (bIndex || bIndexM) {
         DERINDEX derIndex = new DERINDEX();
         callResult = this.globalHelperEx.getDAModelHelper().GetDERINDEX(strDERID, derIndex);
         if (callResult.getRetCode() != 0) {
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (bIndex) {
            strMajorDEID = derIndex.getINDEXDEID();
            strDERID = "INDEX:" + strDERID;
         } else {
            strMajorDEID = derIndex.getDEID();
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
      IDEHelper iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strMajorDEID);
      if (iCurDEHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]辅助对象", strMajorDEID));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      if (extSelects != null) {
         String strExtSelect = joinQueryConfig.getExtSelect();
         if (!StringHelper.IsNullOrEmpty(strExtSelect)) {
            try {
               Properties extPros = PropertiesHelper.Load(null, strExtSelect);

               for (Object objKey : extPros.keySet()) {
                  String strKeyValue = PropertiesHelper.GetProperty(extPros, objKey.toString());
                  if (StringHelper.IsNullOrEmpty(strKeyValue)) {
                     strKeyValue = objKey.toString();
                  }

                  IDEFHelper iDEFHelper = iCurDEHelper.GetDEFHelper(strKeyValue);
                  if (iDEFHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]属性[%2$s]辅助对象", strMajorDEID, strKeyValue));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  callResult = this.GetDEFieldExp(iDEFHelper, strNewDER, derAliasMap, derList);
                  if (callResult.getRetCode() != 0) {
                     return callResult;
                  }

                  String strFieldName = (String)callResult.getUserObject();
                  extSelects.put(objKey.toString(), strFieldName);
               }
            } catch (Exception var29) {
            }
         }
      }

      if (!StringHelper.IsNullOrEmpty(joinQueryConfig.getAlias())) {
         DAQueryModelAlias qmAlias = new DAQueryModelAlias();
         qmAlias.setIDEHelper(iCurDEHelper);
         qmAlias.setParentDER(strNewDER);
         qmAlias.setDERAliasMap(derAliasMap);
         qmAlias.setDERList(derList);
         this.qmAliasMap.put(joinQueryConfig.getAlias().toUpperCase(), qmAlias);
      }

      if (joinQueryConfig.getJoinQueriesConfig() != null) {
         for (DGModelJoinQueryConfig subjoinQueryConfig : joinQueryConfig.getJoinQueriesConfig()) {
            if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "N1", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "N1RIGHT", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "CUSTOMN1", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "11", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "11M", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "1NLEFTOUT", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "1N", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "CUSTOM1N", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "CUSTOM1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "INDEX", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            } else if (StringHelper.Compare(subjoinQueryConfig.getDERType(), "INDEXM", true) == 0) {
               callResult = this.BuildJoinQuery(
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
               if (callResult.getRetCode() != 0) {
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }
            }
         }
      }

      if (joinQueryConfig.getLogicConfig() != null) {
         callResult = this.GetGroupCondition(iCurDEHelper, strNewDER, joinQueryConfig.getLogicConfig(), derAliasMap, derList);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }

         String strGroupCondition = (String)callResult.getUserObject();
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      callResult.setRetCode(0);
      return callResult;
   }

   protected CallResult BuildExistQuery(IDEHelper iDEHelper, DGModelJoinQueryConfig existQueryConfig, int nAlias, boolean bCustom) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      if (iDEHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法获取实体辅助对象"));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      String strDERID = existQueryConfig.getDERID();
      Vector<String> mainConditionList = new Vector<>();
      Vector<String> derList = new Vector<>();
      TreeMap<String, Integer> derAliasMap = new TreeMap<>();
      IDEHelper iCurDEHelper = null;
      int nCurAliasIndex = -1;
      StringBuilderEx script = new StringBuilderEx();
      boolean bFirst = true;
      if (bCustom) {
         DERCUSTOM der1N = new DERCUSTOM();
         callResult = this.globalHelperEx.getDAModelHelper().GetDERCUSTOM(strDERID, der1N);
         if (callResult.getRetCode() != 0) {
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
         if (iCurDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]辅助对象", der1N.getMINORDEID()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (!StringHelper.IsNullOrEmpty(existQueryConfig.getAlias())) {
            DAQueryModelAlias qmAlias = new DAQueryModelAlias();
            qmAlias.setIDEHelper(iCurDEHelper);
            qmAlias.setParentDER("");
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            this.qmAliasMap.put(existQueryConfig.getAlias().toUpperCase(), qmAlias);
         }

         IDEFHelper pKeyDEFHelper = iCurDEHelper.GetKeyDEFHelper();
         String strMainTable = iCurDEHelper.GetMainTable();
         String strUserTable = iCurDEHelper.GetUserTable();
         String strMainTable2 = strMainTable;
         String strUserTable2 = strUserTable;
         if (StringHelper.Compare(iCurDEHelper.GetDBStorage(), this.iMajorDEHelper.GetDBStorage(), true) != 0) {
            strMainTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.GetDBSchema(), strMainTable);
            strUserTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.GetDBSchema(), strUserTable);
         }

         nCurAliasIndex = this.getAliasIndex();
         derAliasMap.put("", nCurAliasIndex);
         script.Append("SELECT * FROM %1$s t%2$s \n", strMainTable2, nCurAliasIndex + 1);
         if (!StringHelper.IsNullOrEmpty(strUserTable)) {
            script.Append(
               "INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n",
               strUserTable2,
               pKeyDEFHelper.GetDTColumn().GetFormalColumnName(),
               nCurAliasIndex + 1,
               nCurAliasIndex + 2
            );
         }

         if (iCurDEHelper.IsLogicValid()) {
            IDEFHelper iValidDEFHelper = iCurDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iValidDEFHelper == null) {
               callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]的逻辑有效属性", iCurDEHelper.GetFullName()));
               callResult.setRetCode(1);
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            mainConditionList.add(
               StringHelper.Format(
                  "t%3$s.%1$s = %2$s", iValidDEFHelper.GetDTColumn().GetFormalColumnName(), iCurDEHelper.GetProperty("VALIDVALUE"), nCurAliasIndex + 1
               )
            );
         }

         boolean bMT = true;
         String strCurMTAlias = StringHelper.Format("t%1$s", nCurAliasIndex + 1);
         String strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
         String strCustomJoin = der1N.getJOINCOND().replace("%%SRFMAJOR%%", strCurMTAlias);
         strCustomJoin = strCustomJoin.replace("%%SRFMINOR%%", strMTAlias);
         mainConditionList.add("(" + strCustomJoin + ")");
      } else {
         DER1N der1N = new DER1N();
         callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strDERID, der1N);
         if (callResult.getRetCode() != 0) {
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
         if (iCurDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]辅助对象", der1N.getMINORDEID()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (!StringHelper.IsNullOrEmpty(existQueryConfig.getAlias())) {
            DAQueryModelAlias qmAlias = new DAQueryModelAlias();
            qmAlias.setIDEHelper(iCurDEHelper);
            qmAlias.setParentDER("");
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            this.qmAliasMap.put(existQueryConfig.getAlias().toUpperCase(), qmAlias);
         }

         IDEFHelper pKeyDEFHelper = iCurDEHelper.GetKeyDEFHelper();
         IDEFHelper pickupDEFHelper = null;

         for (IDEFHelper iDEFHelper : iCurDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsLinkDEField() && iDEFHelper instanceof ILinkDEFHelper) {
               ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
               if (StringHelper.Compare(linkDEFHelper.GetDERId(), der1N.getDERID(), true) == 0
                  && StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUP", true) == 0) {
                  pickupDEFHelper = iDEFHelper;
                  break;
               }
            }
         }

         if (pKeyDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]的主键属性 ", iCurDEHelper.GetFullName()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (pickupDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]的与相关实体的关系属性 ", iCurDEHelper.GetFullName()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         IDEFHelper pickupRelatedDEFHelper = null;
         if (pickupDEFHelper instanceof ILinkDEFHelper) {
            pickupRelatedDEFHelper = ((ILinkDEFHelper)pickupDEFHelper).GetRelatedDEFHelper();
         }

         if (pickupRelatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法获取属性[%1$s]的关系属性 ", pickupDEFHelper.GetFullName()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         if (StringHelper.Compare(pickupRelatedDEFHelper.getDEHelper().getId(), iDEHelper.getId(), true) != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("关系属性[%1$s]的实体与上级实体不一致 ", pickupDEFHelper.GetFullName()));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         String strMainTable = iCurDEHelper.GetMainTable();
         String strUserTable = iCurDEHelper.GetUserTable();
         String strMainTable2 = strMainTable;
         String strUserTable2 = strUserTable;
         if (StringHelper.Compare(iCurDEHelper.GetDBStorage(), this.iMajorDEHelper.GetDBStorage(), true) != 0) {
            strMainTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.GetDBSchema(), strMainTable);
            strUserTable2 = StringHelper.Format("%1$s.%2$s", iCurDEHelper.GetDBSchema(), strUserTable);
         }

         nCurAliasIndex = this.getAliasIndex();
         derAliasMap.put("", nCurAliasIndex);
         script.Append("SELECT * FROM %1$s t%2$s \n", strMainTable2, nCurAliasIndex + 1);
         if (!StringHelper.IsNullOrEmpty(strUserTable)) {
            script.Append(
               "INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n",
               strUserTable2,
               pKeyDEFHelper.GetDTColumn().GetFormalColumnName(),
               nCurAliasIndex + 1,
               nCurAliasIndex + 2
            );
         }

         if (iCurDEHelper.IsLogicValid()) {
            IDEFHelper iValidDEFHelper = iCurDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iValidDEFHelper == null) {
               callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]的逻辑有效属性", iCurDEHelper.GetFullName()));
               callResult.setRetCode(1);
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            mainConditionList.add(
               StringHelper.Format(
                  "t%3$s.%1$s = %2$s", iValidDEFHelper.GetDTColumn().GetFormalColumnName(), iCurDEHelper.GetProperty("VALIDVALUE"), nCurAliasIndex + 1
               )
            );
         }

         boolean bMT = true;
         if (StringHelper.Compare(pickupDEFHelper.GetDTColumn().GetTableName(), strMainTable, true) == 0) {
            bMT = true;
         } else {
            bMT = false;
         }

         mainConditionList.add(
            StringHelper.Format(
               "t%1$s.%3$s = t%2$s.%4$s",
               nAlias + 1,
               nCurAliasIndex + (bMT ? 1 : 2),
               pickupRelatedDEFHelper.GetDTColumn().GetFormalColumnName(),
               pickupDEFHelper.GetDTColumn().GetFormalColumnName()
            )
         );
      }

      if (existQueryConfig.getJoinQueriesConfig() != null) {
         for (DGModelJoinQueryConfig joinQueryConfig : existQueryConfig.getJoinQueriesConfig()) {
            if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "N1RIGHT", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOMN1", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "11M", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NLEFTOUT", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1N", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1N", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add((String)callResult.getUserObject());
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "CUSTOM1NNOT", true) == 0) {
               callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEX", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            } else if (StringHelper.Compare(joinQueryConfig.getDERType(), "INDEXM", true) == 0) {
               callResult = this.BuildJoinQuery(
                  iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, null
               );
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }
            }
         }
      }

      if (existQueryConfig.getLogicConfig() != null) {
         callResult = this.GetGroupCondition(iCurDEHelper, "", existQueryConfig.getLogicConfig(), derAliasMap, derList);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }

         String strGroupCondition = (String)callResult.getUserObject();
         if (!StringHelper.IsNullOrEmpty(strGroupCondition)) {
            mainConditionList.add(strGroupCondition);
         }
      }

      TreeMap<String, Integer> joinMap = new TreeMap<>();

      for (String strDERs : derList) {
         callResult = this.GetJoin(script, iCurDEHelper, "", strDERs, derAliasMap, joinMap);
         if (callResult.getRetCode() != 0) {
            return callResult;
         }
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

      callResult.setRetCode(0);
      callResult.setUserObject("EXISTS(" + script.toString() + ")");
      return callResult;
   }

   public CallResult GetGroupCondition(DGModelGroupLogicConfig dgModelGroupLogicConfig) {
      return this.GetGroupCondition(this.iMajorDEHelper, "", dgModelGroupLogicConfig, this.majorDERAliasMap, this.majorDERList);
   }

   public String GetDEFieldExp(String strDEField) throws Exception {
      IDEFHelper iDEFHelper = this.iMajorDEHelper.GetDEFHelper(strDEField);
      if (iDEFHelper == null) {
         throw new Exception(StringHelper.Format("无法获取实体属性[%1$s]对象", strDEField));
      } else {
         CallResult callResult = this.GetDEFieldExp(iDEFHelper);
         if (callResult.IsError()) {
            throw new Exception(StringHelper.Format("无法获取实体属性[%1$s]对应表达式，%2$s", strDEField, callResult.getErrorInfo()));
         } else {
            return (String)callResult.getUserObject();
         }
      }
   }

   public CallResult GetDEFieldExp(IDEFHelper iDEFHelper) {
      return this.GetDEFieldExp(iDEFHelper, "", this.majorDERAliasMap, this.majorDERList);
   }

   public int GetMajorDERAlias(String strDERId) {
      return this.majorDERAliasMap.containsKey(strDERId) ? this.majorDERAliasMap.get(strDERId) : -1;
   }

   protected CallResult GetGroupCondition(
      IDEHelper iDEHelper, String strParentDER, DGModelGroupLogicConfig dgModelGroupLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList
   ) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(0);
      StringBuilderEx script = new StringBuilderEx();
      if (dgModelGroupLogicConfig.getLogicsConfig() == null) {
         callResult.setUserObject("");
         return callResult;
      }

      if (dgModelGroupLogicConfig.getLogicsConfig().size() == 0) {
         callResult.setUserObject("");
         return callResult;
      }

      callResult.setRetCode(1);
      if (dgModelGroupLogicConfig.isNot()) {
         script.Append("NOT");
      }

      script.Append("(");
      boolean bFirst = true;

      for (DGModelBaseLogicConfig dgModelBaseLogicConfig : dgModelGroupLogicConfig.getLogicsConfig()) {
         if (bFirst) {
            bFirst = false;
         } else if (StringHelper.Compare(dgModelGroupLogicConfig.getCondition(), "AND", true) == 0) {
            script.Append(" AND ");
         } else {
            script.Append(" OR ");
         }

         if (dgModelBaseLogicConfig instanceof DGModelGroupLogicConfig) {
            callResult = this.GetGroupCondition(iDEHelper, strParentDER, (DGModelGroupLogicConfig)dgModelBaseLogicConfig, derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            script.Append(" %1$s ", callResult.getUserObject());
         } else if (dgModelBaseLogicConfig instanceof DGModelSingleLogicConfig) {
            callResult = this.GetSingleCondition(iDEHelper, strParentDER, (DGModelSingleLogicConfig)dgModelBaseLogicConfig, derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
               return callResult;
            }

            script.Append(" %1$s ", callResult.getUserObject());
         } else if (dgModelBaseLogicConfig instanceof DGModelCustomLogicConfig) {
            DGModelCustomLogicConfig customLogicConfig = (DGModelCustomLogicConfig)dgModelBaseLogicConfig;
            if (!StringHelper.IsNullOrEmpty(customLogicConfig.getCondition())) {
               callResult = this.GetCustomCondition(iDEHelper, strParentDER, customLogicConfig, derAliasMap, derList);
               if (callResult.getRetCode() != 0) {
                  log.error(
                     StringHelper.Format(
                        "计算自定义逻辑[%1$s -- %2$s]失败，%3$s", customLogicConfig.getLogicName(), customLogicConfig.getCondition(), callResult.getErrorInfo()
                     )
                  );
                  return callResult;
               }

               script.Append(" %1$s ", callResult.getUserObject());
            }
         }
      }

      script.Append(")");
      callResult.setRetCode(0);
      callResult.setUserObject(script.toString());
      return callResult;
   }

   protected CallResult GetSingleCondition(
      IDEHelper iDEHelper, String strParentDER, DGModelSingleLogicConfig dgModelSingleLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList
   ) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(0);
      if (iDEHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo("没有指定实体辅助对象");
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dgModelSingleLogicConfig.getDEField());
      if (iDEFHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法找到属性[%1$s]", dgModelSingleLogicConfig.getDEField()));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      callResult = this.GetDEFieldExp(iDEFHelper, strParentDER, derAliasMap, derList);
      if (callResult.getRetCode() != 0) {
         return callResult;
      }

      String strFieldName = (String)callResult.getUserObject();
      String strFunc = dgModelSingleLogicConfig.getFunc();
      if (StringHelper.IsNullOrEmpty(strFunc)) {
         String strParamName = dgModelSingleLogicConfig.getParamName();
         String strParamValue = dgModelSingleLogicConfig.getValue();
         if (this.globalParamMap.containsKey(strParamName)) {
            strParamValue = this.globalParamMap.get(strParamName);
            strParamName = "";
         }

         IDEFQueryHelper iDEFQueryHelper = iDEFHelper.GetQueryHelper();
         if (iDEFQueryHelper != null) {
            String strSQL = iDEFQueryHelper.GetConditionSQL(this, this, strFieldName, dgModelSingleLogicConfig.getCondition(), strParamValue, strParamName);
            callResult.setUserObject(strSQL);
            callResult.setRetCode(0);
            return callResult;
         } else {
            String strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty(strDataType)) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法获取属性[%1$s]的数据类型", iDEFHelper.GetFullName()));
               log.error(callResult.getErrorInfo());
               return callResult;
            } else {
               String strSQL = this.GetConditionSQL(strFieldName, strDataType, dgModelSingleLogicConfig.getCondition(), strParamValue, strParamName);
               if (StringHelper.IsNullOrEmpty(strSQL)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法获取条件语句"));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               } else {
                  callResult.setUserObject(strSQL);
                  callResult.setRetCode(0);
                  return callResult;
               }
            }
         }
      } else {
         IDAValueFunc iDAValueFunc = this.globalHelperEx.getDAConfigMgr().getValueFuncMgr().FindFunc(strFunc, this.GetDBType(), iDEFHelper.GetStdDataType());
         if (iDAValueFunc == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法找到的值处理函数[%1$s]", strFunc));
            log.error(callResult.getErrorInfo());
            return callResult;
         } else {
            String strFuncFormat = StringHelper.Format(iDAValueFunc.GetFuncFormat(), strFieldName);
            String strSQL = this.GetConditionSQL(
               strFuncFormat,
               iDAValueFunc.GetDataType(),
               dgModelSingleLogicConfig.getCondition(),
               dgModelSingleLogicConfig.getValue(),
               dgModelSingleLogicConfig.getParamName()
            );
            if (StringHelper.IsNullOrEmpty(strSQL)) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法获取条件语句"));
               log.error(callResult.getErrorInfo());
               return callResult;
            } else {
               callResult.setUserObject(strSQL);
               callResult.setRetCode(0);
               return callResult;
            }
         }
      }
   }

   protected CallResult GetCustomCondition(
      IDEHelper iDEHelper, String strParentDER, DGModelCustomLogicConfig dgModelCustomLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList
   ) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(0);
      if (iDEHelper == null) {
         callResult.setRetCode(1);
         callResult.setErrorInfo("没有指定实体辅助对象");
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      String strCondition = dgModelCustomLogicConfig.getCondition();
      if (StringHelper.IsNullOrEmpty(strCondition)) {
         callResult.setRetCode(1);
         callResult.setErrorInfo("没有指定自定义逻辑");
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      DAQueryModelAlias qmAlias = new DAQueryModelAlias();
      qmAlias.setIDEHelper(iDEHelper);
      qmAlias.setParentDER(strParentDER);
      qmAlias.setDERAliasMap(derAliasMap);
      qmAlias.setDERList(derList);
      this.qmAliasMap.put("CUR".toUpperCase(), qmAlias);
      if (strCondition.indexOf("qm.") == -1 && StringHelper.Compare(strCondition, "\"1=1\"", true) != 0) {
         if (strCondition.indexOf("${") == -1) {
            String strTemp = strCondition.trim();
            if (!StringHelper.IsNullOrEmpty(strTemp) && (strTemp.charAt(0) == '"' || strTemp.charAt(0) == '\'')) {
               return this.grooveEngine.GetCustomCondition(strCondition);
            }
         }

         Configuration config = new Configuration();
         StrTemplateLoader deTemplateLoader = new StrTemplateLoader(strCondition);
         config.setTemplateLoader(deTemplateLoader);

         try {
            Template template = config.getTemplate("STRING");
            StringWriter sw = new StringWriter();
            template.process(this.macroParams, sw);
            callResult.setUserObject(sw.toString());
            return callResult;
         } catch (IOException e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            return callResult;
         } catch (TemplateException e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            return callResult;
         }
      } else {
         return this.grooveEngine.GetCustomCondition(strCondition);
      }
   }

   protected CallResult GetJoin(
      StringBuilderEx script, IDEHelper iDEHelper, String strParentDERs, String strDER, TreeMap<String, Integer> derAliasMap, TreeMap<String, Integer> joinMap
   ) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      if (StringHelper.IsNullOrEmpty(strDER)) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法指定连接关系"));
         log.error(callResult.getErrorInfo());
         return callResult;
      }

      String[] strDERs = strDER.split("[|]");
      String strCurDERId = strDERs[0];
      String strCurTotalDER = strParentDERs;
      if (!StringHelper.IsNullOrEmpty(strCurTotalDER)) {
         strCurTotalDER = strCurTotalDER + "|";
      }

      strCurTotalDER = strCurTotalDER + strCurDERId;
      IDEHelper iNextDEHelper = null;
      DERCUSTOM derCustom = iDEHelper.FindDERCUSTOM(false, strCurDERId);
      if (derCustom != null) {
         if (!joinMap.containsKey(strCurTotalDER)) {
            String strPreFix = "t";
            iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derCustom.getMAJORDEID());
            if (iNextDEHelper == null) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]辅助对象", derCustom.getMAJORDEID()));
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty(strParentDERs)) {
               strMTAlias = strPreFix + "1";
               strUTAlias = strPreFix + "2";
            } else {
               if (!derAliasMap.containsKey(strParentDERs)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               Integer nAlias = derAliasMap.get(strParentDERs);
               strMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
               strUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
            }

            String strCurMTAlias = "";
            String strCurUTAlias = "";
            if (!derAliasMap.containsKey(strCurTotalDER)) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
               log.error(callResult.getErrorInfo());
               return callResult;
            }

            Integer nAlias = derAliasMap.get(strCurTotalDER);
            strCurMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
            strCurUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
            String strMainTable = iNextDEHelper.GetMainTable();
            String strUserTable = iNextDEHelper.GetUserTable();
            String strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            if (StringHelper.Compare(iNextDEHelper.GetDBStorage(), iDEHelper.GetDBStorage(), true) != 0) {
               strMainTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strMainTable);
               strUserTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strUserTable);
            }

            String strCustomJoin = derCustom.getJOINCOND().replace("%%SRFMAJOR%%", strCurMTAlias);
            strCustomJoin = strCustomJoin.replace("%%SRFMINOR%%", strMTAlias);
            script.Append("LEFT JOIN %1$s %2$s ON %3$s \n", strMainTable2, strCurMTAlias, strCustomJoin);
            if (!StringHelper.IsNullOrEmpty(strUserTable)) {
               IDEFHelper pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
               script.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n",
                  strUserTable2,
                  strCurUTAlias,
                  strCurMTAlias,
                  pkeyDEFHelper.GetDTColumn().GetFormalColumnName()
               );
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
            callResult.setRetCode(0);
            return callResult;
         } else {
            return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
         }
      } else {
         IDEFHelper joinDEFHelper = null;
         boolean bInheritMode = false;
         boolean bRightJoin = false;
         if (strCurDERId.indexOf("N1R:") == 0) {
            bRightJoin = true;
         }

         for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsLinkDEField() && iDEFHelper instanceof ILinkDEFHelper) {
               ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
               if (StringHelper.Compare(linkDEFHelper.GetDERId(), strCurDERId, true) == 0
                  || bRightJoin && StringHelper.Compare(linkDEFHelper.GetDERId(), strCurDERId.substring(4), true) == 0) {
                  if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUP", true) == 0) {
                     joinDEFHelper = iDEFHelper;
                     break;
                  }

                  if (StringHelper.Compare(iDEFHelper.GetDataType(), "INHERIT", true) == 0) {
                     bInheritMode = true;
                     iNextDEHelper = linkDEFHelper.GetRelatedDEFHelper().getDEHelper();
                     break;
                  }
               }
            }
         }

         if (bInheritMode) {
            if (!joinMap.containsKey(strCurTotalDER)) {
               String strPreFix = "t";
               String strMTAlias = "";
               String strUTAlias = "";
               if (StringHelper.IsNullOrEmpty(strParentDERs)) {
                  strMTAlias = strPreFix + "1";
                  strUTAlias = strPreFix + "2";
               } else {
                  if (!derAliasMap.containsKey(strParentDERs)) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  Integer nAlias = derAliasMap.get(strParentDERs);
                  strMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
                  strUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
               }

               String strCurMTAlias = "";
               String strCurUTAlias = "";
               if (!derAliasMap.containsKey(strCurTotalDER)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               Integer nAlias = derAliasMap.get(strCurTotalDER);
               strCurMTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 1);
               strCurUTAlias = StringHelper.Format("%1$s%2$s", strPreFix, nAlias + 2);
               boolean bJoinAsMain = true;
               IDEFHelper iKeyDEFHelper = iDEHelper.GetKeyDEFHelper();
               if (StringHelper.Compare(iKeyDEFHelper.GetDTColumn().GetTableName(), iDEHelper.getDataEntity().getTABLENAME(), true) == 0) {
                  bJoinAsMain = true;
               } else {
                  bJoinAsMain = false;
               }

               String strMainTable = iNextDEHelper.GetMainTable();
               String strUserTable = iNextDEHelper.GetUserTable();
               String strMainTable2 = strMainTable;
               String strUserTable2 = strUserTable;
               if (StringHelper.Compare(iNextDEHelper.GetDBStorage(), this.iMajorDEHelper.GetDBStorage(), true) != 0) {
                  strMainTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strMainTable);
                  strUserTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strUserTable);
               }

               script.Append(
                  "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n",
                  strMainTable2,
                  strCurMTAlias,
                  bJoinAsMain ? strMTAlias : strUTAlias,
                  iKeyDEFHelper.GetDTColumn().GetFormalColumnName(),
                  iNextDEHelper.GetKeyDEFHelper().GetDTColumn().GetFormalColumnName()
               );
               if (!StringHelper.IsNullOrEmpty(strUserTable)) {
                  IDEFHelper pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                  script.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n",
                     strUserTable2,
                     strCurUTAlias,
                     strCurMTAlias,
                     pkeyDEFHelper.GetDTColumn().GetFormalColumnName()
                  );
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
               callResult.setRetCode(0);
               return callResult;
            } else {
               return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
            }
         } else {
            boolean bLeftOuterJoin = false;
            IDEFHelper joinRelatedDEFHelper = null;
            if (joinDEFHelper == null) {
               String strTempCurDERId = "";
               if (strCurDERId.indexOf("1NLO:") == 0) {
                  strTempCurDERId = strCurDERId.substring(5);
                  DER1N der1N = new DER1N();
                  callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strTempCurDERId, der1N);
                  if (callResult.getRetCode() != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strTempCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  if (StringHelper.Compare(iDEHelper.getId(), der1N.getMAJORDEID(), true) != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strTempCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
                  if (iNextDEHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", der1N.getMINORDEID()));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  for (IDEFHelper iDEFHelper : iNextDEHelper.GetDEFHelpers()) {
                     if (iDEFHelper.IsLinkDEField() && iDEFHelper instanceof ILinkDEFHelper) {
                        ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        if (StringHelper.Compare(linkDEFHelper.GetDERId(), strTempCurDERId, true) == 0
                           && StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUP", true) == 0) {
                           joinRelatedDEFHelper = iDEFHelper;
                           joinDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
                           break;
                        }
                     }
                  }

                  if (joinRelatedDEFHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iNextDEHelper.GetFullName(), strCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  bLeftOuterJoin = true;
               } else if (strCurDERId.indexOf("11M:") == 0) {
                  strTempCurDERId = strCurDERId.substring(4);
                  DER11 der11 = new DER11();
                  callResult = this.globalHelperEx.getDAModelHelper().GetDER11(strTempCurDERId, der11);
                  if (callResult.getRetCode() != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strTempCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  if (StringHelper.Compare(iDEHelper.getId(), der11.getMAJORDEID(), true) != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strTempCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                  if (iNextDEHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", der11.getMINORDEID()));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  for (IDEFHelper iDEFHelper : iNextDEHelper.GetDEFHelpers()) {
                     if (iDEFHelper.IsLinkDEField() && iDEFHelper instanceof ILinkDEFHelper) {
                        ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        if (StringHelper.Compare(linkDEFHelper.GetDERId(), strTempCurDERId, true) == 0
                           && StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUP", true) == 0) {
                           joinRelatedDEFHelper = iDEFHelper;
                           joinDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
                           break;
                        }
                     }
                  }

                  if (joinRelatedDEFHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iNextDEHelper.GetFullName(), strCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }
               } else {
                  if (strCurDERId.indexOf("INDEX:") != 0 && strCurDERId.indexOf("INDEXM:") != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
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

                  DERINDEX derIndex = new DERINDEX();
                  callResult = this.globalHelperEx.getDAModelHelper().GetDERINDEX(strTempCurDERId, derIndex);
                  if (callResult.getRetCode() != 0) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]关系[%2$s]的连接属性", iDEHelper.GetFullName(), strTempCurDERId));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  if (bIndexM) {
                     iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derIndex.getDEID());
                  } else {
                     iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
                  }

                  if (iNextDEHelper == null) {
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到实体[%1$s]辅助操作对象", bIndexM ? derIndex.getDEID() : derIndex.getINDEXDEID()));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  joinRelatedDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                  joinDEFHelper = iDEHelper.GetKeyDEFHelper();
               }
            } else {
               if (joinDEFHelper instanceof ILinkDEFHelper) {
                  joinRelatedDEFHelper = ((ILinkDEFHelper)joinDEFHelper).GetRelatedDEFHelper();
               }

               if (joinRelatedDEFHelper == null) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法找到属性[%1$s]关联属性", joinDEFHelper.GetFullName()));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               iNextDEHelper = joinRelatedDEFHelper.getDEHelper();
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
                     callResult.setRetCode(1);
                     callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
                     log.error(callResult.getErrorInfo());
                     return callResult;
                  }

                  Integer nAlias = derAliasMap.get(strParentDERs);
                  strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
                  strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
               }

               String strCurMTAlias = "";
               String strCurUTAlias = "";
               if (!derAliasMap.containsKey(strCurTotalDER)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDERs));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               Integer nAlias = derAliasMap.get(strCurTotalDER);
               strCurMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
               strCurUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
               boolean bJoinAsMain = true;
               if (StringHelper.Compare(joinDEFHelper.GetDTColumn().GetTableName(), iDEHelper.GetMainTable(), true) == 0) {
                  bJoinAsMain = true;
               } else {
                  bJoinAsMain = false;
               }

               String strMainTable = iNextDEHelper.GetMainTable();
               String strUserTable = iNextDEHelper.GetUserTable();
               String strMainTable2 = strMainTable;
               String strUserTable2 = strUserTable;
               if (StringHelper.Compare(iNextDEHelper.GetDBStorage(), this.iMajorDEHelper.GetDBStorage(), true) != 0) {
                  strMainTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strMainTable);
                  strUserTable2 = StringHelper.Format("%1$s.%2$s", iNextDEHelper.GetDBSchema(), strUserTable);
               }

               if (bLeftOuterJoin) {
                  script.Append(
                     "LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n",
                     strMainTable2,
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     joinDEFHelper.GetDTColumn().GetFormalColumnName(),
                     joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName()
                  );
               } else if (bRightJoin) {
                  script.Append(
                     "RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n",
                     strMainTable2,
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     joinDEFHelper.GetDTColumn().GetFormalColumnName(),
                     joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName()
                  );
               } else {
                  script.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n",
                     strMainTable2,
                     strCurMTAlias,
                     bJoinAsMain ? strMTAlias : strUTAlias,
                     joinDEFHelper.GetDTColumn().GetFormalColumnName(),
                     joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName()
                  );
               }

               if (!StringHelper.IsNullOrEmpty(strUserTable)) {
                  IDEFHelper pkeyDEFHelper = null;
                  if (joinRelatedDEFHelper.GetDTColumn().IsPKey()) {
                     pkeyDEFHelper = joinRelatedDEFHelper;
                  } else {
                     pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                  }

                  script.Append(
                     "LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n",
                     strUserTable2,
                     strCurUTAlias,
                     strCurMTAlias,
                     pkeyDEFHelper.GetDTColumn().GetFormalColumnName()
                  );
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
               callResult.setRetCode(0);
               return callResult;
            } else {
               return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
            }
         }
      }
   }

   protected CallResult GetDEFieldExp(IDEFHelper iDEFHelper, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
      IDEHelper iDEHelper = iDEFHelper.getDEHelper();
      IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
      if (iDEFDTColumn.IsFormula() && !iDEFHelper.IsFormulaPhisical()) {
         String strFormulaFields = iDEFDTColumn.GetFormulaColumns();
         if (!StringHelper.IsNullOrEmpty(strFormulaFields)) {
            Object[] params = null;
            String[] strFields = strFormulaFields.split("[;]");
            params = new Object[strFields.length];

            for (int i = 0; i < strFields.length; i++) {
               String strDEFName = strFields[i].toUpperCase();
               IDEFHelper argvField = iDEFHelper.getDEHelper().GetDEFHelper(strDEFName);
               if (argvField == null) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("逻辑属性参数[%1$s]无效", strDEFName));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               callResult = this.GetDEFieldExp(argvField, strParentDER, derAliasMap, derList);
               if (callResult.getRetCode() != 0) {
                  return callResult;
               }

               params[i] = callResult.getUserObject();
            }

            String strExp = StringHelper.Format(iDEFDTColumn.GetFormulaFormat(), params);
            callResult.setRetCode(0);
            callResult.setUserObject(strExp);
            return callResult;
         } else {
            String strExp = StringHelper.Format(iDEFDTColumn.GetFormulaFormat());
            callResult.setRetCode(0);
            callResult.setUserObject(strExp);
            this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
            return callResult;
         }
      } else {
         String strDERID = "";
         if (iDEFHelper instanceof ILinkDEFHelper) {
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            strDERID = linkDEFHelper.GetDERId();
         }

         if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUP", true) == 0) {
            strDERID = "";
         } else if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPTEXT", true) == 0 && iDEFHelper.getDEField().getDEFTYPE() == 1) {
            strDERID = "";
         }

         if (StringHelper.IsNullOrEmpty(strDERID)) {
            boolean bDynamicTable = false;
            String strMainTable = iDEHelper.GetMainTable();
            String strUserTable = iDEHelper.GetUserTable();
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty(strParentDER)) {
               int nAlias = derAliasMap.get("");
               strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
               strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
               bDynamicTable = StringHelper.Compare(iDEHelper.getDataEntity().getSTORAGETYPE(), "DYNAMIC", true) == 0;
            } else {
               if (!derAliasMap.containsKey(strParentDER)) {
                  callResult.setRetCode(1);
                  callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDER));
                  log.error(callResult.getErrorInfo());
                  return callResult;
               }

               Integer nAlias = derAliasMap.get(strParentDER);
               strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
               strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
            }

            String strDEFTableName = iDEFDTColumn.GetTableName();
            if (bDynamicTable || StringHelper.Compare(strMainTable, strDEFTableName, true) == 0) {
               String strExp = StringHelper.Format("%1$s.%2$s", strMTAlias, iDEFDTColumn.GetFormalColumnName());
               callResult.setRetCode(0);
               callResult.setUserObject(strExp);
               this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
               return callResult;
            } else if (StringHelper.Compare(strUserTable, strDEFTableName, true) == 0) {
               String strExp = StringHelper.Format("%1$s.%2$s", strUTAlias, iDEFDTColumn.GetFormalColumnName());
               callResult.setRetCode(0);
               callResult.setUserObject(strExp);
               this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
               return callResult;
            } else {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法识别的属性[%1$s]表名[%2$s]", iDEFHelper.GetFullName(), strDEFTableName));
               log.error(callResult.getErrorInfo());
               return callResult;
            }
         } else {
            String strNewDER = strParentDER;
            if (!StringHelper.IsNullOrEmpty(strNewDER)) {
               strNewDER = strNewDER + "|";
            }

            strNewDER = strNewDER + strDERID;
            IDEFHelper relatedDEFHelper = null;
            if (iDEFHelper instanceof ILinkDEFHelper) {
               relatedDEFHelper = ((ILinkDEFHelper)iDEFHelper).GetRelatedDEFHelper();
            }

            if (relatedDEFHelper == null) {
               callResult.setRetCode(1);
               callResult.setErrorInfo(StringHelper.Format("无法获取属性[%1$s]的关系属性", iDEFHelper.GetFullName()));
               log.error(callResult.getErrorInfo());
               return callResult;
            }

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

            return this.GetDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList);
         }
      }
   }

   protected CallResult GetTableAlias(IDEHelper iDEHelper, boolean bMain, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
      CallResult callResult = new CallResult();
      callResult.setRetCode(1);
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
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法找到关系[%1$s]别名", strParentDER));
            log.error(callResult.getErrorInfo());
            return callResult;
         }

         strMTAlias = StringHelper.Format("t%1$s", nAlias + 1);
         strUTAlias = StringHelper.Format("t%1$s", nAlias + 2);
      }

      String strExp = bMain ? strMTAlias : strUTAlias;
      callResult.setRetCode(0);
      callResult.setUserObject(strExp);
      return callResult;
   }

   protected String GetConditionSQL(String strFieldName, String strDataType, String strCondition, String strValue, String strParamName) {
      if (StringHelper.Compare(strCondition, "TESTNULL", true) == 0) {
         return StringHelper.Compare(strValue, "1", true) == 0
            ? StringHelper.Format("%1$s IS NULL", strFieldName)
            : StringHelper.Format("%1$s IS NOT NULL", strFieldName);
      }

      if (StringHelper.Compare(strCondition, "ISNULL", true) == 0) {
         return StringHelper.Format("%1$s IS NULL", strFieldName);
      }

      if (StringHelper.Compare(strCondition, "ISNOTNULL", true) == 0) {
         return StringHelper.Format("%1$s IS NOT NULL", strFieldName);
      }

      if (!StringHelper.IsNullOrEmpty(strParamName) && MacroHelper.isSRFFunc(strParamName)) {
         Vector<String> argList = new Vector<>();
         String strFuncName = MacroHelper.ParseSRFFunc(strParamName, argList);
         if (StringHelper.Compare(strFuncName, "SRFUVEX", true) == 0) {
            if (argList.size() == 0) {
               log.error(StringHelper.Format("无法失败扩展URL参数[%1$s]", strParamName));
               return "";
            }

            String strMacroIndex = StringHelper.Format("_MACRO_%1$s_", this.nMacroIndex);
            this.nMacroIndex++;
            BaseDAQueryModelHelper.URLCondPair urlCondPair = new BaseDAQueryModelHelper.URLCondPair();
            urlCondPair.strFieldName = strFieldName;
            urlCondPair.strDataType = strDataType;
            urlCondPair.strCondition = strCondition;
            urlCondPair.strURLParam = argList.get(0);
            urlCondPair.strMacro = strMacroIndex;
            if (argList.size() >= 2) {
               urlCondPair.bAll = StringHelper.Compare(argList.get(1), "ALL", true) == 0;
            }

            this.urlCondPairList.add(urlCondPair);
            return strMacroIndex;
         }
      }

      int nDataType = DataTypeHelper.FromString(strDataType);
      if (DataTypeHelper.IsStringType(nDataType)) {
         return this.GetStringConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else if (DataTypeHelper.IsIntType(nDataType)) {
         return this.GetIntConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else if (DataTypeHelper.IsDoubleType(nDataType)) {
         return this.GetDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
      } else {
         return DataTypeHelper.IsDateTimeType(nDataType) ? this.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName) : "";
      }
   }

   public String GetStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
      return this.GetStringConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String GetStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
      if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
         strValue = strValue.replace("'", "''");
         return StringHelper.Format("%1$s = '%2$s'", strFieldName, strValue);
      } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
         strValue = strValue.replace("'", "''");
         return StringHelper.Format("%1$s <> '%2$s'", strFieldName, strValue);
      } else if (StringHelper.Compare(strCondition, "LIKE", true) == 0) {
         strValue = strValue.replace("'", "''");
         strValue = "%" + strValue + "%";
         return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
      } else if (StringHelper.Compare(strCondition, "LEFTLIKE", true) == 0) {
         strValue = strValue.replace("'", "''");
         strValue = strValue + "%";
         return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
      } else if (StringHelper.Compare(strCondition, "RIGHTLIKE", true) == 0) {
         strValue = strValue.replace("'", "''");
         strValue = "%" + strValue;
         return StringHelper.Format("%1$s LIKE '%2$s'", strFieldName, strValue);
      } else {
         return "";
      }
   }

   public String GetIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
      return this.GetIntConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String GetIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
      Object objValue = null;
      if (StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
         objValue = DataTypeParse.TestBigInt(strValue);
         if (objValue == null) {
            log.error(StringHelper.Format("值[%1$s]非整数值", strValue));
            return "";
         }
      }

      if (StringHelper.IsNullOrEmpty(strParamName)) {
         if (StringHelper.Compare(strCondition, "=", true) != 0 && StringHelper.Compare(strCondition, "==", true) != 0) {
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

            if (StringHelper.IsNullOrEmpty(strValue)) {
               return StringHelper.Compare(strCondition, "IN", true) == 0 ? "1<>1" : "1=1";
            }

            String[] items = strValue.split("[;]");
            String strSQL = "";
            if (StringHelper.Compare(strCondition, "IN", true) == 0) {
               strSQL = StringHelper.Format("%1$s IN (", strFieldName);
            } else {
               strSQL = StringHelper.Format("%1$s NOT IN (", strFieldName);
            }

            for (int i = 0; i < items.length; i++) {
               if (i != 0) {
                  strSQL = strSQL + ",";
               }

               strSQL = strSQL + StringHelper.Format("%1$s", items[i]);
            }

            return strSQL + ")";
         } else {
            return StringHelper.Format("%1$s = %2$s", strFieldName, strValue);
         }
      } else {
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
      }
   }

   public String GetDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
      return this.GetDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String GetDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
      Object objValue = DataTypeParse.TestDouble(strValue);
      if (objValue == null && StringHelper.Compare(strCondition, "IN", true) != 0 && StringHelper.Compare(strCondition, "NOTIN", true) != 0) {
         log.error(StringHelper.Format("值[%1$s]非浮点值", strValue));
         return "";
      }

      if (StringHelper.IsNullOrEmpty(strParamName)) {
         if (StringHelper.Compare(strCondition, "=", true) == 0 || StringHelper.Compare(strCondition, "==", true) == 0) {
            return StringHelper.Format("%1$s = %2$s", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<>", true) == 0) {
            return StringHelper.Format("%1$s <> %2$s", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">", true) == 0) {
            return StringHelper.Format("%1$s > %2$s", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, ">=", true) == 0) {
            return StringHelper.Format("%1$s >= %2$s", strFieldName, strValue);
         } else if (StringHelper.Compare(strCondition, "<", true) == 0) {
            return StringHelper.Format("%1$s < %2$s", strFieldName, strValue);
         } else {
            return StringHelper.Compare(strCondition, "<=", true) == 0 ? StringHelper.Format("%1$s <= %2$s", strFieldName, strValue) : "";
         }
      } else {
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
      }
   }

   public String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
      return this.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
   }

   protected String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
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

   public String getDAQueryModelHelperId() {
      return this.strDAQueryModelHelperId;
   }

   public void setDAQueryModelHelperId(String strDAQueryModelHelperId) {
      this.strDAQueryModelHelperId = strDAQueryModelHelperId;
   }

   public String GetConditionSQL(IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig, String strValue) {
      return this.GetConditionSQL(null, iDEFHelper, searchItemConfig, strValue);
   }

   public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig, String strValue) {
      String strDEFName = iDEFHelper.getName();
      if (!this.fieldExpMap.containsKey(strDEFName)) {
         log.warn(StringHelper.Format("无法获取属性[%1$s]对应的表达式", strDEFName));
         return "";
      }

      if (!this.fieldDataTypeMap.containsKey(strDEFName)) {
         log.warn(StringHelper.Format("无法获取属性[%1$s]对应的数据类型", strDEFName));
         return "";
      }

      if (StringHelper.IsNullOrEmpty(searchItemConfig.getFunc())) {
         if (iDEFHelper.getEncryptStorage() == 1 && !StringHelper.IsNullOrEmpty(strValue)) {
            strValue = EncryptHelper.encode2(strValue);
         }

         IDEFQueryHelper iDEFQueryHelper = iDEFHelper.GetQueryHelper();
         return iDEFQueryHelper != null
            ? iDEFQueryHelper.GetConditionSQL(iQMUserContext, this, this.fieldExpMap.get(strDEFName), searchItemConfig.getAction(), strValue, "")
            : this.GetConditionSQL(this.fieldExpMap.get(strDEFName), this.fieldDataTypeMap.get(strDEFName), searchItemConfig.getAction(), strValue, "");
      } else {
         IDAValueFunc iDAValueFunc = this.globalHelperEx
            .getDAConfigMgr()
            .getValueFuncMgr()
            .FindFunc(searchItemConfig.getFunc(), this.GetDBType(), iDEFHelper.GetStdDataType());
         if (iDAValueFunc == null) {
            log.error(StringHelper.Format("无法找到的值处理函数[%1$s]", searchItemConfig.getFunc()));
            return "";
         } else {
            String strFuncFormat = StringHelper.Format(iDAValueFunc.GetFuncFormat(), this.fieldExpMap.get(strDEFName));
            return this.GetConditionSQL(strFuncFormat, iDAValueFunc.GetDataType(), searchItemConfig.getAction(), strValue, "");
         }
      }
   }

   public String GetConditionSQL(IDEFHelper iDEFHelper, String strFunc, String strAction, String strValue) {
      return this.GetConditionSQL(null, iDEFHelper, strFunc, strAction, strValue);
   }

   public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, IDEFHelper iDEFHelper, String strFunc, String strAction, String strValue) {
      String strDEFName = iDEFHelper.getName();
      if (!this.fieldExpMap.containsKey(strDEFName)) {
         return "";
      }

      if (!this.fieldDataTypeMap.containsKey(strDEFName)) {
         return "";
      }

      if (StringHelper.IsNullOrEmpty(strFunc)) {
         if (iDEFHelper.getEncryptStorage() == 1 && !StringHelper.IsNullOrEmpty(strValue)) {
            strValue = EncryptHelper.encode2(strValue);
         }

         IDEFQueryHelper iDEFQueryHelper = iDEFHelper.GetQueryHelper();
         return iDEFQueryHelper != null
            ? iDEFQueryHelper.GetConditionSQL(iQMUserContext, this, this.fieldExpMap.get(strDEFName), strAction, strValue, "")
            : this.GetConditionSQL(this.fieldExpMap.get(strDEFName), this.fieldDataTypeMap.get(strDEFName), strAction, strValue, "");
      } else {
         return "";
      }
   }

   public String GetCountSQL(String strSQL) {
      return "";
   }

   public String GetPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
      return "";
   }

   public String GetPagingSQL(
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
         ? this.GetPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection)
         : this.GetPagingSQL(strSQL, nStartPos, nPageSize, strGroup, strGroupDir, strMajor, strMajorDirection);
   }

   public String GetSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
      return "";
   }

   public String GetSortSQL(boolean bSubQuery, String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
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
         return this.GetSortSQL(strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
      }
   }

   private final int getAliasIndex() {
      this.nAliasIndex += 10;
      return this.nAliasIndex;
   }

   protected int getAliasIndex2() {
      this.nAliasIndex += 10;
      return this.nAliasIndex;
   }

   public IDEHelper GetMajorDEHelper() {
      return this.iMajorDEHelper;
   }

   public String GetGroupSQL(
      String strSQL,
      QueryGroupModelConfig queryGroupModelConfig,
      Vector<CallParam> list,
      ISRFDAWebContext webContext,
      ISRFDAGlobalHelper globalHelperEx,
      String strCurPersonId,
      BaseDataEntity baseDataEntity
   ) {
      if (StringHelper.IsNullOrEmpty(strSQL)) {
         strSQL = this.GetQueryModelScript(null);
      }

      if (StringHelper.IsNullOrEmpty(strSQL)) {
         log.error(StringHelper.Format("主查询语句无效"));
         return "";
      }

      StringBuilderEx sqlGroup = new StringBuilderEx();
      IDEHelper majorDEHelper = this.GetMajorDEHelper();
      sqlGroup.Append("SELECT ");
      boolean bFirst = true;
      int nAliasIndex = 0;
      TreeMap<Integer, String> orderMap = new TreeMap<>();
      Vector<String> groupFields = new Vector<>();
      Vector<QueryGroupItemConfig> recalcItems = new Vector<>();

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
                     IDEFHelper defHelper = majorDEHelper.GetDEFHelper(strDEField);
                     if (defHelper == null) {
                        if (StringHelper.IsNullOrEmpty(strAlias)) {
                           strAlias = fields[0];
                        }

                        fieldCodes[0] = strDEField;
                     } else {
                        if (StringHelper.IsNullOrEmpty(strAlias)) {
                           strAlias = fields[0];
                        }

                        String strRealCode = this.GetDEFieldStatisticsNullConvertCode(defHelper);
                        fieldCodes[0] = strRealCode;
                     }
                  } else {
                     for (int i = 0; i < fields.length; i++) {
                        String strDEField = fields[i];
                        IDEFHelper defHelper = majorDEHelper.GetDEFHelper(strDEField);
                        if (defHelper == null) {
                           fieldCodes[i] = strDEField;
                        } else {
                           String strRealCode = this.GetDEFieldStatisticsNullConvertCode(defHelper);
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
                     CallResult callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
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

      return queryGroupModelConfig.getTopCount() == 0 ? strGroupSql : this.GetFetchTopRowSQL(strGroupSql, queryGroupModelConfig.getTopCount());
   }

   public String GetFetchTopRowSQL(String strSQL, int nTopCount) {
      return strSQL;
   }

   protected String GetDEFieldStatisticsNullConvertCode(IDEFHelper defHelper) {
      String strStaNullConv = defHelper.GetDTColumn().GetStatisticsNullConvert();
      return !StringHelper.IsNullOrEmpty(strStaNullConv)
         ? StringHelper.Format("(CASE WHEN %1$s IS NULL THEN %2$s ELSE %1$s END)", defHelper.GetDTColumn().GetFormalColumnName(), strStaNullConv)
         : defHelper.getName();
   }

   public DAQueryModelAlias FindQMAlias(String strAlias) {
      return this.qmAliasMap.get(strAlias.toUpperCase());
   }

   public void RegisterCallParam(String strParamName, Object objValue) {
      CallParam callParam = new CallParam();
      callParam.setParamName(strParamName);
      callParam.setValue(objValue);
      this.callParams.add(callParam);
   }

   @Override
   public void RegisterQMDeclare(String strDeclareName, QueryModelDeclare qmDeclare) {
      strDeclareName = strDeclareName.toUpperCase();
      this.qmDeclareMap.put(strDeclareName, qmDeclare);
   }

   @Override
   public boolean isContainsQMDeclare(String strDeclareName) {
      strDeclareName = strDeclareName.toUpperCase();
      return this.qmDeclareMap.containsKey(strDeclareName);
   }

   @Override
   public String GetQMDeclareScript() {
      String strQMDeclareScript = "";

      for (String strName : this.qmDeclareMap.keySet()) {
         QueryModelDeclare qmDeclare = this.qmDeclareMap.get(strName);
         strQMDeclareScript = strQMDeclareScript + qmDeclare.getDeclareCode();
         strQMDeclareScript = strQMDeclareScript + "\n";
      }

      return strQMDeclareScript;
   }

   public static void AppendConditionSQL(StringBuilderEx script, Vector<String> userConditions) {
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

   public void SetFieldQueryCaseSensitive(String strField, String strValue) {
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

   public String GetDBType() {
      return "";
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
      return this.globalHelperEx;
   }

   class URLCondPair {
      public String strFieldName;
      public String strDataType;
      public String strCondition;
      public String strMacro;
      public String strURLParam;
      public boolean bAll = true;
   }
}
