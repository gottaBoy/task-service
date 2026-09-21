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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewServiceDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewService;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEViewServiceDAO
extends PSCoreSysDAOBase<PSDEViewService> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEViewServiceDEModel pSDEViewServiceDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEViewServiceDAO";
    }

    public PSDEViewServiceDEModel getPSDEViewServiceDEModel() {
        if (this.pSDEViewServiceDEModel == null) {
            try {
                this.pSDEViewServiceDEModel = (PSDEViewServiceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewServiceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewServiceDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEViewServiceDEModel();
    }
}

