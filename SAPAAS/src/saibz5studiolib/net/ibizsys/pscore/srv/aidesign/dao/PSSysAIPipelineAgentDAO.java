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
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysAIPipelineAgentDAO
extends PSCoreSysDAOBase<PSSysAIPipelineAgent> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAIFACTORY = "CurAIFactory";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysAIPipelineAgentDEModel pSSysAIPipelineAgentDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineAgentDAO";
    }

    public PSSysAIPipelineAgentDEModel getPSSysAIPipelineAgentDEModel() {
        if (this.pSSysAIPipelineAgentDEModel == null) {
            try {
                this.pSSysAIPipelineAgentDEModel = (PSSysAIPipelineAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineAgentDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysAIPipelineAgentDEModel();
    }
}

