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
import net.ibizsys.pscore.srv.config.demodel.PSSubAppDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubAppDAO
extends PSCoreSysDAOBase<PSSubApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSUBSYS = "CurSubSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubAppDEModel pSSubAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSubAppDAO";
    }

    public PSSubAppDEModel getPSSubAppDEModel() {
        if (this.pSSubAppDEModel == null) {
            try {
                this.pSSubAppDEModel = (PSSubAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubAppDEModel();
    }
}

