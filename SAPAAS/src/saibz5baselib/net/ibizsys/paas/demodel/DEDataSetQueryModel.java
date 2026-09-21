/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.core.IDEDataSetQuery;

public class DEDataSetQueryModel
implements IDEDataSetQuery {
    private DEDataSetQuery deDataSetQuery = null;

    public DEDataSetQueryModel(DEDataSetQuery deDataSetQuery) {
        this.deDataSetQuery = deDataSetQuery;
    }

    @Override
    public String getDEDataQueryId() {
        return this.deDataSetQuery.queryid();
    }
}

