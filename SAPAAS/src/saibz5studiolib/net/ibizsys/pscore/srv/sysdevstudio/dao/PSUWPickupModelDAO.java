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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWPickupModelDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWPickupModel;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWPickupModelDAO
extends PSCoreSysDAOBase<PSUWPickupModel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWPickupModelDEModel pSUWPickupModelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWPickupModelDAO";
    }

    public PSUWPickupModelDEModel getPSUWPickupModelDEModel() {
        if (this.pSUWPickupModelDEModel == null) {
            try {
                this.pSUWPickupModelDEModel = (PSUWPickupModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWPickupModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWPickupModelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWPickupModelDEModel();
    }
}

