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
import net.ibizsys.pscore.srv.config.demodel.PSModelRSDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelRS;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelRSDAO
extends PSCoreSysDAOBase<PSModelRS> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelRSDEModel pSModelRSDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelRSDAO";
    }

    public PSModelRSDEModel getPSModelRSDEModel() {
        if (this.pSModelRSDEModel == null) {
            try {
                this.pSModelRSDEModel = (PSModelRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelRSDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelRSDEModel();
    }
}

