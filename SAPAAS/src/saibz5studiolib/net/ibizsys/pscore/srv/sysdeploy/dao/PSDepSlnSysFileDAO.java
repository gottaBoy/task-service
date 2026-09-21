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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysFileDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysFile;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnSysFileDAO
extends PSCoreSysDAOBase<PSDepSlnSysFile> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnSysFileDEModel pSDepSlnSysFileDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysFileDAO";
    }

    public PSDepSlnSysFileDEModel getPSDepSlnSysFileDEModel() {
        if (this.pSDepSlnSysFileDEModel == null) {
            try {
                this.pSDepSlnSysFileDEModel = (PSDepSlnSysFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysFileDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnSysFileDEModel();
    }
}

