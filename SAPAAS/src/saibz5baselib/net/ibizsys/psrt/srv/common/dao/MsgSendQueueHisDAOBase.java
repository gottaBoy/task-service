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
import net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueueHis;

public abstract class MsgSendQueueHisDAOBase
extends PSRuntimeSysDAOBase<MsgSendQueueHis> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private MsgSendQueueHisDEModel msgSendQueueHisDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.MsgSendQueueHisDAO";
    }

    public MsgSendQueueHisDEModel getMsgSendQueueHisDEModel() {
        if (this.msgSendQueueHisDEModel == null) {
            try {
                this.msgSendQueueHisDEModel = (MsgSendQueueHisDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgSendQueueHisDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgSendQueueHisDEModel();
    }
}

