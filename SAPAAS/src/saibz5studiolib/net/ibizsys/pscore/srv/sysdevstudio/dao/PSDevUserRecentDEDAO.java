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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevUserRecentDEDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevUserRecentDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevUserRecentDEDAO
extends PSCoreSysDAOBase<PSDevUserRecentDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSERAPP = "CurUserApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW = "VIEW";
    private PSDevUserRecentDEDEModel pSDevUserRecentDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevUserRecentDEDAO";
    }

    public PSDevUserRecentDEDEModel getPSDevUserRecentDEDEModel() {
        if (this.pSDevUserRecentDEDEModel == null) {
            try {
                this.pSDevUserRecentDEDEModel = (PSDevUserRecentDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevUserRecentDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserRecentDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevUserRecentDEDEModel();
    }
}

