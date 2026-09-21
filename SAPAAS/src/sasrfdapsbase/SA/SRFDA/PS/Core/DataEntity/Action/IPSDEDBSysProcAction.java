/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDBSysProcAction
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.core.IDEDBSysProcAction;

@PSModelIgnoreMeta
public interface IPSDEDBSysProcAction
extends IPSDEAction,
IDEDBSysProcAction {
    public String getPSDEDBSysProcId();

    public String getPSDEDBSPActionId();

    public IPSDEDBSysProc getPSDEDBSysProc();
}

