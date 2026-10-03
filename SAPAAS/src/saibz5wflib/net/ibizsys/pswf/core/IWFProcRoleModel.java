package net.ibizsys.pswf.core;

/**
 * 流程处理角色模型接口
 * 
 * @author lionlau
 * 
 */
public interface IWFProcRoleModel
{

	// 定义角色类型代码表

	/**
	 * 工作流角色
	 */
	public final static String ROLETYPE_WFROLE = "WFROLE";

	/**
	 * 上两个步骤操作者
	 */
	public final static String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";

	/**
	 * 上三个步骤操作者
	 */
	public final static String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";

	/**
	 * 上一步骤操作者
	 */
	public final static String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
	
	
	/**
	 * 用户数据操作者
	 */
	public final static String ROLETYPE_UDACTOR = "UDACTOR";
	
	
	/**
	 * 当前操作者
	 */
	public final static String ROLETYPE_CURACTOR = "CURACTOR";
	
	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 初始化
	 * 
	 * @param iWFInteractiveProcessModel
	 * @throws Exception
	 */
	void init(IWFInteractiveProcessModel iWFInteractiveProcessModel) throws Exception;

	/**
	 * 获取交互处理模型对象
	 * @return
	 */
	IWFInteractiveProcessModel getWFInteractiveProcessModel();
	
	
	/**
	 * 获取流程角色类型
	 * 
	 * @return
	 */
	String getWFProcRoleType();

	/**
	 * 获取流程角色标识
	 * 
	 * @return
	 */
	String getWFRoleId();
	
	
	
	/**
	 * 获取流程角色模型
	 * @return
	 */
	IWFRoleModel getWFRoleModel();
	
	
	/**
	 * 获取用户数据属性
	 * @return
	 */
	String[] getUDFields(); 
	
	
	
	
	/**
	 * 获取用户集合
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext)throws Exception;
}
