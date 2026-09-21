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
package net.ibizsys.pscore.srv.wfplatform.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWFEngineDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWFEngine;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFEngineDAO
extends PSCoreSysDAOBase<PSWFEngine> {
    private static final long serialVersionUID = -1L;
    private PSWFEngineDEModel pSWFEngineDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWFEngineDAO";
    }

    public PSWFEngineDEModel getPSWFEngineDEModel() {
        if (this.pSWFEngineDEModel == null) {
            try {
                this.pSWFEngineDEModel = (PSWFEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWFEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFEngineDEModel();
    }
}

