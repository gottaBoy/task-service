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
package net.ibizsys.pscore.srv.systest.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTestModuleDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTestModuleDAO
extends PSCoreSysDAOBase<PSSysTestModule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURPRJ = "CurPrj";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSAPI = "CurSysAPI";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTestModuleDEModel pSSysTestModuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.systest.dao.PSSysTestModuleDAO";
    }

    public PSSysTestModuleDEModel getPSSysTestModuleDEModel() {
        if (this.pSSysTestModuleDEModel == null) {
            try {
                this.pSSysTestModuleDEModel = (PSSysTestModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestModuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTestModuleDEModel();
    }
}

