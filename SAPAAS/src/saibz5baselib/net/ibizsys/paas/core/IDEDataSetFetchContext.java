/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.SqlParamList;

public interface IDEDataSetFetchContext
extends IActionContext {
    public int getStartRow();

    public int getPageSize();

    public String getSort();

    public String getSortDir();

    public String getSort2();

    public String getSort2Dir();

    public ArrayList<IDEDataSetCond> getConditionList();

    public String getDeclareScript();

    public void fillDeclareParams(SqlParamList var1) throws Exception;

    public ISimpleDataObject getActiveDataObject();

    public void setActiveDataObject(ISimpleDataObject var1);

    public String getJoinScript();

    public int getGroupTopCount();

    public boolean isFetchData();

    public boolean isFetchTotalRow();

    public boolean isCancel();

    public void setCancel(boolean var1);

    public String getFetchInfo();

    public boolean isCacheDataSet();

    public void setJoinScript(String var1);

    public boolean isPaging();
}

