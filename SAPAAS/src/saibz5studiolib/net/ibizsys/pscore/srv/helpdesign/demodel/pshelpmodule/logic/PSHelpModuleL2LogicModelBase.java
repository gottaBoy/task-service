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
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpmodule.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpModuleL2LogicModelBase
extends DELogicModelBase<PSHelpModule> {
    private static final Log log = LogFactory.getLog(PSHelpModuleL2LogicModelBase.class);

    public PSHelpModuleL2LogicModelBase() {
        this.setId("A25AF076-DD97-432C-913A-63CE3C3EFD50");
        this.setName("L2");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSHelpModule pSHelpModule = (PSHelpModule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSHelpModule pSHelpModule = (PSHelpModule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSHelpModule.set("PPSHELPMODULEID", pSHelpModule.get("nodeid"));
    }
}

