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

public abstract class PSDevPrdSubVerL1LogicModelBase
extends DELogicModelBase<PSDevPrdSubVer> {
    private static final Log log = LogFactory.getLog(PSDevPrdSubVerL1LogicModelBase.class);

    public PSDevPrdSubVerL1LogicModelBase() {
        this.setId("2DD5A226-8695-4522-B10B-15CF5FF279F3");
        this.setName("L1");
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
        pSDevPrdSubVer.set("PSDEVPRDVERID", pSDevPrdSubVer.get("nodeid"));
    }
}

