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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCredentialDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import org.springframework.stereotype.Repository;

@Repository
public class PSCredentialDAO
extends PSCoreSysDAOBase<PSCredential> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDCVALID = "AllDCValid";
    public static final String DATAQUERY_CURDCVALID = "CurDCValid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCredentialDEModel pSCredentialDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSCredentialDAO";
    }

    public PSCredentialDEModel getPSCredentialDEModel() {
        if (this.pSCredentialDEModel == null) {
            try {
                this.pSCredentialDEModel = (PSCredentialDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCredentialDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCredentialDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCredentialDEModel();
    }
}

