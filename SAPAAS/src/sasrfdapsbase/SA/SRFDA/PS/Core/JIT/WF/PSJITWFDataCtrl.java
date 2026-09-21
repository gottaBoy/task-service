/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.psrt.srv.common.service.MsgAccountService
 *  net.ibizsys.psrt.srv.common.service.MsgSendQueueService
 *  net.ibizsys.psrt.srv.common.service.MsgTemplateService
 *  net.ibizsys.psrt.srv.wf.service.WFIAActionService
 *  net.ibizsys.psrt.srv.wf.service.WFInstanceService
 *  net.ibizsys.psrt.srv.wf.service.WFStepActorService
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 *  net.ibizsys.psrt.srv.wf.service.WFStepInstService
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService
 *  net.ibizsys.psrt.srv.wf.service.WFUserService
 *  net.ibizsys.psrt.srv.wf.service.WFWorkListService
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.WFDataCtrl
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFModel;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.service.WFStepInstService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.WFDataCtrl;
import org.hibernate.SessionFactory;

public class PSJITWFDataCtrl
extends WFDataCtrl {
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSJITWFModel iPSJITWFModel = null;

    public void init(IPSJITSystemModel iPSJITSystemModel, IPSJITWFModel iPSJITWFModel) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSJITWFModel = iPSJITWFModel;
    }

    public void init(IWFModel iWFModel) throws Exception {
        SessionFactory sessionFactory = this.iPSJITSystemModel.getSessionFactory();
        this.wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, (SessionFactory)sessionFactory);
        this.wfStepDataService = (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class, (SessionFactory)sessionFactory);
        this.wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class, (SessionFactory)sessionFactory);
        this.wfStepActorService = (WFStepActorService)ServiceGlobal.getService(WFStepActorService.class, (SessionFactory)sessionFactory);
        this.wfIAActionService = (WFIAActionService)ServiceGlobal.getService(WFIAActionService.class, (SessionFactory)sessionFactory);
        this.wfWorkListService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class, (SessionFactory)sessionFactory);
        this.wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, (SessionFactory)sessionFactory);
        this.wfTmpStepActorService = (WFTmpStepActorService)ServiceGlobal.getService(WFTmpStepActorService.class, (SessionFactory)sessionFactory);
        this.msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class, (SessionFactory)sessionFactory);
        this.msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class, (SessionFactory)sessionFactory);
        this.msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class, (SessionFactory)sessionFactory);
        this.wfStepInstService = (WFStepInstService)ServiceGlobal.getService(WFStepInstService.class, (SessionFactory)sessionFactory);
        this.iWFModel = this.iPSJITWFModel;
        this.prepareRTEnv();
    }
}

