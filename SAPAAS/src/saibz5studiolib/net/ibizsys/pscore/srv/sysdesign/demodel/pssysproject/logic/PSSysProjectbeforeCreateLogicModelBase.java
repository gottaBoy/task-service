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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysproject.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysProjectbeforeCreateLogicModelBase
extends DELogicModelBase<PSSysProject> {
    private static final Log log = LogFactory.getLog(PSSysProjectbeforeCreateLogicModelBase.class);

    public PSSysProjectbeforeCreateLogicModelBase() {
        this.setId("40678CE4-9134-481D-BE55-5F7CD51A9D5E");
        this.setName("beforeCreate");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSysProject pSSysProject = (PSSysProject)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSSysProjectbeforeCreateLogicModelBase.testCond((Object)pSSysProject.get("PSOBJTYPE"), (String)"EQ", (Object)"PSSYSAPP")) {
            this.executePrepareparam1(iActionContext);
        }
        if (PSSysProjectbeforeCreateLogicModelBase.testCond((Object)pSSysProject.get("PSOBJTYPE"), (String)"EQ", (Object)"PSSYSSFPUB")) {
            this.executePrepareparam2(iActionContext);
        }
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSysProject pSSysProject = (PSSysProject)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysProject.set("PSOBJID", pSSysProject.get("PSSYSAPPID"));
        pSSysProject.set("PSOBJNAME", pSSysProject.get("PSSYSAPPNAME"));
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSSysProject pSSysProject = (PSSysProject)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysProject.set("PSOBJID", pSSysProject.get("PSSYSSFPUBID"));
        pSSysProject.set("PSOBJNAME", pSSysProject.get("PSSYSSFPUBNAME"));
    }
}

