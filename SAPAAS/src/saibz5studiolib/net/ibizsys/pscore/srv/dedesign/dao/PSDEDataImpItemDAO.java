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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataImpItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEDataImpItemDAO
extends PSCoreSysDAOBase<PSDEDataImpItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEDataImpItemDEModel pSDEDataImpItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEDataImpItemDAO";
    }

    public PSDEDataImpItemDEModel getPSDEDataImpItemDEModel() {
        if (this.pSDEDataImpItemDEModel == null) {
            try {
                this.pSDEDataImpItemDEModel = (PSDEDataImpItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataImpItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataImpItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEDataImpItemDEModel();
    }
}

