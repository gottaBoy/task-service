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
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvaluerule.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFValueRuleL1LogicModelBase
extends DELogicModelBase<PSDEFValueRule> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleL1LogicModelBase.class);

    public PSDEFValueRuleL1LogicModelBase() {
        this.setId("4358AB27-6CFD-4D44-8960-5B0748B90275");
        this.setName("L1");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSDEFValueRuleL1LogicModelBase.testCond((Object)pSDEFValueRule.get("DEFAULTMODE"), (String)"EQ", (Object)"1")) {
            this.executePrepareparam1(iActionContext);
        }
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEFValueRule.set("CHECKDEFAULT", "1");
    }
}

