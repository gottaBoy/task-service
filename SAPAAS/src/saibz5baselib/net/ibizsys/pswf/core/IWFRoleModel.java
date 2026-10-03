package net.ibizsys.pswf.core;

import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 流程角色模型接口
 * 
 * @author lionlau
 *
 */
public interface IWFRoleModel {
	// 定义流程角色类型代码表

	/**
	 * 用户组
	 */
	public final static String WFROLETYPE_USERGROUP = "USERGROUP";

	/**
	 * 自定义
	 */
	public final static String WFROLETYPE_CUSTOM = "CUSTOM";

	/**
	 * 实体数据集合
	 */
	public final static String WFROLETYPE_DEDATASET = "DEDATASET";

	/**
	 * 常规用户
	 */
	public final static String User = "USER";

	/**
	 * 用户组
	 */
	public final static String UserGroup = "USERGROUP";

	/**
	 * 系统用户
	 */
	public final static String SystemUser = "SYSTEMUSER";

	/**
	 * 动态用户
	 */
	public final static String DynamicUser = "DYNAMICUSER";

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
	 * 获取系统模型
	 * 
	 * @return
	 */
	ISystemModel getSystemModel();

	/**
	 * 获取流程角色类型
	 * 
	 * @return
	 */
	String getWFRoleType();

	/**
	 * 获取角色用户集合
	 * 
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception;

	/**
	 * 获取运行时标识
	 * 
	 * @return
	 */
	Object getRuntimeId();

	/**
	 * 设置运行时标识
	 * 
	 * @param objId
	 */
	void setRuntimeId(Object objId);
}
