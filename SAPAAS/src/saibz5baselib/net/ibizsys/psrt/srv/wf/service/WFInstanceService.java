package net.ibizsys.psrt.srv.wf.service;


import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFModelGlobal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 工作流实例 服务操作对象
 * 
 */
public  class WFInstanceService extends WFInstanceServiceBase{

  private static final Log log = LogFactory.getLog(WFInstanceService.class);
   public WFInstanceService (){
        super();
        
   }
   
   @Override
	protected void onRestart(WFInstance wFInstance) throws Exception
	{
	   if(!wFInstance.isFullEntity())
		   this.get(wFInstance);
	   	IWFModel iWFModel = WFModelGlobal.getWFModel(wFInstance.getWFWorkflowId());
		IWFService iWFService = iWFModel.getWFService();
		WFActionParam wfActionParam = new WFActionParam();
		wfActionParam.setUserData(wFInstance.getUserData());
		wfActionParam.setUserData4(wFInstance.getUserData4());
		wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
		iWFService.restart(wfActionParam);
	}
   
   
   @Override
	protected void onUserCancel(WFInstance wFInstance) throws Exception
	{
	   if(!wFInstance.isFullEntity())
		   this.get(wFInstance);
	   IWFModel iWFModel = WFModelGlobal.getWFModel(wFInstance.getWFWorkflowId());
		IWFService iWFService = iWFModel.getWFService();
		WFActionParam wfActionParam = new WFActionParam();
		wfActionParam.setUserData(wFInstance.getUserData());
		wfActionParam.setUserData4(wFInstance.getUserData4());
		wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
		iWFService.close(wfActionParam);
	}

}