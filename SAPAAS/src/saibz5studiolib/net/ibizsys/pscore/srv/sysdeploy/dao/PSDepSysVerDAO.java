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
package net.ibizsys.pscore.srv.sysdeploy.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysVerDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSysVerDAO
extends PSCoreSysDAOBase<PSDepSysVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSysVerDEModel pSDepSysVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysVerDAO";
    }

    public PSDepSysVerDEModel getPSDepSysVerDEModel() {
        if (this.pSDepSysVerDEModel == null) {
            try {
                this.pSDepSysVerDEModel = (PSDepSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSysVerDEModel();
    }
}

