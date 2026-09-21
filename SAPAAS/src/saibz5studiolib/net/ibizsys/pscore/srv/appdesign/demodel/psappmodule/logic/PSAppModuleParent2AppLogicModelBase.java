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
package net.ibizsys.pscore.srv.appdesign.demodel.psappmodule.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppModuleParent2AppLogicModelBase
extends DELogicModelBase<PSAppModule> {
    private static final Log log = LogFactory.getLog(PSAppModuleParent2AppLogicModelBase.class);

    public PSAppModuleParent2AppLogicModelBase() {
        this.setId("67C92FAF-3A58-4083-94EC-F15D6591A088");
        this.setName("Parent2App");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppModule pSAppModule = (PSAppModule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppModule pSAppModule = (PSAppModule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppModule.set("PSSYSAPPID", WebContext.getCurrent().getPostValue("srfparentkey"));
    }
}

