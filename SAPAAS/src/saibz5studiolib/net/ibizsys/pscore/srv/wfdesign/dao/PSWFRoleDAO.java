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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFRoleDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFRoleDAO
extends PSCoreSysDAOBase<PSWFRole> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFRoleDEModel pSWFRoleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFRoleDAO";
    }

    public PSWFRoleDEModel getPSWFRoleDEModel() {
        if (this.pSWFRoleDEModel == null) {
            try {
                this.pSWFRoleDEModel = (PSWFRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFRoleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFRoleDEModel();
    }
}

