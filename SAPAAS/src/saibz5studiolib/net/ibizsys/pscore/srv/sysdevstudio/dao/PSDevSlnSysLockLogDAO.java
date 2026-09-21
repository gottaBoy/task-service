/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysLockLogDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysLockLog;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysLockLogDAO
extends PSCoreSysDAOBase<PSDevSlnSysLockLog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysLockLogDEModel pSDevSlnSysLockLogDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysLockLogDAO";
    }

    public PSDevSlnSysLockLogDEModel getPSDevSlnSysLockLogDEModel() {
        if (this.pSDevSlnSysLockLogDEModel == null) {
            try {
                this.pSDevSlnSysLockLogDEModel = (PSDevSlnSysLockLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysLockLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysLockLogDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysLockLogDEModel();
    }
}

