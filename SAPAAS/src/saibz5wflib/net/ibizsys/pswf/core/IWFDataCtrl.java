package net.ibizsys.pswf.core;

import java.util.ArrayList;

import net.ibizsys.paas.entity.IEntity;
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

/**
 * 流程数据操作对象接口
 * @author lionlau
 *
 */
public interface IWFDataCtrl
{
	/**
	 * 用户数据组织标识
	 */
	final static String USERENTITY_ORGID = "srforgid";
	
	/**
	 * 用户数据组织名称
	 */
	final static String USERENTITY_ORGNAME = "srforgname";
	

	
	/**
	 * 初始化
	 * @param iWFModel
	 * @throws Exception
	 */
	void init(IWFModel iWFModel) throws Exception;
	
	

	/**
	 *  获取工作流实例
	 * @param iWFContext
	 * @param wfInstance
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	WFInstance getWFInstance(IWFActionContext2 iWFContext ,WFInstance wfInstance,boolean bTryMode) throws Exception;
	
	

	/**
	 * 获取流程交互操作
	 * @param iWFContext
	 * @param strWFStepId
	 * @param strActionName
	 * @param iaAction
	 * @throws Exception
	 */
	void getWFIAAction(IWFActionContext2 iWFContext ,String strWFStepId,String strActionName ,WFIAAction iaAction) throws Exception;
	
	
	
	

	 /**
	  * 获取流程处理步骤代办用户
	 * @param iWFContext
	 * @param strWFStepActorId 步骤操作者标识
	 * @param strAssistUserId
	 * @param userAssist
	 * @throws Exception
	 */
	void getWFUserAssist(IWFActionContext2 iWFContext,String strWFStepActorId,String strAssistUserId,WFUserAssist userAssist) throws Exception;
	
	 
	 

	/**
	 * 获取流程处理步骤代办用户列表
	 * @param iWFContext
	 * @param strWFStepActorId
	 * @param strAssistUserId
	 * @param userAssists
	 * @throws Exception
	 */
	void getWFUserAssists(IWFActionContext2 iWFContext,String strWFStepActorId,String strAssistUserId,ArrayList<WFUserAssist> userAssists) throws Exception;
	 
	 
	

	/**
	 * 获取工作流交互操作
	 * @param strWFID
	 * @param strWFActionId
	 * @param action
	 * @throws Exception
	 */
	void getWFAction(String strWFID, String strWFActionId ,WFAction action) throws Exception;
	

	/**
	 * 获取步骤操作次数
	 * @param iWFContext
	 * @param strWFStepId
	 * @param strActionName
	 * @return
	 * @throws Exception
	 */
	int getWFStepDataCount(IWFActionContext2 iWFContext, String strWFStepId,String strActionName) throws Exception;
	
	

	/**
	 * 获取步骤操作者次数
	 * @param iWFContext
	 * @param strWFStepId
	 * @return
	 * @throws Exception
	 */
	int getWFStepActorCount(IWFActionContext2 iWFContext, String strWFStepId) throws Exception;
	
	

	/**
	 * 获取步骤操作者清单
	 * @param iWFContext
	 * @param strWFStepId
	 * @param list
	 * @throws Exception
	 */
	void getWFStepActors(IWFActionContext2 iWFContext ,String strWFStepId,ArrayList<WFStepActor> list) throws Exception;
	
	
	

	/**
	 * 获取步骤的操作数据清单
	 * @param iWFContext
	 * @param strWFStepId
	 * @param list
	 * @throws Exception
	 */
	void getWFStepDatas(IWFActionContext2 iWFContext,String strWFStepId,ArrayList<WFStepData> list) throws Exception;
	
	

	/**
	 * 步骤操作角色数量
	 * @param iWFContext
	 * @param strWFStepId
	 * @return
	 * @throws Exception
	 */
	int getWFStepRoleCount(IWFActionContext2 iWFContext, String strWFStepId) throws Exception;
	
	

	/**
	 * 通过步骤及角色删除没有操作的步骤用户
	 * @param iWFContext
	 * @param strWFStepId
	 * @param strRoleId
	 * @throws Exception
	 */
	void removeNoDataWFStepActor(IWFActionContext2 iWFContext,String strWFStepId,String strRoleId) throws Exception;
	
	
	
