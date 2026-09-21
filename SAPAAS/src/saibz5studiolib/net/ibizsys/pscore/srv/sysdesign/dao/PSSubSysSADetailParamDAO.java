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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubSysSADetailParamDAO
extends PSCoreSysDAOBase<PSSubSysSADetailParam> {
    private static final long serialVersionUID = -1L;
    private PSSubSysSADetailParamDEModel pSSubSysSADetailParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADetailParamDAO";
    }

    public PSSubSysSADetailParamDEModel getPSSubSysSADetailParamDEModel() {
        if (this.pSSubSysSADetailParamDEModel == null) {
            try {
                this.pSSubSysSADetailParamDEModel = (PSSubSysSADetailParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADetailParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubSysSADetailParamDEModel();
    }
}

