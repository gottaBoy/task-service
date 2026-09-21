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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysPrdVerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysPrdVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysPrdVerDAO
extends PSCoreSysDAOBase<PSSysPrdVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysPrdVerDEModel pSSysPrdVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSSysPrdVerDAO";
    }

    public PSSysPrdVerDEModel getPSSysPrdVerDEModel() {
        if (this.pSSysPrdVerDEModel == null) {
            try {
                this.pSSysPrdVerDEModel = (PSSysPrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysPrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPrdVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysPrdVerDEModel();
    }
}

