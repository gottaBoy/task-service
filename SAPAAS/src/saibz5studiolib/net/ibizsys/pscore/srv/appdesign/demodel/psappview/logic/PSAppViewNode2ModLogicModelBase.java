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
package net.ibizsys.pscore.srv.appdesign.demodel.psappview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewNode2ModLogicModelBase
extends DELogicModelBase<PSAppView> {
    private static final Log log = LogFactory.getLog(PSAppViewNode2ModLogicModelBase.class);

    public PSAppViewNode2ModLogicModelBase() {
        this.setId("E4FFC057-E139-431B-BA72-EDD0CD2A70EE");
        this.setName("Node2Mod");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppView pSAppView = (PSAppView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppView pSAppView = (PSAppView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppView.set("PSAPPMODULEID", pSAppView.get("nodeid"));
    }
}

