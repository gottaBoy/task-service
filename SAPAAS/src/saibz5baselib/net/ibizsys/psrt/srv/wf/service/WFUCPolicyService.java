package net.ibizsys.psrt.srv.wf.service;

import java.util.ArrayList;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserCandidate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Service
//@Transactional
@Component
/**
 * 工作流候选用户策略 服务操作对象
 * 
 */
public class WFUCPolicyService extends WFUCPolicyServiceBase
{
	private static final Log log = LogFactory.getLog(WFUCPolicyService.class);

	public WFUCPolicyService()
	{
		super();

	}
	
	@Override
	protected void onEnablePolicy(WFUCPolicy wFUCPolicy) throws Exception
	{
		wFUCPolicy.resetPolicyState();
		wFUCPolicy.setValidFlag(1);
		this.update(wFUCPolicy);
	}
	
	
	@Override
	protected void onDisablePolicy(WFUCPolicy wFUCPolicy) throws Exception
	{
		wFUCPolicy.resetPolicyState();
		wFUCPolicy.setValidFlag(0);
		this.update(wFUCPolicy);
	}
	
	@Override
	protected void onBeforeCreate(WFUCPolicy et) throws Exception
	{
		calcWFUCPolicyState(et);
		calcWFUCPolicyName(et);
		super.onBeforeCreate(et);
	}
	
	@Override
	protected void onBeforeUpdate(WFUCPolicy et) throws Exception
	{
		calcWFUCPolicyState(et);
		calcWFUCPolicyName(et);
		super.onBeforeUpdate(et);
	}
	

	@Override
	protected void onAfterRemove(WFUCPolicy et) throws Exception
	{
		removeWFUserCandidate(et);
		super.onAfterRemove(et);
	}

	@Override
	protected void onAfterCreate(WFUCPolicy et) throws Exception
	{
		createOrRemoveWFUserCandidate(et);
		super.onAfterCreate(et);
	}

	@Override
	protected void onAfterUpdate(WFUCPolicy et) throws Exception
	{
		createOrRemoveWFUserCandidate(et);
		super.onAfterUpdate(et);
	}

	/**
	 * 计算用户委托策略名称
	 * @param et
	 * @throws Exception
	 */
	protected void calcWFUCPolicyName(WFUCPolicy et)throws Exception
	{
		if(et.getMajorWFUser()!=null && et.getMinorWFUser()!=null)
		{
			String strWFUCPolicyName = StringHelper.format("流程工作委托策略[%1$s-%2$s]",et.getMajorWFUserName(),et.getMinorWFUserName());
			et.setWFUCPolicyName(strWFUCPolicyName);
		}
	}
	
	/**
	 * 计算用户委托策略状态
	 * @param et
	 * @throws Exception
	 */
	protected void calcWFUCPolicyState(WFUCPolicy et)throws Exception
	{
		if(et.getPolicyState()==null)
		{
			boolean bValidFlag = DataObject.getBoolValue(et.getValidFlag(), true);
			if(bValidFlag)
			{
				if (et.getBeginTime() != null)
				{
					// 判断开始时间是否大于现在
					if (et.getBeginTime().getTime() > System.currentTimeMillis())
					{
						et.setPolicyState(WFUCPolicyStateCodeListModel.NOTAPPLIED);
						return;
					}
				}

				if (et.getEndTime() != null)
				{
					// 判断结束时间是否小于现在
					if (et.getEndTime().getTime() < System.currentTimeMillis())
					{
						et.setPolicyState(WFUCPolicyStateCodeListModel.EXPIRED);
						return;
					}
				}
				
				et.setPolicyState(WFUCPolicyStateCodeListModel.APPLIED);
				return;
			}
			else
			{
				et.setPolicyState(WFUCPolicyStateCodeListModel.CANCELED);
				return;
			}
		}
	}
	
	protected void createOrRemoveWFUserCandidate(WFUCPolicy et) throws Exception
	{
		if(et.getPolicyState()!=null)
		{
			if(et.getPolicyState() == WFUCPolicyStateCodeListModel.APPLIED)
				createWFUserCandidate(et);
			else
				removeWFUserCandidate(et);
		}
		
		
	}

	/**
	 * 建立候选用户
	 * @param et
	 * @throws Exception
	 */
	protected void createWFUserCandidate(WFUCPolicy et) throws Exception
	{
		WFUserCandidate wfUserCandidate = new WFUserCandidate();
		wfUserCandidate.setWFUserCandidateId(et.getWFUCPolicyId());
		WFUserCandidateService wfUserCandidateService = (WFUserCandidateService) ServiceGlobal.getService(WFUserCandidateService.class, getSessionFactory());
		if (wfUserCandidateService.checkKey(wfUserCandidate) == IService.CHECKKEYSTATE_OK)
		{
			wfUserCandidate.setWFUserCandidateName(et.getMinorWFUserName());
			wfUserCandidate.setWFMajorUserId(et.getMajorWFUserId());
			wfUserCandidate.setWFMajorUserName(et.getMajorWFUserName());
			wfUserCandidate.setWFMinorUserId(et.getMinorWFUserId());
			wfUserCandidate.setWFMinorUserName(et.getMinorWFUserName());
			wfUserCandidate.setUserData(et.getWFUCPolicyId());
			wfUserCandidateService.create(wfUserCandidate, false);
			
			//直接标记为不接收工作
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(wfUserCandidate.getWFMajorUserId());
			wfUser.setIsRecvWork(0);
			WFUserService wfUserService = (WFUserService) ServiceGlobal.getService(WFUserService.class, getSessionFactory());
			wfUserService.update(wfUser,false);
		}
	}

	/**
	 * 移除候选用户
	 * @param et
	 * @throws Exception
	 */
	protected void removeWFUserCandidate(WFUCPolicy et) throws Exception
	{
		WFUserCandidate wfUserCandidate = new WFUserCandidate();
		wfUserCandidate.setWFUserCandidateId(et.getWFUCPolicyId());
		WFUserCandidateService wfUserCandidateService = (WFUserCandidateService) ServiceGlobal.getService(WFUserCandidateService.class, getSessionFactory());
		if (wfUserCandidateService.get(wfUserCandidate,true))
		{
			// 移除关联
			wfUserCandidateService.remove(wfUserCandidate);
			
			//查询所有的
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(wfUserCandidate.getWFMajorUserId());
			
			ArrayList<WFUserCandidate > wfUserCandidateList = 	wfUserCandidateService.selectByWFMajorUser(wfUser);
			if(wfUserCandidateList.size() == 0){
				 //接收工作
				wfUser.setIsRecvWork(1);
			}
			else //不接收工作
			{
				wfUser.setIsRecvWork(0);
			}
			
			WFUserService wfUserService = (WFUserService) ServiceGlobal.getService(WFUserService.class, getSessionFactory());
			wfUserService.update(wfUser,false);
		}
	}

}