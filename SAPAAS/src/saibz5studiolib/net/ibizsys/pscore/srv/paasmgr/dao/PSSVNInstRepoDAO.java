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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSVNInstRepoDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import org.springframework.stereotype.Repository;

@Repository
public class PSSVNInstRepoDAO
extends PSCoreSysDAOBase<PSSVNInstRepo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSVNInstRepoDEModel pSSVNInstRepoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSSVNInstRepoDAO";
    }

    public PSSVNInstRepoDEModel getPSSVNInstRepoDEModel() {
        if (this.pSSVNInstRepoDEModel == null) {
            try {
                this.pSSVNInstRepoDEModel = (PSSVNInstRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSVNInstRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSVNInstRepoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSVNInstRepoDEModel();
    }
}

