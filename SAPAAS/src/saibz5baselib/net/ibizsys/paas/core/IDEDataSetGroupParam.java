/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IModelBase;

public interface IDEDataSetGroupParam
extends IModelBase {
    public IDEDataSet getDEDataSet();

    public String getGroupCode();

    public String[] getGroupFields();

    public String getSortDir();

    public int getSortOrder();

    public boolean isReCalc();

    public boolean isEnableGroup();
}

