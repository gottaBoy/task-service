package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;

/**
 * 流程用户对象接口
 * @author lionlau
 *
 */
public interface IWFUser extends IEntity
{
	/**
	 * 获取用户标识
	 * @return
	 */
	String getWFUserId();
	
	
	/**
	 * 获取用户名称
	 * @return
	 */
	String getWFUserName();
}
