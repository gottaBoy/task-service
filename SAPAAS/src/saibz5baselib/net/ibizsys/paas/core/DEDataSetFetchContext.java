/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataSetFetchContext
extends ActionContext
implements IDEDataSetFetchContext {
    public static final String ATTR_START = "start";
    public static final String ATTR_SIZE = "size";
    public static final String ATTR_SORT = "sort";
    public static final String ATTR_SORTDIR = "sortdir";
    public static final String ATTR_SORT2 = "sort2";
    public static final String ATTR_SORT2DIR = "sort2dir";
    public static final String ATTR_ACTIVEDATA = "activedata";
    public static final String ATTR_JOINSCRIPT = "joinscript";
    public static final String ATTR_GROUPTOP = "grouptop";
    public static final String ATTR_FETCHDATA = "fetchdata";
    public static final String ATTR_FETCHTOTAL = "fetchtotal";
    public static final String ATTR_FETCHINFO = "fetchinfo";
    public static final String ATTR_CACHE = "cache";
    public static final String ATTR_PAGING = "paging";
    public static final String ATTR_CONDS = "conds";
    private static ThreadLocal<IDEDataSetFetchContext> deDataSetFetchContext = new ThreadLocal();
    private static final Log log = LogFactory.getLog(DEDataSetFetchContext.class);
    private int nStartRow = 0;
    private int nPageSize = -1;
    private int nDefaultPageSize = 25;
    private String strSort = null;
    private String strSortDir = "";
    private String strSort2 = null;
    private String strSort2Dir = "";
    private ISimpleDataObject activeDataObject = null;
    private String strJoinScript = "";
    private int nGroupTopCount = -1;
    private boolean bFetchData = true;
    private boolean bFetchTotalRow = true;
    private boolean bCancel = false;
    private String strFetchInfo = "";
    private boolean bCacheDataSet = true;
    private boolean bPaging = true;
    private HashMap<String, String> joinScriptMap = null;
    protected ArrayList<IDEDataSetCond> userConditionList = new ArrayList();

    public DEDataSetFetchContext() {
        super(null);
    }

    public DEDataSetFetchContext(IWebContext iWebContext) {
        super(iWebContext);
        if (iWebContext != null) {
            this.setStartRow(WebContext.getFetchStart(iWebContext, this.nStartRow));
            this.setPageSize(WebContext.getFetchSize(iWebContext, this.nPageSize));
            String strSortParam = WebContext.getSortParam(iWebContext);
            if (!StringHelper.isNullOrEmpty(strSortParam)) {
                try {
                    if (strSortParam.charAt(0) == '{' || strSortParam.charAt(0) == '[') {
                        JSONObject item;
                        JSONArray jo = JSONArray.fromString((String)strSortParam);
                        if (jo.length() >= 1) {
                            item = jo.getJSONObject(0);
                            this.strSort = item.optString("property", "");
                            this.strSortDir = item.optString("direction", "ASC");
                        }
                        if (jo.length() >= 2) {
                            item = jo.getJSONObject(1);
                            this.strSort2 = item.optString("property", "");
                            this.strSort2Dir = item.optString("direction", "ASC");
                        }
                    } else {
                        this.strSort = strSortParam;
                        this.strSortDir = WebContext.getSortDir(iWebContext);
                        if (StringHelper.isNullOrEmpty(this.strSortDir)) {
                            this.strSortDir = "asc";
                        }
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    @Override
    public int getStartRow() {
        return this.nStartRow;
    }

    @Override
    public int getPageSize() {
        if (this.nPageSize <= 0) {
            return this.getDefaultPageSize();
        }
        return this.nPageSize;
    }

    @Override
    public String getSort() {
        return this.strSort;
    }

    @Override
    public String getSortDir() {
        return this.strSortDir;
    }

    @Override
    public String getSort2() {
        return this.strSort2;
    }

    @Override
    public String getSort2Dir() {
        return this.strSort2Dir;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public void setSort(String strSort) {
        this.strSort = strSort;
    }

    public void setSortDir(String strSortDir) {
        this.strSortDir = strSortDir;
    }

    public void setSort2(String strSort2) {
        this.strSort2 = strSort2;
    }

    public void setSort2Dir(String strSort2Dir) {
        this.strSort2Dir = strSort2Dir;
    }

    @Override
    public ArrayList<IDEDataSetCond> getConditionList() {
        return this.userConditionList;
    }

    @Override
    public String getDeclareScript() {
        return "";
    }

    @Override
    public void fillDeclareParams(SqlParamList list) throws Exception {
    }

    @Override
    public ISimpleDataObject getActiveDataObject() {
        return this.activeDataObject;
    }

    @Override
    public void setActiveDataObject(ISimpleDataObject activeDataObject) {
        this.activeDataObject = activeDataObject;
    }

    public void resetSortInfo() {
        this.setSort("");
        this.setSort2("");
        this.setSortDir("");
        this.setSort2Dir("");
        this.setJoinScript("");
    }

    @Override
    public String getJoinScript() {
        if (this.joinScriptMap == null) {
            return this.strJoinScript;
        }
        String strTotal = "";
        if (!StringHelper.isNullOrEmpty(this.strJoinScript)) {
            strTotal = String.valueOf(strTotal) + this.strJoinScript;
        }
        for (String strValue : this.joinScriptMap.values()) {
            strTotal = String.valueOf(strTotal) + strValue;
        }
        return strTotal;
    }

    @Override
    public void setJoinScript(String strJoinScript) {
        this.strJoinScript = strJoinScript;
    }

    @Override
    public int getGroupTopCount() {
        return this.nGroupTopCount;
    }

    public void setGroupTopCount(int nGroupTopCount) {
        this.nGroupTopCount = nGroupTopCount;
    }

    @Override
    public boolean isFetchData() {
        return this.bFetchData;
    }

    public void setFetchData(boolean bFetchData) {
        this.bFetchData = bFetchData;
    }

    @Override
    public boolean isFetchTotalRow() {
        return this.bFetchTotalRow;
    }

    public void setFetchTotalRow(boolean bFetchTotalRow) {
        this.bFetchTotalRow = bFetchTotalRow;
    }

    public static IDEDataSetFetchContext getCurrent() {
        return deDataSetFetchContext.get();
    }

    public static void setCurrent(IDEDataSetFetchContext value) {
        deDataSetFetchContext.set(value);
    }

    @Override
    public boolean isCancel() {
        return this.bCancel;
    }

    @Override
    public void setCancel(boolean bCancel) {
        this.bCancel = bCancel;
    }

    public static void enableOrgDRCond(IDEDataSetFetchContext deDataSetFetchContextImpl, IDEField orgIdDEField, IDEField secIdDEField, ArrayList<String> condList) throws Exception {
        if (condList.size() == 0) {
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond(StringHelper.format("1<>1"));
            deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
        } else {
            String strJoinCode;
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            boolean bFirst = true;
            int i = 0;
            while (i < condList.size()) {
                if (!StringHelper.isNullOrEmpty(condList.get(i))) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        sBuilderEx.append(" OR ");
                    }
                    sBuilderEx.append(condList.get(i));
                }
                ++i;
            }
            boolean bJoinOrg = true;
            boolean bJoinOrgSector = true;
            String strCode = sBuilderEx.toString();
            sBuilderEx.reset();
            if (bJoinOrg && orgIdDEField != null) {
                sBuilderEx.append(" INNER JOIN T_SRFORG o1  ON  ${srfdefieldexp('%1$s')} = o1.ORGID ", orgIdDEField.getName());
            }
            if (bJoinOrgSector && secIdDEField != null) {
                sBuilderEx.append(" INNER JOIN T_SRFORGSECTOR o2  ON ${srfdefieldexp('%1$s')} = o2.ORGSECTORID ", secIdDEField.getName());
            }
            if (!StringHelper.isNullOrEmpty(strJoinCode = deDataSetFetchContextImpl.getJoinScript())) {
                if (strJoinCode.indexOf(sBuilderEx.toString()) == -1) {
                    strJoinCode = String.valueOf(strJoinCode) + sBuilderEx.toString();
                }
            } else {
                strJoinCode = sBuilderEx.toString();
            }
            deDataSetFetchContextImpl.setJoinScript(strJoinCode);
            if (!StringHelper.isNullOrEmpty(strCode)) {
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("CUSTOM");
                deDataSetCondImpl.setCustomCond(strCode);
                deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
            }
        }
    }

    @Override
    public String getFetchInfo() {
        return this.strFetchInfo;
    }

    public void setFetchInfo(String strFetchInfo) {
        this.strFetchInfo = strFetchInfo;
    }

    @Override
    public boolean isCacheDataSet() {
        return this.bCacheDataSet;
    }

    public void setCacheDataSet(boolean bCacheDataSet) {
        this.bCacheDataSet = bCacheDataSet;
    }

    public void setDefaultPageSize(int nDefaultPageSize) {
        this.nDefaultPageSize = nDefaultPageSize;
    }

    public int getDefaultPageSize() {
        return this.nDefaultPageSize;
    }

    public void setJoinScript(String strMode, String strJoinScript) {
        if (StringHelper.isNullOrEmpty(strJoinScript)) {
            if (this.joinScriptMap == null) {
                return;
            }
            this.joinScriptMap.remove(strMode);
        } else {
            if (this.joinScriptMap == null) {
                this.joinScriptMap = new HashMap();
            }
            this.joinScriptMap.put(strMode, strJoinScript);
        }
    }

    @Override
    public boolean isPaging() {
        return this.bPaging;
    }

    public void setPaging(boolean bPaging) {
        this.bPaging = bPaging;
    }

    public static JSONObject toJSONObject(IDEDataSetFetchContext iDEDataSetFetchContext, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if (iDEDataSetFetchContext.getStartRow() >= 0) {
            JSONObjectHelper.put(jsonObject, ATTR_START, iDEDataSetFetchContext.getStartRow());
        }
        if (iDEDataSetFetchContext.getPageSize() > 0) {
            JSONObjectHelper.put(jsonObject, ATTR_SIZE, iDEDataSetFetchContext.getPageSize());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort())) {
            JSONObjectHelper.put(jsonObject, ATTR_SORT, iDEDataSetFetchContext.getSort());
            if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSortDir())) {
                JSONObjectHelper.put(jsonObject, ATTR_SORTDIR, iDEDataSetFetchContext.getSortDir());
            }
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2())) {
            JSONObjectHelper.put(jsonObject, ATTR_SORT2, iDEDataSetFetchContext.getSort2());
            if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2Dir())) {
                JSONObjectHelper.put(jsonObject, ATTR_SORT2DIR, iDEDataSetFetchContext.getSort2Dir());
            }
        }
        if (iDEDataSetFetchContext.getActiveDataObject() != null) {
            jsonObject.put(ATTR_ACTIVEDATA, (Object)DataObject.toJSONObject((IDataObject)iDEDataSetFetchContext.getActiveDataObject(), false));
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())) {
            JSONObjectHelper.put(jsonObject, ATTR_JOINSCRIPT, iDEDataSetFetchContext.getJoinScript());
        }
        if (iDEDataSetFetchContext.getGroupTopCount() >= 0) {
            JSONObjectHelper.put(jsonObject, ATTR_GROUPTOP, iDEDataSetFetchContext.getGroupTopCount());
        }
        JSONObjectHelper.put(jsonObject, ATTR_FETCHDATA, iDEDataSetFetchContext.isFetchData());
        JSONObjectHelper.put(jsonObject, ATTR_FETCHTOTAL, iDEDataSetFetchContext.isFetchTotalRow());
        if (!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getFetchInfo())) {
            JSONObjectHelper.put(jsonObject, ATTR_FETCHINFO, iDEDataSetFetchContext.getFetchInfo());
        }
        JSONObjectHelper.put(jsonObject, ATTR_CACHE, iDEDataSetFetchContext.isCacheDataSet());
        JSONObjectHelper.put(jsonObject, ATTR_PAGING, iDEDataSetFetchContext.isPaging());
        ArrayList<IDEDataSetCond> deDataSetCondList = iDEDataSetFetchContext.getConditionList();
        if (deDataSetCondList != null && deDataSetCondList.size() > 0) {
            ArrayList<JSONObject> joList = new ArrayList<JSONObject>();
            for (IDEDataSetCond iDEDataSetCond : deDataSetCondList) {
                joList.add(DEDataSetCond.toJSONObject(iDEDataSetCond, null));
            }
            jsonObject.put(ATTR_CONDS, (Object)JSONArray.fromCollection(joList));
        }
        return jsonObject;
    }

    public static IDEDataSetFetchContext fromJSONObject(JSONObject jsonObject) throws Exception {
        int nGroupTop;
        String strJoinScript;
        JSONObject activeDataJO;
        String strSort2;
        String strSort;
        int nPageSize;
        DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext();
        int nStartRow = jsonObject.optInt(ATTR_START, -1);
        if (nStartRow >= 0) {
            deDataSetFetchContext.setStartRow(nStartRow);
        }
        if ((nPageSize = jsonObject.optInt(ATTR_SIZE, -1)) > 0) {
            deDataSetFetchContext.setPageSize(nPageSize);
        }
        if (!StringHelper.isNullOrEmpty(strSort = jsonObject.optString(ATTR_SORT, null))) {
            deDataSetFetchContext.setSort(strSort);
            String strSortDir = jsonObject.optString(ATTR_SORTDIR, null);
            if (!StringHelper.isNullOrEmpty(strSortDir)) {
                deDataSetFetchContext.setSortDir(strSortDir);
            }
        }
        if (!StringHelper.isNullOrEmpty(strSort2 = jsonObject.optString(ATTR_SORT2, null))) {
            deDataSetFetchContext.setSort2(strSort2);
            String strSort2Dir = jsonObject.optString(ATTR_SORT2DIR, null);
            if (!StringHelper.isNullOrEmpty(strSort2Dir)) {
                deDataSetFetchContext.setSort2Dir(strSort2Dir);
            }
        }
        if ((activeDataJO = jsonObject.optJSONObject(ATTR_ACTIVEDATA)) != null) {
            deDataSetFetchContext.setActiveDataObject(DataObject.fromJSONObject(activeDataJO));
        }
        if (!StringHelper.isNullOrEmpty(strJoinScript = jsonObject.optString(ATTR_JOINSCRIPT, null))) {
            deDataSetFetchContext.setJoinScript(strJoinScript);
        }
        if ((nGroupTop = jsonObject.optInt(ATTR_GROUPTOP, -1)) >= 0) {
            deDataSetFetchContext.setGroupTopCount(nGroupTop);
        }
        deDataSetFetchContext.setFetchData(jsonObject.optBoolean(ATTR_FETCHDATA, true));
        deDataSetFetchContext.setFetchTotalRow(jsonObject.optBoolean(ATTR_FETCHTOTAL, true));
        String strFetchInfo = jsonObject.optString(ATTR_FETCHINFO, null);
        if (!StringHelper.isNullOrEmpty(strFetchInfo)) {
            deDataSetFetchContext.setFetchInfo(strFetchInfo);
        }
        deDataSetFetchContext.setCacheDataSet(jsonObject.optBoolean(ATTR_CACHE, true));
        deDataSetFetchContext.setPaging(jsonObject.optBoolean(ATTR_PAGING, true));
        JSONArray condJA = jsonObject.optJSONArray(ATTR_CONDS);
        if (condJA != null) {
            int i = 0;
            while (i < condJA.length()) {
                JSONObject jo = condJA.getJSONObject(i);
                IDEDataSetCond iDEDataSetCond = DEDataSetCond.fromJSONObject(jo);
                deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
                ++i;
            }
        }
        return deDataSetFetchContext;
    }
}

