package net.ibizsys.paas.security;

/**
 * 数据访问行为
 * 
 * @author Administrator
 *
 */
public class DataAccessActions {
	
	/**
	 * 全部操作，用于映射关系数据操作
	 */
	public final static String ALL = "ALL";

	/**
	 * 无操作，对于此操作标识返回成功
	 */
	public final static String NONE = "NONE";
	
	
	/**
	 * 无操作，对于此操作标识返回禁止
	 */
	public final static String DENY = "DENY";
	
	/**
	 * 建立
	 */
	public final static String CREATE = "CREATE";

	/**
	 * 读取
	 */
	public final static String READ = "READ";

	/**
	 * 更新
	 */
	public final static String UPDATE = "UPDATE";

	/**
	 * 工作流操作模式,权限相当于UPDATE
	 */
	public final static String WFACTION = "WFACTION";

	/**
	 * 删除
	 */
	public final static String DELETE = "DELETE";

	/**
	 * 修改子数据
	 */
	public final static String MODIFYCHILD = "MODIFYCHILD";

	/**
	 * 工作流启动
	 */
	public final static String WFSTART = "WFSTART";

	/**
	 * 工作流重新启动
	 */
	public final static String WFRESTART = "WFRESTART";

	/**
	 * 工作流取消
	 */
	public final static String WFCANCEL = "WFCANCEL";

	/**
	 * 查看当前工作节点
	 */
	public final static String WFVIEWSTEPACTOR = "WFVIEWSTEPACTOR";

	/**
	 * 查看当前流程历史步骤
	 */
	public final static String WFVIEWSTEPDATA = "WFVIEWSTEPDATA";

}
