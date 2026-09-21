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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import org.springframework.stereotype.Repository;

@Repository
public class PSTaskServerDAO
extends PSCoreSysDAOBase<PSTaskServer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSTaskServerDEModel pSTaskServerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerDAO";
    }

    public PSTaskServerDEModel getPSTaskServerDEModel() {
        if (this.pSTaskServerDEModel == null) {
            try {
                this.pSTaskServerDEModel = (PSTaskServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSTaskServerDEModel();
    }
}

