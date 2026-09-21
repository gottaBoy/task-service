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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysVerDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSaaSSysVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSaaSSysVerDAO
extends PSCoreSysDAOBase<PSDepSaaSSysVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSaaSSysVerDEModel pSDepSaaSSysVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysVerDAO";
    }

    public PSDepSaaSSysVerDEModel getPSDepSaaSSysVerDEModel() {
        if (this.pSDepSaaSSysVerDEModel == null) {
            try {
                this.pSDepSaaSSysVerDEModel = (PSDepSaaSSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSaaSSysVerDEModel();
    }
}

