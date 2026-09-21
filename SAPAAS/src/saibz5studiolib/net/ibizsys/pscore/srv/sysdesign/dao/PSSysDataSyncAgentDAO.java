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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDataSyncAgentDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysDataSyncAgentDAO
extends PSCoreSysDAOBase<PSSysDataSyncAgent> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_IN = "IN";
    public static final String DATAQUERY_INOUT = "INOUT";
    public static final String DATAQUERY_OUT = "OUT";
    private PSSysDataSyncAgentDEModel pSSysDataSyncAgentDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysDataSyncAgentDAO";
    }

    public PSSysDataSyncAgentDEModel getPSSysDataSyncAgentDEModel() {
        if (this.pSSysDataSyncAgentDEModel == null) {
            try {
                this.pSSysDataSyncAgentDEModel = (PSSysDataSyncAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDataSyncAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDataSyncAgentDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysDataSyncAgentDEModel();
    }
}

