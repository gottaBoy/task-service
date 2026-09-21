/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DAQueryModelAlias;
import SA.SRFDA.Ctrl.DAQueryModelGrooveEngine;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEHelper;
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
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDAQueryModelHelper
implements IDAQueryModelUserContext {
    public static final String QMVALUE_ISNULL = "__SRFQMVALUE_ISNULL__";
    public static final String QMVALUE_ISNOTNULL = "__SRFQMVALUE_ISNOTNULL__";
    protected IDEHelper iMajorDEHelper = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    protected Hashtable<String, String> fieldExpMap = new Hashtable();
    protected Hashtable<String, String> fieldDataTypeMap = new Hashtable();
    private static final Log log = LogFactory.getLog(BaseDAQueryModelHelper.class);
    protected String strQueryScript = "";
    protected String strQueryScriptWithCondition = "";
    protected Vector<CallParam> callParams = new Vector();
    protected String strDAQueryModelHelperId = "";
    private int nAliasIndex = 0;
    private Vector<String> majorDERList = null;
    private TreeMap<String, Integer> majorDERAliasMap = null;
    private Vector<String> majorConditionList = null;
    private DAQueryModelGrooveEngine grooveEngine = null;
    protected TreeMap<String, DAQueryModelAlias> qmAliasMap = new TreeMap();
    protected TreeMap<String, QueryModelDeclare> qmDeclareMap = new TreeMap();
    protected TreeMap<String, Integer> fieldCaseSensitiveMap = new TreeMap();
    public static final int QUERYCASESENSITIVE_EQ = 1;
    public static final int QUERYCASESENSITIVE_LIKE = 2;
    public static final int QUERYOPTION_LIKESPLIT = 4;
    public static final String TAG_DYNAMICTABLES = "__DYNAMICTABLES__";
    private int nMacroIndex = 1;
    protected Vector<URLCondPair> urlCondPairList = new Vector();
    protected Map<String, Object> macroParams = new TreeMap<String, Object>();
    protected HashMap<String, String> globalParamMap = new HashMap();
    protected HashMap<String, Object> attributeMap = new HashMap();

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
        String strValue = this.globalParamMap.get(strMacroParam);
        return strValue;
    }

    public CallResult Compile(DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, boolean bDPControl, Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs, Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs) {
        return this.CompileEx(mainQueryConfig, mainQueryConfig2, bDPControl, notQueryConfigs, orQueryConfigs, false);
    }

    public CallResult CompileEx(DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, boolean bDPControl, Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs, Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs, boolean bDelete) {
        String strGroupCondition;
        CallResult callResult = new CallResult();
        this.callParams.clear();
        Vector<String> mainConditionList = new Vector<String>();
        Vector<String> derList = new Vector<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        derAliasMap.put("", 0);
        this.fieldExpMap.clear();
        TreeMap<String, String> extSelects = new TreeMap<String, String>();
        StringBuilderEx script = new StringBuilderEx();
        String strSelectColumns = mainQueryConfig.getExtSelect();
        if (!StringHelper.IsNullOrEmpty((String)strSelectColumns)) {
            String strSelectColumns2;
            if (mainQueryConfig2 != null && !StringHelper.IsNullOrEmpty((String)(strSelectColumns2 = mainQueryConfig2.getExtSelect()))) {
                strSelectColumns = String.valueOf(strSelectColumns) + ";";
                strSelectColumns = String.valueOf(strSelectColumns) + strSelectColumns2;
            }
        } else if (mainQueryConfig2 != null) {
            strSelectColumns = mainQueryConfig2.getExtSelect();
        }
        TreeMap<String, Integer> selectColumns = null;
        boolean bSelectColumn = false;
        if (!StringHelper.IsNullOrEmpty((String)strSelectColumns)) {
            selectColumns = new TreeMap<String, Integer>();
            String[] columns = strSelectColumns.split("[;]");
            int i = 0;
            while (i < columns.length) {
                String strColumn = columns[i];
                if (!StringHelper.IsNullOrEmpty((String)(strColumn = strColumn.trim()))) {
                    selectColumns.put(strColumn.toUpperCase(), 1);
                }
                ++i;
            }
            bSelectColumn = selectColumns.size() > 0;
        }
        for (IDEFHelper iDEFHelper : this.iMajorDEHelper.GetDEFHelpers()) {
            String strDataType;
            IDEFDTColumn iDEFDTColumn;
            if (bSelectColumn && !selectColumns.containsKey(iDEFHelper.getName())) {
                if (!iDEFHelper.GetDTColumn().isViewColumn() || !iDEFHelper.IsPhisicalDEField() && !iDEFHelper.IsInheritDEField()) continue;
                callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                iDEFDTColumn = iDEFHelper.GetDTColumn();
                strDataType = iDEFHelper.GetStdDataType();
                if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.GetFullName()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                this.fieldDataTypeMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), strDataType);
                this.fieldExpMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), (String)callResult.getUserObject());
                continue;
            }
            if (!iDEFHelper.GetDTColumn().isViewColumn()) continue;
            callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u5bf9\u5e94\u7684\u8868\u8fbe\u5f0f", (Object)iDEFHelper.getName()));
                return callResult;
            }
            iDEFDTColumn = iDEFHelper.GetDTColumn();
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"TEXT", (boolean)false) == 0) {
                log.error((Object)StringHelper.Format((String)"\u957f\u6587\u672c\u5c5e\u6027[%1$s]\u653e\u5165\u67e5\u8be2\u4e2d\uff0c\u4f1a\u5f71\u54cd\u68c0\u7d22\u6027\u80fd", (Object)iDEFHelper.getName()));
            }
            extSelects.put(iDEFDTColumn.GetFormalColumnName().toUpperCase(), (String)callResult.getUserObject());
            strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            this.fieldDataTypeMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), strDataType);
            this.fieldExpMap.put(iDEFDTColumn.GetColumnName().toUpperCase(), (String)callResult.getUserObject());
        }
        IDEFHelper keyDEFHelper = this.iMajorDEHelper.GetKeyDEFHelper();
        if (keyDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)this.iMajorDEHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strMainTable = this.iMajorDEHelper.getDataEntity().getTABLENAME();
        String strUserTable = this.iMajorDEHelper.getDataEntity().getEXTABLENAME();
        boolean bDynamicTable = false;
        if (StringHelper.Compare((String)this.iMajorDEHelper.getDataEntity().getSTORAGETYPE(), (String)"DYNAMIC", (boolean)true) == 0) {
            bDynamicTable = true;
            script.Append("\nFROM %1$s t1 \n", (Object)TAG_DYNAMICTABLES);
        } else {
            script.Append("\nFROM %1$s t1 \n", (Object)strMainTable);
            if (!StringHelper.IsNullOrEmpty((String)strUserTable) && !bDelete) {
                script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", (Object)strUserTable, (Object)keyDEFHelper.GetDTColumn().GetFormalColumnName());
            }
        }
        DAQueryModelAlias qmAlias = new DAQueryModelAlias();
        qmAlias.setIDEHelper(this.iMajorDEHelper);
        qmAlias.setParentDER("");
        qmAlias.setDERAliasMap(derAliasMap);
        qmAlias.setDERList(derList);
        this.qmAliasMap.put("MAIN", qmAlias);
        if (!StringHelper.IsNullOrEmpty((String)mainQueryConfig.getAlias())) {
            this.qmAliasMap.put(mainQueryConfig.getAlias().toUpperCase(), qmAlias);
        }
        if (mainQueryConfig.getJoinQueriesConfig() != null) {
            Iterator<Vector<DGModelMainQueryConfig>> iterator = mainQueryConfig.getJoinQueriesConfig().iterator();
            while (iterator.hasNext()) {
                DGModelJoinQueryConfig joinQueryConfig = (DGModelJoinQueryConfig)((Object)iterator.next());
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11M", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (!(StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEX", (boolean)true) == 0 ? (callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, extSelects)).getRetCode() != 0 : StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEXM", (boolean)true) == 0 && (callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, extSelects)).getRetCode() != 0)) continue;
                return callResult;
            }
        }
        if (mainQueryConfig2 != null && mainQueryConfig2.getJoinQueriesConfig() != null) {
            if (!StringHelper.IsNullOrEmpty((String)mainQueryConfig2.getAlias())) {
                this.qmAliasMap.put(mainQueryConfig2.getAlias().toUpperCase(), qmAlias);
            }
            if ((callResult = this.Complie(mainQueryConfig2, this.iMajorDEHelper, derAliasMap, derList, mainConditionList, extSelects)).getRetCode() != 0) {
                return callResult;
            }
        }
        if (bDPControl) {
            if (notQueryConfigs != null) {
                for (Vector<DGModelMainQueryConfig> notList : notQueryConfigs) {
                    Object conditions;
                    Vector listconditions = new Vector();
                    for (DGModelMainQueryConfig queryConfig : notList) {
                        if (!StringHelper.IsNullOrEmpty((String)queryConfig.getAlias())) {
                            this.qmAliasMap.put(queryConfig.getAlias().toUpperCase(), qmAlias);
                        }
                        if ((callResult = this.Complie(queryConfig, this.iMajorDEHelper, derAliasMap, derList, (Vector<String>)(conditions = new Vector()), null)).getRetCode() != 0) {
                            return callResult;
                        }
                        if (queryConfig.getLogicConfig() != null) {
                            callResult = this.GetGroupCondition(this.iMajorDEHelper, "", queryConfig.getLogicConfig(), derAliasMap, derList);
                            if (callResult.getRetCode() != 0) {
                                return callResult;
                            }
                            String strGroupCondition2 = (String)callResult.getUserObject();
                            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition2)) {
                                ((Vector)conditions).add(strGroupCondition2);
                            }
                        }
                        if (((Vector)conditions).size() == 0) continue;
                        String strTotalCond = "";
                        Iterator iterator = ((Vector)conditions).iterator();
                        while (iterator.hasNext()) {
                            String strCond = (String)iterator.next();
                            if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                            if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                                strTotalCond = String.valueOf(strTotalCond) + " AND ";
                            }
                            strTotalCond = String.valueOf(strTotalCond) + strCond;
                        }
                        if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                        if (queryConfig.isExclude()) {
                            strTotalCond = "NOT " + strTotalCond;
                        }
                        listconditions.add(strTotalCond);
                    }
                    if (listconditions.size() == 0) continue;
                    String strTotalCond = "";
                    conditions = listconditions.iterator();
                    while (conditions.hasNext()) {
                        String strCond = (String)conditions.next();
                        if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                            strTotalCond = String.valueOf(strTotalCond) + " AND ";
                        }
                        strTotalCond = String.valueOf(strTotalCond) + strCond;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                    mainConditionList.add("NOT (" + strTotalCond + ")");
                }
            }
            String strOrTotalCond = "";
            if (orQueryConfigs != null) {
                for (Vector<DGModelMainQueryConfig> orList : orQueryConfigs) {
                    Vector<String> listconditions = new Vector<String>();
                    for (DGModelMainQueryConfig queryConfig : orList) {
                        Vector<String> conditions;
                        if (!StringHelper.IsNullOrEmpty((String)queryConfig.getAlias())) {
                            this.qmAliasMap.put(queryConfig.getAlias().toUpperCase(), qmAlias);
                        }
                        if ((callResult = this.Complie(queryConfig, this.iMajorDEHelper, derAliasMap, derList, conditions = new Vector<String>(), null)).getRetCode() != 0) {
                            return callResult;
                        }
                        if (queryConfig.getLogicConfig() != null) {
                            callResult = this.GetGroupCondition(this.iMajorDEHelper, "", queryConfig.getLogicConfig(), derAliasMap, derList);
                            if (callResult.getRetCode() != 0) {
                                return callResult;
                            }
                            String strGroupCondition3 = (String)callResult.getUserObject();
                            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition3)) {
                                conditions.add(strGroupCondition3);
                            }
                        }
                        if (conditions.size() == 0) continue;
                        String strTotalCond = "";
                        for (String strCond : conditions) {
                            if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                            if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                                strTotalCond = String.valueOf(strTotalCond) + " AND ";
                            }
                            strTotalCond = String.valueOf(strTotalCond) + strCond;
                        }
                        if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                        if (queryConfig.isExclude()) {
                            strTotalCond = "NOT" + strTotalCond;
                        }
                        listconditions.add(strTotalCond);
                    }
                    if (listconditions.size() == 0) continue;
                    String strTotalCond = "";
                    for (String strCond : listconditions) {
                        if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                            strTotalCond = String.valueOf(strTotalCond) + " AND ";
                        }
                        strTotalCond = String.valueOf(strTotalCond) + strCond;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                    if (!StringHelper.IsNullOrEmpty((String)strOrTotalCond)) {
                        strOrTotalCond = String.valueOf(strOrTotalCond) + " OR ";
                    }
                    strOrTotalCond = String.valueOf(strOrTotalCond) + "(" + strTotalCond + ")";
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strOrTotalCond)) {
                strOrTotalCond = "(1<>1)";
            }
            mainConditionList.add(strOrTotalCond);
        }
        if (this.iMajorDEHelper.IsLogicValid()) {
            IDEFHelper iDEFHelper = this.iMajorDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iDEFHelper != null) {
                mainConditionList.add(StringHelper.Format((String)"t1.%1$s = %2$s", (Object)iDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)this.iMajorDEHelper.GetProperty("VALIDVALUE")));
            } else {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)this.iMajorDEHelper.GetFullName()));
                callResult.setRetCode(1);
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        if (mainQueryConfig.getLogicConfig() != null) {
            callResult = this.GetGroupCondition(this.iMajorDEHelper, "", mainQueryConfig.getLogicConfig(), derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            strGroupCondition = (String)callResult.getUserObject();
            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition)) {
                mainConditionList.add(strGroupCondition);
            }
        }
        if (mainQueryConfig2 != null && mainQueryConfig2.getLogicConfig() != null) {
            callResult = this.GetGroupCondition(this.iMajorDEHelper, "", mainQueryConfig2.getLogicConfig(), derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            strGroupCondition = (String)callResult.getUserObject();
            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition)) {
                mainConditionList.add(strGroupCondition);
            }
        }
        TreeMap<String, Integer> joinMap = new TreeMap<String, Integer>();
        for (String strDERs : derList) {
            callResult = this.GetJoin(script, this.iMajorDEHelper, "", strDERs, derAliasMap, joinMap);
            if (callResult.getRetCode() == 0) continue;
            return callResult;
        }
        this.majorConditionList = mainConditionList;
        if (bDelete) {
            this.strQueryScript = "DELETE \n";
        } else {
            this.strQueryScript = "SELECT\n";
            if (mainQueryConfig.isDistinct()) {
                this.strQueryScript = String.valueOf(this.strQueryScript) + " DISTINCT\n";
            }
            boolean bFirst = true;
            for (String strColumnName : extSelects.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    this.strQueryScript = String.valueOf(this.strQueryScript) + ",\n";
                }
                String strField = extSelects.get(strColumnName);
                this.strQueryScript = String.valueOf(this.strQueryScript) + StringHelper.Format((String)"%1$s AS %2$s", (Object)strField, (Object)strColumnName);
            }
        }
        this.strQueryScript = String.valueOf(this.strQueryScript) + script.toString();
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

    private final CallResult Complie(DGModelMainQueryConfig mainQueryConfig, IDEHelper iDEHelper, TreeMap<String, Integer> derAliasMap, Vector<String> derList, Vector<String> conditionList, TreeMap<String, String> extSelects) {
        CallResult callResult = new CallResult();
        if (mainQueryConfig.getJoinQueriesConfig() == null) {
            return callResult;
        }
        Iterator iterator = mainQueryConfig.getJoinQueriesConfig().iterator();
        while (iterator.hasNext()) {
            DGModelJoinQueryConfig joinQueryConfig = (DGModelJoinQueryConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, false, false, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1RIGHT", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, false, false, true, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, true, false, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, true, false, false, false, false, false, false, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11M", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, true, false, false, false, false, false, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, true, false, false, false, false, extSelects);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1N", (boolean)true) == 0) {
                callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                conditionList.add((String)callResult.getUserObject());
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                conditionList.add((String)callResult.getUserObject());
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NNOT", (boolean)true) == 0) {
                callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, false);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                conditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                callResult = this.BuildExistQuery(this.iMajorDEHelper, joinQueryConfig, 0, true);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                conditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                continue;
            }
            if (!(StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEX", (boolean)true) == 0 ? (callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, true, false, false, false, extSelects)).getRetCode() != 0 : StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEXM", (boolean)true) == 0 && (callResult = this.BuildJoinQuery(this.iMajorDEHelper, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, true, false, false, extSelects)).getRetCode() != 0)) continue;
            return callResult;
        }
        return callResult;
    }

    public CallResult CompileRawCodeMode(String strQuerySQL, String strQueryCond, String strQueryParam, String strQueryField) {
        CallResult callResult = new CallResult();
        this.strQueryScript = strQuerySQL;
        if (!StringHelper.IsNullOrEmpty((String)strQueryCond)) {
            if (this.majorConditionList == null) {
                this.majorConditionList = new Vector();
            }
            this.majorConditionList.add(strQueryCond);
        }
        try {
            strQueryParam = strQueryParam.replace("\r\n", "\n");
            String[] params = strQueryParam.split("[\n]");
            int i = 0;
            while (i < params.length) {
                String strParam = params[i];
                if (!StringHelper.IsNullOrEmpty((String)(strParam = strParam.trim()))) {
                    CallParam callParam = new CallParam();
                    callParam.setParamName(strParam);
                    this.callParams.add(callParam);
                }
                ++i;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u67e5\u8be2\u53d8\u91cf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()));
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
        for (URLCondPair condPair : this.urlCondPairList) {
            String strCond;
            String strParamValue = webContext.GetParamValue(condPair.strURLParam);
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    public String ReplaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext, boolean bTestPost) {
        for (URLCondPair condPair : this.urlCondPairList) {
            String strCond;
            String strParamValue = webContext.GetParamValue(condPair.strURLParam);
            if (StringHelper.IsNullOrEmpty((String)strParamValue) && bTestPost) {
                strParamValue = webContext.GetPostValue(condPair.strURLParam.toLowerCase());
            }
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    public String ReplaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext) {
        return this.ReplaceURLParamMacro(strFinalScript, webContext, false);
    }

    public String ReplaceDynamicTableMacro(String strFinalScript, Vector<String> dynamicTables) {
        if (dynamicTables.size() == 0) {
            strFinalScript = strFinalScript.replace(TAG_DYNAMICTABLES, "\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u8868");
            return strFinalScript;
        }
        if (dynamicTables.size() == 1) {
            strFinalScript = strFinalScript.replace(TAG_DYNAMICTABLES, dynamicTables.get(0));
        } else {
            String strTables = "(";
            boolean bFirst = true;
            for (String strTableName : dynamicTables) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    strTables = String.valueOf(strTables) + " UNION ALL \n";
                }
                strTables = String.valueOf(strTables) + StringHelper.Format((String)"SELECT * FROM %1$s \n", (Object)strTableName);
            }
            strTables = String.valueOf(strTables) + ")";
            strFinalScript = strFinalScript.replace(TAG_DYNAMICTABLES, strTables);
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
            strSql = String.valueOf(strSql) + " WHERE \n";
            boolean bFirst = true;
            for (String strCondition : conditionList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    strSql = String.valueOf(strSql) + " AND ";
                }
                strSql = String.valueOf(strSql) + strCondition;
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
            strSql = String.valueOf(strSql) + " WHERE \n";
            boolean bFirst = true;
            for (String strCondition : conditionList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    strSql = String.valueOf(strSql) + " AND ";
                }
                strSql = String.valueOf(strSql) + strCondition;
            }
        }
        String strFinalScript = strSql;
        for (URLCondPair condPair : this.urlCondPairList) {
            String strCond;
            String strParamValue = webContext.GetParamValue(condPair.strURLParam);
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.GetConditionSQL(condPair.strFieldName, condPair.strDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    @Override
    public void FillQMDeclareParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId) {
        this.FillQMDeclareParams(list, webContext, globalHelperEx, strCurPersonId, null);
    }

    @Override
    public void FillQMDeclareParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity) {
        CallResult callResult = null;
        for (String strName : this.qmDeclareMap.keySet()) {
            QueryModelDeclare qmDeclare = this.qmDeclareMap.get(strName);
            for (CallParam callParam : qmDeclare.getParams()) {
                Object objValue;
                CallParam cp = callParam.Clone();
                callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
                if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                    cp.setValue(objValue);
                }
                list.add(cp);
            }
        }
    }

    public void FillCallParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity) {
        CallResult callResult = null;
        for (CallParam callParam : this.callParams) {
            Object objValue;
            CallParam cp = callParam.Clone();
            callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
            if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                cp.setValue(objValue);
            }
            list.add(cp);
        }
    }

    public void FillCallParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId) {
        this.FillCallParams(list, webContext, globalHelperEx, strCurPersonId, null);
    }

    public void FillMajorConditions(Vector<String> list) {
        if (this.majorConditionList == null) {
            return;
        }
        for (String strCondition : this.majorConditionList) {
            list.add(strCondition);
        }
    }

    private CallResult BuildJoinQuery(IDEHelper iDEHelper, DGModelJoinQueryConfig joinQueryConfig, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList, Vector<String> mainConditionList, boolean bN1, boolean b11, boolean b11M, boolean b1NLEFTOUTER, boolean bIndex, boolean bIndexM, boolean bCustom, boolean bN1RIGHT, TreeMap<String, String> extSelects) {
        String strExtSelect;
        String strNewDER;
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strDERID = joinQueryConfig.getDERID();
        String strMajorDEID = "";
        if (bN1 || b1NLEFTOUTER || bN1RIGHT) {
            BaseDataEntity der1N;
            if (bCustom) {
                der1N = new DERCUSTOM();
                callResult = this.globalHelperEx.getDAModelHelper().GetDERCUSTOM(strDERID, (DERCUSTOM)der1N);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)callResult.getErrorInfo());
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
                der1N = new DER1N();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strDERID, (DER1N)der1N);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)callResult.getErrorInfo());
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
                log.error((Object)callResult.getErrorInfo());
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
                log.error((Object)callResult.getErrorInfo());
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
        if (!StringHelper.IsNullOrEmpty((String)(strNewDER = strParentDER))) {
            strNewDER = String.valueOf(strNewDER) + "|";
        }
        if (!derAliasMap.containsKey(strNewDER = String.valueOf(strNewDER) + strDERID)) {
            derAliasMap.put(strNewDER, this.getAliasIndex());
            String strLastDERID = "";
            if (derList.size() > 0) {
                strLastDERID = derList.get(derList.size() - 1);
            }
            if (!(strNewDER.indexOf(strLastDERID) != 0 || strNewDER.length() != strLastDERID.length() && strNewDER.charAt(strLastDERID.length()) != '|' || StringHelper.IsNullOrEmpty((String)strLastDERID))) {
                derList.set(derList.size() - 1, strNewDER);
            } else {
                derList.add(strNewDER);
            }
        }
        int nCurAliasIndex = derAliasMap.get(strNewDER);
        IDEHelper iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strMajorDEID);
        if (iCurDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strMajorDEID));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (extSelects != null && !StringHelper.IsNullOrEmpty((String)(strExtSelect = joinQueryConfig.getExtSelect()))) {
            try {
                Properties extPros = PropertiesHelper.Load(null, (String)strExtSelect);
                for (Object objKey : extPros.keySet()) {
                    IDEFHelper iDEFHelper;
                    String strKeyValue = PropertiesHelper.GetProperty((Properties)extPros, (String)objKey.toString());
                    if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                        strKeyValue = objKey.toString();
                    }
                    if ((iDEFHelper = iCurDEHelper.GetDEFHelper(strKeyValue)) == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strMajorDEID, (Object)strKeyValue));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    callResult = this.GetDEFieldExp(iDEFHelper, strNewDER, derAliasMap, derList);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    String strFieldName = (String)callResult.getUserObject();
                    extSelects.put(objKey.toString(), strFieldName);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)joinQueryConfig.getAlias())) {
            DAQueryModelAlias qmAlias = new DAQueryModelAlias();
            qmAlias.setIDEHelper(iCurDEHelper);
            qmAlias.setParentDER(strNewDER);
            qmAlias.setDERAliasMap(derAliasMap);
            qmAlias.setDERList(derList);
            this.qmAliasMap.put(joinQueryConfig.getAlias().toUpperCase(), qmAlias);
        }
        if (joinQueryConfig.getJoinQueriesConfig() != null) {
            Iterator iterator = joinQueryConfig.getJoinQueriesConfig().iterator();
            while (iterator.hasNext()) {
                DGModelJoinQueryConfig subjoinQueryConfig = (DGModelJoinQueryConfig)((Object)iterator.next());
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"N1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"11", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"11M", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"INDEX", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, extSelects);
                    if (callResult.getRetCode() == 0) continue;
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getDERType(), (String)"INDEXM", (boolean)true) != 0 || (callResult = this.BuildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, extSelects)).getRetCode() == 0) continue;
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        if (joinQueryConfig.getLogicConfig() != null) {
            callResult = this.GetGroupCondition(iCurDEHelper, strNewDER, joinQueryConfig.getLogicConfig(), derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            String strGroupCondition = (String)callResult.getUserObject();
            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition)) {
                mainConditionList.add(strGroupCondition);
            }
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult BuildExistQuery(IDEHelper iDEHelper, DGModelJoinQueryConfig existQueryConfig, int nAlias, boolean bCustom) {
        Object pKeyDEFHelper;
        DAQueryModelAlias qmAlias;
        BaseDataEntity der1N;
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strDERID = existQueryConfig.getDERID();
        Vector<String> mainConditionList = new Vector<String>();
        Vector<String> derList = new Vector<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        IDEHelper iCurDEHelper = null;
        int nCurAliasIndex = -1;
        StringBuilderEx script = new StringBuilderEx();
        boolean bFirst = true;
        if (bCustom) {
            der1N = new DERCUSTOM();
            callResult = this.globalHelperEx.getDAModelHelper().GetDERCUSTOM(strDERID, (DERCUSTOM)der1N);
            if (callResult.getRetCode() != 0) {
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
            if (iCurDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)existQueryConfig.getAlias())) {
                qmAlias = new DAQueryModelAlias();
                qmAlias.setIDEHelper(iCurDEHelper);
                qmAlias.setParentDER("");
                qmAlias.setDERAliasMap(derAliasMap);
                qmAlias.setDERList(derList);
                this.qmAliasMap.put(existQueryConfig.getAlias().toUpperCase(), qmAlias);
            }
            pKeyDEFHelper = iCurDEHelper.GetKeyDEFHelper();
            String strMainTable = iCurDEHelper.GetMainTable();
            String strUserTable = iCurDEHelper.GetUserTable();
            Object strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            if (StringHelper.Compare((String)iCurDEHelper.GetDBStorage(), (String)this.iMajorDEHelper.GetDBStorage(), (boolean)true) != 0) {
                strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.GetDBSchema(), (Object)strMainTable);
                strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.GetDBSchema(), (Object)strUserTable);
            }
            nCurAliasIndex = this.getAliasIndex();
            derAliasMap.put("", nCurAliasIndex);
            script.Append("SELECT * FROM %1$s t%2$s \n", strMainTable2, (Object)(nCurAliasIndex + 1));
            if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                script.Append("INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n", (Object)strUserTable2, (Object)pKeyDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)(nCurAliasIndex + 1), (Object)(nCurAliasIndex + 2));
            }
            if (iCurDEHelper.IsLogicValid()) {
                IDEFHelper iValidDEFHelper = iCurDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
                if (iValidDEFHelper != null) {
                    mainConditionList.add(StringHelper.Format((String)"t%3$s.%1$s = %2$s", (Object)iValidDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iCurDEHelper.GetProperty("VALIDVALUE"), (Object)(nCurAliasIndex + 1)));
                } else {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)iCurDEHelper.GetFullName()));
                    callResult.setRetCode(1);
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
            }
            boolean bMT = true;
            String strCurMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nCurAliasIndex + 1));
            String strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            String strCustomJoin = der1N.getJOINCOND().replace("%%SRFMAJOR%%", strCurMTAlias);
            strCustomJoin = strCustomJoin.replace("%%SRFMINOR%%", strMTAlias);
            mainConditionList.add("(" + strCustomJoin + ")");
        } else {
            der1N = new DER1N();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strDERID, (DER1N)der1N);
            if (callResult.getRetCode() != 0) {
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iCurDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
            if (iCurDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)existQueryConfig.getAlias())) {
                qmAlias = new DAQueryModelAlias();
                qmAlias.setIDEHelper(iCurDEHelper);
                qmAlias.setParentDER("");
                qmAlias.setDERAliasMap(derAliasMap);
                qmAlias.setDERList(derList);
                this.qmAliasMap.put(existQueryConfig.getAlias().toUpperCase(), qmAlias);
            }
            pKeyDEFHelper = iCurDEHelper.GetKeyDEFHelper();
            IDEFHelper pickupDEFHelper = null;
            for (IDEFHelper iDEFHelper : iCurDEHelper.GetDEFHelpers()) {
                ILinkDEFHelper linkDEFHelper;
                if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof ILinkDEFHelper) || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)der1N.getDERID(), (boolean)true) != 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                pickupDEFHelper = iDEFHelper;
                break;
            }
            if (pKeyDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)iCurDEHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (pickupDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e0e\u76f8\u5173\u5b9e\u4f53\u7684\u5173\u7cfb\u5c5e\u6027 ", (Object)iCurDEHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            IDEFHelper pickupRelatedDEFHelper = null;
            if (pickupDEFHelper instanceof ILinkDEFHelper) {
                pickupRelatedDEFHelper = ((ILinkDEFHelper)pickupDEFHelper).GetRelatedDEFHelper();
            }
            if (pickupRelatedDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027 ", (Object)pickupDEFHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (StringHelper.Compare((String)pickupRelatedDEFHelper.getDEHelper().getId(), (String)iDEHelper.getId(), (boolean)true) != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u7684\u5b9e\u4f53\u4e0e\u4e0a\u7ea7\u5b9e\u4f53\u4e0d\u4e00\u81f4 ", (Object)pickupDEFHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strMainTable = iCurDEHelper.GetMainTable();
            String strUserTable = iCurDEHelper.GetUserTable();
            String strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            if (StringHelper.Compare((String)iCurDEHelper.GetDBStorage(), (String)this.iMajorDEHelper.GetDBStorage(), (boolean)true) != 0) {
                strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.GetDBSchema(), (Object)strMainTable);
                strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.GetDBSchema(), (Object)strUserTable);
            }
            nCurAliasIndex = this.getAliasIndex();
            derAliasMap.put("", nCurAliasIndex);
            script.Append("SELECT * FROM %1$s t%2$s \n", (Object)strMainTable2, (Object)(nCurAliasIndex + 1));
            if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                script.Append("INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n", (Object)strUserTable2, (Object)pKeyDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)(nCurAliasIndex + 1), (Object)(nCurAliasIndex + 2));
            }
            if (iCurDEHelper.IsLogicValid()) {
                IDEFHelper iValidDEFHelper = iCurDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
                if (iValidDEFHelper != null) {
                    mainConditionList.add(StringHelper.Format((String)"t%3$s.%1$s = %2$s", (Object)iValidDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iCurDEHelper.GetProperty("VALIDVALUE"), (Object)(nCurAliasIndex + 1)));
                } else {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)iCurDEHelper.GetFullName()));
                    callResult.setRetCode(1);
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
            }
            boolean bMT = true;
            bMT = StringHelper.Compare((String)pickupDEFHelper.GetDTColumn().GetTableName(), (String)strMainTable, (boolean)true) == 0;
            mainConditionList.add(StringHelper.Format((String)"t%1$s.%3$s = t%2$s.%4$s", (Object)(nAlias + 1), (Object)(nCurAliasIndex + (bMT ? 1 : 2)), (Object)pickupRelatedDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetFormalColumnName()));
        }
        if (existQueryConfig.getJoinQueriesConfig() != null) {
            pKeyDEFHelper = existQueryConfig.getJoinQueriesConfig().iterator();
            while (pKeyDEFHelper.hasNext()) {
                DGModelJoinQueryConfig joinQueryConfig = (DGModelJoinQueryConfig)((Object)pKeyDEFHelper.next());
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"11M", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, null);
                    if (callResult.getRetCode() == 0) continue;
                    return callResult;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add((String)callResult.getUserObject());
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    callResult = this.BuildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    mainConditionList.add("NOT(" + (String)callResult.getUserObject() + ")");
                    continue;
                }
                if (!(StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEX", (boolean)true) == 0 ? (callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, null)).getRetCode() != 0 : StringHelper.Compare((String)joinQueryConfig.getDERType(), (String)"INDEXM", (boolean)true) == 0 && (callResult = this.BuildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, null)).getRetCode() != 0)) continue;
                return callResult;
            }
        }
        if (existQueryConfig.getLogicConfig() != null) {
            callResult = this.GetGroupCondition(iCurDEHelper, "", existQueryConfig.getLogicConfig(), derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            String strGroupCondition = (String)callResult.getUserObject();
            if (!StringHelper.IsNullOrEmpty((String)strGroupCondition)) {
                mainConditionList.add(strGroupCondition);
            }
        }
        TreeMap<String, Integer> joinMap = new TreeMap<String, Integer>();
        for (String strDERs : derList) {
            callResult = this.GetJoin(script, iCurDEHelper, "", strDERs, derAliasMap, joinMap);
            if (callResult.getRetCode() == 0) continue;
            return callResult;
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
                script.Append(" %1$s ", (Object)strCondition);
            }
        }
        callResult.setRetCode(0);
        callResult.setUserObject((Object)("EXISTS(" + script.toString() + ")"));
        return callResult;
    }

    public CallResult GetGroupCondition(DGModelGroupLogicConfig dgModelGroupLogicConfig) {
        return this.GetGroupCondition(this.iMajorDEHelper, "", dgModelGroupLogicConfig, this.majorDERAliasMap, this.majorDERList);
    }

    public String GetDEFieldExp(String strDEField) throws Exception {
        IDEFHelper iDEFHelper = this.iMajorDEHelper.GetDEFHelper(strDEField);
        if (iDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5bf9\u8c61", (Object)strDEField));
        }
        CallResult callResult = this.GetDEFieldExp(iDEFHelper);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5bf9\u5e94\u8868\u8fbe\u5f0f\uff0c%2$s", (Object)strDEField, (Object)callResult.getErrorInfo()));
        }
        return (String)callResult.getUserObject();
    }

    public CallResult GetDEFieldExp(IDEFHelper iDEFHelper) {
        return this.GetDEFieldExp(iDEFHelper, "", this.majorDERAliasMap, this.majorDERList);
    }

    public int GetMajorDERAlias(String strDERId) {
        if (this.majorDERAliasMap.containsKey(strDERId)) {
            return this.majorDERAliasMap.get(strDERId);
        }
        return -1;
    }

    protected CallResult GetGroupCondition(IDEHelper iDEHelper, String strParentDER, DGModelGroupLogicConfig dgModelGroupLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        StringBuilderEx script = new StringBuilderEx();
        if (dgModelGroupLogicConfig.getLogicsConfig() == null) {
            callResult.setUserObject((Object)"");
            return callResult;
        }
        if (dgModelGroupLogicConfig.getLogicsConfig().size() == 0) {
            callResult.setUserObject((Object)"");
            return callResult;
        }
        callResult.setRetCode(1);
        if (dgModelGroupLogicConfig.isNot()) {
            script.Append("NOT");
        }
        script.Append("(");
        boolean bFirst = true;
        Iterator iterator = dgModelGroupLogicConfig.getLogicsConfig().iterator();
        while (iterator.hasNext()) {
            DGModelCustomLogicConfig customLogicConfig;
            DGModelBaseLogicConfig dgModelBaseLogicConfig = (DGModelBaseLogicConfig)((Object)iterator.next());
            if (bFirst) {
                bFirst = false;
            } else if (StringHelper.Compare((String)dgModelGroupLogicConfig.getCondition(), (String)"AND", (boolean)true) == 0) {
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
                continue;
            }
            if (dgModelBaseLogicConfig instanceof DGModelSingleLogicConfig) {
                callResult = this.GetSingleCondition(iDEHelper, strParentDER, (DGModelSingleLogicConfig)dgModelBaseLogicConfig, derAliasMap, derList);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                script.Append(" %1$s ", callResult.getUserObject());
                continue;
            }
            if (!(dgModelBaseLogicConfig instanceof DGModelCustomLogicConfig) || StringHelper.IsNullOrEmpty((String)(customLogicConfig = (DGModelCustomLogicConfig)dgModelBaseLogicConfig).getCondition())) continue;
            callResult = this.GetCustomCondition(iDEHelper, strParentDER, customLogicConfig, derAliasMap, derList);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u81ea\u5b9a\u4e49\u903b\u8f91[%1$s -- %2$s]\u5931\u8d25\uff0c%3$s", (Object)customLogicConfig.getLogicName(), (Object)customLogicConfig.getCondition(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            script.Append(" %1$s ", callResult.getUserObject());
        }
        script.Append(")");
        callResult.setRetCode(0);
        callResult.setUserObject((Object)script.toString());
        return callResult;
    }

    protected CallResult GetSingleCondition(IDEHelper iDEHelper, String strParentDER, DGModelSingleLogicConfig dgModelSingleLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dgModelSingleLogicConfig.getDEField());
        if (iDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]", (Object)dgModelSingleLogicConfig.getDEField()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.GetDEFieldExp(iDEFHelper, strParentDER, derAliasMap, derList);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strFieldName = (String)callResult.getUserObject();
        String strFunc = dgModelSingleLogicConfig.getFunc();
        if (StringHelper.IsNullOrEmpty((String)strFunc)) {
            IDEFQueryHelper iDEFQueryHelper;
            String strParamName = dgModelSingleLogicConfig.getParamName();
            String strParamValue = dgModelSingleLogicConfig.getValue();
            if (this.globalParamMap.containsKey(strParamName)) {
                strParamValue = this.globalParamMap.get(strParamName);
                strParamName = "";
            }
            if ((iDEFQueryHelper = iDEFHelper.GetQueryHelper()) != null) {
                String strSQL = iDEFQueryHelper.GetConditionSQL(this, this, strFieldName, dgModelSingleLogicConfig.getCondition(), strParamValue, strParamName);
                callResult.setUserObject((Object)strSQL);
                callResult.setRetCode(0);
                return callResult;
            }
            String strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strSQL = this.GetConditionSQL(strFieldName, strDataType, dgModelSingleLogicConfig.getCondition(), strParamValue, strParamName);
            if (StringHelper.IsNullOrEmpty((String)strSQL)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6761\u4ef6\u8bed\u53e5"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult.setUserObject((Object)strSQL);
            callResult.setRetCode(0);
            return callResult;
        }
        IDAValueFunc iDAValueFunc = this.globalHelperEx.getDAConfigMgr().getValueFuncMgr().FindFunc(strFunc, this.GetDBType(), iDEFHelper.GetStdDataType());
        if (iDAValueFunc == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u7684\u503c\u5904\u7406\u51fd\u6570[%1$s]", (Object)strFunc));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strFuncFormat = StringHelper.Format((String)iDAValueFunc.GetFuncFormat(), (Object)strFieldName);
        String strSQL = this.GetConditionSQL(strFuncFormat, iDAValueFunc.GetDataType(), dgModelSingleLogicConfig.getCondition(), dgModelSingleLogicConfig.getValue(), dgModelSingleLogicConfig.getParamName());
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6761\u4ef6\u8bed\u53e5"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult.setUserObject((Object)strSQL);
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult GetCustomCondition(IDEHelper iDEHelper, String strParentDER, DGModelCustomLogicConfig dgModelCustomLogicConfig, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
        String strTemp;
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strCondition = dgModelCustomLogicConfig.getCondition();
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u903b\u8f91");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DAQueryModelAlias qmAlias = new DAQueryModelAlias();
        qmAlias.setIDEHelper(iDEHelper);
        qmAlias.setParentDER(strParentDER);
        qmAlias.setDERAliasMap(derAliasMap);
        qmAlias.setDERList(derList);
        this.qmAliasMap.put("CUR".toUpperCase(), qmAlias);
        if (strCondition.indexOf("qm.") != -1 || StringHelper.Compare((String)strCondition, (String)"\"1=1\"", (boolean)true) == 0) {
            return this.grooveEngine.GetCustomCondition(strCondition);
        }
        if (!(strCondition.indexOf("${") != -1 || StringHelper.IsNullOrEmpty((String)(strTemp = strCondition.trim())) || strTemp.charAt(0) != '\"' && strTemp.charAt(0) != '\'')) {
            return this.grooveEngine.GetCustomCondition(strCondition);
        }
        Configuration config = new Configuration();
        StrTemplateLoader deTemplateLoader = new StrTemplateLoader(strCondition);
        config.setTemplateLoader((TemplateLoader)deTemplateLoader);
        try {
            Template template = config.getTemplate("STRING");
            StringWriter sw = new StringWriter();
            template.process(this.macroParams, (Writer)sw);
            callResult.setUserObject((Object)sw.toString());
            return callResult;
        }
        catch (IOException e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            return callResult;
        }
        catch (TemplateException e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            return callResult;
        }
    }

    /*
     * Unable to fully structure code
     */
    protected CallResult GetJoin(StringBuilderEx script, IDEHelper iDEHelper, String strParentDERs, String strDER, TreeMap<String, Integer> derAliasMap, TreeMap<String, Integer> joinMap) {
        callResult = new CallResult();
        callResult.setRetCode(1);
        if (StringHelper.IsNullOrEmpty((String)strDER)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u8fde\u63a5\u5173\u7cfb"));
            BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        strDERs = strDER.split("[|]");
        strCurDERId = strDERs[0];
        strCurTotalDER = strParentDERs;
        if (!StringHelper.IsNullOrEmpty((String)strCurTotalDER)) {
            strCurTotalDER = String.valueOf(strCurTotalDER) + "|";
        }
        strCurTotalDER = String.valueOf(strCurTotalDER) + strCurDERId;
        iNextDEHelper = null;
        derCustom = iDEHelper.FindDERCUSTOM(false, strCurDERId);
        if (derCustom != null) {
            if (!joinMap.containsKey(strCurTotalDER)) {
                strPreFix = "t";
                iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derCustom.getMAJORDEID());
                if (iNextDEHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derCustom.getMAJORDEID()));
                    BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                strMTAlias = "";
                strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                        BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                strCurMTAlias = "";
                strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                strMainTable = iNextDEHelper.GetMainTable();
                strUserTable = iNextDEHelper.GetUserTable();
                strMainTable2 = strMainTable;
                strUserTable2 = strUserTable;
                if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)iDEHelper.GetDBStorage(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
                }
                strCustomJoin = derCustom.getJOINCOND().replace("%%SRFMAJOR%%", strCurMTAlias);
                strCustomJoin = strCustomJoin.replace("%%SRFMINOR%%", strMTAlias);
                script.Append("LEFT JOIN %1$s %2$s ON %3$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)strCustomJoin);
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
                }
                joinMap.put(strCurTotalDER, 1);
            }
            strNextDERId = "";
            i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                callResult.setRetCode(0);
                return callResult;
            }
            return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
        }
        joinDEFHelper = null;
        bInheritMode = false;
        bRightJoin = false;
        if (strCurDERId.indexOf("N1R:") == 0) {
            bRightJoin = true;
        }
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof ILinkDEFHelper) || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strCurDERId, (boolean)true) != 0 && (!bRightJoin || StringHelper.Compare((String)linkDEFHelper.GetDERId(), (String)strCurDERId.substring(4), (boolean)true) != 0)) continue;
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0) {
                joinDEFHelper = iDEFHelper;
                break;
            }
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
            bInheritMode = true;
            iNextDEHelper = linkDEFHelper.GetRelatedDEFHelper().getDEHelper();
            break;
        }
        if (bInheritMode) {
            if (!joinMap.containsKey(strCurTotalDER)) {
                strPreFix = "t";
                strMTAlias = "";
                strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                        BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                strCurMTAlias = "";
                strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                bJoinAsMain = true;
                iKeyDEFHelper = iDEHelper.GetKeyDEFHelper();
                bJoinAsMain = StringHelper.Compare((String)iKeyDEFHelper.GetDTColumn().GetTableName(), (String)iDEHelper.getDataEntity().getTABLENAME(), (boolean)true) == 0;
                strMainTable = iNextDEHelper.GetMainTable();
                strUserTable = iNextDEHelper.GetUserTable();
                strMainTable2 = strMainTable;
                strUserTable2 = strUserTable;
                if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)this.iMajorDEHelper.GetDBStorage(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
                }
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain != false ? strMTAlias : strUTAlias), (Object)iKeyDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iNextDEHelper.GetKeyDEFHelper().GetDTColumn().GetFormalColumnName());
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
                }
                joinMap.put(strCurTotalDER, 1);
            }
            strNextDERId = "";
            i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                callResult.setRetCode(0);
                return callResult;
            }
            return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
        }
        bLeftOuterJoin = false;
        joinRelatedDEFHelper = null;
        if (joinDEFHelper != null) ** GOTO lbl238
        strTempCurDERId = "";
        if (strCurDERId.indexOf("1NLO:") == 0) {
            strTempCurDERId = strCurDERId.substring(5);
            der1N = new DER1N();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strTempCurDERId, der1N);
            if (callResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strTempCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (StringHelper.Compare((String)iDEHelper.getId(), (String)der1N.getMAJORDEID(), (boolean)true) != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strTempCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
            if (iNextDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            for (IDEFHelper iDEFHelper : iNextDEHelper.GetDEFHelpers()) {
                if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof ILinkDEFHelper) || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strTempCurDERId, (boolean)true) != 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                joinRelatedDEFHelper = iDEFHelper;
                joinDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
                break;
            }
            if (joinRelatedDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iNextDEHelper.GetFullName(), (Object)strCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            bLeftOuterJoin = true;
        } else if (strCurDERId.indexOf("11M:") == 0) {
            strTempCurDERId = strCurDERId.substring(4);
            der11 = new DER11();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER11(strTempCurDERId, der11);
            if (callResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strTempCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (StringHelper.Compare((String)iDEHelper.getId(), (String)der11.getMAJORDEID(), (boolean)true) != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strTempCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
            if (iNextDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)der11.getMINORDEID()));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            for (IDEFHelper iDEFHelper : iNextDEHelper.GetDEFHelpers()) {
                if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof ILinkDEFHelper) || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strTempCurDERId, (boolean)true) != 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                joinRelatedDEFHelper = iDEFHelper;
                joinDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
                break;
            }
            if (joinRelatedDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iNextDEHelper.GetFullName(), (Object)strCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        } else if (strCurDERId.indexOf("INDEX:") == 0 || strCurDERId.indexOf("INDEXM:") == 0) {
            bIndexM = false;
            if (strCurDERId.indexOf("INDEXM:") == 0) {
                bIndexM = true;
            }
            strTempCurDERId = "";
            strTempCurDERId = bIndexM != false ? strCurDERId.substring(7) : strCurDERId.substring(6);
            derIndex = new DERINDEX();
            callResult = this.globalHelperEx.getDAModelHelper().GetDERINDEX(strTempCurDERId, derIndex);
            if (callResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strTempCurDERId));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iNextDEHelper = bIndexM != false ? this.globalHelperEx.getDAModelStorage().FindDEHelper(derIndex.getDEID()) : this.globalHelperEx.getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
            if (iNextDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)(bIndexM != false ? derIndex.getDEID() : derIndex.getINDEXDEID())));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            joinRelatedDEFHelper = iNextDEHelper.GetKeyDEFHelper();
            joinDEFHelper = iDEHelper.GetKeyDEFHelper();
        } else {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strCurDERId));
            BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
            return callResult;
