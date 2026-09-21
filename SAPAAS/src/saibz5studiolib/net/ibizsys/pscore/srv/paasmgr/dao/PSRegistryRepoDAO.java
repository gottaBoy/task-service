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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryRepoDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import org.springframework.stereotype.Repository;

@Repository
public class PSRegistryRepoDAO
extends PSCoreSysDAOBase<PSRegistryRepo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSRegistryRepoDEModel pSRegistryRepoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSRegistryRepoDAO";
    }

    public PSRegistryRepoDEModel getPSRegistryRepoDEModel() {
        if (this.pSRegistryRepoDEModel == null) {
            try {
                this.pSRegistryRepoDEModel = (PSRegistryRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRegistryRepoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSRegistryRepoDEModel();
    }
}

