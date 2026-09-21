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
package net.ibizsys.pscore.srv.unisys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModule;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSDCModuleDAO
extends PSCoreSysDAOBase<PSUSDCModule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSDCModuleDEModel pSUSDCModuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleDAO";
    }

    public PSUSDCModuleDEModel getPSUSDCModuleDEModel() {
        if (this.pSUSDCModuleDEModel == null) {
            try {
                this.pSUSDCModuleDEModel = (PSUSDCModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSDCModuleDEModel();
    }
}

