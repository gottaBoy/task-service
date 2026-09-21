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
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineWorkerDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineWorker;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysAIPipelineWorkerDAO
extends PSCoreSysDAOBase<PSSysAIPipelineWorker> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysAIPipelineWorkerDEModel pSSysAIPipelineWorkerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineWorkerDAO";
    }

    public PSSysAIPipelineWorkerDEModel getPSSysAIPipelineWorkerDEModel() {
        if (this.pSSysAIPipelineWorkerDEModel == null) {
            try {
                this.pSSysAIPipelineWorkerDEModel = (PSSysAIPipelineWorkerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineWorkerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineWorkerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysAIPipelineWorkerDEModel();
    }
}