	/**
	 * 获取流程的业务数据
	 * @param iWFActionContext
	 * @param iEntity
	 * @throws Exception
	 */
	void getWFUserEntity(IWFActionContext2 iWFActionContext ,IEntity iEntity) throws Exception;
	
	
	/**
	 * 更新执行步骤至用户数据
	 * @param iWFActionContext
	 * @param strWFStepValue
	 * @throws Exception
	 */
	void updateWFUserDataRunStep(IWFActionContext2 iWFActionContext ,String strWFStepValue) throws Exception;
	
	
	/**
	 * 建立流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void addWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	/**
	 * 完成流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void finishWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	/**
	 * 重置流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void resetWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	

	/**
	 * 标记流程实例发生错误
	 * @param instance
	 * @param strErrorInfo 错误信息
	 * @param strOpPersonId
	 * @throws Exception
	 */
	void errorWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	/**
	 * 删除流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void removeWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	/**
	 * 用户关闭流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void userCloseWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	/**
	 * 添加流处理步骤
	 * @param iWFActionContext
	 * @param step
	 * @throws Exception
	 */
	void addWFStep(IWFActionContext2 iWFActionContext,WFStep step) throws Exception;
	
	/**
	 * 添加流程执行步骤
	 * @param iWFActionContext
	 * @param stepData
	 * @throws Exception
	 */
	void addWFStepData(IWFActionContext2 iWFActionContext,WFStepData stepData) throws Exception;
	
	
	/**
	 * 测试是否可以进行流程交互操作
	 * @param iWFActionContext
	 * @param stepData
	 * @throws Exception
	 */
	void testWFStepData(IWFActionContext2 iWFActionContext,WFStepData stepData) throws Exception;
	
	
	/**
	 * 完成流程步骤
	 * @param iWFContext
	 * @param step
	 * @throws Exception
	 */
	void finishWFStep(IWFActionContext2 iWFContext,WFStep step) throws Exception;
	
	
	/**
	 * 添加流程步骤操作者，要排除重复值
	 * @param iWFContext
	 * @param stepActor
	 * @throws Exception
	 */
	boolean addWFStepActor(IWFActionContext2 iWFContext,WFStepActor stepActor) throws Exception;
	
	
	/**
	 * 添加流程步骤交互操作
	 * @param iWFContext
	 * @param iaAction
	 * @throws Exception
	 */
	void addWFIAAction(IWFActionContext2 iWFContext,WFIAAction iaAction) throws Exception;
	
	
	/**
	 * 添加流程临时步骤操着者
	 * @param iWFContext
	 * @param tmpStepActors
	 * @throws Exception
	 */
	void addWFTmpStepActors(IWFActionContext2 iWFContext,ArrayList<WFTmpStepActor> tmpStepActors) throws Exception;
	
	
	/**
	 * 移除流程临时步骤操着者
	 * @param iWFContext
	 * @param strWFStepId
	 * @throws Exception
	 */
	void removeWFTmpStepActors(IWFActionContext2 iWFContext,String strWFStepId) throws Exception;
	
	
	
	/**
	 * 发送通知至步骤操作用户
	 * @param iWFContext
	 * @param actors
	 * @param strMsgTemplateId
	 * @param nMsgType
	 * @throws Exception
	 */
	void sendWFStepActorInformMsg(IWFActionContext2 iWFContext,ArrayList<String> actors,String strMsgTemplateId,int nMsgType) throws Exception;
	

	/**
	 * 计算超时时间
	 * @param srcTime
	 * @param strTimeoutType
	 * @param nAmount
	 * @param strWorkdayType
	 * @return
	 * @throws Exception
	 */
	java.sql.Timestamp calcTimeout(java.sql.Timestamp srcTime,String strTimeoutType,int nAmount,String strWorkdayType) throws Exception;
	
	
	/**
	 * 判断步骤是否存在指定交互处理
	 * @param strStepId
	 * @param strActionName
	 * @param strOpPersonId
	 * @return
	 */
	void testIAAction(String strStepId,String strActionName,String strOpPersonId) throws Exception;
	
	
	/**
	 * 执行SQL命令
	 * @param strSQL
	 * @return
	 */
	void execRawSql(String strSQL) throws Exception;
	

	/**
	 * 获取工作流操作者对象
	 * @param iWFContext
	 * @param wfActor
	 * @throws Exception
	 */
	void getWFActor(IWFActionContext2 iWFContext, WFActor wfActor) throws Exception;
	
	
	/**
	 * 获取工作流系统用户
	 * @param strActorId
	 * @param wfActor
	 * @return
	 */
	void getWFSystemUser(IWFActionContext2 iWFContext,String strActorId, ArrayList<WFUser> list) throws Exception;
	
	
	
