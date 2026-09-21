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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnPipelineDAO
extends PSCoreSysDAOBase<PSDevSlnPipeline> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNMAJORNOTSYS = "CurSlnMajorNotSys";
    public static final String DATAQUERY_CURSLNNOTSYS = "CurSlnNotSys";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSMAJOR = "CurSysMajor";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnPipelineDEModel pSDevSlnPipelineDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineDAO";
    }

    public PSDevSlnPipelineDEModel getPSDevSlnPipelineDEModel() {
        if (this.pSDevSlnPipelineDEModel == null) {
            try {
                this.pSDevSlnPipelineDEModel = (PSDevSlnPipelineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineDEModel();
    }
}

