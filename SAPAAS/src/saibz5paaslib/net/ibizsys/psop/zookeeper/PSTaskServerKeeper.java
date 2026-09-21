/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psop.zookeeper;

import java.util.HashMap;
import net.ibizsys.psop.zookeeper.IPSUserKeeper;
import net.ibizsys.psop.zookeeper.IPSZooKeeper;
import net.ibizsys.psop.zookeeper.PSObjectKeeperBase;

public class PSTaskServerKeeper
extends PSObjectKeeperBase {
    private static IPSUserKeeper iPSUserKeeper = null;
    private HashMap<String, String> userMap = new HashMap();
    public static final String strTaskServerPathPrefix = "/PSTASKSERVER/";
    private static final String strTaskServerPathPrefix2 = "/PSTASKSERVER";

    public PSTaskServerKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
        super(iPSZooKeeper);
        this.exists(strTaskServerPathPrefix2, "".getBytes(), true, false);
    }
}

