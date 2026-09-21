/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.zookeeper.WatchedEvent
 *  org.apache.zookeeper.Watcher$Event$EventType
 *  org.apache.zookeeper.data.Stat
 */
package net.ibizsys.psop.zookeeper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.IPSZooKeeper;
import net.ibizsys.psop.zookeeper.IPSZooKeeperEntity;
import net.ibizsys.psop.zookeeper.PSEntityStruct;
import net.ibizsys.psop.zookeeper.PSObjectKeeperBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

public class PSEntityKeeper
extends PSObjectKeeperBase {
    private static final Log log = LogFactory.getLog(PSEntityKeeper.class);
    private PSEntityStruct psEntityStruct = null;
    private Object[] values = null;
    private String[] fields = null;
    private String strEntityKey = null;
    private String strFullPath = null;
    private int nLastVersion = 0;
    private long nLastActiveTime = 0L;
    private String[] folders = null;

    public PSEntityKeeper(IPSZooKeeper iPSZooKeeper, PSEntityStruct psEntityStruct, IEntity iEntity) throws Exception {
        super(iPSZooKeeper);
        this.strEntityKey = DataObject.getStringValue((IDataObject)iEntity, (String)psEntityStruct.getKeyName(), (String)"");
        if (StringHelper.isNullOrEmpty((String)this.strEntityKey)) {
            throw new Exception("\u6570\u636e\u5bf9\u8c61\u4e3b\u952e\u65e0\u6548");
        }
        this.psEntityStruct = psEntityStruct;
        ArrayList<String> folderList = new ArrayList<String>();
        this.exists(String.valueOf(iPSZooKeeper.getDomain()) + psEntityStruct.getPath(), "".getBytes(), true, false);
        folderList.add(String.valueOf(iPSZooKeeper.getDomain()) + psEntityStruct.getPath());
        String strPath = psEntityStruct.getPath();
        if (psEntityStruct.getFolders() != null) {
            int i = 0;
            while (i < psEntityStruct.getFolders().length) {
                String strFolderValue = DataObject.getStringValue((IDataObject)iEntity, (String)psEntityStruct.getFolders()[i], (String)"");
                if (StringHelper.isNullOrEmpty((String)strFolderValue)) {
                    throw new Exception(StringHelper.format((String)"\u76ee\u5f55[%1$s]\u503c\u65e0\u6548", (Object)psEntityStruct.getFolders()[i]));
                }
                strPath = String.valueOf(strPath) + StringHelper.format((String)"/%1$s", (Object)strFolderValue);
                this.exists(String.valueOf(iPSZooKeeper.getDomain()) + strPath, "".getBytes(), true, false);
                folderList.add(String.valueOf(iPSZooKeeper.getDomain()) + strPath);
                ++i;
            }
        }
        this.strFullPath = StringHelper.format((String)"%1$s%2$s/%3$s", (Object)iPSZooKeeper.getDomain(), (Object)strPath, (Object)this.strEntityKey);
        Stat stat = this.exists(this.strFullPath, "".getBytes(), true);
        folderList.add(this.strFullPath);
        this.folders = folderList.toArray(new String[folderList.size()]);
        this.nLastVersion = stat.getVersion();
        this.fields = psEntityStruct.getFields();
        if (this.fields != null) {
            this.values = new Object[this.fields.length];
        }
        this.updatePSEntity(iEntity);
    }

    public PSEntityKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
        super(iPSZooKeeper);
    }

    protected boolean updateValues(IEntity iEntity) throws Exception {
        boolean bUpdate = false;
        if (this.fields != null) {
            int i = 0;
            while (i < this.fields.length) {
                if (iEntity.contains(this.fields[i])) {
                    this.values[i] = iEntity.get(this.fields[i]);
                    bUpdate = true;
                }
                ++i;
            }
        }
        return bUpdate;
    }

    protected void getPSEntity() throws Exception {
        Stat stat = new Stat();
        byte[] bytes = this.getData(this.strFullPath, stat);
        JSONObject jo = null;
        if (bytes != null && bytes.length != 0) {
            jo = JSONObject.fromString((String)new String(bytes, "UTF-8"));
        }
        this.nLastActiveTime = System.currentTimeMillis();
        this.nLastVersion = stat.getVersion();
        if (jo == null) {
            return;
        }
        if (this.fields != null) {
            int i = 0;
            while (i < this.fields.length) {
                if (jo.has(this.fields[i])) {
                    this.values[i] = PSEntityKeeper.fromJSONValue(jo.opt(this.fields[i]));
                }
                ++i;
            }
        }
        log.debug((Object)StringHelper.format((String)"\u5e73\u53f0\u5bf9\u8c61[%1$s][%2$s]\u53d8\u5316", (Object)this.psEntityStruct.getEntityName(), (Object)this.strEntityKey));
    }

    @Override
    protected void onProcessEvent(WatchedEvent event) throws Exception {
        super.onProcessEvent(event);
        this.nLastActiveTime = System.currentTimeMillis();
        if (StringHelper.isNullOrEmpty((Object)event.getType())) {
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeCreated) {
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
            if (StringHelper.compare((String)event.getPath(), (String)this.strFullPath, (boolean)true) == 0) {
                this.getPSEntity();
                return;
            }
            return;
        }
        if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
            return;
        }
    }

    protected byte[] getPSEntityData() throws Exception {
        JSONObject jo = new JSONObject();
        if (this.fields != null) {
            int i = 0;
            while (i < this.fields.length) {
                jo.put(this.fields[i], PSEntityKeeper.getJSONValue(this.values[i]));
                ++i;
            }
        }
        return jo.toString().getBytes("UTF-8");
    }

    public void getPSEntity(IEntity iEntity, boolean bGet) throws Exception {
        if (iEntity instanceof IPSZooKeeperEntity) {
            this.getPSEntityEx((IPSZooKeeperEntity)iEntity, bGet);
            return;
        }
        if (bGet) {
            this.getPSEntity();
        }
        if (this.fields != null) {
            int i = 0;
            while (i < this.fields.length) {
                iEntity.set(this.fields[i], this.values[i]);
                ++i;
            }
        }
    }

    public void getPSEntityEx(IPSZooKeeperEntity iEntity, boolean bGet) throws Exception {
        if (bGet) {
            this.getPSEntity();
        }
        if (iEntity.getZKDataVersion() == this.nLastVersion) {
            return;
        }
        if (this.fields != null) {
            int i = 0;
            while (i < this.fields.length) {
                iEntity.set(this.fields[i], this.values[i]);
                ++i;
            }
        }
    }

    public void updatePSEntity(IEntity iEntity) throws Exception {
        if (iEntity instanceof IPSZooKeeperEntity) {
            this.updatePSEntityEx((IPSZooKeeperEntity)iEntity);
            return;
        }
        this.updateValues(iEntity);
        try {
            Stat stat = this.setData(this.strFullPath, this.getPSEntityData(), this.nLastVersion);
            this.nLastVersion = stat.getVersion();
            this.nLastActiveTime = System.currentTimeMillis();
            return;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.getPSEntity();
            this.updateValues(iEntity);
            this.setData(this.strFullPath, this.getPSEntityData(), this.nLastVersion);
            this.nLastActiveTime = System.currentTimeMillis();
            return;
        }
    }

    public void updatePSEntityEx(IPSZooKeeperEntity iEntity) throws Exception {
        this.updateValues(iEntity);
        try {
            Stat stat = this.setData(this.strFullPath, this.getPSEntityData(), this.nLastVersion);
            this.nLastVersion = stat.getVersion();
            this.nLastActiveTime = System.currentTimeMillis();
            iEntity.setZKDataVersion(this.nLastVersion);
            return;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.getPSEntity();
            this.updateValues(iEntity);
            Stat stat = this.setData(this.strFullPath, this.getPSEntityData(), this.nLastVersion);
            this.nLastVersion = stat.getVersion();
            this.nLastActiveTime = System.currentTimeMillis();
            iEntity.setZKDataVersion(this.nLastVersion);
            return;
        }
    }

    protected static Object getJSONValue(Object objValue) throws Exception {
        if (objValue == null) {
            return JSONNull.getInstance();
        }
        Long nValue = null;
        if (objValue instanceof Timestamp) {
            nValue = ((Timestamp)objValue).getTime();
        } else if (objValue instanceof Date) {
            nValue = ((Date)objValue).getTime();
        } else if (objValue instanceof java.util.Date) {
            nValue = ((java.util.Date)objValue).getTime();
        } else {
            return objValue;
        }
        JSONObject dt = new JSONObject();
        if (nValue < 0L) {
            dt.put("timestr", (Object)Long.toString(nValue));
        } else {
            dt.put("time", (Object)nValue);
        }
        return dt;
    }

    protected static Object fromJSONValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof JSONNull) {
            return null;
        }
        if (objValue instanceof JSONArray) {
            return null;
        }
        if (objValue instanceof JSONObject) {
            JSONObject jo = (JSONObject)objValue;
            if (jo.has("time") || jo.has("timestr")) {
                long lTime = 0L;
                lTime = jo.has("timestr") ? Long.parseLong(jo.getString("timestr")) : jo.getLong("time");
                Timestamp date = new Timestamp(lTime);
                return date;
            }
            return jo.toString();
        }
        return objValue;
    }

    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }
}

