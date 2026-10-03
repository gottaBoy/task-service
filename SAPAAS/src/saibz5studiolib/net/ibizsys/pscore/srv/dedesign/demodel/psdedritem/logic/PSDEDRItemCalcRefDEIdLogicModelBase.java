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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedritem.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDRItemCalcRefDEIdLogicModelBase
extends DELogicModelBase<PSDEDRItem> {
    private static final Log log = LogFactory.getLog(PSDEDRItemCalcRefDEIdLogicModelBase.class);

    public PSDEDRItemCalcRefDEIdLogicModelBase() {
        this.setId("46B15D37-38ED-47C1-A2E0-AFC642339BDD");
        this.setName("CalcRefDEId");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("DER", (Object)new PSDER());
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEDRItem pSDEDRItem = (PSDEDRItem)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executeSetDER(iActionContext);
    }

    protected void executeSetDER(IActionContext iActionContext) throws Exception {
        PSDEDRItem pSDEDRItem = (PSDEDRItem)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDER.set("psderid", pSDEDRItem.get("psderid"));
        if (PSDEDRItemCalcRefDEIdLogicModelBase.testCond((Object)pSDER.get("psderid"), (String)"ISNOTNULL", (Object)"") && PSDEDRItemCalcRefDEIdLogicModelBase.testCond((Object)pSDER.get("psderid"), (String)"NOTEQ", (Object)"")) {
            this.executeGetDER(iActionContext);
            return;
        }
        this.executeSetViewDEId(iActionContext);
    }

    protected void executeGetDER(IActionContext iActionContext) throws Exception {
        PSDEDRItem pSDEDRItem = (PSDEDRItem)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService iService = ServiceGlobal.getService(PSDERService.class, (SessionFactory)sessionFactory);
        iService.executeAction("GET", pSDER);
        this.executeSetViewDEId(iActionContext);
    }

    protected void executeSetViewDEId(IActionContext iActionContext) throws Exception {
        PSDEDRItem pSDEDRItem = (PSDEDRItem)iActionContext.getParam("Default");
        PSDER pSDER = (PSDER)iActionContext.getParam("DER");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEDRItem.set("VIEWPSDEID", pSDER.get("MINORPSDEID"));
    }
}

