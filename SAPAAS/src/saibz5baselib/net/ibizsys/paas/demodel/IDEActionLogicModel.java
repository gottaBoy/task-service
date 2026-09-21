/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IModelBase3;

public interface IDEActionLogicModel
extends IModelBase3 {
    public String getDEName();

    public String getDEActionName();

    public boolean isCloneParam();

    public boolean isIgnoreException();
}

