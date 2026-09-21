/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.zookeeper.WatchedEvent
 *  org.apache.zookeeper.Watcher$Event$EventType
 *  org.apache.zookeeper.data.Stat
 */
package net.ibizsys.psop.zookeeper;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.IPSUserKeeper;
import net.ibizsys.psop.zookeeper.IPSZooKeeper;
import net.ibizsys.psop.zookeeper.PSObjectKeeperBase;
import net.ibizsys.psop.zookeeper.PSZooKeeper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

public class PSUserKeeper
extends PSObjectKeeperBase
implements IPSUserKeeper {
    private static IPSUserKeeper iPSUserKeeper = null;
    private HashMap<String, String> userMap = new HashMap();
    public static final String strUserPathPrefix = "/PSUSER/";
    private static final String strUserPathPrefix2 = "/PSUSER";

    public PSUserKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
        super(iPSZooKeeper);
        this.exists(strUserPathPrefix2, "".getBytes(), true, false);
    }

    @Override
    public void loginUser(String strUserId, String strSessionId) throws Exception {
        String strUserPath = StringHelper.format((String)"%1$s%2$s", (Object)strUserPathPrefix, (Object)strUserId);
        Stat stat = this.exists(strUserPath, "".getBytes(), true);
        this.setData(strUserPath, strSessionId.getBytes("UTF-8"));
    }

    @Override
    public void logoutUser(String strUserId, String strSessionId) throws Exception {
        String strUserPath = StringHelper.format((String)"%1$s%2$s", (Object)strUserPathPrefix, (Object)strUserId);
        Stat stat = this.exists(strUserPath, "".getBytes(), false);
        if (stat == null) {
            return;
        }
        byte[] data = this.getData(strUserPath, stat);
        if (data == null) {
            return;
        }
        String strLastSessionId = new String(data, "UTF-8");
        if (StringHelper.compare((String)strLastSessionId, (String)strSessionId, (boolean)true) == 0) {
            this.setData(strUserPath, "".getBytes());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean activeUser(String strUserId, String strSessionId) throws Exception {
        String strUserPath = StringHelper.format((String)"%1$s%2$s", (Object)strUserPathPrefix, (Object)strUserId);
        String strCurSessionId = null;
        HashMap<String, String> hashMap = this.userMap;
        synchronized (hashMap) {
            strCurSessionId = this.userMap.get(strUserPath);
        }
        return StringHelper.compare((String)strCurSessionId, (String)strSessionId, (boolean)false) == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void onProcessEvent(WatchedEvent event) throws Exception {
        super.onProcessEvent(event);
        if (StringHelper.isNullOrEmpty((Object)event.getType())) {
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeCreated) {
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
            byte[] data = this.getData(event.getPath(), null);
            String strSessionId = null;
            if (data != null) {
                strSessionId = new String(data, "UTF-8");
            }
            HashMap<String, String> hashMap = this.userMap;
            synchronized (hashMap) {
                this.userMap.put(event.getPath(), strSessionId);
            }
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
            HashMap<String, String> hashMap = this.userMap;
            synchronized (hashMap) {
                this.userMap.remove(event.getPath());
            }
            return;
        }
    }

    public static synchronized IPSUserKeeper getCurrent() throws Exception {
        if (iPSUserKeeper == null) {
            PSUserKeeper PSUserKeeper2 = new PSUserKeeper(PSZooKeeper.getCurrent());
            iPSUserKeeper = PSUserKeeper2;
        }
        return iPSUserKeeper;
    }
}

