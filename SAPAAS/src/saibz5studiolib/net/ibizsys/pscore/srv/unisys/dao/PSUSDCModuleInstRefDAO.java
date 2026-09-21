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
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstRefDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstRef;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSDCModuleInstRefDAO
extends PSCoreSysDAOBase<PSUSDCModuleInstRef> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstRefDEModel pSUSDCModuleInstRefDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstRefDAO";
    }

    public PSUSDCModuleInstRefDEModel getPSUSDCModuleInstRefDEModel() {
        if (this.pSUSDCModuleInstRefDEModel == null) {
            try {
                this.pSUSDCModuleInstRefDEModel = (PSUSDCModuleInstRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstRefDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstRefDEModel();
    }
}

