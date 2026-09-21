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
package net.ibizsys.pscore.srv.dedesign.demodel.psdemsaction.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMSActionFillMajorFieldLogicModelBase
extends DELogicModelBase<PSDEMSAction> {
    private static final Log log = LogFactory.getLog(PSDEMSActionFillMajorFieldLogicModelBase.class);

    public PSDEMSActionFillMajorFieldLogicModelBase() {
        this.setId("0746B1E8-C40C-488B-B860-2C6E9F1804DB");
        this.setName("FillMajorField");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEMSAction pSDEMSAction = (PSDEMSAction)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSDEMSActionFillMajorFieldLogicModelBase.testCond((Object)pSDEMSAction.get("PSDEACTIONNAME"), (String)"ISNOTNULL", (Object)"") && PSDEMSActionFillMajorFieldLogicModelBase.testCond((Object)pSDEMSAction.get("PSDEACTIONNAME"), (String)"NOTEQ", (Object)"")) {
            this.executePrepareparam1(iActionContext);
        }
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEMSAction pSDEMSAction = (PSDEMSAction)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEMSAction.set("PSDEMSACTIONNAME", pSDEMSAction.get("PSDEACTIONNAME"));
    }
}

