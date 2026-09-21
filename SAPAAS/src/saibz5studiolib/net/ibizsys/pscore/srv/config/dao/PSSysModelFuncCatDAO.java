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
import net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFuncCat;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysModelFuncCatDAO
extends PSCoreSysDAOBase<PSSysModelFuncCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysModelFuncCatDEModel pSSysModelFuncCatDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysModelFuncCatDAO";
    }

    public PSSysModelFuncCatDEModel getPSSysModelFuncCatDEModel() {
        if (this.pSSysModelFuncCatDEModel == null) {
            try {
                this.pSSysModelFuncCatDEModel = (PSSysModelFuncCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncCatDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysModelFuncCatDEModel();
    }
}

