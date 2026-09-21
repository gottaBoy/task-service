/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpmodule.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpModuleL1LogicModelBase
extends DELogicModelBase<PSHelpModule> {
    private static final Log log = LogFactory.getLog(PSHelpModuleL1LogicModelBase.class);

    public PSHelpModuleL1LogicModelBase() {
        this.setId("63E607AB-54A1-4745-AC91-E54D15EAB10F");
        this.setName("L1");
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
        pSHelpModule.set("PSHELPPRJID", WebContext.getCurrent().getPostValue("srfparentkey"));
    }
}

