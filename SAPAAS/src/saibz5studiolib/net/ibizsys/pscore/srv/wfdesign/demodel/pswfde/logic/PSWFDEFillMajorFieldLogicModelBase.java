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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfde.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFDEFillMajorFieldLogicModelBase
extends DELogicModelBase<PSWFDE> {
    private static final Log log = LogFactory.getLog(PSWFDEFillMajorFieldLogicModelBase.class);

    public PSWFDEFillMajorFieldLogicModelBase() {
        this.setId("991E3BF6-1DC0-47E3-9770-E2542BB3D2F2");
        this.setName("FillMajorField");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFDE.set("pswfdename", pSWFDE.get("psdename"));
    }
}

