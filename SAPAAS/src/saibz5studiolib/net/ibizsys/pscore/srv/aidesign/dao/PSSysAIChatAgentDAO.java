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
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIChatAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysAIChatAgentDAO
extends PSCoreSysDAOBase<PSSysAIChatAgent> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAIFACTORY = "CurAIFactory";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysAIChatAgentDEModel pSSysAIChatAgentDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.aidesign.dao.PSSysAIChatAgentDAO";
    }

    public PSSysAIChatAgentDEModel getPSSysAIChatAgentDEModel() {
        if (this.pSSysAIChatAgentDEModel == null) {
            try {
                this.pSSysAIChatAgentDEModel = (PSSysAIChatAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIChatAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIChatAgentDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysAIChatAgentDEModel();
    }
}

