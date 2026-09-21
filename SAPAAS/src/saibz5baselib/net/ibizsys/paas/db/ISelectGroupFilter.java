/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.db.ISelectFilter;

public interface ISelectGroupFilter
extends ISelectFilter,
IDEDataQueryCodeCond {
    public ArrayList<IDEDataQueryCodeCond> getSelectFilterList(boolean var1);
}

