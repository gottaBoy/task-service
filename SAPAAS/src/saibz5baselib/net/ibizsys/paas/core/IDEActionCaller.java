/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionCallContext;
import net.ibizsys.paas.util.IGlobalContext;

public interface IDEActionCaller {
    public void init(IGlobalContext var1, IDEAction var2) throws Exception;

    public void execute(IDEActionCallContext var1) throws Exception;

    public void close();

    public IDEActionCallContext getDEActionCallContext();
}

