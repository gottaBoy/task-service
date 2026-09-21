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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWFEngineInstDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWFEngineInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFEngineInstDAO
extends PSCoreSysDAOBase<PSWFEngineInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFEngineInstDEModel pSWFEngineInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSWFEngineInstDAO";
    }

    public PSWFEngineInstDEModel getPSWFEngineInstDEModel() {
        if (this.pSWFEngineInstDEModel == null) {
            try {
                this.pSWFEngineInstDEModel = (PSWFEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWFEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFEngineInstDEModel();
    }
}

