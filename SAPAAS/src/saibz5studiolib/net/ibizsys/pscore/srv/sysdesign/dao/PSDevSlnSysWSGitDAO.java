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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysWSGitDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysWSGit;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysWSGitDAO
extends PSCoreSysDAOBase<PSDevSlnSysWSGit> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysWSGitDEModel pSDevSlnSysWSGitDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysWSGitDAO";
    }

    public PSDevSlnSysWSGitDEModel getPSDevSlnSysWSGitDEModel() {
        if (this.pSDevSlnSysWSGitDEModel == null) {
            try {
                this.pSDevSlnSysWSGitDEModel = (PSDevSlnSysWSGitDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysWSGitDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysWSGitDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysWSGitDEModel();
    }
}

