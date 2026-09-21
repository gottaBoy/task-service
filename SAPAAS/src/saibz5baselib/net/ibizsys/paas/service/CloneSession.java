/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import java.util.HashMap;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;

public class CloneSession {
    protected HashMap<String, HashMap<Object, IEntity>> classEntityMap = new HashMap();
    private String strOwner = "";
    private boolean bFromSource = false;
    private IEntity sourceObject = null;

    public IEntity getEntity(String strDEName, Object objKey) {
        HashMap<Object, IEntity> entityMap = this.classEntityMap.get(strDEName);
        if (entityMap != null) {
            return entityMap.get(objKey);
        }
        return null;
    }

    public void setEntity(String strDEName, Object objKey, IEntity iEntity) throws Exception {
        this.setEntity(DEModelGlobal.getDEModel(strDEName), objKey, iEntity);
    }

    public void setEntity(IDataEntityModel iDataEntityModel, Object objKey, IEntity iEntity) throws Exception {
        String strDEName = iDataEntityModel.getName();
        HashMap<Object, IEntity> entityMap = this.classEntityMap.get(strDEName);
        if (entityMap == null) {
            entityMap = new HashMap();
            this.classEntityMap.put(strDEName, entityMap);
        }
        entityMap.put(objKey, iEntity);
        IDataEntityModel inheritDEModel = iDataEntityModel.getInheritDEModel();
        if (inheritDEModel == null) {
            return;
        }
        Object iEntity2 = inheritDEModel.createEntity();
        iEntity.copyTo((IDataObject)iEntity2, false);
        iEntity2.set(inheritDEModel.getKeyDEField().getName(), iEntity.get(iDataEntityModel.getKeyDEField().getName()));
        iEntity2.set(inheritDEModel.getMajorDEField().getName(), iEntity.get(iDataEntityModel.getMajorDEField().getName()));
        this.setEntity(inheritDEModel, objKey, (IEntity)iEntity2);
    }

    public void setOwner(String strOwner) {
        this.strOwner = strOwner;
    }

    public String getOwner() {
        return this.strOwner;
    }

    public void setFromSource(boolean bFromSource) {
        this.bFromSource = bFromSource;
    }

    public boolean isFromSource() {
        return this.bFromSource;
    }

    public void setSourceObject(IEntity sourceObject) {
        this.sourceObject = sourceObject;
    }

    public IEntity getSourceObject() {
        return this.sourceObject;
    }
}

