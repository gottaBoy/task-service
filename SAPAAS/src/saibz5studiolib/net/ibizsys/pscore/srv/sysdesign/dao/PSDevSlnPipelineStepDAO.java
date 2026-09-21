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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStepDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnPipelineStepDAO
extends PSCoreSysDAOBase<PSDevSlnPipelineStep> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPIPELINE = "CurPipeline";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnPipelineStepDEModel pSDevSlnPipelineStepDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStepDAO";
    }

    public PSDevSlnPipelineStepDEModel getPSDevSlnPipelineStepDEModel() {
        if (this.pSDevSlnPipelineStepDEModel == null) {
            try {
                this.pSDevSlnPipelineStepDEModel = (PSDevSlnPipelineStepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStepDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineStepDEModel();
    }
}

