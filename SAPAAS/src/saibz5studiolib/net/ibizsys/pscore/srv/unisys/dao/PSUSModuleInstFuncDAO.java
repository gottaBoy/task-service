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
package net.ibizsys.pscore.srv.unisys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstFuncDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSModuleInstFuncDAO
extends PSCoreSysDAOBase<PSUSModuleInstFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSModuleInstFuncDEModel pSUSModuleInstFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstFuncDAO";
    }

    public PSUSModuleInstFuncDEModel getPSUSModuleInstFuncDEModel() {
        if (this.pSUSModuleInstFuncDEModel == null) {
            try {
                this.pSUSModuleInstFuncDEModel = (PSUSModuleInstFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSModuleInstFuncDEModel();
    }
}

