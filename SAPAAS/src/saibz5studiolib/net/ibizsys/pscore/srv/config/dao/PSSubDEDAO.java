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
import net.ibizsys.pscore.srv.config.demodel.PSSubDEDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubDEDAO
extends PSCoreSysDAOBase<PSSubDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubDEDEModel pSSubDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSubDEDAO";
    }

    public PSSubDEDEModel getPSSubDEDEModel() {
        if (this.pSSubDEDEModel == null) {
            try {
                this.pSSubDEDEModel = (PSSubDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubDEDEModel();
    }
}

