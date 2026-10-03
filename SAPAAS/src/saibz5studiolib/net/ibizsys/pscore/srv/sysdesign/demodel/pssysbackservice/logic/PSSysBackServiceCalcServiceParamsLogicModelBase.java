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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysbackservice.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.entity.PSBackService;
import net.ibizsys.pscore.srv.config.service.PSBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysBackService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBackServiceCalcServiceParamsLogicModelBase
extends DELogicModelBase<PSSysBackService> {
    private static final Log log = LogFactory.getLog(PSSysBackServiceCalcServiceParamsLogicModelBase.class);

    public PSSysBackServiceCalcServiceParamsLogicModelBase() {
        this.setId("6857BED0-F5F0-4A5A-B15B-251642ADEDCD");
        this.setName("CalcServiceParams");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("PSBackService", (Object)new PSBackService());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSysBackService pSSysBackService = (PSSysBackService)iActionContext.getParam("Default");
        PSBackService pSBackService = (PSBackService)iActionContext.getParam("PSBackService");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSysBackService pSSysBackService = (PSSysBackService)iActionContext.getParam("Default");
        PSBackService pSBackService = (PSBackService)iActionContext.getParam("PSBackService");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSBackService.set("PSBACKSERVICEID", pSSysBackService.get("PSBACKSERVICEID"));
        if (PSSysBackServiceCalcServiceParamsLogicModelBase.testCond((Object)pSBackService.get("PSBACKSERVICEID"), (String)"EQ", (Object)"") || PSSysBackServiceCalcServiceParamsLogicModelBase.testCond((Object)pSBackService.get("PSBACKSERVICEID"), (String)"ISNULL", (Object)"")) {
            this.executePrepareparam2(iActionContext);
        }
        if (PSSysBackServiceCalcServiceParamsLogicModelBase.testCond((Object)pSBackService.get("PSBACKSERVICEID"), (String)"NOTEQ", (Object)"") && PSSysBackServiceCalcServiceParamsLogicModelBase.testCond((Object)pSBackService.get("PSBACKSERVICEID"), (String)"ISNOTNULL", (Object)"")) {
            this.executeDeaction1(iActionContext);
        }
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSSysBackService pSSysBackService = (PSSysBackService)iActionContext.getParam("Default");
        PSBackService pSBackService = (PSBackService)iActionContext.getParam("PSBackService");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysBackService.set("SERVICEPARAMS", pSBackService.get("SERVICEPARAMS"));
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        PSSysBackService pSSysBackService = (PSSysBackService)iActionContext.getParam("Default");
        PSBackService pSBackService = (PSBackService)iActionContext.getParam("PSBackService");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSBackServiceService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", pSBackService);
        this.executePrepareparam2(iActionContext);
    }
}

