/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.wf.IPSWFRole;

public interface IPSWFDEDataSetRole
extends IPSWFRole {
    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getWFUserIdPSDEF();

    public IPSDEField getWFUserNamePSDEF();
}

