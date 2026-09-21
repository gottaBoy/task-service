/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo
 *  SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter
 *  SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper
 *  SA.SRFDA.BI.Ctrl.IBIHierarchyHelper
 *  SA.SRFDA.BI.Ctrl.IBILevelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCache;
import SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BICubeOracleCache
extends BICubeCache {
    private static final Log log = LogFactory.getLog(BICubeOracleCache.class);

    @Override
    protected void OnCreateCacheTable() throws Exception {
        this.OnCreateCacheTable(this.getCacheTableName());
    }

    protected void OnCreateCacheTable(String strTableName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append("CREATE TABLE %1$s(\n", (Object)strTableName);
        boolean bFirst = true;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s VARCHAR2(60) \n", (Object)iBILevelHelper.getShortId());
        }
        for (IBICubeMeasureHelper iBICubeMeasureHelper : this.getBICube().getBICubeMeasures()) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s NUMBER(20,4) \n", (Object)iBICubeMeasureHelper.getShortId());
        }
        stringBuilder.Append(") ");
        CallResult callResult = this.CallDBSql(stringBuilder.toString());
        if (callResult.IsError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }

    @Override
    protected void OnInsertIntoCacheTable(Vector<String> srcTables) throws Exception {
        Date dtBegin = new Date();
        boolean bFirst = true;
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append("INSERT INTO %1$s (\n", (Object)this.getCacheTableName());
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s", (Object)iBILevelHelper.getShortId());
        }
        for (IBICubeMeasureHelper iBICubeMeasureHelper : this.getBICube().getBICubeMeasures()) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s", (Object)iBICubeMeasureHelper.getShortId());
        }
        stringBuilder.Append(")\n");
        stringBuilder.Append(" SELECT \n");
        bFirst = true;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getColumnName());
        }
        Hashtable<String, String> measureExpMap = new Hashtable<String, String>();
        for (IBICubeMeasureHelper iBICubeMeasureHelper : this.getBICube().getBICubeMeasures()) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s", (Object)this.OnGetBICubeMeasureExpression(measureExpMap, iBICubeMeasureHelper, false));
        }
        stringBuilder.Append(" FROM \n");
        if (srcTables.size() == 1) {
            stringBuilder.Append(" %1$s t1\n", (Object)srcTables.get(0));
        } else {
            stringBuilder.Append("(\n");
            bFirst = true;
            for (String strName : srcTables) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append("UNION \n");
                }
                stringBuilder.Append(strName);
                stringBuilder.Append("\n");
            }
            stringBuilder.Append(") t1\n");
        }
        int i = 0;
        while (i < this.biHierarchyFilters.size()) {
            IBIHierarchyHelper iBIHierarchyHelper = (IBIHierarchyHelper)this.groupBIHierarchies.get(i);
            String strCubeField = iBIHierarchyHelper.getBIHierarchyDEHelper().GetKeyDEFHelper().getName();
            IDEFHelper joinDEFHelper = this.getBICube().FindBIDMJoinDEFHelper(iBIHierarchyHelper.getIBIDimension().getId());
            if (joinDEFHelper != null) {
                strCubeField = joinDEFHelper.GetDTColumn().GetColumnName();
            }
            stringBuilder.Append("INNER JOIN %1$s %2$s ON t1.%3$s=%2$s.%4$s\n", (Object)iBIHierarchyHelper.getTableName(), (Object)iBIHierarchyHelper.getShortId(), (Object)strCubeField, (Object)iBIHierarchyHelper.getBIHierarchyDEHelper().GetKeyDEFHelper().getName());
            ++i;
        }
        Vector<String> allConditions = new Vector<String>();
        int i2 = 0;
        while (i2 < this.biHierarchyFilters.size()) {
            BIHierarchyFilter biHierarchyFilter = (BIHierarchyFilter)this.biHierarchyFilters.get(i2);
            IBIHierarchyHelper iBIHierarchyHelper = (IBIHierarchyHelper)this.groupBIHierarchies.get(i2);
            if (!StringHelper.IsNullOrEmpty((String)biHierarchyFilter.getFilters())) {
                allConditions.add(this.OnGetAllBIHierarchySqlCondition(iBIHierarchyHelper, biHierarchyFilter.getFilters()));
            }
            ++i2;
        }
        if (allConditions.size() > 0) {
            bFirst = true;
            stringBuilder.Append("WHERE \n");
            for (String strCondition : allConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(" AND ");
                }
                stringBuilder.Append("%1$s \n", (Object)strCondition);
            }
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("GROUP BY \n");
        if (StringHelper.Compare((String)this.strMode, (String)"TABLE", (boolean)true) == 0) {
            boolean bFirstRollup = true;
            for (IBIHierarchyHelper iBIHierarchyHelper : this.groupBIHierarchies) {
                if (bFirstRollup) {
                    bFirstRollup = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("ROLLUP(");
                bFirst = true;
                for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                    if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        stringBuilder.Append(",");
                    }
                    stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getColumnName());
                }
                stringBuilder.Append(")");
            }
        }
        if (StringHelper.Compare((String)this.strMode, (String)"CHART", (boolean)true) == 0) {
            bFirst = true;
            for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getColumnName());
            }
        }
        log.debug((Object)StringHelper.Format((String)"\u5206\u7ec4\u8bed\u53e5:\r\n%1$s", (Object)stringBuilder.toString()));
        CallResult callResult = this.CallDBSql(stringBuilder.toString());
        if (callResult.IsError()) {
            throw new Exception(callResult.getErrorInfo());
        }
        if (StringHelper.Compare((String)this.strMode, (String)"CHART", (boolean)true) == 0) {
            String strNotNullCondition = "";
            for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                if (!StringHelper.IsNullOrEmpty((String)strNotNullCondition)) {
                    strNotNullCondition = String.valueOf(strNotNullCondition) + " OR ";
                }
                strNotNullCondition = String.valueOf(strNotNullCondition) + StringHelper.Format((String)"%1$s IS  NULL ", (Object)iBILevelHelper.getShortId());
            }
            String strSQL = StringHelper.Format((String)"DELETE FROM %1$s WHERE %2$s", (Object)this.getCacheTableName(), (Object)strNotNullCondition);
            callResult = this.CallDBSql(strSQL);
            if (callResult.IsError()) {
                throw new Exception(callResult.getErrorInfo());
            }
        }
        Date dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"\u63d2\u5165\u539f\u59cb\u5206\u7ec4\u8868\u8017\u65f6[%1$s]\u6beb\u79d2", (Object)(dtEnd.getTime() - dtBegin.getTime())));
        dtBegin = new Date();
        dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"\u539f\u59cb\u5206\u7ec4\u8868\u5efa\u7acb\u7d22\u5f15\u8017\u65f6[%1$s]\u6beb\u79d2", (Object)(dtEnd.getTime() - dtBegin.getTime())));
        dtBegin = new Date();
        this.OnFetchBIHierarchyDatas();
        dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"\u63d0\u53d6\u6570\u636e\u8017\u65f6[%1$s]\u6beb\u79d2", (Object)(dtEnd.getTime() - dtBegin.getTime())));
    }

    protected void OnInsertIntoGroupCacheTable() throws Exception {
        if (this.groupBIHierarchies.size() == 0) {
            return;
        }
        Vector<BaseDataEntity> groupList = new Vector<BaseDataEntity>();
        IBIHierarchyHelper iBIHierarchyHelper = (IBIHierarchyHelper)this.groupBIHierarchies.get(0);
        BaseDataEntity groupData = new BaseDataEntity();
        groupList.add(groupData);
        this.OnCalcGroupDatas(1, groupData, groupList);
        Vector<String> levelList = new Vector<String>();
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            BaseDataEntity groupData2 = new BaseDataEntity();
            groupData2.SetParamValue(iBILevelHelper.getShortId(), (Object)"GROUP");
            groupList.add(groupData2);
            for (String string : levelList) {
                groupData2.SetParamValue(string, (Object)"GROUP");
            }
            levelList.add(iBILevelHelper.getShortId());
            this.OnCalcGroupDatas(1, groupData2, groupList);
        }
        for (BaseDataEntity groupData3 : groupList) {
            boolean bFirst = true;
            StringBuilderEx stringBuilder = new StringBuilderEx();
            stringBuilder.Append("INSERT INTO %1$s (SRFALL\n", (Object)(String.valueOf(this.getCacheTableName()) + "_G"));
            bFirst = false;
            for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("%1$s", (Object)iBILevelHelper.getShortId());
            }
            for (IBICubeMeasureHelper iBICubeMeasureHelper : this.getBICube().getBICubeMeasures()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("%1$s", (Object)iBICubeMeasureHelper.getShortId());
            }
            stringBuilder.Append(")\n");
            stringBuilder.Append(" SELECT '1'\n");
            bFirst = false;
            boolean bAllGroup = true;
            for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                Iterator strLevelGroup = groupData3.GetParamStringValue(iBILevelHelper.getShortId(), "(ALL)");
                if (StringHelper.Compare((String)"GROUP", (String)((Object)strLevelGroup), (boolean)true) == 0) {
                    stringBuilder.Append("%1$s", (Object)iBILevelHelper.getShortId());
                    continue;
                }
                stringBuilder.Append("'(ALL)'");
                bAllGroup = false;
            }
            if (bAllGroup) continue;
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            for (IBICubeMeasureHelper iBICubeMeasureHelper : this.getBICube().getBICubeMeasures()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("%1$s", (Object)this.OnGetBICubeMeasureExpression(hashtable, iBICubeMeasureHelper, true));
            }
            stringBuilder.Append(" FROM \n");
            stringBuilder.Append(" %1$s t1\n", (Object)this.getCacheTableName());
            stringBuilder.Append("GROUP BY \n");
            bFirst = true;
            for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
                String strLevelGroup = groupData3.GetParamStringValue(iBILevelHelper.getShortId(), "(ALL)");
                if (StringHelper.Compare((String)"GROUP", (String)strLevelGroup, (boolean)true) != 0) continue;
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(",");
                }
                stringBuilder.Append("%1$s", (Object)iBILevelHelper.getShortId());
            }
            if (bFirst) {
                stringBuilder.Append("SRFALL");
            }
            Date dtBegin = new Date();
            CallResult callResult = this.CallDBSql(stringBuilder.toString());
            if (callResult.IsError()) {
                throw new Exception(callResult.getErrorInfo());
            }
            Date dtEnd = new Date();
            log.debug((Object)StringHelper.Format((String)"\u5206\u7ec4\u8bed\u53e5\uff0c\u6267\u884c[%2$sms]:\r\n%1$s", (Object)stringBuilder.toString(), (Object)(dtEnd.getTime() - dtBegin.getTime())));
        }
    }

    protected void OnCalcGroupDatas(int nLevel, BaseDataEntity groupData, Vector<BaseDataEntity> groupList) throws Exception {
        if (this.groupBIHierarchies.size() <= nLevel) {
            return;
        }
        IBIHierarchyHelper iBIHierarchyHelper = (IBIHierarchyHelper)this.groupBIHierarchies.get(nLevel);
        this.OnCalcGroupDatas(nLevel + 1, groupData, groupList);
        Vector<String> levelList = new Vector<String>();
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            BaseDataEntity activeGroup = new BaseDataEntity();
            groupData.CopyTo(activeGroup, true);
            groupList.add(activeGroup);
            groupData.SetParamValue(iBILevelHelper.getShortId(), (Object)"GROUP");
            for (String strLastLevelId : levelList) {
                activeGroup.SetParamValue(strLastLevelId, (Object)"GROUP");
            }
            levelList.add(iBILevelHelper.getShortId());
            this.OnCalcGroupDatas(nLevel + 1, activeGroup, groupList);
        }
    }

    protected void OnCreateCacheTableIndex() throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(" CREATE INDEX \"I_%1$s\" \n", (Object)Helper.GenGuidEx().substring(0, 16));
        stringBuilder.Append(" ON \"%1$s\" \n", (Object)this.getCacheTableName());
        stringBuilder.Append("(SRFALL\n");
        boolean bFirst = false;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("\"%1$s\" %2$s", (Object)iBILevelHelper.getShortId(), (Object)"ASC");
        }
        stringBuilder.Append(")\n");
        stringBuilder.Append(" DISALLOW REVERSE SCANS \n");
        CallResult callResult = this.CallDBSql(stringBuilder.toString());
        if (callResult.IsError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }

    protected void OnFetchBIHierarchyDatas() throws Exception {
        int i = 0;
        while (i < this.biHierarchyFilters.size()) {
            BIHierarchyFilter biHierarchyFilter = (BIHierarchyFilter)this.biHierarchyFilters.get(i);
            IBIHierarchyHelper iBIHierarchyHelper = (IBIHierarchyHelper)this.groupBIHierarchies.get(i);
            this.OnFetchBIHierarchyData(biHierarchyFilter, iBIHierarchyHelper, "");
            ++i;
        }
    }

    @Override
    protected void OnFetchBIHierarchyData(BIHierarchyFilter biHierarchyFilter, IBIHierarchyHelper iBIHierarchyHelper, String strExtQuery) throws Exception {
        String strTotalKey = biHierarchyFilter.getBIHierarchy();
        if (!StringHelper.IsNullOrEmpty((String)strExtQuery)) {
            strTotalKey = String.valueOf(strTotalKey) + "|";
            strTotalKey = String.valueOf(strTotalKey) + strExtQuery;
        }
        if (this.biHierarchyDataMap.containsKey(strTotalKey)) {
            return;
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(" SELECT * from (\n");
        stringBuilder.Append(" SELECT \n");
        boolean bFirst = true;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s.%2$s as %3$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getColumnName(), (Object)iBILevelHelper.getShortId());
            stringBuilder.Append(",");
            stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getSortColumnName());
        }
        stringBuilder.Append(" FROM %1$s %2$s\n", (Object)iBIHierarchyHelper.getTableName(), (Object)iBIHierarchyHelper.getShortId());
        if (!StringHelper.IsNullOrEmpty((String)biHierarchyFilter.getFilters()) || !StringHelper.IsNullOrEmpty((String)strExtQuery)) {
            String strCondition = this.OnGetAllBIHierarchySqlCondition(iBIHierarchyHelper, biHierarchyFilter.getFilters());
            Iterator strCondition2 = this.OnGetAllBIHierarchySqlCondition(iBIHierarchyHelper, strExtQuery);
            String strTotalCondition = "";
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strTotalCondition = String.valueOf(strTotalCondition) + StringHelper.Format((String)"(%1$s)", (Object)strCondition);
            }
            if (!StringHelper.IsNullOrEmpty((String)((Object)strCondition2))) {
                if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
                    strTotalCondition = String.valueOf(strTotalCondition) + " AND ";
                }
                strTotalCondition = String.valueOf(strTotalCondition) + StringHelper.Format((String)"(%1$s)", (Object)strCondition2);
            }
            if (!StringHelper.IsNullOrEmpty((String)strTotalCondition)) {
                stringBuilder.Append(" WHERE ( %1$s )\n", (Object)strTotalCondition);
            }
        }
        stringBuilder.Append("GROUP BY \n ROLLUP(");
        bFirst = true;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getColumnName());
            if (StringHelper.Compare((String)iBILevelHelper.getColumnName(), (String)iBILevelHelper.getSortColumnName(), (boolean)true) == 0) continue;
            stringBuilder.Append(",");
            stringBuilder.Append("%1$s.%2$s", (Object)iBILevelHelper.getBIHierarchy().getShortId(), (Object)iBILevelHelper.getSortColumnName());
        }
        stringBuilder.Append(")\n");
        stringBuilder.Append(") A \n");
        stringBuilder.Append("ORDER BY \n");
        bFirst = true;
        for (IBILevelHelper iBILevelHelper : this.groupBILevels) {
            if (iBILevelHelper.getBIHierarchy() != iBIHierarchyHelper) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append(iBILevelHelper.getSortColumnName());
        }
        Vector dataEntities = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strDBStorage, (String)stringBuilder.toString(), dataEntities, (String)"");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ef4\u5ea6\u660e\u7ec6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, String> dupMap = new Hashtable<String, String>();
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        for (BaseDataEntity dataEntity : dataEntities) {
            String strDataKey = iBIHierarchyHelper.getDataKey(dataEntity);
            if (dupMap.containsKey(strDataKey) || strDataKey.indexOf("(ALL)") == 0 && !iBIHierarchyHelper.isHasAll()) continue;
            dupMap.put(strDataKey, "");
            list.add(dataEntity);
        }
        this.biHierarchyDataMap.put(strTotalKey, list);
    }

    @Override
    protected String OnGetSortSQL(String strSQL, BICubeCacheSortInfo sortInfo) {
        StringBuilderEx script = new StringBuilderEx();
        if (!StringHelper.IsNullOrEmpty((String)sortInfo.getSortField())) {
            script.Append("SELECT * FROM (Select m1.*, rownum  as SRFROWINDEX from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s) m1 ", (Object)strSQL, (Object)sortInfo.getSortField(), (Object)sortInfo.getSortDir());
        } else {
            script.Append("SELECT * FROM (Select m1.*, rownum as SRFROWINDEX from (%1$s) m1 ", (Object)strSQL);
        }
        script.Append(" ) AS a1 WHERE a1.SRFROWINDEX >= %1$s and a1.SRFROWINDEX < %2$s ", (Object)1, (Object)(0 + sortInfo.getTopCount() + 1));
        return script.toString();
    }
}

