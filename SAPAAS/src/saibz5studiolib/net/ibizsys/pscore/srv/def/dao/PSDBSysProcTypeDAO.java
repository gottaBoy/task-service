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
import net.ibizsys.pscore.srv.def.demodel.PSDBSysProcTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDBSysProcTypeDAO
extends PSCoreSysDAOBase<PSDBSysProcType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDBSysProcTypeDEModel pSDBSysProcTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSDBSysProcTypeDAO";
    }

    public PSDBSysProcTypeDEModel getPSDBSysProcTypeDEModel() {
        if (this.pSDBSysProcTypeDEModel == null) {
            try {
                this.pSDBSysProcTypeDEModel = (PSDBSysProcTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDBSysProcTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBSysProcTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDBSysProcTypeDEModel();
    }
}

