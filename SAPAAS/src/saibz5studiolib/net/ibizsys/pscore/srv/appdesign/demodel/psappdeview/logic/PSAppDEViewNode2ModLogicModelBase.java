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
package net.ibizsys.pscore.srv.appdesign.demodel.psappdeview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDEViewNode2ModLogicModelBase
extends DELogicModelBase<PSAppDEView> {
    private static final Log log = LogFactory.getLog(PSAppDEViewNode2ModLogicModelBase.class);

    public PSAppDEViewNode2ModLogicModelBase() {
        this.setId("5168C195-EA34-4328-AFF2-215D1C8568F9");
        this.setName("Node2Mod");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppDEView pSAppDEView = (PSAppDEView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppDEView pSAppDEView = (PSAppDEView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppDEView.set("PSAPPMODULEID", pSAppDEView.get("nodeid"));
    }
}

