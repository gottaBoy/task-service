/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeoppriv.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEOPPrivCalcMapDERMajorDEIdLogicModelBase
extends DELogicModelBase<PSDEOPPriv> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivCalcMapDERMajorDEIdLogicModelBase.class);

    public PSDEOPPrivCalcMapDERMajorDEIdLogicModelBase() {
        this.setId("E3CB157B-EEAF-4D3F-8579-7F2968352403");
        this.setName("CalcMapDERMajorDEId");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("DER", (Object)new PSDER());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDER.set("PSDERID", pSDEOPPriv.get("PSDERID"));
        if (PSDEOPPrivCalcMapDERMajorDEIdLogicModelBase.testCond((Object)pSDER.get("PSDERID"), (String)"NOTEQ", (Object)"") && PSDEOPPrivCalcMapDERMajorDEIdLogicModelBase.testCond((Object)pSDER.get("PSDERID"), (String)"ISNOTNULL", (Object)"")) {
            this.executeDeaction1(iActionContext);
        }
        this.executePrepareparam2(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDERService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", pSDER);
        this.executePrepareparam2(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEOPPriv.set("MAJORPSDEID", pSDER.get("MAJORPSDEID"));
    }
}

