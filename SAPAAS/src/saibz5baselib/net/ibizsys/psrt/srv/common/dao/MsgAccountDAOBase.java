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
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;

public abstract class MsgAccountDAOBase
extends PSRuntimeSysDAOBase<MsgAccount> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private MsgAccountDEModel msgAccountDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.MsgAccountDAO";
    }

    public MsgAccountDEModel getMsgAccountDEModel() {
        if (this.msgAccountDEModel == null) {
            try {
                this.msgAccountDEModel = (MsgAccountDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgAccountDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgAccountDEModel();
    }
}

