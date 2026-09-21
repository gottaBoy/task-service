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
import net.ibizsys.psrt.srv.common.demodel.SysAdminFuncDEModel;
import net.ibizsys.psrt.srv.common.entity.SysAdminFunc;

public abstract class SysAdminFuncDAOBase
extends PSRuntimeSysDAOBase<SysAdminFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private SysAdminFuncDEModel sysAdminFuncDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.SysAdminFuncDAO";
    }

    public SysAdminFuncDEModel getSysAdminFuncDEModel() {
        if (this.sysAdminFuncDEModel == null) {
            try {
                this.sysAdminFuncDEModel = (SysAdminFuncDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.SysAdminFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.sysAdminFuncDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getSysAdminFuncDEModel();
    }
}

