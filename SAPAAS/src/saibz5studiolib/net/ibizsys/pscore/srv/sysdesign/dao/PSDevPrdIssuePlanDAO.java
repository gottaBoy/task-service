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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssuePlanDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssuePlan;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdIssuePlanDAO
extends PSCoreSysDAOBase<PSDevPrdIssuePlan> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevPrdIssuePlanDEModel pSDevPrdIssuePlanDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssuePlanDAO";
    }

    public PSDevPrdIssuePlanDEModel getPSDevPrdIssuePlanDEModel() {
        if (this.pSDevPrdIssuePlanDEModel == null) {
            try {
                this.pSDevPrdIssuePlanDEModel = (PSDevPrdIssuePlanDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssuePlanDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssuePlanDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdIssuePlanDEModel();
    }
}

