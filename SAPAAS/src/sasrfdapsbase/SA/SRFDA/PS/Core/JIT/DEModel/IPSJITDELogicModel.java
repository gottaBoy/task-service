/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDELogicModel
 *  net.ibizsys.paas.entity.IEntity
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.entity.IEntity;

public interface IPSJITDELogicModel<ET extends IEntity>
extends IDELogicModel<ET> {
    public IPSJITDELogicNodeModel getPSJITDELogicNodeModel(IPSDELogicNode var1) throws Exception;

    public IPSDELogic getPSDELogic();

    public IPSJITDEModel<ET> getIPSJITDEModel();
}

