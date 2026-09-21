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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysAppDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnSysAppDAO
extends PSCoreSysDAOBase<PSDepSlnSysApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnSysAppDEModel pSDepSlnSysAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysAppDAO";
    }

    public PSDepSlnSysAppDEModel getPSDepSlnSysAppDEModel() {
        if (this.pSDepSlnSysAppDEModel == null) {
            try {
                this.pSDepSlnSysAppDEModel = (PSDepSlnSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnSysAppDEModel();
    }
}

