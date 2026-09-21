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
import net.ibizsys.pscore.srv.config.demodel.PSDCOrgTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDCOrgType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCOrgTypeDAO
extends PSCoreSysDAOBase<PSDCOrgType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCOrgTypeDEModel pSDCOrgTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSDCOrgTypeDAO";
    }

    public PSDCOrgTypeDEModel getPSDCOrgTypeDEModel() {
        if (this.pSDCOrgTypeDEModel == null) {
            try {
                this.pSDCOrgTypeDEModel = (PSDCOrgTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDCOrgTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCOrgTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCOrgTypeDEModel();
    }
}

