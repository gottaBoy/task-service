/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.db.IDataSet;

public class DBCallResult
extends CallResult {
    protected HashMap<String, Object> outputMap = null;
    protected IDataSet iDataSet = null;
    private int nUpdateCount = -1;

    public IDataSet getDataSet() {
        return this.iDataSet;
    }

    public void setDataSet(IDataSet iDataSet) {
        this.iDataSet = iDataSet;
    }

    public HashMap<String, Object> getOutputValues(boolean bCreate) {
        if (this.outputMap == null && bCreate) {
            this.outputMap = new HashMap();
        }
        return this.outputMap;
    }

    public void from(DBCallResult result) {
        HashMap<String, Object> paramMap = result.getOutputValues(false);
        if (paramMap != null) {
            HashMap<String, Object> curMap = this.getOutputValues(true);
            curMap.putAll(paramMap);
        }
        this.setDataSet(result.getDataSet());
        super.from(result);
    }

    public void setUpdateCount(int nUpdateCount) {
        this.nUpdateCount = nUpdateCount;
    }

    public int getUpdateCount() {
        return this.nUpdateCount;
    }
}

