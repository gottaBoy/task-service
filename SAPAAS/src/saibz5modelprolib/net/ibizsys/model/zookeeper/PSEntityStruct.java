/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.zookeeper;

import java.util.HashMap;
import net.ibizsys.model.zookeeper.PSEntityKeeper;
import net.ibizsys.model.zookeeper.PSZooKeeper;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;

public class PSEntityStruct {
    String strEntityName = null;
    String[] folders = null;
    String strKeyName = null;
    String[] fields = null;
    String strCat = null;
    String strPath = null;
    private HashMap<String, PSEntityKeeper> psEntityKeeperMap = new HashMap();

    public String getEntityName() {
        return this.strEntityName;
    }

    public void setEntityName(String strEntityName) {
        this.strEntityName = strEntityName;
        this.strPath = StringHelper.format((String)"/%1$s", (Object)this.strEntityName);
    }

    public String getKeyName() {
        return this.strKeyName;
    }

    public void setKeyName(String strKeyName) {
        this.strKeyName = strKeyName;
    }

    public String[] getFolders() {
        return this.folders;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
    }

    public String[] getFields() {
        return this.fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String getCat() {
        return this.strCat;
    }

    public void setCat(String strCat) {
        this.strCat = strCat;
    }

    public String getPath() {
        return this.strPath;
    }

    public boolean getPSEntity(IEntity iEntity, boolean bUpdateNow) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)iEntity.get(this.getKeyName()), null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        PSEntityKeeper psEntityKeeper = this.psEntityKeeperMap.get(strKeyValue);
        if (psEntityKeeper == null) {
            return false;
        }
        psEntityKeeper.getPSEntity(iEntity, bUpdateNow);
        return true;
    }

    public void updatePSEntity(IEntity iEntity, boolean bCreate) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)iEntity.get(this.getKeyName()), null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        PSEntityKeeper psEntityKeeper = this.psEntityKeeperMap.get(strKeyValue);
        if (psEntityKeeper == null) {
            if (bCreate) {
                psEntityKeeper = new PSEntityKeeper(PSZooKeeper.getInstance(this.getCat()), this, iEntity);
                this.psEntityKeeperMap.put(strKeyValue, psEntityKeeper);
            }
            return;
        }
        psEntityKeeper.updatePSEntity(iEntity);
    }

    public boolean hasPSEntity(IEntity iEntity) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)iEntity.get(this.getKeyName()), null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        PSEntityKeeper psEntityKeeper = this.psEntityKeeperMap.get(strKeyValue);
        return psEntityKeeper != null;
    }

    public boolean hasPSEntity(Object objValue) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)objValue, null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        PSEntityKeeper psEntityKeeper = this.psEntityKeeperMap.get(strKeyValue);
        return psEntityKeeper != null;
    }

    public void removePSEntity(IEntity iEntity) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)iEntity.get(this.getKeyName()), null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        this.removePSEntity(strKeyValue);
    }

    public void removePSEntity(Object objValue) throws Exception {
        String strKeyValue = DataObject.getStringValue((Object)objValue, null);
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        PSEntityKeeper psEntityKeeper = this.psEntityKeeperMap.remove(strKeyValue);
        if (psEntityKeeper == null) {
            return;
        }
        psEntityKeeper.close();
    }
}

