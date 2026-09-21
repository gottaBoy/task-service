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
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpsection.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionL2LogicModelBase
extends DELogicModelBase<PSHelpSection> {
    private static final Log log = LogFactory.getLog(PSHelpSectionL2LogicModelBase.class);

    public PSHelpSectionL2LogicModelBase() {
        this.setId("566FF716-335C-4B49-8FF0-9139DAE80F4C");
        this.setName("L2");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSHelpSection pSHelpSection = (PSHelpSection)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSHelpSection pSHelpSection = (PSHelpSection)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSHelpSection.set("PPSHELPSECTIONID", pSHelpSection.get("nodeid"));
    }
}

