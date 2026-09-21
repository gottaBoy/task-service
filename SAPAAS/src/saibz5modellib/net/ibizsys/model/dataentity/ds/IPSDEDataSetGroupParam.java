/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetGroupParam
 */
package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.core.IDEDataSetGroupParam;

public interface IPSDEDataSetGroupParam
extends IPSModelObject,
IDEDataSetGroupParam {
    public IPSDEDataSet getPSDEDataSet();

    public int getStdDataType();
}

