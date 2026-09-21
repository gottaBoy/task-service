/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.zookeeper;

import java.util.HashMap;
import net.ibizsys.model.zookeeper.PSEntityStruct;
import net.ibizsys.model.zookeeper.PSZooKeeper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSEntityKeeperGlobal {
    private static final Log log = LogFactory.getLog(PSEntityKeeperGlobal.class);
    static PSEntityKeeperGlobal psEntityKeeperGlobal = null;
    protected HashMap<String, PSEntityStruct> psEntityStructMap = new HashMap();

    public static synchronized PSEntityKeeperGlobal getCurrent() throws Exception {
        if (psEntityKeeperGlobal == null) {
            PSEntityKeeperGlobal item;
            psEntityKeeperGlobal = item = new PSEntityKeeperGlobal();
        }
        return psEntityKeeperGlobal;
    }

    public void registerPSEntity(String strEntityName, String strEntityKey, String[] fields) throws Exception {
        this.registerPSEntity(strEntityName, strEntityKey, fields, null);
    }

    public void registerPSEntity(String strEntityName, String strEntityKey, String[] fields, String strCat) throws Exception {
        this.registerPSEntity(strEntityName, strEntityKey, null, fields, strCat);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerPSEntity(String strEntityName, String strEntityKey, String[] folders, String[] fields, String strCat) throws Exception {
        PSEntityStruct psEntityStruct = new PSEntityStruct();
        psEntityStruct.setEntityName(strEntityName);
        psEntityStruct.setKeyName(strEntityKey);
        psEntityStruct.setFolders(folders);
        psEntityStruct.setFields(fields);
        psEntityStruct.setCat(strCat);
        HashMap<String, PSEntityStruct> hashMap = this.psEntityStructMap;
        synchronized (hashMap) {
            if (!this.psEntityStructMap.containsKey(strEntityName)) {
                this.psEntityStructMap.put(strEntityName, psEntityStruct);
            }
        }
    }

    public void updatePSEntity(String strEntityName, IEntity iEntity, boolean bCreate) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        psEntityStruct.updatePSEntity(iEntity, bCreate);
    }

    public boolean hasPSEntity(String strEntityName, IEntity iEntity) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        return psEntityStruct.hasPSEntity(iEntity);
    }

    public boolean hasPSEntity(String strEntityName, Object objKey) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        return psEntityStruct.hasPSEntity(objKey);
    }

    public boolean getPSEntity(String strEntityName, IEntity iEntity) throws Exception {
        return this.getPSEntity(strEntityName, iEntity, false);
    }

    public boolean getPSEntity(String strEntityName, IEntity iEntity, boolean bUpdateNow) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        return psEntityStruct.getPSEntity(iEntity, bUpdateNow);
    }

    public void removePSEntity(String strEntityName, IEntity iEntity) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        psEntityStruct.removePSEntity(iEntity);
    }

    public void removePSEntity(String strEntityName, Object objKeyValue) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        psEntityStruct.removePSEntity(objKeyValue);
    }

    public boolean isRegisterPSEntity(String strEntityName) {
        return this.psEntityStructMap.containsKey(strEntityName);
    }

    public boolean isPSEntityEnabled(String strEntityName) throws Exception {
        PSEntityStruct psEntityStruct = null;
        psEntityStruct = this.psEntityStructMap.get(strEntityName);
        if (psEntityStruct == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61[%1$s]\u8fd8\u672a\u6ce8\u518c", (Object)strEntityName));
        }
        return PSZooKeeper.getInstance(psEntityStruct.getCat()).isConnected();
    }
}

