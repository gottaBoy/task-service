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
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCAppPolicyDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCAppPolicy;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSDCAppPolicyDAO
extends PSCoreSysDAOBase<PSUSDCAppPolicy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSDCAppPolicyDEModel pSUSDCAppPolicyDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSDCAppPolicyDAO";
    }

    public PSUSDCAppPolicyDEModel getPSUSDCAppPolicyDEModel() {
        if (this.pSUSDCAppPolicyDEModel == null) {
            try {
                this.pSUSDCAppPolicyDEModel = (PSUSDCAppPolicyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCAppPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCAppPolicyDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSDCAppPolicyDEModel();
    }
}

