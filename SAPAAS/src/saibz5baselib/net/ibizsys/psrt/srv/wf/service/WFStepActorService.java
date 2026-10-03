package net.ibizsys.psrt.srv.wf.service;


import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 工作流步骤操作者 服务操作对象
 * 
 */
public  class WFStepActorService extends WFStepActorServiceBase{

  private static final Log log = LogFactory.getLog(WFStepActorService.class);
   public WFStepActorService (){
        super();
        
   }

   @Override
	protected void onRemindSave(WFStepActor wfStepActor) throws Exception
	{
	   String strRemindMemo = DataObject.getStringValue(wfStepActor, "remindmemo", ""); 
	   
	   //催办保存
	   this.get(wfStepActor);
	   
	   if(DataObject.getBoolValue(wfStepActor, WFStepActor.FIELD_ISFINISH, false))
	   {
		   throw new Exception(StringHelper.format("当前用户工作已经完成, 无需催办"));
	   }
	  
	   int nRemindCount = 1;
	   if(wfStepActor.getReminderCount()!=null)
	   {
		   nRemindCount = (wfStepActor.getReminderCount()+1);
	   }
	   
	   
	   WFUser wfUser = new WFUser();
	   WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class,getSessionFactory());
	   wfUser.setWFUserId( this.getWebContext().getCurUserId());
	   wfUserService.get(wfUser);
	   
	   WFReminderService wfReminderService = (WFReminderService)ServiceGlobal.getService(WFReminderService.class,getSessionFactory());
	   //建立备注
	   WFReminder wfReminder = new WFReminder();
	   wfReminder.setWFReminderName(StringHelper.format("[%1$s]发起流程催办",wfUser.getWFUserName()));
	   wfReminder.setWFStepActorId(wfStepActor.getWFStepActorId());
	   wfReminder.setWFStepActorName(wfStepActor.getWFStepActorName());
	   wfReminder.setActorId(wfStepActor.getActorId());
	   wfReminder.setWFUserId(wfUser.getWFUserId());
	   wfReminder.setWFUserName(wfUser.getWFUserName());
	   wfReminder.setMemo(strRemindMemo);
	   wfReminder.setReminderTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
	   wfReminderService.create(wfReminder, false);
	   
	   wfStepActor.reset();
	   wfStepActor.setWFStepActorId(wfReminder.getWFStepActorId());
	   wfStepActor.setReminderCount(nRemindCount);
	   
	   this.update(wfStepActor);
	}
}