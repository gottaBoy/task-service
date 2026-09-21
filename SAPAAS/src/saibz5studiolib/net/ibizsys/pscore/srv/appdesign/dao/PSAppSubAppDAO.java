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
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppSubAppDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSubApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppSubAppDAO
extends PSCoreSysDAOBase<PSAppSubApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppSubAppDEModel pSAppSubAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppSubAppDAO";
    }

    public PSAppSubAppDEModel getPSAppSubAppDEModel() {
        if (this.pSAppSubAppDEModel == null) {
            try {
                this.pSAppSubAppDEModel = (PSAppSubAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppSubAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSubAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppSubAppDEModel();
    }
}

