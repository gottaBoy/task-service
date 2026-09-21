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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStageDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnPipelineStageDAO
extends PSCoreSysDAOBase<PSDevSlnPipelineStage> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPIPELINE = "CurPipeline";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnPipelineStageDEModel pSDevSlnPipelineStageDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStageDAO";
    }

    public PSDevSlnPipelineStageDEModel getPSDevSlnPipelineStageDEModel() {
        if (this.pSDevSlnPipelineStageDEModel == null) {
            try {
                this.pSDevSlnPipelineStageDEModel = (PSDevSlnPipelineStageDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStageDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineStageDEModel();
    }
}

