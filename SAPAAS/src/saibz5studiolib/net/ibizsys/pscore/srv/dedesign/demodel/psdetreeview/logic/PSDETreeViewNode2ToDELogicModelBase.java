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
package net.ibizsys.pscore.srv.dedesign.demodel.psdetreeview.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeViewNode2ToDELogicModelBase
extends DELogicModelBase<PSDETreeView> {
    private static final Log log = LogFactory.getLog(PSDETreeViewNode2ToDELogicModelBase.class);

    public PSDETreeViewNode2ToDELogicModelBase() {
        this.setId("40421FA8-A050-46C8-8F9F-0C6875F2759F");
        this.setName("Node2ToDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDETreeView pSDETreeView = (PSDETreeView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDETreeView pSDETreeView = (PSDETreeView)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDETreeView.set("PSDEID", pSDETreeView.get("nodeid2"));
    }
}

