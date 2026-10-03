package net.ibizsys.pswf.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.wf.entity.WFAction;
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;
import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.service.WFStepInstService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.pswf.i18n.WFLanResTags;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

/**
 * 工作流数据访问对象
 * 
 * @author lionlau
 * 
 */
public class WFDataCtrl implements IWFDataCtrl,IWFDataCtrl2
{
	private static final Log log = LogFactory.getLog(WFDataCtrl.class);

	protected WFInstanceService wfInstanceService = null;

	protected WFStepDataService wfStepDataService = null;

	protected WFStepService wfStepService = null;

	protected WFStepActorService wfStepActorService = null;

	protected WFStepInstService wfStepInstService = null;

	protected WFIAActionService wfIAActionService = null;

	protected WFWorkListService wfWorkListService = null;

	protected WFUserService wfUserService = null;

	protected WFTmpStepActorService wfTmpStepActorService = null;

	protected MsgTemplateService msgTemplateService = null;

	protected MsgAccountService msgAccountService = null;

	protected MsgSendQueueService msgSendQueueService = null;

	protected IWFModel iWFModel = null;

	protected boolean bUserCandidate = true;

	protected boolean bNoLogSystem = true;

	protected final static String USER_SYSTEM = "SYSTEM";

	
	
	/**
	 * 嵌入流程启动时标记为并行子流程
	 */
	public final static String CONNECTION_PARALLELSUBWF = "PARALLELSUBWF" ;
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#init(net.ibizsys.pswf.core.IWFModel)
	 */
	@Override
	public void init(IWFModel iWFModel) throws Exception
	{
		wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class);
		wfStepDataService = (WFStepDataService) ServiceGlobal.getService(WFStepDataService.class);
		wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class);
		wfStepActorService = (WFStepActorService) ServiceGlobal.getService(WFStepActorService.class);
		wfIAActionService = (WFIAActionService) ServiceGlobal.getService(WFIAActionService.class);
		wfWorkListService = (WFWorkListService) ServiceGlobal.getService(WFWorkListService.class);
		wfUserService = (WFUserService) ServiceGlobal.getService(WFUserService.class);
		wfTmpStepActorService = (WFTmpStepActorService) ServiceGlobal.getService(WFTmpStepActorService.class);
		msgTemplateService = (MsgTemplateService) ServiceGlobal.getService(MsgTemplateService.class);
		msgAccountService = (MsgAccountService) ServiceGlobal.getService(MsgAccountService.class);
		msgSendQueueService = (MsgSendQueueService) ServiceGlobal.getService(MsgSendQueueService.class);
		wfStepInstService = (WFStepInstService) ServiceGlobal.getService(WFStepInstService.class);
		this.iWFModel = iWFModel;
		this.prepareRTEnv();
	}

	/**
	 * 准备运行环境
	 * 
	 * @throws Exception
	 */
	protected void prepareRTEnv() throws Exception
	{
		return;
	}

	/**
	 * 获取流程模型对象
	 * 
	 * @return
	 */
	protected IWFModel getWFModel()
	{
		return this.iWFModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance, boolean)
	 */
	@Override
	public WFInstance getWFInstance(IWFActionContext2 iWFActionContext, WFInstance wfInstance, boolean bTryMode) throws Exception
	{
		String strWFInstanceId = "";
		if (wfInstance == null)
			wfInstance = new WFInstance();
		else
		{
			strWFInstanceId = wfInstance.getWFInstanceId();
		}

		if (StringHelper.isNullOrEmpty(strWFInstanceId))
		{
			wfInstance.reset();

			String strDataKey = iWFActionContext.getWFActionParam().getUserData();
			String strDEName = iWFActionContext.getWFActionParam().getUserData4();

			SelectCond selectCond = new SelectCond();
			selectCond.setConditon(WFInstance.FIELD_WFWORKFLOWID, iWFActionContext.getWFModel().getId());
			selectCond.setConditon(WFInstance.FIELD_USERDATA, strDataKey);
			if (!StringHelper.isNullOrEmpty(strDEName))
			{
				selectCond.setConditon(WFInstance.FIELD_USERDATA4, strDEName);
			}

			ArrayList<WFInstance> wfInstanceList = wfInstanceService.select(selectCond);
			if (wfInstanceList.size() == 0)
			{
				if (bTryMode)
					return null;
				else
				{
					throw new WFException(WFErrors.E_000037,getLocalization(WFLanResTags.MSG_E_000037,null, StringHelper.format("指定工作流实例不存在")));
				}
			}

			WFInstance wfInst2 = null;
			for (WFInstance wfInst : wfInstanceList)
			{
				if (!DataObject.getBoolValue(wfInst.getIsClose(), false))
				{
					wfInst2 = wfInst;
					break;
				}
			}

			if (wfInst2 == null)
			{
				if (bTryMode)
					return null;
				else
				{
					throw new WFException(WFErrors.E_000036,getLocalization(WFLanResTags.MSG_E_000036, null, StringHelper.format("指定工作流实例已经关闭，无法操作")));
				}
			}

			wfInst2.copyTo(wfInstance, false);
		}
		else
		{
			wfInstanceService.get(wfInstance);
		}

		return wfInstance;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFIAAction(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.lang.String, net.ibizsys.psrt.srv.wf.entity.WFIAAction)
	 */
	@Override
	public void getWFIAAction(IWFActionContext2 iWFActionContext, String strWFStepId, String strActionName, WFIAAction iaAction) throws Exception
	{
		SelectCond selectCond = new SelectCond();
		selectCond.set("WFSTEPID", strWFStepId);
		selectCond.set("ACTIONNAME", strActionName);
		ArrayList<WFIAAction> wfIAActionList = wfIAActionService.select(selectCond);
		if (wfIAActionList.size() == 0)
		{
			throw new Exception("找不到指定的互动行为");
		}

		wfIAActionList.get(0).copyTo(iaAction, true);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFUserAssist(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.lang.String, net.ibizsys.psrt.srv.wf.entity.WFUserAssist)
	 */
	@Override
	public void getWFUserAssist(IWFActionContext2 iWFActionContext, String strWFStepActorId, String strAssistUserId, WFUserAssist userAssist) throws Exception
	{
		throw new Exception("没有实现 getWFIAAction");
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFUserAssists(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void getWFUserAssists(IWFActionContext2 iWFActionContext, String strWFStepActorId, String strAssistUserId, ArrayList<WFUserAssist> userAssists) throws Exception
	{
		throw new Exception("没有实现 getWFUserAssists");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFAction(java.lang.String, java.lang.String, net.ibizsys.psrt.srv.wf.entity.WFAction)
	 */
	@Override
	public void getWFAction(String strWFID, String strWFActionId, WFAction action) throws Exception
	{
		throw new Exception("没有实现 getWFAction");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepDataCount(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.lang.String)
	 */
	@Override
	public int getWFStepDataCount(IWFActionContext2 iWFActionContext, String strWFStepId, String strActionName) throws Exception
	{
		String strSQL = StringHelper.format("select count(*) as RDCOUNT from T_SRFWFSTEPDATA where  WFSTEPID='%1$s' AND UPPER(CONNECTIONNAME) = UPPER('%2$s')", strWFStepId, strActionName);
		DataObject dataObject = new DataObject();
		executeRawSql(strSQL, null, dataObject);
		return DataObject.getIntegerValue(dataObject, "RDCOUNT", 0);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepActorCount(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String)
	 */
	@Override
	public int getWFStepActorCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception
	{
		String strSQL = StringHelper.format("select count(*) as RDCOUNT from t_srfwfSTEPACTOR where  WFSTEPID='%1$s'", strWFStepId);
		DataObject dataObject = new DataObject();
		executeRawSql(strSQL, null, dataObject);
		return DataObject.getIntegerValue(dataObject, "RDCOUNT", 0);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepActors(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void getWFStepActors(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepActor> list) throws Exception
	{
		WFStep wfStep = new WFStep();
		wfStep.setWFStepId(strWFStepId);
		list.addAll(wfStepActorService.selectByWFStep(wfStep));
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepDatas(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void getWFStepDatas(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepData> list) throws Exception
	{
		//throw new Exception("没有实现 getWFStepDatas");
		String strSql = "" ;
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSql = StringHelper.format("select actorid,actorname,actorname2,connectionname,createdate,createman,memo,nextto,originalwfuserid,originalwfusername,sdparam,sdparam2,updatedate,updateman,userdata,userdatadesc,wfactionlanrestag,wfinstanceid,wfinstancename,wfplogicname,wfstepdataid,wfstepdataname,wfstepid,wfsteplanrestag,wfstepname from t_srfwfstepdata where wfstepid='%1$s' and (connectionname <> 'SRFWFRESUBMIT' and connectionname <> 'SRFWFTIMEOUT')", strWFStepId);
		}else {
			strSql = StringHelper.format("select * from t_srfwfSTEPDATA where WFSTEPID='%1$s' AND (CONNECTIONNAME <> 'SRFWFRESUBMIT' AND CONNECTIONNAME <> 'SRFWFTIMEOUT')", strWFStepId);
		}
		this.executeRawSql(strSql, null, list, WFStepData.class);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepRoleCount(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String)
	 */
	@Override
	public int getWFStepRoleCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception
	{
		throw new Exception("没有实现 getWFStepRoleCount");
	}

	@Override
	public void removeNoDataWFStepActor(IWFActionContext2 iWFActionContext, String strWFStepId, String strRoleId) throws Exception
	{
		String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=? and cancelflag=0 " + 
				" AND WFACTORID IN (SELECT t.ACTORID FROM t_srfwfstepactor t WHERE t.ROLEID= ? AND t.WFSTEPID= ?)");
    	SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addDateTime(DateHelper.getCurTime());
		sqlParamList.addString(strWFStepId);
		sqlParamList.addString(iWFActionContext.getActiveWFInstanceId());
		sqlParamList.addString(strRoleId);
		sqlParamList.addString(strWFStepId);
		this.executeRawSql(strSQL, sqlParamList);
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFUserEntity(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void getWFUserEntity(IWFActionContext2 iWFActionContext, IEntity iEntity) throws Exception
	{
		String strDataKey = iWFActionContext.getWFActionParam().getUserData();
		String strDEName = iWFActionContext.getWFActionParam().getUserData4();
		if ((StringHelper.isNullOrEmpty(strDataKey) || StringHelper.isNullOrEmpty(strDEName)) && iWFActionContext.getActiveWFInstance() != null)
		{
			strDataKey = iWFActionContext.getActiveWFInstance().getUserData();
			strDEName = iWFActionContext.getActiveWFInstance().getUserData4();
		}

		IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
		IService iService = iDataEntityModel.getService();
		iEntity.set(iDataEntityModel.getKeyDEField().getName(), strDataKey);
		iService.get(iEntity);

		// 放入实体名称
		String strDataInfo =  iDataEntityModel.getDataInfo(iEntity);
		iEntity.set("srfdatainfo", StringHelper.format("%1$s|%2$s", iDataEntityModel.getLogicName(),strDataInfo));
		iEntity.set(IDataItem.MAJORTEXTITEM, strDataInfo);
		//放入机构数据
		IDEField orgIdDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID,true);
		if(orgIdDEField!=null){
			iEntity.set(USERENTITY_ORGID,iEntity.get(orgIdDEField.getName()));
		}
		
		IDEField orgNameDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGNAME,true);
		if(orgNameDEField!=null){
			iEntity.set(USERENTITY_ORGNAME,iEntity.get(orgNameDEField.getName()));
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#updateWFUserDataRunStep(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String)
	 */
	@Override
	public void updateWFUserDataRunStep(IWFActionContext2 iWFActionContext, String strWFStepValue) throws Exception
	{
		WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
		IDEWF iDEWF = null;

		
		String strWFStepColumnName = "";
		
		if(false)
		{
			// // 并行子流程
			// DESubWF deSubWF = new DESubWF();
			// deSubWF.setDESUBWFID(wfInstance.getUSERTAG());
			// callResult = this.deSubWFDataCtrl.Get(deSubWF);
			// if (callResult.IsError())
			// {
			// log.error(StringHelper.format("无法获取实体子流程[%1$s],%2$s",
			// deSubWF.getDESUBWFID(), callResult.getErrorInfo()));
			// return callResult;
			// }
			//
			// strWFStepColumnName = deSubWF.getWFSTEPDEFID();
			
			// 常规流程
			iDEWF = iDEModel.getDEWF(wfInstance.getWFWorkflowId());
			// 获取步骤字段
			strWFStepColumnName = iDEWF.getWFStepField();
						
		}
		else
		{
			// 常规流程
			iDEWF = iDEModel.getDEWF(wfInstance.getWFWorkflowId());
			// 获取步骤字段
			strWFStepColumnName = iDEWF.getWFStepField();
		}

		IEntity iEntity = iDEModel.createEntity();
		iEntity.set(iDEModel.getKeyDEField().getName(), wfInstance.getUserData());
		iEntity.set(strWFStepColumnName, strWFStepValue);
		// 重置当前操作用户
		if (iDEWF != null)
		{
			String strWFActorsField = iDEWF.getWFActorsField();
			if (!StringHelper.isNullOrEmpty(strWFActorsField))
			{
				iEntity.set(strWFActorsField, "");
			}
		}

		IService deDataCtrl = iDEModel.getService();
		deDataCtrl.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE, iWFActionContext, iEntity);
		
	}

	/**
	 * 获取用户数据实体模型对象
	 * @param iWFActionContext
	 * @param strWFWorkflowId
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel getUserDataDEModel(IWFActionContext2 iWFActionContext, String strWFWorkflowId, String strDEName) throws Exception
	{
		IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
		return iDataEntityModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void addWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
		IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());

		// 并行流程，不加锁
		if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		{
			// 对业务数据进行加锁

		}

		// 将数据进行查出，填充描述字段
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());
		IService udService = iDEModel.getService();
		udService.get(dataEntity);
		instance.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		instance.setStartTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		// instance.setDESCRIPTION(iDEModel.GetDataInfo(dataEntity));
		wfInstanceService.create(instance);
		//if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		if(true)
		{
			dataEntity.reset();
			dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());


			String strWFInstDEF = iDEWF.getWFInstField();
			if (!StringHelper.isNullOrEmpty(strWFInstDEF))
			{
				dataEntity.set(strWFInstDEF, instance.getWFInstanceId());
			}
			String strWFStateDEF = iDEWF.getWFStateField();
			if (!StringHelper.isNullOrEmpty(strWFStateDEF))
			{
				dataEntity.set(strWFStateDEF, WFStates.NOTFINISH);
			}

			String strUDStateDEF = iDEWF.getUDStateField();
			if (!StringHelper.isNullOrEmpty(strUDStateDEF) && !StringHelper.isNullOrEmpty(iDEWF.getEntityWFState()))
			{
				dataEntity.set(strUDStateDEF, iDEWF.getEntityWFState());
			}
			
			String strWFVerDEF = iDEWF.getWFVerField();
			if (!StringHelper.isNullOrEmpty(strWFVerDEF))
			{
				dataEntity.set(strWFVerDEF,instance.getWFVersion());
			}
			
			String strWFIdDEF = iDEWF.getWorkflowField();
			if (!StringHelper.isNullOrEmpty(strWFIdDEF))
			{
				dataEntity.set(strWFIdDEF,instance.getWFWorkflowId());
			}


			udService.updateWFInfo(IService.UPDATEWFINFOMODE_INIT, iWFActionContext, dataEntity);

		}
		// else
		// {
		// DESubWF deSubWF = iDEModel.GetDESubWF(instance.getUSERTAG());
		// if (deSubWF == null)
		// {
		// callResult.setRetCode(Errors.INTERNALERROR);
		// callResult.setErrorInfo(StringHelper.format("无法获取实体子流程[%1$s]",
		// instance.getUSERTAG()));
		// log.error(callResult.getErrorInfo());
		// return callResult;
		// }
		//
		// dataEntity.Reset();
		// dataEntity.set(iDEModel.GetKeyDEFHelper().getName(),
		// instance.getUSERDATA());
		//
		// String strWFInstDEF = deSubWF.getWFINSTDEFID();
		// if (!StringHelper.isNullOrEmpty(strWFInstDEF))
		// {
		// IDEFHelper wfInstDEFHelper = iDEModel.GetDEFHelper(strWFInstDEF);
		// if (wfInstDEFHelper == null)
		// {
		// callResult.setRetCode(Errors.INTERNALERROR);
		// callResult.setErrorInfo(StringHelper.format("无法获取实体[%1$s]属性[%2$s]辅助对象",
		// iDEModel.GetFullName(), strWFInstDEF));
		// log.error(callResult.getErrorInfo());
		//
		// this.RemoveWFInstance(instance, strOpPersonId);
		//
		// return callResult;
		// }
		// dataEntity.set(wfInstDEFHelper.getName(),
		// instance.getWFInstanceId());
		// }
		//
		// String strWFUpdateAction =
		// PropertiesHelper.GetProperty(deSubWF.getWFParams(),
		// DEWF.WFPARAM_UPDATEACTIONMODE,
		// DEWF.WFPARAM_UPDATEACTIONMODE_WFACTION);
		// callResult = udService.Save(false, strWFUpdateAction, dataEntity);
		// if (callResult.getRetCode() != Errors.OK)
		// {
		// callResult.setRetCode(Errors.INTERNALERROR);
		// callResult.setErrorInfo(StringHelper.format("更新用户数据失败，%1$s",
		// callResult.getErrorInfo()));
		// log.error(callResult.getErrorInfo());
		// this.RemoveWFInstance(instance, strOpPersonId);
		// return callResult;
		// }
		//
		// }
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#finishWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void finishWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{
		wfInstanceService.get(instance);
		if (DataObject.getBoolValue(instance.getIsClose(), false))
		{
			throw new Exception("工作流实例已经关闭，无法完成");
		}

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setEndTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		wfInstance.setIsClose(1);
		wfInstance.setIsFinish(1);
		wfInstance.setActiveStepId(null);
		wfInstance.setActiveStepName(null);

		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);

		// 取消通知
		cancelSendWFStepActorInformMsg(iWFActionContext, instance);

		
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
		IService iService = iDEModel.getService();
		if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		{
			// 对业务数据进行解锁锁
			
		}

		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());

		//if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		if(true)
		{
			IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
			

			if (!StringHelper.isNullOrEmpty(iDEWF.getWFInstField()))
			{
				dataEntity.set(iDEWF.getWFInstField(), null);
			}

			

			if (!StringHelper.isNullOrEmpty(iDEWF.getWFStateField()))
			{
				dataEntity.set(iDEWF.getWFStateField(), WFStates.FINISH);
			}

			// 重置当前操作用户
			if (!StringHelper.isNullOrEmpty(iDEWF.getWFActorsField()))
			{
				dataEntity.set(iDEWF.getWFActorsField(), null);
			}

			// 将执行步骤置空
			if (!StringHelper.isNullOrEmpty(iDEWF.getWFStepField()))
			{
				dataEntity.set(iDEWF.getWFStepField(), null);
			}

			iService.updateWFInfo(IService.UPDATEWFINFOMODE_FINISH, iWFActionContext, dataEntity);

		}
		else
		{
			throw new Exception("没有实现");
			// DESubWF deSubWF = deHelper.GetDESubWF(instance.getUSERTAG());
			// if (deSubWF == null)
			// {
			// callResult.setRetCode(Errors.INTERNALERROR);
			// callResult.setErrorInfo(StringHelper.Format("无法获取实体子流程[%1$s]",
			// instance.getUSERTAG()));
			// log.error(callResult.getErrorInfo());
			// return callResult;
			// }
			//
			// String strWFStepDEFId = deSubWF.getWFSTEPDEFID();
			// if (!StringHelper.isNullOrEmpty(strWFStepDEFId))
			// {
			// IDEFHelper wfStepDEFHelper =
			// deHelper.GetDEFHelper(strWFStepDEFId);
			// if (wfStepDEFHelper == null)
			// {
			// callResult.setRetCode(Errors.INTERNALERROR);
			// callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]属性[%2$s]辅助对象",
			// deHelper.GetFullName(), strWFStepDEFId));
			// log.error(callResult.getErrorInfo());
			// return callResult;
			// }
			// dataEntity.SetParamValue(wfStepDEFHelper.getName(), null);
			// }
			//
			// String strWFUpdateAction =
			// PropertiesHelper.GetProperty(deSubWF.getWFParams(),
			// DEWF.WFPARAM_UPDATEACTIONMODE,
			// DEWF.WFPARAM_UPDATEACTIONMODE_WFACTION);
			// callResult = udDEDataCtrl.Save(false, strWFUpdateAction,
			// dataEntity);
			// if (callResult.getRetCode() != Errors.OK)
			// {
			// callResult.setRetCode(Errors.INTERNALERROR);
			// callResult.setErrorInfo(StringHelper.Format("更新用户数据失败，%1$s",
			// callResult.getErrorInfo()));
			// log.error(callResult.getErrorInfo());
			// return callResult;
			// }

		}
	}

	@Override
	public void resetWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
		IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());

		int nversion = instance.getWFVersion();

		wfInstanceService.get(instance);
		if (DataObject.getBoolValue(instance.getIsClose(), false))
		{
			throw new Exception("工作流实例已经关闭，无法重置");
		}

		cancelSendWFStepActorInformMsg(iWFActionContext, instance);

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setEndTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		wfInstance.setIsClose(0);
		wfInstance.setIsFinish(0);
		wfInstance.setIsError(0);
		wfInstance.setErrorInfo(null);
		wfInstance.setActiveStepId(null);
		wfInstance.setActiveStepName(null);
		wfInstance.setWFVersion(nversion);
		// wfInstance.setWFVersion(this.getWFModel().getLastWFVersionModel().getWFVersion());
		wfInstance.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);

		if (true)
		{
//			String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE  CANCELFLAG=0 AND WFINSTANCEID=?");
//			SqlParamList sqlParamList = new SqlParamList();
//			sqlParamList.addDateTime(DateHelper.getCurTime());
//			sqlParamList.addString(instance.getWFInstanceId());
//			executeRawSql(strSQL, sqlParamList);
			cancelOnResetWFInstance(instance);
		}

		

		// 将数据进行查出，填充描述字段
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());
		IService udService = iDEModel.getService();
		udService.get(dataEntity);
		//if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		if(true)
		{
			dataEntity.reset();
			dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());

			String strWFInstDEF = iDEWF.getWFInstField();
			if (!StringHelper.isNullOrEmpty(strWFInstDEF))
			{
				dataEntity.set(strWFInstDEF, instance.getWFInstanceId());
			}
			String strWFStateDEF = iDEWF.getWFStateField();
			if (!StringHelper.isNullOrEmpty(strWFStateDEF))
			{
				dataEntity.set(strWFStateDEF, WFStates.NOTFINISH);
			}

			String strUDStateDEF = iDEWF.getUDStateField();
			if (!StringHelper.isNullOrEmpty(strUDStateDEF) && !StringHelper.isNullOrEmpty(iDEWF.getEntityWFState()))
			{
				dataEntity.set(strUDStateDEF, iDEWF.getEntityWFState());
			}
			
			String strWFVerDEF = iDEWF.getWFVerField();
			if (!StringHelper.isNullOrEmpty(strWFVerDEF))
			{
				dataEntity.set(strWFVerDEF,instance.getWFVersion());
			}
			
			String strWFIdDEF = iDEWF.getWorkflowField();
			if (!StringHelper.isNullOrEmpty(strWFIdDEF))
			{
				dataEntity.set(strWFIdDEF,instance.getWFWorkflowId());
			}

			udService.updateWFInfo(IService.UPDATEWFINFOMODE_INIT, iWFActionContext, dataEntity);
		}
	}

	protected void cancelOnResetWFInstance(WFInstance wfInstance) throws Exception {
		wfWorkListService.cancelByWFInstance(wfInstance);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#errorWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void errorWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception
	{
		throw new Exception("没有实现 errorWFInstance");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#removeWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void removeWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{
		throw new Exception("没有实现 removeWFInstance");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#userCloseWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void userCloseWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
		IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());

		//取消通知
		cancelSendWFStepActorInformMsg(iWFActionContext, instance);


		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setEndTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		wfInstance.setIsClose(1);
		wfInstance.setIsCancel(1);
		wfInstance.setIsError(0);
		wfInstance.setCancelReason(instance.getCancelReason());
		wfInstance.setActiveStepId(null);
		wfInstance.setActiveStepName(null);
		wfInstance.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);


		if (true)
		{
//			String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE  CANCELFLAG=0 AND WFINSTANCEID=?");
//			SqlParamList sqlParamList = new SqlParamList();
//			sqlParamList.addDateTime(DateHelper.getCurTime());
//			sqlParamList.addString(instance.getWFInstanceId());
//			executeRawSql(strSQL, sqlParamList);
			cancelOnUserCloseWFInstance(instance);
		}

		// 将数据进行查出，填充描述字段
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());
		IService udService = iDEModel.getService();
		udService.get(dataEntity);
	//	if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		if(true)
		{
			dataEntity.reset();
			dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());

			String strWFInstDEF = iDEWF.getWFInstField();
			if (!StringHelper.isNullOrEmpty(strWFInstDEF))
			{
				//dataEntity.set(strWFInstDEF, instance.getWFInstanceId());
				dataEntity.set(strWFInstDEF, null);
			}
			String strWFStateDEF = iDEWF.getWFStateField();
			if (!StringHelper.isNullOrEmpty(strWFStateDEF))
			{
				dataEntity.set(strWFStateDEF, WFStates.CANCEL_MANUAL);
			}

			udService.updateWFInfo(IService.UPDATEWFINFOMODE_CANCEL, iWFActionContext, dataEntity);
		}
		
	}
	
	protected void cancelOnUserCloseWFInstance(WFInstance wfInstance) throws Exception {
		wfWorkListService.cancelByWFInstance(wfInstance);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFStep(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStep)
	 */
	@Override
	public void addWFStep(IWFActionContext2 iWFActionContext, WFStep step) throws Exception
	{
		if (StringHelper.isNullOrEmpty(step.getWFStepName()))
		{
			step.setWFStepName("step");
		}
		
		// 获取上一个步骤
		// select ActiveStepId into VAREX_FROMWFSTEPID from t_SRFWFInstance
		// where WFINSTANCEID = VAR_WFINSTANCEID;

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(step.getWFInstanceId());
		wfInstanceService.get(wfInstance);

		String strFromWFStepId = wfInstance.getActiveStepId();

		// 判断该步骤是否已经完毕
		if (!StringHelper.isNullOrEmpty(strFromWFStepId))
		{
			WFStep wfStep = new WFStep();
			wfStep.setWFStepId(strFromWFStepId);
			wfStepService.get(wfStep);

			if (!DataObject.getBoolValue(wfStep.getIsFinish(), false))
			{
				throw new Exception("上一个步骤还未完成");
			}
		}
		int nTraceStep = 1;

		if (true)
		{
			if (wfInstance.getTraceStep() == null)
			{
				nTraceStep = 1;
			}
			else
			{
				nTraceStep = wfInstance.getTraceStep() + 1;
			}
		}

		step.setIsFinish(0);
		step.setTraceStep(nTraceStep);
		step.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfStepService.create(step);
		/*
		 * -- 更新主数据 update t_SRFWFInstance set ActiveStepId =
		 * VAREX_WFSTEPID,ActiveStepName=VAR_WFPNAME,
		 * updateman=SRF_PERSONID,updatedate = SRF_CURTIME where WFINSTANCEID =
		 * VAR_WFINSTANCEID;
		 */
		wfInstance.reset();
		wfInstance.setWFInstanceId(step.getWFInstanceId());
		wfInstance.setActiveStepId(step.getWFStepId());
		wfInstance.setActiveStepName(step.getWFPName());
		wfInstance.setTraceStep(nTraceStep);
		wfInstance.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfInstanceService.update(wfInstance, false);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFStepData(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepData)
	 */
	@Override
	public void addWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception
	{
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(stepData.getWFInstanceId());
		wfInstanceService.get(wfInstance);

		if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
		{
			throw new WFException(WFErrors.E_000036,getLocalization(WFLanResTags.MSG_E_000036, null, StringHelper.format("指定工作流实例已经关闭，无法操作")));
		}

		if (StringHelper.compare(wfInstance.getActiveStepName(), stepData.getWFStepId(), true) != 0)
		{
			throw new Exception("指定工作流实例执行步骤不相符");
		}

		WFIAAction wfIAAction = null;
		if ((StringHelper.compare(stepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0) && (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0))
		{
			SelectCond selectCond = new SelectCond();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTIONNAME", stepData.getConnectionName());
			ArrayList<WFIAAction> wfIAActionList = wfIAActionService.select(selectCond);
			if (wfIAActionList.size() == 0)
			{
				throw new Exception("找不到指定的互动行为");
			}
			wfIAAction = wfIAActionList.get(0);
		}


		if (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0)
		{
			SelectCond selectCond = new SelectCond();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTORID", stepData.getActorId());
			selectCond.setFetchFirst(true);
			ArrayList<WFStepActor> wfStepActorList = wfStepActorService.select(selectCond);
			if (wfStepActorList.size() == 0)
			{
				throw new Exception("用户无法执行当前步骤，不在可执行用户的范围内");
			}
			
			WFStepActor wfStepActor = wfStepActorList.get(0); 
			stepData.setOriginalWFUserId(wfStepActor.getOriginalWFUserId());
			stepData.setOriginalWFUserName(wfStepActor.getOriginalWFUserName());
			
			selectCond.reset();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTORID", stepData.getActorId());
			ArrayList<WFStepData> wfStepDataList = wfStepDataService.select(selectCond);
			for (WFStepData wfStepData : wfStepDataList)
			{
				if (StringHelper.compare(wfStepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0)
				{
					throw new Exception("用户已经完成了当前步骤的操作，无法再次完成");
				}
			}
		}

		
		if (StringHelper.compare(stepData.getConnectionName(), "SRFWFRESUBMIT", true) == 0)
		{
			SelectCond selectCond = new SelectCond();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTORID", stepData.getSDParam());
			ArrayList<WFStepActor> wfStepActorList = wfStepActorService.select(selectCond);
			if (wfStepActorList.size() > 0)
			{
				throw new Exception("无法转移工作到指定用户，该用户已经存在此项工作");
			}
		}


		stepData.setWFStepId(wfInstance.getActiveStepId());
		if (StringHelper.isNullOrEmpty(stepData.getActorName()))
		{
			if (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0)
			{
				WFUser wfUser = new WFUser();
				wfUser.setWFUserId(stepData.getActorId());
				wfUserService.get(wfUser);
				stepData.setActorName(wfUser.getWFUserName());
			}
		}

		if ((!StringHelper.isNullOrEmpty(stepData.getSDParam2())) && StringHelper.isNullOrEmpty(stepData.getActorName2()))
		{
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(stepData.getSDParam2());
			wfUserService.get(wfUser);
			stepData.setActorName2(wfUser.getWFUserName());
		}
		wfStepDataService.create(stepData);

		//更新上一步信息
		wfInstance.reset();
		wfInstance.setLastActorId(stepData.getActorId());
		wfInstance.setLastAction(stepData.getWFStepDataName());
		wfInstance.setLastWFStepId(stepData.getWFStepId());
		wfInstance.setWFInstanceId(stepData.getWFInstanceId());
		wfInstanceService.update(wfInstance, false);


		//取消工作清单
		if (true)
		{
//			String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=? AND WFACTORID=?");
//			SqlParamList sqlParamList = new SqlParamList();
//			sqlParamList.addDateTime(DateHelper.getCurTime());
//			sqlParamList.addString(stepData.getWFStepId());
//			sqlParamList.addString(stepData.getWFInstanceId());
//			sqlParamList.addString(stepData.getActorId());
//			
//			executeRawSql(strSQL, sqlParamList);
			cancelOnAddWFStepData(stepData);
		}

		if (StringHelper.compare(stepData.getConnectionName(), "SRFWFRESUBMIT", true) == 0)
		{
			String strSQL = StringHelper.format("update t_SRFWFSTEPACTOR set ACTORID=?,READFLAG=NULL,FIRSTREADTIME=NULL where (WFSTEPID = ? AND ACTORID = ? ) ");
			SqlParamList sqlParamList = new SqlParamList();
			sqlParamList.addString(stepData.getSDParam());
			sqlParamList.addString(stepData.getWFStepId());
			sqlParamList.addString(stepData.getActorId());
			executeRawSql(strSQL, sqlParamList);
		}
		else
		{
			if (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0)
			{
				String strSQL = StringHelper.format("update t_SRFWFSTEPACTOR set ISFINISH=1 ,FINISHDATE=%1$s where (WFSTEPID = ? AND ACTORID = ? ) ",
						this.getDBDialect().getFuncSQL(IDBDialect.FUNC_CURDATETIME, false, null));
				SqlParamList sqlParamList = new SqlParamList();
				sqlParamList.addString(stepData.getWFStepId());
				sqlParamList.addString(stepData.getActorId());
				executeRawSql(strSQL, sqlParamList);
			}
		}

	}

	protected void cancelOnAddWFStepData(WFStepData stepData) throws Exception {
		wfWorkListService.cancelByWFStepData(stepData);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#testWFStepData(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepData)
	 */
	@Override
	public void testWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception
	{
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(stepData.getWFInstanceId());
		wfInstanceService.get(wfInstance);

		if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
		{
			throw new WFException(WFErrors.E_000036,getLocalization(WFLanResTags.MSG_E_000036,null, StringHelper.format("指定工作流实例已经关闭，无法操作")));
		}

		if (StringHelper.compare(wfInstance.getActiveStepName(), stepData.getWFStepId(), true) != 0)
		{
			throw new Exception("指定工作流实例执行步骤不相符");
		}


		// 查询指定连接是否存在
		WFIAAction wfIAAction = null;
		if ((StringHelper.compare(stepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0) && (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0))
		{
			SelectCond selectCond = new SelectCond();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTIONNAME", stepData.getConnectionName());
			ArrayList<WFIAAction> wfIAActionList = wfIAActionService.select(selectCond);
			if (wfIAActionList.size() == 0)
			{
				throw new Exception("找不到指定的互动行为");
			}
			wfIAAction = wfIAActionList.get(0);
		}

		if (StringHelper.compare(stepData.getConnectionName(), "SRFWFTIMEOUT", true) != 0)
		{
			SelectCond selectCond = new SelectCond();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTORID", stepData.getActorId());
			ArrayList<WFStepActor> wfStepActorList = wfStepActorService.select(selectCond);
			if (wfStepActorList.size() == 0)
			{
				throw new Exception("用户无法执行当前步骤，不在可执行用户的范围内");
			}

			selectCond.reset();
			selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
			selectCond.set("ACTORID", stepData.getActorId());
			ArrayList<WFStepData> wfStepDataList = wfStepDataService.select(selectCond);
			if (wfStepActorList.size() != 0)
			{
				for (WFStepData wfStepData : wfStepDataList)
				{
					if (StringHelper.compare(wfStepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0)
					{
						throw new Exception("用户已经完成了当前步骤的操作，无法再次完成");
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#finishWFStep(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStep)
	 */
	@Override
	public void finishWFStep(IWFActionContext2 iWFActionContext, WFStep step) throws Exception
	{
		WFStep wfStep2 = new WFStep();
		wfStep2.setWFStepId(step.getWFStepId());
		wfStepService.get(wfStep2);
		if (DataObject.getBoolValue(wfStep2.getIsFinish(), false))
		{
			throw new Exception("工作流步骤已经完成，无法再次完成");
		}

		wfStep2.reset();
		wfStep2.setIsFinish(1);
		wfStep2.setEndTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		wfStep2.setWFStepId(step.getWFStepId());
		wfStepService.update(wfStep2);

		wfStep2.copyTo(step, true);

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(step.getWFInstanceId());
		wfInstance.setActiveStepId(null);
		wfInstance.setActiveStepName(null);
		wfInstanceService.update(wfInstance);

		if (true)
		{
//			String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=?");
//			SqlParamList sqlParamList = new SqlParamList();
//			sqlParamList.addDateTime(DateHelper.getCurTime());
//			sqlParamList.addString(wfStep2.getWFStepId());
//			sqlParamList.addString(wfStep2.getWFInstanceId());
//			executeRawSql(strSQL, sqlParamList);
			cancelOnFinishWFStep(wfStep2);
		}

	}
	
	protected void cancelOnFinishWFStep(WFStep step) throws Exception {
		wfWorkListService.cancelByWFStep(step);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFStepActor(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepActor)
	 */
	@Override
	public boolean addWFStepActor(IWFActionContext2 iWFActionContext, WFStepActor stepActor) throws Exception
	{
		stepActor.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		stepActor.setOriginalWFUserId(null);
		stepActor.setOriginalWFUserName(null);
		
		boolean bRecvInform = true;
		//是否忽略计算候选
		boolean bIgnoreCandidate = DataObject.getBoolValue(stepActor, IWFProcRoleUser.FIELD_IGNORESUBSTITUTE,false);
		if (bUserCandidate && !bIgnoreCandidate)
		{
			WFUser wfUser = reCalcRecvWorkWFUser(stepActor.getActorId());
			// 支持用户候选
			if (wfUser != null)
			{
				// 判断用户是否一致
				if (StringHelper.compare(wfUser.getWFUserId(), stepActor.getActorId(), true) != 0)
				{
					stepActor.setOriginalWFUserId(stepActor.getActorId());
					stepActor.setOriginalWFUserName(stepActor.getWFStepActorName());
					stepActor.setActorId(wfUser.getWFUserId());
					stepActor.setWFStepActorName(wfUser.getWFUserName());
					bRecvInform = DataObject.getBoolValue(wfUser.getRecvInform(), true);
				}
			}
			else
				return false;
		}
		
		WFStepActor stepActor2 = new WFStepActor();
		wfStepActorService.fillEntityKeyValue(stepActor);
		stepActor2.setWFStepActorId(stepActor.getWFStepActorId());
		boolean bUpdate = wfStepActorService.get(stepActor2,true);
		if(bUpdate)
		{
			if(!DataObject.getBoolValue(stepActor2.getIsFinish(),false))
			{
				//未完成
				return false;
			}
			
			//重置数据
			stepActor.setIsFinish(null);
			stepActor.setFinishDate(null);
			stepActor.setFirstReadTime(null);
			stepActor.setReminderCount(null);
			
			SelectCond selectCond = new  SelectCond();
			selectCond.reset();
			selectCond.set("WFSTEPID", stepActor2.getWFStepId());
			selectCond.set("ACTORID", stepActor2.getActorId());
			ArrayList<WFStepData> wfStepDataList = wfStepDataService.select(selectCond);
			for (WFStepData wfStepData : wfStepDataList)
			{
				if (StringHelper.compare(wfStepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0)
				{
					//throw new Exception("用户已经完成了当前步骤的操作，无法再次完成");
					WFStepData wfStepData2 = new WFStepData();
					wfStepData2.setConnectionName("SRFWFRESUBMIT");
					wfStepData2.setNextTo(wfStepData.getConnectionName());
					wfStepData2.setWFStepDataId(wfStepData.getWFStepDataId());
					wfStepDataService.update(wfStepData2, false);
				}
			}
		}
		if (true)
		{
			if(bUpdate)
			{
				wfStepActorService.update(stepActor, false);
			}
			else
				wfStepActorService.create(stepActor, false);
			stepActor.set(WFUser.FIELD_RECVINFORM, bRecvInform?1:0);
			if (true)
			{
				WFWorkList wfWorkList = new WFWorkList();
				wfWorkList.setWFInstanceId(iWFActionContext.getActiveWFInstanceId());
				// wfWorkList.setWFInstanceName(iWFActionContext.get.getActiveWFInstanceId());
				wfWorkList.setWFWorkListName(stepActor.getWFStepActorName());
				wfWorkList.setWFActorId(stepActor.getActorId());
				wfWorkList.setWFStepId(stepActor.getWFStepId());
				wfWorkList.setWFInstanceName(iWFActionContext.getActiveWFInstance().getWFInstanceName());
				wfWorkList.setWFStepName(stepActor.getWFStepName());
				wfWorkList.setUserData(iWFActionContext.getActiveWFInstance().getUserData());
				wfWorkList.setUserData2(iWFActionContext.getActiveWFInstance().getUserData2());
				wfWorkList.setUserData3(iWFActionContext.getActiveWFInstance().getUserData3());
				wfWorkList.setUserData4(iWFActionContext.getActiveWFInstance().getUserData4());
				wfWorkList.setOriginalWFUserId(stepActor.getOriginalWFUserId());
				wfWorkList.setOriginalWFUserName(stepActor.getOriginalWFUserName());
				if(iWFActionContext.getActiveEntity()!=null)
				{
					wfWorkList.setUserDataInfo(DataObject.getStringValue(iWFActionContext.getActiveEntity().get(IDataItem.MAJORTEXTITEM)));
				}
				wfWorkList.setWFInstanceName(iWFActionContext.getActiveWFInstance().getWFInstanceName());
				wfWorkList.setWFWorkflowId(iWFActionContext.getActiveWFInstance().getWFWorkflowId());
				wfWorkList.setWFWorkflowName(iWFActionContext.getActiveWFInstance().getWFWorkflowName());
				//处理步骤多语言
				if(iWFActionContext instanceof WFActionContext) {
					WFActionContext wfActionContext = (WFActionContext)iWFActionContext;
					WFStep wfStep = wfActionContext.getActiveWFStep();
					if(wfStep != null && !StringHelper.isNullOrEmpty(wfStep.getWFStepLanResTag()))
						wfWorkList.setWFStepLanResTag(wfStep.getWFStepLanResTag());
				}
				//流程多语言
				String strWFLanResTag = this.getWFModel().getNameLanResTag();
				if(!StringHelper.isNullOrEmpty(strWFLanResTag))
					wfWorkList.setWFLanResTag(strWFLanResTag);
				wfWorkListService.create(wfWorkList, false);
			}
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFIAAction(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFIAAction)
	 */
	@Override
	public void addWFIAAction(IWFActionContext2 iWFActionContext, WFIAAction iaAction) throws Exception
	{
		iaAction.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfIAActionService.create(iaAction);

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFTmpStepActors(net.ibizsys.pswf.core.IWFActionContext2, java.util.ArrayList)
	 */
	@Override
	public void addWFTmpStepActors(IWFActionContext2 iWFActionContext, ArrayList<WFTmpStepActor> tmpStepActors) throws Exception
	{
		HashMap<String, WFTmpStepActor> wfTmpStepActorMap = new HashMap<String, WFTmpStepActor>();

		for (WFTmpStepActor tmpStepActor : tmpStepActors)
		{
			tmpStepActor.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());

			if (bUserCandidate)
			{
				WFUser wfUser = reCalcRecvWorkWFUser(tmpStepActor.getWFActorId());
				// 支持用户候选
				if (wfUser != null)
				{
					// 判断用户是否一致
					if (StringHelper.compare(wfUser.getWFUserId(), tmpStepActor.getWFActorId(), true) != 0)
					{
						tmpStepActor.setWFActorId(wfUser.getWFUserId());
						tmpStepActor.setWFTmpStepActorName(wfUser.getWFUserName());
					}
				}
				else
					continue;
			}

			if (wfTmpStepActorMap.containsKey(tmpStepActor.getWFActorId()))
				continue;

			wfTmpStepActorService.create(tmpStepActor);
			wfTmpStepActorMap.put(tmpStepActor.getWFActorId(), tmpStepActor);
		}

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#removeWFTmpStepActors(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String)
	 */
	@Override
	public void removeWFTmpStepActors(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception
	{
		String strSQL = StringHelper.format("delete from T_SRFWFTMPSTEPACTOR where PREVWFSTEPID='%1$s'", strWFStepId);
		executeRawSql(strSQL, null);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#sendWFStepActorInformMsg(net.ibizsys.pswf.core.IWFActionContext2, java.util.ArrayList, java.lang.String, int)
	 */
	@Override
	public void sendWFStepActorInformMsg(IWFActionContext2 iWFActionContext, ArrayList<String> actors, String strMsgTemplateId, int nMsgType) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
		IService iService = iDEModel.getService();

		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), iWFActionContext.getActiveWFInstance().getUserData());
		iService.get(dataEntity);

		MsgTemplate msgTemplate = new MsgTemplate();
		msgTemplate.setMsgTemplateId(strMsgTemplateId);
		if (!msgTemplateService.get(msgTemplate, true))
		{
			throw new Exception(StringHelper.format("获取指定消息模板[%1$s]失败", strMsgTemplateId));
		}

		boolean bMailGroupSend = DataObject.getBoolValue(msgTemplate.getMailGroupSend(), false);
		String strMailAddress = "";

		ArrayList<MsgSendQueue> msqs = new ArrayList<MsgSendQueue>();
		MsgAccount msgAccount = new MsgAccount();
		for (String strActorId : actors)
		{
			msgAccount.setMsgAccountId(strActorId);
			if (!msgAccountService.get(msgAccount, true))
			{
				throw new Exception(StringHelper.format("获取消息账户[%1$s]失败", strActorId));
			}

			if ((nMsgType & MsgTypeCodeListModel.INTERNAL) != 0)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.INTERNAL, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
				msq.setDstUsers(msgAccount.getMsgAccountId());
				msq.setIsError(0);
				msq.setIsSend(0);
				msqs.add(msq);
			}

			if ((nMsgType & MsgTypeCodeListModel.EMAIL) != 0)
			{
				if (!bMailGroupSend)
				{
					MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.EMAIL, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
					msq.setDstAddresses(msgAccount.getMailAddress());
					msq.setIsError(0);
					msq.setIsSend(0);
					msqs.add(msq);
				}
				else
				{
					if (!StringHelper.isNullOrEmpty(strMailAddress))
					{
						strMailAddress += ";";
					}
					strMailAddress += msgAccount.getMailAddress();
				}
			}

			if ((nMsgType & MsgTypeCodeListModel.MSN) != 0)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.MSN, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
				msq.setDstAddresses(msgAccount.getMsnEmail());
				msq.setIsError(0);
				msq.setIsSend(0);
				msqs.add(msq);
			}

			if ((nMsgType & MsgTypeCodeListModel.SAIM) != 0)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.SAIM, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
				msq.setDstUsers(strActorId);
				msq.setIsError(0);
				msq.setIsSend(0);
				// 附加 步骤属性工作流实例属性
				String strValue = "wfinstance:" + iWFActionContext.getActiveWFInstanceId();
				msq.setUserData(strValue);
				msq.setUserData3("1001");

				msqs.add(msq);
			}

			if ((nMsgType & MsgTypeCodeListModel.SMS) != 0)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.SMS, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
				msq.setDstAddresses(msgAccount.getMobile());
				msq.setIsError(0);
				msq.setIsSend(0);
				msqs.add(msq);
			}

			if ((nMsgType & MsgTypeCodeListModel.WT) != 0)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.WT, msgTemplate, dataEntity, null, msgAccount, USER_SYSTEM);
				msq.setDstAddresses(msgAccount.getWXAddr());
				msq.setDstUsers(strActorId);
				msq.setIsError(0);
				msq.setIsSend(0);
				msq.setUserData(iWFActionContext.getActiveWFInstanceId());
				msq.setUserData2(iWFActionContext.getWFModel().getWXAccountId());
				msq.setUserData3(iWFActionContext.getWFModel().getWXEntAppId());
				
				msqs.add(msq);
			}
		}

		// 设置群组邮件
		if ((nMsgType & MsgTypeCodeListModel.EMAIL) != 0)
		{
			if (bMailGroupSend)
			{
				MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.EMAIL, msgTemplate, dataEntity, null, null, USER_SYSTEM);
				msq.setDstAddresses(strMailAddress);
				msq.setIsError(0);
				msq.setIsSend(0);
				msqs.add(msq);
			}
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
	
	protected void createMsgSendQueue(MsgSendQueue msq) throws Exception {
		msgSendQueueService.create(msq, false);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#calcTimeout(java.sql.Timestamp, java.lang.String, int, java.lang.String)
	 */
	@Override
	public Timestamp calcTimeout(Timestamp srcTime, String strTimeoutType, int nAmount, String strWorkdayType) throws Exception
	{
		//throw new Exception("没有实现 calcTimeout");
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(srcTime);
		 
		if(StringHelper.compare(strTimeoutType, IWFInteractiveProcessModel.TIMEOUTTYPE_MINUTE, true)==0){
			calendar.add(Calendar.SECOND, nAmount*60);
		}else if(StringHelper.compare(strTimeoutType, IWFInteractiveProcessModel.TIMEOUTTYPE_HOUR, true)==0){
			calendar.add(Calendar.HOUR, nAmount);
		}else if(StringHelper.compare(strTimeoutType, IWFInteractiveProcessModel.TIMEOUTTYPE_DAY, true)==0){
			calendar.add(Calendar.DATE, nAmount);
		}else if(StringHelper.compare(strTimeoutType, IWFInteractiveProcessModel.TIMEOUTTYPE_WORKDAY, true)==0){
			throw new Exception("未实现 [工作日] 超时时间");
		}else{
			throw new Exception("没有超时类型");
		}
		return new Timestamp(calendar.getTime().getTime());
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#testIAAction(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void testIAAction(String strStepId, String strActionName, String strOpPersonId) throws Exception
	{
		throw new Exception("没有实现 testIAAction");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#execRawSql(java.lang.String)
	 */
	@Override
	public void execRawSql(String strSQL) throws Exception
	{
		this.executeRawSql(strSQL, null);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFActor(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFActor)
	 */
	@Override
	public void getWFActor(IWFActionContext2 iWFActionContext, WFActor wfActor) throws Exception
	{
		throw new Exception("没有实现 getWFActor");

	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFSystemUser(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void getWFSystemUser(IWFActionContext2 iWFActionContext, String strActorId, ArrayList<WFUser> list) throws Exception
	{
		throw new Exception("没有实现 getWFSystemUser");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#testStartWF(net.ibizsys.pswf.core.IWFActionContext2)
	 */
	@Override
	public boolean testStartWF(IWFActionContext2 iWFActionContext) throws Exception
	{
		throw new Exception("没有实现 testStartWF");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#testRestartWF(net.ibizsys.pswf.core.IWFActionContext2)
	 */
	@Override
	public boolean testRestartWF(IWFActionContext2 iWFActionContext) throws Exception
	{
		throw new Exception("没有实现 testRestartWF");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#testCancelWF(net.ibizsys.pswf.core.IWFActionContext2)
	 */
	@Override
	public boolean testCancelWF(IWFActionContext2 iWFActionContext) throws Exception
	{
		throw new Exception("没有实现 testCancelWF");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getEmbedWorkflows(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.pswf.core.IWFEmbedWFProcessModel, java.util.ArrayList)
	 */
	@Override
	public void getEmbedWorkflows(IWFActionContext2 iWFActionContext, IWFEmbedWFProcessModel iWFEmbedWorkflowModel, ArrayList<WFActionParam> wfParams) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
		IService iService = iDEModel.getService();
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), iWFActionContext.getActiveWFInstance().getUserData());
		// iService.get(dataEntity);
		
		java.util.Iterator<IWFProcSubWFModel> wfProcSubWFModels = iWFEmbedWorkflowModel.getWFProcSubWFModels();
		if(wfProcSubWFModels!=null)
		{
			while(wfProcSubWFModels.hasNext()){
				IWFProcSubWFModel iWFProcSubWFModel = wfProcSubWFModels.next();
				
				IDataEntityModel embedWFDEModel = DEModelGlobal.getDEModel(iWFProcSubWFModel.getDEName());
				IService embedWFDEService = embedWFDEModel.getService();

				DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
				deDataSetFetchContext.setPageSize(9999);
				deDataSetFetchContext.setActiveDataObject(dataEntity);
				// deDataSetFetchContext.setPageSize(1000);

				DBFetchResult dbFetchResult = embedWFDEService.fetchDataSet(iWFProcSubWFModel.getDEDSName(), deDataSetFetchContext);
				IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
				int nCachedRowCount = iDataTable.getCachedRowCount();
				for (int i = 0; i < nCachedRowCount; i++)
				{
					IDataRow iDataRow = iDataTable.getCachedRow(i);
					WFActionParam wfParam = new WFActionParam();
					wfParam.setWorkflowId(iWFProcSubWFModel.getWFId());
					wfParam.setUserData(DataObject.getStringValue(iDataRow.get(embedWFDEModel.getKeyDEField().getName()), null));
					wfParam.setUserData4(embedWFDEModel.getId());
					wfParam.setSuspendMode(iWFProcSubWFModel.isSuspendDefault());
					wfParams.add(wfParam);
				}
				
			}
		}

		

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getParallelSubWFs(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.pswf.core.IWFParallelSubWFProcessModel, java.util.ArrayList)
	 */
	@Override
	public void getParallelSubWFs(IWFActionContext2 iWFActionContext, IWFParallelSubWFProcessModel iWFParallelSubWFModel, ArrayList<WFActionParam> wfParams) throws Exception
	{
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
		IService iService = iDEModel.getService();
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), iWFActionContext.getActiveWFInstance().getUserData());
		// iService.get(dataEntity);
		
		java.util.Iterator<IWFProcSubWFModel> wfProcSubWFModels = iWFParallelSubWFModel.getWFProcSubWFModels();
		if(wfProcSubWFModels!=null)
		{
			while(wfProcSubWFModels.hasNext()){
				IWFProcSubWFModel iWFProcSubWFModel = wfProcSubWFModels.next();
				
				IDataEntityModel embedWFDEModel = DEModelGlobal.getDEModel(iWFProcSubWFModel.getDEName());
				IService embedWFDEService = embedWFDEModel.getService();

				DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
				deDataSetFetchContext.setPageSize(9999);
				deDataSetFetchContext.setActiveDataObject(dataEntity);
				// deDataSetFetchContext.setPageSize(1000);

				DBFetchResult dbFetchResult = embedWFDEService.fetchDataSet(iWFProcSubWFModel.getDEDSName(), deDataSetFetchContext);
				IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
				int nCachedRowCount = iDataTable.getCachedRowCount();
				for (int i = 0; i < nCachedRowCount; i++)
				{
					IDataRow iDataRow = iDataTable.getCachedRow(i);
					WFActionParam wfParam = new WFActionParam();
					wfParam.setWorkflowId(iWFProcSubWFModel.getWFId());
					wfParam.setWFVersionId(iWFProcSubWFModel.getWFVerId());
					wfParam.setUserData(DataObject.getStringValue(iDataRow.get(embedWFDEModel.getKeyDEField().getName()), null));
					//指定父数据
					wfParam.setUserData2(iWFActionContext.getActiveWFInstance().getUserData());
					wfParam.setUserData3(iWFActionContext.getActiveWFInstance().getUserData4());
					wfParam.setUserData4(embedWFDEModel.getId());
					wfParam.setConnection(CONNECTION_PARALLELSUBWF+":"+iWFProcSubWFModel.getWFId());
					wfParams.add(wfParam);
				}
				
			}
		};

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addWFStepInst(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepInst)
	 */
	@Override
	public void addWFStepInst(IWFActionContext2 iWFActionContext, WFStepInst wfStepInst) throws Exception
	{
		wfStepInst.remove(WFStepInst.FIELD_CLOSEFLAG);
		wfStepInst.remove(WFStepInst.FIELD_RETURNDATA);
		wfStepInstService.create(wfStepInst);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#closeWFStepInst(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepInst)
	 */
	@Override
	public void closeWFStepInst(IWFActionContext2 iWFActionContext, WFStepInst wfStepInst) throws Exception
	{
		wfStepInstService.update(wfStepInst);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepInstCount(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.lang.String)
	 */
	@Override
	public int getWFStepInstCount(IWFActionContext2 iWFActionContext, String strWFStepId, String strReturnValue) throws Exception
	{
		String strSql = StringHelper.format("select count(*) as RDCOUNT from t_srfwfSTEPINST where WFSTEPID='%1$s' AND CLOSEFLAG IS NOT NULL AND RETURNDATA ='%2$s'", strWFStepId, strReturnValue);
		SimpleEntity simpleEntity = new SimpleEntity();
		executeRawSql(strSql, null, simpleEntity);
		return DataObject.getIntegerValue(simpleEntity, "RDCOUNT", 0);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getWFStepInstCount(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String)
	 */
	@Override
	public int getWFStepInstCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception
	{
		String strSql = StringHelper.format("select count(*) as RDCOUNT from t_srfwfSTEPINST where WFSTEPID='%1$s' ", strWFStepId);
		SimpleEntity simpleEntity = new SimpleEntity();
		executeRawSql(strSql, null, simpleEntity);
		return DataObject.getIntegerValue(simpleEntity, "RDCOUNT", 0);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getUnfinishedWFStepInsts(net.ibizsys.pswf.core.IWFActionContext2, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void getUnfinishedWFStepInsts(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepInst> stepInsts) throws Exception
	{
		String strSql = "" ;
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSql = StringHelper.format("select closeflag,createdate,createman,returndata,updatedate,updateman,wfinstanceid,wfinstancename,wfstepid,wfstepinstid,wfstepinstname,wfsteplanrestag,wfstepname  from t_srfwfstepinst where wfstepid='%1$s' and closeflag is  null ", strWFStepId);
		}else {
			strSql = StringHelper.format("select *  from t_srfwfSTEPINST where WFSTEPID='%1$s' AND CLOSEFLAG IS  NULL ", strWFStepId);
		}
		executeRawSql(strSql, null, stepInsts, WFStepInst.class);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#updateCurWFStepActors(net.ibizsys.pswf.core.IWFActionContext2)
	 */
	@Override
	public void updateCurWFStepActors(IWFActionContext2 iWFActionContext) throws Exception
	{
		WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
		IDEWF iDEWF = iDEModel.getDEWF(this.getWFModel().getId());
		if (StringHelper.isNullOrEmpty(iDEWF.getWFActorsField()))
			return;

		// 查询用户明细
		String strSQL = "";
		SqlParamList callParamList = new SqlParamList();

		if(false)//此处处理并行流程代码有问题，未来要优化
	//	if (!StringHelper.isNullOrEmpty(wfInstance.getPWFInstanceId()) && DataObject.getBoolValue(wfInstance.getParallelInst(), false))
		{
			strSQL = "select t1.WFSTEPID,t1.WFSTEPACTORID,t1.WFSTEPACTORNAME,t2.WFUSERNAME,t2.WFUSERID,t3.WFINSTANCEID from t_srfwfstepactor t1 INNER JOIN T_SRFWFUSER t2 ON t1.ACTORID = t2.WFUSERID "
					+ " INNER JOIN T_SRFWFINSTANCE t3 ON t1.WFSTEPID = t3.ACTIVESTEPID AND  (t3.ISCLOSE IS  NULL OR t3.ISCLOSE <> 1) AND t3.PWFINSTANCEID = ? "
					+ " LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=t1.ACTORID and  t5.WFSTEPID = t3.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') "
					+ " where t5.WFSTEPDATAID IS NULL ";

			callParamList.addString(wfInstance.getPWFInstanceId());
		}
		else
		{
			strSQL = "select t1.WFSTEPID,t1.WFSTEPACTORID,t1.WFSTEPACTORNAME,t2.WFUSERNAME,t2.WFUSERID,t3.WFINSTANCEID from t_srfwfstepactor t1 INNER JOIN T_SRFWFUSER t2 ON t1.ACTORID = t2.WFUSERID "
					+ "INNER JOIN T_SRFWFINSTANCE t3 ON t1.WFSTEPID = t3.ACTIVESTEPID AND  (t3.ISCLOSE IS  NULL OR t3.ISCLOSE <> 1) AND  t3.WFINSTANCEID = ?"
					+ " LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=t1.ACTORID and  t5.WFSTEPID = t3.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') "
					+ " where t5.WFSTEPDATAID IS NULL ";
			callParamList.addString(wfInstance.getWFInstanceId());
		}

		ArrayList<DataObject> wfUserList = new ArrayList<DataObject>();
		executeRawSql(strSQL, callParamList, wfUserList, null);

		String strCurWFStepActors = "";
		HashMap<String, String> userMap = new HashMap<String, String>();
		// 合成字段
		for (DataObject wfUser : wfUserList)
		{
			if (bNoLogSystem)
			{
				// 不再当前步骤中出现SYSTEM账户
				if (StringHelper.compare(DataObject.getStringValue(wfUser.get("WFUSERID"), ""), USER_SYSTEM, true) == 0)
					continue;
			}

			String strStepActorName = DataObject.getStringValue(wfUser.get("WFSTEPACTORNAME"), "");
			String strUserName = DataObject.getStringValue(wfUser.get("WFUSERNAME"), "");
			String strStepActorId = DataObject.getStringValue(wfUser.get("WFUSERID"), "");

			String strCurWFStepActor = "";
			if ((StringHelper.compare(strStepActorName, strUserName, true) == 0) || (StringHelper.compare(strStepActorName, "WFSTEPACTORNAME", true) == 0))
			{
				strCurWFStepActor = strUserName;
			}
			else
			{
				strCurWFStepActor = StringHelper.format("(%1$s)%2$s", strStepActorName, strUserName);
			}

			if (userMap.containsKey(strCurWFStepActor))
			{
				continue;
			}

			// if (StringHelper.compare(this.strLogCurStepActorMode,
			// TAG_LOGCURSTEPACTOR_ADVANCE, true) == 0)
			// {
			// boolean bReadFlag = wfUser.GetParamIntValue("READFLAG", 0) == 1;
			// Date dtReadTime =
			// wfUser.GetParamDateValue(WFStepActor.TAG_FIRSTREADTIME, null);
			// String strWFStepId = wfUser.GetParamStringValue("WFSTEPID", "");
			// String strWFStepActorId =
			// wfUser.GetParamStringValue("WFSTEPACTORID", "");
			//
			// XMLNode stepActorNode = new XMLNode();
			// stepActorNode.setNodeName(CodeItemConfig.TAG_CODEITEM);
			// stepActorNode.SetValue(CodeItemConfig.TAG_VALUE, strStepActorId);
			// // stepActorNode.SetValue(CodeItemConfig.TAG_TEXT,
			// // strCurWFStepActor);
			// stepActorNode.SetValue(CodeItemConfig.TAG_TEXT, strUserName);
			// if (bReadFlag && dtReadTime != null)
			// {
			// stepActorNode.SetValue("READTIME",
			// DateParser.toDateTimeString(dtReadTime));
			// }
			// stepActorNode.SetValue("WFSTEPID", strWFStepId);
			// stepActorNode.SetValue("WFSTEPACTORID", strWFStepActorId);
			// curWFStepActorsNode.AddNode(stepActorNode);
			// }
			// else
			{
				if (!StringHelper.isNullOrEmpty(strCurWFStepActors))
				{
					strCurWFStepActors += ",";
				}
				strCurWFStepActors += strCurWFStepActor;
			}
		}


		// 重置当前操作用户
		IEntity userData = iDEModel.createEntity();
		userData.set(iDEModel.getKeyDEField().getName(), wfInstance.getUserData());
		userData.set(iDEWF.getWFActorsField(), strCurWFStepActors);
		userData.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());

		IService iService = iDEModel.getService();
		iService.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE, iWFActionContext, userData);
		
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#markWFStepActorReadFlag(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepActor)
	 */
	@Override
	public void markWFStepActorReadFlag(IWFActionContext2 iWFActionContext, WFStepActor wfStepActor) throws Exception
	{
		throw new Exception("没有实现 markWFStepActorReadFlag");

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getEmbedWorkflowReturnValue(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance, net.ibizsys.paas.entity.IEntity, net.ibizsys.pswf.core.IWFProcessModel)
	 */
	@Override
	public String getEmbedWorkflowReturnValue(IWFActionContext2 iWFActionContext, WFInstance childWFInstance2, IEntity dataEntity, IWFProcessModel iWFProcessModel) throws Exception
	{
		String strDEName = childWFInstance2.getUserData4();
		if (StringHelper.isNullOrEmpty(strDEName))
		{
			wfInstanceService.get(childWFInstance2);
			strDEName = childWFInstance2.getUserData4();
		}

		IDataEntityModel iEntityModel = DEModelGlobal.getDEModel(strDEName);
		IDEWF iDEWF = iEntityModel.getDEWF(childWFInstance2.getWFWorkflowId());
		return DataObject.getStringValue(dataEntity.get(iDEWF.getWFRetField()), null);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#addRawWFStepData(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepData)
	 */
	@Override
	public void addRawWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception
	{
		stepData.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		if (StringHelper.compare(stepData.getConnectionName(), WFServiceBase.TAG_SRFWFSTART, true) == 0)
		{
			// 替换步骤名称
			WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
			IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
			IDEWF iDEWF = iDEModel.getDEWF(wfInstance.getWFWorkflowId());
			// 放入第一步名称
			if (StringHelper.isNullOrEmpty(stepData.getWFStepDataName()))
			{
				String strWFStartName = iDEWF.getWFStartName();
				if(StringHelper.isNullOrEmpty(strWFStartName))
				{
					strWFStartName = 	"启动流程";				
				}
				stepData.setWFStepDataName(strWFStartName);
			}
		}
		if (StringHelper.isNullOrEmpty(stepData.getActorName()))
		{
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(stepData.getActorId());
			if(wfUserService.get(wfUser,true)){
				stepData.setActorName(wfUser.getWFUserName());
			}
			else{
				stepData.setActorName("未知用户");
			}
			
		}
		wfStepDataService.create(stepData);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#getLastWFStepData(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFStepData)
	 */
	@Override
	public void getLastWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception
	{
		WFInstance wfInstance = iWFActionContext.getActiveWFInstance();

		String strSQL = "" ;
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSQL = StringHelper.format("select t1.actorid,t1.actorname,t1.actorname2,t1.connectionname,t1.createdate,t1.createman,t1.memo,t1.nextto,t1.originalwfuserid,t1.originalwfusername,t1.sdparam,t1.sdparam2,t1.updatedate,t1.updateman,t1.userdata,t1.userdatadesc,t1.wfactionlanrestag,t1.wfinstanceid,t1.wfinstancename,t1.wfplogicname,t1.wfstepdataid,t1.wfstepdataname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t2.wfpname from t_srfwfstepdata t1 " + " left join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid "
					+ "  where t1.wfinstanceid='%1$s'  order by t1.updatedate desc", wfInstance.getWFInstanceId());
		}else {
			strSQL = StringHelper.format("SELECT T1.*,T2.WFPNAME FROM T_SRFWFSTEPDATA T1 " + " LEFT JOIN T_SRFWFSTEP T2 ON T1.WFSTEPID = T2.WFSTEPID "
					+ "  WHERE T1.WFINSTANCEID='%1$s'  ORDER BY T1.UPDATEDATE DESC", wfInstance.getWFInstanceId());
		}

		executeRawSql(strSQL, null, stepData);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDataCtrl#cancelStartWFInstance(net.ibizsys.pswf.core.IWFActionContext2, net.ibizsys.psrt.srv.wf.entity.WFInstance)
	 */
	@Override
	public void cancelStartWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception
	{

		IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
		IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());

		//关闭流程
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setEndTime(new java.sql.Timestamp((new java.util.Date()).getTime()));
		wfInstance.setIsClose(1);
		wfInstance.setIsCancel(1);
		wfInstance.setIsError(0);
		wfInstance.setCancelReason(instance.getCancelReason());
		wfInstance.setActiveStepId(null);
		wfInstance.setActiveStepName(null);
		wfInstance.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);

		//取消流程工作
		if (true)
		{
//			String strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE  CANCELFLAG=0 AND WFINSTANCEID=?");
//			SqlParamList sqlParamList = new SqlParamList();
//			sqlParamList.addDateTime(DateHelper.getCurTime());
//			sqlParamList.addString(instance.getWFInstanceId());
//			executeRawSql(strSQL, sqlParamList);
			cancelOnCancelStartWFInstance(instance);
		}
		

		//取消通知
		cancelSendWFStepActorInformMsg(iWFActionContext, instance);

		
		
		// 将数据进行查出，填充描述字段
		IEntity dataEntity = iDEModel.createEntity();
		dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());
		IService udService = iDEModel.getService();
		udService.get(dataEntity);
	//	if (!DataObject.getBoolValue(instance.getParallelInst(), false))
		if(true)
		{
			dataEntity.reset();
			dataEntity.set(iDEModel.getKeyDEField().getName(), instance.getUserData());

			// callResult = FillDataEntityParam(iDEModel, dataEntity,
			// dewf.getINITSET(), strOpPersonId);
			// if (callResult.getRetCode() != Errors.OK)
			// {
			// callResult.setRetCode(Errors.INTERNALERROR);
			// callResult.setErrorInfo(StringHelper.format("填充用户数据参数失败，%1$s",
			// callResult.getErrorInfo()));
			// log.error(callResult.getErrorInfo());
			//
			// this.RemoveWFInstance(instance, strOpPersonId);
			//
			// return callResult;
			// }

			String strWFInstDEF = iDEWF.getWFInstField();
			if (!StringHelper.isNullOrEmpty(strWFInstDEF))
			{
				dataEntity.set(strWFInstDEF, instance.getWFInstanceId());
			}
			String strWFStateDEF = iDEWF.getWFStateField();
			if (!StringHelper.isNullOrEmpty(strWFStateDEF))
			{
				dataEntity.set(strWFStateDEF, WFStates.NOTSTART);
			}

			// 清空流程步骤值					
			String strWFStepDEF = iDEWF.getWFStepField();					
			if (!StringHelper.isNullOrEmpty(strWFStepDEF))					
			{					
				dataEntity.set(strWFStepDEF, null);				
			}					
			
			// String strUDStateDEF = iDEWF.getUDStateField();
			// if (!StringHelper.isNullOrEmpty(strUDStateDEF) &&
			// !StringHelper.isNullOrEmpty(iDEWF.getEntityWFState()))
			// {
			// dataEntity.set(strUDStateDEF, iDEWF.getEntityWFState());
			// }

			udService.updateWFInfo(IService.UPDATEWFINFOMODE_CANCELSTART, iWFActionContext, dataEntity);
		}

	}
	
	protected void cancelOnCancelStartWFInstance(WFInstance wfInstance) throws Exception {
		wfWorkListService.cancelByWFInstance(wfInstance);
	}

	/**
	 * 重新计算接收工作的流程用户
	 * @param strWFUserId
	 * @param wfUser
	 * @return
	 */
	protected WFUser reCalcRecvWorkWFUser(String strWFUserId) throws Exception
	{
		WFUser wfUserCur = new WFUser();
		wfUserCur.setWFUserId(strWFUserId);
		if(!wfUserService.get(wfUserCur,true))
		{
			throw new WFException(WFErrors.E_000034,getLocalization(WFLanResTags.MSG_E_000034, new Object[]{strWFUserId}, StringHelper.format("找不到指定工作流用户[%1$s]",strWFUserId)));
		}
		if(!DataObject.getBoolValue(wfUserCur.getValidFlag(),true))
		{
			throw new WFException(WFErrors.E_000033,getLocalization(WFLanResTags.MSG_E_000033, new Object[]{wfUserCur.getWFUserName()} , StringHelper.format("工作流用户[%1$s]没有启用",wfUserCur.getWFUserName())));
		}
		
		if(DataObject.getBoolValue(wfUserCur.getIsRecvWork(),true))
		{
			return wfUserCur;
		}
		
		// 继续
		String strSql = "";
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSql = StringHelper.format("select t1.createdate,t1.createman,t1.isrecvwork,t1.memo,t1.recvinform,t1.updatedate,t1.updateman,t1.validflag,t1.wfuserid,t1.wfusername from t_srfwfuser t1 " + " inner join t_srfwfusercandidate t2 on t2.wfminoruserid = t1.wfuserid "
					+ "	where (t1.isrecvwork is null or t1.isrecvwork=1 ) and (t1.validflag is null or t1.validflag = 1 ) and  t2.wfmajoruserid=?  order by t2.candidateorder ");
		}else {
			strSql = StringHelper.format("select t1.* from T_SRFWFUSER t1 " + " INNER JOIN T_SRFWFUSERCANDIDATE t2 on t2.WFMINORUSERID = t1.WFUSERID "
					+ "	where (t1.ISRECVWORK IS NULL OR t1.ISRECVWORK=1 ) AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1 ) and  t2.WFMAJORUSERID=?  ORDER BY t2.CANDIDATEORDER ");
		}
		try
		{
			SqlParamList sqlParamList = new SqlParamList();
			sqlParamList.addString(strWFUserId);
			WFUser wfUser = new WFUser();
			executeRawSql(strSql, sqlParamList, wfUser);
			return wfUser;
		}
		catch (Exception ex)
		{
			ex = getExceptionRealCause(ex);
			if (ex instanceof ErrorException)
			{
				ErrorException errorException = (ErrorException) ex;
				if (errorException.getErrorCode() != Errors.INVALIDDATA)
				{
					throw ex;
				}
				throw new WFException(WFErrors.E_000035,getLocalization(WFLanResTags.MSG_E_000035, new Object[]{wfUserCur.getWFUserName()} ,StringHelper.format("工作流用户[%1$s]不接收工作，且没有指定待办用户",wfUserCur.getWFUserName())));
			}
			else
				throw ex;
		}
	}


	/**
	 * 取消发送给用户的通知信息
	 * @param iWFActionContext
	 * @param wfInstane
	 * @throws Exception
	 */
	protected void cancelSendWFStepActorInformMsg(IWFActionContext2 iWFActionContext, WFInstance wfInstane) throws Exception
	{

	}

	/**
	 * 获取Session会话
	 * 
	 * @return
	 */
	protected SessionFactory getSessionFactory()
	{
		return ((ISystemRuntime) this.getWFModel().getSystemModel()).getSessionFactory();
	}

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	protected Session getCurrentSession() throws Exception
	{
		return SessionFactoryManager.getCurrentSession(this.getSessionFactory());
	}


	/**
	 * 执行SQL
	 * @param strSQL
	 * @param sqlParamList
	 * @param dataObject
	 * @throws Exception
	 */
	protected void executeRawSql(String strSQL, SqlParamList sqlParamList, DataObject dataObject) throws Exception
	{
		Session session = this.getCurrentSession();
		log.debug(StringHelper.format("执行SQL\r\n%1$s", strSQL));

		final SqlParamList sqlParamList2 = sqlParamList;
		final String strSQL2 = strSQL;
		final DataObject dataObject2 = dataObject;

		session.doWork(new Work()
		{
			@Override
			public void execute(Connection connection) throws SQLException
			{
				try
				{
					DBCallResult dbCallResult = getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
					if (dbCallResult.isOk())
					{
						dbCallResult.getDataSet().cacheDataRow();
					}
					if (dbCallResult.isError())
					{
						throw new ErrorException(Errors.INTERNALERROR, dbCallResult.getErrorInfo());
					}

					if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0)
					{
						throw new ErrorException(Errors.INVALIDDATA);
					}

					DataObject.fromDataRow(dataObject2, dbCallResult.getDataSet().getDataTable(0).getCachedRow(0));

				}
				catch (Exception e)
				{
					throw new SQLException(e);
				}
			}
		});
	}


	/**
	 * 执行SQL
	 * @param strSQL
	 * @param sqlParamList
	 * @param list
	 * @param classType
	 * @throws Exception
	 */
	protected void executeRawSql(String strSQL, SqlParamList sqlParamList, ArrayList list, Class classType) throws Exception
	{
		Session session = this.getCurrentSession();
		log.debug(StringHelper.format("执行SQL\r\n%1$s", strSQL));

		final SqlParamList sqlParamList2 = sqlParamList;
		final String strSQL2 = strSQL;
		final Class classType2 = classType;
		final ArrayList arrayList = list;

		session.doWork(new Work()
		{
			@Override
			public void execute(Connection connection) throws SQLException
			{
				try
				{
					DBCallResult dbCallResult = getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
					if (dbCallResult.isOk())
					{
						dbCallResult.getDataSet().cacheDataRow();
					}
					if (dbCallResult.isError())
					{
						throw new ErrorException(Errors.INTERNALERROR, dbCallResult.getErrorInfo());
					}

					IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
					int nRows = iDataTable.getCachedRowCount();
					for (int i = 0; i < nRows; i++)
					{
						IDataRow iDataRow = iDataTable.getCachedRow(i);
						DataObject dataObject = null;
						if (classType2 == null)
						{
							dataObject = new DataObject();
						}
						else
						{
							dataObject = (DataObject) ObjectHelper.create(classType2);
						}
						DataObject.fromDataRow(dataObject, iDataRow);
						arrayList.add(dataObject);
					}
				}
				catch (Exception e)
				{
					throw new SQLException(e);
				}
			}
		});
	}


	/**
	 * 执行SQL
	 * @param strSQL
	 * @param sqlParamList
	 * @throws Exception
	 */
	protected void executeRawSql(String strSQL, SqlParamList sqlParamList) throws Exception
	{
		Session session = this.getCurrentSession();
		log.debug(StringHelper.format("执行SQL\r\n%1$s", strSQL));

		final SqlParamList sqlParamList2 = sqlParamList;
		final String strSQL2 = strSQL;

		session.doWork(new Work()
		{
			@Override
			public void execute(Connection connection) throws SQLException
			{
				try
				{
					DBCallResult dbCallResult = getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
					if (dbCallResult.isOk() && dbCallResult.getDataSet()!=null)
					{
						dbCallResult.getDataSet().close();
					}
					
					if (dbCallResult.isError())
					{
						throw new ErrorException(Errors.INTERNALERROR, dbCallResult.getErrorInfo());
					}
				}
				catch (Exception e)
				{
					throw new SQLException(e);
				}
			}
		});
	}

	/**
	 * 获取数据库适配器
	 * 
	 * @return
	 */
	protected IDBDialect getDBDialect()
	{
		return ((ISystemRuntime) this.getWFModel().getSystemModel()).getDBDialect();
	}

	
	/**
	 * 获取异常实际原因
	 * @param ex
	 * @return
	 */
	protected Exception getExceptionRealCause(Exception ex) 
	{
		if(ex.getCause()==null)
			return ex;
		
		Throwable throwable = ex.getCause();
		if(throwable instanceof Exception)
		{
			return getExceptionRealCause((Exception)throwable);
		}
		return ex;
	}
	
	/**
	 * 获取系统运行时
	 * @return
	 */
	protected ISystemRuntime getSystemRuntime() {
		return (ISystemRuntime) this.getWFModel().getSystemModel();
	}
	
	/**
	 * 获取本地化语言
	 * 
	 * @return
	 */
	protected String getLocalization() {
		if (WebContext.getCurrent() != null) {
			return WebContext.getCurrent().getLocalization();
		}
		return this.getSystemRuntime().getLocalization();
	}

	
	
	/**
	 * 获取本地化内容
	 * @param strResId
	 * @param params
	 * @param strDefault
	 * @return
	 */
	protected String getLocalization(String strResId,  Object[] params, String strDefault) {
		if (WebContext.getCurrent() != null) {
			return WebContext.getCurrent().getLocalization(strResId, params, strDefault);
		}
		return strDefault;
	}
	
	
	/**
	 * 获取本地化内容
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	protected String getLocalization(String strResId, String strDefault) {
		if (WebContext.getCurrent() != null) {
			return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
		}
		return strDefault;
	}

	@Override
	public void suspendWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
		wfInstanceService.get(instance);
		if (DataObject.getBoolValue(instance.getIsClose(), false))
		{
			throw new Exception("工作流实例已经关闭，无法挂起");
		}
		
		if (DataObject.getBoolValue(instance.getSuspendFlag(), false))
		{
			throw new Exception("工作流实例已经挂起，无法再次挂起");
		}

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setSuspendFlag(1);
		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);
	}

	@Override
	public void resumeWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
		wfInstanceService.get(instance);
		if (DataObject.getBoolValue(instance.getIsClose(), false))
		{
			throw new Exception("工作流实例已经关闭，无法继续");
		}
		
		if (!DataObject.getBoolValue(instance.getSuspendFlag(), false))
		{
			throw new Exception("工作流实例没有被挂起，无法继续");
		}

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(instance.getWFInstanceId());
		wfInstance.setSuspendFlag(0);
		wfInstanceService.update(wfInstance);
		wfInstance.copyTo(instance, true);
	}
}
