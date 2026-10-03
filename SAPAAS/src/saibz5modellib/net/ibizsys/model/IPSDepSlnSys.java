package net.ibizsys.model;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 部署方案系统对象接口
 * @author lionlau
 *
 */
public interface IPSDepSlnSys extends IPSModelObject
{
	/**
	 * 获取系统标识
	 * @return
	 */
	String getPSSystemId();
	
	
	/**
	 * 获取系统对象
	 * @return
	 */
	IPSSystem getPSSystem()throws Exception;
	
	
	/**
	 * 获取系统对象
	 * @return
	 */
	IPSSystem getPSSystem(boolean bCache)throws Exception;
	
	
	
	/**
	 * 获取系统模型实例标识
	 * @return
	 */
	String getPSSysModelInstId();
	
	
	
	
	
	/**
	 * 获取模型实例版本
	 * @return
	 */
	int getModelInstVer();


	
	
	/**
	 * 获取最后的活动时间
	 * @return
	 */
	long getLastActiveTime();
	
	
	
	/**
	 * 激活
	 */
	void active();
	
	
	/**
	 * 获取开发系统的过期时间
	 * @return
	 */
	java.sql.Timestamp getExpiredTime();
	
	
	
	/**
	 * 判断系统是否过期
	 * @return
	 */
	boolean isExpired();



}
