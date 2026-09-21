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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard2DEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import org.springframework.stereotype.Repository;

@Repository
public class PSUAWizard2DAO
extends PSCoreSysDAOBase<PSUAWizard2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW = "View";
    private PSUAWizard2DEModel pSUAWizard2DEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUAWizard2DAO";
    }

    public PSUAWizard2DEModel getPSUAWizard2DEModel() {
        if (this.pSUAWizard2DEModel == null) {
            try {
                this.pSUAWizard2DEModel = (PSUAWizard2DEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUAWizard2DEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUAWizard2DEModel();
    }
}

