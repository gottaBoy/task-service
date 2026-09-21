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
package net.ibizsys.pscore.srv.appdesign.demodel.psapplocalde.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppLocalDEInitLogicModelBase
extends DELogicModelBase<PSAppLocalDE> {
    private static final Log log = LogFactory.getLog(PSAppLocalDEInitLogicModelBase.class);

    public PSAppLocalDEInitLogicModelBase() {
        this.setId("776C9F28-D62D-45CA-9148-C59F6CD143FA");
        this.setName("Init");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("LocalDE", (Object)new PSDataEntity());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("LocalDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSAppLocalDEInitLogicModelBase.testCond((Object)pSAppLocalDE.get("PSDENAME"), (String)"ISNOTNULL", (Object)"") && PSAppLocalDEInitLogicModelBase.testCond((Object)pSAppLocalDE.get("PSDENAME"), (String)"NOTEQ", (Object)"")) {
            this.executePrepareparam1(iActionContext);
        }
        this.executePrepareparam2(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("LocalDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDataEntity.set("PSDATAENTITYID", pSAppLocalDE.get("PSDEID"));
        this.executegetDataEntity(iActionContext);
    }

    protected void executesetPSDEName(IActionContext iActionContext) throws Exception {
        PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("LocalDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppLocalDE.set("PSDENAME", pSDataEntity.get("PSDATAENTITYNAME"));
        this.executePrepareparam1(iActionContext);
    }

    protected void executegetDataEntity(IActionContext iActionContext) throws Exception {
        PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("LocalDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", (IEntity)pSDataEntity);
        this.executesetPSDEName(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("LocalDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSAppLocalDE.set("PSAPPLOCALDENAME", pSAppLocalDE.get("PSDENAME"));
    }
}

