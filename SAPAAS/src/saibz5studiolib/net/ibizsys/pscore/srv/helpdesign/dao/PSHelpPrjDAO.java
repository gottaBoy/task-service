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
package net.ibizsys.pscore.srv.helpdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpPrjDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpPrj;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpPrjDAO
extends PSCoreSysDAOBase<PSHelpPrj> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpPrjDEModel pSHelpPrjDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpPrjDAO";
    }

    public PSHelpPrjDEModel getPSHelpPrjDEModel() {
        if (this.pSHelpPrjDEModel == null) {
            try {
                this.pSHelpPrjDEModel = (PSHelpPrjDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpPrjDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpPrjDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpPrjDEModel();
    }
}

