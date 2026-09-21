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
package net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppIndexViewNode2ModLogicModelBase
extends DELogicModelBase<PSAppIndexView> {
    private static final Log log = LogFactory.getLog(PSAppIndexViewNode2ModLogicModelBase.class);

    public PSAppIndexViewNode2ModLogicModelBase() {
        this.setId("B1CF703C-36A9-4C76-A12B-87DB6BC347C4");
        this.setName("Node2Mod");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppIndexView pSAppIndexView = (PSAppIndexView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppIndexView pSAppIndexView = (PSAppIndexView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppIndexView.set("PSAPPMODULEID", pSAppIndexView.get("nodeid"));
    }
}

