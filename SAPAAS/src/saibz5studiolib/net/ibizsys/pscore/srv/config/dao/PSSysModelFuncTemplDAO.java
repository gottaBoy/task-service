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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFuncTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysModelFuncTemplDAO
extends PSCoreSysDAOBase<PSSysModelFuncTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysModelFuncTemplDEModel pSSysModelFuncTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysModelFuncTemplDAO";
    }

    public PSSysModelFuncTemplDEModel getPSSysModelFuncTemplDEModel() {
        if (this.pSSysModelFuncTemplDEModel == null) {
            try {
                this.pSSysModelFuncTemplDEModel = (PSSysModelFuncTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysModelFuncTemplDEModel();
    }
}

