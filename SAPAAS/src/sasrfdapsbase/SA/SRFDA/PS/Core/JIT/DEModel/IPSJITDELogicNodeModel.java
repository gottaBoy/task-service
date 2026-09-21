/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IModelBase
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicModel;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IModelBase;

public interface IPSJITDELogicNodeModel
extends IModelBase {
    public IPSJITDELogicModel getPSJITDELogicModel();

    public IPSDELogicNode getPSDELogicNode();

    public void execute(IActionContext var1) throws Exception;
}

