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
package net.ibizsys.pscore.srv.helpdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModuleDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpModuleDAO
extends PSCoreSysDAOBase<PSHelpModule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_CURPRJ = "CurPrj";
    public static final String DATAQUERY_CURPRJROOT = "CurPrjRoot";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ROOT = "Root";
    public static final String DATAQUERY_VALID = "Valid";
    public static final String DATAQUERY_VALIDROOT = "ValidRoot";
    private PSHelpModuleDEModel pSHelpModuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModuleDAO";
    }

    public PSHelpModuleDEModel getPSHelpModuleDEModel() {
        if (this.pSHelpModuleDEModel == null) {
            try {
                this.pSHelpModuleDEModel = (PSHelpModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpModuleDEModel();
    }
}

