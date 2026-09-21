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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCSSessionDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCSSession;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnCSSessionDAO
extends PSCoreSysDAOBase<PSDevSlnCSSession> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnCSSessionDEModel pSDevSlnCSSessionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCSSessionDAO";
    }

    public PSDevSlnCSSessionDEModel getPSDevSlnCSSessionDEModel() {
        if (this.pSDevSlnCSSessionDEModel == null) {
            try {
                this.pSDevSlnCSSessionDEModel = (PSDevSlnCSSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCSSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCSSessionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnCSSessionDEModel();
    }
}

