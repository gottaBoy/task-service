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
package net.ibizsys.pscore.srv.dedesign.demodel.psdetoolbar.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEToolbarNode2ToDELogicModelBase
extends DELogicModelBase<PSDEToolbar> {
    private static final Log log = LogFactory.getLog(PSDEToolbarNode2ToDELogicModelBase.class);

    public PSDEToolbarNode2ToDELogicModelBase() {
        this.setId("F78C2DA0-8FD7-4AF4-875B-46B2F09C4C1E");
        this.setName("Node2ToDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEToolbar pSDEToolbar = (PSDEToolbar)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEToolbar pSDEToolbar = (PSDEToolbar)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEToolbar.set("PSDEID", pSDEToolbar.get("nodeid2"));
    }
}