lbl238:
            // 1 sources

            if (joinDEFHelper instanceof ILinkDEFHelper) {
                joinRelatedDEFHelper = ((ILinkDEFHelper)joinDEFHelper).GetRelatedDEFHelper();
            }
            if (joinRelatedDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]\u5173\u8054\u5c5e\u6027", (Object)joinDEFHelper.GetFullName()));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iNextDEHelper = joinRelatedDEFHelper.getDEHelper();
        }
        if (!joinMap.containsKey(strCurTotalDER)) {
            strMTAlias = "";
            strUTAlias = "";
            if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                nAlias = derAliasMap.get("");
                strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
            } else {
                if (!derAliasMap.containsKey(strParentDERs)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                nAlias = derAliasMap.get(strParentDERs);
                strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
            }
            strCurMTAlias = "";
            strCurUTAlias = "";
            if (!derAliasMap.containsKey(strCurTotalDER)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                BaseDAQueryModelHelper.log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            nAlias = derAliasMap.get(strCurTotalDER);
            strCurMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            strCurUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
            bJoinAsMain = true;
            bJoinAsMain = StringHelper.Compare((String)joinDEFHelper.GetDTColumn().GetTableName(), (String)iDEHelper.GetMainTable(), (boolean)true) == 0;
            strMainTable = iNextDEHelper.GetMainTable();
            strUserTable = iNextDEHelper.GetUserTable();
            strMainTable2 = strMainTable;
            strUserTable2 = strUserTable;
            if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)this.iMajorDEHelper.GetDBStorage(), (boolean)true) != 0) {
                strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
            }
            if (bLeftOuterJoin) {
                script.Append("LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain != false ? strMTAlias : strUTAlias), (Object)joinDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName());
            } else if (bRightJoin) {
                script.Append("RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain != false ? strMTAlias : strUTAlias), (Object)joinDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName());
            } else {
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain != false ? strMTAlias : strUTAlias), (Object)joinDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName());
            }
            if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                pkeyDEFHelper = null;
                pkeyDEFHelper = joinRelatedDEFHelper.GetDTColumn().IsPKey() != false ? joinRelatedDEFHelper : iNextDEHelper.GetKeyDEFHelper();
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
            }
            joinMap.put(strCurTotalDER, 1);
        }
        strNextDERId = "";
        i = 1;
        while (i < strDERs.length) {
            if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                strNextDERId = String.valueOf(strNextDERId) + "|";
            }
            strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
            ++i;
        }
        if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
            callResult.setRetCode(0);
            return callResult;
        }
        return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
    }

    protected CallResult GetDEFieldExp(IDEFHelper iDEFHelper, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        IDEHelper iDEHelper = iDEFHelper.getDEHelper();
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        if (iDEFDTColumn.IsFormula() && !iDEFHelper.IsFormulaPhisical()) {
            String strFormulaFields = iDEFDTColumn.GetFormulaColumns();
            if (!StringHelper.IsNullOrEmpty((String)strFormulaFields)) {
                Object[] params = null;
                String[] strFields = strFormulaFields.split("[;]");
                params = new Object[strFields.length];
                int i = 0;
                while (i < strFields.length) {
                    String strDEFName = strFields[i].toUpperCase();
                    IDEFHelper argvField = iDEFHelper.getDEHelper().GetDEFHelper(strDEFName);
                    if (argvField == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u903b\u8f91\u5c5e\u6027\u53c2\u6570[%1$s]\u65e0\u6548", (Object)strDEFName));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    callResult = this.GetDEFieldExp(argvField, strParentDER, derAliasMap, derList);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    params[i] = callResult.getUserObject();
                    ++i;
                }
                String strExp = StringHelper.Format((String)iDEFDTColumn.GetFormulaFormat(), (Object[])params);
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            String strExp = StringHelper.Format((String)iDEFDTColumn.GetFormulaFormat());
            callResult.setRetCode(0);
            callResult.setUserObject((Object)strExp);
            this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
            return callResult;
        }
        String strDERID = "";
        if (iDEFHelper instanceof ILinkDEFHelper) {
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            strDERID = linkDEFHelper.GetDERId();
        }
        if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0) {
            strDERID = "";
        } else if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 && iDEFHelper.getDEField().getDEFTYPE() == 1) {
            strDERID = "";
        }
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            boolean bDynamicTable = false;
            String strMainTable = iDEHelper.GetMainTable();
            String strUserTable = iDEHelper.GetUserTable();
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
                int nAlias = derAliasMap.get("");
                strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
                bDynamicTable = StringHelper.Compare((String)iDEHelper.getDataEntity().getSTORAGETYPE(), (String)"DYNAMIC", (boolean)true) == 0;
            } else {
                if (!derAliasMap.containsKey(strParentDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strParentDER);
                strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
            }
            String strDEFTableName = iDEFDTColumn.GetTableName();
            if (bDynamicTable || StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strMTAlias, (Object)iDEFDTColumn.GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
                return callResult;
            }
            if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strUTAlias, (Object)iDEFDTColumn.GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                this.SetFieldQueryCaseSensitive(strExp, iDEFDTColumn.GetQueryCaseSenstive());
                return callResult;
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c5e\u6027[%1$s]\u8868\u540d[%2$s]", (Object)iDEFHelper.GetFullName(), (Object)strDEFTableName));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strNewDER = strParentDER;
        if (!StringHelper.IsNullOrEmpty((String)strNewDER)) {
            strNewDER = String.valueOf(strNewDER) + "|";
        }
        strNewDER = String.valueOf(strNewDER) + strDERID;
        IDEFHelper relatedDEFHelper = null;
        if (iDEFHelper instanceof ILinkDEFHelper) {
            relatedDEFHelper = ((ILinkDEFHelper)iDEFHelper).GetRelatedDEFHelper();
        }
        if (relatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)iDEFHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!derAliasMap.containsKey(strNewDER)) {
            derAliasMap.put(strNewDER, this.getAliasIndex());
            String strLastDERID = "";
            if (derList.size() > 0) {
                strLastDERID = derList.get(derList.size() - 1);
            }
            if (!(strNewDER.indexOf(strLastDERID) != 0 || strNewDER.length() != strLastDERID.length() && strNewDER.charAt(strLastDERID.length()) != '|' || StringHelper.IsNullOrEmpty((String)strLastDERID))) {
                derList.set(derList.size() - 1, strNewDER);
            } else {
                derList.add(strNewDER);
            }
        }
        return this.GetDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList);
    }

    protected CallResult GetTableAlias(IDEHelper iDEHelper, boolean bMain, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        int nAlias = derAliasMap.get("");
        String strMTAlias = "";
        String strUTAlias = "";
        strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
        strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
        if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
            strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
        } else {
            if (!derAliasMap.containsKey(strParentDER)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
        }
        String strExp = bMain ? strMTAlias : strUTAlias;
        callResult.setRetCode(0);
        callResult.setUserObject((Object)strExp);
        return callResult;
    }

    protected String GetConditionSQL(String strFieldName, String strDataType, String strCondition, String strValue, String strParamName) {
        Vector<String> argList;
        String strFuncName;
        if (StringHelper.Compare((String)strCondition, (String)"TESTNULL", (boolean)true) == 0) {
            if (StringHelper.Compare((String)strValue, (String)"1", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
            }
            return StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"ISNOTNULL", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strParamName) && MacroHelper.isSRFFunc(strParamName) && StringHelper.Compare((String)(strFuncName = MacroHelper.ParseSRFFunc(strParamName, argList = new Vector<String>())), (String)"SRFUVEX", (boolean)true) == 0) {
            if (argList.size() == 0) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u6269\u5c55URL\u53c2\u6570[%1$s]", (Object)strParamName));
                return "";
            }
            String strMacroIndex = StringHelper.Format((String)"_MACRO_%1$s_", (Object)this.nMacroIndex);
            ++this.nMacroIndex;
            URLCondPair urlCondPair = new URLCondPair();
            urlCondPair.strFieldName = strFieldName;
            urlCondPair.strDataType = strDataType;
            urlCondPair.strCondition = strCondition;
            urlCondPair.strURLParam = argList.get(0);
            urlCondPair.strMacro = strMacroIndex;
            if (argList.size() >= 2) {
                urlCondPair.bAll = StringHelper.Compare((String)argList.get(1), (String)"ALL", (boolean)true) == 0;
            }
            this.urlCondPairList.add(urlCondPair);
            return strMacroIndex;
        }
        int nDataType = DataTypeHelper.FromString((String)strDataType);
        if (DataTypeHelper.IsStringType((int)nDataType)) {
            return this.GetStringConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsIntType((int)nDataType)) {
            return this.GetIntConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsDoubleType((int)nDataType)) {
            return this.GetDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsDateTimeType((int)nDataType)) {
            return this.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        return "";
    }

    public String GetStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        return this.GetStringConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String GetStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue + "%";
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = String.valueOf(strValue) + "%";
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue;
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }

    public String GetIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        return this.GetIntConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String GetIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
        Object objValue = null;
        if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0 && (objValue = DataTypeParse.TestBigInt((String)strValue)) == null) {
            log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)strValue));
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                String[] items = strValue.split("[;]");
                String strSQL = "";
                strSQL = StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"%1$s", (Object)items[i]);
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
            return "";
        }
        CallParam callParam = new CallParam();
        callParam.setParamName(strParamName);
        callParam.setValue(objValue);
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s = ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <> ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s > ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s >=?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s < ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <= ?", (Object)strFieldName);
        }
        return "";
    }

    public String GetDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        return this.GetDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String GetDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
        Object objValue = DataTypeParse.TestDouble((String)strValue);
        if (objValue == null && StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0) {
            log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)strValue));
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            return "";
        }
        CallParam callParam = new CallParam();
        callParam.setParamName(strParamName);
        callParam.setValue(objValue);
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s = ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <> ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s > ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s >=?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s < ?", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <= ?", (Object)strFieldName);
        }
        return "";
    }

    public String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        return this.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
        Object objValue = null;
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            objValue = DataTypeParse.TestDateTime((String)strValue);
            if (objValue == null) {
                log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u65e5\u671f\u65f6\u95f4\u6027", (Object)strValue));
                return "";
            }
            Timestamp ts = (Timestamp)objValue;
            strValue = StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)ts);
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(ts.getTime()));
                if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
                    strValue = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 23:59:59", (Object)ts);
                    objValue = DataTypeParse.TestDateTime((String)strValue);
                }
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            return "";
        }
        CallParam callParam = new CallParam();
        callParam.setParamName(strParamName);
        callParam.setValue(objValue);
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s = ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <> ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s > ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s >= ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s < ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            this.callParams.add(callParam);
            return StringHelper.Format((String)"%1$s <= ?", (Object)strFieldName, (Object)strValue);
        }
        return "";
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
            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u5bf9\u5e94\u7684\u8868\u8fbe\u5f0f", (Object)strDEFName));
            return "";
        }
        if (!this.fieldDataTypeMap.containsKey(strDEFName)) {
            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u5bf9\u5e94\u7684\u6570\u636e\u7c7b\u578b", (Object)strDEFName));
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getFunc())) {
            IDEFQueryHelper iDEFQueryHelper;
            if (iDEFHelper.getEncryptStorage() == 1 && !StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = EncryptHelper.encode2(strValue);
            }
            if ((iDEFQueryHelper = iDEFHelper.GetQueryHelper()) != null) {
                String strSQL = iDEFQueryHelper.GetConditionSQL(iQMUserContext, this, this.fieldExpMap.get(strDEFName), searchItemConfig.getAction(), strValue, "");
                return strSQL;
            }
            return this.GetConditionSQL(this.fieldExpMap.get(strDEFName), this.fieldDataTypeMap.get(strDEFName), searchItemConfig.getAction(), strValue, "");
        }
        IDAValueFunc iDAValueFunc = this.globalHelperEx.getDAConfigMgr().getValueFuncMgr().FindFunc(searchItemConfig.getFunc(), this.GetDBType(), iDEFHelper.GetStdDataType());
        if (iDAValueFunc == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u7684\u503c\u5904\u7406\u51fd\u6570[%1$s]", (Object)searchItemConfig.getFunc()));
            return "";
        }
        String strFuncFormat = StringHelper.Format((String)iDAValueFunc.GetFuncFormat(), (Object)this.fieldExpMap.get(strDEFName));
        return this.GetConditionSQL(strFuncFormat, iDAValueFunc.GetDataType(), searchItemConfig.getAction(), strValue, "");
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
        if (StringHelper.IsNullOrEmpty((String)strFunc)) {
            IDEFQueryHelper iDEFQueryHelper;
            if (iDEFHelper.getEncryptStorage() == 1 && !StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = EncryptHelper.encode2(strValue);
            }
            if ((iDEFQueryHelper = iDEFHelper.GetQueryHelper()) != null) {
                String strSQL = iDEFQueryHelper.GetConditionSQL(iQMUserContext, this, this.fieldExpMap.get(strDEFName), strAction, strValue, "");
                return strSQL;
            }
            return this.GetConditionSQL(this.fieldExpMap.get(strDEFName), this.fieldDataTypeMap.get(strDEFName), strAction, strValue, "");
        }
        return "";
    }

    public String GetCountSQL(String strSQL) {
        return "";
    }

    public String GetPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        return "";
    }

    public String GetPagingSQL(String strSQL, int nStartPos, int nPageSize, String strGroup, String strGroupDir, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.IsNullOrEmpty((String)strGroup)) {
            return this.GetPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection);
        }
        return this.GetPagingSQL(strSQL, nStartPos, nPageSize, strGroup, strGroupDir, strMajor, strMajorDirection);
    }

    public String GetSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        return "";
    }

    public String GetSortSQL(boolean bSubQuery, String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (bSubQuery) {
            StringBuilderEx script = new StringBuilderEx();
            if (!StringHelper.IsNullOrEmpty((String)strMajor)) {
                String strFieldName = this.fieldExpMap.get(strMajor.toUpperCase());
                if (!StringHelper.IsNullOrEmpty((String)strFieldName)) {
                    script.Append("%1$s ORDER BY %2$s %3$s", (Object)strSQL, (Object)strFieldName, (Object)strMajorDirection);
                    if (!StringHelper.IsNullOrEmpty((String)strMinor) && !StringHelper.IsNullOrEmpty((String)(strFieldName = this.fieldExpMap.get(strMinor.toUpperCase())))) {
                        script.Append(",%1$s %2$s", (Object)strFieldName, (Object)strMinorDirection);
                    }
                }
                return script.toString();
            }
            return strSQL;
        }
        return this.GetSortSQL(strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
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

    public String GetGroupSQL(String strSQL, QueryGroupModelConfig queryGroupModelConfig, Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity) {
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            strSQL = this.GetQueryModelScript(null);
        }
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u67e5\u8be2\u8bed\u53e5\u65e0\u6548"));
            return "";
        }
        StringBuilderEx sqlGroup = new StringBuilderEx();
        IDEHelper majorDEHelper = this.GetMajorDEHelper();
        sqlGroup.Append("SELECT ");
        boolean bFirst = true;
        int nAliasIndex = 0;
        TreeMap<Integer, String> orderMap = new TreeMap<Integer, String>();
        Vector<String> groupFields = new Vector<String>();
        Vector<QueryGroupItemConfig> recalcItems = new Vector<QueryGroupItemConfig>();
        Iterator iterator = queryGroupModelConfig.iterator();
        while (iterator.hasNext()) {
            String strParams;
            QueryGroupItemConfig queryGroupItemConfig = (QueryGroupItemConfig)((Object)iterator.next());
            if (queryGroupItemConfig.isReCalc()) {
                recalcItems.add(queryGroupItemConfig);
                continue;
            }
            ++nAliasIndex;
            Object strFormular = queryGroupItemConfig.getFormular();
            String strDEFields = queryGroupItemConfig.getDEFields();
            if (StringHelper.IsNullOrEmpty((String)strFormular) && StringHelper.IsNullOrEmpty((String)strDEFields)) continue;
            String strFieldCode = "";
            String strAlias = queryGroupItemConfig.getAlias();
            if (!StringHelper.IsNullOrEmpty((String)strDEFields)) {
                String[] fields = strDEFields.split("[,]");
                Object[] fieldCodes = new String[fields.length];
                if (StringHelper.IsNullOrEmpty((String)strFormular)) {
                    strFormular = "%1$s";
                    String strDEField = fields[0];
                    IDEFHelper defHelper = majorDEHelper.GetDEFHelper(strDEField);
                    if (defHelper == null) {
                        if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        fieldCodes[0] = strDEField;
                    } else {
                        if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        String strRealCode = this.GetDEFieldStatisticsNullConvertCode(defHelper);
                        fieldCodes[0] = strRealCode;
                    }
                } else {
                    int i = 0;
                    while (i < fields.length) {
                        String strDEField = fields[i];
                        IDEFHelper defHelper = majorDEHelper.GetDEFHelper(strDEField);
                        if (defHelper == null) {
                            fieldCodes[i] = strDEField;
                        } else {
                            String strRealCode = this.GetDEFieldStatisticsNullConvertCode(defHelper);
                            fieldCodes[i] = strRealCode;
                        }
                        ++i;
                    }
                }
                strFieldCode = StringHelper.Format((String)strFormular, (Object[])fieldCodes);
            } else {
                strFieldCode = strFormular;
            }
            if (bFirst) {
                bFirst = false;
            } else {
                sqlGroup.Append(",");
            }
            if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                strAlias = StringHelper.Format((String)"A%1$s", (Object)nAliasIndex);
                queryGroupItemConfig.setAlias(strAlias);
            }
            sqlGroup.Append("%1$s as %2$s", (Object)strFieldCode, (Object)strAlias);
            if (queryGroupItemConfig.getIsGroup()) {
                groupFields.add(strFieldCode);
            }
            if (!StringHelper.IsNullOrEmpty((String)queryGroupItemConfig.getOrderDirection())) {
                orderMap.put(queryGroupItemConfig.getOrder(), StringHelper.Format((String)"%1$s %2$s", (Object)strAlias, (Object)queryGroupItemConfig.getOrderDirection()));
            }
            if (StringHelper.IsNullOrEmpty((String)(strParams = queryGroupItemConfig.getUserTag()))) continue;
            String[] params = strParams.split("[;]");
            int i = 0;
            while (i < params.length) {
                Object objValue;
                CallParam cp = new CallParam();
                cp.setParamName(params[i]);
                CallResult callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
                if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                    cp.setValue(objValue);
                }
                list.add(cp);
                ++i;
            }
        }
        sqlGroup.Append(" FROM (%1$s) m1 ", (Object)strSQL);
        if (groupFields.size() == 0) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u4efb\u4f55\u5206\u7ec4\u5c5e\u6027"));
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
                ++nAliasIndex;
                String strFormular = queryGroupItemConfig.getFormular();
                String strDEFields = queryGroupItemConfig.getDEFields();
                if (StringHelper.IsNullOrEmpty((String)strFormular) && StringHelper.IsNullOrEmpty((String)strDEFields)) continue;
                String strFieldCode = "";
                String strAlias = queryGroupItemConfig.getAlias();
                strFieldCode = strFormular;
                sqlGroup.Append(",");
                if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                    strAlias = StringHelper.Format((String)"A%1$s", (Object)nAliasIndex);
                    queryGroupItemConfig.setAlias(strAlias);
                }
                sqlGroup.Append("%1$s as %2$s", (Object)strFieldCode, (Object)strAlias);
                if (StringHelper.IsNullOrEmpty((String)queryGroupItemConfig.getOrderDirection())) continue;
                orderMap.put(queryGroupItemConfig.getOrder(), StringHelper.Format((String)"%1$s %2$s", (Object)strAlias, (Object)queryGroupItemConfig.getOrderDirection()));
            }
            sqlGroup.Append(" FROM (%1$s) m3", (Object)strGroupSql);
            strGroupSql = sqlGroup.toString();
        }
        if (!StringHelper.IsNullOrEmpty((String)queryGroupModelConfig.getGroupCond())) {
            sqlGroup.Reset();
            sqlGroup.Append("SELECT m4.*");
            sqlGroup.Append(" FROM (%1$s) m4 where %2$s", (Object)strGroupSql, (Object)queryGroupModelConfig.getGroupCond());
            strGroupSql = sqlGroup.toString();
        }
        if (orderMap.size() > 0) {
            StringBuilderEx sqlGroupEx = new StringBuilderEx();
            sqlGroupEx.Append("SELECT * FROM (%1$s) m2 ", (Object)strGroupSql);
            bFirst = true;
            Iterator iterator2 = orderMap.keySet().iterator();
            while (iterator2.hasNext()) {
                int nValue = (Integer)iterator2.next();
                if (bFirst) {
                    sqlGroupEx.Append(" ORDER BY ");
                    bFirst = false;
                } else {
                    sqlGroupEx.Append(" , ");
                }
                sqlGroupEx.Append((String)orderMap.get(nValue));
            }
            strGroupSql = sqlGroupEx.toString();
        }
        if (queryGroupModelConfig.getTopCount() == 0) {
            return strGroupSql;
        }
        return this.GetFetchTopRowSQL(strGroupSql, queryGroupModelConfig.getTopCount());
    }

    public String GetFetchTopRowSQL(String strSQL, int nTopCount) {
        return strSQL;
    }

    protected String GetDEFieldStatisticsNullConvertCode(IDEFHelper defHelper) {
        String strStaNullConv = defHelper.GetDTColumn().GetStatisticsNullConvert();
        if (!StringHelper.IsNullOrEmpty((String)strStaNullConv)) {
            return StringHelper.Format((String)"(CASE WHEN %1$s IS NULL THEN %2$s ELSE %1$s END)", (Object)defHelper.GetDTColumn().GetFormalColumnName(), (Object)strStaNullConv);
        }
        return defHelper.getName();
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
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + qmDeclare.getDeclareCode();
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + "\n";
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
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
    }

    public void SetFieldQueryCaseSensitive(String strField, String strValue) {
        strField = strField.toUpperCase();
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            this.fieldCaseSensitiveMap.remove(strField);
        } else {
            int nValue = 0;
            String[] values = strValue.split("[;]");
            int i = 0;
            while (i < values.length) {
                if (StringHelper.Compare((String)values[i], (String)"LIKE", (boolean)true) == 0) {
                    nValue |= 2;
                } else if (StringHelper.Compare((String)values[i], (String)"=", (boolean)true) == 0) {
                    nValue |= 1;
                } else if (StringHelper.Compare((String)values[i], (String)"LIKESPLIT", (boolean)true) == 0) {
                    nValue |= 4;
                }
                ++i;
            }
            this.fieldCaseSensitiveMap.put(strField, nValue);
        }
    }

    public boolean isFieldQueryCaseSensitive(String strField, String strCondition) {
        if (!this.fieldCaseSensitiveMap.containsKey(strField = strField.toUpperCase())) {
            return false;
        }
        int nValue = this.fieldCaseSensitiveMap.get(strField);
        if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
            return (nValue & 2) != 0;
        }
        return (nValue & 1) != 0;
    }

    public boolean TestQueryOption(String strField, int nOption) {
        if (!this.fieldCaseSensitiveMap.containsKey(strField = strField.toUpperCase())) {
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
        Object objValue = this.attributeMap.get(strKey = strKey.toUpperCase());
        if (objValue == null) {
            return objDefaultValue;
        }
        return objValue;
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

        URLCondPair() {
        }
    }
}

