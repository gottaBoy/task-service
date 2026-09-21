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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDPartDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBDPartDAO
extends PSCoreSysDAOBase<PSSysBDPart> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURBDS = "CurBDS";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBDPartDEModel pSSysBDPartDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDPartDAO";
    }

    public PSSysBDPartDEModel getPSSysBDPartDEModel() {
        if (this.pSSysBDPartDEModel == null) {
            try {
                this.pSSysBDPartDEModel = (PSSysBDPartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDPartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDPartDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBDPartDEModel();
    }
}

