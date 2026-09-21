/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.psop.zookeeper.IPSZooKeeperEntity
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.psop.zookeeper.IPSZooKeeperEntity;

public class PSDevSlnSys
extends PSDevSlnSysBase
implements IPSZooKeeperEntity {
    private int nZKDataVersion = -1;
    private long nRTLastActiveTime = 0L;

    public int getZKDataVersion() {
        return this.nZKDataVersion;
    }

    public void setZKDataVersion(int n) {
        this.nZKDataVersion = n;
    }

    public long getRTLastActiveTime() {
        return this.nRTLastActiveTime;
    }

    public void setRTLastActiveTime(long l) {
        this.nRTLastActiveTime = l;
    }
}

