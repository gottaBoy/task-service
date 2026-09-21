/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IModelBase3;

public interface IDEUniStateModel
extends IDEUniState,
IModelBase3 {
    public IUniStateModel getUniStateModel() throws Exception;
}

