package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 工作流后台服务
 * 
 * @author Administrator
 */
public class WFBackendService extends BackendServiceBase
{
	private static Log log = LogFactory.getLog(WFBackendService.class);

	private Timer checkTimer = null;

	protected String strQuerySQL = "select t1.* from t_SRFWFINSTANCE t1 INNER JOIN T_SRFWFSTEP t2 ON t1.ACTIVESTEPID =  t2.WFSTEPID "
			+ "where (t1.ISCLOSE IS NULL OR t1.ISCLOSE = 0) AND t2.DEADline IS NOT NULL and t2.DEADline<? ORDER BY t2.DEADline DESC";
	
	protected String strQuerySQLLowCase = "select t1.activestepid,t1.activestepname,t1.cancelreason,t1.createdate,t1.createman,t1.enable,t1.endtime,t1.errorinfo,t1.importanceflag,t1.iscancel,t1.isclose,t1.iserror,t1.isfinish,t1.lastaction,t1.lastactorid,t1.lastwfstepid,t1.memo,t1.orgid,t1.orgname,t1.owner,t1.parallelinst,t1.pstepid,t1.pwfinstanceid,t1.result,t1.starttime,t1.suspendflag,t1.tracestep,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.userdata3,t1.userdata4,t1.userdatainfo,t1.usertag,t1.usertag2,t1.wfinstanceid,t1.wfinstancename,t1.wfmodel,t1.wfversion,t1.wfworkflowid from t_srfwfinstance t1 inner join t_srfwfstep t2 on t1.activestepid =  t2.wfstepid "
			+ "where (t1.isclose is null or t1.isclose = 0) and t2.deadline is not null and t2.deadline<? order by t2.deadline desc";
	

	protected String strQuerySQL2 = "select t1.* from t_srfwfucpolicy t1 where (t1.policystate=1 and t1.begintime <= ? ) or (t1.policystate=2 and t1.ENDTIME is not null and t1.ENDTIME < ?)";
	
	protected String strQuerySQL2LowCase = "select t1.begintime,t1.createdate,t1.createman,t1.endtime,t1.majorwfuserid,t1.memo,t1.minorwfuserid,t1.policystate,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.validflag,t1.wfucpolicyid,t1.wfucpolicyname from t_srfwfucpolicy t1 where (t1.policystate=1 and t1.begintime <= ? ) or (t1.policystate=2 and t1.endtime is not null and t1.endtime < ?)";
	
	int nCheckTimer = 30000;

	private WFStepService wfStepService = null;

	private WFUCPolicyService wfUCPolicyService = null;
	
