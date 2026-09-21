/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEUserRole
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public String getRoleTag();
}

