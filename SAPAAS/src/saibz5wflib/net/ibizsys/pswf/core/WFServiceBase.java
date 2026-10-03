package net.ibizsys.pswf.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.HibernateTransaction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
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
import net.ibizsys.pswf.i18n.WFLanResTags;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

/**
 * 流程服务对象基类
 * 
 * @author lionlau
 * 
 */
public abstract class WFServiceBase implements IWFService,IWFService2
{
	private static final Log log = LogFactory.getLog(WFServiceBase.class);

	private IWFDataCtrl iWFDataCtrl = null;
	
	private IWFDataCtrl2 iWFDataCtrl2 = null;

	/**
	 * 用户类型，来自工作流的操作者
	 */
	public final static int ACTORTYPE_WFACTOR = 1;

	/**
	 * 用户类型，来自用户数据的操作者
	 */
	public final static int ACTORTYPE_UDACTOR = 2;

	/**
	 * 正常退出
	 */
	public final static int CLOSEFLAG_NORMAL = 0;

	/**
	 * 被外部关闭
	 */
	public final static int CLOSEFLAG_USERCLOSE = 1;

	public static final String TAG_SRFWFIAGOTO = "SRFWFIAGOTO";

	/**
	 * 流程超时操作
	 */
	public static final String TAG_SRFWFTIMEOUT = "SRFWFTIMEOUT";

	/**
	 * 流程启动
	 */
	public static final String TAG_SRFWFSTART = "SRFWFSTART";

	/**
	 * 流程重启动
	 */
	public static final String TAG_SRFWFRESTART = "SRFWFRESTART";

	/**
	 * 流程撤回
	 */
	public static final String TAG_SRFWFROLLBACK = "SRFWFROLLBACK";

	/**
	 * 嵌入工作流返回值（用户关闭）
	 */
	public final static String EMBEDWFRETURN_USERCLOSE = "%%SRF_USERCLOSE%%";

	
	/**
	 * 流程挂起
	 */
	public static final String TAG_SRFWFSUSPEND = "SRFWFSUSPEND";
	
	/**
	 * 流程继续
	 */
	public static final String TAG_SRFWFRESUME = "SRFWFRESUME";

	/**
	 * 引擎线程
	 * @author LionLau
	 */
	private class WFServiceThread extends Thread
	{
		protected IWFProcessModel iWFProcessModel = null;

		protected WFActionContext wfActionContext = null;

		protected IWebContext iWebContext = null;
		
		public WFServiceThread(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel)
		{
			this.wfActionContext = wfActionContext;
			this.iWFProcessModel = iWFProcessModel;
			if(WebContext.getCurrent()!=null){
				SimpleWebContext simpleWebContext = new SimpleWebContext();
				simpleWebContext.cloneSession(WebContext.getCurrent());
				simpleWebContext.setSessionValue(IWebContext.PERSONID,WebContext.getCurrent().getCurUserId());
				simpleWebContext.setSessionValue(IWebContext.USERNAME,WebContext.getCurrent().getCurUserName());
				this.iWebContext = simpleWebContext;
			}
		}

