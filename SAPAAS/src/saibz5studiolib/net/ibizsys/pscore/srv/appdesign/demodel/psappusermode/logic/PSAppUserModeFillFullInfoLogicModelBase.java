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
package net.ibizsys.pscore.srv.appdesign.demodel.psappusermode.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUserMode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUserModeFillFullInfoLogicModelBase
extends DELogicModelBase<PSAppUserMode> {
    private static final Log log = LogFactory.getLog(PSAppUserModeFillFullInfoLogicModelBase.class);

    public PSAppUserModeFillFullInfoLogicModelBase() {
        this.setId("0345DFB4-B30A-496E-9EC4-F8CF02C711D2");
        this.setName("FillFullInfo");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppUserMode pSAppUserMode = (PSAppUserMode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppUserMode pSAppUserMode = (PSAppUserMode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSAppUserModeFillFullInfoLogicModelBase.testCond((Object)pSAppUserMode.get("defaultflag"), (String)"EQ", (Object)"1")) {
            this.executePrepareparam2(iActionContext);
            return;
        }
        this.executePrepareparam3(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSAppUserMode pSAppUserMode = (PSAppUserMode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppUserMode.set("PSAPPUSERMODENAME", "\u9ed8\u8ba4");
        pSAppUserMode.set("pssysusermodeid", null);
        pSAppUserMode.set("pssysusermodename", null);
    }

    protected void executePrepareparam3(IActionContext iActionContext) throws Exception {
        PSAppUserMode pSAppUserMode = (PSAppUserMode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppUserMode.set("PSAPPUSERMODENAME", pSAppUserMode.get("pssysusermodename"));
    }
}

