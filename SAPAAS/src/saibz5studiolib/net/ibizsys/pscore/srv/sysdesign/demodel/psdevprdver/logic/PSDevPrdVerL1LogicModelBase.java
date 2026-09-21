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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdver.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdVerL1LogicModelBase
extends DELogicModelBase<PSDevPrdVer> {
    private static final Log log = LogFactory.getLog(PSDevPrdVerL1LogicModelBase.class);

    public PSDevPrdVerL1LogicModelBase() {
        this.setId("C9D24577-2054-4C35-995C-DFC1FA40DD17");
        this.setName("L1");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDevPrdVer.set("psdevprdid", WebContext.getCurrent().getPostValue("srfparentkey"));
    }
}

