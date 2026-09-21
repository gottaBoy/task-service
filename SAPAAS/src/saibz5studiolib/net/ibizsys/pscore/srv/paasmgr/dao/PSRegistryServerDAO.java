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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryServer;
import org.springframework.stereotype.Repository;

@Repository
public class PSRegistryServerDAO
extends PSCoreSysDAOBase<PSRegistryServer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSRegistryServerDEModel pSRegistryServerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSRegistryServerDAO";
    }

    public PSRegistryServerDEModel getPSRegistryServerDEModel() {
        if (this.pSRegistryServerDEModel == null) {
            try {
                this.pSRegistryServerDEModel = (PSRegistryServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRegistryServerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSRegistryServerDEModel();
    }
}

