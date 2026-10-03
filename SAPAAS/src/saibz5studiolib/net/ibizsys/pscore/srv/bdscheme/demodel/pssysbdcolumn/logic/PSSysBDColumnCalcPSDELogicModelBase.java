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
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdcolumn.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDColumnCalcPSDELogicModelBase
extends DELogicModelBase<PSSysBDColumn> {
    private static final Log log = LogFactory.getLog(PSSysBDColumnCalcPSDELogicModelBase.class);

    public PSSysBDColumnCalcPSDELogicModelBase() {
        this.setId("FC77ED68-F64C-46E7-8B44-616A01680C89");
        this.setName("CalcPSDE");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("CurPSSysBDTableDE", (Object)new PSSysBDTableDE());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSysBDColumn pSSysBDColumn = (PSSysBDColumn)iActionContext.getParam("Default");
        PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)iActionContext.getParam("CurPSSysBDTableDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSysBDColumn pSSysBDColumn = (PSSysBDColumn)iActionContext.getParam("Default");
        PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)iActionContext.getParam("CurPSSysBDTableDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysBDTableDE.set("PSSYSBDTABLEDEID", pSSysBDColumn.get("PSSYSBDTABLEDEID"));
        if (PSSysBDColumnCalcPSDELogicModelBase.testCond((Object)pSSysBDTableDE.get("PSSysBDTableDEid"), (String)"ISNULL", (Object)"")) {
            this.executePrepareparam2(iActionContext);
        }
        if (PSSysBDColumnCalcPSDELogicModelBase.testCond((Object)pSSysBDColumn.get("pssysbdtabledeid"), (String)"ISNOTNULL", (Object)"")) {
            this.executeDeaction1(iActionContext);
        }
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        PSSysBDColumn pSSysBDColumn = (PSSysBDColumn)iActionContext.getParam("Default");
        PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)iActionContext.getParam("CurPSSysBDTableDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", pSSysBDTableDE);
        this.executePrepareparam2(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSSysBDColumn pSSysBDColumn = (PSSysBDColumn)iActionContext.getParam("Default");
        PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)iActionContext.getParam("CurPSSysBDTableDE");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSysBDColumn.set("PSDEID", pSSysBDTableDE.get("PSDEID"));
        pSSysBDColumn.set("PSDENAME", pSSysBDTableDE.get("PSDENAME"));
    }
}

