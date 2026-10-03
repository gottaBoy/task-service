package net.ibizsys.ssdynawf.core;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
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

/**
 * JIT 流程数据访问对象
 * 
 * @author Administrator
 *
 */
public class DynaWFDataCtrl extends WFDataCtrl {

	private IDynaSysModel iDynaSysModel = null;
	private IDynaWFModel iDynaWFModel = null;

	public void init(IDynaSysModel iDynaSysModel, IDynaWFModel iDynaWFModel) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
		this.iDynaWFModel = iDynaWFModel;

	}

	@Override
	public void init(IWFModel iWFModel) throws Exception {
		SessionFactory sessionFactory = this.iDynaSysModel.getSessionFactory();

		wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, sessionFactory);
		wfStepDataService = (WFStepDataService) ServiceGlobal.getService(WFStepDataService.class, sessionFactory);
		wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class, sessionFactory);
		wfStepActorService = (WFStepActorService) ServiceGlobal.getService(WFStepActorService.class, sessionFactory);
		wfIAActionService = (WFIAActionService) ServiceGlobal.getService(WFIAActionService.class, sessionFactory);
		wfWorkListService = (WFWorkListService) ServiceGlobal.getService(WFWorkListService.class, sessionFactory);
		wfUserService = (WFUserService) ServiceGlobal.getService(WFUserService.class, sessionFactory);
		wfTmpStepActorService = (WFTmpStepActorService) ServiceGlobal.getService(WFTmpStepActorService.class, sessionFactory);
		msgTemplateService = (MsgTemplateService) ServiceGlobal.getService(MsgTemplateService.class, sessionFactory);
		msgAccountService = (MsgAccountService) ServiceGlobal.getService(MsgAccountService.class, sessionFactory);
		msgSendQueueService = (MsgSendQueueService) ServiceGlobal.getService(MsgSendQueueService.class, sessionFactory);
		wfStepInstService = (WFStepInstService) ServiceGlobal.getService(WFStepInstService.class, sessionFactory);

		this.iWFModel = iDynaWFModel;
		this.prepareRTEnv();
	}

}
