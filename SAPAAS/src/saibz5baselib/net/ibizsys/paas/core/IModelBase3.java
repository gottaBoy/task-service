/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase2;

public interface IModelBase3
extends IModelBase2 {
    public Object getAttribute(String var1) throws Exception;

    public boolean getAttribute(String var1, boolean var2) throws Exception;

    public String getAttribute(String var1, String var2) throws Exception;

    public int getAttribute(String var1, int var2) throws Exception;

    public double getAttribute(String var1, double var2) throws Exception;

    public void setAttribute(String var1, Object var2) throws Exception;
}