	private boolean bChecking = false;


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception
	{
		super.onInit();

		int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQLLowCase);
			strQuerySQL2 = this.getServiceParam("QUERYSQL2", strQuerySQL2LowCase);
		}else {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQL);
			strQuerySQL2 = this.getServiceParam("QUERYSQL2", strQuerySQL2);
		}
		
		nCheckTimer = Integer.parseInt(this.getServiceParam("CHECKTIMER", "30000"));

		wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class);
		wfUCPolicyService = (WFUCPolicyService) ServiceGlobal.getService(WFUCPolicyService.class);
		
		strQuerySQL = wfStepService.getDAO().getRealDBDialect().getPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
		if (StringHelper.isNullOrEmpty(strQuerySQL))
		{
			throw new Exception("没有指定工作流超时检查SQL");
		}
		
		strQuerySQL2 = wfUCPolicyService.getDAO().getRealDBDialect().getPagingSQL(strQuerySQL2, 0, nPageSize, "CREATEDATE", "ASC", "", "");
		if (StringHelper.isNullOrEmpty(strQuerySQL))
		{
			throw new Exception("没有指定工作流工作委派策略检查SQL");
		}

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStart()
	 */
	@Override
	protected void onStart() throws Exception
	{
		super.onStart();

		if (checkTimer == null)
		{
			checkTimer = new Timer("WFBACKSERVICE");
			checkTimer.schedule(new TimerTask(){
				@Override
				public void run() {
					runTask();
				}}, nCheckTimer, nCheckTimer);
		}

		log.info(StringHelper.format("WF Service Start"));

	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStop()
	 */
	@Override
	protected void onStop() throws Exception
	{
		log.info(StringHelper.format("WF Service Stop"));
		if (checkTimer != null)
		{
			checkTimer.cancel();
			checkTimer = null;
		}

		super.onStop();
	}

	
	
	

	@Override
	protected void onRun() throws Exception {
		
		try
		{
			internalRun();
		}
		catch (Exception ex)
		{
			log.error(StringHelper.format("工作流超时处理发生错误，%1$s", ex.getMessage()), ex);
		}
		
		try
		{
			internalRun2();
		}
		catch (Exception ex)
		{
			log.error(StringHelper.format("工作流委派处理发生错误，%1$s", ex.getMessage()), ex);
		}
	}

//	/* (non-Javadoc)
//	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#run()
//	 */
//	@Override
//	public void run()
//	{
//		synchronized (this)
//		{
//			if (bChecking)
//				return;
//			bChecking = true;
//		}
//		try
//		{
//			internalRun();
//		}
//		catch (Exception ex)
//		{
//			log.error(StringHelper.format("工作流超时处理发生错误，%1$s", ex.getMessage()), ex);
//		}
//		
//		try
//		{
//			internalRun2();
//		}
//		catch (Exception ex)
//		{
//			log.error(StringHelper.format("工作流委派处理发生错误，%1$s", ex.getMessage()), ex);
//		}
//		
//		synchronized (this)
//		{
//			bChecking = false;
//		}
//	}

	/**
	 * 内部处理，处理超时流程
	 * @throws Exception
	 */
	protected void internalRun() throws Exception
	{
		// 检查超时的工作流
		SqlParamList sqlParamList = new SqlParamList();
		
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime()+30000);
		sqlParamList.addDateTime(sendTime);
		
		ArrayList<IEntity> timeoutWFInstanceList = wfStepService.selectRaw(strQuerySQL, sqlParamList);
		if (timeoutWFInstanceList.size() == 0)
		{
			return;
		}
		
		for (IEntity wfInst : timeoutWFInstanceList)
		{
			WFInstance wfInstance = new WFInstance();
			wfInst.copyTo(wfInstance, false);
			
			IWFService iWFService = WFModelGlobal.getWFModel(wfInstance.getWFWorkflowId()).getWFService();
			
			WFActionParam wfActionParam = new WFActionParam();
			wfActionParam.setUserData(wfInstance.getUserData());
			wfActionParam.setUserData4(wfInstance.getUserData4());
			wfActionParam.setOpPersonId("SYSTEM");
			wfActionParam.setStepId(wfInstance.getActiveStepName());
			wfActionParam.setConnection(IWFService.CONNECTION_TIMEOUT);
			
			try
			{
				iWFService.timeoutIAAction(wfActionParam);
			}
			catch(Exception ex)
			{
				log.error(StringHelper.format("工作流交互超时操作失败，%1$s", ex.getMessage()));
				continue;
			}
			
		}
		
	}

	
	/**
	 * 内部处理，处理委派策略
	 * @throws Exception
	 */
	protected void internalRun2() throws Exception
	{
		// 检查委派策略
		SqlParamList sqlParamList = new SqlParamList();
		
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime()+30000);
		
		sqlParamList.addDateTime(sendTime);
		sqlParamList.addDateTime(sendTime);
		
		ArrayList<IEntity> wfUCPolicyList = wfUCPolicyService.selectRaw(strQuerySQL2, sqlParamList);
		if (wfUCPolicyList.size() == 0)
		{
			return;
		}
		
		for (IEntity iEntity : wfUCPolicyList)
		{
			WFUCPolicy wfUCPolicy = new WFUCPolicy();
			iEntity.copyTo(wfUCPolicy, false);
	
			try
			{

				if(wfUCPolicy.getPolicyState()== WFUCPolicyStateCodeListModel.NOTAPPLIED)
				{
					//应用改策略
					WFUCPolicy wfUCPolicy2 = new WFUCPolicy();
					wfUCPolicy2.setWFUCPolicyId(wfUCPolicy.getWFUCPolicyId());
					wfUCPolicy2.setPolicyState(WFUCPolicyStateCodeListModel.APPLIED);
					wfUCPolicyService.update(wfUCPolicy2);
					continue;
				}
				
				if(wfUCPolicy.getPolicyState()== WFUCPolicyStateCodeListModel.APPLIED)
				{
					//超时
					WFUCPolicy wfUCPolicy2 = new WFUCPolicy();
					wfUCPolicy2.setWFUCPolicyId(wfUCPolicy.getWFUCPolicyId());
					wfUCPolicy2.setPolicyState(WFUCPolicyStateCodeListModel.EXPIRED);
					wfUCPolicyService.update(wfUCPolicy2);
					continue;
				}
				
			}
			catch(Exception ex)
			{
				log.error(StringHelper.format("工作流委派策略操作失败，%1$s", ex.getMessage()));
				continue;
			}
			
		}
		
	}
}
