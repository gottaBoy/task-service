/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataChangeDispatchParam;
import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;

public interface IDEDataChangeDispatcher {
    public void init(DEDataChgDisp var1) throws Exception;

    public String getName();

    public void dispatch(IDEDataChangeDispatchParam var1) throws Exception;
}

