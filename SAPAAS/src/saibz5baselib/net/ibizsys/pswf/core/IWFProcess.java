/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IWFProcess {
    public void init(IWFProcessModel var1) throws Exception;

    public void execute(IWFActionContext var1) throws Exception;

    public void executeBefore(IWFActionContext var1) throws Exception;

    public void executeAfter(IWFActionContext var1) throws Exception;
}

