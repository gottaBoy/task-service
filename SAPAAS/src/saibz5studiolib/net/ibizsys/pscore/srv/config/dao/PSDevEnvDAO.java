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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSDevEnvDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDevEnv;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevEnvDAO
extends PSCoreSysDAOBase<PSDevEnv> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevEnvDEModel pSDevEnvDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSDevEnvDAO";
    }

    public PSDevEnvDEModel getPSDevEnvDEModel() {
        if (this.pSDevEnvDEModel == null) {
            try {
                this.pSDevEnvDEModel = (PSDevEnvDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDevEnvDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevEnvDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevEnvDEModel();
    }
}

