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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerLog;
import org.springframework.stereotype.Repository;

@Repository
public class PSStudioServerLogDAO
extends PSCoreSysDAOBase<PSStudioServerLog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSStudioServerLogDEModel pSStudioServerLogDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerLogDAO";
    }

    public PSStudioServerLogDEModel getPSStudioServerLogDEModel() {
        if (this.pSStudioServerLogDEModel == null) {
            try {
                this.pSStudioServerLogDEModel = (PSStudioServerLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerLogDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSStudioServerLogDEModel();
    }
}

