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
package net.ibizsys.pscore.srv.appdesign.demodel.psappportalview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPortalViewParent2AppLogicModelBase
extends DELogicModelBase<PSAppPortalView> {
    private static final Log log = LogFactory.getLog(PSAppPortalViewParent2AppLogicModelBase.class);

    public PSAppPortalViewParent2AppLogicModelBase() {
        this.setId("B12C9F22-5A81-43BF-9797-6DDCA709BCA7");
        this.setName("Parent2App");
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
        pSAppPortalView.set("PSSYSAPPID", WebContext.getCurrent().getPostValue("srfparentkey"));
    }
}

