/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.DBCallResult;

public class DBFetchResult
extends DBCallResult {
    protected int nTotalRow = -1;

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void from(DBFetchResult result) {
        this.setTotalRow(result.getTotalRow());
        super.from(result);
    }
}

