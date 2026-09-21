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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSGitUserDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import org.springframework.stereotype.Repository;

@Repository
public class PSGitUserDAO
extends PSCoreSysDAOBase<PSGitUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDCVALID = "AllDCValid";
    public static final String DATAQUERY_CURDCVALID = "CurDCValid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSGitUserDEModel pSGitUserDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSGitUserDAO";
    }

    public PSGitUserDEModel getPSGitUserDEModel() {
        if (this.pSGitUserDEModel == null) {
            try {
                this.pSGitUserDEModel = (PSGitUserDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSGitUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSGitUserDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSGitUserDEModel();
    }
}

