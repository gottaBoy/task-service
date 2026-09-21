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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSRTWXAccountDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRTWXAccount;
import org.springframework.stereotype.Repository;

@Repository
public class PSRTWXAccountDAO
extends PSCoreSysDAOBase<PSRTWXAccount> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSRTWXAccountDEModel pSRTWXAccountDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSRTWXAccountDAO";
    }

    public PSRTWXAccountDEModel getPSRTWXAccountDEModel() {
        if (this.pSRTWXAccountDEModel == null) {
            try {
                this.pSRTWXAccountDEModel = (PSRTWXAccountDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSRTWXAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRTWXAccountDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSRTWXAccountDEModel();
    }
}

