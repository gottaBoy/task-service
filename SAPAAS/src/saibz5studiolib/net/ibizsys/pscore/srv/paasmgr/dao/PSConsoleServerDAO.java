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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSConsoleServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSConsoleServer;
import org.springframework.stereotype.Repository;

@Repository
public class PSConsoleServerDAO
extends PSCoreSysDAOBase<PSConsoleServer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSConsoleServerDEModel pSConsoleServerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSConsoleServerDAO";
    }

    public PSConsoleServerDEModel getPSConsoleServerDEModel() {
        if (this.pSConsoleServerDEModel == null) {
            try {
                this.pSConsoleServerDEModel = (PSConsoleServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSConsoleServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSConsoleServerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSConsoleServerDEModel();
    }
}