		@Override
		public void run()
		{
			try
			{
				ServiceWorkHelper.getInstance(this.iWebContext).execute(new IServiceWork() {
					@Override
					public void execute(ITransaction iTransaction) throws Exception {
						wfActionContext.setThreadMode(true);
						internalExecute(wfActionContext, iWFProcessModel);
					}
				});
				
			}
			catch (Exception ex)
			{
				log.error(ex.getMessage(), ex);
			}
		}
	}

	
	private IWFModel iWFModel = null;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#init(net.ibizsys.pswf.core.IWFModel)
	 */
	@Override
	public void init(IWFModel iWFModel) throws Exception
	{
		this.iWFModel = iWFModel;
		
		this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				iWFDataCtrl = createWFDataCtrl();
				iWFDataCtrl.init(getWFModel());
				if(iWFDataCtrl instanceof IWFDataCtrl2){
					iWFDataCtrl2 = (IWFDataCtrl2) iWFDataCtrl;
				}
				return null;
			}
		});
	}
	
	
	
	/**
	 * 建立数据访问对象
	 * @return
	 * @throws Exception
	 */
	protected IWFDataCtrl createWFDataCtrl()throws Exception
	{
		return new WFDataCtrl();
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

	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	protected ISystemModel getSystemModel()
	{
		return this.getWFModel().getSystemModel();
	}
	


	/**
	 * 获取Session会话工厂
	 * @return
	 */
	public SessionFactory getSessionFactory()
	{
		return ((ISystemRuntime) getSystemModel()).getSessionFactory();
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#start(net.ibizsys.pswf.core.WFActionParam)
	 */
	@Override
	public WFActionResult start(WFActionParam wfParam) throws Exception
	{
		final WFActionParam wfActionParam = wfParam;

		log.debug("开始[start]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);

				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, true);
				if (wfInstance != null)
				{
					throw new WFException(WFErrors.E_000001,getLocalization(WFLanResTags.MSG_E_000001, new Object[]{iEntity.get("srfdatainfo")},  StringHelper.format("数据[%1$s]流程已经存在",iEntity.get("srfdatainfo"))));
				}

				// 获取流程版本
				if(StringHelper.isNullOrEmpty(wfActionParam.getWFVersionId())){
					//最新流程版本
					wfActionContext.setWFVersionModel(getWFModel().getLastWFVersionModel(wfActionParam.getWFMode()));
				}
				else{
					wfActionContext.setWFVersionModel(getWFModel().getWFVersionModel(wfActionParam.getWFVersionId()));
				}
				
				if (!testStart(wfActionContext))
				{
					throw new WFException(WFErrors.E_000002,getLocalization(WFLanResTags.MSG_E_000002, new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format("数据[%1$s]流程启动检查失败", iEntity.get("srfdatainfo"))));
				}

				// 建立数据实例
				wfInstance = new WFInstance();
				wfInstance.setWFInstanceId(KeyValueHelper.genGuidEx());
				wfInstance.setWFInstanceName(StringHelper.format("%1$s[%2$s]", getWFModel().getName(), DateHelper.toDateTimeString(new Date())));
				wfInstance.setPWFInstanceId(wfActionParam.getPInstanceId());
				wfInstance.setPStepId(wfActionParam.getStepId());
				// wfInstance.setWFWorkflowId(wfActionParam.getWFWorkflowId());
				wfInstance.setWFWorkflowId(getWFModel().getId());
				wfInstance.setWFVersion(wfActionContext.getWFVersionModel().getWFVersion());
				wfInstance.setUserData(wfActionParam.getUserData());
				wfInstance.setUserData2(wfActionParam.getUserData2());
				wfInstance.setUserData3(wfActionParam.getUserData3());
				wfInstance.setUserData4(wfActionParam.getUserData4());
				wfInstance.setUserDataInfo(DataObject.getStringValue(iEntity,IDataItem.MAJORTEXTITEM,null));
				wfInstance.setOrgId(DataObject.getStringValue(iEntity,IWFDataCtrl.USERENTITY_ORGID,null));
				wfInstance.setOrgName(DataObject.getStringValue(iEntity,IWFDataCtrl.USERENTITY_ORGNAME,null));
				wfInstance.setOwner(wfActionParam.getOpPersonId());
				wfInstance.setImportanceFlag(0);
				// wfInstance.setWFMODEL(workflow.getWFMODEL());
				if (!StringHelper.isNullOrEmpty(wfActionParam.getConnection()))
				{
					if (wfActionParam.getConnection().indexOf(WFDataCtrl.CONNECTION_PARALLELSUBWF) == 0)
					{
						wfInstance.setParallelInst(1);
						wfInstance.setUserTag(wfActionParam.getConnection().substring(14));
					}
				}
				if(wfActionParam.isSuspendMode()){
					wfInstance.setSuspendFlag(1);
				}
				getWFDataCtrl().addWFInstance(wfActionContext, wfInstance);
				

				wfActionContext.setActiveWFInstance(wfInstance);
				wfActionParam.setInstanceId(wfInstance.getWFInstanceId());

				if (!DataObject.getBoolValue(wfInstance.getParallelInst(), false))
				{
					// 判断该步骤是否包括制定处理
					WFStepData stepData = new WFStepData();
					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_START,"启动流程");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_START);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_START);
					stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
					stepData.setConnectionName(TAG_SRFWFSTART);
					stepData.setWFInstanceId(wfInstance.getWFInstanceId());
					stepData.setActorId(wfActionContext.getOpPersonId());
					stepData.setActorName(wfActionContext.getOpPersonName());
					getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);

				}

				
				if(!wfActionParam.isSuspendMode()){
					//开始执行，处于非挂起模式，开始执行
					internalExecute(wfActionContext, null);
				}
				else{
					WFStepData stepData = new WFStepData();
					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_SUSPEND,"流程挂起");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_SUSPEND);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_SUSPEND);
					stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
					stepData.setConnectionName(TAG_SRFWFSUSPEND);
					stepData.setWFInstanceId(wfInstance.getWFInstanceId());
					stepData.setActorId(wfActionContext.getOpPersonId());
					stepData.setActorName(wfActionContext.getOpPersonName());
					getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
				}
				
				return wfActionContext.createWFActionResult();
			}

		});

	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#submit(net.ibizsys.pswf.core.WFActionParam)
	 */
	@Override
	public WFActionResult submit(WFActionParam wfParam) throws Exception
	{
		final WFActionParam wfActionParam = wfParam;

		log.debug("开始[submit]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				if (!StringHelper.isNullOrEmpty(wfActionContext.getUserTag()))
				{
					wfActionContext.getNextIAStepActorMap().clear();
					String[] actorids = wfActionContext.getUserTag().split("[;]");
					for (int i = 0; i < actorids.length; i++)
					{
						if (!StringHelper.isNullOrEmpty(actorids[i]))
							wfActionContext.getNextIAStepActorMap().put(actorids[i], "");
					}
				}

				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);


				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000003,getLocalization(WFLanResTags.MSG_E_000003, new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行交互处理", iEntity.get("srfdatainfo"))));
				}

				// 判断当前步骤是否一致
				if (StringHelper.compare(wfActionParam.getStepId(), wfInstance.getActiveStepName(), true) != 0)
				{
					throw new WFException(WFErrors.E_000004,getLocalization(WFLanResTags.MSG_E_000004, new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName())));
				}

				String strCurWFStepId = wfInstance.getActiveStepId();
				
				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);

				wfActionContext.setActiveWFInstance(wfInstance);
				wfActionContext.setWFVersionModel(iWFVersionModel);

				// 判断该步骤是否包括制定处理
				WFStepData stepData = new WFStepData();
				stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
				//此处代码故意放错，用于传入给testWFStepData
				stepData.setWFStepId(wfActionParam.getStepId());
				stepData.setConnectionName(wfActionParam.getConnection());
				stepData.setMemo(wfActionParam.getDescription());
				stepData.setWFInstanceId(wfInstance.getWFInstanceId());

				boolean bNoConnection = false;
				if (curWFProcessModel instanceof IWFInteractiveProcessModel)
				{
					IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel) curWFProcessModel;

					if (!StringHelper.isNullOrEmpty(wfActionContext.getUserTag2()))
					{
						ArrayList<WFUserAssist> userAssists = new ArrayList<WFUserAssist>();
						getWFDataCtrl().getWFUserAssists(wfActionContext, wfActionContext.getUserTag2(), wfActionContext.getOpPersonId(), userAssists);
		

						// 判断是否使用代办模式
						if (true)
						{
							WFUserAssist userAssist = new WFUserAssist();
							getWFDataCtrl().getWFUserAssist(wfActionContext, wfActionContext.getUserTag2(), wfActionContext.getOpPersonId(), userAssist);
							

							userAssists.add(userAssist);
						}
						if (userAssists.size() == 0)
						{
							throw new WFException(WFErrors.E_000005,getLocalization(WFLanResTags.MSG_E_000005, null,StringHelper.format("当前用户不在指定的代办用户范围")));
						}

						boolean bTestOK = false;
						for (WFUserAssist userAssist : userAssists)
						{
							// 判断是否具备权限
							String strWFStep = userAssist.getWFStep();
							if (!StringHelper.isNullOrEmpty(strWFStep))
							{
								String[] step = strWFStep.split("[;]");
								for (int i = 0; i < step.length; i++)
								{
									String strStep = step[i];
									if (StringHelper.compare(strStep, "*", true) == 0)
									{
										bTestOK = true;
										break;
									}

									if (StringHelper.compare(strStep, iaProcessConfig.getWFStepValue(), true) == 0)
									{
										bTestOK = true;
										break;
									}
								}

								if (bTestOK)
								{
									wfActionContext.setOpPersonId(userAssist.getWFMajorUserId());
									stepData.setSDParam2(userAssist.getWFMinorUserId());
									break;
								}
							}
							else
							{
								bTestOK = true;
								wfActionContext.setOpPersonId(userAssist.getWFMajorUserId());
								stepData.setSDParam2(userAssist.getWFMinorUserId());
								break;
							}
						}

						if (!bTestOK)
						{
							throw new WFException(WFErrors.E_000006,getLocalization(WFLanResTags.MSG_E_000006,null,StringHelper.format("当前用户不能为工作用户代办指定事项")));
						}
					}

					if (StringHelper.isNullOrEmpty(wfActionParam.getConnection()))
					{
						if (wfActionParam.isTestMode())
						{
							bNoConnection = true;
							if (iaProcessConfig.getWFInteractiveLinkModels() == null)
							{
								throw new WFException(WFErrors.E_000007,getLocalization(WFLanResTags.MSG_E_000007,null,StringHelper.format("没有找到任何交互操作")));
							}

							IWFInteractiveLinkModel iWFInteractiveLinkModel = null;
							java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
							while (wfInteractiveLinkModels.hasNext())
							{
								iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
								break;
							}

							if (iWFInteractiveLinkModel == null)
							{
								throw new WFException(WFErrors.E_000007,getLocalization(WFLanResTags.MSG_E_000007, null,StringHelper.format("没有找到任何交互操作")));
							}
							//处理步骤操作多语言
							String strLogicName = iWFInteractiveLinkModel.getLogicName();
							String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
							if(!StringHelper.isNullOrEmpty(strLNLanResTag)){
								stepData.setWFActionLanResTag(strLNLanResTag);
								strLogicName = getLocalization(strLNLanResTag, strLogicName);
							}
							stepData.setWFStepDataName(strLogicName);
							//处理步骤多语言
							String strWFStepName = curWFProcessModel.getName();
							String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
							if(!StringHelper.isNullOrEmpty(strWFStepLanResTag)){
								stepData.setWFStepLanResTag(strWFStepLanResTag);
								strWFStepName = getLocalization(strWFStepLanResTag,strWFStepName);
							}
							stepData.setWFPLogicName(strWFStepName);

							if(!StringHelper.isNullOrEmpty(iWFInteractiveLinkModel.getActionField()))
							{
								String strActionValue = DataObject.getStringValue(iEntity, iWFInteractiveLinkModel.getActionField(), null);
								String strActionLanResTag = "";
								if(!StringHelper.isNullOrEmpty(strActionValue))
								{
									ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
									if(codeList != null)
									{
										strActionValue = getCodeItemText(codeList, strActionValue);
										String strCodeItemLanResTag = getCodeItemLanResTag(codeList, strActionValue);
										if(!StringHelper.isNullOrEmpty(strCodeItemLanResTag)) {
											stepData.setWFActionLanResTag(strActionLanResTag);
											strActionValue = getLocalization(strCodeItemLanResTag, strActionValue);
										}
									}
									if(!StringHelper.isNullOrEmpty(strActionValue)){
										stepData.setWFStepDataName(strActionValue);
									}
										
								}
							}
							stepData.setConnectionName(iWFInteractiveLinkModel.getName());
						}
					}
					else
					{
						IWFInteractiveLinkModel iWFInteractiveLinkModel = iaProcessConfig.getWFInteractiveLinkModel(wfActionParam.getConnection(), true);
						if (iWFInteractiveLinkModel != null)
						{
							//处理步骤操作多语言
							String strLogicName = iWFInteractiveLinkModel.getLogicName();
							String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
							if(!StringHelper.isNullOrEmpty(strLNLanResTag)){
								stepData.setWFActionLanResTag(strLNLanResTag);
								strLogicName = getLocalization(strLNLanResTag, strLogicName);
							}
							stepData.setWFStepDataName(strLogicName);
							//处理步骤多语言
							String strWFStepName = curWFProcessModel.getName();
							String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
							if(!StringHelper.isNullOrEmpty(strWFStepLanResTag)){
								stepData.setWFStepLanResTag(strWFStepLanResTag);
								strWFStepName = getLocalization(strWFStepLanResTag,strWFStepName);
							}
							stepData.setWFPLogicName(strWFStepName);
							
							if(!StringHelper.isNullOrEmpty(iWFInteractiveLinkModel.getActionField()))
							{
								String strActionValue = DataObject.getStringValue(iEntity, iWFInteractiveLinkModel.getActionField(), null);
								String strActionLanResTag = "";
								if(!StringHelper.isNullOrEmpty(strActionValue))
								{
									ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
									if(codeList != null)
									{
										strActionValue = getCodeItemText(codeList, strActionValue);
										String strCodeItemLanResTag = getCodeItemLanResTag(codeList, strActionValue);
										if(!StringHelper.isNullOrEmpty(strCodeItemLanResTag)) {
											stepData.setWFActionLanResTag(strActionLanResTag);
											strActionValue = getLocalization(strCodeItemLanResTag, strActionValue);
										}
									}
									if(!StringHelper.isNullOrEmpty(strActionValue)){
										stepData.setWFStepDataName(strActionValue);
									}
										
								}
							}
							
							if (!wfActionParam.isTestMode())
							{
								//附加操作者
								internalPrepareIAAddedWFStepActor(wfActionContext,iaProcessConfig,iWFInteractiveLinkModel);
							}
						}
					}
				}

				stepData.setActorId(wfActionContext.getOpPersonId());
				stepData.setActorName(wfActionContext.getOpPersonName());
				if (wfActionParam.isTestMode())
				{
					getWFDataCtrl().testWFStepData(wfActionContext, stepData);
					
					WFActionResult wfActionResult = new WFActionResult();
					wfActionResult.setInstanceId(wfInstance.getWFInstanceId());
					return wfActionResult;
				}
				
				

				getWFDataCtrl().addWFStepData(wfActionContext, stepData);
				

				getWFDataCtrl().updateCurWFStepActors(wfActionContext);
				

				// 进一步判断是否能够继续下一个处理
				WFIAAction iaAction = new WFIAAction();
				getWFDataCtrl().getWFIAAction(wfActionContext, stepData.getWFStepId(), stepData.getConnectionName(), iaAction);
				

				int nCount = getWFDataCtrl().getWFStepDataCount(wfActionContext, stepData.getWFStepId(), stepData.getConnectionName());
				

				boolean bGoNext = false;

				String strNextCondition = iaAction.getNextCondition();

				// 支持进一步扩展条件
				// ANY|ROLE|C1;C2;C3
				String[] conds = strNextCondition.split("[|]");
				if (conds.length >= 1)
					strNextCondition = conds[0];

				if (StringHelper.compare(strNextCondition, "UDF", true) == 0)
				{
					// 用户数据属性
					if (conds.length < 2)
					{
						throw new WFException(WFErrors.E_000018,getLocalization(WFLanResTags.MSG_E_000018, null,StringHelper.format("没有指定用户数据属性")));
					}

					String strFieldName = conds[1];
					String strDefault = "ANY";
					if (conds.length >= 3)
					{
						strDefault = conds[2];
					}

					strNextCondition = DataObject.getStringValue(wfActionContext.getActiveEntity(), strFieldName, strDefault);
					conds = strNextCondition.split("[|]");
					if (conds.length >= 1)
						strNextCondition = conds[0];
				}

				if (StringHelper.compare(strNextCondition, "CUSTOM", true) == 0)
				{
					throw new WFException(WFErrors.E_000019,getLocalization(WFLanResTags.MSG_E_000019,null,StringHelper.format("暂时不支持自定义连接")));

				}
				else
				{
					boolean bRoleMode = false;
					String strRoleNextCond = "ANY";
					TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
					// 判断是否为角色模式
					if (conds.length >= 2)
					{
						String strRoleCond = conds[1];
						String role[] = strRoleCond.split("[;]");
						if (StringHelper.compare(role[0], "ROLE", true) == 0)
						{
							bRoleMode = true;
						}

						if (role.length >= 2)
							strRoleNextCond = role[1];

					}

					// 判断是否预计其它操作
					if (conds.length >= 3)
					{
						String strOtherIA = conds[2];
						strOtherIA = strOtherIA.toUpperCase();
						if (!StringHelper.isNullOrEmpty(strOtherIA))
						{
							String[] ias = strOtherIA.split("[;]");
							for (int i = 0; i < ias.length; i++)
							{
								if (StringHelper.compare(ias[i], stepData.getConnectionName(), true) == 0)
									continue;
								otherIAMap.put(ias[i], 0);
							}
						}
					}

					if (bRoleMode)
					{
						ArrayList<WFStepActor> stepActorList = new ArrayList<WFStepActor>();
						getWFDataCtrl().getWFStepActors(wfActionContext, stepData.getWFStepId(), stepActorList);
						

						ArrayList<WFStepData> stepDataList = new ArrayList<WFStepData>();
						getWFDataCtrl().getWFStepDatas(wfActionContext, stepData.getWFStepId(), stepDataList);
						

						TreeMap<String, Integer> roleCountMap = new TreeMap<String, Integer>();
						TreeMap<String, String> actorRoleMap = new TreeMap<String, String>();
						for (WFStepActor wfStepActor : stepActorList)
						{
							String strRoleId = wfStepActor.getRoleId();
							int nCurCount = 0;
							if (roleCountMap.containsKey(strRoleId))
								nCurCount = roleCountMap.get(strRoleId);
							nCurCount++;
							roleCountMap.put(strRoleId, nCurCount);

							actorRoleMap.put(wfStepActor.getActorId(), wfStepActor.getRoleId());
						}

						TreeMap<String, TreeMap<String, Integer>> roleStepCountMap = new TreeMap<String, TreeMap<String, Integer>>();

						for (String strRoleId : roleCountMap.keySet())
						{
							roleStepCountMap.put(strRoleId, new TreeMap<String, Integer>());
						}

						String strCurRoleId = "";
						for (WFStepData wfStepData : stepDataList)
						{
							String strRoleId = actorRoleMap.get(wfStepData.getActorId());
							TreeMap<String, Integer> roleActionMap = roleStepCountMap.get(strRoleId);
							int nCurCount = 0;
							if (roleActionMap.containsKey(wfStepData.getConnectionName()))
							{
								nCurCount = roleActionMap.get(wfStepData.getConnectionName());
							}
							roleActionMap.put(wfStepData.getConnectionName(), nCurCount + 1);

							if (StringHelper.compare(wfStepData.getActorId(), stepData.getActorId(), true) == 0)
							{
								strCurRoleId = strRoleId;
							}

						}

						nCount = 0;

						// 分析每个步骤在当前操作的情况
						for (String strRoleId : roleCountMap.keySet())
						{
							if (testRoleConnection(stepData.getConnectionName(), roleCountMap.get(strRoleId), roleStepCountMap.get(strRoleId), strRoleNextCond, ""))
							{
								nCount++;
								if (StringHelper.compare(strCurRoleId, strRoleId, true) == 0)
								{
									// 执行清除操作
									getWFDataCtrl().removeNoDataWFStepActor(wfActionContext, stepData.getWFStepId(), strCurRoleId);
								}
							}
						}
						if (StringHelper.compare(strNextCondition, "ANY", true) == 0)
						{
							if (nCount > 0)
							{
								// 该步骤可以完成
								bGoNext = true;
							}
						}
						else
						{
							int nActionCount = -1;
							int nRoleCount = (Integer) roleCountMap.size();
							double fPercent = 0;
							if (StringHelper.compare(strNextCondition, "ALL", true) == 0)
							{
								nActionCount = nRoleCount;
							}
							else
							{
								if (strNextCondition.indexOf("%") != -1)
								{
									strNextCondition = strNextCondition.replaceAll("[%]", "");
									fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
									fPercent = fPercent / 100.0;
								}
								else
								{
									try
									{
										nActionCount = Integer.parseInt(strNextCondition);
									}
									catch (Exception ex)
									{
										fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
									}
								}
							}

							if (nActionCount >= 1)
							{
								if (nCount >= nActionCount)
									bGoNext = true;
							}
							else
							{
								if (fPercent > 0 && nRoleCount != 0 && ((double) nCount / (double) nRoleCount >= fPercent))
								{
									bGoNext = true;
								}
							}
						}
					}
					else
					{
						if (StringHelper.compare(strNextCondition, "ANY", true) == 0)
						{
							if (nCount > 0)
							{
								// 该步骤可以完成
								bGoNext = true;
							}
						}
						else
						{
							// 判断是否合并其它操作
							for (String strIA : otherIAMap.keySet())
							{
								
								int nIAActionCount = getWFDataCtrl().getWFStepDataCount(wfActionContext, stepData.getWFStepId(), strIA);
								nCount += nIAActionCount;
							}

							
							int nActionCount = -1;
							int nActorCount = getWFDataCtrl().getWFStepActorCount(wfActionContext, stepData.getWFStepId());
							double fPercent = 0;
							if (StringHelper.compare(strNextCondition, "ALL", true) == 0)
							{
								nActionCount = nActorCount;
							}
							else
							{
								if (strNextCondition.indexOf("%") != -1)
								{
									strNextCondition = strNextCondition.replaceAll("[%]", "");
									fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
									fPercent = fPercent / 100.0;
								}
								else
								{
									try
									{
										nActionCount = Integer.parseInt(strNextCondition);
									}
									catch (Exception ex)
									{
										fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
									}
								}
							}

							if (nActionCount >= 1)
							{
								if (nCount >= nActionCount)
									bGoNext = true;
							}
							else
							{
								if (fPercent > 0 && nActorCount != 0 && ((double) nCount / (double) nActorCount >= fPercent))
								{
									bGoNext = true;
								}
							}
						}
					}
				}

				if (bGoNext)
				{
					WFStep activeStep = new WFStep();
					activeStep.setWFStepId(stepData.getWFStepId());
					wfActionContext.setActiveWFStep(activeStep);

					internalExecuteProcess(wfActionContext, curWFProcessModel);
					

					internalFinishProcess(wfActionContext, curWFProcessModel);
					

					IWFProcessModel nextProcessConfig = wfActionContext.getWFVersionModel().getWFProcessModel(iaAction.getNextTo(), false);
					

					internalExecute(wfActionContext, nextProcessConfig);

					// 删除所有临时步骤用户
					getWFDataCtrl().removeWFTmpStepActors(wfActionContext, strCurWFStepId);
					wfActionContext.getNextIAStepActorMap().clear();// .nextIAStepActorMap
																	// = null;

					return wfActionContext.createWFActionResult();
				}

				return wfActionContext.createWFActionResult();
				
			}
		});
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#close(net.ibizsys.pswf.core.WFActionParam)
	 */
	@Override
	public WFActionResult close(WFActionParam wfParam) throws Exception
	{
		final WFActionParam wfActionParam = wfParam;

		log.debug("开始[close]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				if (!StringHelper.isNullOrEmpty(wfActionContext.getUserTag()))
				{
					wfActionContext.getNextIAStepActorMap().clear();
					String[] actorids = wfActionContext.getUserTag().split("[;]");
					for (int i = 0; i < actorids.length; i++)
					{
						if (!StringHelper.isNullOrEmpty(actorids[i]))
							wfActionContext.getNextIAStepActorMap().put(actorids[i], "");
					}
				}

				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000020,getLocalization(WFLanResTags.MSG_E_000020, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法再次关闭",iEntity.get("srfdatainfo"))));
				}
				

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				wfActionContext.setActiveWFInstance(wfInstance);
				wfActionContext.setWFVersionModel(iWFVersionModel);

				String strActiveStepId = wfInstance.getActiveStepId();

				if (!testClose(wfActionContext))
				{
					throw new WFException(WFErrors.E_000021,getLocalization(WFLanResTags.MSG_E_000021, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("数据[%1$s]流程不允许关闭", iEntity.get("srfdatainfo"))));
				}

				// 放入取消原因
				wfInstance.setCancelReason(wfActionParam.getDescription());

				getWFDataCtrl().userCloseWFInstance(wfActionContext, wfInstance);
				

				getWFDataCtrl().updateCurWFStepActors(wfActionContext);
				

				// 判断当前是否为子流程
				if (!StringHelper.isNullOrEmpty(wfInstance.getPWFInstanceId()))
				{
					// 向父流程提交结果
					if (wfActionParam.isSubmitEmbedWF())
						return submitEmbedWorkflow(wfActionContext, wfInstance.getPWFInstanceId(), wfActionContext.getActiveEntity(), false);
				}

				// 关闭
				userCloseUnfinishEmbedWorkflows(wfActionContext, strActiveStepId, false, "父流程实例已经被关闭");
				return wfActionContext.createWFActionResult();
			}
		});
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#restart(net.ibizsys.pswf.core.WFActionParam)
	 */
	@Override
	public WFActionResult restart(WFActionParam wfParam) throws Exception
	{
		final WFActionParam wfActionParam = wfParam;

		log.debug("开始[restart]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, true);
				if (wfInstance == null)
					return start(wfActionParam);

				wfActionContext.setActiveWFInstance(wfInstance);
				
				//获取上一次流程模型
				IWFVersionModel lastWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				
				// 当前流程版本
				IWFVersionModel iWFVersionModel = getWFModel().getLastWFVersionModel(lastWFVersionModel.getWFMode());
				wfActionContext.setWFVersionModel(iWFVersionModel);

				if (!testRestart(wfActionContext))
				{
					throw new WFException(WFErrors.E_000022,getLocalization(WFLanResTags.MSG_E_000022, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("数据[%1$s]流程不允许重启", iEntity.get("srfdatainfo"))));
				}

				userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "父流程重新启动");
				wfInstance.setWFVersion(iWFVersionModel.getWFVersion());
				// wfInstance.setWFMODEL(workflow.getWFMODEL());
				getWFDataCtrl().resetWFInstance(wfActionContext, wfInstance);
				
				if (!DataObject.getBoolValue(wfInstance.getParallelInst(), false))
				{
					WFStepData stepData = new WFStepData();
					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_RESTART,"重新启动流程");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_RESTART);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_RESTART);
					stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
					stepData.setConnectionName(TAG_SRFWFSTART);
					stepData.setWFInstanceId(wfInstance.getWFInstanceId());
					stepData.setActorId(wfActionContext.getOpPersonId());
					stepData.setActorName(wfActionContext.getOpPersonName());
					getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);

				}

				// 开始执行
				internalExecute(wfActionContext, null);
				
				return wfActionContext.createWFActionResult();
			}
		});
	}

	// /*
	// * 重启流程 (non-Javadoc)
	// *
	// * @see SRFWF.Ctrl.ISRFWFEngine#Restart(SRFWF.Client.WFActionParam)
	// */
	// public void restart(WFActionParam wpParam) throws Exception
	// {
	// wfEngineInst.strCurUserId = wfActionParam.getOpPersonId();
	// wfEngineInst.strUserTag = wfActionParam.getUserTag();
	// wfEngineInst.strUserTag2 = wfActionParam.getUserTag2();
	//
	// // 从数据库中查出当前数据
	// WFActionResult ret = getUserData(wpParam);
	// if (ret == null || ret.getRetCode() != Errors.OK)
	// {
	// throw new Exception( "获取用户数据失败", ret);
	// }
	//
	// // 从配置中加载配置
	// wfConfig = wfModelStorage.FindWFConfig(workflow);
	// if (wfConfig == null)
	// {
	// return LogAndReturn("Init", StringHelper.format("加载工作流处理配置失败[%1$s]",
	// workflow.getWFWorkflowId()), null);
	// }
	//
	// // 获取指定数据实例
	// WFActionResult callResult =
	// getWFDataCtrl().getWFInstance(wfActionParam.getWorkflowId(),
	// wfActionParam.getUserData(), wfActionParam.getUserData2(),
	// wfActionParam.getUserData3(), wfActionParam.getUserData4(), wfInstance);
	// if (callResult != null && callResult.getRetCode() == Errors.INVALIDDATA)
	// {
	// // 没有找到实例数据，直接重启
	// return startNew(wpParam);
	// }
	//
	// if (callResult == null || callResult.getRetCode() != Errors.OK)
	// {
	// throw new Exception( StringHelper.format("获取工作流实例[%1$s]失败",
	// wfActionParam.getUserData()));
	// }
	//
	// if (this.iWFDataCtrl != null)
	// {
	// ret = getWFDataCtrl().TestRestartWF(this);
	// if (ret.getRetCode() != Errors.OK)
	// {
	// throw new Exception( StringHelper.format("数据[%1$s]流程重启失败",
	// wfActionParam.getUserData()));
	// }
	// }
	//
	// userCloseUnfinishEmbedWorkflows(wfInstance.getActiveStepId(), false,
	// "父流程重新启动");
	//
	// //
	// wfInstance.setWFInstanceName(StringHelper.format("%1$s[%2$s]",workflow.getWFNAME(),DateParser.toDateTimeString(new
	// // Date())));
	// wfInstance.setWFVersion(workflow.getWFVERSION());
	// wfInstance.setWFMODEL(workflow.getWFMODEL());
	// callResult = getWFDataCtrl().resetWFInstance(wfInstance, strCurUserId);
	// if (callResult == null || callResult.getRetCode() != Errors.OK)
	// {
	// throw new Exception( StringHelper.format("重置工作流实例[%1$s]失败",
	// wfActionParam.getUserData()));
	// }
	//
	// // 通知用户重新启动
	// String strSQL = workflow.getRestartCmd();
	// if (!StringHelper.isNullOrEmpty(strSQL))
	// {
	// strSQL = StringHelper.format(strSQL, wfActionParam.getUserData(),
	// wfActionParam.getUserData2(), wfActionParam.getUserData3(),
	// wfActionParam.getUserData4(), wfEngineInst.strCurUserId,
	// wfInstance.getWFInstanceId());
	// ret = getWFDataCtrl().ExecRawSql(strSQL);
	// if (ret == null || ret.getRetCode() != Errors.OK)
	// {
	// throw new Exception( StringHelper.format("实例被重新启动，更新用户数据失败"));
	// }
	// }
	//
	// if (this.iWFDataCtrl != null)
	// {
	// if (!wfInstance.getParallelInst())
	// {
	// WFStepData stepData = new WFStepData();
	// stepData.setWFStepDataName("重新启动流程");
	// stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
	// stepData.setConnectionName(TAG_SRFWFSTART);
	// stepData.setWFInstanceId(wfInstance.getWFInstanceId());
	// stepData.setActorId(strCurUserId);
	//
	// getWFDataCtrl().addRawWFStepData(this, stepData);
	// if (ret == null || ret.getRetCode() != Errors.OK)
	// {
	// getWFDataCtrl().errorWFInstance(wfInstance, ret == null ? "不明错误" :
	// ret.getErrorInfo(), wfActionParam.getOpPersonId());
	// throw new Exception( "", ret);
	// }
	// }
	// }
	//
	// // 开始执行
	// ret = internalExecute(null);
	// if (ret == null || ret.getRetCode() != Errors.OK)
	// {
	// getWFDataCtrl().errorWFInstance(wfInstance, ret == null ? "不明错误" :
	// ret.getErrorInfo(), wfActionParam.getOpPersonId());
	// throw new Exception( "", ret);
	// }
	// return ret;
	// }


	/**
	 * 计算下一个交互操作用户
	 * @param wpParam
	 * @return
	 * @throws Exception
	 */
	public WFActionResult calcNextIAProcessActor(WFActionParam wpParam) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[calcNextIAProcessActor]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);

				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000003,getLocalization(WFLanResTags.MSG_E_000003, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行交互处理",iEntity.get("srfdatainfo"))));
				}

				// 判断当前步骤是否一致
				if (StringHelper.compare(wfActionParam.getStepId(), wfInstance.getActiveStepName(), true) != 0)
				{
					throw new WFException(WFErrors.E_000004,getLocalization(WFLanResTags.MSG_E_000004, new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()},StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName())));
				}

				String strWFStepId = wfInstance.getActiveStepId();

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());

				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
	

				String strNext = "";
				if (curWFProcessModel instanceof IWFInteractiveProcessModel)
				{
					IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel) curWFProcessModel;
					IWFInteractiveLinkModel iWFInteractiveLinkModel = iaProcessConfig.getWFInteractiveLinkModel(wfActionParam.getConnection(), false);
	
					strNext = iWFInteractiveLinkModel.getNext();
				}

				IWFInteractiveProcessModel nextIAProcessModel = null;

				while (!StringHelper.isNullOrEmpty(strNext))
				{
					IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(strNext, false);
					
					if (nextProcessConfig.isTerminalProcess())
					{
						throw new WFException(WFErrors.E_000023,getLocalization(WFLanResTags.MSG_E_000023,null,StringHelper.format("当前处理后续为结束处理，不存在交互操作处理")));
					}

					if (nextProcessConfig instanceof IWFProcessModel)
					{
						IWFProcessModel iWFProcessModel = (IWFProcessModel) nextProcessConfig;
						strNext = calcWFProcessNext(wfActionContext, iWFProcessModel);
						continue;
					}

					if (nextProcessConfig instanceof IWFInteractiveProcessModel)
					{
						nextIAProcessModel = (IWFInteractiveProcessModel) nextProcessConfig;
						break;
					}

					throw new WFException(WFErrors.E_000024,getLocalization(WFLanResTags.MSG_E_000024,null,StringHelper.format("无法计算当前处理后续的交互处理")));
				}

				if (nextIAProcessModel == null)
				{
					throw new WFException(WFErrors.E_000025,getLocalization(WFLanResTags.MSG_E_000025,null,StringHelper.format("无法获取当前处理后续的交互处理")));
				}

				java.util.Iterator<IWFProcRoleModel> wfProcRoleModels = nextIAProcessModel.getWFProcRoleModels();
				if (wfProcRoleModels != null)
				{
					while (wfProcRoleModels.hasNext())
					{
						IWFProcRoleModel iWFProcRoleModel = wfProcRoleModels.next();
						java.util.Iterator<IWFProcRoleUser> wfProcRoleUserModels = getWFProcRoleUserModels(wfActionContext, iWFProcRoleModel) ;
						if (wfProcRoleUserModels != null)
						{
							ArrayList<WFTmpStepActor> tmpStepActors = new ArrayList<WFTmpStepActor>();

							while (wfProcRoleUserModels.hasNext())
							{
								IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();

								WFTmpStepActor tmpStepActor = new WFTmpStepActor();
								tmpStepActor.setWFActorId(iWFProcRoleUser.getWFUserId());
								tmpStepActor.setWFActorName(iWFProcRoleUser.getWFUserName());
								tmpStepActor.setPrevProcess(wfActionContext.getUserTag());
								tmpStepActor.setPrevWFStepId(strWFStepId);
								tmpStepActor.setConnection(wfActionParam.getConnection());
								tmpStepActors.add(tmpStepActor);
							}

							getWFDataCtrl().addWFTmpStepActors(wfActionContext, tmpStepActors);

						}
					}
				}
				return wfActionContext.createWFActionResult();
			}
		});
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#rollbackIAAction(net.ibizsys.pswf.core.WFActionParam)
	 */
	public WFActionResult rollbackIAAction(WFActionParam wpParam) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[rollbackIAAction]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000008,getLocalization(WFLanResTags.MSG_E_000008, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行撤回处理", iEntity.get("srfdatainfo"))));
				}

				wfActionContext.setActiveWFInstance(wfInstance);

				// 判断流程的最后一个人为操作
				WFStepData lastWFStepData = new WFStepData();
				getWFDataCtrl().getLastWFStepData(wfActionContext, lastWFStepData);
				

				if (StringHelper.compare(lastWFStepData.getActorId(), wfActionContext.getOpPersonId(), false) != 0)
				{
					throw new WFException(WFErrors.E_000026,getLocalization(WFLanResTags.MSG_E_000026,null,StringHelper.format("当前用户不是工作流最后一次操作者，无法进行撤回处理")));
				}

				if (StringHelper.compare(lastWFStepData.getConnectionName(), TAG_SRFWFROLLBACK, true) == 0)
				{
					throw new WFException(WFErrors.E_000027,getLocalization(WFLanResTags.MSG_E_000027, null,StringHelper.format("无法对撤回处理进行再撤回")));
				}

				if (StringHelper.compare(lastWFStepData.getConnectionName(), TAG_SRFWFTIMEOUT, true) == 0)
				{
					throw new WFException(WFErrors.E_000028,getLocalization(WFLanResTags.MSG_E_000028, null,StringHelper.format("无法对超时处理进行撤回")));
				}

				if (StringHelper.compare(lastWFStepData.getConnectionName(), TAG_SRFWFSTART, true) == 0)
				{
					// 取消启动，回到草稿
					cancelStart(wfActionContext);
					
					// 加入撤回步骤
					WFStepData stepData = new WFStepData();
					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_ROLLBACK,"流程撤回");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_ROLLBACK);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_ROLLBACK);
					stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
					stepData.setConnectionName(TAG_SRFWFROLLBACK);
					stepData.setWFInstanceId(wfInstance.getWFInstanceId());
					stepData.setActorId(wfActionContext.getOpPersonId());
					stepData.setActorName(wfActionContext.getOpPersonName());
					stepData.setMemo(wfActionParam.getDescription());
					stepData.setWFStepId(wfInstance.getActiveStepId());
					getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
					
					return wfActionContext.createWFActionResult();
				}

				if (StringHelper.isNullOrEmpty(lastWFStepData.getWFStepId()))
				{
					throw new WFException(WFErrors.E_000029,getLocalization(WFLanResTags.MSG_E_000029, null,StringHelper.format("没有指定工作流上一个步骤")));
				}

				// 判断步骤是否只有一个人
				ArrayList<WFStepData> stepDataList = new ArrayList<WFStepData>();
				getWFDataCtrl().getWFStepDatas(wfActionContext, lastWFStepData.getWFStepId(), stepDataList);
				

				if (stepDataList.size() > 1)
				{
					throw new WFException(WFErrors.E_000030,getLocalization(WFLanResTags.MSG_E_000030,null,StringHelper.format("工作流上一个步骤有多个操作者，无法进行撤回处理")));
				}

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				wfActionContext.setWFVersionModel(iWFVersionModel);
				String strWFPName = wfInstance.getActiveStepName();

				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(strWFPName, false);
				

				// 切换到下一步骤
				WFStep activeStep = new WFStep();
				activeStep.setWFStepId(wfInstance.getActiveStepId());
				wfActionContext.setActiveWFStep(activeStep);

				internalExecuteProcess(wfActionContext, curWFProcessModel);
				

				internalFinishProcess(wfActionContext, curWFProcessModel);
				
				// 加入撤回步骤
				WFStepData stepData = new WFStepData();
				String strLogicName = getLocalization(WFLanResTags.MSG_STEP_ROLLBACK,"流程撤回");
				stepData.setWFStepDataName(strLogicName);
				stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_ROLLBACK);
				stepData.setWFPLogicName(strLogicName);
				stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_ROLLBACK);
				stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
				stepData.setConnectionName(TAG_SRFWFROLLBACK);
				stepData.setWFInstanceId(wfInstance.getWFInstanceId());
				stepData.setActorId(wfActionContext.getOpPersonId());
				stepData.setActorName(wfActionContext.getOpPersonName());
				stepData.setMemo(wfActionParam.getDescription());
				stepData.setWFStepId(wfInstance.getActiveStepId());
				getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
				
				// 获取上一步处理
				strWFPName = DataObject.getStringValue(lastWFStepData, "WFPNAME", "");
				IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(strWFPName, false);
				

				wfActionContext.getRollbackStepActors().clear();
				getWFDataCtrl().getWFStepActors(wfActionContext, lastWFStepData.getWFStepId(), wfActionContext.getRollbackStepActors());
				

				internalExecute(wfActionContext, nextProcessConfig);
				return wfActionContext.createWFActionResult();
			}
		});

	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#timeoutIAAction(net.ibizsys.pswf.core.WFActionParam)
	 */
	@Override
	public WFActionResult timeoutIAAction(WFActionParam wpParam) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[timeoutIAAction]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				boolean bIAGoto = false;
				
				String strConnection = wfActionParam.getConnection();
				if (StringHelper.compare(strConnection, TAG_SRFWFIAGOTO, true) == 0)
				{
					wfActionParam.setConnection(TAG_SRFWFTIMEOUT);
					bIAGoto = true;
				}

				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000010,getLocalization(WFLanResTags.MSG_E_000010, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行超时处理", iEntity.get("srfdatainfo"))));
				}

				wfActionContext.setActiveWFInstance(wfInstance);

				// 判断当前步骤是否一致
				if (!bIAGoto)
				{
					if (StringHelper.compare(wfActionParam.getStepId(), wfInstance.getActiveStepName(), true) != 0)
					{
						throw new WFException(WFErrors.E_000004,getLocalization(WFLanResTags.MSG_E_000004, new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()},StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName())));
					}
				}

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				wfActionContext.setWFVersionModel(iWFVersionModel);

				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
	

				// 判断该步骤是否包括制定处理
				WFStepData stepData = new WFStepData();
				stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
				stepData.setWFStepId(wfInstance.getActiveStepName());
				stepData.setConnectionName(wfActionParam.getConnection());
				stepData.setMemo(wfActionParam.getDescription());
				stepData.setWFInstanceId(wfInstance.getWFInstanceId());

				IWFProcessModel nextProcessConfig = null;

				if (!bIAGoto)
				{
					String strTimeoutNext = "";
					if (!curWFProcessModel.isEnableTimeout())
					{
						throw new WFException(WFErrors.E_000031,getLocalization(WFLanResTags.MSG_E_000031, new Object[]{wfInstance.getActiveStepName()},StringHelper.format("指定处理[%1$s]不支持超时处理", wfInstance.getActiveStepName())));
					}

					strTimeoutNext = curWFProcessModel.getTimeoutNext();
					if (StringHelper.isNullOrEmpty(strTimeoutNext))
					{
						throw new WFException(WFErrors.E_000032,getLocalization(WFLanResTags.MSG_E_000032, new Object[]{wfInstance.getActiveStepName()},StringHelper.format("指定处理[%1$s]没有定义超时路径", wfInstance.getActiveStepName())));
					}

					if (curWFProcessModel instanceof IWFEmbedWFProcessModelBase)
					{
						userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "父流程超时结束当前步骤");
					}

					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_TIMEOUT,"超时处理");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_TIMEOUT);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_TIMEOUT);
					nextProcessConfig = iWFVersionModel.getWFProcessModel(strTimeoutNext, false);

				}
				else
				{
					// 判断指定步骤是否存在
					nextProcessConfig = iWFVersionModel.getWFProcessModelByWFStepValue(wfActionParam.getStepId(), false);
					if (nextProcessConfig instanceof IWFEmbedWFProcessModelBase)
					{
						userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "父流程步骤跳转结束当前步骤");
					}
					String strLogicName = getLocalization(WFLanResTags.MSG_STEP_GOTO,"步骤跳转处理");
					stepData.setWFStepDataName(strLogicName);
					stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_GOTO);
					stepData.setWFPLogicName(strLogicName);
					stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_GOTO);
				}

				stepData.setActorId(wfActionContext.getOpPersonId());
				stepData.setActorName(wfActionContext.getOpPersonName());
				getWFDataCtrl().addWFStepData(wfActionContext, stepData);
				// 切换到下一步骤
				WFStep activeStep = new WFStep();
				activeStep.setWFStepId(stepData.getWFStepId());

				wfActionContext.setActiveWFStep(activeStep);

				internalExecuteProcess(wfActionContext, curWFProcessModel);
				internalFinishProcess(wfActionContext, curWFProcessModel);
				internalExecute(wfActionContext, nextProcessConfig);
				return wfActionContext.createWFActionResult();
			}
		});
	}


	/**
	 * 测试角色在某个操作的操作
	 * @param strConnection
	 * @param nRoleActorCount
	 * @param connCountMap
	 * @param strNextCondition
	 * @param strIAUnion
	 * @return
	 * @throws Exception
	 */
	protected boolean testRoleConnection(String strConnection, int nRoleActorCount, TreeMap<String, Integer> connCountMap, String strNextCondition, String strIAUnion) throws Exception
	{
		int nCount = 0;
		if (connCountMap.containsKey(strConnection))
			nCount = connCountMap.get(strConnection);
		if (StringHelper.compare(strNextCondition, "ANY", true) == 0)
		{
			if (nCount > 0)
			{
				// 该步骤可以完成
				return true;
			}
		}
		else
		{
			TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
			String strOtherIA = strIAUnion;
			if (!StringHelper.isNullOrEmpty(strOtherIA))
			{
				strOtherIA = strOtherIA.toUpperCase();
				String[] ias = strOtherIA.split("[;]");
				for (int i = 0; i < ias.length; i++)
				{
					if (StringHelper.compare(ias[i], strConnection, true) == 0)
						continue;
					otherIAMap.put(ias[i], 0);
				}

				// 判断是否合并其它操作
				for (String strIA : otherIAMap.keySet())
				{
					if (connCountMap.containsKey(strIA))
					{
						nCount += connCountMap.get(strIA);
					}
				}
			}

			int nActionCount = -1;
			int nActorCount = nRoleActorCount;
			double fPercent = 0;
			if (StringHelper.compare(strNextCondition, "ALL", true) == 0)
			{
				nActionCount = nActorCount;
			}
			else
			{
				if (strNextCondition.indexOf("%") != -1)
				{
					strNextCondition = strNextCondition.replaceAll("[%]", "");
					fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
					fPercent = fPercent / 100.0;
				}
				else
				{
					try
					{
						nActionCount = Integer.parseInt(strNextCondition);
					}
					catch (Exception ex)
					{
						fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
					}
				}
			}

			if (nActionCount >= 1)
			{
				if (nCount >= nActionCount)
					return true;
			}
			else
			{
				if (fPercent > 0 && nActorCount != 0 && ((double) nCount / (double) nActorCount >= fPercent))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 工作转移
	 * @param wpParam
	 * @return
	 */
	public WFActionResult resubmitAction(WFActionParam wpParam) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[resubmitAction]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			/* (non-Javadoc)
			 * @see net.ibizsys.pswf.core.IWFServiceWork#execute(net.ibizsys.paas.service.ITransaction)
			 */
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				boolean bIAGoto = false;

				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000011,getLocalization(WFLanResTags.MSG_E_000011, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行工作转移", iEntity.get("srfdatainfo"))));
				}

				wfActionContext.setActiveWFInstance(wfInstance);

				// 判断当前步骤是否一致
				if (StringHelper.compare(wfActionParam.getStepId(), wfInstance.getActiveStepName(), true) != 0)
				{
					throw new WFException(WFErrors.E_000004,getLocalization(WFLanResTags.MSG_E_000004, new Object[]{iEntity.get("srfdatainfo"),wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致",iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName())));
				}

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				wfActionContext.setWFVersionModel(iWFVersionModel);

				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);


				// 判断该步骤是否包括制定处理
				WFStepData stepData = new WFStepData();
				stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
				stepData.setWFStepId(wfActionParam.getStepId());
				stepData.setActorId(wfActionContext.getOpPersonId());
				stepData.setActorName(wfActionContext.getOpPersonName());
				stepData.setMemo(wfActionParam.getDescription());
				stepData.setWFInstanceId(wfInstance.getWFInstanceId());

				IWFInteractiveProcessModel iaProcessConfig = null;
				if (curWFProcessModel instanceof IWFInteractiveProcessModel)
				{
					iaProcessConfig = (IWFInteractiveProcessModel) curWFProcessModel;
					java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
					if (wfInteractiveLinkModels == null)
					{
						throw new WFException(WFErrors.E_000007,getLocalization(WFLanResTags.MSG_E_000007, null,StringHelper.format("没有找到任何交互操作")));
					}

					IWFInteractiveLinkModel iWFInteractiveLinkModel = null;
					while (wfInteractiveLinkModels.hasNext())
					{
						iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
						//处理步骤操作多语言
						String strLogicName = iWFInteractiveLinkModel.getLogicName();
						String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
						if(!StringHelper.isNullOrEmpty(strLNLanResTag)){
							stepData.setWFActionLanResTag(strLNLanResTag);
							strLogicName = getLocalization(strLNLanResTag, strLogicName);
						}
						stepData.setWFStepDataName(strLogicName);
						//处理步骤多语言
						String strWFStepName = curWFProcessModel.getName();
						String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
						if(!StringHelper.isNullOrEmpty(strWFStepLanResTag)){
							stepData.setWFStepLanResTag(strWFStepLanResTag);
							strWFStepName = getLocalization(strWFStepLanResTag,strWFStepName);
						}
						stepData.setWFPLogicName(strWFStepName);
						
						stepData.setWFStepLanResTag(iWFInteractiveLinkModel.getLNLanResTag());
						if(!StringHelper.isNullOrEmpty(iWFInteractiveLinkModel.getActionField()))
						{
							String strActionValue = DataObject.getStringValue(iEntity, iWFInteractiveLinkModel.getActionField(), null);
							String strActionLanResTag = "";
							if(!StringHelper.isNullOrEmpty(strActionValue))
							{
								ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
								if(codeList != null)
								{
									strActionValue = getCodeItemText(codeList, strActionValue);
									String strCodeItemLanResTag = getCodeItemLanResTag(codeList, strActionValue);
									if(!StringHelper.isNullOrEmpty(strCodeItemLanResTag)) {
										stepData.setWFActionLanResTag(strActionLanResTag);
										strActionValue = getLocalization(strCodeItemLanResTag, strActionValue);
									}
								}
								if(!StringHelper.isNullOrEmpty(strActionValue)){
									stepData.setWFStepDataName(strActionValue);
								}

							}
						}
						stepData.setConnectionName(iWFInteractiveLinkModel.getName());
						break;
					}
				}

				//测试操作是否允许
				getWFDataCtrl().testWFStepData(wfActionContext, stepData);

				
				WFActor wfActor = new WFActor();
				wfActor.setWFActorId(wfActionParam.getConnection());
				getWFDataCtrl().getWFActor(wfActionContext, wfActor);
				

				// 完成当前步骤
				String strLogicName = getLocalization(WFLanResTags.MSG_STEP_RESUBMIT, new Object[]{wfActor.getWFActorName()},StringHelper.format("将工作转移至[%1$s]", wfActor.getWFActorName()));
				stepData.setWFStepDataName(strLogicName);
				stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_RESUBMIT);
				stepData.setWFPLogicName(strLogicName);
				stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_RESUBMIT);
				stepData.setConnectionName("SRFWFRESUBMIT");
				stepData.setSDParam(wfActionParam.getConnection());

				//添加步骤数据
				getWFDataCtrl().addWFStepData(wfActionContext, stepData);
				

				//更新当前操作者
				getWFDataCtrl().updateCurWFStepActors(wfActionContext);

				if (iaProcessConfig != null && iaProcessConfig.isSendInform())
				{
					ArrayList<String> actors = new ArrayList<String>();
					actors.add(wfActionParam.getConnection());
					// 发送任务通知
					getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
				}

				return wfActionContext.createWFActionResult();
			}
		});
	}


	/**
	 * 取消流程启动
	 * @param wfActionContext
	 * @throws Exception
	 */
	protected void cancelStart(WFActionContext wfActionContext) throws Exception
	{
		// 放入取消原因
		wfActionContext.getActiveWFInstance().setCancelReason(wfActionContext.getWFActionParam().getDescription());
		String strActiveStepId = wfActionContext.getActiveWFInstance().getActiveStepId();

		getWFDataCtrl().cancelStartWFInstance(wfActionContext, wfActionContext.getActiveWFInstance());
		// 关闭
		userCloseUnfinishEmbedWorkflows(wfActionContext, strActiveStepId, false, "父流程实例已经被关闭");
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#markReadFlag(net.ibizsys.pswf.core.WFActionParam)
	 */
	public WFActionResult markReadFlag(WFActionParam wpParam) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[markReadFlag]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				boolean bIAGoto = false;

				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000009,getLocalization(WFLanResTags.MSG_E_000009, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行标记已读操作",iEntity.get("srfdatainfo"))));
				}

				wfActionContext.setActiveWFInstance(wfInstance);

				WFStepActor wfStepActor = new WFStepActor();
				wfStepActor.setActorId(wfActionContext.getOpPersonId());
				wfStepActor.setWFStepId(wfActionParam.getStepId());

				getWFDataCtrl().markWFStepActorReadFlag(wfActionContext, wfStepActor);

				return wfActionContext.createWFActionResult();
			}
		});
	}

	
	/**
	 * 判断用户数据操作者与制定操作者是否一致
	 * @param wfActionContext
	 * @param strUDActorId
	 * @param strUserId
	 * @return
	 * @throws Exception
	 */
	protected boolean testUDActor(WFActionContext wfActionContext, String strUDActorId, String strUserId) throws Exception
	{
		String strUDUserId = DataObject.getStringValue(wfActionContext.getActiveEntity(), strUDActorId, null);
		if (strUDUserId == null)
			return false;
		return StringHelper.compare(strUDUserId, strUserId, false) == 0;
	}

	
	/**
	 * 内部执行处理
	 * @param wfActionContext
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void internalExecute(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		if (iWFProcessModel == null)
		{
			iWFProcessModel = wfActionContext.getWFVersionModel().getStartWFProcessModel();
		}
		if (iWFProcessModel == null)
		{
			throw new WFException(WFErrors.E_000012,getLocalization(WFLanResTags.MSG_E_000012, null,"没有找到流程开始节点"));
		}

		if (iWFProcessModel.isAsynchronousProcess() && !wfActionContext.isThreadMode())
		{
			WFServiceThread engineThread = new WFServiceThread(wfActionContext, iWFProcessModel);
			engineThread.start();
			// return new WFActionResult();
			return;
		}

		int nLoopCount = 0;
		while (true)
		{
			internalPrepareProcess(wfActionContext, iWFProcessModel);

			// 是否为结束节点
			if (iWFProcessModel.isTerminalProcess())
			{
				internalFinishProcess(wfActionContext, iWFProcessModel);
				// 结束节点，流程结束
				internalFinishWorkflow(wfActionContext);
				return;
			}

			// 是否为交互处理
			if (iWFProcessModel.isSuspendProcess())
			{
				// 该节点为挂起处理节点，当前处理结束
				// return new WFActionResult();
				return;
			}

			wfActionContext.setCurNext("");
			internalExecuteProcess(wfActionContext, iWFProcessModel);


			internalFinishProcess(wfActionContext, iWFProcessModel);
			

			// 执行成功
			if (StringHelper.isNullOrEmpty(wfActionContext.getCurNext()))
			{
				throw new WFException(WFErrors.E_000013,getLocalization(WFLanResTags.MSG_E_000013, new Object[]{iWFProcessModel.getLogicName(), iWFProcessModel.getName()},StringHelper.format("[%1$s][%2$s]执行后，没有指定后续节点", iWFProcessModel.getLogicName(), iWFProcessModel.getName())));
			}

			// 判断下一个节点
			iWFProcessModel = wfActionContext.getWFVersionModel().getWFProcessModel(wfActionContext.getCurNext(), false);

			nLoopCount++;
			if (nLoopCount >= wfActionContext.getMaxLoopCount())
			{
				throw new WFException(WFErrors.E_000014,getLocalization(WFLanResTags.MSG_E_000014, new Object[]{wfActionContext.getMaxLoopCount()},StringHelper.format("处理已经超过[%1$s]次，系统中断", wfActionContext.getMaxLoopCount())));
			}

			if (iWFProcessModel.isAsynchronousProcess() && !wfActionContext.isThreadMode())
			{
				WFServiceThread engineThread = new WFServiceThread(wfActionContext, iWFProcessModel);
				engineThread.start();
				// return new WFActionResult();
				return;
			}
		}
	}


	/**
	 * 准备执行处理，生成步骤节点等
	 * @param wfActionContext
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void internalPrepareProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		// 变更相关数据

		Date curDate = new Date();

		// 准备数据
		wfActionContext.setActiveWFStep(null);
		WFStep wfStep = new WFStep();
		wfStep.setWFStepId(KeyValueHelper.genGuidEx());
		wfStep.setWFInstanceId(wfActionContext.getActiveWFInstanceId());
		wfStep.setWFPName(iWFProcessModel.getId());
		//处理步骤多语言
		String strLogicName = iWFProcessModel.getLogicName();
		String strNameLanResTag = iWFProcessModel.getNameLanResTag();
		if(!StringHelper.isNullOrEmpty(strNameLanResTag)){
			wfStep.setWFStepLanResTag(strNameLanResTag);
			strLogicName = getLocalization(strNameLanResTag, strLogicName);
		}
		wfStep.setWFPLogicName(strLogicName);
		wfStep.setIsInteractive(iWFProcessModel.isSuspendProcess() ? 1 : 0);
		wfStep.setWFVersion(wfActionContext.getWFVersionModel().getWFVersion());
		wfStep.setStartTime(new Timestamp(curDate.getTime()));
		wfStep.setWFStepName(iWFProcessModel.getWFStepValue());

		if (iWFProcessModel.isEnableTimeout())
		{
			int nTimeout = iWFProcessModel.getTimeout();
			if (!StringHelper.isNullOrEmpty(iWFProcessModel.getTimeoutField()))
			{
				nTimeout = DataObject.getIntegerValue(wfActionContext.getActiveEntity(), iWFProcessModel.getTimeoutField(), nTimeout);
				log.debug(StringHelper.format("计算工作流超时（动态属性）[%1$s]=[%2$s]", iWFProcessModel.getTimeoutField(), nTimeout));
			}

			if (nTimeout > 0)
			{
				Timestamp deadLine = getWFDataCtrl().calcTimeout(new Timestamp(curDate.getTime()), iWFProcessModel.getTimeoutType(), nTimeout, iWFProcessModel.getWorkTimeType());

				wfStep.setDeadLine(deadLine);
			}
		}

		getWFDataCtrl().addWFStep(wfActionContext, wfStep);

		wfActionContext.setActiveWFStep(wfStep);
		if (iWFProcessModel.isSuspendProcess())
		{
			// 更新执行步骤至用户数据
			getWFDataCtrl().updateWFUserDataRunStep(wfActionContext, iWFProcessModel.getWFStepValue());

			// 重新获取数据
			refreshUserEntity(wfActionContext);
			if (iWFProcessModel instanceof IWFInteractiveProcessModel)
			{
				HashMap<String, String> wfStepActorMap = new HashMap<String, String>();
				HashMap<String, Integer> wfUserRecInformMap = new HashMap<String, Integer>();
				
				IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel) iWFProcessModel;

				if (wfActionContext.getRollbackStepActors().size() > 0)
				{
					for (WFStepActor lastWFStepActor : wfActionContext.getRollbackStepActors())
					{
						WFStepActor stepActor = new WFStepActor();
						stepActor.setWFStepActorName(lastWFStepActor.getWFStepActorName());
						stepActor.setRoleId(lastWFStepActor.getRoleId());

						//stepActor.setWFStepActorId(KeyValueHelper.genGuidEx());
						stepActor.setWFStepId(wfStep.getWFStepId());
						stepActor.setIsReadOnly(0);
						stepActor.setActorId(lastWFStepActor.getActorId());
						stepActor.setActorType(ACTORTYPE_WFACTOR);

						if(!getWFDataCtrl().addWFStepActor(wfActionContext, stepActor))
							continue;
						
						wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue(stepActor,WFUser.FIELD_RECVINFORM,1));
	

						wfStepActorMap.put(stepActor.getActorId(), stepActor.getActorId());
					}
					wfActionContext.getRollbackStepActors().clear();
				}
				else
				{
					boolean bActorIAActionControl = iaProcessConfig.isActorIAActionControl();
					java.util.Iterator<IWFProcRoleModel> wfProcRoleModels = iaProcessConfig.getWFProcRoleModels();
					if (wfProcRoleModels != null)
					{
						while (wfProcRoleModels.hasNext())
						{
							IWFProcRoleModel iWFProcRoleModel = wfProcRoleModels.next();
							java.util.Iterator<IWFProcRoleUser> wfProcRoleUserModels =  getWFProcRoleUserModels(wfActionContext,iWFProcRoleModel);
							if (wfProcRoleUserModels != null)
							{
								while (wfProcRoleUserModels.hasNext())
								{
									IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();
									if (wfActionContext.isEnableNextIAStepActors())
									{
										if (!wfActionContext.getNextIAStepActorMap().containsKey(iWFProcRoleUser.getWFUserId()))
											continue;
									}

									WFStepActor stepActor = new WFStepActor();
									stepActor.setWFStepActorName(iWFProcRoleUser.getWFUserName());
									//stepActor.setWFStepActorId(KeyValueHelper.genGuidEx());
									stepActor.setWFStepId(wfStep.getWFStepId());
									stepActor.setIsReadOnly(0);
									stepActor.setActorId(iWFProcRoleUser.getWFUserId());

									stepActor.setActorType(ACTORTYPE_WFACTOR);
//									if (iWFProcRoleUser.getWFProcRoleModel() != null)
//									{
//										stepActor.setRoleId(iWFProcRoleUser.getWFProcRoleModel().getWFRoleId());
//									}
									stepActor.setRoleId(iWFProcRoleUser.getWFRoleId());
									stepActor.set(IWFProcRoleUser.FIELD_IGNORESUBSTITUTE, iWFProcRoleUser.get(IWFProcRoleUser.FIELD_IGNORESUBSTITUTE));
									stepActor.set(IWFProcRoleUser.FIELD_ORIGINALWFUSERID, iWFProcRoleUser.get(IWFProcRoleUser.FIELD_ORIGINALWFUSERID));
									
									
									if (bActorIAActionControl)
									{
										String strActions = "";
										java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
										if (wfInteractiveLinkModels != null)
										{
											while (wfInteractiveLinkModels.hasNext())
											{
												IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
												if (!iWFInteractiveLinkModel.isActorIAActionControl() || iWFInteractiveLinkModel.containsWFProcRole(iWFProcRoleModel))
												{
													if (!StringHelper.isNullOrEmpty(strActions))
													{
														strActions += ";";
													}

													strActions += StringHelper.format("(%1$s)", iWFInteractiveLinkModel.getName());
												}
											}
										}
										// 放入列表中
										if (StringHelper.isNullOrEmpty(strActions))
											strActions = "NONE";
										stepActor.setIAActions(strActions);
									}

									if(!getWFDataCtrl().addWFStepActor(wfActionContext, stepActor))
										continue;
									wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue(stepActor,WFUser.FIELD_RECVINFORM,1));
									wfStepActorMap.put(iWFProcRoleUser.getWFUserId(), stepActor.getActorId());
									continue;
								}
							}

							continue;
						}
					}

					java.util.Iterator<String> udActors = iaProcessConfig.getUDActors();
					if (udActors != null)
					{
						while (udActors.hasNext())
						{
							String strFieldName = udActors.next();

							WFStepActor stepActor = new WFStepActor();
							//stepActor.setWFStepActorId(KeyValueHelper.genGuidEx());
							stepActor.setWFStepId(wfStep.getWFStepId());
							stepActor.setIsReadOnly(0);

							// 获取实际的用户
							Object objRealUserId = wfActionContext.getActiveEntity().get(strFieldName);
							if (objRealUserId == null)
							{
								log.error(StringHelper.format("无法从用户数据中获取属性[%1$s]", strFieldName));
								continue;
							}

							stepActor.setActorId(objRealUserId.toString());
							stepActor.setActorType(ACTORTYPE_UDACTOR);

							if (bActorIAActionControl)
							{
								String strActions = "";
								java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
								if (wfInteractiveLinkModels != null)
								{
									while (wfInteractiveLinkModels.hasNext())
									{
										IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
										if (!iWFInteractiveLinkModel.isActorIAActionControl() || iWFInteractiveLinkModel.containsUDActor(strFieldName))
										{
											if (!StringHelper.isNullOrEmpty(strActions))
											{
												strActions += ";";
											}
											strActions += StringHelper.format("(%1$s)", iWFInteractiveLinkModel.getName());
										}
									}
								}
								// 放入列表中
								if (StringHelper.isNullOrEmpty(strActions))
									strActions = "NONE";
								stepActor.setIAActions(strActions);
							}

							if(!getWFDataCtrl().addWFStepActor(wfActionContext, stepActor))
								continue;
							
							wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue(stepActor,WFUser.FIELD_RECVINFORM,1));

							wfStepActorMap.put(objRealUserId.toString(), stepActor.getActorId());
							continue;

						}
					}
				}

				int nOrderFlag = 1;
				// 插入交互步骤
				java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
				if (wfInteractiveLinkModels != null)
				{
					while (wfInteractiveLinkModels.hasNext())
					{
						IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModels.next();

						WFIAAction iaAction = new WFIAAction();
						iaAction.setWFIAActionId(KeyValueHelper.genGuidEx());
						iaAction.setWFStepId(wfStep.getWFStepId());
						iaAction.setActionName(iWFInteractiveLinkModel.getName());
						iaAction.setActionLogicName(iWFInteractiveLinkModel.getLogicName());
						iaAction.setActionCount(iWFInteractiveLinkModel.getActionCount());
						// iaAction.setPAGEPATH(iWFInteractiveLinkModel.getPagePath());
						// iaAction.setPANELID(iWFInteractiveLinkModel.getPanelId());
						// iaAction.setFAHELPER(iWFInteractiveLinkModel.getFAHelper());
						iaAction.setOrderFlag(nOrderFlag);
						iaAction.setNextTo(iWFInteractiveLinkModel.getNext());
						iaAction.setNextCondition(iWFInteractiveLinkModel.getNextCondition());

						getWFDataCtrl().addWFIAAction(wfActionContext, iaAction);
						
						nOrderFlag++;
					}
				}

				if (iaProcessConfig.isSendInform())
				{
					HashMap<String, String> wfStepActorMapReal = new HashMap<String, String>();
					for (String strActorId : wfStepActorMap.keySet())
					{
						String strRealActorId = wfStepActorMap.get(strActorId);
						if (StringHelper.isNullOrEmpty(strRealActorId))
							strRealActorId = strActorId;
						wfStepActorMapReal.put(strRealActorId, "");
					}

					ArrayList<String> actors = new ArrayList<String>();
					for (String strActorId : wfStepActorMapReal.keySet())
					{
						Integer nRecvInform = wfUserRecInformMap.get(strActorId);
						if(nRecvInform==null||nRecvInform==1)
							actors.add(strActorId);
					}
					// 发送任务通知
					getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
				}

				getWFDataCtrl().updateCurWFStepActors(wfActionContext);

			}

			// 判断是否为嵌套流程
			if (iWFProcessModel instanceof IWFEmbedWFProcessModel)
			{
				ArrayList<WFActionParam> wfParams = new ArrayList<WFActionParam>();
				getWFDataCtrl().getEmbedWorkflows(wfActionContext, (IWFEmbedWFProcessModel) iWFProcessModel, wfParams);
				

				ArrayList<WFActionParam> startWFInstances = new ArrayList<WFActionParam>();

				for (WFActionParam wfParam : wfParams)
				{
					wfParam.setPInstanceId(wfActionContext.getActiveWFInstanceId());
					wfParam.setStepId(wfStep.getWFStepId());
					wfParam.setOpPersonId(wfActionContext.getOpPersonId());
					wfParam.setOpPersonName(wfActionContext.getOpPersonName());
					//放入父流程的流程模式
					wfParam.setWFMode(wfActionContext.getWFVersionModel().getWFMode());
					startEmbedWorkflow(wfParam);
					
					startWFInstances.add(wfParam);
				}

				// 将所有的实例放入关系数据中
				for (WFActionParam startItem : startWFInstances)
				{
					WFStepInst stepInst = new WFStepInst();
					stepInst.setWFStepInstId(KeyValueHelper.genUniqueId(startItem.getInstanceId(), wfStep.getWFStepId()));
					stepInst.setWFInstanceId(startItem.getInstanceId());
					stepInst.setWFStepId(wfStep.getWFStepId());
					getWFDataCtrl().addWFStepInst(wfActionContext, stepInst);
					
				}
			}

			// 判断是否为平行子流程
			if (iWFProcessModel instanceof IWFParallelSubWFProcessModel)
			{
				ArrayList<WFActionParam> wfParams = new ArrayList<WFActionParam>();
				getWFDataCtrl().getParallelSubWFs(wfActionContext, (IWFParallelSubWFProcessModel) iWFProcessModel, wfParams);

				ArrayList<WFActionParam> startWFInstances = new ArrayList<WFActionParam>();

				for (WFActionParam wfParam : wfParams)
				{
					wfParam.setPInstanceId(wfActionContext.getActiveWFInstanceId());
					wfParam.setStepId(wfStep.getWFStepId());
					wfParam.setOpPersonId(wfActionContext.getOpPersonId());
					wfParam.setOpPersonName(wfActionContext.getOpPersonName());
					wfParam.setConnection(wfParam.getConnection());
					//放入父流程的流程模式
					wfParam.setWFMode(wfActionContext.getWFVersionModel().getWFMode());
					startEmbedWorkflow(wfParam);

					
					startWFInstances.add(wfParam);
				}

				// 将所有的实例放入关系数据中
				for (WFActionParam startItem : startWFInstances)
				{
					WFStepInst stepInst = new WFStepInst();
					stepInst.setWFStepInstId(KeyValueHelper.genUniqueId(startItem.getInstanceId(), wfStep.getWFStepId()));
					stepInst.setWFInstanceId(startItem.getInstanceId());
					stepInst.setWFStepId(wfStep.getWFStepId());
					getWFDataCtrl().addWFStepInst(wfActionContext, stepInst);
					
				}
			}
		}

	}


	/**
	 * 内部完成处理
	 * @param wfActionContext
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void internalFinishProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		// 变更相关数据
		// if (iWFProcessModel instanceof WFHopProcessConfig)
		// {
		// return new WFActionResult();
		// }
		if (wfActionContext.getActiveWFStep() == null)
		{
			throw new WFException(WFErrors.E_000015,getLocalization(WFLanResTags.MSG_E_000015, null,"当前处理步骤无效"));
		}

		// 准备数据
		WFStep wfStep = new WFStep();
		wfActionContext.getActiveWFStep().copyTo(wfStep, true);
		getWFDataCtrl().finishWFStep(wfActionContext, wfStep);
	}

	/**
	 * 内部完成子流程
	 * @return
	 */
	protected void internalFinishWorkflow(WFActionContext wfActionContext) throws Exception
	{
		// 变更相关数据
		getWFDataCtrl().finishWFInstance(wfActionContext, wfActionContext.getActiveWFInstance());
		getWFDataCtrl().updateCurWFStepActors(wfActionContext);
		// 判断当前是否为子流程
		if (!StringHelper.isNullOrEmpty(wfActionContext.getActiveWFInstance().getPWFInstanceId()))
		{
			refreshUserEntity(wfActionContext);
			// 向父流程提交结果
			submitEmbedWorkflow(wfActionContext, wfActionContext.getActiveWFInstance().getPWFInstanceId(), wfActionContext.getActiveEntity(), true);
			return;
		}
	}


	/**
	 * 内部执行处理
	 * @param wfActionContext
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void internalExecuteProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		// if (iWFProcessModel instanceof WFHopProcessConfig)
		// {
		// this.strCurNext = ((WFHopProcessConfig) iWFProcessModel).getNext();
		// return new WFActionResult();
		// }

		IWFProcess iWFProcess = iWFProcessModel.getWFProcess();
		// 开始进行处理
		wfActionContext.setCurWFProcessModel(iWFProcessModel);
		// 调用开始执行
		iWFProcess.executeBefore(wfActionContext);

		// 调用开始执行
		iWFProcess.execute(wfActionContext);

		// 调用结束执行
		iWFProcess.executeAfter(wfActionContext);

	}


	/**
	 * 内部执行交互处理
	 * @param wfActionContext
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void internalExecuteInteractiveProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		wfActionContext.setCurNext("");
		wfActionContext.setFinishInteractiveProcess(false);

		internalExecuteProcess(wfActionContext, iWFProcessModel);

		// 判断是否完成当前的交互处理
		if (!wfActionContext.isFinishInteractiveProcess())
			return;

		// 执行成功
		if (StringHelper.isNullOrEmpty(wfActionContext.getCurNext()))
		{
			throw new WFException(WFErrors.E_000016,getLocalization(WFLanResTags.MSG_E_000016, new Object[]{iWFProcessModel.getName()},StringHelper.format("[%1$s]执行后，没有指定后续节点", iWFProcessModel.getName())));
		}

		// 判断下一个节点
		iWFProcessModel = wfActionContext.getWFVersionModel().getWFProcessModel(wfActionContext.getCurNext(), false);

		internalExecuteProcess(wfActionContext, iWFProcessModel);
	}

	

	/**
	 * 获取当前用户数据
	 * @param wfActionContext
	 * @return
	 */
	protected IEntity getUserEntity(WFActionContext wfActionContext) throws Exception
	{
		String strUserData4 =  wfActionContext.getWFActionParam().getUserData4();
		if(StringHelper.isNullOrEmpty(strUserData4) && wfActionContext.getActiveWFInstance()!=null)
		{
			strUserData4 = wfActionContext.getActiveWFInstance().getUserData4();
		}
		
		IEntity tempDataEntity = this.getWFModel().createEntity(strUserData4);
		getWFDataCtrl().getWFUserEntity(wfActionContext, tempDataEntity);
		
		return tempDataEntity;
	}

	/**
	 * 更新当前用户数据
	 * 
	 * @param wfActionContext
	 * @return
	 */
	protected void refreshUserEntity(WFActionContext wfActionContext) throws Exception
	{
		String strUserData4 =  wfActionContext.getWFActionParam().getUserData4();
		if(StringHelper.isNullOrEmpty(strUserData4) && wfActionContext.getActiveWFInstance()!=null)
		{
			strUserData4 = wfActionContext.getActiveWFInstance().getUserData4();
		}
		
		IEntity tempDataEntity = this.getWFModel().createEntity(strUserData4);
		getWFDataCtrl().getWFUserEntity(wfActionContext, tempDataEntity);
		tempDataEntity.copyTo(wfActionContext.getActiveEntity(), true);
	}

	/**
	 * 启动嵌套工作流
	 * 
	 * @param wfParam
	 * @return
	 */
	protected WFActionResult startEmbedWorkflow(WFActionParam wfParam) throws Exception
	{
		IWFService iWFService = WFModelGlobal.getWFModel(wfParam.getWorkflowId()).getWFService();
		return iWFService.start(wfParam);
	}

	/**
	 * 关闭嵌套流程
	 * 
	 * @param wfParam
	 * @return
	 */
	protected WFActionResult closeEmbedWorkflow(WFActionParam wfParam) throws Exception
	{
		IWFService iWFService = WFModelGlobal.getWFModel(wfParam.getWorkflowId()).getWFService();
		return iWFService.close(wfParam);
	}

	/**
	 * 关闭嵌套流程
	 * 
	 * @param wfParams
	 * @param strReason
	 */
	protected void closeEmbedWorkflows(ArrayList<WFActionParam> wfParams, String strReason) throws Exception
	{
		for (WFActionParam startItem : wfParams)
		{
			startItem.setDescription(strReason);
			closeEmbedWorkflow(startItem);
		}
	}


	/**
	 * 嵌入流程提交
	 * @param wfActionContext
	 * @param strPWFInstanceId
	 * @param dataEntity
	 * @param bNormalClose
	 * @return
	 * @throws Exception
	 */
	protected WFActionResult submitEmbedWorkflow(WFActionContext wfActionContext, String strPWFInstanceId, IEntity dataEntity, boolean bNormalClose) throws Exception
	{
		WFInstance pWFInstance = new WFInstance();
		pWFInstance.setWFInstanceId(strPWFInstanceId);
		getWFDataCtrl().getWFInstance(wfActionContext, pWFInstance, false);
		

		IWFService iWFService = WFModelGlobal.getWFModel(pWFInstance.getWFWorkflowId()).getWFService();
		
		
		WFActionParam wfParam = new WFActionParam();
		wfParam.setOpPersonId(wfActionContext.getOpPersonId());
		wfParam.setInstanceId(strPWFInstanceId);
		wfParam.setStepId(wfActionContext.getActiveWFInstance().getPStepId());

		

		return iWFService.submitEmbedWorkflow(wfParam, wfActionContext.getActiveWFInstance(), dataEntity, bNormalClose);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFService#submitEmbedWorkflow(net.ibizsys.pswf.core.WFActionParam, net.ibizsys.psrt.srv.wf.entity.WFInstance, net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public WFActionResult submitEmbedWorkflow(WFActionParam wpParam, WFInstance childWFInstance, IEntity dataEntity, boolean bNormalClose) throws Exception
	{
		final WFActionParam wfActionParam = wpParam;
		final boolean bNormalClose2 = bNormalClose;
		final IEntity dataEntity2 = dataEntity;
		final WFInstance childWFInstance2 = childWFInstance;

		log.debug("开始[submitEmbedWorkflow]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				boolean bIAGoto = false;

				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();
				
				

				// 获取指定数据实例
				WFInstance wfInstance = new WFInstance();
				wfInstance.setWFInstanceId(wfActionParam.getInstanceId());
				wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, wfInstance, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000017,getLocalization(WFLanResTags.MSG_E_000017, new Object[]{ wfActionParam.getInstanceId()},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行提交处理", wfActionParam.getInstanceId())));
				}

				wfActionContext.setActiveWFInstance(wfInstance);
				
				//补足参数
				if(StringHelper.isNullOrEmpty(wfActionParam.getUserData())){
					wfActionParam.setUserData(wfInstance.getUserData());
				}
				if(StringHelper.isNullOrEmpty(wfActionParam.getUserData4())){
				wfActionParam.setUserData4(wfInstance.getUserData4());
				}

				// // 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				//refreshUserEntity(wfActionContext);

				// 判断当前步骤是否一致
				if (StringHelper.compare(wfActionParam.getStepId(), wfInstance.getActiveStepId(), true) != 0)
				{
					throw new WFException(WFErrors.E_000004,getLocalization(WFLanResTags.MSG_E_000004, new Object[]{ wfActionParam.getInstanceId(), wfActionParam.getStepId(), wfInstance.getActiveStepId()},StringHelper.format("提交实例[%1$s]处理步骤[%2$s]与当前步骤[%3$s]不一致", wfActionParam.getInstanceId(), wfActionParam.getStepId(), wfInstance.getActiveStepId())));
				}

				String strCurWFStepId = wfInstance.getActiveStepId();

				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				// 获取当前处理配置
				IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);

				wfActionContext.setWFVersionModel(iWFVersionModel);

				String strReturnValue = getWFDataCtrl().getEmbedWorkflowReturnValue(wfActionContext,childWFInstance2, dataEntity2, curWFProcessModel);

				IWFEmbedWFProcessModelBase baseEmbedConfig = (IWFEmbedWFProcessModelBase) curWFProcessModel;

				WFStepInst stepInst = new WFStepInst();
				stepInst.setWFStepInstId(KeyValueHelper.genUniqueId(childWFInstance2.getWFInstanceId(), wfActionParam.getStepId()));
				stepInst.setWFStepId(wfActionParam.getStepId());
				stepInst.setWFInstanceId(childWFInstance2.getWFInstanceId());
				if (bNormalClose2)
				{
					// 获取返回值
					stepInst.setCloseFlag(CLOSEFLAG_NORMAL);
					stepInst.setReturnData(strReturnValue);
				}
				else
				{
					stepInst.setCloseFlag(CLOSEFLAG_USERCLOSE);
					stepInst.setReturnData(EMBEDWFRETURN_USERCLOSE);
				}

				// 提交步骤
				getWFDataCtrl().closeWFStepInst(wfActionContext, stepInst);
				

				// 通过值获取连接
				IWFEmbedWFReturnModel wfReturnConfig = baseEmbedConfig.getWFEmbedWFReturnModelByValue(stepInst.getReturnData(),false);
				

				int nCount = getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId(), stepInst.getReturnData());
				

				boolean bGoNext = false;

				String strNextCondition = wfReturnConfig.getNextCondition();

				// 支持进一步扩展条件
				// ANY|ROLE|C1;C2;C3
				String[] conds = strNextCondition.split("[|]");
				if (conds.length >= 1)
					strNextCondition = conds[0];

				if (true)
				{
					TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
					// 判断是否预计其它操作
					if (conds.length >= 2)
					{
						String strOtherIA = conds[1];
						strOtherIA = strOtherIA.toUpperCase();
						if (!StringHelper.isNullOrEmpty(strOtherIA))
						{
							String[] ias = strOtherIA.split("[;]");
							for (int i = 0; i < ias.length; i++)
							{
								if (StringHelper.compare(ias[i], stepInst.getReturnData(), true) == 0)
									continue;
								otherIAMap.put(ias[i], 0);
							}
						}
					}

					if (StringHelper.compare(strNextCondition, "ANY", true) == 0)
					{
						if (nCount > 0)
						{
							// 该步骤可以完成
							bGoNext = true;
						}
					}
					else
					{
						// 判断是否合并其它操作
						for (String strIA : otherIAMap.keySet())
						{
							int nIAActionCount = getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId(), strIA);
							
							nCount += nIAActionCount;
						}

						int nActionCount = -1;
						int nActorCount = getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId());
						
						double fPercent = 0;
						if (StringHelper.compare(strNextCondition, "ALL", true) == 0)
						{
							nActionCount = nActorCount;
						}
						else
						{
							if (strNextCondition.indexOf("%") != -1)
							{
								strNextCondition = strNextCondition.replaceAll("[%]", "");
								fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
								fPercent = fPercent / 100.0;
							}
							else
							{
								try
								{
									nActionCount = Integer.parseInt(strNextCondition);
								}
								catch (Exception ex)
								{
									fPercent = (Double) DataTypeHelper.testDouble(strNextCondition);
								}
							}
						}

						if (nActionCount >= 1)
						{
							if (nCount >= nActionCount)
								bGoNext = true;
						}
						else
						{
							if (fPercent > 0 && nActorCount != 0 && ((double) nCount / (double) nActorCount >= fPercent))
							{
								bGoNext = true;
							}
						}
					}
				}

				if (bGoNext)
				{
					userCloseUnfinishEmbedWorkflows(wfActionContext, wfActionParam.getStepId(), false, "父流程步骤已经结束");

					WFStep activeStep = new WFStep();
					activeStep.setWFStepId(stepInst.getWFStepId());
					wfActionContext.setActiveWFStep(activeStep);
					internalExecuteProcess(wfActionContext, curWFProcessModel);
					
					internalFinishProcess(wfActionContext, curWFProcessModel);
					
					IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(wfReturnConfig.getNext(), false);

					internalExecute(wfActionContext, nextProcessConfig);
					return wfActionContext.createWFActionResult();
				}

				return wfActionContext.createWFActionResult();
			}
		});
	}


	/**
	 * 关闭嵌套流程
	 * @param wfActionContext
	 * @param strActiveStepId
	 * @param bSubmitEmbedWF
	 * @param strDescription
	 * @throws Exception
	 */
	protected void userCloseUnfinishEmbedWorkflows(WFActionContext wfActionContext, String strActiveStepId, boolean bSubmitEmbedWF, String strDescription) throws Exception
	{
		ArrayList<WFStepInst> wfStepInsts = new ArrayList<WFStepInst>();
		getWFDataCtrl().getUnfinishedWFStepInsts(wfActionContext, strActiveStepId, wfStepInsts);
		

		if (wfStepInsts.size() == 0)
			return;

		// 循环列出所有的实例
		for (WFStepInst wfStepInst : wfStepInsts)
		{
			WFInstance tempWFInst = new WFInstance();
			tempWFInst.setWFInstanceId(wfStepInst.getWFInstanceId());
			getWFDataCtrl().getWFInstance(wfActionContext, tempWFInst, false);
			

			WFActionParam wfParam = new WFActionParam();
			wfParam.setOpPersonId(wfActionContext.getOpPersonId());
			wfParam.setDescription(strDescription);
			wfParam.setWorkflowId(tempWFInst.getWFWorkflowId());
			wfParam.setInstanceId(tempWFInst.getWFInstanceId());
			wfParam.setUserData(tempWFInst.getUserData());
			wfParam.setUserData2(tempWFInst.getUserData2());
			wfParam.setUserData3(tempWFInst.getUserData3());
			wfParam.setUserData4(tempWFInst.getUserData4());
			wfParam.setSubmitEmbedWF(bSubmitEmbedWF);

			IWFService iWFService = WFModelGlobal.getWFModel(tempWFInst.getWFWorkflowId()).getWFService();
			iWFService.close(wfParam);

		}


	}

	/**
	 * 执行流程处理作业
	 * @param iWFServiceWork
	 * @return
	 * @throws Exception
	 */
	protected WFActionResult doWFServiceWork(IWFServiceWork iWFServiceWork) throws Exception
	{
		return doWFServiceWork(-1, iWFServiceWork);
	}

	/**
	 * 执行流程处理作业
	 * 
	 * @param nMode
	 * @param iServiceWork
	 * @throws Exception
	 */
	protected WFActionResult doWFServiceWork(int nMode, IWFServiceWork iServiceWork) throws Exception
	{
		long nBeginTime = java.lang.System.currentTimeMillis();
		
		
		// 判断当前是否在事物中
		try
		{
			SessionFactoryManager.addRef();
			org.hibernate.Transaction curTransaction = SessionFactoryManager.getCurrentTransaction(this.getSessionFactory());
			WFActionResult wfActionResult = iServiceWork.execute(new HibernateTransaction(curTransaction));
			SessionFactoryManager.releaseRef(true);

			log.debug(StringHelper.format("作业 耗时[%1$s]", java.lang.System.currentTimeMillis()-nBeginTime));

			return wfActionResult;
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			SessionFactoryManager.releaseRef(false);
			throw ex;
		}
	}

	protected IWFDataCtrl getWFDataCtrl()
	{
		return this.iWFDataCtrl;
	}

	protected IWFDataCtrl2 getWFDataCtrl2()
	{
		return this.iWFDataCtrl2;
	}
	
	
	/**
	 * 判断是否可以启动指定流程
	 * 
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testStart(IWFActionContext iWFActionContext) throws Exception
	{
		return true;
	}

	/**
	 * 判断是否可以重新启动指定流程
	 * 
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testRestart(IWFActionContext iWFActionContext) throws Exception
	{
		return true;
	}

	/**
	 * 判断是否可以取消指定流程
	 * 
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testClose(IWFActionContext iWFActionContext) throws Exception
	{
		return true;
	}

	/**
	 * 计算处理的下一步
	 * 
	 * @param iWFActionContext
	 * @param iWFProcessModel
	 * @return
	 * @throws Exception
	 */
	protected String calcWFProcessNext(IWFActionContext iWFActionContext, IWFProcessModel iWFProcessModel) throws Exception
	{
		return null;
	}


	

	/**
	 * 获取流程处理角色用户清单
	 * @param iWFActionContext
	 * @param iWFProcRoleModel
	 * @return
	 * @throws Exception
	 */
	protected Iterator<IWFProcRoleUser> getWFProcRoleUserModels(IWFActionContext iWFActionContext, IWFProcRoleModel iWFProcRoleModel) throws Exception
	{
		java.util.ArrayList<IWFProcRoleUser> iWFProcRoleUserList = new java.util.ArrayList<IWFProcRoleUser> ();
		java.util.Iterator<IWFRoleUser>  wfRoleUsers = iWFProcRoleModel.getWFRoleUserModels(iWFActionContext);
		if(wfRoleUsers!=null)
		{
			while(wfRoleUsers.hasNext())
			{
				iWFProcRoleUserList.add(WFProcRoleUser.fromWFRoleUser(wfRoleUsers.next(), iWFProcRoleModel));
			}
		}	
		return iWFProcRoleUserList.iterator();
	}

	
	/**
	 * 获取交互操作附加的流程角色用户
	 * @param iWFActionContext
	 * @param iWFInteractiveLinkModel
	 * @return
	 * @throws Exception
	 */
	protected Iterator<IWFProcRoleUser> getAddedWFProcRoleUserModels(IWFActionContext iWFActionContext, IWFInteractiveLinkModel iWFInteractiveLinkModel) throws Exception
	{
		java.util.ArrayList<IWFProcRoleUser> iWFProcRoleUserList = new java.util.ArrayList<IWFProcRoleUser> ();
		java.util.Iterator<IWFRoleUser>  wfRoleUsers = iWFInteractiveLinkModel.getAddedWFRoleUserModels(iWFActionContext);
		if(wfRoleUsers!=null)
		{
			while(wfRoleUsers.hasNext())
			{
				iWFProcRoleUserList.add(WFProcRoleUser.fromWFRoleUser(wfRoleUsers.next(), iWFInteractiveLinkModel.getAddedWFRoleId()));
			}
		}	
		return iWFProcRoleUserList.iterator();
	}
	
	
	/**
	 * 准备附加处理更多用户
	 * @return
	 */
	protected void internalPrepareIAAddedWFStepActor(WFActionContext wfActionContext, IWFInteractiveProcessModel iaProcessConfig,IWFInteractiveLinkModel wfIALinkModel) throws Exception
	{
		java.util.Iterator<IWFRoleUser> wfRoleUsers =  wfIALinkModel.getAddedWFRoleUserModels(wfActionContext);
		if(wfRoleUsers == null)
			return ;
		
		HashMap<String, String> wfStepActorMap = new HashMap<String, String>();
		HashMap<String, Integer> wfUserRecInformMap = new HashMap<String, Integer>();
		
//		boolean bActorIAActionControl = iaProcessConfig.isActorIAActionControl();
		java.util.Iterator<IWFProcRoleUser> wfProcRoleUserModels =  getAddedWFProcRoleUserModels(wfActionContext,wfIALinkModel);
		if (wfProcRoleUserModels != null)
		{
			while (wfProcRoleUserModels.hasNext())
			{
				IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();
//				if (wfActionContext.isEnableNextIAStepActors())
//				{
//					if (!wfActionContext.getNextIAStepActorMap().containsKey(iWFProcRoleUser.getWFUserId()))
//						continue;
//				}

				WFStepActor stepActor = new WFStepActor();
				stepActor.setWFStepActorName(iWFProcRoleUser.getWFUserName());
				stepActor.setWFStepId(wfActionContext.getActiveWFInstance().getActiveStepId());
				stepActor.setIsReadOnly(0);
				stepActor.setActorId(iWFProcRoleUser.getWFUserId());

				stepActor.setActorType(ACTORTYPE_WFACTOR);
				stepActor.setRoleId(iWFProcRoleUser.getWFRoleId());
				
				stepActor.set(IWFProcRoleUser.FIELD_IGNORESUBSTITUTE, iWFProcRoleUser.get(IWFProcRoleUser.FIELD_IGNORESUBSTITUTE));
				stepActor.set(IWFProcRoleUser.FIELD_ORIGINALWFUSERID, iWFProcRoleUser.get(IWFProcRoleUser.FIELD_ORIGINALWFUSERID));
				
				

//				if (bActorIAActionControl)
//				{
//					String strActions = "";
//					java.util.Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
//					if (wfInteractiveLinkModels != null)
//					{
//						while (wfInteractiveLinkModels.hasNext())
//						{
//							IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
//							if (!iWFInteractiveLinkModel.isActorIAActionControl() || iWFInteractiveLinkModel.containsWFProcRole(iWFProcRoleModel))
//							{
//								if (!StringHelper.isNullOrEmpty(strActions))
//								{
//									strActions += ";";
//								}
//
//								strActions += StringHelper.format("(%1$s)", iWFInteractiveLinkModel.getName());
//							}
//						}
//					}
//					// 放入列表中
//					if (StringHelper.isNullOrEmpty(strActions))
//						strActions = "NONE";
//					stepActor.setIAActions(strActions);
//				}

				if(!getWFDataCtrl().addWFStepActor(wfActionContext, stepActor))
					continue;
				wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue(stepActor,WFUser.FIELD_RECVINFORM,1));
				wfStepActorMap.put(iWFProcRoleUser.getWFUserId(), stepActor.getActorId());
				continue;
			}
		}

		if (iaProcessConfig.isSendInform())
		{
			HashMap<String, String> wfStepActorMapReal = new HashMap<String, String>();
			for (String strActorId : wfStepActorMap.keySet())
			{
				String strRealActorId = wfStepActorMap.get(strActorId);
				if (StringHelper.isNullOrEmpty(strRealActorId))
					strRealActorId = strActorId;
				wfStepActorMapReal.put(strRealActorId, "");
			}

			ArrayList<String> actors = new ArrayList<String>();
			for (String strActorId : wfStepActorMapReal.keySet())
			{
				Integer nRecvInform = wfUserRecInformMap.get(strActorId);
				if(nRecvInform==null||nRecvInform==1)
					actors.add(strActorId);
			}
			// 发送任务通知
			getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
		}

		getWFDataCtrl().updateCurWFStepActors(wfActionContext);

	}
	
	
	/**
	 * 获取系统运行时
	 * @return
	 */
	protected ISystemRuntime getSystemRuntime() {
		return (ISystemRuntime) this.getSystemModel();
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

	/**
	 * 获取代码项文本
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	protected String getCodeItemText(ICodeList codelist, String strValue) {
		if(codelist != null) {
			try {
				return codelist.getCodeListText(strValue, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return strValue;
	}
	
	/**
	 * 获取代码项语言资源
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	protected String getCodeItemLanResTag(ICodeList codelist, String strValue) {
		if(codelist != null) {
			try {
				ICodeItem codeItem = codelist.getCodeItem(strValue, true);
				if(codeItem != null)
					return codeItem.getTextLanResTag();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public WFActionResult suspend(WFActionParam wpParam) throws Exception {
		throw new Exception("没有实现");
	}



	@Override
	public WFActionResult resume(WFActionParam wpParam) throws Exception {
		final WFActionParam wfActionParam = wpParam;
		log.debug("开始[markReadFlag]作业");
		return this.doWFServiceWork(new IWFServiceWork()
		{
			@Override
			public WFActionResult execute(ITransaction iTransaction) throws Exception
			{
				WFActionContext wfActionContext = new WFActionContext();
				wfActionContext.setWFModel(getWFModel());
				wfActionContext.setWFActionParam(wfActionParam);
				wfActionContext.setUserTag(wfActionParam.getUserTag());
				wfActionContext.setUserTag2(wfActionParam.getUserTag2());
				wfActionContext.getReturnInfoSB().reset();

				// 从数据库中查出当前数据
				IEntity iEntity = getUserEntity(wfActionContext);
				wfActionContext.setActiveEntity(iEntity);

				// 获取指定数据实例
				WFInstance wfInstance = getWFDataCtrl().getWFInstance(wfActionContext, null, false);
				// 判断实例的状态
				if (DataObject.getBoolValue(wfInstance.getIsClose(), false))
				{
					throw new WFException(WFErrors.E_000040,getLocalization(WFLanResTags.MSG_E_000040, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]已经关闭，无法进行继续操作",iEntity.get("srfdatainfo"))));
				}
				
				if (!DataObject.getBoolValue(wfInstance.getSuspendFlag(), false))
				{
					throw new WFException(WFErrors.E_000041,getLocalization(WFLanResTags.MSG_E_000041, new Object[]{iEntity.get("srfdatainfo")},StringHelper.format("指定工作流实例[%1$s]没有被挂起，无法进行继续操作",iEntity.get("srfdatainfo"))));
				}
				
				// 从配置中加载配置
				IWFVersionModel iWFVersionModel = getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());
				wfActionContext.setActiveWFInstance(wfInstance);
				wfActionContext.setWFVersionModel(iWFVersionModel);
				
				getWFDataCtrl2().resumeWFInstance(wfActionContext, wfInstance);

				WFStepData stepData = new WFStepData();
				String strLogicName = getLocalization(WFLanResTags.MSG_STEP_RESUME,"流程继续");
				stepData.setWFStepDataName(strLogicName);
				stepData.setWFActionLanResTag(WFLanResTags.MSG_STEP_RESUME);
				stepData.setWFPLogicName(strLogicName);
				stepData.setWFStepLanResTag(WFLanResTags.MSG_STEP_RESUME);
				stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
				stepData.setConnectionName(TAG_SRFWFRESUME);
				stepData.setWFInstanceId(wfInstance.getWFInstanceId());
				stepData.setActorId(wfActionContext.getOpPersonId());
				stepData.setActorName(wfActionContext.getOpPersonName());
				
				
				getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
				
				//执行
				internalExecute(wfActionContext, null);

				return wfActionContext.createWFActionResult();
			}
		});
	}
	
	
	
	
	
}
