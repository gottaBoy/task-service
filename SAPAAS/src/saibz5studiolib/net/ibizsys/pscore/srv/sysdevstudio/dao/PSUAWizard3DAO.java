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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard3DEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard3;
import org.springframework.stereotype.Repository;

@Repository
public class PSUAWizard3DAO
extends PSCoreSysDAOBase<PSUAWizard3> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUAWizard3DEModel pSUAWizard3DEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUAWizard3DAO";
    }

    public PSUAWizard3DEModel getPSUAWizard3DEModel() {
        if (this.pSUAWizard3DEModel == null) {
            try {
                this.pSUAWizard3DEModel = (PSUAWizard3DEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard3DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUAWizard3DEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUAWizard3DEModel();
    }
}

