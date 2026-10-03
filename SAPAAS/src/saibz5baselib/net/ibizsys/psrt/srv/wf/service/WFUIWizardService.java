package net.ibizsys.psrt.srv.wf.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFUIWizard;
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
 * 工作流操作界面 服务操作对象
 * 
 */
public class WFUIWizardService extends WFUIWizardServiceBase
{

	public static String ACTIONMODE_GOTOSTEP = "GOTOSTEP";

	private static final Log log = LogFactory.getLog(WFUIWizardService.class);

	public WFUIWizardService()
	{
		super();

	}

	@Override
	public void getDraft(WFUIWizard et) throws Exception
	{
		if (StringHelper.compare(et.getActionMode(), ACTIONMODE_GOTOSTEP, true) == 0)
		{
			// 获取数据
			String strActoinParams = et.getActionParam();
			String[] keys = strActoinParams.split("[;]");
			String strActionData = "";
			WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
			for (String strKey : keys)
			{
				WFInstance wfInstance = new WFInstance();
				wfInstance.setWFInstanceId(strKey);
				wfInstanceService.get(wfInstance);
				if (!StringHelper.isNullOrEmpty(strActionData))
				{
					strActionData += ";";
				}
				strActionData += wfInstance.getWFInstanceName();
			}
			et.setDataInfo(strActionData);
		}

	}

	@Override
	protected void onAfterCreate(WFUIWizard et) throws Exception
	{
		if (StringHelper.compare(et.getActionMode(), ACTIONMODE_GOTOSTEP, true) == 0)
		{
			String strActorId= this.getWebContext().getCurUserId();
			// 获取数据
			String strActoinParams = et.getActionParam();
			String[] keys = strActoinParams.split("[;]");
			WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
			for (String strKey : keys)
			{
				WFInstance wfInstance = new WFInstance();
				wfInstance.setWFInstanceId(strKey);
				wfInstanceService.get(wfInstance);

				IWFModel iWFModel = WFModelGlobal.getWFModel(wfInstance.getWFWorkflowId());

				IWFService iWFService = iWFModel.getWFService();
				WFActionParam wfActionParam = new WFActionParam();
				wfActionParam.setUserData(wfInstance.getUserData());
				wfActionParam.setUserData4(wfInstance.getUserData4());
				wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
				wfActionParam.setConnection(IWFService.CONNECTION_IAGOTO);
				wfActionParam.setStepId(et.getWFStepValue());
				iWFService.timeoutIAAction(wfActionParam);
			}
		}

		super.onAfterCreate(et);
	}

}