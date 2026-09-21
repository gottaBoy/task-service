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
import net.ibizsys.pscore.srv.config.demodel.PSHelpPrjTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpPrjTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpPrjTemplDAO
extends PSCoreSysDAOBase<PSHelpPrjTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpPrjTemplDEModel pSHelpPrjTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSHelpPrjTemplDAO";
    }

    public PSHelpPrjTemplDEModel getPSHelpPrjTemplDEModel() {
        if (this.pSHelpPrjTemplDEModel == null) {
            try {
                this.pSHelpPrjTemplDEModel = (PSHelpPrjTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpPrjTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpPrjTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpPrjTemplDEModel();
    }
}

