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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryRepoDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCRegistryRepoDAO
extends PSCoreSysDAOBase<PSDCRegistryRepo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCRegistryRepoDEModel pSDCRegistryRepoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryRepoDAO";
    }

    public PSDCRegistryRepoDEModel getPSDCRegistryRepoDEModel() {
        if (this.pSDCRegistryRepoDEModel == null) {
            try {
                this.pSDCRegistryRepoDEModel = (PSDCRegistryRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryRepoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCRegistryRepoDEModel();
    }
}

