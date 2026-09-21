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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETBItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDETBItemDAO
extends PSCoreSysDAOBase<PSDETBItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDETBItemDEModel pSDETBItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDETBItemDAO";
    }

    public PSDETBItemDEModel getPSDETBItemDEModel() {
        if (this.pSDETBItemDEModel == null) {
            try {
                this.pSDETBItemDEModel = (PSDETBItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETBItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETBItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDETBItemDEModel();
    }
}

