/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.zookeeper.CreateMode
 *  org.apache.zookeeper.KeeperException
 *  org.apache.zookeeper.WatchedEvent
 *  org.apache.zookeeper.Watcher
 *  org.apache.zookeeper.Watcher$Event$EventType
 *  org.apache.zookeeper.ZooDefs$Ids
 *  org.apache.zookeeper.ZooKeeper
 *  org.apache.zookeeper.data.Stat
 */
package net.ibizsys.psop.zookeeper;

import java.util.List;
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

public abstract class PSObjectKeeperBase
implements IPSObjectKeeper {
    private static final Log log = LogFactory.getLog(PSObjectKeeperBase.class);
    private IPSZooKeeper iPSZooKeeper = null;
    private boolean bClose = false;

    public PSObjectKeeperBase(IPSZooKeeper iPSZooKeeper) throws Exception {
        this.iPSZooKeeper = iPSZooKeeper;
    }

    protected IPSZooKeeper getPSZooKeeper() {
        return this.iPSZooKeeper;
    }

    protected void processEvent(WatchedEvent event) {
        if (event.getType() != Watcher.Event.EventType.NodeDeleted) {
            if (this.isClose()) {
                return;
            }
            try {
                if (!StringHelper.isNullOrEmpty((String)event.getPath())) {
                    this.getZooKeeper().exists(event.getPath(), new Watcher(){

                        public void process(WatchedEvent event) {
                            PSObjectKeeperBase.this.processEvent(event);
                        }
                    });
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                if (event.getPath() != null) {
                    log.debug((Object)("\u5df2\u7ecf\u89e6\u53d1\u4e86[" + event.getPath() + "] " + event.getType() + "\u4e8b\u4ef6\uff01"));
                } else {
                    log.debug((Object)("\u5df2\u7ecf\u89e6\u53d1\u4e86[\u672a\u77e5\u8def\u5f84] " + event.getType() + "\u4e8b\u4ef6\uff01"));
                }
                this.onProcessEvent(event);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        } else {
            log.debug((Object)("\u5df2\u7ecf\u89e6\u53d1\u4e86[" + event.getPath() + "] " + event.getType() + "\u4e8b\u4ef6\uff01"));
        }
    }

    protected void onProcessEvent(WatchedEvent event) throws Exception {
    }

    protected ZooKeeper getZooKeeper() {
        return this.getPSZooKeeper().getZooKeeper();
    }

    protected Stat exists(String strPath, byte[] data, boolean bCreateIfNotExists) throws KeeperException, InterruptedException {
        return this.exists(strPath, data, bCreateIfNotExists, true);
    }

    protected Stat exists(String strPath, byte[] data, boolean bCreateIfNotExists, boolean bListen) throws KeeperException, InterruptedException {
        Stat stat = this.getZooKeeper().exists(strPath, bListen ? new Watcher(){

            public void process(WatchedEvent event) {
                PSObjectKeeperBase.this.processEvent(event);
            }
        } : null);
        if (stat == null && bCreateIfNotExists) {
            this.getZooKeeper().create(strPath, data, (List)ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u8def\u5f84[%1$s]\u6210\u529f", (Object)strPath));
            return this.getZooKeeper().exists(strPath, bListen ? new Watcher(){

                public void process(WatchedEvent event) {
                    PSObjectKeeperBase.this.processEvent(event);
                }
            } : null);
        }
        return stat;
    }

    public static Stat exists(ZooKeeper zooKeeper, String strPath, byte[] data, boolean bCreateIfNotExists) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(strPath, null);
        if (stat == null && bCreateIfNotExists) {
            zooKeeper.create(strPath, data, (List)ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u8def\u5f84[%1$s]\u6210\u529f", (Object)strPath));
            return zooKeeper.exists(strPath, null);
        }
        return stat;
    }

    protected Stat setData(String strPath, byte[] data) throws KeeperException, InterruptedException {
        return this.getZooKeeper().setData(strPath, data, -1);
    }

    protected Stat setData(String strPath, byte[] data, int nVersion) throws Exception {
        try {
            return this.getZooKeeper().setData(strPath, data, nVersion);
        }
        catch (Exception ex) {
            if (this.getPSZooKeeper().dealException(this, ex)) {
                return this.getZooKeeper().setData(strPath, data, nVersion);
            }
            throw ex;
        }
    }

    public static Stat setData(ZooKeeper zooKeeper, String strPath, byte[] data, int nVersion) throws KeeperException, InterruptedException {
        return zooKeeper.setData(strPath, data, nVersion);
    }

    protected byte[] getData(String strPath, Stat stat) throws Exception {
        try {
            return this.getZooKeeper().getData(strPath, false, stat);
        }
        catch (Exception ex) {
            if (this.getPSZooKeeper().dealException(this, ex)) {
                return this.getData(strPath, stat);
            }
            throw ex;
        }
    }

    public void close() {
        this.bClose = true;
    }

    public boolean isClose() {
        return this.bClose;
    }
}

