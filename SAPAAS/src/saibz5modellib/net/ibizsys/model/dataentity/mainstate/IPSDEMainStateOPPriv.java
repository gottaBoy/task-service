/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;

public interface IPSDEMainStateOPPriv
extends IPSModelObject {
    public IPSDEMainState getPSDEMainState();

    public String getPSDEOPPrivId();

    public IPSDEOPPriv getPSDEOPPriv();
}

