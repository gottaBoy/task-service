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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWAppViewDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWAppView;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWAppViewDAO
extends PSCoreSysDAOBase<PSUWAppView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWAppViewDEModel pSUWAppViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWAppViewDAO";
    }

    public PSUWAppViewDEModel getPSUWAppViewDEModel() {
        if (this.pSUWAppViewDEModel == null) {
            try {
                this.pSUWAppViewDEModel = (PSUWAppViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWAppViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWAppViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWAppViewDEModel();
    }
}

