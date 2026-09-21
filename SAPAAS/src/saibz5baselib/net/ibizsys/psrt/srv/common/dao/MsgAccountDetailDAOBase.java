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
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccountDetail;

public abstract class MsgAccountDetailDAOBase
extends PSRuntimeSysDAOBase<MsgAccountDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private MsgAccountDetailDEModel msgAccountDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO";
    }

    public MsgAccountDetailDEModel getMsgAccountDetailDEModel() {
        if (this.msgAccountDetailDEModel == null) {
            try {
                this.msgAccountDetailDEModel = (MsgAccountDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgAccountDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgAccountDetailDEModel();
    }
}

