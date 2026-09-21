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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSearchEngineInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSearchEngineInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSearchEngineInstDAO
extends PSCoreSysDAOBase<PSDCSearchEngineInst> {
    private static final long serialVersionUID = -1L;
    private PSDCSearchEngineInstDEModel pSDCSearchEngineInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSearchEngineInstDAO";
    }

    public PSDCSearchEngineInstDEModel getPSDCSearchEngineInstDEModel() {
        if (this.pSDCSearchEngineInstDEModel == null) {
            try {
                this.pSDCSearchEngineInstDEModel = (PSDCSearchEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSearchEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSearchEngineInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSearchEngineInstDEModel();
    }
}

