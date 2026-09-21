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
package net.ibizsys.pscore.srv.appdesign.demodel.psappportalview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPortalViewNode2ModLogicModelBase
extends DELogicModelBase<PSAppPortalView> {
    private static final Log log = LogFactory.getLog(PSAppPortalViewNode2ModLogicModelBase.class);

    public PSAppPortalViewNode2ModLogicModelBase() {
        this.setId("7B711D04-1D6C-4099-909B-2A30736237CF");
        this.setName("Node2Mod");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppPortalView pSAppPortalView = (PSAppPortalView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppPortalView pSAppPortalView = (PSAppPortalView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppPortalView.set("PSAPPMODULEID", pSAppPortalView.get("nodeid"));
    }
}

