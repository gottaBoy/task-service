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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerLog;
import org.springframework.stereotype.Repository;

@Repository
public class PSTaskServerLogDAO
extends PSCoreSysDAOBase<PSTaskServerLog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSTaskServerLogDEModel pSTaskServerLogDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerLogDAO";
    }

    public PSTaskServerLogDEModel getPSTaskServerLogDEModel() {
        if (this.pSTaskServerLogDEModel == null) {
            try {
                this.pSTaskServerLogDEModel = (PSTaskServerLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerLogDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSTaskServerLogDEModel();
    }
}

