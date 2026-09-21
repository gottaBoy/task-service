/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.db.ISelectFilter;

public interface ISelectFieldFilter
extends ISelectFilter,
IDEDataQueryCodeCond {
    public Object getCondObjectValue() throws Exception;
}

