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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSMQInstDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMQInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSMQInstDAO
extends PSCoreSysDAOBase<PSMQInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSMQInstDEModel pSMQInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSMQInstDAO";
    }

    public PSMQInstDEModel getPSMQInstDEModel() {
        if (this.pSMQInstDEModel == null) {
            try {
                this.pSMQInstDEModel = (PSMQInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSMQInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMQInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSMQInstDEModel();
    }
}

