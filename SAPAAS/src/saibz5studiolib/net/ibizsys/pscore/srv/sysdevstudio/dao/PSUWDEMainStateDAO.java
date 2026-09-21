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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDEMainStateDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDEMainState;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWDEMainStateDAO
extends PSCoreSysDAOBase<PSUWDEMainState> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWDEMainStateDEModel pSUWDEMainStateDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWDEMainStateDAO";
    }

    public PSUWDEMainStateDEModel getPSUWDEMainStateDEModel() {
        if (this.pSUWDEMainStateDEModel == null) {
            try {
                this.pSUWDEMainStateDEModel = (PSUWDEMainStateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDEMainStateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWDEMainStateDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWDEMainStateDEModel();
    }
}

