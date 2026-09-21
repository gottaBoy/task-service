/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDELogicAction
extends IPSDEAction {
    public IPSDELogic getPSDELogic() throws Exception;
}

