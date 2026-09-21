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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDERDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDER;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBDTableDERDAO
extends PSCoreSysDAOBase<PSSysBDTableDER> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBDTableDERDEModel pSSysBDTableDERDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDERDAO";
    }

    public PSSysBDTableDERDEModel getPSSysBDTableDERDEModel() {
        if (this.pSSysBDTableDERDEModel == null) {
            try {
                this.pSSysBDTableDERDEModel = (PSSysBDTableDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDERDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBDTableDERDEModel();
    }
}

