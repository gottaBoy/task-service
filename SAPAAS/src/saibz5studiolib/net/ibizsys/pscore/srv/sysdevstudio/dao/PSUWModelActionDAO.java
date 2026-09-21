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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWModelActionDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWModelAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWModelActionDAO
extends PSCoreSysDAOBase<PSUWModelAction> {
    private static final long serialVersionUID = -1L;
    private PSUWModelActionDEModel pSUWModelActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWModelActionDAO";
    }

    public PSUWModelActionDEModel getPSUWModelActionDEModel() {
        if (this.pSUWModelActionDEModel == null) {
            try {
                this.pSUWModelActionDEModel = (PSUWModelActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWModelActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWModelActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWModelActionDEModel();
    }
}

