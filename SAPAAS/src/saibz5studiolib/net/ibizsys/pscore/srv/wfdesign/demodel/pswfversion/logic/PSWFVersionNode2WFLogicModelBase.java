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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfversion.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFVersionNode2WFLogicModelBase
extends DELogicModelBase<PSWFVersion> {
    private static final Log log = LogFactory.getLog(PSWFVersionNode2WFLogicModelBase.class);

    public PSWFVersionNode2WFLogicModelBase() {
        this.setId("0695ABCD-0506-4E53-B8E6-17DEC442485B");
        this.setName("Node2WF");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSWFVersion pSWFVersion = (PSWFVersion)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSWFVersion pSWFVersion = (PSWFVersion)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFVersion.set("PSWFID", pSWFVersion.get("nodeid"));
    }
}

