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
package net.ibizsys.pscore.srv.sysdeploy.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSSaaSSysDBDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSSaaSSysDB;
import org.springframework.stereotype.Repository;

@Repository
public class PSSaaSSysDBDAO
extends PSCoreSysDAOBase<PSSaaSSysDB> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSaaSSysDBDEModel pSSaaSSysDBDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSSaaSSysDBDAO";
    }

    public PSSaaSSysDBDEModel getPSSaaSSysDBDEModel() {
        if (this.pSSaaSSysDBDEModel == null) {
            try {
                this.pSSaaSSysDBDEModel = (PSSaaSSysDBDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSSaaSSysDBDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysDBDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSaaSSysDBDEModel();
    }
}

