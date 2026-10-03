package net.ibizsys.pswf.core;

/**
 * 流程处理角色用户模型接口
 * @author lionlau
 *
 */
public interface IWFProcRoleUser  extends IWFUser
{
	/**
	 * 忽略替补用户
	 */
	public final static String FIELD_IGNORESUBSTITUTE = "IGNORESUBSTITUTE";
	
	/**
	 * 替代的流程用户标识
	 */
	public final static String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
	
	
	/**
	 * 获取标识
	 * @return
	 */
	String getId();
	
	
	/**
	 * 获取名称
	 * @return
	 */
	String getName();
	
	/**
	 * 获取过程角色模型
	 * @return
	 */
	IWFProcRoleModel getWFProcRoleModel();
	
	
	/**
	 * 获取流程角色标识
	 * @return
	 */
	String getWFRoleId();
	
	
	
	/**
	 * 是否忽略计算候选人
	 * @return
	 */
	boolean isIgnoreSubstitute();
	
	
	
	
	/**
	 * 获取原来的流程用户标识
	 * @return
	 */
	String getOriginalWFUserId();
	
}
