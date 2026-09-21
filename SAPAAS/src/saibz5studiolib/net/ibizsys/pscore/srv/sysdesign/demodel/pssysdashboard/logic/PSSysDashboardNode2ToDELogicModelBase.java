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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdashboard.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDashboardNode2ToDELogicModelBase
extends DELogicModelBase<PSSysDashboard> {
    private static final Log log = LogFactory.getLog(PSSysDashboardNode2ToDELogicModelBase.class);

    public PSSysDashboardNode2ToDELogicModelBase() {
        this.setId("5D38FC72-BDB9-443C-ABFA-A2C09B8189C6");
        this.setName("Node2ToDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSysDashboard pSSysDashboard = (PSSysDashboard)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSysDashboard pSSysDashboard = (PSSysDashboard)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysDashboard.set("PSDEID", pSSysDashboard.get("nodeid2"));
    }
}

