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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysModelInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysModelInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSysModelInstDAO
extends PSCoreSysDAOBase<PSDCSysModelInst> {
    private static final long serialVersionUID = -1L;
    private PSDCSysModelInstDEModel pSDCSysModelInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSysModelInstDAO";
    }

    public PSDCSysModelInstDEModel getPSDCSysModelInstDEModel() {
        if (this.pSDCSysModelInstDEModel == null) {
            try {
                this.pSDCSysModelInstDEModel = (PSDCSysModelInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysModelInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysModelInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSysModelInstDEModel();
    }
}

