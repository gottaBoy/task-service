/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.db.IProcParam;

public interface IDEDBSysProcAction
extends IDEAction {
    @Override
    public int getTimeOut();

    public String getDBProcName();

    public String getActionMode();

    public Iterator<IProcParam> getProcParams(String var1) throws Exception;
}

