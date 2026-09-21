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
package net.ibizsys.pscore.srv.dedesign.demodel.psdellcond.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELLCondCalcDstParamPSDEIdLogicModelBase
extends DELogicModelBase<PSDELLCond> {
    private static final Log log = LogFactory.getLog(PSDELLCondCalcDstParamPSDEIdLogicModelBase.class);

    public PSDELLCondCalcDstParamPSDEIdLogicModelBase() {
        this.setId("2FBF98D5-0DFA-4FB8-A784-A67E5E637F56");
        this.setName("CalcDstParamPSDEId");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("DELogicParam", (Object)new PSDELogicParam());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDELLCond pSDELLCond = (PSDELLCond)iActionContext.getParam("Default");
        PSDELogicParam pSDELogicParam = (PSDELogicParam)iActionContext.getParam("DELogicParam");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareDELogicParam(iActionContext);
    }

    protected void executeGetPSDELogicParam(IActionContext iActionContext) throws Exception {
        PSDELLCond pSDELLCond = (PSDELLCond)iActionContext.getParam("Default");
        PSDELogicParam pSDELogicParam = (PSDELogicParam)iActionContext.getParam("DELogicParam");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GETTEMP", (IEntity)pSDELogicParam);
        this.executeFillDefaultParam(iActionContext);
    }

    protected void executePrepareDELogicParam(IActionContext iActionContext) throws Exception {
        PSDELLCond pSDELLCond = (PSDELLCond)iActionContext.getParam("Default");
        PSDELogicParam pSDELogicParam = (PSDELogicParam)iActionContext.getParam("DELogicParam");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDELogicParam.set("PSDELOGICPARAMID", pSDELLCond.get("DSTPSDLPARAMID"));
        if (PSDELLCondCalcDstParamPSDEIdLogicModelBase.testCond((Object)pSDELogicParam.get("psdelogicparamid"), (String)"EQ", (Object)"") || PSDELLCondCalcDstParamPSDEIdLogicModelBase.testCond((Object)pSDELogicParam.get("psdelogicparamid"), (String)"ISNULL", (Object)"")) {
            this.executeFillDefaultParam(iActionContext);
        }
        this.executeGetPSDELogicParam(iActionContext);
    }

    protected void executeFillDefaultParam(IActionContext iActionContext) throws Exception {
        PSDELLCond pSDELLCond = (PSDELLCond)iActionContext.getParam("Default");
        PSDELogicParam pSDELogicParam = (PSDELogicParam)iActionContext.getParam("DELogicParam");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDELLCond.set("DSTPARAMPSDEID", pSDELogicParam.get("PARAMPSDEID"));
    }
}

