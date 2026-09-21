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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevInfoDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevInfo;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysDevInfoDAO
extends PSCoreSysDAOBase<PSSysDevInfo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysDevInfoDEModel pSSysDevInfoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevInfoDAO";
    }

    public PSSysDevInfoDEModel getPSSysDevInfoDEModel() {
        if (this.pSSysDevInfoDEModel == null) {
            try {
                this.pSSysDevInfoDEModel = (PSSysDevInfoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevInfoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevInfoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysDevInfoDEModel();
    }
}

