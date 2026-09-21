/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UniStateSFSAction
implements ISFSAction {
    private static final Log log = LogFactory.getLog(UniStateSFSAction.class);
    private IUniStateModel iUniStateModel = null;
    private IEntity iEntity = null;
    private String strAction = null;

    public UniStateSFSAction(IUniStateModel iUniStateModel, IEntity iEntity, String strAction) {
        this.iUniStateModel = iUniStateModel;
        this.iEntity = iEntity;
        this.strAction = strAction;
    }

    @Override
    public void commit() {
        try {
            if (StringHelper.compare(this.strAction, "UPDATE", false) == 0) {
                this.iUniStateModel.update(this.iEntity);
                return;
            }
            if (StringHelper.compare(this.strAction, "REMOVE", false) == 0) {
                this.iUniStateModel.remove(this.iEntity.get(this.iUniStateModel.getKeyField()));
                return;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public void rollback() {
    }
}

