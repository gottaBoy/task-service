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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsubver.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSubVerL2LogicModelBase
extends DELogicModelBase<PSDevPrdSubVer> {
    private static final Log log = LogFactory.getLog(PSDevPrdSubVerL2LogicModelBase.class);

    public PSDevPrdSubVerL2LogicModelBase() {
        this.setId("E5A9BA68-EC3B-4C2A-8475-4D10CD5E8EBC");
        this.setName("L2");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDevPrdSubVer.set("PPSDEVPRDSUBVERID", pSDevPrdSubVer.get("nodeid2"));
    }
}

