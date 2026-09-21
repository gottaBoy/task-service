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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewBaseNode2WFVerLogicModelBase
extends DELogicModelBase<PSDEViewBase> {
    private static final Log log = LogFactory.getLog(PSDEViewBaseNode2WFVerLogicModelBase.class);

    public PSDEViewBaseNode2WFVerLogicModelBase() {
        this.setId("1A091D4D-4BC4-4C99-B866-DE9B0F679ABE");
        this.setName("Node2WFVer");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEViewBase pSDEViewBase = (PSDEViewBase)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEViewBase pSDEViewBase = (PSDEViewBase)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEViewBase.set("PSWFVERSIONID", pSDEViewBase.get("nodeid"));
    }
}

