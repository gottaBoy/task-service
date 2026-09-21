/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDELogicAction
extends IPSDEAction {
    public IPSDELogic getPSDELogic() throws Exception;
}

