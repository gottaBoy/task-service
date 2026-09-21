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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormDetailCalcRefPSDEFormIdLogicModelBase
extends DELogicModelBase<PSDEFormDetail> {
    private static final Log log = LogFactory.getLog(PSDEFormDetailCalcRefPSDEFormIdLogicModelBase.class);

    public PSDEFormDetailCalcRefPSDEFormIdLogicModelBase() {
        this.setId("1C6DF76E-EF43-45D1-A070-44925EFF5FC2");
        this.setName("CalcRefPSDEFormId");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("PSDEFORMRF", (Object)new PSDEFormRF());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iActionContext.getParam("Default");
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("PSDEFORMRF");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareParams(iActionContext);
    }

    protected void executePrepareParams(IActionContext iActionContext) throws Exception {
        PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iActionContext.getParam("Default");
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("PSDEFORMRF");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEFormRF.set("PSDEFORMRFID", pSDEFormDetail.get("PSDEFORMRFID"));
        this.executeGetPSDEFormRF(iActionContext);
    }

    protected void executeGetPSDEFormRF(IActionContext iActionContext) throws Exception {
        PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iActionContext.getParam("Default");
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("PSDEFORMRF");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GETTEMP", (IEntity)pSDEFormRF);
        this.executeFillbackDefault(iActionContext);
    }

    protected void executeFillbackDefault(IActionContext iActionContext) throws Exception {
        PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iActionContext.getParam("Default");
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("PSDEFORMRF");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEFormDetail.set("REFPSDEFORMID", pSDEFormRF.get("MINORPSDEFORMID"));
    }
}

