/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;

public interface IPSDEMainStateAction
extends IPSModelObject {
    public IPSDEMainState getPSDEMainState();

    public String getPSDEActionId();

    public IPSDEAction getPSDEAction();
}

