package net.ibizsys.pswf.core;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 流程模型对象接口
 * @author lionlau
 *
 */
public interface IWFModel extends IModelBase
{
	
	// 定义流程引擎类型代码表

	/**
	 * 流程引擎类型：iBiz内置
	 */
	final static String WFENGINETYPE_EMBEDDED = "EMBEDDED";

	/**
	 * 流程引擎类型：Java Activiti
	 */
	final static String WFENGINETYPE_ACTIVITI = "ACTIVITI";
		
	/**
	 * 流程引擎类型：Java Activiti
	 */
	final static String WFENGINETYPE_ACTIVITI_REMOTE = "ACTIVITI_REMOTE";
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	
	
	/**
	 * 建立数据对象
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IEntity createEntity(String strDEName)throws Exception; 
	
	
	/**
	 * 获取流程步骤代码表模型
	 * @return
	 */
	ICodeList getWFStepCodeList();
	
	
	
	/**
	 * 获取数据对象状态代码表模型
	 * @return
	 */
	ICodeList getEntityStateCodeList();
	
	
	
	/**
	 * 获取实体流程状态
	 * @return
	 */
	java.util.Iterator<String> getEntityWFStates();
	
	
	
	/**
	 * 获取最新的流程版本模型
	 * @return
	 */
	IWFVersionModel getLastWFVersionModel();
	
	
	
	
	/**
	 * 获取最新的流程版本模型
	 * @param strWFMode 流程模式
	 * @return
	 */
	IWFVersionModel getLastWFVersionModel(String strWFMode)throws Exception;
	
//	/**
//	 * 获取子工作流模型集合
//	 * @return
//	 */
//	java.util.Iterator<IWFSubWFModel> getWFSubWFModels();
	
	
	
	
	/**
	 * 获取指定的流程版本模型
	 * @nVersion 流程版本
	 * @return
	 */
	IWFVersionModel getWFVersionModelByWFVersion(int nVersion)throws Exception;
	
	
	/**
	 * 获取指定的流程版本模型
	 * @param strWFVersionId 流程版本标识
	 * @return
	 */
	IWFVersionModel getWFVersionModel(String strWFVersionId)throws Exception;
	
	
	/**
	 * 判断是否为业务状态中的工作流状态
	 * @param strWFState
	 */
	boolean isEntityWFState(String strWFState);
	
	
	/**
	 * 获取流程服务对象
	 * @return
	 */
	IWFService getWFService();
	

	
	/**
	 * 获取实体的流程状态值
	 * @return
	 */
	String getEntityWFState();
	
	
	
	
	/**
	 * 获取催办消息模板标识
	 * @return
	 */
	String getRemindMsgTemplId();
	
	/**
	 * 获取微信公众号标识
	 * @return
	 */
	String getWXAccountId();
	
	
	/**
	 * 获取微信企业应用标识
	 * @return
	 */
	String getWXEntAppId();
	
	
	/**
	 * 获取运行时标识
	 * @return
	 */
	Object getRuntimeId();
	
	
	/**
	 * 设置运行时标识
	 * @param objId
	 */
	void setRuntimeId(Object objId);

	
	/**
	 * 获取使用的工作流引擎类型，值参考 net.ibizsys.pswf.core.IWFModel.WFENGINETYPE_XXX 定义
	 * @return
	 */
	String getWFEngineType();
	
	
	
	
	/**
	 * 获取名称语言资源标识
	 * @return
	 */
	String getNameLanResTag();
	
	
	
	/**
	 * 获取使用的工作流引擎类型分类
	 * @return
	 */
	String getWFEngineCat();
	
	
	
	
	/**
	 * 获取默认流程实体名称
	 * @return
	 */
	String getDefaultDEName();
}
