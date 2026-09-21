/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;

public interface IPSJITDEModel<ET extends IEntity>
extends IDataEntityModel<ET> {
    public IPSDataEntity getPSDataEntity();

    public IPSJITSystemModel getPSJITSystemModel();
}

