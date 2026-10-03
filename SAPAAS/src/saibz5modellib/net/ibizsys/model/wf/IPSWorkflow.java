package net.ibizsys.model.wf;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.pswf.core.IWFModel;

/**
 * 系统工作流对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWorkflow extends IPSSystemObject, IWFModel {
	
	
	/**
	 * 工作流引擎类型：iBiz内置
	 */
	public final static String WFENGINETYPE_EMBEDDED = "EMBEDDED";

	/**
	 * 工作流引擎类型：Java Activiti
	 */
	public final static String WFENGINETYPE_ACTIVITI = "ACTIVITI";
	
	
	/**
	 * 工作流引擎代理模式：无
	 */
	public final static int WFPROXYMODE_NONE = 0;
	
	
	/**
	 * 工作流引擎代理模式：使用外部代理服务
	 */
	public final static int WFPROXYMODE_CLIENT = 1;
	
	
	/**
	 * 工作流引擎代理模式：为外部提供服务
	 */
	public final static int WFPROXYMODE_SERVER = 2;
	

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 获取流程版本对象集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFVersion> getPSWFVersions() throws Exception;

	/**
	 * 获取流程版本对象
	 * 
	 * @param strWFVersionId
	 * @return
	 * @throws Exception
	 */
	IPSWFVersion getPSWFVersion(String strWFVersionId) throws Exception;

	/**
	 * 获取流程实体对象集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEWF> getPSWFDEs() throws Exception;

	/**
	 * 获取指定实体工作流配置
	 * 
	 * @param strPSDEWFId
	 * @return
	 * @throws Exception
	 */
	IPSDEWF getPSDEWF(String strPSDEWFId) throws Exception;

	/**
	 * 获取流程步骤代码表对象
	 * 
	 * @return
	 */
	IPSCodeList getWFStepPSCodeList();

	/**
	 * 获取业务状态步骤代码表对象
	 * 
	 * @return
	 */
	IPSCodeList getEntityStatePSCodeList();

	/**
	 * 获取实体流程状态
	 * 
	 * @return
	 */
	java.util.Iterator<String> getEntityWFStates();

	/**
	 * 获取最新的流程版本
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSWFVersion getLastPSWFVersion() throws Exception;

	/**
	 * 是否启用
	 * 
	 * @return
	 */
	boolean isValid();

	/**
	 * 获取流程编号
	 * 
	 * @return
	 */
	String getWFSN();
//
//	
//
//	/**
//	 * 微信公众号账户
//	 * 
//	 * @return
//	 */
//	IPSWXAccount getPSWXAccount();
//
//	/**
//	 * 获取微信企业应用
//	 * 
//	 * @return
//	 */
//	IPSWXEntApp getPSWXEntApp();
//
//	
//	
//	/**
//	 * 是否支持动态视图
//	 * @return
//	 */
//	@Deprecated
//	boolean isEnableDynamicView();
//	
	
	/**
	 * 获取使用的工作流引擎类型
	 * @return
	 */
	String getWFEngineType();
	
	
	
	/**
	 * 是否为动态工作流
	 * @return
	 */
	boolean isDynamicWorkflow();
	
	
	
	/**
	 * 获取工作流名称语言资源
	 * @return
	 */
	IPSLanguageRes getNamePSLanguageRes();
//	
//	
//	/**
//	 * 获取系统模块
//	 * @return
//	 */
//	IPSSystemModule getPSSystemModule();
	
	
	/**
	 * 是否使用远程引擎
	 * @return
	 */
	boolean isUseRemoteEngine();
	
	
	/**
	 * 获取工作流代理模式，值参考 net.ibizsys.model.wf.IPSWorkflow.WFPROXYMODE_XXX 定义
	 * @return
	 */
	int getWFProxyMode();
}
