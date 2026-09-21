/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.zookeeper.WatchedEvent
 *  org.apache.zookeeper.Watcher$Event$EventType
 *  org.apache.zookeeper.data.Stat
 */
package net.ibizsys.psop.zookeeper;

import java.sql.Timestamp;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.IPSRobotKeeper;
import net.ibizsys.psop.zookeeper.IPSZooKeeper;
import net.ibizsys.psop.zookeeper.PSObjectKeeperBase;
import net.ibizsys.psop.zookeeper.PSZooKeeper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

public class PSRobotKeeper
extends PSObjectKeeperBase
implements IPSRobotKeeper {
    private static final Log log = LogFactory.getLog(PSObjectKeeperBase.class);
    public static final String strRobotPathPrefix = "/PSROBOT/";
    private static final String strRobotPathPrefix2 = "/PSROBOT";
    private String strPSTaskServerId = null;
    private String strPSRobotId = null;
    private String strWorkInfo = "";
    private String strRunPSTaskServerId = null;
    private long nLastRunTime = 0L;
    private String strRunWorkInfo = null;
    private String strRobotPath = null;
    private String strRobotEnergyPath = null;
    private int nLastVerion = 0;
    private int nLastEnergy = 0;
    private long nLastCalcTime = 0L;
    private int nMaxEnergy = 0;
    private int nMaxExtEnergy = 0;
    private int nExtEnergy = 0;
    private float fEnergyRate = 1.0f;
    private String strRobotName = null;
    private long nLastActiveTime = 0L;
    private int nOrderValue = 99999999;
    private int nRobotLevel = 1;

    public PSRobotKeeper(IPSZooKeeper iPSZooKeeper, String strPSRobotId, String strPSTaskServerId, IEntity psRobot) throws Exception {
        super(iPSZooKeeper);
        this.strPSRobotId = strPSRobotId;
        this.strPSTaskServerId = strPSTaskServerId;
        if (StringHelper.isNullOrEmpty((String)strPSTaskServerId)) {
            throw new Exception("\u673a\u5668\u4eba\u5f53\u524d\u4efb\u52a1\u670d\u52a1\u5668\u6ca1\u6709\u6307\u5b9a");
        }
        this.strRobotName = DataObject.getStringValue((Object)psRobot.get("psrobotname"));
        this.exists(String.valueOf(iPSZooKeeper.getDomain()) + strRobotPathPrefix2, "".getBytes(), true, false);
        this.strRobotPath = StringHelper.format((String)"%1$s%2$s%3$s", (Object)iPSZooKeeper.getDomain(), (Object)strRobotPathPrefix, (Object)strPSRobotId);
        Stat stat = this.exists(this.strRobotPath, "".getBytes(), true);
        this.nLastVerion = stat.getVersion();
        this.stop();
        this.strRobotEnergyPath = StringHelper.format((String)"%1$s/ENERGY", (Object)this.strRobotPath);
        this.nLastEnergy = DataObject.getIntegerValue((Object)psRobot.get("lastenergy"), (Integer)this.nLastEnergy);
        this.nMaxEnergy = DataObject.getIntegerValue((Object)psRobot.get("maxenergy"), (Integer)this.nMaxEnergy);
        this.nExtEnergy = DataObject.getIntegerValue((Object)psRobot.get("lextenergy"), (Integer)this.nExtEnergy);
        this.nMaxExtEnergy = DataObject.getIntegerValue((Object)psRobot.get("maxextenergy"), (Integer)this.nMaxExtEnergy);
        this.nOrderValue = DataObject.getIntegerValue((Object)psRobot.get("ordervalue"), (Integer)this.nOrderValue);
        this.nRobotLevel = DataObject.getIntegerValue((Object)psRobot.get("level"), (Integer)this.nRobotLevel);
        this.fEnergyRate = DataObject.getFloatValue((IDataObject)psRobot, (String)"energyrate", (float)this.fEnergyRate).floatValue();
        Timestamp lastTime = DataObject.getTimestampValue((IDataObject)psRobot, (String)"lastcalctime", null);
        this.nLastCalcTime = lastTime != null ? lastTime.getTime() : System.currentTimeMillis();
        stat = this.exists(this.strRobotEnergyPath, this.getPSRobotEnergy(), true);
        this.updatePSRobotEnergy();
    }

    public synchronized boolean start() throws Exception {
        block3: {
            try {
                this.updatePSRobotInfo();
                if (StringHelper.isNullOrEmpty((String)this.strRunPSTaskServerId) || System.currentTimeMillis() - this.nLastRunTime >= 120000L) break block3;
                return false;
            }
            catch (Exception e) {
                log.error((Object)e);
                return false;
            }
        }
        this.setData(this.strRobotPath, this.getPSRobotInfo(), this.nLastVerion);
        return true;
    }

    public synchronized void stop() throws Exception {
        try {
            this.updatePSRobotInfo();
            if (StringHelper.compare((String)this.strRunPSTaskServerId, (String)this.strPSTaskServerId, (boolean)true) != 0) {
                return;
            }
            this.setData(this.strRobotPath, "".getBytes(), this.nLastVerion);
        }
        catch (Exception e) {
            log.error((Object)e);
        }
    }

    public void setRunWork(String strWorkInfo) {
        this.strRunWorkInfo = strWorkInfo;
    }

    @Override
    public void close() {
    }

    public synchronized byte[] getPSRobotInfo() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("taskserverid", (Object)this.strPSTaskServerId);
        jo.put("workinfo", (Object)this.strWorkInfo);
        jo.put("activetime", System.currentTimeMillis());
        return jo.toString().getBytes("UTF-8");
    }

    public synchronized byte[] getPSRobotEnergy() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("maxenergy", this.nMaxEnergy);
        jo.put("lastenergy", this.nLastEnergy);
        jo.put("maxextenergy", this.nMaxExtEnergy);
        jo.put("extenergy", this.nExtEnergy);
        jo.put("lastcalctime", this.nLastCalcTime);
        jo.put("energyrate", (double)this.fEnergyRate);
        jo.put("level", this.nRobotLevel);
        jo.put("ordervalue", this.nOrderValue);
        return jo.toString().getBytes("UTF-8");
    }

    protected synchronized void updatePSRobotInfo() throws Exception {
        Stat stat = new Stat();
        byte[] bytes = this.getData(this.strRobotPath, stat);
        JSONObject jo = null;
        if (bytes != null && bytes.length != 0) {
            jo = JSONObject.fromString((String)new String(bytes, "UTF-8"));
        }
        this.nLastVerion = stat.getVersion();
        if (jo == null) {
            this.strRunPSTaskServerId = null;
            this.nLastRunTime = 0L;
        } else {
            this.strRunPSTaskServerId = jo.optString("taskserverid");
            this.nLastRunTime = jo.optLong("activetime");
        }
        log.debug((Object)StringHelper.format((String)"\u5e73\u53f0\u673a\u5668\u4eba[%1$s]\u8fd0\u884c\u53d8\u5316:[%2$s]", (Object)this.strRobotName, (Object)this.strRunPSTaskServerId));
    }

    protected synchronized void updatePSRobotEnergy() throws Exception {
        Stat stat = new Stat();
        byte[] bytes = this.getData(this.strRobotEnergyPath, stat);
        JSONObject jo = null;
        if (bytes != null && bytes.length != 0) {
            jo = JSONObject.fromString((String)new String(bytes, "UTF-8"));
        }
        if (jo != null) {
            this.nMaxEnergy = jo.optInt("maxenergy");
            this.nLastEnergy = jo.optInt("lastenergy");
            this.nMaxExtEnergy = jo.optInt("maxextenergy");
            this.nExtEnergy = jo.optInt("extenergy");
            this.nRobotLevel = jo.optInt("level");
            this.nOrderValue = jo.optInt("ordervalue");
            this.nLastCalcTime = jo.optLong("lastcalctime");
            this.fEnergyRate = (float)jo.optDouble("energyrate");
            log.debug((Object)StringHelper.format((String)"\u5e73\u53f0\u673a\u5668\u4eba[%1$s]\u80fd\u91cf\u53d8\u5316", (Object)this.strRobotName));
        }
    }

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
            if (StringHelper.compare((String)event.getPath(), (String)this.strRobotPath, (boolean)true) == 0) {
                this.updatePSRobotInfo();
                return;
            }
            if (StringHelper.compare((String)event.getPath(), (String)this.strRobotEnergyPath, (boolean)true) == 0) {
                this.updatePSRobotEnergy();
                return;
            }
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
            return;
        }
    }

    public synchronized int getCurrentEnergy() throws Exception {
        int nEnergy = (int)((float)((System.currentTimeMillis() - this.nLastCalcTime) / 1000L) * this.fEnergyRate) + this.nLastEnergy;
        int nCurExtEnergy = this.nExtEnergy;
        if (nCurExtEnergy > this.nMaxExtEnergy) {
            nCurExtEnergy = this.nMaxExtEnergy;
        }
        if (nEnergy > this.nMaxEnergy) {
            return this.nMaxEnergy + nCurExtEnergy;
        }
        return nEnergy + nCurExtEnergy;
    }

    public synchronized String getRunPSTaskServerId() {
        if (!StringHelper.isNullOrEmpty((String)this.strRunPSTaskServerId) && System.currentTimeMillis() - this.nLastRunTime > 120000L) {
            this.strRunPSTaskServerId = null;
            log.debug((Object)StringHelper.format((String)"\u5e73\u53f0\u673a\u5668\u4eba[%1$s]\u5728\u7ea6\u5b9a\u65f6\u95f4\u5185\u6ca1\u6709\u63a5\u6536\u5230\u5360\u7528\u4efb\u52a1\u670d\u52a1\u5668\u6fc0\u6d3b\u4fe1\u606f\uff0c\u53d6\u6d88\u5360\u4f4d", (Object)this.strRobotName));
        }
        return this.strRunPSTaskServerId;
    }

    public synchronized float getEnergyRate() {
        return this.fEnergyRate;
    }

    public synchronized int getOrderValue() {
        return this.nOrderValue;
    }

    public synchronized int getRobotLevel() {
        return this.nRobotLevel;
    }

    public static void updatePSRobotEnergy(IEntity psRobot) throws Exception {
        IPSZooKeeper iPSZooKeeper = PSZooKeeper.getCurrent();
        if (PSRobotKeeper.exists(iPSZooKeeper.getZooKeeper(), String.valueOf(iPSZooKeeper.getDomain()) + strRobotPathPrefix2, "".getBytes(), false) == null) {
            return;
        }
        String strPSRobotId = DataObject.getStringValue((Object)psRobot.get("psrobotid"));
        String strRobotPath = StringHelper.format((String)"%1$s%2$s%3$s", (Object)iPSZooKeeper.getDomain(), (Object)strRobotPathPrefix, (Object)strPSRobotId);
        if (PSRobotKeeper.exists(iPSZooKeeper.getZooKeeper(), strRobotPath, "".getBytes(), false) == null) {
            return;
        }
        String strRobotEnergyPath = StringHelper.format((String)"%1$s/ENERGY", (Object)strRobotPath);
        if (PSRobotKeeper.exists(iPSZooKeeper.getZooKeeper(), strRobotEnergyPath, "".getBytes(), false) == null) {
            return;
        }
        int nLastEnergy = DataObject.getIntegerValue((Object)psRobot.get("lastenergy"), (Integer)0);
        int nMaxEnergy = DataObject.getIntegerValue((Object)psRobot.get("maxenergy"), (Integer)0);
        int nMaxExtEnergy = DataObject.getIntegerValue((Object)psRobot.get("maxextenergy"), (Integer)0);
        int nExtEnergy = DataObject.getIntegerValue((Object)psRobot.get("extenergy"), (Integer)0);
        int nOrderValue = DataObject.getIntegerValue((Object)psRobot.get("ordervalue"), (Integer)999999999);
        int nRobotLevel = DataObject.getIntegerValue((Object)psRobot.get("level"), (Integer)1);
        float fEnergyRate = DataObject.getFloatValue((IDataObject)psRobot, (String)"energyrate", (float)1.0f).floatValue();
        Timestamp lastTime = DataObject.getTimestampValue((IDataObject)psRobot, (String)"lastcalctime", null);
        JSONObject jo = new JSONObject();
        jo.put("maxenergy", nMaxEnergy);
        jo.put("lastenergy", nLastEnergy);
        jo.put("maxextenergy", nMaxExtEnergy);
        jo.put("extenergy", nExtEnergy);
        jo.put("ordervalue", nOrderValue);
        jo.put("level", nRobotLevel);
        jo.put("lastcalctime", lastTime.getTime());
        jo.put("energyrate", (double)fEnergyRate);
        byte[] data = jo.toString().getBytes("UTF-8");
        PSRobotKeeper.setData(iPSZooKeeper.getZooKeeper(), strRobotEnergyPath, data, -1);
    }

    public synchronized void active() throws Exception {
        long nCurTime;
        if (StringHelper.compare((String)this.strPSTaskServerId, (String)this.getRunPSTaskServerId(), (boolean)false) == 0 && (nCurTime = System.currentTimeMillis()) - this.nLastActiveTime > 20000L) {
            try {
                this.updatePSRobotInfo();
                if (StringHelper.compare((String)this.strRunPSTaskServerId, (String)this.strPSTaskServerId, (boolean)true) == 0) {
                    this.setData(this.strRobotPath, this.getPSRobotInfo(), this.nLastVerion);
                }
                this.nLastActiveTime = nCurTime;
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
    }
}

