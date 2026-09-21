/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.psba.dao.IBASelectFilter;

public class BASelectFilter
extends SelectFieldFilter
implements IBASelectFilter {
    private String strColSet = null;
    private String strBAFilterType = null;

    @Override
    public String getColSet() {
        return this.strColSet;
    }

    public void setColSet(String strColSet) {
        this.strColSet = strColSet;
    }

    @Override
    public String getBAFilterType() {
        return this.strBAFilterType;
    }

    public void setBAFilterType(String strBAFilterType) {
        this.strBAFilterType = strBAFilterType;
    }
}

