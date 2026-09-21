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
package net.ibizsys.pscore.srv.wfdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkRoleDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRole;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFLinkRoleDAO
extends PSCoreSysDAOBase<PSWFLinkRole> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFLinkRoleDEModel pSWFLinkRoleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkRoleDAO";
    }

    public PSWFLinkRoleDEModel getPSWFLinkRoleDEModel() {
        if (this.pSWFLinkRoleDEModel == null) {
            try {
                this.pSWFLinkRoleDEModel = (PSWFLinkRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkRoleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFLinkRoleDEModel();
    }
}

