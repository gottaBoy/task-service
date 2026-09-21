/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.zookeeper.CreateMode
 *  org.apache.zookeeper.KeeperException$BadVersionException
 *  org.apache.zookeeper.KeeperException$ConnectionLossException
 *  org.apache.zookeeper.KeeperException$SessionExpiredException
 *  org.apache.zookeeper.WatchedEvent
 *  org.apache.zookeeper.Watcher
 *  org.apache.zookeeper.Watcher$Event$KeeperState
 *  org.apache.zookeeper.ZooDefs$Ids
 *  org.apache.zookeeper.ZooKeeper
 *  org.apache.zookeeper.ZooKeeper$States
 *  org.apache.zookeeper.data.Stat
 */
package net.ibizsys.psop.zookeeper;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.IPSObjectKeeper;
import net.ibizsys.psop.zookeeper.IPSZooKeeper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class PSZooKeeper
implements IPSZooKeeper {
    private static final Log log = LogFactory.getLog(PSZooKeeper.class);
    private static IPSZooKeeper iPSZooKeeper = null;
    private static HashMap<String, IPSZooKeeper> psZooKeeperCatMap = new HashMap();
    private int sessionTimeout = 3000;
    private ZooKeeper zk = null;
    private Properties cfg = new Properties();
    private String strDomain = "/PS";
    private static Object objPSZooKeeperLock = new Object();

    public PSZooKeeper() throws Exception {
        this.cfg.load(PSZooKeeper.class.getClassLoader().getResourceAsStream("saps-zookeeper.properties"));
        this.strDomain = PropertiesHelper.getProperty((Properties)this.cfg, (String)"zookeeper.domain", (String)this.strDomain);
        this.open();
    }

    public void open() throws Exception {
        String strHosts = PropertiesHelper.getProperty((Properties)this.cfg, (String)"zookeeper.hosts");
        if (StringHelper.isNullOrEmpty((String)strHosts)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49ZooKeeper\u4e3b\u673a");
        }
        ZooKeeper zk = new ZooKeeper(strHosts, this.sessionTimeout, new Watcher(){

            public void process(WatchedEvent event) {
                PSZooKeeper.this.processEvent(event);
            }
        });
        Stat stat = zk.exists(this.strDomain, null);
        if (stat == null) {
            zk.create(this.strDomain, new String("").getBytes(), (List)ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u8def\u5f84[%1$s]\u6210\u529f", (Object)this.strDomain));
        }
        this.zk = zk;
    }

    public void close() {
        if (this.zk != null) {
            try {
                this.zk.close();
                log.info((Object)"\u91ca\u653eZooKeeper\u8fde\u63a5\u6210\u529f\uff01");
            }
            catch (InterruptedException e) {
                log.error((Object)e);
            }
            this.zk = null;
        }
    }

    protected synchronized boolean reopen() {
        block3: {
            try {
                ZooKeeper zk = this.zk;
                if (zk == null || zk.getState() != ZooKeeper.States.CONNECTED && zk.getState() != ZooKeeper.States.CONNECTEDREADONLY) break block3;
                return true;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return false;
            }
        }
        this.close();
        this.open();
        return true;
    }

    protected void processEvent(WatchedEvent event) {
        if (event.getType() == null || "".equals(event.getType())) {
            return;
        }
        if (event.getPath() != null) {
            log.debug((Object)("ZooKeeper \u5df2\u7ecf\u89e6\u53d1\u4e86[" + event.getPath() + "] " + event.getType() + "\u4e8b\u4ef6\uff01"));
        } else {
            log.debug((Object)("ZooKeeper \u5df2\u7ecf\u89e6\u53d1\u4e86" + event.getType() + "\u4e8b\u4ef6\uff01"));
            if (event.getState() != null) {
                log.debug((Object)("ZooKeeper \u72b6\u6001[" + event.getState() + "]"));
                if (event.getState() == Watcher.Event.KeeperState.Disconnected) {
                    return;
                }
                if (event.getState() == Watcher.Event.KeeperState.Expired) {
                    this.reopen();
                    return;
                }
                if (event.getState() == Watcher.Event.KeeperState.ConnectedReadOnly) {
                    return;
                }
            }
        }
    }

    @Override
    public ZooKeeper getZooKeeper() {
        return this.zk;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IPSZooKeeper getCurrent() throws Exception {
        if (iPSZooKeeper == null) {
            PSZooKeeper psZooKeeper = new PSZooKeeper();
            Object object = objPSZooKeeperLock;
            synchronized (object) {
                if (iPSZooKeeper == null) {
                    iPSZooKeeper = psZooKeeper;
                }
            }
        }
        return iPSZooKeeper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IPSZooKeeper getInstance(String strCat) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCat)) {
            return PSZooKeeper.getCurrent();
        }
        IPSZooKeeper psZooKeeper = psZooKeeperCatMap.get(strCat);
        if (psZooKeeper == null) {
            psZooKeeper = new PSZooKeeper();
            HashMap<String, IPSZooKeeper> hashMap = psZooKeeperCatMap;
            synchronized (hashMap) {
                IPSZooKeeper psZooKeeper2 = psZooKeeperCatMap.get(strCat);
                if (psZooKeeper2 != null) {
                    psZooKeeper = psZooKeeper2;
                } else {
                    psZooKeeperCatMap.put(strCat, psZooKeeper);
                }
            }
        }
        return psZooKeeper;
    }

    @Override
    public String getDomain() {
        return this.strDomain;
    }

    @Override
    public boolean dealException(IPSObjectKeeper iPSObjectKeeper, Exception ex) throws Exception {
        log.error((Object)StringHelper.format((String)"[%1$s]\u53d1\u751f\u5f02\u5e38", (Object)iPSObjectKeeper.toString(), (Object)ex.getMessage()), (Throwable)ex);
        boolean cfr_ignored_0 = ex instanceof KeeperException.BadVersionException;
        boolean cfr_ignored_1 = ex instanceof KeeperException.SessionExpiredException;
        boolean cfr_ignored_2 = ex instanceof KeeperException.ConnectionLossException;
        throw new Exception("\u4e91\u5e73\u53f0\u534f\u540c\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458\u6216\u7a0d\u540e\u91cd\u8bd5");
    }

    @Override
    public boolean isConnected() {
        ZooKeeper zk = this.zk;
        return zk != null && (zk.getState() == ZooKeeper.States.CONNECTED || zk.getState() == ZooKeeper.States.CONNECTEDREADONLY);
    }
}

