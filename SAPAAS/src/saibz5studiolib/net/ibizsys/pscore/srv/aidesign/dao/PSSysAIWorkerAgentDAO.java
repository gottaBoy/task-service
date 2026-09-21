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
package net.ibizsys.pscore.srv.aidesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIWorkerAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysAIWorkerAgentDAO
extends PSCoreSysDAOBase<PSSysAIWorkerAgent> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAIFACTORY = "CurAIFactory";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysAIWorkerAgentDEModel pSSysAIWorkerAgentDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.aidesign.dao.PSSysAIWorkerAgentDAO";
    }

    public PSSysAIWorkerAgentDEModel getPSSysAIWorkerAgentDEModel() {
        if (this.pSSysAIWorkerAgentDEModel == null) {
            try {
                this.pSSysAIWorkerAgentDEModel = (PSSysAIWorkerAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIWorkerAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIWorkerAgentDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysAIWorkerAgentDEModel();
    }
}

