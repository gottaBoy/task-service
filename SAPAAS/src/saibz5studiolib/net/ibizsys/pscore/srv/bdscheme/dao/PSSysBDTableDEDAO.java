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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBDTableDEDAO
extends PSCoreSysDAOBase<PSSysBDTableDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURBDT = "CurBDT";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBDTableDEDEModel pSSysBDTableDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDEDAO";
    }

    public PSSysBDTableDEDEModel getPSSysBDTableDEDEModel() {
        if (this.pSSysBDTableDEDEModel == null) {
            try {
                this.pSSysBDTableDEDEModel = (PSSysBDTableDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBDTableDEDEModel();
    }
}