	/**
	 * 测试启动流程
	 * @param iWFActionContext
	 * @return
	 */
	boolean testStartWF(IWFActionContext2 iWFActionContext) throws Exception;
	
	
	
	/**
	 * 测试重启流程
	 * @param iWFActionContext
	 * @return
	 */
	boolean testRestartWF(IWFActionContext2 iWFActionContext) throws Exception;
	
	
	
	/**
	 * 测试取消流程
	 * @param iWFActionContext
	 * @return
	 */
	boolean testCancelWF(IWFActionContext2 iWFActionContext) throws Exception;
	

	/**
	 * 获取要启动的嵌入子流程
	 * @param iWFActionContext
	 * @param iWFEmbedWorkflowModel
	 * @param wfParams
	 * @throws Exception
	 */
	void getEmbedWorkflows(IWFActionContext2 iWFActionContext, IWFEmbedWFProcessModel iWFEmbedWorkflowModel, ArrayList<WFActionParam> wfParams) throws Exception;
	
	
	/**
	 * 获取要启动的并行子流程
	 * @param iWFActionContext
	 * @param iWFParallelSubWFModel
	 * @param wfParams
	 * @return
	 */
	void getParallelSubWFs(IWFActionContext2 iWFActionContext, IWFParallelSubWFProcessModel iWFParallelSubWFModel, ArrayList<WFActionParam> wfParams) throws Exception;
	
	
	/**
	 * 增加步骤实例
	 * @param iWFActionContext
	 * @param wfStepInst
	 * @return
	 */
	void addWFStepInst(IWFActionContext2 iWFActionContext,WFStepInst wfStepInst) throws Exception;
	
	
	/**
	 * 关闭步骤实例
	 * @param iWFActionContext
	 * @param wfStepInst
	 * @return
	 */
	void closeWFStepInst(IWFActionContext2 iWFActionContext,WFStepInst wfStepInst) throws Exception;
	
	/**
	 * 获取具备指定返回值的流程实例数量
	 * @param iWFActionContext
	 * @param strStepId
	 * @param strReturnValue
	 * @return
	 */
	int getWFStepInstCount(IWFActionContext2 iWFActionContext,String strWFStepId,String strReturnValue) throws Exception;
	
	/**
	 * 获取步骤实例数量
	 * @param iWFActionContext
	 * @param strWFStepId
	 * @return
	 */
	int getWFStepInstCount(IWFActionContext2 iWFActionContext,String strWFStepId) throws Exception;
	
	
	/**
	 * 获取未完成的步骤实例
	 * @param iWFActionContext
	 * @param strWFStepId
	 * @param stepInsts
	 * @return
	 */
	void getUnfinishedWFStepInsts(IWFActionContext2 iWFActionContext,String strWFStepId,ArrayList<WFStepInst> stepInsts) throws Exception;
	
	
	/**
	 * 更新当前流程步骤的用户
	 * @param iWFActionContext
	 * @return
	 */
	void updateCurWFStepActors(IWFActionContext2 iWFActionContext) throws Exception;
	
	
	
	/**
	 * 标记步骤用户读标志
	 * @param iWFActionContext
	 * @param wfStepActor
	 * @return
	 */
	void markWFStepActorReadFlag(IWFActionContext2 iWFActionContext,WFStepActor wfStepActor) throws Exception;
	

	/**
	 * 获取嵌入流程返回值，包括了嵌入流程及并行子流程
	 * @param iWFActionContext
	 * @param childWFInstance2
	 * @param dataEntity
	 * @param iWFProcessModel
	 * @return
	 * @throws Exception
	 */
	String getEmbedWorkflowReturnValue(IWFActionContext2 iWFActionContext,WFInstance childWFInstance2,IEntity dataEntity,  IWFProcessModel iWFProcessModel) throws Exception;
	
	
	
	/**
	 * 直接填充步骤数据，放入类似启动，关闭等步骤信息
	 * @param iWFActionContext
	 * @param stepData
	 * @return
	 */
	void addRawWFStepData(IWFActionContext2 iWFActionContext,WFStepData stepData) throws Exception;
	
	
	
	/**
	 * 获取最后提交的步骤操作
	 * @param iWFActionContext
	 * @param stepData
	 * @return
	 */
	void getLastWFStepData(IWFActionContext2 iWFActionContext,WFStepData stepData) throws Exception;
	
	
	
	/**
	 * 对于刚启动的流程执行取消操作，对流程进行关闭，并进一步调用 WFCANCELSTART 逻辑，交由用户将数据进行重置。
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void cancelStartWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	
}
