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
import net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSUSModuleInstDAO
extends PSCoreSysDAOBase<PSUSModuleInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUSModuleInstDEModel pSUSModuleInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstDAO";
    }

    public PSUSModuleInstDEModel getPSUSModuleInstDEModel() {
        if (this.pSUSModuleInstDEModel == null) {
            try {
                this.pSUSModuleInstDEModel = (PSUSModuleInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUSModuleInstDEModel();
    }
}

