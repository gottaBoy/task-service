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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDBInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnDBInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnDBInstDAO
extends PSCoreSysDAOBase<PSDepSlnDBInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnDBInstDEModel pSDepSlnDBInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnDBInstDAO";
    }

    public PSDepSlnDBInstDEModel getPSDepSlnDBInstDEModel() {
        if (this.pSDepSlnDBInstDEModel == null) {
            try {
                this.pSDepSlnDBInstDEModel = (PSDepSlnDBInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDBInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnDBInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnDBInstDEModel();
    }
}

