/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import net.ibizsys.paas.entity.IEntityActionHelper;

public interface IEntityActionSupporter {
    public void setActionHelper(IEntityActionHelper var1);

    public IEntityActionHelper getActionHelper();

    public void create() throws Exception;

    public void update() throws Exception;

    public void remove() throws Exception;

    public void save() throws Exception;

    public boolean get(boolean var1) throws Exception;

    public void get() throws Exception;

    public boolean select(boolean var1) throws Exception;

    public void select() throws Exception;
}

