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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColSetDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBDColSetDAO
extends PSCoreSysDAOBase<PSSysBDColSet> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURBDT = "CurBDT";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBDColSetDEModel pSSysBDColSetDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDColSetDAO";
    }

    public PSSysBDColSetDEModel getPSSysBDColSetDEModel() {
        if (this.pSSysBDColSetDEModel == null) {
            try {
                this.pSSysBDColSetDEModel = (PSSysBDColSetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColSetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDColSetDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBDColSetDEModel();
    }
}

