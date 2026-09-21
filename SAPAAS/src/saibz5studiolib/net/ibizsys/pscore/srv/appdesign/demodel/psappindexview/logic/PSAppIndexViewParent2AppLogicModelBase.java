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
package net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppIndexViewParent2AppLogicModelBase
extends DELogicModelBase<PSAppIndexView> {
    private static final Log log = LogFactory.getLog(PSAppIndexViewParent2AppLogicModelBase.class);

    public PSAppIndexViewParent2AppLogicModelBase() {
        this.setId("72933D0E-18DE-4D54-B7F0-74A68E2DD2E4");
        this.setName("Parent2App");
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
        pSAppIndexView.set("PSSYSAPPID", WebContext.getCurrent().getPostValue("srfparentkey"));
    }
}

