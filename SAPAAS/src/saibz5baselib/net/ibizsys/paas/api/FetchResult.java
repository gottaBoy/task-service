/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import java.util.ArrayList;
import net.ibizsys.paas.db.IDataRow;

public class FetchResult {
    private int nTotalRow = -1;
    private ArrayList<IDataRow> items = new ArrayList();

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    public ArrayList<IDataRow> getDataRows() {
        return this.items;
    }
}

