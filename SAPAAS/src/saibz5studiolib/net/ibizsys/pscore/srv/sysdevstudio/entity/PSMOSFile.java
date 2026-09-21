/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  net.ibizsys.paas.entity.IEntity
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFileBase;

public class PSMOSFile
extends PSMOSFileBase {
    @JsonIgnore
    private IEntity realEntity = null;
    @JsonIgnore
    private ArrayList<PSMOSFile> list = null;

    @JsonIgnore
    public IEntity getRealEntity() {
        return this.realEntity;
    }

    @JsonIgnore
    public void setRealEntity(IEntity iEntity) {
        this.realEntity = iEntity;
    }

    @Override
    @JsonProperty(value="files")
    public ArrayList<PSMOSFile> getPSMOSFiles() throws Exception {
        return this.list;
    }

    public void setPSMOSFiles(ArrayList<PSMOSFile> arrayList) {
        this.list = arrayList;
    }

    public Map<String, Object> toDTOMap() throws Exception {
        HashMap hashMap = new HashMap();
        this.fillMap(hashMap, true);
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        for (Map.Entry object : hashMap.entrySet()) {
            hashMap2.put(((String)object.getKey()).toLowerCase(), object.getValue());
        }
        if (this.getPSMOSFiles() != null) {
            ArrayList arrayList = new ArrayList();
            for (PSMOSFile pSMOSFile : this.getPSMOSFiles()) {
                arrayList.add(pSMOSFile.toDTOMap());
            }
            hashMap2.put("files", arrayList);
        }
        return hashMap2;
    }
}

