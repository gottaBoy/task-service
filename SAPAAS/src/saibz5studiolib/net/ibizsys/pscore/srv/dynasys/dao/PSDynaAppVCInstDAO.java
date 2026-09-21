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
package net.ibizsys.pscore.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppVCInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppVCInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaAppVCInstDAO
extends PSCoreSysDAOBase<PSDynaAppVCInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaAppVCInstDEModel pSDynaAppVCInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppVCInstDAO";
    }

    public PSDynaAppVCInstDEModel getPSDynaAppVCInstDEModel() {
        if (this.pSDynaAppVCInstDEModel == null) {
            try {
                this.pSDynaAppVCInstDEModel = (PSDynaAppVCInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppVCInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppVCInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaAppVCInstDEModel();
    }
}

