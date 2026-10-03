/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.BICubeCacheCondition
 *  SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo
 *  SA.SRFDA.BI.Ctrl.Data.BICacheTable
 *  SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter
 *  SA.SRFDA.BI.Ctrl.IBICalculatedMeasureHelper
 *  SA.SRFDA.BI.Ctrl.IBICubeCache
 *  SA.SRFDA.BI.Ctrl.IBICubeHelper
 *  SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper
 *  SA.SRFDA.BI.Ctrl.IBIHierarchyHelper
 *  SA.SRFDA.BI.Ctrl.IBILevelHelper
 *  SA.SRFDA.BI.Ctrl.IBIMeasureHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCacheCondition;
import SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo;
import SA.SRFDA.BI.Ctrl.Data.BICacheTable;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter;
import SA.SRFDA.BI.Ctrl.IBICalculatedMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.BI.Ctrl.IBIMeasureHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.rmi.server.UID;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BICubeCache
implements IBICubeCache {
    private static final Log log = LogFactory.getLog(BICubeCache.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IBICubeHelper iBICubeHelper = null;
    protected String strBIFilter = "";
    protected String strPersonId = "";
    protected String strMode = "";
    protected Vector<BIHierarchyFilter> biHierarchyFilters = null;
    protected String strCacheTableName = "";
    protected String strDBStorage = "";
    protected Vector<IBILevelHelper> groupBILevels = new Vector();
    protected Vector<IBIHierarchyHelper> groupBIHierarchies = new Vector();
    protected Hashtable<String, Vector<BaseDataEntity>> biHierarchyDataMap = new Hashtable();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBICubeHelper iBICubeHelper, String strBIFilter, String strMode, String strPersonId) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBICubeHelper = iBICubeHelper;
        this.strBIFilter = strBIFilter;
        this.strPersonId = strPersonId;
        this.strMode = strMode;
        this.strDBStorage = this.getBICube().getBICubeDEHelper().GetDBStorage();
        this.OnBuildCache();
    }

    public IBICubeHelper getBICube() {
        return this.iBICubeHelper;
    }

    public String getBIFilter() {
        return this.strBIFilter;
    }

    protected void OnBuildCache() throws Exception {
        Vector tables;
        block3: {
            CallResult callResult;
            this.biHierarchyFilters = this.OnGetBIHierarchyFilters();
            tables = this.getBICube().CalcBICubeTables(this.biHierarchyFilters);
            IDEDataCtrl cacheTableDataCtrl = this.getCacheTableDataCtrl();
            do {
                this.strCacheTableName = this.OnGetCacheTableName();
                BICacheTable biCacheTable = new BICacheTable();
                biCacheTable.setBICACHETABLEID(this.strCacheTableName);
                biCacheTable.setBICACHETABLENAME(this.strCacheTableName);
                callResult = cacheTableDataCtrl.Save(true, (BaseDataEntity)biCacheTable);
                if (callResult.IsOk()) break block3;
            } while (callResult.getRetCode() == 6 || callResult.getRetCode() == 1006);
            throw new Exception(StringHelper.Format((String)"\u8bb0\u5f55BI\u4e34\u65f6\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        block1: for (BIHierarchyFilter biHierarchyFilter : this.biHierarchyFilters) {
            IBIHierarchyHelper iBIHierarchyHelper = this.getBICube().FindBIHierarchy(biHierarchyFilter.getBIHierarchy());
            this.groupBIHierarchies.add(iBIHierarchyHelper);
            for (IBILevelHelper iBILevelHelper : iBIHierarchyHelper.getBILevels()) {
                this.groupBILevels.add(iBILevelHelper);
                if (StringHelper.Compare((String)iBILevelHelper.getName(), (String)biHierarchyFilter.getBILevel(), (boolean)true) == 0) continue block1;
            }
        }
        Date dtBegin = new Date();
        this.OnCreateCacheTable();
        this.OnInsertIntoCacheTable(tables);
        Date dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"\u6784\u5efaBI\u4e34\u65f6\u8868\u8017\u65f6[%1$s]\u6beb\u79d2", (Object)(dtEnd.getTime() - dtBegin.getTime())));
    }

    public String getCacheTableName() {
        return this.strCacheTableName;
    }

    protected abstract void OnCreateCacheTable() throws Exception;

    protected abstract void OnInsertIntoCacheTable(Vector<String> var1) throws Exception;

    protected String OnGetCacheTableName() {
        UID uid = new UID();
        String strCacheTableName = StringHelper.Format((String)"SABI%1$s", (Object)uid.toString().toUpperCase());
        strCacheTableName = strCacheTableName.replace(":", "");
        strCacheTableName = strCacheTableName.replace("-", "");
        return strCacheTableName;
    }

    protected Vector<BIHierarchyFilter> OnGetBIHierarchyFilters() throws Exception {
        return BIHierarchyFilter.Parse((String)this.strBIFilter);
    }

    protected CallResult CallDBSql(String strSql) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller(this.strDBStorage).CallRaw3(strSql, null);
            callResult.From((DBResult)selectResult);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql), (Throwable)ex);
            return callResult;
        }
    }

    protected String OnGetAllBIHierarchySqlCondition(IBIHierarchyHelper iBIHierarchyHelper, String strBIHierarchyFilters) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strBIHierarchyFilters)) {
            return "";
        }
        String[] filters = strBIHierarchyFilters.split("[;]");
        if (filters.length > 50) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u7ef4\u5ea6\u6761\u4ef6\u8d85\u8fc7\u4e3a50\u4e2a", (Object)iBIHierarchyHelper.getLogicName()));
        }
        String strCondition = "";
        int i = 0;
        while (i < filters.length) {
            if (!StringHelper.IsNullOrEmpty((String)filters[i])) {
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s)", (Object)this.OnGetBIHierarchySqlCondition(iBIHierarchyHelper, filters[i]));
            }
            ++i;
        }
        return strCondition;
    }

    protected String OnGetBIHierarchySqlCondition(IBIHierarchyHelper iBIHierarchyHelper, String strBIHierarchyFilter) throws Exception {
        String strCondition = "";
        String[] filterItems = strBIHierarchyFilter.split("[.]");
        int i = 0;
        while (i < filterItems.length) {
            IBILevelHelper iBILevelHelper = (IBILevelHelper)iBIHierarchyHelper.getBILevels().get(i);
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"%1$s.%2$s='%3$s'", (Object)iBIHierarchyHelper.getShortId(), (Object)iBILevelHelper.getColumnName(), (Object)filterItems[i]);
            ++i;
        }
        return strCondition;
    }

    protected String OnGetBICubeMeasureExpression(Hashtable<String, String> measureExpMap, IBICubeMeasureHelper iBICubeMeasureHelper, boolean bShortId) throws Exception {
        if (iBICubeMeasureHelper instanceof IBIMeasureHelper) {
            IBIMeasureHelper iBIMeasureHelper = (IBIMeasureHelper)iBICubeMeasureHelper;
            String strExp = "";
            strExp = StringHelper.Compare((String)iBIMeasureHelper.getAggregator(), (String)"COUNT", (boolean)true) == 0 ? StringHelper.Format((String)"COUNT(*)") : StringHelper.Format((String)"%1$s(%2$s.%3$s)", (Object)iBIMeasureHelper.getAggregator().toUpperCase(), (Object)"t1", (Object)(bShortId ? iBIMeasureHelper.getShortId() : iBIMeasureHelper.getColumnName()));
            measureExpMap.put(iBIMeasureHelper.getUniqueName(), strExp);
            return strExp;
        }
        if (iBICubeMeasureHelper instanceof IBICalculatedMeasureHelper) {
            IBICalculatedMeasureHelper iBICalculatedMeasureHelper = (IBICalculatedMeasureHelper)iBICubeMeasureHelper;
            String strExpression = iBICalculatedMeasureHelper.getExpression();
            for (String strKey : measureExpMap.keySet()) {
                strExpression = strExpression.replace(strKey, measureExpMap.get(strKey));
            }
            return strExpression;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6307\u6807\u7c7b\u578b[%1$s]", (Object)iBICubeMeasureHelper.getMeasureType()));
    }

    public Vector<BIHierarchyFilter> getBIHierarchyFilters() {
        return this.biHierarchyFilters;
    }

    public Vector<BaseDataEntity> getBIHierarchyDatas(String strBIHierarchyId) throws Exception {
        if (this.biHierarchyDataMap.containsKey(strBIHierarchyId)) {
            return this.biHierarchyDataMap.get(strBIHierarchyId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u7684\u6570\u636e\u96c6\u5408", (Object)strBIHierarchyId));
    }

    public Vector<BaseDataEntity> getBIHierarchyDatas(String strBIHierarchyId, String strExtQuery) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strExtQuery)) {
            return this.getBIHierarchyDatas(strBIHierarchyId);
        }
        int i = 0;
        while (i < this.biHierarchyFilters.size()) {
            BIHierarchyFilter biHierarchyFilter = this.biHierarchyFilters.get(i);
            if (StringHelper.Compare((String)biHierarchyFilter.getBIHierarchy(), (String)strBIHierarchyId, (boolean)true) == 0) {
                IBIHierarchyHelper iBIHierarchyHelper = this.groupBIHierarchies.get(i);
                this.OnFetchBIHierarchyData(biHierarchyFilter, iBIHierarchyHelper, strExtQuery);
                String strTotalKey = biHierarchyFilter.getBIHierarchy();
                if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
                    strTotalKey = String.valueOf(strTotalKey) + "|";
                    strTotalKey = String.valueOf(strTotalKey) + strExtQuery;
                }
                return this.getBIHierarchyDatas(strTotalKey);
            }
            ++i;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u7684\u6570\u636e\u96c6\u5408", (Object)strBIHierarchyId));
    }

    public boolean hasBIHierarchyFilter(String strBIHierarchyId) {
        for (BIHierarchyFilter biHierarchyFilter : this.biHierarchyFilters) {
            if (StringHelper.Compare((String)biHierarchyFilter.getBIHierarchy(), (String)strBIHierarchyId, (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    protected IBIHierarchyHelper getBIHierarchy(String strBIHierarchyId) throws Exception {
        for (IBIHierarchyHelper iBIHierarchyHelper : this.groupBIHierarchies) {
            if (StringHelper.Compare((String)iBIHierarchyHelper.getUniqueName(), (String)strBIHierarchyId, (boolean)true) != 0) continue;
            return iBIHierarchyHelper;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb[%1$s]", (Object)strBIHierarchyId));
    }

    public Vector<IBILevelHelper> getGroupBILevels() {
        return this.groupBILevels;
    }

    public void FetchDataByBIHierarchy(String strBIHierarchyId, int nStartPos, int nEndPos, Vector<IBIHierarchyHelper> allBIHierarchies, Hashtable<String, BaseDataEntity> datas) throws Exception {
        this.LogCacheTableUsed();
        IBIHierarchyHelper iBIHierarchyHelper = this.getBIHierarchy(strBIHierarchyId);
        Vector<BaseDataEntity> biHierarchyDatas = this.biHierarchyDataMap.get(strBIHierarchyId);
        String strCondFmt = "";
        Vector<String> paramList = new Vector<String>();
        int nParamIndex = 1;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            paramList.add(iBILevelHelper.getShortId());
            if (!StringHelper.IsNullOrEmpty((String)strCondFmt)) {
                strCondFmt = String.valueOf(strCondFmt) + " AND ";
            }
            strCondFmt = String.valueOf(strCondFmt) + StringHelper.Format((String)"%1$s ='%%%2$s$s'", (Object)iBILevelHelper.getShortId(), (Object)nParamIndex);
            ++nParamIndex;
        }
        Object[] item = new Object[paramList.size()];
        Vector<String> conditions = new Vector<String>();
        int i = nStartPos - 1;
        while (i < nEndPos) {
            BaseDataEntity biHierarchyData = biHierarchyDatas.get(i);
            int j = 0;
            while (j < paramList.size()) {
                item[j] = biHierarchyData.GetParamValue((String)paramList.get(j));
                ++j;
            }
            conditions.add(StringHelper.Format((String)strCondFmt, (Object[])item));
            ++i;
        }
        Vector<String> allConditions = new Vector<String>();
        int nIndex = 0;
        String strAllCondition = "";
        for (String strCondition : conditions) {
            if (nIndex != 0) {
                strAllCondition = String.valueOf(strAllCondition) + " OR ";
            }
            strAllCondition = String.valueOf(strAllCondition) + StringHelper.Format((String)"(%1$s)", (Object)strCondition);
            if (++nIndex <= 10) continue;
            allConditions.add(strAllCondition);
            strAllCondition = "";
            nIndex = 0;
        }
        if (!StringHelper.IsNullOrEmpty((String)strAllCondition)) {
            allConditions.add(strAllCondition);
        }
        for (String strTempCondition : allConditions) {
            Vector<BaseDataEntity> list = new Vector();
            String strSQL = StringHelper.Format((String)"SELECT * FROM %1$s where %2$s", (Object)this.getCacheTableName(), (Object)strTempCondition);
            CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)(strSQL = strSQL.replace("='null'", " IS NULL")), list, (String)"");
            if (callResult == null || callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
            }
            for (BaseDataEntity dataEntity : list) {
                String strKey = "";
                for (IBIHierarchyHelper groupBIHierarchyHelper : allBIHierarchies) {
                    if (!StringHelper.IsNullOrEmpty((String)strKey)) {
                        strKey = String.valueOf(strKey) + ";";
                    }
                    strKey = String.valueOf(strKey) + groupBIHierarchyHelper.getDataKey(dataEntity);
                }
                datas.put(strKey, dataEntity);
            }
        }
    }

    public void FetchData(BICubeCacheCondition extCondition, Vector<IBIHierarchyHelper> allBIHierarchies, Hashtable<String, BaseDataEntity> datas) throws Exception {
        CallResult callResult;
        this.LogCacheTableUsed();
        Vector<String> allConditions = new Vector<String>();
        int k = 0;
        while (k < this.biHierarchyFilters.size()) {
            BIHierarchyFilter biHierarchyFilter = this.biHierarchyFilters.get(k);
            IBIHierarchyHelper iBIHierarchyHelper = this.groupBIHierarchies.get(k);
            String strExtQuery = "";
            if (extCondition != null && extCondition.hasCondition(biHierarchyFilter.getBIHierarchy())) {
                strExtQuery = extCondition.getCondition(biHierarchyFilter.getBIHierarchy());
            }
            if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
                String strTotalKey = biHierarchyFilter.getBIHierarchy();
                if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
                    strTotalKey = String.valueOf(strTotalKey) + "|";
                    strTotalKey = String.valueOf(strTotalKey) + strExtQuery;
                }
                Vector<BaseDataEntity> biHierarchyDatas = this.biHierarchyDataMap.get(strTotalKey);
                String strCondFmt = "";
                Vector<String> paramList = new Vector<String>();
                int nParamIndex = 1;
                for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                    if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
                    paramList.add(iBILevelHelper.getShortId());
                    if (!StringHelper.IsNullOrEmpty((String)strCondFmt)) {
                        strCondFmt = String.valueOf(strCondFmt) + " AND ";
                    }
                    strCondFmt = String.valueOf(strCondFmt) + StringHelper.Format((String)"%1$s ='%%%2$s$s'", (Object)iBILevelHelper.getShortId(), (Object)nParamIndex);
                    ++nParamIndex;
                }
                Object[] item = new Object[paramList.size()];
                Vector<String> conditions = new Vector<String>();
                boolean bIgnore = false;
                int i = 0;
                while (i < biHierarchyDatas.size()) {
                    bIgnore = false;
                    BaseDataEntity biHierarchyData = biHierarchyDatas.get(i);
                    int j = 0;
                    while (j < paramList.size()) {
                        item[j] = biHierarchyData.GetParamValue((String)paramList.get(j));
                        if (item[j] == null) {
                            bIgnore = true;
                            break;
                        }
                        ++j;
                    }
                    if (!bIgnore) {
                        conditions.add(StringHelper.Format((String)strCondFmt, (Object[])item));
                    }
                    ++i;
                }
                int nIndex = 0;
                String strAllCondition = "";
                for (String strCondition : conditions) {
                    if (nIndex != 0) {
                        strAllCondition = String.valueOf(strAllCondition) + " OR ";
                    }
                    ++nIndex;
                    strAllCondition = String.valueOf(strAllCondition) + StringHelper.Format((String)"(%1$s)", (Object)strCondition);
                }
                if (!StringHelper.IsNullOrEmpty((String)strAllCondition)) {
                    allConditions.add(strAllCondition);
                }
            }
            ++k;
        }
        String strTotalCondition = "";
        for (String strTempCondition : allConditions) {
            if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
                strTotalCondition = String.valueOf(strTotalCondition) + " AND ";
            }
            strTotalCondition = String.valueOf(strTotalCondition) + StringHelper.Format((String)"(%1$s)", (Object)strTempCondition);
        }
        Vector<BaseDataEntity> list = new Vector();
        String strSQL = StringHelper.Format((String)"SELECT * FROM %1$s ", (Object)this.getCacheTableName());
        if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
            strSQL = String.valueOf(strSQL) + StringHelper.Format((String)" WHERE %1$s", (Object)strTotalCondition);
        }
        if ((callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)(strSQL = strSQL.replace("='null'", " IS NULL")), list, (String)"")) == null || callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
        }
        for (BaseDataEntity dataEntity : list) {
            String strKey = "";
            for (IBIHierarchyHelper groupBIHierarchyHelper : allBIHierarchies) {
                if (!StringHelper.IsNullOrEmpty((String)strKey)) {
                    strKey = String.valueOf(strKey) + ";";
                }
                strKey = String.valueOf(strKey) + groupBIHierarchyHelper.getDataKey(dataEntity);
            }
            datas.put(strKey, dataEntity);
        }
    }

    protected void OnFetchBIHierarchyData(BIHierarchyFilter biHierarchyFilter, IBIHierarchyHelper iBIHierarchyHelper, String strExtQuery) throws Exception {
    }

    public void FetchData(BICubeCacheCondition extCondition, BICubeCacheSortInfo sortInfo, Vector<IBIHierarchyHelper> allBIHierarchies, Vector<BaseDataEntity> rowDatas) throws Exception {
        this.LogCacheTableUsed();
        Vector<String> allConditions = new Vector<String>();
        int k = 0;
        while (k < this.biHierarchyFilters.size()) {
            BIHierarchyFilter biHierarchyFilter = this.biHierarchyFilters.get(k);
            IBIHierarchyHelper iBIHierarchyHelper = this.groupBIHierarchies.get(k);
            String strExtQuery = "";
            if (extCondition != null && extCondition.hasCondition(biHierarchyFilter.getBIHierarchy())) {
                strExtQuery = extCondition.getCondition(biHierarchyFilter.getBIHierarchy());
            }
            if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
                String strTotalKey = biHierarchyFilter.getBIHierarchy();
                if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
                    strTotalKey = String.valueOf(strTotalKey) + "|";
                    strTotalKey = String.valueOf(strTotalKey) + strExtQuery;
                }
                Vector<BaseDataEntity> biHierarchyDatas = this.biHierarchyDataMap.get(strTotalKey);
                String strCondFmt = "";
                Vector<String> paramList = new Vector<String>();
                int nParamIndex = 1;
                for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                    if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
                    paramList.add(iBILevelHelper.getShortId());
                    if (!StringHelper.IsNullOrEmpty((String)strCondFmt)) {
                        strCondFmt = String.valueOf(strCondFmt) + " AND ";
                    }
                    strCondFmt = String.valueOf(strCondFmt) + StringHelper.Format((String)"%1$s ='%%%2$s$s'", (Object)iBILevelHelper.getShortId(), (Object)nParamIndex);
                    ++nParamIndex;
                }
                Object[] item = new Object[paramList.size()];
                Vector<String> conditions = new Vector<String>();
                boolean bIgnore = false;
                int i = 0;
                while (i < biHierarchyDatas.size()) {
                    bIgnore = false;
                    BaseDataEntity biHierarchyData = biHierarchyDatas.get(i);
                    int j = 0;
                    while (j < paramList.size()) {
                        item[j] = biHierarchyData.GetParamValue((String)paramList.get(j));
                        if (item[j] == null) {
                            bIgnore = true;
                            break;
                        }
                        ++j;
                    }
                    if (!bIgnore) {
                        conditions.add(StringHelper.Format((String)strCondFmt, (Object[])item));
                    }
                    ++i;
                }
                int nIndex = 0;
                String strAllCondition = "";
                for (String strCondition : conditions) {
                    if (nIndex != 0) {
                        strAllCondition = String.valueOf(strAllCondition) + " OR ";
                    }
                    ++nIndex;
                    strAllCondition = String.valueOf(strAllCondition) + StringHelper.Format((String)"(%1$s)", (Object)strCondition);
                }
                if (!StringHelper.IsNullOrEmpty((String)strAllCondition)) {
                    allConditions.add(strAllCondition);
                }
            }
            ++k;
        }
        String strTotalCondition = "";
        for (String strTempCondition : allConditions) {
            if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
                strTotalCondition = String.valueOf(strTotalCondition) + " AND ";
            }
            strTotalCondition = String.valueOf(strTotalCondition) + StringHelper.Format((String)"(%1$s)", (Object)strTempCondition);
        }
        String strSQL = StringHelper.Format((String)"SELECT * FROM %1$s ", (Object)this.getCacheTableName());
        if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
            strSQL = String.valueOf(strSQL) + StringHelper.Format((String)" WHERE %1$s", (Object)strTotalCondition);
        }
        strSQL = strSQL.replace("='null'", " IS NULL");
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)(strSQL = this.OnGetSortSQL(strSQL, sortInfo)), rowDatas, (String)"");
        if (callResult == null || callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
        }
    }

    protected abstract String OnGetSortSQL(String var1, BICubeCacheSortInfo var2);

    protected IDEDataCtrl getCacheTableDataCtrl() throws Exception {
        return this.OnGetCacheTableDataCtrl();
    }

    protected IDEDataCtrl OnGetCacheTableDataCtrl() throws Exception {
        IDEDataCtrl dataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0065", this.strPersonId, null);
        if (dataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0065"));
        }
        return dataCtrl;
    }

    protected void LogCacheTableUsed() throws Exception {
        IDEDataCtrl cacheTableDataCtrl = this.getCacheTableDataCtrl();
        BICacheTable biCacheTable = new BICacheTable();
        biCacheTable.setBICACHETABLEID(this.strCacheTableName);
        CallResult callResult = cacheTableDataCtrl.Save(false, (BaseDataEntity)biCacheTable);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0BI\u4e34\u65f6\u8868\u4f7f\u7528\u8bb0\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

