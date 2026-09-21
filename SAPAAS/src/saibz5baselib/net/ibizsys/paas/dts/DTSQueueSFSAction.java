/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.dts;

import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DTSQueueSFSAction
implements ISFSAction {
    private static final Log log = LogFactory.getLog(DTSQueueSFSAction.class);
    private IDTSQueueModel iDTSQueueModel = null;
    private IEntity iEntity = null;

    public DTSQueueSFSAction(IDTSQueueModel iDTSQueueModel, IEntity iEntity) {
        this.iDTSQueueModel = iDTSQueueModel;
        this.iEntity = iEntity;
    }

    @Override
    public void commit() {
        try {
            this.iDTSQueueModel.push(this.iEntity);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public void rollback() {
    }
}

