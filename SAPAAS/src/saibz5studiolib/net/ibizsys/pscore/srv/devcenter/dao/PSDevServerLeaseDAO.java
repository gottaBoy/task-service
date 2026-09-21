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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevServerLeaseDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevServerLease;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevServerLeaseDAO
extends PSCoreSysDAOBase<PSDevServerLease> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevServerLeaseDEModel pSDevServerLeaseDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevServerLeaseDAO";
    }

    public PSDevServerLeaseDEModel getPSDevServerLeaseDEModel() {
        if (this.pSDevServerLeaseDEModel == null) {
            try {
                this.pSDevServerLeaseDEModel = (PSDevServerLeaseDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevServerLeaseDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevServerLeaseDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevServerLeaseDEModel();
    }
}

