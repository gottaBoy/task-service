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
package net.ibizsys.pscore.srv.wfplatform.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWorkflowDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWorkflow;
import org.springframework.stereotype.Repository;

@Repository
public class PSWPDCWorkflowDAO
extends PSCoreSysDAOBase<PSWPDCWorkflow> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWPDCWorkflowDEModel pSWPDCWorkflowDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCWorkflowDAO";
    }

    public PSWPDCWorkflowDEModel getPSWPDCWorkflowDEModel() {
        if (this.pSWPDCWorkflowDEModel == null) {
            try {
                this.pSWPDCWorkflowDEModel = (PSWPDCWorkflowDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWorkflowDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCWorkflowDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWPDCWorkflowDEModel();
    }
}

