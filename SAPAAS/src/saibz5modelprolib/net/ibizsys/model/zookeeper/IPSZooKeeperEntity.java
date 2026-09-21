/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 */
package net.ibizsys.model.zookeeper;

import net.ibizsys.paas.entity.IEntity;

public interface IPSZooKeeperEntity
extends IEntity {
    public int getZKDataVersion();

    public void setZKDataVersion(int var1);
}

