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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSSubSysVerInstDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVerInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubSysVerInstDAO
extends PSCoreSysDAOBase<PSSubSysVerInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubSysVerInstDEModel pSSubSysVerInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSubSysVerInstDAO";
    }

    public PSSubSysVerInstDEModel getPSSubSysVerInstDEModel() {
        if (this.pSSubSysVerInstDEModel == null) {
            try {
                this.pSSubSysVerInstDEModel = (PSSubSysVerInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubSysVerInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysVerInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubSysVerInstDEModel();
    }
}

