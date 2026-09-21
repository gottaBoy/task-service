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
import net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppStartPageDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppStartPage;
import org.springframework.stereotype.Repository;

@Repository
public class PSMobAppStartPageDAO
extends PSCoreSysDAOBase<PSMobAppStartPage> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSMobAppStartPageDEModel pSMobAppStartPageDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSMobAppStartPageDAO";
    }

    public PSMobAppStartPageDEModel getPSMobAppStartPageDEModel() {
        if (this.pSMobAppStartPageDEModel == null) {
            try {
                this.pSMobAppStartPageDEModel = (PSMobAppStartPageDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppStartPageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppStartPageDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSMobAppStartPageDEModel();
    }
}

