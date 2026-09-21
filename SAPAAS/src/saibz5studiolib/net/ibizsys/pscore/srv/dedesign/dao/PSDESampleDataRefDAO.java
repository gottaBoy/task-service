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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataRefDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataRef;
import org.springframework.stereotype.Repository;

@Repository
public class PSDESampleDataRefDAO
extends PSCoreSysDAOBase<PSDESampleDataRef> {
    private static final long serialVersionUID = -1L;
    private PSDESampleDataRefDEModel pSDESampleDataRefDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDESampleDataRefDAO";
    }

    public PSDESampleDataRefDEModel getPSDESampleDataRefDEModel() {
        if (this.pSDESampleDataRefDEModel == null) {
            try {
                this.pSDESampleDataRefDEModel = (PSDESampleDataRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESampleDataRefDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDESampleDataRefDEModel();
    }
}

