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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWAsyncActionDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWAsyncAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWAsyncActionDAO
extends PSCoreSysDAOBase<PSUWAsyncAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWAsyncActionDEModel pSUWAsyncActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWAsyncActionDAO";
    }

    public PSUWAsyncActionDEModel getPSUWAsyncActionDEModel() {
        if (this.pSUWAsyncActionDEModel == null) {
            try {
                this.pSUWAsyncActionDEModel = (PSUWAsyncActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWAsyncActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWAsyncActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWAsyncActionDEModel();
    }
}

