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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedsdq.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSDQFillMajorInfoLogicModelBase
extends DELogicModelBase<PSDEDSDQ> {
    private static final Log log = LogFactory.getLog(PSDEDSDQFillMajorInfoLogicModelBase.class);

    public PSDEDSDQFillMajorInfoLogicModelBase() {
        this.setId("352D9A77-AE66-4992-8490-48D6FE7C608C");
        this.setName("FillMajorInfo");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEDSDQ pSDEDSDQ = (PSDEDSDQ)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEDSDQ pSDEDSDQ = (PSDEDSDQ)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEDSDQ.set("psdedsdqname", pSDEDSDQ.get("psdedqname"));
    }
}

