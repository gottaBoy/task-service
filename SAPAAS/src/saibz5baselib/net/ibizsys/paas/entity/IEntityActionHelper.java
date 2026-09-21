/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import net.ibizsys.paas.entity.IEntity;

public interface IEntityActionHelper {
    public void create(IEntity var1) throws Exception;

    public void update(IEntity var1) throws Exception;

    public void save(IEntity var1) throws Exception;

    public void remove(IEntity var1) throws Exception;

    public boolean get(IEntity var1, boolean var2) throws Exception;

    public boolean select(IEntity var1, boolean var2) throws Exception;
}

