/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.pswf.core.IWFProcSubWFModel;

public interface IPSWFProcessSubWF
extends IWFProcSubWFModel {
    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public String getCodeName();
}

