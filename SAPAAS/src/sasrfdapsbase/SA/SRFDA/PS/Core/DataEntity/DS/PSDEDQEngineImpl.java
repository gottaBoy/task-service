/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAQueryModelGrooveEngine
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Model.QueryGroupItemConfig
 *  SA.SRFDA.Model.QueryGroupModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.Ctrl.DAQueryModelGrooveEngine;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCustomCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQFieldCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQAlias;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQDeclare;
import SA.SRFDA.PS.Core.DataEntity.DS.SimplePSDEDQMainImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
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

public class PSDEDQEngineImpl
implements IPSDEDQEngine {
    public static final String QMVALUE_ISNULL = "__SRFQMVALUE_ISNULL__";
    public static final String QMVALUE_ISNOTNULL = "__SRFQMVALUE_ISNOTNULL__";
    protected IPSDataEntity majorPSDataEntity = null;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Hashtable<String, String> fieldExpMap = new Hashtable();
    protected Hashtable<String, Integer> fieldDataTypeMap = new Hashtable();
    private static final Log log = LogFactory.getLog(PSDEDQEngineImpl.class);
    protected String strQueryScript = "";
    protected String strQueryScriptTemp = "";
    protected String strQueryScriptWithCondition = "";
    protected ArrayList<CallParam> callParams = new ArrayList();
    protected String strDAQueryModelHelperId = "";
    private int nAliasIndex = 0;
    private ArrayList<String> majorDERList = null;
    private TreeMap<String, Integer> majorDERAliasMap = null;
    private ArrayList<String> majorConditionList = null;
    private DAQueryModelGrooveEngine grooveEngine = null;
    protected TreeMap<String, PSDEDQAlias> qmAliasMap = new TreeMap();
    protected TreeMap<String, PSDEDQDeclare> qmDeclareMap = new TreeMap();
    protected TreeMap<String, Integer> fieldCaseSensitiveMap = new TreeMap();
    public static final int QUERYCASESENSITIVE_EQ = 1;
    public static final int QUERYCASESENSITIVE_LIKE = 2;
    public static final int QUERYOPTION_LIKESPLIT = 4;
    public static final String TAG_DYNAMICTABLES = "__DYNAMICTABLES__";
    private int nMacroIndex = 1;
    protected ArrayList<URLCondPair> urlCondPairList = new ArrayList();
    protected Map<String, Object> macroParams = new TreeMap<String, Object>();
    protected Map<String, String> globalParamMap = new LinkedHashMap<String, String>();
    protected Map<String, Object> attributeMap = new LinkedHashMap<String, Object>();
    protected IPSDBType iPSDBType = null;
    protected ArrayList<IDEDataQueryCodeExp> deDataQueryCodeExpImplList = new ArrayList();
    protected ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondImplList = new ArrayList();
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
        String strValue = this.globalParamMap.get(strMacroParam);
        return strValue;
    }

    public void compile(IPSDEDQMain mainQueryConfig, IPSDEDQMain mainQueryConfig2, boolean bDPControl, ArrayList<ArrayList<IPSDEDQMain>> notQueryConfigs, ArrayList<ArrayList<IPSDEDQMain>> orQueryConfigs) throws Exception {
        this.compileEx(mainQueryConfig, mainQueryConfig2, bDPControl, notQueryConfigs, orQueryConfigs, false);
    }

    /*
     * WARNING - void declaration
     */
    public void compileEx(IPSDEDQMain mainQueryConfig, IPSDEDQMain mainQueryConfig2, boolean bDPControl, ArrayList<ArrayList<IPSDEDQMain>> notQueryConfigs, ArrayList<ArrayList<IPSDEDQMain>> orQueryConfigs, boolean bDelete) throws Exception {
        String string;
        String string2;
        IPSDEField iPSDEField;
        IPSDEDQColumn iPSQMColumn;
        this.bEnablePQL = mainQueryConfig.getPSDEDataQuery().isEnablePQL();
        this.callParams.clear();
        ArrayList<String> mainConditionList = new ArrayList<String>();
        ArrayList<String> derList = new ArrayList<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        derAliasMap.put("", 0);
        this.fieldExpMap.clear();
        this.deDataQueryCodeExpImplList.clear();
        TreeMap<String, String> extSelects = new TreeMap<String, String>();
        StringBuilderEx script = new StringBuilderEx();
        StringBuilderEx scriptTemp = null;
        if (this.majorPSDataEntity.isEnableTempDataBackend()) {
            scriptTemp = new StringBuilderEx();
        }
        TreeMap<String, Integer> selectColumns = new TreeMap<String, Integer>();
        Iterator<IPSDEDQColumn> selectPSQMColumns = mainQueryConfig.getSelectedPSDEDQColumns();
        if (selectPSQMColumns != null) {
            while (selectPSQMColumns.hasNext()) {
                iPSQMColumn = selectPSQMColumns.next();
                selectColumns.put(iPSQMColumn.getName().toUpperCase(), 1);
            }
        }
        if (mainQueryConfig2 != null && (selectPSQMColumns = mainQueryConfig2.getSelectedPSDEDQColumns()) != null) {
            while (selectPSQMColumns.hasNext()) {
                iPSQMColumn = selectPSQMColumns.next();
                selectColumns.put(iPSQMColumn.getName().toUpperCase(), 1);
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
                    Iterator<IPSDERIndexDEFieldMap> psDERIndexDEFieldMaps;
                    PSDEDQColumnImpl psDEDQColumnImpl;
                    IPSDERIndex iPSDERIndex = psDERIndexs.next();
                    if (iPSDERIndex.isInherit()) continue;
                    LinkedHashMap<String, IPSDEField> fieldMap = new LinkedHashMap<String, IPSDEField>();
                    ArrayList<IPSDEDQColumn> psDEDQColumnList = new ArrayList<IPSDEDQColumn>();
                    if (this.majorPSDataEntity.getKeyPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField() != null) {
                        psDEDQColumnImpl = new PSDEDQColumnImpl();
                        psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField().getName());
                        psDEDQColumnList.add(psDEDQColumnImpl);
                        fieldMap.put(this.majorPSDataEntity.getKeyPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField());
                    }
                    if (this.majorPSDataEntity.getMajorPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField() != null) {
                        psDEDQColumnImpl = new PSDEDQColumnImpl();
                        psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField().getName());
                        psDEDQColumnList.add(psDEDQColumnImpl);
                        fieldMap.put(this.majorPSDataEntity.getMajorPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField());
                    }
                    if ((psDERIndexDEFieldMaps = iPSDERIndex.getPSDERIndexDEFieldMaps()) != null) {
                        while (psDERIndexDEFieldMaps.hasNext()) {
                            IPSDERIndexDEFieldMap iPSDERIndexDEFieldMap = psDERIndexDEFieldMaps.next();
                            if (iPSDERIndexDEFieldMap.getMinorPSDEField() == null || iPSDERIndexDEFieldMap.getMajorPSDEField() == null) continue;
                            PSDEDQColumnImpl psDEDQColumnImpl2 = new PSDEDQColumnImpl();
                            psDEDQColumnImpl2.setName(iPSDERIndexDEFieldMap.getMinorPSDEField().getName());
                            psDEDQColumnList.add(psDEDQColumnImpl2);
                            fieldMap.put(iPSDERIndexDEFieldMap.getMajorPSDEField().getName(), iPSDERIndexDEFieldMap.getMinorPSDEField());
                        }
                    }
                    PSDEDQEngineImpl psDEDQEngineImpl = new PSDEDQEngineImpl();
                    psDEDQEngineImpl.init(this.GetDAGlobalHelper(), this.iPSDBType, iPSDERIndex.getMinorPSDataEntity());
                    SimplePSDEDQMainImpl simplePSDEDQMainImpl = new SimplePSDEDQMainImpl();
                    simplePSDEDQMainImpl.init(this.iDAGlobalHelper, iPSDERIndex.getMinorPSDataEntity(), psDEDQColumnList);
                    psDEDQEngineImpl.compile(simplePSDEDQMainImpl);
                    String string3 = psDEDQEngineImpl.getQueryScript();
                    net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
                    ++nIndex;
                    sb.append("SELECT\n");
                    if (this.majorPSDataEntity.getIndexTypePSDEField() == null) {
                        throw new Exception("\u7d22\u5f15\u4e3b\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u7c7b\u578b\u5c5e\u6027");
                    }
                    IPSDEFDTColumn iPSDEFDTColumn = this.majorPSDataEntity.getIndexTypePSDEField().getPSDTColumn(this.getDBType());
                    if (DataTypeHelper.IsStringType((int)this.majorPSDataEntity.getIndexTypePSDEField().getStdDataType())) {
                        sb.append("'%1$s' AS %2$s", (Object)iPSDERIndex.getTypeValue(), (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    } else {
                        sb.append("%1$s AS %2$s", (Object)iPSDERIndex.getTypeValue(), (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    }
                    Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();
                    while (psDEFields.hasNext()) {
                        Object iPSDEFDTColumn2;
                        iPSDEField = psDEFields.next();
                        if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || iPSDEField.isIndexTypeDEField() || !StringHelper.IsNullOrEmpty((String)(iPSDEFDTColumn2 = iPSDEField.getPSDTColumn(this.getDBType())).getFormulaFormat()) && !StringHelper.IsNullOrEmpty((String)iPSDEFDTColumn2.getFormulaColumns())) continue;
                        IPSDEField minorPSDEField = (IPSDEField)fieldMap.get(iPSDEField.getName());
                        if (minorPSDEField == null) {
                            sb.append(",NULL AS %1$s\n", (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn2.getColumnName()));
                            continue;
                        }
                        IPSDEFDTColumn minorPSDEFDTColumn = minorPSDEField.getPSDTColumn(this.getDBType());
                        sb.append(",v%1$s.%2$s AS %3$s\n", (Object)nIndex, (Object)this.iPSDBType.getDBObjStandardName(minorPSDEFDTColumn.getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn2.getColumnName()));
                    }
                    sb.append("FROM\n");
                    sb.append("(%1$s) v%2$s\n", (Object)string3, (Object)nIndex);
                    if (nIndex > 1) {
                        unionAll.append("UNION ALL\n");
                    }
                    unionAll.append(sb.toString());
                }
            }
            if (StringHelper.IsNullOrEmpty((String)(strRealQueryCode = unionAll.toString()))) {
                throw new Exception("\u7d22\u5f15\u4e3b\u5b9e\u4f53\u672a\u5b9a\u4e49\u4efb\u4f55\u7d22\u5f15\u5173\u7cfb");
            }
        }
        boolean bSelectColumn = selectColumns.size() > 0;
        Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEFDTColumn iPSDEFDTColumn;
            IPSDEField iPSDEField2 = psDEFields.next();
            if (iPSDEField2.isDynaStorageDEField() || iPSDEField2.isUIAssistDEField()) continue;
            if (!iPSDEField2.isPhisicalDEField() && iPSDEField2.isLinkDEField()) {
                IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField2;
                boolean bIgnore = false;
                while (iPSLinkDEField != null) {
                    IPSDER1NBase iPSDER1NBase;
                    if (iPSLinkDEField.getPSDER() instanceof IPSDER1NBase && (iPSDER1NBase = (IPSDER1NBase)iPSLinkDEField.getPSDER()).getPickupPSDEField() != null && !iPSDER1NBase.getPickupPSDEField().isPhisicalDEField()) {
                        bIgnore = true;
                        break;
                    }
                    IPSDEField relatedPSDEField = iPSLinkDEField.getRelatedPSDEField();
                    if (!relatedPSDEField.getPSDataEntity().isEnableSQLStorage() && iPSLinkDEField.getPSDataEntity().getVirtualMode() != 5) {
                        bIgnore = true;
                        break;
                    }
                    if (relatedPSDEField.isPhisicalDEField()) {
                        if (!relatedPSDEField.isDynaStorageDEField()) break;
                        bIgnore = true;
                        break;
                    }
                    if (relatedPSDEField.isLinkDEField()) {
                        iPSLinkDEField = (IPSLinkDEField)relatedPSDEField;
                        continue;
                    }
                    if (!relatedPSDEField.isUIAssistDEField()) break;
                    bIgnore = true;
                    break;
                }
                if (bIgnore) {
                    String strMsg = String.format("\u5c5e\u6027[%1$s]\u5f15\u7528\u5b9e\u4f53[%2$s]\u5c5e\u6027[%3$s]\u4e0d\u652f\u6301SQL\u5b58\u50a8\uff0c\u5ffd\u7565", iPSDEField2.getName(), iPSLinkDEField.getRelatedPSDataEntity().getName(), iPSLinkDEField.getRelatedPSDEField().getName());
                    log.warn((Object)strMsg);
                    ((IPSSystemUtil)((Object)this.getPSSystem())).getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u6570\u636e\u67e5\u8be2[%2$s]", this.getMajorPSDataEntity().getName(), mainQueryConfig.getPSDEDataQuery().getName()), strMsg);
                    continue;
                }
            }
            if (!(bSelectColumn && selectColumns.containsKey(iPSDEField2.getName()) || iPSDEField2.isQueryColumn(mainQueryConfig.getPSDEDataQuery().getViewLevel()) && !bSelectColumn || iPSDEField2.isQueryColumn() && selectColumns.containsKey(iPSDEField2.getName()))) {
                if (!iPSDEField2.isPhisicalDEField() && !iPSDEField2.isInheritDEField()) continue;
                iPSDEFDTColumn = iPSDEField2.getPSDTColumn(this.getDBType());
                String strPSDEFieldExp = null;
                if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
                    strPSDEFieldExp = StringHelper.Format((String)"%1$s.%2$s", (Object)"t1", (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    this.setFieldQueryCaseSensitive(strPSDEFieldExp, iPSDEFDTColumn.getQueryCaseSenstive());
                } else {
                    strPSDEFieldExp = this.getPSDEFieldExp(iPSDEField2, "", derAliasMap, derList);
                }
                int nDataType = iPSDEField2.getStdDataType();
                this.fieldDataTypeMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), nDataType);
                this.fieldExpMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), strPSDEFieldExp);
                continue;
            }
            iPSDEFDTColumn = iPSDEField2.getPSDTColumn(this.getDBType());
            String strPSDEFieldExp = null;
            if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
                strPSDEFieldExp = StringHelper.Format((String)"%1$s.%2$s", (Object)"t1", (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                this.setFieldQueryCaseSensitive(strPSDEFieldExp, iPSDEFDTColumn.getQueryCaseSenstive());
            } else {
                strPSDEFieldExp = this.getPSDEFieldExp(iPSDEField2, "", derAliasMap, derList);
            }
            if (iPSDEField2.getStringLength() != -1 && iPSDEField2.getStringLength() > 8000) {
                log.error((Object)StringHelper.Format((String)"\u957f\u6587\u672c\u5c5e\u6027[%1$s]\u653e\u5165\u67e5\u8be2\u4e2d\uff0c\u4f1a\u5f71\u54cd\u68c0\u7d22\u6027\u80fd", (Object)iPSDEField2.getName()));
            }
            extSelects.put(iPSDEFDTColumn.getFormalColumnName().toUpperCase(), strPSDEFieldExp);
            int nDataType = iPSDEField2.getStdDataType();
            this.fieldDataTypeMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), nDataType);
            this.fieldExpMap.put(iPSDEFDTColumn.getColumnName().toUpperCase(), strPSDEFieldExp);
        }
        IPSDEField keyPSDEField = this.majorPSDataEntity.getKeyPSDEField();
        if (keyPSDEField == null) {
            throw PSDataEntityException.create(this.getMajorPSDataEntity(), 20014);
        }
        IPSDEDBConfig majorPSDEDBConfig = this.majorPSDataEntity.getPSDEDBConfig(this.getDBType());
        String strMainTable = majorPSDEDBConfig.getTableName();
        String strUserTable = "";
        String strSaaSDCIdColName = "";
        if (this.majorPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || this.majorPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue()) {
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
                if (realPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || realPSDataEntity.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue()) {
                    strSaaSDCIdColName = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
                }
                if (mainQueryConfig.getPSDEDataQuery().isQueryFromView()) {
                    strMainTable = realPSDataEntity.getPSDEDBConfig(this.getDBType()).getViewName(mainQueryConfig.getPSDEDataQuery().getViewLevel());
                    strUserTable = "";
                }
            }
        }
        boolean bDynamicTable = false;
        if (!StringHelper.IsNullOrEmpty((String)strRealQueryCode)) {
            script.Append("\nFROM (%1$s) t1 \n", (Object)strRealQueryCode);
        } else {
            script.Append("\nFROM %1$s t1 \n", (Object)this.iPSDBType.getDBObjStandardName(strMainTable));
            if (!StringHelper.IsNullOrEmpty((String)strUserTable) && !bDelete) {
                script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable), (Object)this.iPSDBType.getDBObjStandardName(keyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                    script.Append(" AND t2.%1$s = '__SRFSAASDCID__'", (Object)strSaaSDCIdColName);
                }
                script.Append("\n");
            }
            if (scriptTemp != null) {
                scriptTemp.Append("\nFROM %1$s t1 \n", (Object)this.iPSDBType.getDBObjStandardName(String.valueOf(strMainTable) + "_TMP"));
                if (!StringHelper.IsNullOrEmpty((String)strUserTable) && !bDelete) {
                    scriptTemp.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s", (Object)this.iPSDBType.getDBObjStandardName(String.valueOf(strUserTable) + "_TMP"), (Object)this.iPSDBType.getDBObjStandardName(keyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        scriptTemp.Append(" AND t2.%1$s = '__SRFSAASDCID__'", (Object)strSaaSDCIdColName);
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
        if (!StringHelper.IsNullOrEmpty((String)mainQueryConfig.getAlias())) {
            this.qmAliasMap.put(mainQueryConfig.getAlias().toLowerCase(), qmAlias);
        }
        if (mainQueryConfig.getChildPSDEDQJoins() != null) {
            Iterator<IPSDEDQJoin> iterator = mainQueryConfig.getChildPSDEDQJoins();
            while (iterator.hasNext()) {
                String strCondition;
                IPSDEDQJoin joinQueryConfig = iterator.next();
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11M", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEX", (boolean)true) == 0) {
                    this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEXM", (boolean)true) != 0) continue;
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, extSelects);
            }
        }
        if (mainQueryConfig2 != null && mainQueryConfig2.getChildPSDEDQJoins() != null) {
            if (!StringHelper.IsNullOrEmpty((String)mainQueryConfig2.getAlias())) {
                this.qmAliasMap.put(mainQueryConfig2.getAlias().toLowerCase(), qmAlias);
            }
            this.complie(mainQueryConfig2, this.majorPSDataEntity, derAliasMap, derList, mainConditionList, extSelects);
        }
        if (bDPControl) {
            void var25_47;
            void var25_42;
            if (notQueryConfigs != null) {
                for (ArrayList arrayList : notQueryConfigs) {
                    Object conditions;
                    ArrayList listconditions = new ArrayList();
                    for (IPSDEDQMain queryConfig : arrayList) {
                        String strGroupCondition2;
                        if (!StringHelper.IsNullOrEmpty((String)queryConfig.getAlias())) {
                            this.qmAliasMap.put(queryConfig.getAlias().toLowerCase(), qmAlias);
                        }
                        conditions = new ArrayList();
                        this.complie(queryConfig, this.majorPSDataEntity, derAliasMap, derList, (ArrayList<String>)conditions, null);
                        if (queryConfig.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(strGroupCondition2 = this.getGroupCondition(this.majorPSDataEntity, "", queryConfig.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
                            ((ArrayList)conditions).add(strGroupCondition2);
                        }
                        if (((ArrayList)conditions).size() == 0) continue;
                        String strTotalCond = "";
                        Iterator iterator = ((ArrayList)conditions).iterator();
                        while (iterator.hasNext()) {
                            String strCond = (String)iterator.next();
                            if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                            if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                                strTotalCond = String.valueOf(strTotalCond) + " AND ";
                            }
                            strTotalCond = String.valueOf(strTotalCond) + strCond;
                        }
                        if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                        if (queryConfig.isExcludeMode()) {
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
            String string4 = "";
            if (orQueryConfigs != null) {
                for (ArrayList<IPSDEDQMain> orList : orQueryConfigs) {
                    void var25_44;
                    ArrayList<String> listconditions = new ArrayList<String>();
                    for (IPSDEDQMain queryConfig : orList) {
                        String strGroupCondition3;
                        if (!StringHelper.IsNullOrEmpty((String)queryConfig.getAlias())) {
                            this.qmAliasMap.put(queryConfig.getAlias().toLowerCase(), qmAlias);
                        }
                        ArrayList conditions = new ArrayList();
                        this.complie(queryConfig, this.majorPSDataEntity, derAliasMap, derList, conditions, null);
                        if (queryConfig.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(strGroupCondition3 = this.getGroupCondition(this.majorPSDataEntity, "", queryConfig.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
                            conditions.add(strGroupCondition3);
                        }
                        if (conditions.size() == 0) continue;
                        String strTotalCond = "";
                        Iterator iterator = conditions.iterator();
                        while (iterator.hasNext()) {
                            String strCond = (String)iterator.next();
                            if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                            if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                                strTotalCond = String.valueOf(strTotalCond) + " AND ";
                            }
                            strTotalCond = String.valueOf(strTotalCond) + strCond;
                        }
                        if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                        if (queryConfig.isExcludeMode()) {
                            strTotalCond = "NOT" + strTotalCond;
                        }
                        listconditions.add(strTotalCond);
                    }
                    if (listconditions.size() == 0) continue;
                    Object strTotalCond = "";
                    for (String strCond : listconditions) {
                        if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strTotalCond)) {
                            strTotalCond = String.valueOf(strTotalCond) + " AND ";
                        }
                        strTotalCond = String.valueOf(strTotalCond) + strCond;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strTotalCond)) continue;
                    if (!StringHelper.IsNullOrEmpty((String)var25_42)) {
                        String string5 = String.valueOf(var25_42) + " OR ";
                    }
                    String string6 = String.valueOf(var25_44) + "(" + (String)strTotalCond + ")";
                }
            }
            if (StringHelper.IsNullOrEmpty((String)var25_42)) {
                String string7 = "(1<>1)";
            }
            mainConditionList.add((String)var25_47);
        }
        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
            mainConditionList.add(StringHelper.Format((String)"t1.%1$s = '__SRFSAASDCID__'", (Object)strSaaSDCIdColName));
        }
        if (this.majorPSDataEntity.isLogicValid()) {
            IPSDEField iPSDEField2 = this.majorPSDataEntity.getPSDEFieldByPDT("LOGICVALID", false);
            if (iPSDEField2 != null) {
                mainConditionList.add(StringHelper.Format((String)"t1.%1$s = %2$s", (Object)iPSDEField2.getPSDTColumn(this.getDBType()).getFormalColumnName(), (Object)this.majorPSDataEntity.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true)));
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)this.majorPSDataEntity.getFullName()));
            }
        }
        if (this.majorPSDataEntity.isVirtual() && this.majorPSDataEntity.getVirtualMode() == 2) {
            IPSDERInherit iPSDERInherit = this.majorPSDataEntity.getPSDERInherit();
            if (iPSDERInherit != null) {
                IPSDEField indexTypePSDEField = this.majorPSDataEntity.getInheritPSDataEntity().getIndexTypePSDEField();
                Object curIndexTypePSDEField = null;
                psDEFields = this.majorPSDataEntity.getAllPSDEFields();
                while (psDEFields.hasNext()) {
                    iPSDEField = psDEFields.next();
                    if (!(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)((IPSLinkDEField)iPSDEField).getRelatedPSDEField().getId(), (String)indexTypePSDEField.getId(), (boolean)false) != 0) continue;
                    curIndexTypePSDEField = iPSDEField;
                    break;
                }
                if (curIndexTypePSDEField == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u7ee7\u627f\u8bc6\u522b\u5c5e\u6027", (Object)this.majorPSDataEntity.getFullName()));
                }
                String strPSDEFieldExp = this.getPSDEFieldExp((IPSDEField)curIndexTypePSDEField, "", derAliasMap, derList);
                mainConditionList.add(this.getConditionSQL(strPSDEFieldExp, curIndexTypePSDEField.getStdDataType(), "=", iPSDERInherit.getTypeValue(), ""));
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u7ee7\u627f\u5173\u7cfb", (Object)this.majorPSDataEntity.getFullName()));
            }
        }
        if (mainQueryConfig.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(string2 = this.getGroupCondition(this.majorPSDataEntity, "", mainQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
            mainConditionList.add(string2);
        }
        if (mainQueryConfig2 != null && mainQueryConfig2.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(string = this.getGroupCondition(this.majorPSDataEntity, "", mainQueryConfig2.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
            mainConditionList.add(string);
        }
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for (String strDERs : derList) {
            this.getJoin(script, scriptTemp, this.majorPSDataEntity, this.majorPSDataEntity.isEnableTempDataBackend(), "", strDERs, derAliasMap, treeMap);
        }
        this.majorConditionList = mainConditionList;
        if (bDelete) {
            this.strQueryScript = "DELETE \n";
        } else {
            this.strQueryScript = "SELECT\n";
            if (mainQueryConfig.isDistinctMode()) {
                this.strQueryScript = String.valueOf(this.strQueryScript) + " DISTINCT\n";
            }
            int nIndex = 0;
            boolean bFirst = true;
            for (String strColumnName : extSelects.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    this.strQueryScript = String.valueOf(this.strQueryScript) + ",\n";
                }
                String strField = extSelects.get(strColumnName);
                if (StringHelper.Compare((String)majorPSDEDBConfig.getObjNameCase(), (String)"UCASE", (boolean)true) == 0) {
                    strColumnName = strColumnName.toUpperCase();
                } else if (StringHelper.Compare((String)majorPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                    strColumnName = strColumnName.toLowerCase();
                }
                String[] parts = strField.split("[.]");
                String strAlias = this.iPSDBType.getDBObjStandardName(strColumnName);
                this.strQueryScript = parts.length == 2 && StringHelper.Compare((String)parts[1], (String)strAlias, (boolean)false) == 0 ? String.valueOf(this.strQueryScript) + StringHelper.Format((String)"%1$s", (Object)strField) : String.valueOf(this.strQueryScript) + StringHelper.Format((String)"%1$s AS %2$s", (Object)strField, (Object)strAlias);
                DEDataQueryCodeExpImpl deDataQueryCodeExpImpl = new DEDataQueryCodeExpImpl();
                deDataQueryCodeExpImpl.setName(strColumnName);
                deDataQueryCodeExpImpl.setExpression(strField);
                deDataQueryCodeExpImpl.setShowOrder(nIndex);
                ++nIndex;
                this.deDataQueryCodeExpImplList.add(deDataQueryCodeExpImpl);
            }
        }
        if (scriptTemp != null) {
            this.strQueryScriptTemp = this.strQueryScript;
            if (!bDelete) {
                this.strQueryScriptTemp = String.valueOf(this.strQueryScriptTemp) + StringHelper.Format((String)",t1.%1$s AS %1$s,t1.%2$s AS %2$s", (Object)this.iPSDBType.getDBObjStandardName("SRFORIKEY"), (Object)this.iPSDBType.getDBObjStandardName("SRFDRAFTFLAG"));
            }
        }
        this.strQueryScript = String.valueOf(this.strQueryScript) + script.toString();
        if (scriptTemp != null) {
            this.strQueryScriptTemp = String.valueOf(this.strQueryScriptTemp) + scriptTemp.toString();
        }
        this.majorDERList = derList;
        this.majorDERAliasMap = derAliasMap;
        for (String strColumnName : this.fieldExpMap.keySet()) {
            if (extSelects.containsKey(strColumnName)) continue;
            String strExpression = this.fieldExpMap.get(strColumnName);
            DEDataQueryCodeExpImpl deDataQueryCodeExpImpl = new DEDataQueryCodeExpImpl();
            deDataQueryCodeExpImpl.setName(strColumnName);
            deDataQueryCodeExpImpl.setExpression(strExpression);
            deDataQueryCodeExpImpl.setShowOrder(-1);
            this.deDataQueryCodeExpImplList.add(deDataQueryCodeExpImpl);
        }
        for (String strCondition : this.majorConditionList) {
            DEDataQueryCodeCondImpl deDataQueryCodeCondImpl = new DEDataQueryCodeCondImpl();
            deDataQueryCodeCondImpl.setName("");
            deDataQueryCodeCondImpl.setCustomCond(strCondition);
            deDataQueryCodeCondImpl.setShowOrder(-1);
            this.deDataQueryCodeCondImplList.add(deDataQueryCodeCondImpl);
        }
        String strAlias = "";
        for (String strAliasName : this.qmAliasMap.keySet()) {
            if (StringHelper.Compare((String)strAliasName, (String)"MAIN", (boolean)true) == 0) continue;
            PSDEDQAlias psDEDQAlias = this.qmAliasMap.get(strAliasName);
            if (!StringHelper.IsNullOrEmpty((String)strAlias)) {
                strAlias = String.valueOf(strAlias) + ",";
            }
            strAlias = String.valueOf(strAlias) + String.format("ALIAS.%1$s=t%2$s", strAliasName, psDEDQAlias.getAliasIndex() + 1);
        }
        if (!StringHelper.IsNullOrEmpty((String)strAlias)) {
            this.strQueryScript = String.valueOf(this.strQueryScript) + String.format("\r\n/*%1$s*/", strAlias);
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

    /*
     * Unable to fully structure code
     */
    private final void complie(IPSDEDQMain mainQueryConfig, IPSDataEntity iPSDataEntity, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList, ArrayList<String> conditionList, TreeMap<String, String> extSelects) throws Exception {
        psQMJoinQuerys = mainQueryConfig.getChildPSDEDQJoins();
        if (psQMJoinQuerys != null) ** GOTO lbl48
        return;
lbl-1000:
        // 1 sources

        {
            joinQueryConfig = psQMJoinQuerys.next();
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, false, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1RIGHT", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, false, false, true, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, true, false, false, false, false, false, true, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, true, false, false, false, false, false, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11M", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, true, false, false, false, false, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, true, false, false, false, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1N", (boolean)true) == 0) {
                strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
                conditionList.add(strCondition);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
                conditionList.add(strCondition);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NNOT", (boolean)true) == 0) {
                strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, false);
                conditionList.add("NOT(" + strCondition + ")");
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                strCondition = this.buildExistQuery(this.majorPSDataEntity, joinQueryConfig, 0, true);
                conditionList.add("NOT(" + strCondition + ")");
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEX", (boolean)true) == 0) {
                this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, true, false, false, false, extSelects);
                continue;
            }
            if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEXM", (boolean)true) != 0) continue;
            this.buildJoinQuery(this.majorPSDataEntity, joinQueryConfig, "", derAliasMap, derList, conditionList, false, false, false, false, false, true, false, false, extSelects);
lbl48:
            // 14 sources

            ** while (psQMJoinQuerys.hasNext())
        }
lbl49:
        // 1 sources

    }

    public void compileRawCodeMode(String strQuerySQL, String strQueryCond, String strQueryParam, String strQueryField) throws Exception {
        this.strQueryScript = strQuerySQL;
        if (!StringHelper.IsNullOrEmpty((String)strQueryCond)) {
            if (this.majorConditionList == null) {
                this.majorConditionList = new ArrayList();
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
            log.error((Object)e.getMessage(), (Throwable)e);
            throw new Exception(StringHelper.Format((String)"\u52a0\u8f7d\u67e5\u8be2\u53d8\u91cf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()));
        }
        this.fieldExpMap.clear();
        this.fieldDataTypeMap.clear();
        Iterator<IPSDEField> psDEFields = this.majorPSDataEntity.getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
            this.fieldDataTypeMap.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), iPSDEField.getStdDataType());
            this.fieldExpMap.put(iPSDEField.getPSDTColumn(this.getDBType()).getColumnName().toUpperCase(), iPSDEField.getPSDTColumn(this.getDBType()).getColumnName());
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
        for (URLCondPair condPair : this.urlCondPairList) {
            String strCond;
            String strParamValue = webContext.GetParamValue(condPair.strURLParam);
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    public String replaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext, boolean bTestPost) throws Exception {
        for (URLCondPair condPair : this.urlCondPairList) {
            String strCond;
            String strParamValue = webContext.GetParamValue(condPair.strURLParam);
            if (StringHelper.IsNullOrEmpty((String)strParamValue) && bTestPost) {
                strParamValue = webContext.GetPostValue(condPair.strURLParam.toLowerCase());
            }
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    public String replaceURLParamMacro(String strFinalScript, ISRFExWebContext webContext) throws Exception {
        return this.replaceURLParamMacro(strFinalScript, webContext, false);
    }

    public String replaceDynamicTableMacro(String strFinalScript, ArrayList<String> dynamicTables) throws Exception {
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

    public String getQueryModelScript(ArrayList<String> userConditionList) {
        ArrayList<String> conditionList = userConditionList;
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

    public String getQueryModelScriptEx(ArrayList<String> userConditionList, ISRFExWebContext webContext) throws Exception {
        ArrayList<String> conditionList = userConditionList;
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
            strFinalScript = StringHelper.IsNullOrEmpty((String)strParamValue) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : (StringHelper.IsNullOrEmpty((String)(strCond = this.getConditionSQL(condPair.strFieldName, condPair.nDataType, condPair.strCondition, strParamValue, ""))) ? strFinalScript.replace(condPair.strMacro, condPair.bAll ? "1=1" : "1<>1") : strFinalScript.replace(condPair.strMacro, strCond));
        }
        return strFinalScript;
    }

    public void fillQMDeclareParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId) {
        this.fillQMDeclareParams(list, webContext, iDAGlobalHelper, strCurPersonId, null);
    }

    public void fillQMDeclareParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId, BaseDataEntity baseDataEntity) {
        CallResult callResult = null;
        for (String strName : this.qmDeclareMap.keySet()) {
            PSDEDQDeclare qmDeclare = this.qmDeclareMap.get(strName);
            for (CallParam callParam : qmDeclare.getParams()) {
                Object objValue;
                CallParam cp = callParam.Clone();
                callResult = MacroHelper.GetValue((String)cp.getParamName(), (ISRFDAWebContext)webContext, (ISRFDAGlobalHelper)iDAGlobalHelper, (String)strCurPersonId, (BaseDataEntity)baseDataEntity);
                if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                    cp.setValue(objValue);
                }
                list.add(cp);
            }
        }
    }

    public void fillCallParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId, BaseDataEntity baseDataEntity) {
        CallResult callResult = null;
        for (CallParam callParam : this.callParams) {
            Object objValue;
            CallParam cp = callParam.Clone();
            callResult = MacroHelper.GetValue((String)cp.getParamName(), (ISRFDAWebContext)webContext, (ISRFDAGlobalHelper)iDAGlobalHelper, (String)strCurPersonId, (BaseDataEntity)baseDataEntity);
            if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                cp.setValue(objValue);
            }
            list.add(cp);
        }
    }

    public void fillCallParams(ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId) {
        this.fillCallParams(list, webContext, iDAGlobalHelper, strCurPersonId, null);
    }

    public void fillMajorConditions(ArrayList<String> list) {
        if (this.majorConditionList == null) {
            return;
        }
        for (String strCondition : this.majorConditionList) {
            list.add(strCondition);
        }
    }

    private void buildJoinQuery(IPSDataEntity iPSDataEntity, IPSDEDQJoin joinQueryConfig, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList, ArrayList<String> mainConditionList, boolean bN1, boolean b11, boolean b11M, boolean b1NLEFTOUTER, boolean bIndex, boolean bIndexM, boolean bCustom, boolean bN1RIGHT, TreeMap<String, String> extSelects) throws Exception {
        String strGroupCondition;
        Iterator<IPSDEDQColumn> psDEDQColumns;
        String strNewDER;
        IPSDERBase derBase;
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (iPSDataEntity == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
        }
        if (!iPSDataEntity.isEnableSQLStorage()) {
            log.warn((Object)String.format("\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301SQL\u5b58\u50a8\uff0c\u5ffd\u7565\u8fde\u63a5", iPSDataEntity.getName()));
            return;
        }
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
                derBase = this.getPSSystem().getPSDER(strDERID);
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
            derBase = this.getPSSystem().getPSDER(strDERID);
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
        IPSDataEntity iCurDEHelper = this.getPSDataEntity(strMajorDEID);
        if (extSelects != null && (psDEDQColumns = joinQueryConfig.getSelectedPSDEDQColumns()) != null) {
            while (psDEDQColumns.hasNext()) {
                IPSDEDQColumn iPSDEDQColumn = psDEDQColumns.next();
                IPSDEField iPSDEField = iCurDEHelper.getPSDEField(iPSDEDQColumn.getName(), false);
                String strFieldName = this.getPSDEFieldExp(iPSDEField, strNewDER, derAliasMap, derList);
                extSelects.put(iPSDEDQColumn.getAlias(), strFieldName);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)joinQueryConfig.getAlias())) {
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
                String strCondition;
                IPSDEDQJoin subjoinQueryConfig = psDEDQJoinsIterator.next();
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"N1", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"11", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"11M", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, false);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, subjoinQueryConfig, nCurAliasIndex, true);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"INDEX", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, extSelects);
                    continue;
                }
                if (StringHelper.Compare((String)subjoinQueryConfig.getJoinType(), (String)"INDEXM", (boolean)true) != 0) continue;
                this.buildJoinQuery(iCurDEHelper, subjoinQueryConfig, strNewDER, derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, extSelects);
            }
        }
        if (joinQueryConfig.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(strGroupCondition = this.getGroupCondition(iCurDEHelper, strNewDER, joinQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
            mainConditionList.add(strGroupCondition);
        }
    }

    protected String buildExistQuery(IPSDataEntity iPSDataEntity, IPSDEDQJoin existQueryConfig, int nAlias, boolean bCustom) throws Exception {
        String strGroupCondition;
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (iPSDataEntity == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
        }
        if (!iPSDataEntity.isEnableSQLStorage()) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301SQL\u5b58\u50a8", (Object)iPSDataEntity.getName()));
        }
        String strDERID = existQueryConfig.getDERId();
        ArrayList<String> mainConditionList = new ArrayList<String>();
        ArrayList<String> derList = new ArrayList<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        IPSDataEntity iCurDEHelper = null;
        int nCurAliasIndex = -1;
        StringBuilderEx script = new StringBuilderEx();
        boolean bFirst = true;
        if (bCustom) {
            IPSDERCustom der1N = (IPSDERCustom)this.getPSSystem().getPSDER(strDERID);
            iCurDEHelper = this.getPSDataEntity(der1N.getMinorPSDEId());
            nCurAliasIndex = this.getAliasIndex();
            if (!StringHelper.IsNullOrEmpty((String)existQueryConfig.getAlias())) {
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
            if (StringHelper.Compare((String)iCurDEHelper.getDBSchema(), (String)this.majorPSDataEntity.getDBSchema(), (boolean)true) != 0) {
                strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.getDBSchema(), (Object)strMainTable);
                strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.getDBSchema(), (Object)strUserTable);
            }
            derAliasMap.put("", nCurAliasIndex);
            script.Append("SELECT * FROM %1$s t%2$s \n", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)(nCurAliasIndex + 1));
            if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                script.Append("INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s\n", (Object)this.iPSDBType.getDBObjStandardName(strUserTable2), (Object)this.iPSDBType.getDBObjStandardName(pKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)(nCurAliasIndex + 1), (Object)(nCurAliasIndex + 2));
            }
            if (iCurDEHelper.isLogicValid()) {
                IPSDEField iValidDEFHelper = iCurDEHelper.getPSDEFieldByPDT("LOGICVALID", false);
                mainConditionList.add(StringHelper.Format((String)"t%3$s.%1$s = %2$s", (Object)this.iPSDBType.getDBObjStandardName(iValidDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)iCurDEHelper.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true), (Object)(nCurAliasIndex + 1)));
            }
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u5173\u7cfb");
        }
        nCurAliasIndex = this.getAliasIndex();
        IPSDERBase derBase = this.getPSSystem().getPSDER(strDERID);
        if (!StringHelper.IsNullOrEmpty((String)existQueryConfig.getAlias())) {
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
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)iCurDEHelper.getFullName()));
        }
        if (pickupDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e0e\u76f8\u5173\u5b9e\u4f53\u7684\u5173\u7cfb\u5c5e\u6027 ", (Object)iCurDEHelper.getFullName()));
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
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027 ", (Object)pickupDEFHelper.getFullName()));
            }
        }
        if (StringHelper.Compare((String)pickupRelatedDEFHelper.getPSDataEntity().getId(), (String)iPSDataEntity.getId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u7684\u5b9e\u4f53\u4e0e\u4e0a\u7ea7\u5b9e\u4f53\u4e0d\u4e00\u81f4 ", (Object)pickupDEFHelper.getFullName()));
        }
        String strMainTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
        String strUserTable = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
        String strMainTable2 = strMainTable;
        String strUserTable2 = strUserTable;
        String strSaaSDCIdColName = "";
        if (iCurDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || iCurDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue()) {
            strSaaSDCIdColName = iCurDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
        }
        if (StringHelper.Compare((String)iCurDEHelper.getDBSchema(), (String)this.majorPSDataEntity.getDBSchema(), (boolean)true) != 0) {
            strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.getDBSchema(), (Object)strMainTable);
            strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iCurDEHelper.getDBSchema(), (Object)strUserTable);
        }
        derAliasMap.put("", nCurAliasIndex);
        script.Append("SELECT * FROM %1$s t%2$s \n", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)(nCurAliasIndex + 1));
        if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
            script.Append("INNER JOIN %1$s t%4$s ON t%3$s.%2$s = t%4$s.%2$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable2), (Object)this.iPSDBType.getDBObjStandardName(pKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)(nCurAliasIndex + 1), (Object)(nCurAliasIndex + 2));
            if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                script.Append(" AND t%1$s.%2$s = '__SRFSAASDCID__'", (Object)(nCurAliasIndex + 2), (Object)strSaaSDCIdColName);
            }
            script.Append("\n");
        }
        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
            mainConditionList.add(StringHelper.Format((String)"t%1$s.%2$s = '__SRFSAASDCID__'", (Object)(nCurAliasIndex + 1), (Object)strSaaSDCIdColName));
        }
        if (iCurDEHelper.isLogicValid()) {
            IPSDEField iValidDEFHelper = iCurDEHelper.getPSDEFieldByPDT("LOGICVALID", false);
            if (iValidDEFHelper != null) {
                mainConditionList.add(StringHelper.Format((String)"t%3$s.%1$s = %2$s", (Object)this.iPSDBType.getDBObjStandardName(iValidDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)iCurDEHelper.getPSDEDBConfig(this.getDBType()).getLogicValidSQLCode(true), (Object)(nCurAliasIndex + 1)));
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)iCurDEHelper.getFullName()));
            }
        }
        boolean bMT = true;
        bMT = StringHelper.Compare((String)pickupDEFHelper.getPSDTColumn(this.getDBType()).getRealTableName(), (String)strMainTable, (boolean)true) == 0;
        mainConditionList.add(StringHelper.Format((String)"t%1$s.%3$s = t%2$s.%4$s", (Object)(nAlias + 1), (Object)(nCurAliasIndex + (bMT ? 1 : 2)), (Object)this.iPSDBType.getDBObjStandardName(pickupRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(pickupDEFHelper.getPSDTColumn(this.getDBType()).getColumnName())));
        if (derCustom != null) {
            String strFieldName;
            IPSDEField parentType = iCurDEHelper.getParentTypePSDEField();
            IPSDEField parentSubType = iCurDEHelper.getPSDEFieldByPDT("PARENTSUBTYPE", true);
            if (parentType != null) {
                strFieldName = String.format("t%1$s.%2$s", nCurAliasIndex + (bMT ? 1 : 2), this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName()));
                mainConditionList.add(parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null));
            }
            if (parentSubType != null) {
                strFieldName = String.format("t%1$s.%2$s", nCurAliasIndex + (bMT ? 1 : 2), this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName()));
                String strTypeValue = derCustom.getTypeValue();
                if (StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                    strTypeValue = derCustom.getMinorCodeName();
                }
                if (!StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                    mainConditionList.add(parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null));
                } else {
                    mainConditionList.add(parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null));
                }
            }
        }
        if (existQueryConfig.getChildPSDEDQJoins() != null) {
            Iterator<IPSDEDQJoin> childPSDEDQJoins = existQueryConfig.getChildPSDEDQJoins();
            while (childPSDEDQJoins.hasNext()) {
                String strCondition;
                IPSDEDQJoin joinQueryConfig = childPSDEDQJoins.next();
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, false, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"N1RIGHT", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, false, false, true, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOMN1", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, true, false, false, false, false, false, true, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, true, false, false, false, false, false, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"11M", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, true, false, false, false, false, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NLEFTOUT", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, true, false, false, false, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1N", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                    mainConditionList.add(strCondition);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, false);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"CUSTOM1NNOT", (boolean)true) == 0) {
                    strCondition = this.buildExistQuery(iCurDEHelper, joinQueryConfig, nCurAliasIndex, true);
                    mainConditionList.add("NOT(" + strCondition + ")");
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEX", (boolean)true) == 0) {
                    this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, true, false, false, false, null);
                    continue;
                }
                if (StringHelper.Compare((String)joinQueryConfig.getJoinType(), (String)"INDEXM", (boolean)true) != 0) continue;
                this.buildJoinQuery(iCurDEHelper, joinQueryConfig, "", derAliasMap, derList, mainConditionList, false, false, false, false, false, true, false, false, null);
            }
        }
        if (existQueryConfig.getPSDEDQGroupCondition() != null && !StringHelper.IsNullOrEmpty((String)(strGroupCondition = this.getGroupCondition(iCurDEHelper, "", existQueryConfig.getPSDEDQGroupCondition(), derAliasMap, derList)))) {
            mainConditionList.add(strGroupCondition);
        }
        TreeMap<String, Integer> joinMap = new TreeMap<String, Integer>();
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
                script.Append(" %1$s ", (Object)strCondition);
            }
        }
        return "EXISTS(" + script.toString() + ")";
    }

    public String getGroupCondition(IPSDEDQGroupCondition iPSDEDQGroupCondition) throws Exception {
        return this.getGroupCondition(this.majorPSDataEntity, "", iPSDEDQGroupCondition, this.majorDERAliasMap, this.majorDERList);
    }

    public String getPSDEFieldExp(String strDEField) throws Exception {
        IPSDEField iPSDEField = this.majorPSDataEntity.getPSDEField(strDEField);
        if (iPSDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5bf9\u8c61", (Object)strDEField));
        }
        return this.getPSDEFieldExp(iPSDEField);
    }

    public String getPSDEFieldExp(IPSDEField iPSDEField) throws Exception {
        return this.getPSDEFieldExp(iPSDEField, "", this.majorDERAliasMap, this.majorDERList);
    }

    public int getMajorDERAlias(String strDERId) {
        if (this.majorDERAliasMap.containsKey(strDERId)) {
            return this.majorDERAliasMap.get(strDERId);
        }
        return -1;
    }

    protected String getGroupCondition(IPSDataEntity iPSDataEntity, String strParentDER, IPSDEDQGroupCondition iPSDEDQGroupCondition, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
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
            String strCond;
            IPSDEDQCondition iPSDEDQCondition = psDEDQConditions.next();
            if (iPSDEDQCondition instanceof IPSDEDQGroupCondition) {
                String strCond2 = this.getGroupCondition(iPSDataEntity, strParentDER, (IPSDEDQGroupCondition)iPSDEDQCondition, derAliasMap, derList);
                if (!StringHelper.IsNullOrEmpty((String)strCond2)) {
                    strCond2 = strCond2.trim();
                }
                if (StringHelper.IsNullOrEmpty((String)strCond2)) continue;
                if (bHasCondition) {
                    if (StringHelper.Compare((String)iPSDEDQGroupCondition.getCondOp(), (String)"AND", (boolean)true) == 0) {
                        script.Append(" AND ");
                    } else {
                        script.Append(" OR ");
                    }
                }
                script.Append(" %1$s ", (Object)strCond2);
                bHasCondition = true;
                continue;
            }
            if (iPSDEDQCondition instanceof IPSDEDQFieldCondition) {
                IPSDEDQFieldCondition iPSDEDQFieldCondition = (IPSDEDQFieldCondition)iPSDEDQCondition;
                strCond = this.getSingleCondition(iPSDataEntity, strParentDER, iPSDEDQFieldCondition, derAliasMap, derList);
                if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                    strCond = strCond.trim();
                }
                if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
                if (bHasCondition) {
                    if (StringHelper.Compare((String)iPSDEDQGroupCondition.getCondOp(), (String)"AND", (boolean)true) == 0) {
                        script.Append(" AND ");
                    } else {
                        script.Append(" OR ");
                    }
                }
                script.Append(" %1$s ", (Object)strCond);
                bHasCondition = true;
                continue;
            }
            if (!(iPSDEDQCondition instanceof IPSDEDQCustomCondition)) continue;
            IPSDEDQCustomCondition iPSDEDQCustomCondition = (IPSDEDQCustomCondition)iPSDEDQCondition;
            strCond = this.getCustomCondition(iPSDataEntity, strParentDER, iPSDEDQCustomCondition, derAliasMap, derList);
            if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                strCond = strCond.trim();
            }
            if (StringHelper.IsNullOrEmpty((String)strCond)) continue;
            if (bHasCondition) {
                if (StringHelper.Compare((String)iPSDEDQGroupCondition.getCondOp(), (String)"AND", (boolean)true) == 0) {
                    script.Append(" AND ");
                } else {
                    script.Append(" OR ");
                }
            }
            script.Append(" %1$s ", (Object)strCond);
            bHasCondition = true;
        }
        script.Append(")");
        if (bHasCondition) {
            return script.toString();
        }
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String getSingleCondition(IPSDataEntity iPSDataEntity, String strParentDER, IPSDEDQFieldCondition iPSDEDQFieldCondition, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
        if (iPSDataEntity == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
        }
        IPSDEField iPSDEField = iPSDataEntity.getPSDEField(iPSDEDQFieldCondition.getPSDEFId());
        if (iPSDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]", (Object)iPSDEDQFieldCondition.getPSDEFId()));
        }
        String strFieldName = this.getPSDEFieldExp(iPSDEField, strParentDER, derAliasMap, derList);
        String strFunc = iPSDEDQFieldCondition.getPSSysDBVFId();
        if (StringHelper.IsNullOrEmpty((String)strFunc)) {
            String strTag;
            String strDEDQFieldCondTempl;
            String strParamName = iPSDEDQFieldCondition.getPSVARTypeId();
            String strParamValue = iPSDEDQFieldCondition.getCondValue();
            if (this.globalParamMap.containsKey(strParamName)) {
                strParamValue = this.globalParamMap.get(strParamName);
                strParamName = "";
            }
            String strCode = null;
            if (StringHelper.IsNullOrEmpty((String)strParamName) || !this.isEnablePQL()) {
                strCode = iPSDEField.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, iPSDEDQFieldCondition.getCondOp(), strParamValue, strParamName, iPSDEDQFieldCondition.getVARTypeParam());
            } else {
                String strDefaultParamName = "__PARAM__NAME__";
                String strDefaultParamName2 = "__PARAM__PARAM__";
                String strDefaultFuncName = "srf" + strDefaultParamName.toLowerCase();
                strCode = iPSDEField.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, iPSDEDQFieldCondition.getCondOp(), strParamValue, strDefaultParamName, strDefaultParamName2);
                int nPos = strCode.indexOf(strDefaultFuncName);
                if (nPos == -1) throw new Exception(String.format("\u8bed\u53e5[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strCode));
                StringBuilder sb = new StringBuilder();
                String strPart1 = strCode.substring(0, nPos);
                int nPos2 = strPart1.lastIndexOf("$");
                if (nPos2 == -1) {
                    throw new Exception(String.format("\u8bed\u53e5[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strCode));
                }
                sb.append(strPart1.substring(0, nPos2));
                String strPart2 = strCode.substring(nPos + strDefaultFuncName.length());
                strPart2 = strPart2.trim();
                nPos2 = strPart2.indexOf("'" + strDefaultParamName2 + "'");
                if (nPos2 == -1) throw new Exception(String.format("\u8bed\u53e5[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strCode));
                strPart1 = strPart2.substring(0, nPos2);
                strPart1 = strPart1.trim();
                strPart1 = strPart1.substring(1);
                strPart1 = strPart1.substring(0, strPart1.length() - 1);
                if (StringHelper.Compare((String)strParamName, (String)"PQL", (boolean)false) == 0) {
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
                if ((strPart2 = strPart2.trim()).length() > 0) {
                    strPart2 = strPart2.substring(1);
                }
                sb.append(strPart2);
                strCode = sb.toString();
            }
            if (StringHelper.IsNullOrEmpty((String)strCode)) return strCode;
            if (StringHelper.IsNullOrEmpty((String)(strCode = strCode.trim()))) return strCode;
            if (this.getMajorPSDataEntity().getPSSysSFPub() != null && this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle() != null && !StringHelper.IsNullOrEmpty((String)(strDEDQFieldCondTempl = this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle().getStyleParam("%DEDQ_FIELDCOND%", "")))) {
                HashMap<String, Object> params = new HashMap<String, Object>();
                params.put("dbtype", this.getDBType());
                params.put("code", strCode);
                params.put("cond", iPSDEDQFieldCondition);
                params.put("field", strFieldName);
                return PSTemplHelper.generateCode(strDEDQFieldCondTempl, params);
            }
            if (this.isUseRazorEngine()) {
                if (StringHelper.IsNullOrEmpty((String)iPSDEDQFieldCondition.getPSVARTypeId())) return strCode;
                strTag = StringHelper.Format((String)"${srf%1$s('%2$s','%3$s')}", (Object)iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(), (Object)iPSDEDQFieldCondition.getCondValue(), (Object)iPSDEDQFieldCondition.getVARTypeParam());
                String strParam = iPSDEDQFieldCondition.getVARTypeParam();
                if (!StringHelper.IsNullOrEmpty((String)strParam)) {
                    strParam = strParam.replace("\"", "\\\"\"");
                }
                String strEmptyCond = "";
                String strTag2 = StringHelper.Format((String)"@Model.GetFunc(\"\"%1$s\"\").GetCode(\"\"%2$s\"\",\"\"%3$s\"\",\"\"%4$s\"\")", (Object)iPSDEDQFieldCondition.getPSVARTypeId(), (Object)iPSDEDQFieldCondition.getCondValue(), (Object)strParam, (Object)strEmptyCond);
                if (strCode.indexOf(strTag) == -1) return strCode;
                return strCode.replace(strTag, strTag2);
            }
            if (!iPSDEDQFieldCondition.isIgnoreEmpty()) return strCode;
            if (StringHelper.IsNullOrEmpty((String)iPSDEDQFieldCondition.getPSVARTypeId())) return strCode;
            if (this.isEnablePQL()) {
                if (StringHelper.Compare((String)strParamName, (String)"PQL", (boolean)false) == 0) return strCode;
                return StringHelper.Format((String)"%1$sIF('%2$s', %3$s)", (Object)strParamName, (Object)iPSDEDQFieldCondition.getCondValue(), (Object)strCode);
            }
            strTag = StringHelper.Format((String)"${srf%1$s('%2$s','%3$s')}", (Object)iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(), (Object)iPSDEDQFieldCondition.getCondValue(), (Object)iPSDEDQFieldCondition.getVARTypeParam());
            if (strCode.indexOf(strTag) == -1) return StringHelper.Format((String)"<#assign _value=srf%2$s('%3$s','%4$s')><#if _value?length gt 0>%1$s<#else>1=1</#if>", (Object)strCode, (Object)iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(), (Object)iPSDEDQFieldCondition.getCondValue(), (Object)iPSDEDQFieldCondition.getVARTypeParam());
            strCode = strCode.replace(strTag, "${_value}");
            return StringHelper.Format((String)"<#assign _value=srf%2$s('%3$s','%4$s')><#if _value?length gt 0>%1$s<#else>1=1</#if>", (Object)strCode, (Object)iPSDEDQFieldCondition.getPSVARTypeId().toLowerCase(), (Object)iPSDEDQFieldCondition.getCondValue(), (Object)iPSDEDQFieldCondition.getVARTypeParam());
        }
        String strParamName = iPSDEDQFieldCondition.getPSVARTypeId();
        String strParamValue = iPSDEDQFieldCondition.getCondValue();
        if (this.globalParamMap.containsKey(strParamName)) {
            strParamValue = this.globalParamMap.get(strParamName);
            strParamName = "";
        }
        IPSSysDBValueFunc iPSSysDBValueFunc = this.getPSSystem().getPSSysDBValueFunc(strFunc);
        IDBFunction iDBFunction = this.iPSDBType.getDBFunction(iPSSysDBValueFunc.getCodeName());
        return iPSDEField.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, iDBFunction, iPSDEDQFieldCondition.getCondOp(), strParamValue, strParamName, iPSDEDQFieldCondition.getVARTypeParam());
    }

    protected String getCustomCondition(IPSDataEntity iPSDataEntity, String strParentDER, IPSDEDQCustomCondition iPSDEDQCustomCondition, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
        String strDEDQCustomCondTempl;
        if (this.getMajorPSDataEntity().getPSSysSFPub() != null && this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle() != null && !StringHelper.IsNullOrEmpty((String)(strDEDQCustomCondTempl = this.getMajorPSDataEntity().getPSSysSFPub().getPSSFStyle().getStyleParam("%DEDQ_CUSTOMCOND%", "")))) {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("dbtype", this.getDBType());
            params.put("code", iPSDEDQCustomCondition.getCondition());
            params.put("cond", iPSDEDQCustomCondition);
            String strResult = PSTemplHelper.generateCode(strDEDQCustomCondTempl, params);
            return strResult;
        }
        return iPSDEDQCustomCondition.getCondition();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void getJoin(StringBuilderEx script, StringBuilderEx scriptTemp, IPSDataEntity iPSDataEntity, boolean bEnableTemp, String strParentDERs, String strDER, TreeMap<String, Integer> derAliasMap, TreeMap<String, Integer> joinMap) throws Exception {
        IPSDER1NBase iPSDER1NBase;
        if (StringHelper.IsNullOrEmpty((String)strDER)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u8fde\u63a5\u5173\u7cfb"));
        }
        String[] strDERs = strDER.split("[|]");
        String strCurDERId = strDERs[0];
        String strCurTotalDER = strParentDERs;
        if (!StringHelper.IsNullOrEmpty((String)strCurTotalDER)) {
            strCurTotalDER = String.valueOf(strCurTotalDER) + "|";
        }
        strCurTotalDER = String.valueOf(strCurTotalDER) + strCurDERId;
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
        if (iPSDERBase instanceof IPSDER1NBase && (iPSDER1NBase = (IPSDER1NBase)iPSDERBase).getPickupPSDEField() != null && !iPSDER1NBase.getPickupPSDEField().isPhisicalDEField()) {
            return;
        }
        if (derCustom != null) {
            joinDEFHelper = derCustom.getPickupPSDEField();
        } else {
            IPSLinkDEField linkDEFHelper;
            IPSDEField iPSDEField;
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                iPSDEField = psDEFields.next();
                if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !iPSDEField.isLinkDEField() || !(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)(linkDEFHelper = (IPSLinkDEField)iPSDEField).getDERId(), (String)strCurDERId, (boolean)true) != 0 && (!bRightJoin || StringHelper.Compare((String)linkDEFHelper.getDERId(), (String)strCurDERId.substring(4), (boolean)true) != 0)) continue;
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                    joinDEFHelper = iPSDEField;
                    break;
                }
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
                bInheritMode = true;
                iNextDEHelper = linkDEFHelper.getRelatedPSDEField().getPSDataEntity();
                break;
            }
            if (joinDEFHelper == null && iNextDEHelper == null && (iPSDataEntity.getPSDERInherit() != null && iPSDataEntity.getPSDERInherit().isSameTable() || iPSDataEntity.getVirtualMode() == 5)) {
                bSameTable = true;
                psDEFields = iPSDataEntity.getPSDEFields();
                while (psDEFields.hasNext()) {
                    iPSDEField = psDEFields.next();
                    if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !iPSDEField.isLinkDEField() || !(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0 || (linkDEFHelper = (linkDEFHelper = (IPSLinkDEField)iPSDEField).getRelatedPSDEField() instanceof IPSLinkDEField ? (IPSLinkDEField)linkDEFHelper.getRelatedPSDEField() : null) == null) continue;
                    iPSDEField = linkDEFHelper;
                    if (StringHelper.Compare((String)linkDEFHelper.getDERId(), (String)strCurDERId, (boolean)true) != 0 && (!bRightJoin || StringHelper.Compare((String)linkDEFHelper.getDERId(), (String)strCurDERId.substring(4), (boolean)true) != 0)) continue;
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                        joinDEFHelper = iPSDEField;
                        break;
                    }
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
                    bInheritMode = true;
                    iNextDEHelper = linkDEFHelper.getRelatedPSDEField().getPSDataEntity();
                    break;
                }
            }
        }
        if (bInheritMode) {
            if (!joinMap.containsKey(strCurTotalDER)) {
                IPSDEField pkeyPSDEField;
                String strPreFix = "t";
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    }
                    Integer nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                String strCurMTAlias = "";
                String strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                }
                Integer nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                boolean bJoinAsMain = true;
                IPSDEField iKeyDEFHelper = iPSDataEntity.getKeyPSDEField();
                bJoinAsMain = StringHelper.Compare((String)iKeyDEFHelper.getPSDTColumn(this.getDBType()).getTableScope(), (String)iPSDataEntity.getTableName(), (boolean)true) == 0;
                String strMainTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
                String strUserTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
                String strMainTable2 = strMainTable;
                String strUserTable2 = strUserTable;
                String strMainTable3 = strMainTable;
                String strUserTable3 = strUserTable;
                if (iNextDEHelper.isEnableTempDataBackend() && bEnableTemp) {
                    strMainTable3 = String.valueOf(strMainTable) + "_TMP";
                    if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                        strUserTable3 = String.valueOf(strUserTable) + "_TMP";
                    }
                }
                String strSaaSDCIdColName = "";
                if (iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue()) {
                    strSaaSDCIdColName = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
                }
                if (StringHelper.Compare((String)iNextDEHelper.getDBSchema(), (String)this.majorPSDataEntity.getDBSchema(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strUserTable);
                    strMainTable3 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strMainTable3);
                    strUserTable3 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strUserTable3);
                }
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(iKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(iNextDEHelper.getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName()));
                if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                    script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                }
                script.Append("\n");
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    pkeyPSDEField = iNextDEHelper.getKeyPSDEField();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable2), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurUTAlias, (Object)strSaaSDCIdColName);
                    }
                    script.Append("\n");
                }
                if (scriptTemp != null) {
                    scriptTemp.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable3), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(iKeyDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(iNextDEHelper.getKeyPSDEField().getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                    }
                    script.Append("\n");
                    if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                        pkeyPSDEField = iNextDEHelper.getKeyPSDEField();
                        scriptTemp.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable3), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                            script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurUTAlias, (Object)strSaaSDCIdColName);
                        }
                        script.Append("\n");
                    }
                }
                joinMap.put(strCurTotalDER, 1);
            }
            String strNextDERId = "";
            int i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                return;
            }
            this.getJoin(script, scriptTemp, iNextDEHelper, bEnableTemp, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
            return;
        } else {
            boolean bLeftOuterJoin = false;
            boolean bNextEnableTemp = false;
            IPSDEField joinRelatedDEFHelper = null;
            if (joinDEFHelper == null) {
                IPSLinkDEField linkDEFHelper;
                IPSDEField iPSDEField;
                Iterator<IPSDEField> psDEFields;
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
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)derBase.getMajorPSDEId(), (boolean)true) != 0) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iPSDataEntity.getFullName(), (Object)strTempCurDERId));
                    }
                    iNextDEHelper = this.getPSDataEntity(derBase.getMinorPSDEId());
                    if (iNextDEHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)derBase.getMinorPSDEId()));
                    }
                    psDEFields = iNextDEHelper.getPSDEFields();
                    while (psDEFields.hasNext()) {
                        iPSDEField = psDEFields.next();
                        if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !iPSDEField.isLinkDEField() || !(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)(linkDEFHelper = (IPSLinkDEField)iPSDEField).getDERId(), (String)strTempCurDERId, (boolean)true) != 0 || StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                        joinRelatedDEFHelper = iPSDEField;
                        joinDEFHelper = linkDEFHelper.getRelatedPSDEField();
                        break;
                    }
                    if (joinRelatedDEFHelper == null) {
                        if (derCustom != null) {
                            joinRelatedDEFHelper = derCustom.getPickupPSDEField();
                            joinDEFHelper = derBase.getMajorPSDataEntity().getKeyPSDEField();
                        }
                        if (joinRelatedDEFHelper == null) {
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iNextDEHelper.getFullName(), (Object)strCurDERId));
                        }
                    }
                    bLeftOuterJoin = true;
                } else if (strCurDERId.indexOf("11M:") == 0) {
                    strTempCurDERId = strCurDERId.substring(4);
                    IPSDER11 der11 = (IPSDER11)this.getPSSystem().getPSDER(strTempCurDERId);
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)der11.getMajorPSDEId(), (boolean)true) != 0) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iPSDataEntity.getFullName(), (Object)strTempCurDERId));
                    }
                    iNextDEHelper = this.getPSDataEntity(der11.getMinorPSDEId());
                    if (iNextDEHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)der11.getMinorPSDEId()));
                    }
                    psDEFields = iNextDEHelper.getPSDEFields();
                    while (psDEFields.hasNext()) {
                        iPSDEField = psDEFields.next();
                        if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !iPSDEField.isLinkDEField() || !(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)(linkDEFHelper = (IPSLinkDEField)iPSDEField).getDERId(), (String)strTempCurDERId, (boolean)true) != 0 || StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                        joinRelatedDEFHelper = iPSDEField;
                        joinDEFHelper = linkDEFHelper.getRelatedPSDEField();
                        break;
                    }
                    if (joinRelatedDEFHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iNextDEHelper.getFullName(), (Object)strCurDERId));
                    }
                } else {
                    if (strCurDERId.indexOf("INDEX:") != 0 && strCurDERId.indexOf("INDEXM:") != 0) throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iPSDataEntity.getFullName(), (Object)strCurDERId));
                    boolean bIndexM = false;
                    if (strCurDERId.indexOf("INDEXM:") == 0) {
                        bIndexM = true;
                    }
                    strTempCurDERId = "";
                    strTempCurDERId = bIndexM ? strCurDERId.substring(7) : strCurDERId.substring(6);
                    IPSDERIndex derIndex = (IPSDERIndex)this.getPSSystem().getPSDER(strTempCurDERId);
                    iNextDEHelper = bIndexM ? this.getPSDataEntity(derIndex.getMinorPSDEId()) : this.getPSDataEntity(derIndex.getMajorPSDEId());
                    if (iNextDEHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)(bIndexM ? derIndex.getMinorPSDEId() : derIndex.getMajorPSDEId())));
                    }
                    joinRelatedDEFHelper = iNextDEHelper.getKeyPSDEField();
                    joinDEFHelper = iPSDataEntity.getKeyPSDEField();
                }
            } else {
                if (joinDEFHelper instanceof IPSLinkDEField) {
                    joinRelatedDEFHelper = ((IPSLinkDEField)joinDEFHelper).getRelatedPSDEField();
                    IPSDER1N iPSDER1N = (IPSDER1N)((IPSLinkDEField)joinDEFHelper).getPSDER();
                    if (bEnableTemp) {
                        boolean bl = bEnableTemp = iPSDER1N.getTempDataOrder() >= 0;
                    }
                }
                if (joinRelatedDEFHelper == null) {
                    if (derCustom != null) {
                        joinRelatedDEFHelper = derCustom.getMajorPSDataEntity().getKeyPSDEField();
                    }
                    if (joinRelatedDEFHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]\u5173\u8054\u5c5e\u6027", (Object)joinDEFHelper.getFullName()));
                    }
                }
                iNextDEHelper = joinRelatedDEFHelper.getPSDataEntity();
            }
            if (!joinMap.containsKey(strCurTotalDER)) {
                String strTypeValue;
                String strFieldName;
                IPSDEField parentSubType;
                IPSDEField parentType;
                Integer nAlias;
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    nAlias = derAliasMap.get("");
                    strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    }
                    nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
                }
                String strCurMTAlias = "";
                String strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                }
                Integer nAlias2 = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias2 + 1));
                strCurUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias2 + 2));
                boolean bJoinAsMain = true;
                bJoinAsMain = bSameTable || StringHelper.Compare((String)joinDEFHelper.getPSDTColumn(this.getDBType()).getTableScope(), (String)iPSDataEntity.getTableName(), (boolean)true) == 0;
                String strMainTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getTableName();
                String strUserTable = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getUserTable();
                String strMainTable2 = strMainTable;
                String strUserTable2 = strUserTable;
                String strMainTable3 = strMainTable;
                String strUserTable3 = strUserTable;
                if (iNextDEHelper.isEnableTempDataBackend() && bEnableTemp) {
                    strMainTable3 = String.valueOf(strMainTable) + "_TMP";
                    strUserTable3 = String.valueOf(strUserTable) + "_TMP";
                }
                String strSaaSDCIdColName = "";
                if (iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || iNextDEHelper.getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue()) {
                    strSaaSDCIdColName = iNextDEHelper.getPSDEDBConfig(this.getDBType()).getSaaSDCIdColumnName();
                }
                if (StringHelper.Compare((String)iNextDEHelper.getDBSchema(), (String)this.majorPSDataEntity.getDBSchema(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strUserTable);
                    strMainTable3 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strMainTable3);
                    strUserTable3 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.getDBSchema(), (Object)strUserTable3);
                }
                if (bLeftOuterJoin) {
                    script.Append("LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                    }
                    if (derCustom != null) {
                        script.Append("\n");
                        parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                        parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                        if (parentType != null) {
                            strFieldName = String.format("%1$s.%2$s", strCurMTAlias, this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName()));
                            script.Append(" AND " + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null));
                        }
                        if (parentSubType != null) {
                            strFieldName = String.format("%1$s.%2$s", strCurMTAlias, this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName()));
                            strTypeValue = derCustom.getTypeValue();
                            if (StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                strTypeValue = derCustom.getMinorCodeName();
                            }
                            if (!StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null));
                            } else {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null));
                            }
                        }
                    }
                    script.Append("\n");
                    if (scriptTemp != null) {
                        scriptTemp.Append("LEFT OUTER JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable3), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                            scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                        }
                        scriptTemp.Append("\n");
                    }
                } else if (bRightJoin) {
                    script.Append("RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                    }
                    if (derCustom != null) {
                        script.Append("\n");
                        parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                        parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                        if (parentType != null) {
                            strFieldName = String.format("%1$s.%2$s", bJoinAsMain ? strMTAlias : strUTAlias, this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName()));
                            script.Append(" AND " + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null));
                        }
                        if (parentSubType != null) {
                            strFieldName = String.format("%1$s.%2$s", bJoinAsMain ? strMTAlias : strUTAlias, this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName()));
                            strTypeValue = derCustom.getTypeValue();
                            if (StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                strTypeValue = derCustom.getMinorCodeName();
                            }
                            if (!StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null));
                            } else {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null));
                            }
                        }
                    }
                    script.Append("\n");
                    if (scriptTemp != null) {
                        scriptTemp.Append("RIGHT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable3), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                            scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                        }
                        scriptTemp.Append("\n");
                    }
                } else {
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable2), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                    }
                    if (derCustom != null) {
                        script.Append("\n");
                        parentType = derCustom.getMinorPSDataEntity().getParentTypePSDEField();
                        parentSubType = derCustom.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTSUBTYPE", true);
                        if (parentType != null) {
                            strFieldName = String.format("%1$s.%2$s", bJoinAsMain ? strMTAlias : strUTAlias, this.iPSDBType.getDBObjStandardName(parentType.getPSDTColumn(this.getDBType()).getColumnName()));
                            script.Append(" AND " + parentType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", iPSDataEntity.getName(), null, null));
                        }
                        if (parentSubType != null) {
                            strFieldName = String.format("%1$s.%2$s", bJoinAsMain ? strMTAlias : strUTAlias, this.iPSDBType.getDBObjStandardName(parentSubType.getPSDTColumn(this.getDBType()).getColumnName()));
                            strTypeValue = derCustom.getTypeValue();
                            if (StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                strTypeValue = derCustom.getMinorCodeName();
                            }
                            if (!StringHelper.IsNullOrEmpty((String)strTypeValue)) {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "EQ", strTypeValue, null, null));
                            } else {
                                script.Append(" AND " + parentSubType.getPSDTColumn(this.getDBType()).getConditionSQL(this, strFieldName, null, "ISNULL", null, null, null));
                            }
                        }
                    }
                    script.Append("\n");
                    if (scriptTemp != null) {
                        scriptTemp.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s ", (Object)this.iPSDBType.getDBObjStandardName(strMainTable3), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.iPSDBType.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()), (Object)this.iPSDBType.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).getColumnName()));
                        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                            scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurMTAlias, (Object)strSaaSDCIdColName);
                        }
                        scriptTemp.Append("\n");
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    IPSDEField pkeyPSDEField = null;
                    pkeyPSDEField = joinRelatedDEFHelper.getPSDTColumn(this.getDBType()).isPKey() ? joinRelatedDEFHelper : iNextDEHelper.getKeyPSDEField();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable2), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                        script.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurUTAlias, (Object)strSaaSDCIdColName);
                    }
                    script.Append("\n");
                    if (scriptTemp != null) {
                        scriptTemp.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s", (Object)this.iPSDBType.getDBObjStandardName(strUserTable3), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.iPSDBType.getDBObjStandardName(pkeyPSDEField.getPSDTColumn(this.getDBType()).getColumnName()));
                        if (!StringHelper.IsNullOrEmpty((String)strSaaSDCIdColName)) {
                            scriptTemp.Append(" AND %1$s.%2$s = '__SRFSAASDCID__'", (Object)strCurUTAlias, (Object)strSaaSDCIdColName);
                        }
                        scriptTemp.Append("\n");
                    }
                }
                joinMap.put(strCurTotalDER, 1);
            }
            String strNextDERId = "";
            int i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                return;
            }
            this.getJoin(script, scriptTemp, iNextDEHelper, bNextEnableTemp, strCurTotalDER, strNextDERId, derAliasMap, joinMap);
        }
    }

    protected String getPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
        boolean bClose = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSDEDQEngineImpl");
                actionSession.registerRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId());
            } else if (!actionSession.registerRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId())) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]SQL\u8868\u8fbe\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)iPSDEField.getFullName()));
            }
            String strPSDEFieldExp = this.onGetPSDEFieldExp(iPSDEField, strParentDER, derAliasMap, derList);
            actionSession.unregisterRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId());
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            return strPSDEFieldExp;
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    protected String onGetPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
        try {
            IPSDEField relatedPSPSDEField;
            IPSDEFDTColumn iPSDEFDTColumn2;
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            IPSDataEntity iPSDataEntity = iPSDEField.getPSDataEntity();
            IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
            if (iPSDEField.isInheritDEField() && (iPSDEFDTColumn2 = (relatedPSPSDEField = ((IPSInheritDEField)iPSDEField).getRelatedPSDEField()).getPSDTColumn(this.getDBType())).isFormula()) {
                iPSDEFDTColumn = iPSDEFDTColumn2;
            }
            if (iPSDEFDTColumn.isFormula() && !iPSDEFDTColumn.isFormulaPhisical()) {
                String strExp;
                String strFormulaFields = iPSDEFDTColumn.getFormulaColumns();
                if (!StringHelper.IsNullOrEmpty((String)strFormulaFields)) {
                    Object[] params = null;
                    String[] strFields = strFormulaFields.split("[;]");
                    params = new Object[strFields.length];
                    int i = 0;
                    while (i < strFields.length) {
                        String strDEFName = strFields[i].toUpperCase();
                        IPSDEField argvField = iPSDEField.getPSDataEntity().getPSDEField(strDEFName, true);
                        params[i] = argvField != null ? this.getPSDEFieldExp(argvField, strParentDER, derAliasMap, derList) : strDEFName;
                        ++i;
                    }
                    String strExp2 = StringHelper.Format((String)iPSDEFDTColumn.getFormulaFormat(), (Object[])params);
                    return strExp2;
                }
                if (iPSDEField.getPSDataEntity().isVirtual() && iPSDEField.getPSDataEntity().getVirtualMode() == 3) {
                    strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)"t1", (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                    return strExp;
                }
                strExp = StringHelper.Format((String)iPSDEFDTColumn.getFormulaFormat());
                this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                return strExp;
            }
            IPSDataEntity realPSDataEntity = null;
            if (StringHelper.IsNullOrEmpty((String)strParentDER) && this.getMajorPSDataEntity().isVirtual()) {
                if (this.getMajorPSDataEntity().getKeyPSDEField() == null) {
                    throw PSDataEntityException.create(this.getMajorPSDataEntity(), 20014);
                }
                if (this.getMajorPSDataEntity().getKeyPSDEField() instanceof IPSLinkDEField) {
                    realPSDataEntity = ((IPSLinkDEField)this.getMajorPSDataEntity().getKeyPSDEField()).getRealPSDEField(true).getPSDataEntity();
                    if (StringHelper.Compare((String)((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDataEntity().getId(), (String)realPSDataEntity.getId(), (boolean)false) != 0) {
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
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                    strDERID = "";
                    bAddJoin = false;
                } else {
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                        strDERID = "";
                        bAddJoin = false;
                    }
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPDATA", (boolean)true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                        strDERID = "";
                        bAddJoin = false;
                    }
                    if (linkDEFHelper != null && StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) == 0) {
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
            if (StringHelper.IsNullOrEmpty((String)strDERID)) {
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
                if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
                    int nAlias = derAliasMap.get("");
                    strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
                    bDynamicTable = false;
                } else {
                    if (!derAliasMap.containsKey(strParentDER)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                    }
                    Integer nAlias = derAliasMap.get(strParentDER);
                    strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
                }
                String strDEFTableName = iPSDEFDTColumn.getRealTableName();
                if (StringHelper.IsNullOrEmpty((String)strDEFTableName) && this.getMajorPSDataEntity().isVirtual() && iPSDEField instanceof IPSLinkDEField) {
                    strDEFTableName = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDTColumn(this.getDBType()).getRealTableName();
                    iPSDEFDTColumn = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDTColumn(this.getDBType());
                }
                if (bDynamicTable || StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                    String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strMTAlias, (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                    return strExp;
                }
                if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                    String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strUTAlias, (Object)this.iPSDBType.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    this.setFieldQueryCaseSensitive(strExp, iPSDEFDTColumn.getQueryCaseSenstive());
                    return strExp;
                }
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c5e\u6027[%1$s]\u8868\u540d[%2$s]", (Object)iPSDEField.getFullName(), (Object)strDEFTableName));
            }
            String strNewDER = strParentDER;
            if (bAddJoin) {
                if (!StringHelper.IsNullOrEmpty((String)strNewDER)) {
                    strNewDER = String.valueOf(strNewDER) + "|";
                }
                strNewDER = String.valueOf(strNewDER) + strDERID;
            }
            IPSDEField relatedDEFHelper = null;
            if (iPSDEField instanceof IPSLinkDEField) {
                relatedDEFHelper = ((IPSLinkDEField)iPSDEField).getRelatedPSDEField();
            }
            if (relatedDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            if (bAddJoin && !derAliasMap.containsKey(strNewDER)) {
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
            return this.getPSDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iPSDEField.getFullModelName(), (Object)ex.getMessage()), ex);
        }
    }

    protected String getTableAlias(IPSDataEntity iPSDataEntity, boolean bMain, String strParentDER, TreeMap<String, Integer> derAliasMap, ArrayList<String> derList) throws Exception {
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
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
            }
            strMTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            strUTAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 2));
        }
        String strExp = bMain ? strMTAlias : strUTAlias;
        return strExp;
    }

    protected String getConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
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
        if (!StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
        }
        if (DataTypeHelper.IsStringType((int)nDataType)) {
            return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsIntType((int)nDataType)) {
            return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsDoubleType((int)nDataType)) {
            return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        if (DataTypeHelper.IsDateTimeType((int)nDataType)) {
            return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u7c7b\u578b[%1$s]", (Object)nDataType));
    }

    public String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
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
        if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
            strValue = strValue.replace(",", ";");
            String[] items = StringHelper.SplitEx((String)(strValue = strValue.replace("'", "''")));
            if (items.length == 0) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u53c2\u6570");
            }
            StringBuilderEx sb = new StringBuilderEx();
            sb.Append(strFieldName);
            if (StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                sb.Append(" NOT ");
            }
            sb.Append(" IN (");
            int i = 0;
            while (i < items.length) {
                if (i != 0) {
                    sb.Append(",");
                }
                sb.Append("'%1$s'", (Object)items[i]);
                ++i;
            }
            sb.Append(")");
            return sb.toString();
        }
        return "";
    }

    public String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
        Object objValue = null;
        if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0 && (objValue = DataTypeParse.TestBigInt((String)strValue)) == null) {
            throw new Exception(StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)strValue));
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
                strValue = strValue.replace(",", ";");
                String[] items = StringHelper.SplitEx((String)strValue);
                String strSQL = "";
                strSQL = StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    Object objItem = DataTypeParse.TestBigInt((String)items[i]);
                    if (objItem == null) {
                        throw new Exception(StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)items[i]));
                    }
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

    public String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
        Object objValue = DataTypeParse.TestDouble((String)strValue);
        if (objValue == null && StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)strValue));
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
                strValue = strValue.replace(",", ";");
                String[] items = StringHelper.SplitEx((String)strValue);
                String strSQL = "";
                strSQL = StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    Object objItem = DataTypeParse.TestDouble((String)items[i]);
                    if (objItem == null) {
                        throw new Exception(StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)items[i]));
                    }
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

    public String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, "");
    }

    protected String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) throws Exception {
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

    public String getCountSQL(String strSQL) {
        return "";
    }

    public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        return "";
    }

    public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strGroup, String strGroupDir, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.IsNullOrEmpty((String)strGroup)) {
            return this.getPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection);
        }
        return this.getPagingSQL(strSQL, nStartPos, nPageSize, strGroup, strGroupDir, strMajor, strMajorDirection);
    }

    public String getSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        return "";
    }

    public String getSortSQL(boolean bSubQuery, String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
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
        return this.getSortSQL(strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
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

    public String getGroupSQL(String strSQL, QueryGroupModelConfig queryGroupModelConfig, ArrayList<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper iDAGlobalHelper, String strCurPersonId, BaseDataEntity baseDataEntity) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            strSQL = this.getQueryModelScript(null);
        }
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u67e5\u8be2\u8bed\u53e5\u65e0\u6548"));
            return "";
        }
        StringBuilderEx sqlGroup = new StringBuilderEx();
        IPSDataEntity majorDEHelper = this.getMajorPSDataEntity();
        sqlGroup.Append("SELECT ");
        boolean bFirst = true;
        int nAliasIndex = 0;
        TreeMap<Integer, String> orderMap = new TreeMap<Integer, String>();
        ArrayList<String> groupFields = new ArrayList<String>();
        ArrayList<QueryGroupItemConfig> recalcItems = new ArrayList<QueryGroupItemConfig>();
        for (QueryGroupItemConfig queryGroupItemConfig : queryGroupModelConfig) {
            String strParams;
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
                    IPSDEField defHelper = majorDEHelper.getPSDEField(strDEField);
                    if (defHelper == null) {
                        if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        fieldCodes[0] = strDEField;
                    } else {
                        if (StringHelper.IsNullOrEmpty((String)strAlias)) {
                            strAlias = fields[0];
                        }
                        String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
                        fieldCodes[0] = strRealCode;
                    }
                } else {
                    int i = 0;
                    while (i < fields.length) {
                        String strDEField = fields[i];
                        IPSDEField defHelper = majorDEHelper.getPSDEField(strDEField);
                        if (defHelper == null) {
                            fieldCodes[i] = strDEField;
                        } else {
                            String strRealCode = this.getDEFieldStatisticsNullConvertCode(defHelper);
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
                CallResult callResult = MacroHelper.GetValue((String)cp.getParamName(), (ISRFDAWebContext)webContext, (ISRFDAGlobalHelper)iDAGlobalHelper, (String)strCurPersonId, (BaseDataEntity)baseDataEntity);
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
            Iterator iterator = orderMap.keySet().iterator();
            while (iterator.hasNext()) {
                int nValue = (Integer)iterator.next();
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
        return this.getFetchTopRowSQL(strGroupSql, queryGroupModelConfig.getTopCount());
    }

    public String getFetchTopRowSQL(String strSQL, int nTopCount) {
        return strSQL;
    }

    protected String getDEFieldStatisticsNullConvertCode(IPSDEField defHelper) throws Exception {
        String strStaNullConv = defHelper.getPSDTColumn(this.getDBType()).getStatisticsNullConvert();
        if (!StringHelper.IsNullOrEmpty((String)strStaNullConv)) {
            return StringHelper.Format((String)"(CASE WHEN %1$s IS NULL THEN %2$s ELSE %1$s END)", (Object)defHelper.getPSDTColumn(this.getDBType()).getColumnName(), (Object)strStaNullConv);
        }
        return defHelper.getName();
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
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + qmDeclare.getDeclareCode();
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + "\n";
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
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
    }

    public void setFieldQueryCaseSensitive(String strField, String strValue) {
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
        if (this.deDataQueryCodeExpImplList == null || this.deDataQueryCodeExpImplList.size() == 0) {
            return null;
        }
        return this.deDataQueryCodeExpImplList.iterator();
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
        if (this.deDataQueryCodeCondImplList == null || this.deDataQueryCodeCondImplList.size() == 0) {
            return null;
        }
        return this.deDataQueryCodeCondImplList.iterator();
    }

    protected boolean isUseRazorEngine() {
        return this.getMajorPSDataEntity().getPSSystem().getPSSFId().indexOf("DOTNET") == 0;
    }

    @Override
    public Iterator<String> getPSDEDQAliasNames() {
        if (this.qmAliasMap.size() == 0) {
            return null;
        }
        return this.qmAliasMap.keySet().iterator();
    }

    @Override
    public PSDEDQAlias getPSDEDQAlias(String strName, boolean bTryMode) throws Exception {
        PSDEDQAlias psDEDQAlias = this.qmAliasMap.get(strName.toLowerCase());
        if (psDEDQAlias != null) {
            return psDEDQAlias;
        }
        psDEDQAlias = this.qmAliasMap.get(strName.toUpperCase());
        if (psDEDQAlias != null) {
            return psDEDQAlias;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u522b\u540d[%1$s]", strName));
    }

    @Override
    public boolean isEnablePQL() {
        return this.bEnablePQL;
    }

    protected class DEDataQueryCodeCondImpl
    extends PSObjectImpl
    implements IDEDataQueryCodeCond {
        private String strCustomCond = "";
        private int nShowOrder = -1;

        protected DEDataQueryCodeCondImpl() {
        }

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

        public String getDEFName() {
            return null;
        }

        public String getCondType() {
            return "CUSTOM";
        }

        public String getCondOp() {
            return null;
        }

        public String getCondValue() {
            return null;
        }

        public void setCustomCond(String strCustomCond) {
            this.strCustomCond = strCustomCond;
        }

        public String getCustomCond() {
            return this.strCustomCond;
        }

        public String getPredefindedCond() {
            return null;
        }

        public String getPredefinedCode() {
            return null;
        }

        public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
            return null;
        }

        public String getDEFieldExp() {
            return null;
        }

        public boolean isNotMode() {
            return false;
        }

        public int getStdDataType() {
            return 0;
        }

        @Override
        public String getPSSysModelInstId() {
            return null;
        }

        public String getValueFunc() {
            return null;
        }
    }

    protected class DEDataQueryCodeExpImpl
    extends PSObjectImpl
    implements IDEDataQueryCodeExp {
        private String strExpression = "";
        private int nShowOrder = -1;

        protected DEDataQueryCodeExpImpl() {
        }

        @Override
        public void setName(String strName) {
            super.setName(strName);
        }

        public String getExpression() {
            return this.strExpression;
        }

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

        URLCondPair() {
        }
    }
}

