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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSVNBKDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSVNBK;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSVNBKDAO
extends PSCoreSysDAOBase<PSDCSVNBK> {
    private static final long serialVersionUID = -1L;
    private PSDCSVNBKDEModel pSDCSVNBKDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSVNBKDAO";
    }

    public PSDCSVNBKDEModel getPSDCSVNBKDEModel() {
        if (this.pSDCSVNBKDEModel == null) {
            try {
                this.pSDCSVNBKDEModel = (PSDCSVNBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSVNBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSVNBKDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSVNBKDEModel();
    }
}

