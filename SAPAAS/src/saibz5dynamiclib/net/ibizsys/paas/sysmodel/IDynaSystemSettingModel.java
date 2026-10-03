package net.ibizsys.paas.sysmodel;


/**
 * 动态系统设置模型对象接口
 * @author Administrator
 *
 */
public interface IDynaSystemSettingModel extends IDynaSystemSetting {

	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	

	
	
	/**
	 * 同步全部视图
	 * @throws Exception
	 */
	void syncAllViews()throws Exception;
	
	
	
	/**
	 * 同步全部工作流
	 * @throws Exception
	 */
	void syncAllWorkflows()throws Exception;
	
	
	/**
	 * 同步指定视图
	 * @param strViewId 视图标识
	 *  
	 * @throws Exception
	 */
	void syncView(String strViewId)throws Exception;
	
	
	
	/**
	 * 同步指定工作流
	 * @param strWorkflowId 工作流标识
	 * @throws Exception
	 */
	void syncWorkflow(String strWorkflowId)throws Exception;
	
	
	
	/**
	 * 获取指定动态实例对象
	 * @param strDynaSystemId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IDynaInst getDynaInst(String strDynaSystemId,boolean bTryMode)throws Exception;
	
	
}
