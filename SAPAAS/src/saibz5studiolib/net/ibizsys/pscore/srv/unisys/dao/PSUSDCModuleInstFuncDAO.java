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
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstFuncDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSDCModuleInstFuncDAO
extends PSCoreSysDAOBase<PSUSDCModuleInstFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstFuncDEModel pSUSDCModuleInstFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstFuncDAO";
    }

    public PSUSDCModuleInstFuncDEModel getPSUSDCModuleInstFuncDEModel() {
        if (this.pSUSDCModuleInstFuncDEModel == null) {
            try {
                this.pSUSDCModuleInstFuncDEModel = (PSUSDCModuleInstFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstFuncDEModel();
    }
}

