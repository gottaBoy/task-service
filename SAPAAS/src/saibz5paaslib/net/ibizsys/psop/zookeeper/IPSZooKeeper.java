/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.zookeeper.ZooKeeper
 */
package net.ibizsys.psop.zookeeper;

import net.ibizsys.psop.zookeeper.IPSObjectKeeper;
import org.apache.zookeeper.ZooKeeper;

public interface IPSZooKeeper {
    public ZooKeeper getZooKeeper();

    public String getDomain();

    public boolean dealException(IPSObjectKeeper var1, Exception var2) throws Exception;

    public boolean isConnected();
}

