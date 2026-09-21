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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSdepSlnDepSessionDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSdepSlnDepSession;
import org.springframework.stereotype.Repository;

@Repository
public class PSdepSlnDepSessionDAO
extends PSCoreSysDAOBase<PSdepSlnDepSession> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSdepSlnDepSessionDEModel pSdepSlnDepSessionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSdepSlnDepSessionDAO";
    }

    public PSdepSlnDepSessionDEModel getPSdepSlnDepSessionDEModel() {
        if (this.pSdepSlnDepSessionDEModel == null) {
            try {
                this.pSdepSlnDepSessionDEModel = (PSdepSlnDepSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSdepSlnDepSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSdepSlnDepSessionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSdepSlnDepSessionDEModel();
    }
}

