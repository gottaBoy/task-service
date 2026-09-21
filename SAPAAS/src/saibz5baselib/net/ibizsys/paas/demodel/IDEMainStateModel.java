/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IModelBase3;

public interface IDEMainStateModel
extends IDEMainState,
IModelBase3 {
    public void registerDEAction(String var1);

    public void registerDEOPPriv(String var1);
}

