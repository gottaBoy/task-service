/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.cache.IUniState
 *  net.ibizsys.paas.cache.IUniStateManager
 *  net.ibizsys.paas.cache.IUniStateModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psop.zookeeper;

import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.PSEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSZooKeeperUniStateManager
implements IUniStateManager {
    private static final Log log = LogFactory.getLog(PSZooKeeperUniStateManager.class);

    public void regUniState(IUniState iUniState) throws Exception {
        IUniStateModel iUniStateModel = (IUniStateModel)iUniState;
        PSEntityKeeperGlobal.getCurrent().registerPSEntity(iUniStateModel.getId(), iUniStateModel.getKeyField(), iUniStateModel.getFolderFields(), iUniStateModel.getStateFields(), null);
    }

    public void unregUniState(IUniState iUniState) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public boolean containsUniState(IUniState iUniState) throws Exception {
        return PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity(iUniState.getId());
    }

    public boolean getEntity(IUniState iUniState, IEntity iEntity) throws Exception {
        return PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(), iEntity);
    }

    public boolean getEntity(IUniState iUniState, IEntity iEntity, boolean bForceUpdate) throws Exception {
        return PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(), iEntity, bForceUpdate);
    }

    public Object getEntityState(IUniState iUniState, Object objKey, String strStateField) throws Exception {
        return this.getEntityState(iUniState, objKey, strStateField, false);
    }

    public Object getEntityState(IUniState iUniState, Object objKey, String strStateField, boolean bForceUpdate) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.set(iUniState.getKeyField(), objKey);
        if (PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(), (IEntity)simpleEntity, bForceUpdate)) {
            if (StringHelper.isNullOrEmpty((String)strStateField)) {
                return simpleEntity.get(iUniState.getStateField());
            }
            return simpleEntity.get(strStateField);
        }
        return null;
    }

    public boolean containsEntity(IUniState iUniState, IEntity iEntity) throws Exception {
        return PSEntityKeeperGlobal.getCurrent().hasPSEntity(iUniState.getId(), iEntity);
    }

    public boolean containsEntity(IUniState iUniState, Object objKey) throws Exception {
        return PSEntityKeeperGlobal.getCurrent().hasPSEntity(iUniState.getId(), objKey);
    }

    public void removeEntity(IUniState iUniState, IEntity iEntity) throws Exception {
        PSEntityKeeperGlobal.getCurrent().removePSEntity(iUniState.getId(), iEntity);
    }

    public void removeEntity(IUniState iUniState, Object objKey) throws Exception {
        PSEntityKeeperGlobal.getCurrent().removePSEntity(iUniState.getId(), objKey);
    }

    public void updateEntity(IUniState iUniState, IEntity iEntity) throws Exception {
        PSEntityKeeperGlobal.getCurrent().updatePSEntity(iUniState.getId(), iEntity, true);
    }
}

