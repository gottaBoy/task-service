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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocess.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcessCalcEmbedDEIdByEmbedWFDELogicModelBase
extends DELogicModelBase<PSWFProcess> {
    private static final Log log = LogFactory.getLog(PSWFProcessCalcEmbedDEIdByEmbedWFDELogicModelBase.class);

    public PSWFProcessCalcEmbedDEIdByEmbedWFDELogicModelBase() {
        this.setId("06DED7C8-6E7C-4B3C-91A3-A85E815642FF");
        this.setName("CalcEmbedDEIdByEmbedWFDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("WFDE", (Object)new PSWFDE());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSWFProcess pSWFProcess = (PSWFProcess)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareParams(iActionContext);
    }

    protected void executePrepareParams(IActionContext iActionContext) throws Exception {
        PSWFProcess pSWFProcess = (PSWFProcess)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFDE.set("PSWFDEID", pSWFProcess.get("EMBEDPSWFDEID"));
        this.executeGetPSWFDE(iActionContext);
    }

    protected void executeGetPSWFDE(IActionContext iActionContext) throws Exception {
        PSWFProcess pSWFProcess = (PSWFProcess)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", pSWFDE);
        this.executeFillParam(iActionContext);
    }

    protected void executeFillParam(IActionContext iActionContext) throws Exception {
        PSWFProcess pSWFProcess = (PSWFProcess)iActionContext.getParam("Default");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("WFDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFProcess.set("EMBEDPSDEID", pSWFDE.get("PSDEID"));
    }
}

