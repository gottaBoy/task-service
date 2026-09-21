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
import net.ibizsys.pscore.srv.config.demodel.PSModelViewUIActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelViewUIAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelViewUIActionDAO
extends PSCoreSysDAOBase<PSModelViewUIAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelViewUIActionDEModel pSModelViewUIActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelViewUIActionDAO";
    }

    public PSModelViewUIActionDEModel getPSModelViewUIActionDEModel() {
        if (this.pSModelViewUIActionDEModel == null) {
            try {
                this.pSModelViewUIActionDEModel = (PSModelViewUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelViewUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelViewUIActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelViewUIActionDEModel();
    }
}

