/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;

public abstract class MsgSendQueueDAOBase
extends PSRuntimeSysDAOBase<MsgSendQueue> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private MsgSendQueueDEModel msgSendQueueDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO";
    }

    public MsgSendQueueDEModel getMsgSendQueueDEModel() {
        if (this.msgSendQueueDEModel == null) {
            try {
                this.msgSendQueueDEModel = (MsgSendQueueDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgSendQueueDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgSendQueueDEModel();
    }
}

