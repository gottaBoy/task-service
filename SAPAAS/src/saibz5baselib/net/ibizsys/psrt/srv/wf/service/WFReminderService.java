package net.ibizsys.psrt.srv.wf.service;


import java.util.ArrayList;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 工作流工作催办 服务操作对象
 * 
 */
public  class WFReminderService extends WFReminderServiceBase{

  private static final Log log = LogFactory.getLog(WFReminderService.class);
   public WFReminderService (){
        super();
        
   }
   
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServiceBase#onAfterCreate(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	protected void onAfterCreate(WFReminder et) throws Exception
	{
		sendInform(et);
		super.onAfterCreate(et);
	}
	
	
	/**
	 * 发送催办
	 * @param et
	 */
	protected void sendInform(WFReminder et) throws Exception
	{
		
		String strWFInstanceId = "";
		if(et.getWFStepActor()!=null)
		{
			strWFInstanceId = et.getWFStepActor().getWFInstanceId();
		}
		
		if(StringHelper.isNullOrEmpty(strWFInstanceId))
			return;
		
		WFInstance wfInstance = new WFInstance();
		WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class,this.getSessionFactory());
		wfInstance.setWFInstanceId(strWFInstanceId);
		wfInstanceService.get(wfInstance);
		
		WFWorkflowService wfWorkflowService = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class,this.getSessionFactory());
		WFWorkflow wfWorkflow = new WFWorkflow();
		wfWorkflow.setWFWorkflowId(wfInstance.getWFWorkflowId());
		wfWorkflowService.get(wfWorkflow);
		
		if(StringHelper.isNullOrEmpty(wfWorkflow.getRemindMsgTemplId()))
			return;
		
		
		MsgTemplateService msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class,this.getSessionFactory());
		MsgAccountService msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class,this.getSessionFactory());
		MsgSendQueueService msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class,this.getSessionFactory());
		
//		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
//		IService iService = iDEModel.getService();
//
//		IEntity dataEntity = iDEModel.createEntity();
//		dataEntity.set(iDEModel.getKeyDEField().getName(), iWFActionContext.getActiveWFInstance().getUserData());
//		iService.get(dataEntity);

		MsgTemplate msgTemplate = new MsgTemplate();
		msgTemplate.setMsgTemplateId(wfWorkflow.getRemindMsgTemplId());
		if (!msgTemplateService.get(msgTemplate, true))
		{
			throw new Exception(StringHelper.format("获取指定消息模板[%1$s]失败", wfWorkflow.getRemindMsgTemplId()));
		}

		boolean bMailGroupSend = DataObject.getBoolValue(msgTemplate.getMailGroupSend(), false);
		String strMailAddress = "";

		ArrayList<MsgSendQueue> msqs = new ArrayList<MsgSendQueue>();
		MsgAccount msgAccount = new MsgAccount();
		String strActorId = et.getWFStepActor().getActorId();
		
		msgAccount.setMsgAccountId(strActorId);
		if (!msgAccountService.get(msgAccount, true))
		{
			throw new Exception(StringHelper.format("获取消息账户[%1$s]失败", strActorId));
		}

		//邮件
		if (true)
		{
			MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.EMAIL, msgTemplate, et, null, msgAccount, "SYSTEM");
			msq.setDstAddresses(msgAccount.getMailAddress());
			msqs.add(msq);
		}

		//短消息
		if (true)
		{
			MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.SMS, msgTemplate, et, null, msgAccount, "SYSTEM");
			msq.setDstAddresses(msgAccount.getMobile());
			msqs.add(msq);
		}
		
		for (MsgSendQueue msq : msqs)
		{
			try
			{
				msgSendQueueService.create(msq, false);
			}
			catch (Exception ex)
			{
				log.error(StringHelper.format("保存消息异步队列数据失败，%1$s", ex.getMessage()));
				continue;
			}
		}
	}

   
  
}