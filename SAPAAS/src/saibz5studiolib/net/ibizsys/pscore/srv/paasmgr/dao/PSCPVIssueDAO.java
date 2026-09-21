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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVIssueDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCPVIssue;
import org.springframework.stereotype.Repository;

@Repository
public class PSCPVIssueDAO
extends PSCoreSysDAOBase<PSCPVIssue> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCPVIssueDEModel pSCPVIssueDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSCPVIssueDAO";
    }

    public PSCPVIssueDEModel getPSCPVIssueDEModel() {
        if (this.pSCPVIssueDEModel == null) {
            try {
                this.pSCPVIssueDEModel = (PSCPVIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCPVIssueDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCPVIssueDEModel();
    }
}

