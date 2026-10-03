package net.ibizsys.paas.sysmodel;

/**
 * 动态系统存储对象接口
 * @author Administrator
 *
 */
public interface IDynaSystemStorage {

	
	/**
	 * 初始化
	 * @param iDynaSystemSetting
	 * @throws Exception
	 */
	void init(IDynaSystemSetting iDynaSystemSetting) throws Exception;
	
	
	/**
	 * 获取动态系统设置
	 * @return
	 */
	IDynaSystemSetting getDynaSystemSetting();
	
	/**
	 * 安装全部数据
	 * @throws Exception
	 */
	void installAll()throws Exception;
	
	/**
	 * 安装全部工作流
	 * @throws Exception
	 */
	void installAllWorkflows() throws Exception ;
	
	
	/**
	 * 安装全部代码表
	 * @throws Exception
	 */
	void installAllCodeLists() throws Exception ;
	
	
	
	/**
	 * 同步全部数据
	 * @throws Exception
	 */
	void syncAll()throws Exception;
	
	
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
	 * 同步全部代码表
	 * @throws Exception
	 */
	void syncAllCodeLists()throws Exception;
	
	
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
	 * 同步指定代码表
	 * @param strCodeListId 工作流标识
	 * @throws Exception
	 */
	void syncCodeList(String strCodeListId)throws Exception;
	
	
	
	
}
