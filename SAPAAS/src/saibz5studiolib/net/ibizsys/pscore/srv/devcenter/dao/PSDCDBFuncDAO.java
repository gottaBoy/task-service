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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBFuncDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCDBFuncDAO
extends PSCoreSysDAOBase<PSDCDBFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCDBFuncDEModel pSDCDBFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCDBFuncDAO";
    }

    public PSDCDBFuncDEModel getPSDCDBFuncDEModel() {
        if (this.pSDCDBFuncDEModel == null) {
            try {
                this.pSDCDBFuncDEModel = (PSDCDBFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCDBFuncDEModel();
    }
}

