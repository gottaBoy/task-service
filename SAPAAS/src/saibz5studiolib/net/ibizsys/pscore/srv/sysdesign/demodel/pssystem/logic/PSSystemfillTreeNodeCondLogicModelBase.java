/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystem.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemfillTreeNodeCondLogicModelBase
extends DELogicModelBase<PSSystem> {
    private static final Log log = LogFactory.getLog(PSSystemfillTreeNodeCondLogicModelBase.class);

    public PSSystemfillTreeNodeCondLogicModelBase() {
        this.setId("4A9A8209-FDFA-427A-9533-DA5AA8ADF350");
        this.setName("fillTreeNodeCond");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSystem pSSystem = (PSSystem)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSystem pSSystem = (PSSystem)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSystem.set("PSMODULEID", pSSystem.get("NODEID"));
    }
}

