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
package net.ibizsys.pscore.srv.def.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.def.demodel.PSDBProcParamDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDBProcParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSDBProcParamDAO
extends PSCoreSysDAOBase<PSDBProcParam> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDBProcParamDEModel pSDBProcParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSDBProcParamDAO";
    }

    public PSDBProcParamDEModel getPSDBProcParamDEModel() {
        if (this.pSDBProcParamDEModel == null) {
            try {
                this.pSDBProcParamDEModel = (PSDBProcParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDBProcParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBProcParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDBProcParamDEModel();
    }
}

