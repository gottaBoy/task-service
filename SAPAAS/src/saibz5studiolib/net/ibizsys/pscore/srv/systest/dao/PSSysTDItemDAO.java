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
package net.ibizsys.pscore.srv.systest.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTDItemDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTDItemDAO
extends PSCoreSysDAOBase<PSSysTDItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTDItemDEModel pSSysTDItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.systest.dao.PSSysTDItemDAO";
    }

    public PSSysTDItemDEModel getPSSysTDItemDEModel() {
        if (this.pSSysTDItemDEModel == null) {
            try {
                this.pSSysTDItemDEModel = (PSSysTDItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTDItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTDItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTDItemDEModel();
    }
}

