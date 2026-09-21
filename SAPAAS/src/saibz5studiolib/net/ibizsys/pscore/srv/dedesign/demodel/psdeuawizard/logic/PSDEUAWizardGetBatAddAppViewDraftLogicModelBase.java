/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAWizardGetBatAddAppViewDraftLogicModelBase
extends DELogicModelBase<PSDEUAWizard> {
    private static final Log log = LogFactory.getLog(PSDEUAWizardGetBatAddAppViewDraftLogicModelBase.class);

    public PSDEUAWizardGetBatAddAppViewDraftLogicModelBase() {
        this.setId("25906320-B9C6-4F5F-A6E7-3F0605989C38");
        this.setName("GetBatAddAppViewDraft");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("CurDataEntity", (Object)new PSDataEntity());
        iActionContext.setParam("CurWFDE", (Object)new PSWFDE());
        iActionContext.setParam("Temp", (Object)new SimpleEntity());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareParam(iActionContext);
    }

    protected void executePrepareParam(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        simpleEntity.set("PSSYSTEMID", (Object)WebContext.getCurrent().getAppDataValue("pssystemid"));
        pSDataEntity.set("PSDATAENTITYID", WebContext.getCurrent().getPostValue("srfparentkey"));
        simpleEntity.set("SRFPARENTKEY", (Object)WebContext.getCurrent().getPostValue("srfparentkey"));
        simpleEntity.set("SRFPARENTTYPE", (Object)WebContext.getCurrent().getPostValue("srfparenttype"));
        simpleEntity.set("SRFDER1NID", (Object)WebContext.getCurrent().getPostValue("srfder1nid"));
        if (PSDEUAWizardGetBatAddAppViewDraftLogicModelBase.testCond((Object)simpleEntity.get("PSSYSTEMID"), (String)"ISNOTNULL", (Object)"") && PSDEUAWizardGetBatAddAppViewDraftLogicModelBase.testCond((Object)simpleEntity.get("PSSYSTEMID"), (String)"NOTEQ", (Object)"")) {
            this.executePrepareparam5(iActionContext);
            return;
        }
        if (PSDEUAWizardGetBatAddAppViewDraftLogicModelBase.testCond((Object)simpleEntity.get("SRFDER1NID"), (String)"EQ", (Object)"DER1N_PSDEVIEWBASE_PSSYSTEM_PSSYSTEMID")) {
            this.executePrepareParam3(iActionContext);
            return;
        }
        if (PSDEUAWizardGetBatAddAppViewDraftLogicModelBase.testCond((Object)simpleEntity.get("SRFDER1NID"), (String)"EQ", (Object)"DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID")) {
            this.executePrepareparam1(iActionContext);
            return;
        }
        this.executeGetPSDataEntity(iActionContext);
    }

    protected void executePrepareparam5(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEUAWizard.set("PSSYSTEMID", simpleEntity.get("PSSYSTEMID"));
    }

    protected void executeGetPSDataEntity(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", (IEntity)pSDataEntity);
        this.executePrepareParam2(iActionContext);
    }

    protected void executePrepareParam3(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEUAWizard.set("PSSYSTEMID", WebContext.getCurrent().getPostValue("srfparentkey"));
    }

    protected void executePrepareparam4(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDataEntity.set("PSDATAENTITYID", pSWFDE.get("PSDEID"));
        this.executeGetPSDataEntity(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSWFDE.set("PSWFDEID", simpleEntity.get("SRFPARENTKEY"));
        this.executeDeaction1(iActionContext);
    }

    protected void executePrepareParam2(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEUAWizard.set("PSSYSTEMID", pSDataEntity.get("PSSYSTEMID"));
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        PSDEUAWizard pSDEUAWizard = (PSDEUAWizard)iActionContext.getParam("Default");
        PSDataEntity pSDataEntity = (PSDataEntity)iActionContext.getParam("CurDataEntity");
        PSWFDE pSWFDE = (PSWFDE)iActionContext.getParam("CurWFDE");
        SimpleEntity simpleEntity = (SimpleEntity)iActionContext.getParam("Temp");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", (IEntity)pSWFDE);
        this.executePrepareparam4(iActionContext);
    }
}

