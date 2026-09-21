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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocsubwf.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcSubWFCalcEmbedDEIdByEmbedWFDELogicModelBase
extends DELogicModelBase<PSWFProcSubWF> {
    private static final Log log = LogFactory.getLog(PSWFProcSubWFCalcEmbedDEIdByEmbedWFDELogicModelBase.class);

    public PSWFProcSubWFCalcEmbedDEIdByEmbedWFDELogicModelBase() {
        this.setId("95BDBECF-DF89-4005-BE66-E126FCD26755");
        this.setName("CalcEmbedDEIdByEmbedWFDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("WFDE", (Object)new PSWFDE());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSWFProcSubWF pSWFProcSubWF = (PSWFProcSubWF)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSWFProcSubWF pSWFProcSubWF = (PSWFProcSubWF)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFDE.set("PSWFDEID", pSWFProcSubWF.get("EMBEDPSWFDEID"));
        if (PSWFProcSubWFCalcEmbedDEIdByEmbedWFDELogicModelBase.testCond((Object)pSWFDE.get("PSWFDEID"), (String)"ISNOTNULL", (Object)"") && PSWFProcSubWFCalcEmbedDEIdByEmbedWFDELogicModelBase.testCond((Object)pSWFDE.get("PSWFDEID"), (String)"NOTEQ", (Object)"")) {
            this.executeDeaction1(iActionContext);
        }
        this.executePrepareparam2(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        PSWFProcSubWF pSWFProcSubWF = (PSWFProcSubWF)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", (IEntity)pSWFDE);
        this.executePrepareparam2(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSWFProcSubWF pSWFProcSubWF = (PSWFProcSubWF)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFProcSubWF.set("EMBEDPSDEID", pSWFDE.get("PSDEID"));
    }
}

