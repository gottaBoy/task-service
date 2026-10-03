/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.GrooveMacroEngine;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupConfig;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DGExFetchResultHelperContext {
    protected ISRFExWebContext webContext = null;
    protected TreeMap<String, Object> paramMap = new TreeMap();
    protected Vector<DGExDataGroupConfig> dataGroupList = new Vector();
    protected Vector<DataRowPair> dataRowList = new Vector();
    private static final Log log = LogFactory.getLog(DGExFetchResultHelperContext.class);
    protected DGExConfig dgExConfig = null;
    protected TreeMap<String, Object> macroValueMap = new TreeMap();
    protected GrooveMacroEngine macroEngine = new GrooveMacroEngine();
    protected int nGroupLevel = 0;
    protected String strDGExUniqueId = "";
    protected String strSortField = "";
    protected String strSortDir = "";
    protected boolean bExportMode = false;

    public ISRFExWebContext getWebContext() {
        return this.webContext;
    }

    public void setWebContext(ISRFExWebContext webContext) {
        this.webContext = webContext;
    }

    public DGExConfig getDGExConfig() {
        return this.dgExConfig;
    }

    public void setDGExConfig(DGExConfig dgExConfig) {
        this.dgExConfig = dgExConfig;
    }

    public void setAttribute(String strKey, Object objValue) {
        strKey = strKey.toUpperCase();
        if (objValue == null) {
            this.paramMap.remove(strKey);
        } else {
            this.paramMap.put(strKey, objValue);
        }
    }

    public Object getAttribute(String strKey) {
        strKey = strKey.toUpperCase();
        return this.paramMap.get(strKey);
    }

    public DGExDataGroupConfig GetActiveDataGroup() {
        if (this.dataGroupList.size() == 0) {
            return null;
        }
        return this.dataGroupList.get(0);
    }

    public void PushDataGroup(DGExDataGroupConfig dataGroupConfig) {
        this.dataGroupList.add(0, dataGroupConfig);
    }

    public void PopDataGroup() {
        if (this.dataGroupList.size() == 0) {
            return;
        }
        this.dataGroupList.remove(0);
    }

    public Vector<DataTable> GetActiveDataGroupGroupDataTables(DataTable dataTable, String strGroupId, Vector<DataTable> dataTables) throws Exception {
        return this.GetDataGroupGroupDataTables(dataTable, strGroupId, dataTables, this.GetActiveDataGroup());
    }

    public Vector<DataTable> GetDataGroupGroupDataTables(DataTable dataTable, String strGroupId, Vector<DataTable> dataTables, DGExDataGroupConfig parentDataGroupConfig) throws Exception {
        DGExDataGroupConfig activeDataGroupConfig = parentDataGroupConfig;
        Vector<DataTable> lastTables = new Vector<DataTable>();
        lastTables.add(dataTable);
        String[] groupIds = strGroupId.split("[.]");
        int i = 0;
        while (i < groupIds.length) {
            String strCurGroupId = groupIds[i];
            if (i == groupIds.length - 1) {
                if (dataTables == null) {
                    dataTables = new Vector();
                }
                for (DataTable dataTable2 : lastTables) {
                    int j = 0;
                    while (j < dataTable2.GetRowCount()) {
                        DataRow dr = dataTable2.GetRow(j);
                        DataTable tempDataTable = this.FindDataGroupGroupDataTable(dr, strCurGroupId, activeDataGroupConfig);
                        dataTables.add(tempDataTable);
                        ++j;
                    }
                }
            } else {
                Vector<DataTable> vector = new Vector<DataTable>();
                for (DataTable dataTable3 : lastTables) {
                    int j = 0;
                    while (j < dataTable3.GetRowCount()) {
                        DataRow dr = dataTable3.GetRow(j);
                        DataTable tempDataTable = this.FindDataGroupGroupDataTable(dr, strCurGroupId, activeDataGroupConfig);
                        vector.add(tempDataTable);
                        ++j;
                    }
                }
                lastTables.clear();
                lastTables.addAll(vector);
                activeDataGroupConfig = (DGExDataGroupConfig)((Object)activeDataGroupConfig.getDataGroupsConfig().findById(strCurGroupId));
            }
            ++i;
        }
        return dataTables;
    }

    public DataTable FindDataGroupGroupDataTable(DataRow dr, String strGroupId, DGExDataGroupConfig parentDataGroupConfig) throws Exception {
        for (DataRowPair drp : this.dataRowList) {
            if (!drp.isMatch(dr, strGroupId)) continue;
            return drp.getDataTable();
        }
        DGExDataGroupConfig childDataGroupConfig = (DGExDataGroupConfig)((Object)parentDataGroupConfig.getDataGroupsConfig().findById(strGroupId));
        String strSQL = childDataGroupConfig.getDataGroupFetchConfig().getSQL();
        String strSQLParams = childDataGroupConfig.getDataGroupFetchConfig().getSQLParams();
        String[] sqlParams = strSQLParams.split("[|]");
        CallParamList callParamList = new CallParamList();
        int i = 0;
        while (i < sqlParams.length) {
            callParamList.Add(dr.Get(sqlParams[i]));
            ++i;
        }
        SelectResult selectResult = DGExFetchResultHelperContext.SelectMulti(this.getWebContext().getGlobalHelper(), childDataGroupConfig.getDataGroupFetchConfig().getDBStroage(), strSQL, callParamList.GetList());
        if (selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)selectResult.getErrorInfo(), (Object)strSQL));
            return null;
        }
        DataRowPair drp = new DataRowPair(dr, strGroupId);
        drp.setDataTable(selectResult.getMainTable());
        this.dataRowList.add(drp);
        return selectResult.getMainTable();
    }

    public DataTable FindActiveDataGroupGroupDataTable(DataRow dr, String strGroupId) throws Exception {
        return this.FindDataGroupGroupDataTable(dr, strGroupId, this.GetActiveDataGroup());
    }

    public static SelectResult SelectMulti(ISRFExGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector<CallParam> params) throws Exception {
        SelectResult selectResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw3(strSQL, params);
        if (selectResult == null) {
            selectResult = new SelectResult();
            selectResult.setRetCode(1);
            selectResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
            return selectResult;
        }
        return selectResult;
    }

    public void ResetMacroValue() {
        this.macroValueMap.clear();
    }

    public void setMacroValue(String strKey, Object objValue) {
        strKey = strKey.toUpperCase();
        if (objValue == null) {
            this.macroValueMap.remove(strKey);
        } else {
            this.macroValueMap.put(strKey, objValue);
        }
    }

    public Object getMacroValue(String strKey) {
        strKey = strKey.toUpperCase();
        return this.macroValueMap.get(strKey);
    }

    public Object CalcMacroValue(String strMacro) {
        return this.macroEngine.Calc(this, this.macroValueMap, strMacro);
    }

    public Object CalcMacroValue(String strMacro, DataRow dr) {
        return this.macroEngine.Calc(this, dr, strMacro);
    }

    public int getGroupLevel() {
        return this.nGroupLevel;
    }

    public void setGroupLevel(int nGroupLevel) {
        this.nGroupLevel = nGroupLevel;
    }

    public String getDGExUniqueId() {
        return this.strDGExUniqueId;
    }

    public String getSortField() {
        return this.strSortField;
    }

    public void setDGExUniqueId(String strDGExUniqueId) {
        this.strDGExUniqueId = strDGExUniqueId;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }

    public boolean isExportMode() {
        return this.bExportMode;
    }

    public void setExportMode(boolean bExportMode) {
        this.bExportMode = bExportMode;
    }

    public String getSortDir() {
        return this.strSortDir;
    }

    public void setSortDir(String strSortDir) {
        this.strSortDir = strSortDir;
    }

    protected class DataRowPair {
        protected DataTable dataTable = null;
        protected DataRow dr;
        protected String strGroupId;

        public DataRowPair(DataRow dr, String strGroupId) {
            this.dr = dr;
            this.strGroupId = strGroupId;
        }

        public boolean isMatch(DataRow dr, String strGroupId) {
            if (this.dr != dr) {
                return false;
            }
            return StringHelper.Compare((String)strGroupId, (String)this.strGroupId, (boolean)true) == 0;
        }

        public DataTable getDataTable() {
            return this.dataTable;
        }

        public void setDataTable(DataTable dataTable) {
            this.dataTable = dataTable;
        }
    }
}

