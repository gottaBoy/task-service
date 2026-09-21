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
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSDCModuleInstDAO
extends PSCoreSysDAOBase<PSUSDCModuleInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstDEModel pSUSDCModuleInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstDAO";
    }

    public PSUSDCModuleInstDEModel getPSUSDCModuleInstDEModel() {
        if (this.pSUSDCModuleInstDEModel == null) {
            try {
                this.pSUSDCModuleInstDEModel = (PSUSDCModuleInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstDEModel();
    }
}

