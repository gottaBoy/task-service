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
package net.ibizsys.pscore.srv.bdscheme.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDModuleDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBDModuleDAO
extends PSCoreSysDAOBase<PSSysBDModule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSCHEME = "CurScheme";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBDModuleDEModel pSSysBDModuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDModuleDAO";
    }

    public PSSysBDModuleDEModel getPSSysBDModuleDEModel() {
        if (this.pSSysBDModuleDEModel == null) {
            try {
                this.pSSysBDModuleDEModel = (PSSysBDModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDModuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBDModuleDEModel();
    }
}

