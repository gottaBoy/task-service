package net.ibizsys.pswf.core;

/**
 * 角色用户模型接口
 * @author lionlau
 *
 */
public interface IWFRoleUser extends IWFUser
{
	/**
	 * 获取角色模型对象
	 * @return
	 */
	IWFRoleModel getWFRoleModel();
	
}
